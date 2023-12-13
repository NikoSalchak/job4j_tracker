package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы
 * в системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 *
 * @author Niko Salchak
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в коллекции HashMap. Ключом выступает User
     * <List> Account является набором счетов пользователя связанный с конкретным пользователем (User).
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход User и записывает его в коллекцию HashMap,
     * если такой пользователь отсутствует.
     *
     * @param user это пользователь, который выступает ключом в HashMap
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * метод принимает паспорт пользователя и удаляет его из коллекции.
     *
     * @param passport номер паспорта пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * метод вызывает метод findByPassport и находит по паспорту пользователя
     * затем добавляет ему новый счет
     *
     * @param passport номер паспорта пользователя
     * @param account  счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * метод находит пользователя по номеру паспорта путем прохода
     * по коллекции users HashMap и возвращает пользователя
     *
     * @param passport номер паспорта пользователя
     * @return пользователь, используется другими методами для добавления нового счета,
     * нахождение текущих счетов
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * метод находит счет пользователя по реквизитам и паспорту путем вызова
     * метода findByPassport и если пользователь не null  проходит по списку его счетов
     *
     * @param passportNumber  номер паспорта пользователя
     * @param requisite номер счета пользователя
     * @return счет пользователя
     */
    public Account findByRequisite(String passportNumber, String requisite) {
        var passport = findByPassport(passportNumber);
        if (passport == null) {
            return null;
        }
        return users.get(passport)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    /**
     * метод предназначен для перечисления денег с одного счета на другой счет
     * если счет не найден или не хватает денег на счете srcAccount метод возвращает false и перевод
     * не осуществляется
     *
     * @param srcPassport   номер паспорта пользователя со счета которого осуществляется списание денег
     * @param srcRequisite  реквизиты счета пользователя с которого будет списана сумма денег
     * @param destPassport  номер паспорта пользователя адресата получателя денег
     * @param destRequisite номер счета пользователя на который будет начислена сумма денег
     * @param amount        сумма денег которая будет списываться со счета и начисляться адресату по реквизитам адресата
     * @return возвращает Boolean true если перевод денег был осуществлен успешно,
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод должен вернуть false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * метод находит список счетов пользователя по входному параметру User который является
     * ключом в users HashMap
     *
     * @param user пользователь
     * @return возвращает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}

