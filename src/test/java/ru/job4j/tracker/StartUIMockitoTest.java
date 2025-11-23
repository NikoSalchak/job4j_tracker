package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUIMockitoTest {

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction replaceAction = new ReplaceAction(output);
        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askInt(ArgumentMatchers.any(String.class))).thenReturn(item.getId());
        Mockito.when(input.askStr(ArgumentMatchers.any(String.class))).thenReturn(replacedName);
        replaceAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "==== Change the item ===" + ln
                + "The item changed successfully." + ln
        );
    }

    @Test
    public void whenItemWasDeletedSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("deleted item"));
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askInt(ArgumentMatchers.any(String.class))).thenReturn(item.getId());
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "==== Delete the item ===" + ln
                        + "The item deleted successfully." + ln
        );
    }

    @Test
    public void whenItemWasAddedAndFoundSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("our item"));
        FindByIdAction findByIdAction = new FindByIdAction(output);
        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askInt(ArgumentMatchers.any(String.class))).thenReturn(item.getId());
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Show item by id ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenItemWasAddedAndFoundByNameSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("our item"));
        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = Mockito.mock(Input.class);
        Mockito.when(input.askStr(ArgumentMatchers.any(String.class))).thenReturn(item.getName());
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Show item by name ===" + ln
                        + item + ln
        );
    }
}
