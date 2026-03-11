package org.example.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target FORM = Target.the("login form").located(By.id("frmInicioSesion"));
    public static final Target USERNAME = Target.the("campo usuario").locatedBy("//*[@id='frmInicioSesion']/div[2]/div/input");
    public static final Target PASSWORD = Target.the("campo contraseña").locatedBy("//*[@id='frmInicioSesion']/div[3]/div/input");
    // Usar el id del ng-select para abrir el dropdown (el div interno)
    public static final Target ENTITY_DROPDOWN = Target.the("abrir entidad").locatedBy("//*[@id='prv_empresa_id']/div");
    // Alias para compatibilidad con la tarea Login (antes se llamaba ENTITY en el código)
    public static final Target ENTITY = Target.the("campo entidad").locatedBy("//*[@id='prv_empresa_id']/div/div/div[2]");
    // Selecciona la opción por el texto dentro del div de opción (div.ng-option)
    public static final Target ENTITY_OPTION = Target.the("opcion entidad").locatedBy("//div[contains(@class,'ng-option') and .//span[normalize-space(text())='{0}']]");
    // Botón de ingreso en el formulario
    public static final Target BUTTON_LOGIN = Target.the("boton ingresar").locatedBy("//*[@id='frmInicioSesion']/div[6]/div/button[1]");
}
