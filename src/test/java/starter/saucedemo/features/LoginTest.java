package starter.saucedemo.features;

import starter.saucedemo.screenplay.Login;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoginTest {

    @CastMember(name = "standardUser")
    private Actor standardUser;

    @Test
    @DisplayName("Login with valid credentials")
    void whenLoginWithValidCredentials_ThenLoginShowInventory() {
        standardUser.attemptsTo(
                Login.as("standard_user", "secret_sauce"),
                Ensure.thatTheCurrentPage()
                        .currentUrl()
                        .isEqualTo("https://www.saucedemo.com/inventory.html")
        );
    }

    @Test
    @DisplayName("Login with invalid credentials")
    void whenLoginWithInvalidCredentials_ThenLoginShowError() {

        standardUser.attemptsTo(
                Login.as("standard_user", "no_secret_sauce"),
                Ensure.that(Text.of(
                                By.cssSelector(".error-message-container > h3"))
                        )
                        .isEqualTo("Epic sadface: Username and password do not match any user in this service")
        );

    }
}
