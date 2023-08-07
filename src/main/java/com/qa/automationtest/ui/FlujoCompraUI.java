package com.qa.automationtest.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:webdriver.base.url.opencart")
public class FlujoCompraUI extends PageObject {
        public static final Target PRODUCTO1 = Target.the("Botón para seleccionar producto 1").locatedBy("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]");
        public static final Target PRODUCTO2 = Target.the("Botón para seleccionar producto 2").locatedBy("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]");
        public static final Target VISUALIZAR_BUTTON = Target.the("Botón para habilitar visualizar carrito").locatedBy("//*[contains(@class, 'btn-inverse')]");
        public static final Target BUTTON1 = Target.the("Botón para visualizar carrito").locatedBy("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong");
        public static final Target CHECKOUT_BUTTON = Target.the("Botón para checkout").locatedBy("//*[@id=\"content\"]/div[3]/div[2]/a");
        public static final Target GUESS_CHECKOUT = Target.the("Guess checkout").locatedBy("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input");
        public static final Target CONTINUE_BUTTON = Target.the("Botón para continuar").locatedBy("//*[@id=\"button-account\"]");

        public static final Target FIRST_NAME_FIELD = Target.the("Campo de firstname").locatedBy("//*[@id=\"input-payment-firstname\"]");
        public static final Target LAST_NAME_FIELD = Target.the("Campo de lastname").locatedBy("//*[@id=\"input-payment-lastname\"]");
        public static final Target EMAIL_FIELD = Target.the("Campo de email").locatedBy("//*[@id=\"input-payment-email\"]");
        public static final Target PHONE_FIELD = Target.the("Campo de phone").locatedBy("//*[@id=\"input-payment-telephone\"]");
        public static final Target COMPANY_FIELD = Target.the("Campo de company").locatedBy("//*[@id=\"input-payment-company\"]");
        public static final Target ADRESS1_FIELD = Target.the("Campo de adress1").locatedBy("//*[@id=\"input-payment-address-1\"]");
        public static final Target ADRESS2_FIELD = Target.the("Campo de adress2").locatedBy("//*[@id=\"input-payment-address-2\"]");
        public static final Target CITY_FIELD = Target.the("Campo de city").locatedBy("//*[@id=\"input-payment-city\"]");
        public static final Target POSTCODE_FIELD = Target.the("Campo de postcode").locatedBy("//*[@id=\"input-payment-postcode\"]");
        public static final Target COUNTRY_FIELD = Target.the("Campo de country").locatedBy("//*[@id=\"input-payment-country\"]");
        public static final Target REGION_FIELD = Target.the("Campo de region").locatedBy("//*[@id=\"input-payment-zone\"]");
        public static final Target CONTINUE_GUESS_BUTTON = Target.the("Botón para continuar Guess").locatedBy("//*[@id=\"button-guest\"]");
        public static final Target CONTINUE_SHIP_BUTTON = Target.the("Botón para continuar la compra").locatedBy("//*[@id=\"button-shipping-method\"]");
        public static final Target TERMS_CHECKOUT = Target.the("Terms checkout").locatedBy("//*[@id=\"collapse-payment-method\"]/div/div[3]/div/input[1]");
        public static final Target PAY_BUTTON = Target.the("Botón para pagar").locatedBy("//*[@id=\"button-payment-method\"]");
        public static final Target CONFIRM_BUTTON = Target.the("Botón para confirmar la orden").locatedBy("//*[@id=\"button-confirm\"]");
        public static final Target MENSAJE = Target.the("Mensaje compra exitosa").locatedBy("//h1[text()='Your order has been placed!']");
}
