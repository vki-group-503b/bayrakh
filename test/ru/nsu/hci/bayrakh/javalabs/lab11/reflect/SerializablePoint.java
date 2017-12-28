package ru.nsu.hci.bayrakh.javalabs.lab11.reflect;

import ru.nsu.hci.bayrakh.javalabs.lab11.data.JSONArray;
import ru.nsu.hci.bayrakh.javalabs.lab11.data.JSONNumber;
import ru.nsu.hci.bayrakh.javalabs.lab11.data.JSONSerializable;
import ru.nsu.hci.bayrakh.javalabs.lab11.data.JSONValue;

public class SerializablePoint extends Point implements JSONSerializable {
    public SerializablePoint(double x, double y) {
        super(x, y);
    }

    public SerializablePoint(JSONValue value) {
        if (!(value instanceof JSONArray)) {
            throw new IllegalArgumentException();
        }
        JSONValue xValue = ((JSONArray) value).get(0);
        JSONValue yValue = ((JSONArray) value).get(1);
        if ((xValue == null) || (!(xValue instanceof JSONNumber))
                || (yValue == null) || (!(yValue instanceof JSONNumber))) {
            throw new IllegalArgumentException();
        }
        coordinateX = ((JSONNumber) xValue).getValue();
        coordinateY = ((JSONNumber) yValue).getValue();
    }

    @Override
    public String toJSON() {
        return Serialize.serialize(new double[]{coordinateX, coordinateY});
    }
}
