package starter.saucedemo.screenplay;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;

import java.util.Objects;

public class ShoppingCart {

    public static Performable startWithAnEmptyCart(){
        return null;
    }

    //Click on the shopping cart icon
    public static Performable view() {
        return CartIcon.click();
    }

    public static Performable add(String item) {

        //Edge case what happens if the button is remove instead of add

        final String kebabCaseItem = toKebabCase(item);

        return Task.where(
                Click.on(Button.withNameOrId("add-to-cart-" + kebabCaseItem)));
    }

    // write a method to remove an item from the cart
    public static Performable remove(String item) {

        //Edge case what happens if the button is remove instead of add

        final String kebabCaseItem = toKebabCase(item);

        return Task.where(
                Click.on(Button.withNameOrId("remove-" + kebabCaseItem)));
    }

    // Check if an item exists in the shopping cart
    public static Target contains(String item) {
        return PageElement.containingText(item);
    }

    /**
     * Method to convert text to kebab-case
     * For example, "Sauce Labs Onesie" should be converted to "sauce-labs-onesie"
     */
    private static String toKebabCase(String item) {
        //TODO - This can be done in a separete shared function

        return Objects.requireNonNull(item).toLowerCase().replace(" ", "-");
    }


}
