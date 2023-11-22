package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> ascNamePriority = new JobAscByName();
        int rsl = ascNamePriority.compare(
                new Job("aBC", 0),
                new Job("bCD", 20)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> ascPriority = new JobAscByPriority();
        int rsl = ascPriority.compare(
                new Job("Wash the dishes", 1),
                new Job("Learn java", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> descName = new JobDescByName();
        int rsl = descName.compare(
                new Job("go to sleep", 1),
                new Job("learn java", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> ascNamePriority = new JobDescByPriority();
        int rsl = ascNamePriority.compare(
                new Job("go to sleep", 1),
                new Job("learn java", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByNameThenAscByPriority() {
        Comparator<Job> ascNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = ascNamePriority.compare(
                new Job("ABC", 0),
                new Job("ACD", 20)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriorityThenDescByName() {
        Comparator<Job> ascNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = ascNamePriority.compare(
                new Job("go to sleep", 1),
                new Job("learn java", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}