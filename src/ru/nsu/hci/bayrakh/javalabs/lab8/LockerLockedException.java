package ru.nsu.hci.bayrakh.javalabs.lab8;

public class LockerLockedException extends Throwable {
    LockerLockedException() {
        super("Попытка изменить заблокированный ящик");
    }
}
