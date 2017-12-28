package ru.nsu.hci.bayrakh.javalabs.lab11.parse;

public class JSONScanner {
    private int position;
    private String input;

    public JSONScanner(String input, int position) {
        this.input = input;
        this.position = position;
    }

    public JSONScanner(String input) {
        this(input, -1);
    }

    private boolean hasNextSymbol() {
        return (position + 1) < input.length();
    }

    private char nextRawSymbol() throws UnexpectedEndOfInputException {
        if (!hasNextSymbol()) {
            throw new UnexpectedEndOfInputException(input, position);
        }
        position++;
        return input.charAt(position);
    }

    private char nextSymbol() throws UnexpectedEndOfInputException {
        char symbol;
        do {
            symbol = nextRawSymbol();
        } while (Character.isWhitespace(symbol));
        return symbol;
    }

    private char currentSymbol() throws UnexpectedEndOfInputException {
        if (position >= input.length()) {
            throw new UnexpectedEndOfInputException(input, position);
        }
        return input.charAt(position);
    }

    public Token next() throws UnexpectedInputException {
        if (!hasNextSymbol()) {
            return new Token(TokenKind.EndOfInput);
        }
        char symbol = Character.toLowerCase(nextSymbol());
        if (symbol == '"') {
            return new Token(TokenKind.StringToken, parseString());
        }
        if (Character.isDigit(symbol) || (symbol == '-')) {
            return new Token(TokenKind.NumberToken, parseNumber());
        }
        if (symbol == 't') {
            parseWord("true");
            return new Token(TokenKind.BooleanToken, true);
        }
        if (symbol == 'f') {
            parseWord("false");
            return new Token(TokenKind.BooleanToken, false);
        }
        if (symbol == 'n') {
            parseWord("null");
            return new Token(TokenKind.NullToken);
        }
        if (symbol == '{') {
            return new Token(TokenKind.ObjectBeginToken);
        }
        if (symbol == '}') {
            return new Token(TokenKind.ObjectEndToken);
        }
        if (symbol == ':') {
            return new Token(TokenKind.ObjectPairDelimiterToken);
        }
        if (symbol == ',') {
            return new Token(TokenKind.ListDelimiterToken);
        }
        if (symbol == '[') {
            return new Token(TokenKind.ArrayBeginToken);
        }
        if (symbol == ']') {
            return new Token(TokenKind.ArrayEndToken);
        }
        throw new UnexpectedInputException(input, position);
    }

    private String parseString() throws UnexpectedEndOfInputException {
        StringBuilder builder = new StringBuilder();
        while (true) {
            char symbol = nextRawSymbol();
            if (symbol == '"') {
                return builder.toString();
            }
            if (symbol == '\\') {
                char[] symbols_t = parseEscapedChar();
                if (symbols_t == null) {
                    builder.append('\\');
                    continue;
                }
                for (char symbol_t : symbols_t) {
                    builder.append(symbol_t);
                }
                continue;
            }
            builder.append(symbol);
        }
    }

    private char[] parseEscapedChar() throws UnexpectedEndOfInputException {
        char symbol = nextSymbol();
        if (symbol == '"') {
            return new char[]{'"'};
        }
        if (symbol == '\\') {
            return new char[]{'\\'};
        }
        if (symbol == '/') {
            return new char[]{'/'};
        }
        if (symbol == 'b') {
            return new char[]{'\b'};
        }
        if (symbol == 'f') {
            return new char[]{'\f'};
        }
        if (symbol == 'n') {
            return new char[]{'\n'};
        }
        if (symbol == 'r') {
            return new char[]{'\r'};
        }
        if (symbol == 't') {
            return new char[]{'\t'};
        }
        if (symbol == 'u') {
            return parseUnicodeChar();
        }
        return null;
    }

    private char[] parseUnicodeChar() throws UnexpectedEndOfInputException {
        char a = nextSymbol();
        char b = nextSymbol();
        char c = nextSymbol();
        char d = nextSymbol();
        String code = new String(new char[]{a, b, c, d});
        int codePoint = Integer.parseInt(code, 16);
        return Character.toChars(codePoint);
    }

    private Double parseNumber() throws UnexpectedEndOfInputException {
        boolean isNegative = false;
        if (currentSymbol() == '-') {
            isNegative = true;
            nextSymbol();
        }
        double result = parseIntPart();
        if (currentSymbol() == '.') {
            nextSymbol();
            result += parseFactPart();
        }
        if ((currentSymbol() == 'e') || (currentSymbol() == 'E')) {
            boolean powerIsNegative = false;
            char symbol = nextSymbol();
            if (symbol == '-') {
                powerIsNegative = true;
                nextSymbol();
            }
            double power = parseIntPart();
            if (powerIsNegative) {
                power *= -1;
            }
            result *= Math.pow(10, power);
        }
        if (isNegative) {
            result *= -1;
        }
        position--;
        return result;
    }

    private double parseIntPart() throws UnexpectedEndOfInputException {
        double result = 0;
        for (char c : excludeDigits()) {
            result = result * 10 + Character.getNumericValue(c);
        }
        return result;
    }

    private double parseFactPart() throws UnexpectedEndOfInputException {
        double result = 0;
        double coefficient = 1;
        for (char c : excludeDigits()) {
            coefficient /= 10;
            result += coefficient * Character.getNumericValue(c);
        }
        return result;
    }

    private char[] excludeDigits() throws UnexpectedEndOfInputException {
        char symbol = currentSymbol();
        StringBuilder builder = new StringBuilder();
        while (Character.isDigit(symbol)) {
            builder.append(symbol);
            if (!hasNextSymbol()) {
                break;
            }
            symbol = nextSymbol();
        }
        return builder.toString().toCharArray();
    }

    private void parseWord(String word) throws UnexpectedInputException {
        expect(
                Character.toLowerCase(currentSymbol()),
                Character.toLowerCase(word.charAt(0))
        );
        for (int i = 1; i < word.length(); i++) {
            expect(
                    Character.toLowerCase(nextSymbol()),
                    Character.toLowerCase(word.charAt(i))
            );
        }
    }

    private void expect(char l, char r) throws UnexpectedInputException {
        if (l != r) {
            throw new UnexpectedInputException(input, position);
        }
    }

    public UnexpectedTokenException makeUnexpectedTokenException(TokenKind kind) {
        return new UnexpectedTokenException(kind, input, position);
    }

    public Object expect(Token token, TokenKind kind) throws UnexpectedTokenException {
        TokenKind tokenKind = token.getKind();
        if (!tokenKind.equals(kind)) {
            throw makeUnexpectedTokenException(tokenKind);
        }
        return token.getValue();
    }

    public Object expectNext(TokenKind kind) throws UnexpectedInputException {
        return expect(next(), kind);
    }

    public JSONScanner copy() {
        return new JSONScanner(input, position);
    }

    public void apply(JSONScanner scanner) {
        input = scanner.input;
        position = scanner.position;
    }

    public <T> T tryParse(JSONParser<T> parser) {
        final JSONScanner scannerCopy = copy();
        try {
            final T result = parser.parse(scannerCopy);
            apply(scannerCopy);
            return result;
        } catch (UnexpectedInputException e) {
            return null;
        }
    }
}
