package ru.job4j.collections.sort;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class DepartmentTest.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 04.12.2018.
 */

public class DepartmentTest {
    @Test
    public void whenCheckSortUpArray() {
        String[] dept = {"K1\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1\\SSK1", "K2", "K1\\SK2", "K1\\SK1\\SSK2"};
        Department department = new Department(dept);
        String[] result = department.departmentSortUp();
        String[] expect = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        assertThat(result, is(expect));
    }

    @Test
    public void whenCheckSortDownArray() {
        String[] dept = {"K1\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K1\\SK1\\SSK1", "K2", "K1\\SK2", "K1\\SK1\\SSK2"};
        Department department = new Department(dept);
        String[] result = department.departmentSortDown();
        String[] expect = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        assertThat(result, is(expect));
    }
}
