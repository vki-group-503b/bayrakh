package ru.nsu.hci.bayrakh.javalabs.lab14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockingQueueTest {
    @Test
    void simple_test() {
        final BlockingQueue<String> queue = new BlockingQueue<>();
        final BlockingQueue<String> log = new BlockingQueue<>();
        final String Hello = "Логгер запущен!";
        final String Message0 = "Привет, мир!";
        final String Message1 = "Это синхронизированный обмен строками";
        final String Message2 = "между разными потоками";
        final String Message3 = "да-да:)";
        Thread logger = new Thread(() -> {
            String message = Hello;
            while (message.length() > 0) {
                log.push(message);
                message = queue.pop();
            }
        }, "Logger");
        queue.push(Message0);
        queue.push(Message1);
        logger.start();
        queue.push(Message2);
        queue.push(Message3);
        queue.push(""); // Сигнал логгеру на завершение.
        assertEquals(Hello, log.pop());
        assertEquals(Message0, log.pop());
        assertEquals(Message1, log.pop());
        assertEquals(Message2, log.pop());
        assertEquals(Message3, log.pop());
        assertEquals(true, log.isEmpty());
    }
}