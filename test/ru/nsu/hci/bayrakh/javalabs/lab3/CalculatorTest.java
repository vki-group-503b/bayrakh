package ru.nsu.hci.bayrakh.javalabs.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    final private static char[] symbols = new char[]{
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            '+',
            '-',
            '*',
            '/',
            '(',
            ')',
            ' ',
            '\n',
            '\t',
            '\r',
    };

    private static char[] getSymbols(char[] exclude) {
        char[] res = new char[symbols.length];
        int i = 0;
        loop:
        for (char c : symbols) {
            for (char x : exclude) {
                if (c == x) {
                    continue loop;
                }
            }
            res[i] = c;
            i++;
        }
        char[] result = new char[i];
        System.arraycopy(res, 0, result, 0, i);
        return result;
    }

    private static char[] getSymbols(char exclude) {
        return getSymbols(new char[]{exclude});
    }

    private static char[] getSymbols() {
        return symbols.clone();
    }

    @Test
    void isDigit() {
        char[] digits = new char[]{
                '0',
                '1',
                '2',
                '3',
                '4',
                '5',
                '6',
                '7',
                '8',
                '9',
        };
        for (char d : digits) {
            assert Calculator.isDigit(d);
        }
        for (char c : getSymbols(digits)) {
            assert !Calculator.isDigit(c);
        }
    }

    @Test
    void getDigitValue() {
        assertEquals(Calculator.getDigitValue('0'), 0);
        assertEquals(Calculator.getDigitValue('1'), 1);
        assertEquals(Calculator.getDigitValue('2'), 2);
        assertEquals(Calculator.getDigitValue('3'), 3);
        assertEquals(Calculator.getDigitValue('4'), 4);
        assertEquals(Calculator.getDigitValue('5'), 5);
        assertEquals(Calculator.getDigitValue('6'), 6);
        assertEquals(Calculator.getDigitValue('7'), 7);
        assertEquals(Calculator.getDigitValue('8'), 8);
        assertEquals(Calculator.getDigitValue('9'), 9);
    }

    @Test
    void isPointDelimiter() {
        char[] points = new char[]{
                '.',
                '.',
        };
        for (char c : points) {
            assert Calculator.isPointDelimiter(c);
        }
        for (char c : getSymbols(points)) {
            assert !Calculator.isPointDelimiter(c);
        }
    }

    @Test
    void isOperation() {
        char[] ops = new char[]{
                '+',
                '-',
                '*',
                '/',
        };
        for (char c : ops) {
            assert Calculator.isOperation(c);
        }
        for (char c : getSymbols(ops)) {
            assert !Calculator.isOperation(c);
        }
    }

    @Test
    void isAddOperation() {
        assert Calculator.isAddOperation('+');
        for (char c : getSymbols('+')) {
            assert !Calculator.isAddOperation(c);
        }
    }

    @Test
    void isSubOperation() {
        assert Calculator.isSubOperation('-');
        for (char c : getSymbols('-')) {
            assert !Calculator.isSubOperation(c);
        }
    }

    @Test
    void isMulOperation() {
        assert Calculator.isMulOperation('*');
        for (char c : getSymbols('*')) {
            assert !Calculator.isMulOperation(c);
        }
    }

    @Test
    void isDivOperation() {
        assert Calculator.isDivOperation('/');
        for (char c : getSymbols('/')) {
            assert !Calculator.isDivOperation(c);
        }
    }

    @Test
    void isOperationPriorOver() {
        assert Calculator.isOperationPriorOver('+', '*');
        assert Calculator.isOperationPriorOver('+', '/');
        assert Calculator.isOperationPriorOver('-', '*');
        assert Calculator.isOperationPriorOver('-', '/');
        assert !Calculator.isOperationPriorOver('+', '+');
        assert !Calculator.isOperationPriorOver('+', '-');
        assert !Calculator.isOperationPriorOver('-', '+');
        assert !Calculator.isOperationPriorOver('-', '-');
        assert !Calculator.isOperationPriorOver('*', '+');
        assert !Calculator.isOperationPriorOver('*', '-');
        assert !Calculator.isOperationPriorOver('*', '*');
        assert !Calculator.isOperationPriorOver('*', '/');
        assert !Calculator.isOperationPriorOver('/', '+');
        assert !Calculator.isOperationPriorOver('/', '-');
        assert !Calculator.isOperationPriorOver('/', '*');
        assert !Calculator.isOperationPriorOver('/', '/');
    }

    @Test
    void isOpeningBracket() {
        assert Calculator.isOpeningBracket('(');
        for (char c : getSymbols('(')) {
            assert !Calculator.isOpeningBracket(c);
        }
    }

    @Test
    void isClosingBracket() {
        assert Calculator.isClosingBracket(')');
        for (char c : getSymbols(')')) {
            assert !Calculator.isClosingBracket(c);
        }
    }

    @Test
    void isWhitespace() {
        char[] spaces = new char[]{
                ' ',
                '\n',
                '\t',
                '\r',
        };
        for (char c : spaces) {
            assert Calculator.isWhitespace(c);
        }
        for (char c : getSymbols(spaces)) {
            assert !Calculator.isWhitespace(c);
        }
    }

    @Test
    void useCaseTest() throws Exception {
        Calculator calc = new Calculator("2 + 2 * 3 / (4 - 2 )");
        assertEquals(calc.getResult(), 5);
        assertEquals(calc.getResultExpr(), "2 2 3 4 2 - / * + ");
    }

}