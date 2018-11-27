package ru.job4j.collections.sort;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class DepartmentTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.11.2018.
 */

public class DepartmentTest {
    @Test
    public void whenCheckSortUpArray() {
        String[] dept = new String[7];
        dept[0] = "K1\\SK1";
        dept[1] = "K2\\SK1\\SSK1";
        dept[2] = "K2\\SK1\\SSK2";
        dept[3] = "K1\\SK1\\SSK1";
        dept[4] = "K2";
        dept[5] = "K1\\SK2";
        dept[6] = "K1\\SK1\\SSK2";

        Department department = new Department(dept);
        String[] result = department.departmentSortUp();
        String[] expect = new String[9];
        expect[0] = "K1";
        expect[1] = "K1\\SK1";
        expect[2] = "K1\\SK1\\SSK1";
        expect[3] = "K1\\SK1\\SSK2";
        expect[4] = "K1\\SK2";
        expect[5] = "K2";
        expect[6] = "K2\\SK1";
        expect[7] = "K2\\SK1\\SSK1";
        expect[8] = "K2\\SK1\\SSK2";
        assertThat(result, is(expect));
    }

    @Test
    public void whenCheckSortDownArray() {
        String[] dept = new String[7];
        dept[0] = "K1\\SK1";
        dept[1] = "K2\\SK1\\SSK1";
        dept[2] = "K2\\SK1\\SSK2";
        dept[3] = "K1\\SK1\\SSK1";
        dept[4] = "K2";
        dept[5] = "K1\\SK2";
        dept[6] = "K1\\SK1\\SSK2";

        Department department = new Department(dept);
        String[] result = department.departmentSortDown();
        String[] expect = new String[9];
        expect[0] = "K2";
        expect[1] = "K2\\SK1";
        expect[2] = "K2\\SK1\\SSK2";
        expect[3] = "K2\\SK1\\SSK1";
        expect[4] = "K1";
        expect[5] = "K1\\SK2";
        expect[6] = "K1\\SK1";
        expect[7] = "K1\\SK1\\SSK2";
        expect[8] = "K1\\SK1\\SSK1";
        assertThat(result, is(expect));
    }
}
