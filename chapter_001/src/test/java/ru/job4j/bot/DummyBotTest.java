package ru.job4j.bot;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Artur Glyzin (aglizin@yandex.ru)
 * @version 1.0
 * @since 01.05.2018
 */

public class DummyBotTest {
    @Test
    public void whenHiBot() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Привет бот."), is("Привет умник."));
    }

    @Test
    public void whenByBot() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Пока."), is("До скорой встречи!"));
    }

    @Test
    public void whenUnknown() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Как дела?"), is("Это ставит меня в тупик, задайте другой вопрос!"));
    }
}