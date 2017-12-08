package ru.nsu.hci.bayrakh.javalabs.lab8;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;

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

    @Test public void locker_stores_number() {
        Locker locker = new Locker(42);
    }

    @Test public void getValue_returns_locker_value() {
        Locker locker = new Locker(42);
        assertEquals(42, locker.getValue());
    }

    @Test void setValue_sets_locker_value() throws LockerLockedException {
        Locker locker = new Locker(0);
        locker.setValue(42.0);
        assertEquals(42.0, locker.getValue());
    }

    @Test void locked_locker_fails_when_trying_to_set_value() {
        Locker locker = new Locker(42);
        locker.lock();
        assertThrows(LockerLockedException.class, () -> locker.setValue(58));
    }

    @Test void setValue_does_not_fail_when_locker_is_unlocked() throws LockerLockedException {
        Locker locker = new Locker(42);
        locker.lock();
        locker.unlock();

        locker.setValue(24);
    }

    @Test void getValue_works_when_locker_is_locked() {
        Locker locker = new Locker(24);
        locker.lock();
        assertEquals(24, locker.getValue());
    }

}