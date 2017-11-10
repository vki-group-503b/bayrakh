package ru.nsu.hci.bayrakh.javalabs.lab8;

public class Locker {
    private double value;
    private boolean locked = false;

    Locker(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) throws LockerLockedException {
        if (this.locked)
            throw new LockerLockedException();
        this.value = value;
    }

    public void lock() {
        locked = true;
    }

    public void unlock() {
        locked = false;
    }
}
