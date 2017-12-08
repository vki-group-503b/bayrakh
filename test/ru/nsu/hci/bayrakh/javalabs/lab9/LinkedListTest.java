package ru.nsu.hci.bayrakh.javalabs.lab9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    LinkedList<Integer> make_list() {
        return new LinkedList<>();
    }

    @Test
    LinkedList<Integer> make_list_one_to_ten() {
        LinkedList<Integer> list = make_list();
        for (int i = 1; i <= 10; i++) {
            list.pushBack(i);
        }
        return list;
    }

    @Test
    LinkedList<Integer> make_list_ten_to_one() {
        LinkedList<Integer> list = make_list();
        for (int i = 1; i <= 10; i++) {
            list.pushFront(i);
        }
        return list;
    }

    @Test
    void iterator_iterates_forward() {
        LinkedList<Integer> list = make_list_one_to_ten();
        int value = 1;

        for (int val : list)
            assertEquals(value++, val);

        assertEquals(11, value);
    }

    @Test
    void iterator_iterates_backward() {
        LinkedList<Integer> list = make_list_one_to_ten();
        int value = 10;

//        Iterable<Integer> reversed = new Iterable<Integer>() {
//            @Override
//            public Iterator<Integer> iterator() {
//                return list.reverse_iterator();
//            }
//        };
//        Iterable<Integer> reversed = () -> list.reverse_iterator();
        Iterable<Integer> reversed = list::reverse_iterator;

        for (int val : reversed)
            assertEquals(value--, val);

        assertEquals(0, value);
    }

    @Test
    void can_remove_item_from_front() {
        LinkedList<Integer> list = make_list_one_to_ten();
        int value = 1;
        assertEquals(value, list.popFront().intValue());
        for (int element : list) {
            assertEquals(++value, element);
        }
        assertEquals(10, value);
    }

    @Test
    void can_remove_item_from_back() {
        LinkedList<Integer> list = make_list_one_to_ten();
        assertEquals(10, list.popBack().intValue());
        int value = 0;
        for (int element : list) {
            assertEquals(++value, element);
        }
        assertEquals(9, value);
    }

}
