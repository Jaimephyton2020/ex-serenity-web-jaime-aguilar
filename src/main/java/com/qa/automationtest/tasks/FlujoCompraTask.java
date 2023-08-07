package com.qa.automationtest.tasks;

import com.qa.automationtest.model.FlujoCompraClienteModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static com.qa.automationtest.ui.FlujoCompraUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FlujoCompraTask implements Task{

    private FlujoCompraClienteModel cliente;

    public FlujoCompraTask(FlujoCompraClienteModel cliente) {
        this.cliente = cliente;
    }

    public static FlujoCompraTask conInformacionCompra(FlujoCompraClienteModel cliente) {
        return instrumented(FlujoCompraTask.class, cliente);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Task.where("{0} Selecciona Productos y Visualiza Carrito",
                        Click.on(PRODUCTO1),
                        //WaitUntil.the(PRODUCTO2, isEnabled()).forNoMoreThan(60).seconds(),
                        Click.on(PRODUCTO2),
                        Click.on(VISUALIZAR_BUTTON),
                        Click.on(BUTTON1),
                        Click.on(CHECKOUT_BUTTON),
                Task.where("{1} Selecciona Guess",
                        Click.on(GUESS_CHECKOUT),
                        Click.on(CONTINUE_BUTTON),
                Task.where("{2} Ingresa Credenciales",
                        Enter.theValue(cliente.getFirstname()).into(FIRST_NAME_FIELD),
                        Enter.theValue(cliente.getLastname()).into(LAST_NAME_FIELD),
                        Enter.theValue(cliente.getEmail()).into(EMAIL_FIELD),
                        Enter.theValue(cliente.getPhone()).into(PHONE_FIELD),
                        Enter.theValue(cliente.getCompany()).into(COMPANY_FIELD),
                        Enter.theValue(cliente.getAdress1()).into(ADRESS1_FIELD),
                        Enter.theValue(cliente.getAdress2()).into(ADRESS2_FIELD),
                        Enter.theValue(cliente.getCity()).into(CITY_FIELD),
                        Enter.theValue(cliente.getPostcode()).into(POSTCODE_FIELD),
                        SelectFromOptions.byVisibleText("Ecuador").from(COUNTRY_FIELD),
                        SelectFromOptions.byVisibleText("Pichincha").from(REGION_FIELD),
                        Click.on(CONTINUE_GUESS_BUTTON),
                        Click.on(CONTINUE_SHIP_BUTTON),
                Task.where("{3} Confirma Compra",
                       // wait(2000),
                        Click.on(TERMS_CHECKOUT),
                        Click.on(PAY_BUTTON),
                        Click.on(CONFIRM_BUTTON))))));
    }

}
