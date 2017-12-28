package ru.nsu.hci.bayrakh.javalabs.lab11.data;

public class JSONCustom extends JSONValue {
    JSONCustom(JSONSerializable object) {
        super(object);
    }

    @Override
    public JSONSerializable getValue() {
        return (JSONSerializable) super.getValue();
    }

    @Override
    public String toJSON() {
        return getValue().toJSON();
    }
}
