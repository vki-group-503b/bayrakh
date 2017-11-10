package ru.nsu.hci.bayrakh.javalabs.lab8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LockerTest {
    @Test
    void useCaseTest() throws LockerLockedException, Exception {
        Locker l = new Locker(1);
        assertEquals(l.getValue(), 1);
        l.setValue(2);
        assertEquals(l.getValue(), 2);
        l.lock();
        try {
            l.setValue(3);
            throw new Exception("Заблокированный Locker не бросил исключение");
        } catch (LockerLockedException e) {}
        assertEquals(l.getValue(), 2);
        l.unlock();
        l.setValue(3);
        assertEquals(l.getValue(), 3);
    }
}