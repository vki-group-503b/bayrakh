package ru.nsu.hci.bayrakh.javalabs.lab11.data;

import ru.nsu.hci.bayrakh.javalabs.lab11.parse.JSONScanner;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.TokenKind;
import ru.nsu.hci.bayrakh.javalabs.lab11.parse.UnexpectedInputException;

import java.util.Locale;

public class JSONNumber extends JSONValue {
    public JSONNumber(Double value) {
        super(value);
    }

    @Override
    public Double getValue() {
        return (Double) super.getValue();
    }

    @Override
    public String toJSON() {
        double value = getValue();
        double log = Math.floor(Math.log10(Math.abs(value)));
        String exp = "";
        if ((log > 5) || (log < -5)) {
            double pow = Math.pow(10, -log);
            value *= pow;
            exp = String.format(Locale.ROOT, "e%d", Double.valueOf(log).intValue());
        }
        String val = String.format(Locale.ROOT, "%.10f", value);
        if (val.indexOf('.') >= 0) {
            int valLength = val.length();
            char c = val.charAt(valLength - 1);
            while ((c == '0')) {
                valLength--;
                c = val.charAt(valLength - 1);
            }
            if (c == '.') {
                valLength--;
            }
            val = val.substring(0, valLength);
        }
        return val + exp;
    }

    public static JSONNumber parse(JSONScanner scanner) throws UnexpectedInputException {
        return new JSONNumber(
                (Double) scanner.expectNext(TokenKind.NumberToken)
        );
    }
}
