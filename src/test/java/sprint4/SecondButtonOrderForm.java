package sprint4;

import org.junit.Test;
import sprint4.pom.MainPage;
import sprint4.pom.OrderCreation;
import sprint4.Steps.Steps;

import static org.junit.Assert.assertTrue;

public class SecondButtonOrderForm extends BeforeAndAfter {

    @Test
    public void orderFormOpenedSecondButton() {

        MainPage mainPage = new MainPage(driver);
        OrderCreation orderCreation = new OrderCreation(driver);
        Steps steps = new Steps(driver);

        steps
                .open(mainPage.getURL())
                .scroll(mainPage.getSecondOrderButton())
                .click(mainPage.getSecondOrderButton());


        assertTrue("Окна для ввода данных заказа нет на странице", steps.checkShown(orderCreation.getOrderForm()));


    }
}
