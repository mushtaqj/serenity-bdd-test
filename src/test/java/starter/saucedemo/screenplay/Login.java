package starter.saucedemo.screenplay;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ui.Button;
import net.thucydides.core.annotations.Step;

public final class Login {

    public static Performable as(final String username, final String password) {

        return Task.where(
                "{0} logs in with username #username and password #password",
                Open.url("https://www.saucedemo.com/"),
                login(username, password)
        );

    }

    private static Performable login(final String userName, final String password) {

        Button.withNameOrId("login-button");

        return Task.where(
                Enter.theValue(userName).into(By.id("user-name")),
                Enter.theValue(password).into(By.id("password")),
                Click.on(By.id("login-button"))
        );
    }
}


