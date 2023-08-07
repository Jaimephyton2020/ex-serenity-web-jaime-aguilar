@FlujoCompra
Feature: Realizar compra en la pagina Opencart
  Scenario Outline: Realizar compra de dos productos
    Given que el cliente admin ingresa a la pagina Opencart
    When selecciona dos productos y visualiza el carrito y presiona el boton checkout e ingresa los datos "<firstname>" "<lastname>" "<email>" "<phone>" "<company>" "<adress1>" "<adress2>" "<city>" "<postcode>" "<country>" "<region>" pulsa el boton Continuar y pulsa el boton Confirmar Orden
    Then el deberia ver el mensaje de compra exitosa
    Examples:
      | firstname   | lastname   |email   |phone   |company   |adress1   |adress2   |city   |postcode  |
      | Jaime   | Aguilar   | ja@gmail.com |0992914349   |Personal   |Pedro Freile   |Sabanilla   |Quito   |593   |
