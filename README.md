# README

Pruebas Automatizadas Flujo de Compra pagina web de Opencart

Realizadas por: Jaime Aguilar

## Ejecución local

Clonar el proyecto

```bash
  git clone https://github.com/Jaimephyton2020/ex-serenity-web-jaime-aguilar.git
```


Para correr el proyecto de manera local se debe realizar los siguientes pasos:
1. Definir la tag de los tipos de tests que se van a ejecutar, esto lo hacemos en el archivo WebRunnerTest, para el ejemplo se va a correr todos los test menos los manuales, api y las pruebas móviles. Se correra los test de aplicaciones web.
```
tags = "not @karate and not @ManualTest and not @Mobiletest"
```

2. Definir el driver a usarse en serenity.properties y comentar la elección del driver mediante variables de entorno. Para el ejemplo vamos a correr pruebas de una aplicación web por lo tanto vamos a seleccionar el driver de chrome
```
####Configuracion driver
#para corrida local
webdriver.driver=chrome
```


## Modificación del codigo

- Para realizar modificaciones al codigo del proyecto. realizar los siguientes pasos: 

     
	 1. Importar el proyecto desde IntelliJ IDE bajo la estructura de un proyecto Gradle existente
	 2. Configurar JRE System Library con JavaSE-1.8
	 3. Configurar la codificación a UTF-8 al proyecto una vez sea importado
     4. Una vez importado el proyecto se puede ejecutar la clase WebRunnerTest desde el IDE

### Comandos E2E

Para ejecutar todos los features por linea de comandos
```bash
  ./gradlew clean test --tests "WebRunnerTest"
```

> **NOTA**:
> * Para ejecutar el proyecto se necesita Java JDK 11.0.20 y Gradle con la versión 3.8.1 o superior.
> * Otra alternativa para no instalar gradle es usar el comando gradlew al momento de ejecutar el proyecto como se muestro anteriormente.
> * En caso de tener problemas con el web driver por la versión del google chrome, realizar el cambio del web driver (descarga) por una versión compatible con el google chrome instalado. tener en cuenta que la  ruta del web driver en el proyecto es \src\test\resources\drivers
> * Para las pruebas E2E, el reporte serenity se genera en la ruta **target/site/serenity/index.html**, los reportes cucumber se generan en la carpeta **build/cucumber-reports/json**, el archivo **cucumber.json**


## Construido con

La automatización fue desarrollada con:

* BDD - Estrategia de desarrollo
* Screenplay 
* Gradle - Manejador de dependencias
* Cucumber - Framework para automatizar pruebas BDD
* Serenity BDD - Biblioteca de código abierto para la generación de reportes
* Gherkin - Lenguaje Business Readable DSL (Lenguaje especifico de dominio legible por el negocio)

Reporte Ejecución Exitosa:

file:///C:/Users/Jaime/Documents/Portafolio/sqa-aut-arq-serenitybdd_UV/target/site/serenity/668be05f1d3399f390d2eec94f120b421a0f08ce8738c54c4b5a3d2aca2d1f40_screenshots.html#screenshots




