package ru.nsu.hci.bayrakh.javalabs.lab5;

public class Formatter {
    public static void main(String[] args) throws Exception {
        String yourName = "Igor", name = "jarvis", description = "AI from some movie";
        String formatted = FormatString.format("Hello, ${0}. My name is ${1}.\n I am ${1} - ${2}.",
                yourName, name, description);
        System.out.println(formatted);
    }
}
