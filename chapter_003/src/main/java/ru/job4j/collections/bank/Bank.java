package ru.job4j.collections.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Bank.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 14.11.2018.
 */

public class Bank {
    private Map<User, List<Account>> listAccounts = new HashMap<>();

    public Map<User, List<Account>> getListAccounts() {
        return listAccounts;
    }

    public void addUser(User user) {
        listAccounts.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        listAccounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (User user : listAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                listAccounts.get(user).add(account);
                break;
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : listAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                listAccounts.get(user).remove(account);
                break;
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> getList = new ArrayList<>();
        for (User user : listAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                getList.addAll(listAccounts.get(user));
            }
        }
        return getList;
    }

    public Account getAccount(String passport, String requisite) {
        Account account = new Account(0.0, "000");
        List<Account> list = getUserAccounts(passport);

        for (Account acc : list) {
            if (acc.getRequisites().equals(requisite)) {
                account = acc;
            }
        }

        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        Account srcAccount = getAccount(srcPassport, srcRequisite);
        Account destAccount = getAccount(destPassport, destRequisite);
        return srcAccount.transfer(destAccount, amount);
    }
}
