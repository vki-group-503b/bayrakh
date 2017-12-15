package ru.nsu.hci.bayrakh.javalabs.lab13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListTest {
    List<Integer> make_list_one_to_ten() {
        final List<Integer> result = new List<>();
        for (int i = 1; i <= 10; i++) {
            result.pushBack(i);
        }
        return result;
    }

    @Test
    void filter() {
        final List<Integer> list = make_list_one_to_ten().filter(e -> (e % 2) == 0);
        int i = 0;
        for (int e : list) {
            i += 2;
            assertEquals(e, i);
        }
        assertEquals(i, 10);
    }

    @Test
    void map() {
        final List<Integer> list = make_list_one_to_ten().map(e -> e * 2);
        int i = 0;
        for (int e : list) {
            i += 2;
            assertEquals(e, i);
        }
        assertEquals(i, 20);
    }

    @Test
    void fold() {
        final int sum = make_list_one_to_ten()
                .fold((element, fold) -> element + fold, 0);
        assertEquals(sum, 55);
    }

    @Test
    void count() {
        final int count = make_list_one_to_ten().count(e -> (5 < e) && (e < 8));
        assertEquals(count, 2);
    }

    @Test
    void first_not_null() {
        final int element = make_list_one_to_ten().first(e -> e % 5 == 0);
        assertEquals(element, 5);
    }


    @Test
    void first_null() {
        final Integer element = make_list_one_to_ten().first(e -> e % 11 == 0);
        assertEquals(element, null);
    }

    @Test
    void last_not_null() {
        final int element = make_list_one_to_ten().last(e -> e % 3 == 0);
        assertEquals(element, 9);
    }

    @Test
    void last_null() {
        final Integer element = make_list_one_to_ten().last(e -> e % 11 == 0);
        assertEquals(element, null);
    }

    @Test
    void single_when_element_is_single() {
        final int element = make_list_one_to_ten().single(e -> e % 7 == 0);
        assertEquals(element, 7);
    }

    @Test
    void single_when_many_elements() {
        final Integer element = make_list_one_to_ten().single(e -> e % 2 == 0);
        assertEquals(element, null);
    }

    @Test
    void single_when_zero_elements() {
        final Integer element = make_list_one_to_ten().single(e -> e % 11 == 0);
        assertEquals(element, null);
    }

    @Test
    void all_when_all_elements_ok() {
        assert make_list_one_to_ten().all(e -> e < 100);
    }

    @Test
    void all_when_not_all_elements_ok() {
        assert !make_list_one_to_ten().all(e -> e < 8);
    }
}