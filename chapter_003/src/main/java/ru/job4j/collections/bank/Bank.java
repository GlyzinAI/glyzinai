package ru.job4j.collections.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Bank.
 *
 * @author Artur Glyzin.
 * @version 1.0.
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

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        int indexSrc = -1;
        int indexDest = -1;
        boolean result = true;
        if (srcPassport.equals(destPassport)) {
            List<Account> list = getUserAccounts(srcPassport);
            for (Account account : list) {
                if (account.getRequisites().equals(srcRequisite)) {
                    indexSrc = list.indexOf(account);
                }
                if (account.getRequisites().equals(destRequisite)) {
                    indexDest = list.indexOf(account);
                }
            }

            if (indexSrc != -1 && indexDest != -1) {

                Account srcAccount = list.get(indexSrc);
                Account destAccount = list.get(indexDest);
                return srcAccount.transfer(destAccount, amount);
            } else {
                result = false;
            }
        } else {
            List<Account> listSrc = getUserAccounts(srcPassport);
            List<Account> listDest = getUserAccounts(destPassport);

            for (Account account : listSrc) {
                if (account.getRequisites().equals(srcRequisite)) {
                    indexSrc = listSrc.indexOf(account);
                }
            }

            for (Account account : listDest) {
                if (account.getRequisites().equals(destRequisite)) {
                    indexDest = listDest.indexOf(account);
                }
            }

            if (indexSrc != -1 && indexDest != -1) {

                Account srcAccount = listSrc.get(indexSrc);
                Account destAccount = listDest.get(indexDest);
                result = srcAccount.transfer(destAccount, amount);
            } else {
                result = false;
            }
        }
        return result;
    }
}
