package org.BankApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Service {

    public void createAccount(Account acc) throws BankException {

        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        if (session.get(Account.class, acc.getAccNo()) != null) {
            throw new BankException("Account already exists!");
        }

        session.save(acc);
        tx.commit();
        session.close();

        System.out.println("Account created successfully");
    }

    public void deposit(int accNo, double amount) throws BankException {

        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Account acc = session.get(Account.class, accNo);

        if (acc == null)
            throw new BankException("Account not found!");

        acc.setBalance(acc.getBalance() + amount);

        tx.commit();
        session.close();

        System.out.println("Deposit successful");
    }

    public void withdraw(int accNo, double amount) throws BankException {

        Session session = HibernateUtil.getFactory().openSession();
        Transaction tx = session.beginTransaction();

        Account acc = session.get(Account.class, accNo);

        if (acc == null)
            throw new BankException("Account not found!");

        if (acc.getBalance() - amount < acc.getMinBalance())
            throw new BankException("Minimum balance rule violated!");

        acc.setBalance(acc.getBalance() - amount);

        tx.commit();
        session.close();

        System.out.println("Withdrawal successful");
    }

    public void showBalance(int accNo) throws BankException {

        Session session = HibernateUtil.getFactory().openSession();
        Account acc = session.get(Account.class, accNo);

        if (acc == null)
            throw new BankException("Account not found!");

        System.out.println("Balance: " + acc.getBalance());
        session.close();
    }
}
