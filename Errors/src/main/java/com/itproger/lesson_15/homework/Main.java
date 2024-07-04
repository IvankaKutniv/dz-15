package com.itproger.lesson_15.homework;

import com.itproger.lesson_15.homework.exceptions.WrongAccountException;
import com.itproger.lesson_15.homework.exceptions.WrongCurrencyException;
import com.itproger.lesson_15.homework.exceptions.WrongOperationException;

public class Main {
    private static BankApplication bankApplication = new BankApplication();

    public static void main(String[] args) {
        processWrapper("accountId000", 50, "USD");
        processWrapper("accountId003", 250, "HRV");
        processWrapper("accountId001", 50, "EUR");
        processWrapper("accountId001", 50, "USD");
        processWrapper("accountId001", 2000, "USD");
    }

    public static void processWrapper(String id, int amount, String currency) {
        try {
            bankApplication.process(id, amount, currency);
        } catch (WrongAccountException e) {
            System.out.println("Такого акаунту не існує");
        } catch (WrongCurrencyException e) {
            System.out.println("Акаунт має рахунок в іншій валюті");
        } catch (WrongOperationException e) {
            System.out.println("Акаунт не має достатньо коштів");
        } catch (Exception e) {
            System.out.println("Сталася помилка при процесінгу, спробуйте ще раз");
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
        }
    }
}
