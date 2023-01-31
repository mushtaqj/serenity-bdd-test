package starter.saucedemo.features;

import starter.saucedemo.screenplay.Login;
import starter.saucedemo.screenplay.ShoppingCart;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddToCartItemsTest {

    @CastMember(name = "standardUser")
    private Actor standardUser;

    @CastMember
    private Actor restritedUser;



    @Test
    @DisplayName("Add to cart items")
    void whenAddToCartItems_ThenItemsAreAddedToCart() {

        final String toAddProductName = "Sauce Labs Onesie";

        standardUser.attemptsTo(
                Login.as("standard_user", "secret_sauce"),
                ShoppingCart.add(toAddProductName),
                ShoppingCart.view(),
                Ensure.that(ShoppingCart.contains(toAddProductName)).isDisplayed()
        );
    }
}
