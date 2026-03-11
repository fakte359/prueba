package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.pages.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class Login implements Task {

    private final String username;
    private final String password;
    private final String entity;

    public Login(String username, String password, String entity) {
        this.username = username;
        this.password = password;
        this.entity = entity;
    }

    public static Login withCredentials(String username, String password, String entity) {
        return new Login(username, password, entity);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.USERNAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(LoginPage.USERNAME),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.ENTITY),
                // selecciona la entidad por texto
                Click.on(LoginPage.ENTITY_OPTION.of(entity)),
                Click.on(LoginPage.BUTTON_LOGIN),
                // espera a que el formulario desaparezca
                WaitUntil.the(LoginPage.FORM, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }
}

