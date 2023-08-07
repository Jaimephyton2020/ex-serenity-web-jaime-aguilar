package com.qa.automationtest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlujoCompraClienteModel {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String company;
    private String adress1;
    private String adress2;
    private String city;
    private String postcode;
    private String country;
    private String region;

public FlujoCompraClienteModel(String firstname, String lastname, String email, String phone, String company, String adress1, String adress2, String city, String postcode, String country, String region) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.phone = phone;
            this.company = company;
            this.adress1 = adress1;
            this.adress2 = adress2;
            this.city = city;
            this.postcode = postcode;
            this.country = country;
            this.region = region;

    }
}
