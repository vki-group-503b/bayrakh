package ru.nsu.hci.bayrakh.javalabs.lab5;

public class FormatString {
    private String input;
    private int pos;
    private StringBuilder resultBuilder;
    private Object[] args;
    private char symbol;

    FormatString(String input, Object... args) throws Exception {
        this.input = input;
        resultBuilder = new StringBuilder();
        this.args = args;
        for (pos = -1; hasNextChar(); ) {
            parseSymbol();
        }
    }

    private boolean hasNextChar() {
        return pos < (this.input.length() - 1);
    }

    private char readNextChar() throws Exception {
        if (!hasNextChar())
            throw new Exception("Нельзя прочитать следующий символ (его нет)");
        pos++;
        symbol = input.charAt(pos);
        return symbol;
    }

    private void parseSymbol() throws Exception {
        if (readNextChar() == '$') {
            int n = parseFormatArg();
            if (n >= 0) {
                if (n >= args.length) {
                    String msg = String.format(
                            "Передано недостаточно агрументов форматирования! (Ожидается арг. #%d, получено %d)",
                            n, args.length
                    );
                    throw new Exception(msg);
                }
                resultBuilder.append(String.valueOf(args[n]));
            } else {
                resultBuilder.append('$');
            }
        } else {
            resultBuilder.append(symbol);
        }
    }

    private int parseFormatArg() throws Exception {
        int posWas = pos;
        while (true) {
            if (readNextChar() != '{') {
                break;
            }
            int result = parseUnsignedNumber();
            if ((result < 0) || (symbol != '}')) {
                break;
            }
            return result;
        }
        pos = posWas;
        return -1;
    }

    private int parseUnsignedNumber() throws Exception {
        int result = 0;
        if (!hasNextChar() || !Character.isDigit(readNextChar()))
            return -1;
        while (Character.isDigit(symbol)) {
            result *= 10;
            result += Character.getNumericValue(symbol);
            if (hasNextChar()) {
                readNextChar();
            } else {
                break;
            }
        }
        return result;
    }

    public String toString() {
        return resultBuilder.toString();
    }

    public static String format(String input, Object... args) throws Exception {
        FormatString f = new FormatString(input, args);
        return f.toString();
    }
}
