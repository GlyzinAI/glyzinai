package ru.job4j.statistics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Class AnalyzeTest - test for сollection statistics.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 25.03.2019.
 */

public class AnalyzeTest {

    private Analyze analyze = new Analyze();
    private List<Analyze.User> previous;
    private List<Analyze.User> current;

    @Before
    public void before() {
        previous = List.of(
                new Analyze.User(1, "Mike"),
                new Analyze.User(2, "Max"),
                new Analyze.User(3, "Den")
        );
        current = new ArrayList<>(previous);
    }

    @Test
    public void checkForNoChanges() {
        Analyze.Info result = analyze.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(0));
    }

    @Test
    public void whenAddTwoElementsCheckChangesTwo() {
        current.add(new Analyze.User(4, "Alex"));
        current.add(new Analyze.User(5, "Ben"));
        Analyze.Info result = analyze.diff(previous, current);
        assertThat(result.added, is(2));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(0));
    }

    @Test
    public void whenChangesFirstUserCheckChanged() {
        current.remove(0);
        current.add(new Analyze.User(1, "Filip"));
        Analyze.Info result = analyze.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(1));
        assertThat(result.deleted, is(0));
    }

    @Test
    public void whenRemoveTwoElementsCheckChanges() {
        current.remove(0);
        current.remove(0);
        Analyze.Info result = analyze.diff(previous, current);
        assertThat(result.added, is(0));
        assertThat(result.changed, is(0));
        assertThat(result.deleted, is(2));
    }
}