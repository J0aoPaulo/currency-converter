# Currency Converter

[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](https://github.com/J0aoPaulo/currency-converter/blob/main/README.pt-br.md)

<p align=center>
  <img src="https://github.com/J0aoPaulo/currency-converter/assets/98539735/84066f49-0694-4fda-ac31-a6bda69b696d">
  <img src="https://github.com/J0aoPaulo/currency-converter/assets/98539735/84066f49-0694-4fda-ac31-a6bda69b696d">
  <img src="https://github.com/J0aoPaulo/currency-converter/assets/98539735/84066f49-0694-4fda-ac31-a6bda69b696d">
</p>

## Configuration 

### 1. Create an Account on ExchangeRate-API

1. Visit the ExchangeRate-API website.
2. Sign up and create your account.
3. After signing up, obtain your API Key from the user dashboard.

### 2. Configure the API Key

1. In the directory of your project, navigate to the src/main/resources folder.
2. Create a file named application.properties (if it doesn't exist already).
3. Add the following line to application.properties, replacing YOUR_API_KEY_HERE with your API Key:

```properties
    api.key=YOUR_API_KEY_HERE
   ```    
4. Then, add the following line to application.properties, 
replacing URL_BASE_HERE with the base URL of the ExchangedRate-API.

```properties
    base.url=URL_BASE_HERE
  ```

## About the project

A simple currency converter using Spring Boot with the main objectives below:
 - Improve my knowledge about API using Java.
 - Improve my knowledge about the Gson library and how it works.
 - Improve my knowledge about Spring Boot dependency injection.
 - Learn how to use ExchangeRate-API.

## Project funcionalities

- [x] Ability for the user provide the currency they wish to convert and the currency it will be converted to.
- [x] The converter allows you to convert up to 10 different currencies.