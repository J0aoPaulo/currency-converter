# Conversor de Moedas

[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/J0aoPaulo/currency-converter/blob/main/README.md)

<p align=center>
  <img src="https://github.com/J0aoPaulo/currency-converter/assets/98539735/84066f49-0694-4fda-ac31-a6bda69b696d">
  <img src="https://github.com/J0aoPaulo/currency-converter/assets/98539735/84066f49-0694-4fda-ac31-a6bda69b696d">
  <img src="https://github.com/J0aoPaulo/currency-converter/assets/98539735/84066f49-0694-4fda-ac31-a6bda69b696d">
</p>

## Configuração

### 1. Crie uma Conta na ExchangeRate-API

1. Acesse o site da [ExchangeRate-API](https://www.exchangerate-api.com/).
2. Faça o cadastro e crie sua conta.
3. Após o cadastro, obtenha sua API Key no painel de usuário.

### 2. Configure a API Key

1. No diretório do seu projeto, navegue até a pasta `src/main/resources`.
2. Crie um arquivo chamado `application.properties` (caso não exista).
3. Adicione a seguinte linha no `application.properties`, substituindo `YOUR_API_KEY_HERE` pela sua API Key:

```properties
    api.key=YOUR_API_KEY_HERE
   ```          
4. Em seguida, adicione a seguinte linha no `application.properties`, 
substituindo `URL_BASE_HERE` pela base da url do ExchangedRate-API.

```properties
    base.url=URL_BASE_HERE
  ```
## Sobre o projeto
Um conversor de moedas simples usando Spring Boot com os principais objetivos abaixo:

 - Melhorar meu conhecimento sobre APIs usando Java.
 - Melhorar meu conhecimento sobre a biblioteca Gson e seu funcionamento.
 - Melhorar meu conhecimento sobre injeção de dependência no Spring Boot.
 - Aprender a usar a ExchangeRate-API.

## Funcionalidades do projeto

 - [x] Permitir que o usuário forneça a moeda de origem e a moeda de destino para conversão.
 - [x] O conversor permite converter até 10 moedas diferentes.