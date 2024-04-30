package sprint4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import sprint4.pom.MainPage;
import sprint4.pom.OrderCreation;
import sprint4.steps.Steps;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FirstButtonCreateOrderSuccess extends BeforeAndAfter {

    private final String name;
    private final String surname;
    private final String address;
    private final By subwayStation;
    private final String phone;
    private final By deviceColor;

    static OrderCreation orderCreation = new OrderCreation(driver);

    public FirstButtonCreateOrderSuccess(String name, String surname, String address, By subwayStation, String phone, By deviceColor) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.deviceColor = deviceColor;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { "Вячеслав", "Пупков", "Колотушкина, 1", orderCreation.getCherkizovoStation(), "+71112223344",
                        orderCreation.getOrderPickBlackColor() },
                { "Мстислав", "Коровин", "Болотушкина, 1", orderCreation.getSokolnikiStation(), "+79257809781",
                        orderCreation.getOrderPickGreyColor() },
        };
    }

    @Test
    public void orderCreatedFirstButton() {

        MainPage mainPage = new MainPage(driver);
        OrderCreation orderCreation = new OrderCreation(driver);
        Steps steps = new Steps(driver);

        steps
                .open(mainPage.getURL())
                .click(mainPage.getFirstOrderButton())
                .click(orderCreation.getSkipCookie())
                .inputText(orderCreation.getOrderName(), name)
                .inputText(orderCreation.getOrderSurname(), surname)
                .inputText(orderCreation.getOrderAdress(), address)
                .click(orderCreation.getOrderSubwayStation())
                .click(subwayStation)
                .inputText(orderCreation.getOrderPhone(), phone)
                .click(orderCreation.getNextButton())
                .click(orderCreation.getOrderDeliveryDate())
                .click(orderCreation.getOrderPickDate())
                .click(orderCreation.getOrderRentPeriod())
                .click(orderCreation.getOrderPickPeriod())
                .click(deviceColor)
                .click(orderCreation.getOrderFinalButton())
                .click(orderCreation.getConfirmationButton());


        assertEquals("Элемента с подтверждением заказа нет на странице",
                true,
                steps.checkShown(orderCreation.getOrderSuccess()));

    }


}
