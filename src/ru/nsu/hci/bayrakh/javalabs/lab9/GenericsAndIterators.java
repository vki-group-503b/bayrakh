package ru.nsu.hci.bayrakh.javalabs.lab9;

public class GenericsAndIterators {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(2);
        list.pushFront(5);
        list.pushBack(4);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
