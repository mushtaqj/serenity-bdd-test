package starter.saucedemo.screenplay;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.PageElement;

public class CartIcon {

    public static Performable click() {
        return Task.where(Click.on(PageElement.withCSSClass("shopping_cart_link")));
    }
}
