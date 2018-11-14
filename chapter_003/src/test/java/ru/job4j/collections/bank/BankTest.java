package ru.job4j.collections.bank;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class BankTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 14.11.2018.
 */

public class BankTest {
    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User user = new User("Artur", "11041993");
        bank.addUser(user);
        Map<User, List<Account>> listMap = bank.getListAccounts();
        assertThat(listMap.containsKey(user), is(true));
    }

    @Test
    public void whenRemoveUser() {
        Bank bank = new Bank();
        User user1 = new User("Artur", "11041993");
        User user2 = new User("Anton", "15061994");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.deleteUser(user2);
        Map<User, List<Account>> listMap = bank.getListAccounts();
        assertThat(listMap.containsKey(user2), is(false));
        assertThat(listMap.containsKey(user1), is(true));
    }

    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        User user = new User("Artur", "11041993");
        bank.addUser(user);
        Account account = new Account(2500.0, "0001");
        bank.addAccountToUser("11041993", account);
        List<Account> list = bank.getListAccounts().get(user);
        assertThat(list.get(0).getRequisites(), is("0001"));
    }

    @Test
    public void whenRemoveAccountToUser() {
        Bank bank = new Bank();
        User user = new User("Artur", "11041993");
        bank.addUser(user);
        Account account1 = new Account(2500.0, "0001");
        Account account2 = new Account(11750.0, "0002");
        bank.addAccountToUser("11041993", account1);
        bank.addAccountToUser("11041993", account2);
        bank.deleteAccountFromUser("11041993", account1);
        List<Account> list = bank.getListAccounts().get(user);
        assertThat(list.get(0).getRequisites(), is("0002"));
    }

    @Test
    public void whenGetListAccount() {
        Bank bank = new Bank();
        User user = new User("Artur", "11041993");
        Account account1 = new Account(2500.0, "0001");
        Account account2 = new Account(11750.0, "0002");
        Account account3 = new Account(1700.0, "0003");
        Account account4 = new Account(1300.0, "0004");
        bank.addUser(user);
        bank.addAccountToUser("11041993", account1);
        bank.addAccountToUser("11041993", account2);
        bank.addAccountToUser("11041993", account3);
        bank.addAccountToUser("11041993", account4);

        List<Account> result = bank.getUserAccounts("11041993");
        List<Account> expect = Arrays.asList(account1, account2, account3, account4);
        assertThat(result, is(expect));
    }

    @Test
    public void whenTransferBetweenAccountsUser() {
        Bank bank = new Bank();
        User user = new User("Artur", "11041993");
        Account account1 = new Account(2500.0, "0001");
        Account account2 = new Account(11750.0, "0002");
        Account account3 = new Account(1700.0, "0003");
        Account account4 = new Account(1300.0, "0004");
        bank.addUser(user);
        bank.addAccountToUser("11041993", account1);
        bank.addAccountToUser("11041993", account2);
        bank.addAccountToUser("11041993", account3);
        bank.addAccountToUser("11041993", account4);
        boolean res = bank.transferMoney("11041993", "0002", "11041993", "0003", 2000);
        assertThat(res, is(true));
        assertThat(account2.getValues(), is(9750.0));
        assertThat(account3.getValues(), is(3700.0));
    }

    @Test
    public void whenTransferBetweenUsers() {
        Bank bank = new Bank();
        User user1 = new User("Artur", "11041993");
        User user2 = new User("Anton", "15081994");
        Account account11 = new Account(2500.0, "00011");
        Account account12 = new Account(11750.0, "00012");
        Account account21 = new Account(1700.0, "00021");
        Account account22 = new Account(1300.0, "00022");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("11041993", account11);
        bank.addAccountToUser("11041993", account12);
        bank.addAccountToUser("15081994", account21);
        bank.addAccountToUser("15081994", account22);
        boolean res = bank.transferMoney("11041993", "00011", "15081994", "00022", 500);
        assertThat(res, is(true));
        assertThat(account11.getValues(), is(2000.0));
        assertThat(account22.getValues(), is(1800.0));
    }

}
