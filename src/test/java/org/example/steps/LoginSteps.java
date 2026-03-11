package org.example.steps;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Managed;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.tasks.Login;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    @Managed
    WebDriver driver;

    @Before
    public void setTheStage() {
        // Configura el driver del sistema para Chrome (WebDriverManager)
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el actor abre la página de login")
    public void abrePaginaLogin() {
        OnStage.theActorCalled("usuario").can(BrowseTheWeb.with(driver));
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://qa.aleerp.com/login")
        );
    }

    @Cuando("inicia sesión con usuario {string} contraseña {string} y entidad {string}")
    public void iniciaSesion(String usuario, String contrasena, String entidad) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(usuario, contrasena, entidad)
        );
    }

    @Entonces("debería ver la página principal")
    public void deberiaVerPaginaPrincipal() {
        // Espera a que el formulario de login desaparezca
        OnStage.theActorInTheSpotlight().attemptsTo(
                net.serenitybdd.screenplay.waits.WaitUntil.the(LoginPage.FORM, net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible()).forNoMoreThan(10).seconds()
        );
    }
}
