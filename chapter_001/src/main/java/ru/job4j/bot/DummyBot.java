package ru.job4j.bot;

/**
 * Программа - глупый бот.
 *
 * @author Artur Glyzin (aglizin@yandex.ru)
 * @version 1.0
 * @since 01.05.2018
 */

public class DummyBot {
    public String answer(String question) {
        String rs1 = "Это ставит меня в тупик, задайте другой вопрос!";
        if (question.equals("Привет бот.")) {
            rs1 = "Привет умник.";
        } else if (question.equals("Пока.")) {
            rs1 = "До скорой встречи!";
        }
        return rs1;
    }

}