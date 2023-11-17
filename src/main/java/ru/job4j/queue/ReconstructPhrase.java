package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder();
        int size = evenElements.size();
        String rsl = "";
        for (int index = 0; index < size; index++) {
            if (index % 2 == 0) {
                str = str.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        rsl = str.toString();
        return rsl;
    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder();
        int size = descendingElements.size();
        String rsl = "";
        for (int index = 0; index < size; index++) {
            str = str.append(descendingElements.pollLast());
        }
        rsl = str.toString();
        return rsl;
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
