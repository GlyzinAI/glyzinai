package ru.job4j.collections.bank;

import java.util.*;

/**
 * Class Bank.
 *
 * @author Artur Glyzin.
 * @version 4.0.
 * @since 11.12.2018.
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
        User user = this.positionById(passport);
        listAccounts.get(user).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = this.positionById(passport);
        listAccounts.get(user).remove(account);
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

    public Optional<Account> getAccount(String passport, String requisite) {
        List<Account> list = getUserAccounts(passport);

        for (Account acc : list) {
            if (acc.getRequisites().equals(requisite)) {
                return Optional.of(acc);
            }
        }

        return Optional.empty();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean res = false;
        Optional<Account> srcAccount = getAccount(srcPassport, srcRequisite);
        Optional<Account> destAccount = getAccount(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            res = srcAccount.get().transfer(destAccount.get(), amount);
        }
        return res;
    }

    private User positionById(String passport) {
        return listAccounts.keySet().stream()
                .filter(i -> i.getPassport().equals(passport))
                .findFirst().orElse(null);
    }
}
