package com.qa.automationtest.glue;

import com.qa.automationtest.model.FlujoCompraInformacionClienteModel;
import com.qa.automationtest.tasks.FlujoCompraTask;
import com.qa.automationtest.ui.FlujoCompraUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class FlujoCompraGlue {

    @Given("que el cliente{actor} ingresa a la pagina Opencart")
    public void que_el_cliente_ingresa_a_la_pagina_opencart(Actor actor) {
        givenThat(actor).attemptsTo(Open.browserOn().the(FlujoCompraUI.class));
    }
    @When("selecciona dos productos y visualiza el carrito y presiona el boton checkout e ingresa los datos {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} pulsa el boton Continuar y pulsa el boton Confirmar Orden")
    public void selecciona_dos_productos_y_visualiza_el_carrito_y_presiona_el_boton_checkout_e_ingresa_los_datos_pulsa_el_boton_continuar_y_pulsa_el_boton_confirmar_orden(String firstname, String lastname, String email, String phone, String company, String adress1, String adress2, String city, String postcode, String country, String region) {
        when(theActorInTheSpotlight()).wasAbleTo(
                FlujoCompraTask.conInformacionCompra(FlujoCompraInformacionClienteModel.conDatos(firstname, lastname, email, phone, company, adress1, adress2, city, postcode, country, region)));
    }
    @Then("el deberia ver el mensaje de compra exitosa")
    public void el_deberia_ver_el_mensaje_de_compra_exitosa() {
        then(theActorInTheSpotlight()).should(GivenWhenThen.seeThat(WebElementQuestion.the(FlujoCompraUI.MENSAJE), isPresent()));
    }
}
