package com.qa.automationtest.model;

public class FlujoCompraInformacionClienteModel {

    private static FlujoCompraClienteModel cliente = new FlujoCompraClienteModel();

    private FlujoCompraInformacionClienteModel() {
    }

    public static FlujoCompraClienteModel conDatos(String firstname, String lastname, String email, String phone, String company, String adress1, String adress2, String city, String postcode, String country, String region) {
        cliente.setFirstname(firstname);
        cliente.setLastname(lastname);
        cliente.setEmail(email);
        cliente.setPhone(phone);
        cliente.setCompany(company);
        cliente.setAdress1(adress1);
        cliente.setAdress2(adress2);
        cliente.setCity(city);
        cliente.setPostcode(postcode);
        cliente.setCountry(country);
        cliente.setRegion(region);
        return cliente;
    }

}
