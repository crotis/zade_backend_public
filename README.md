# zade_backend_public
Backend server for Zade (Financial Web Application)

**NOTE: I have a private repository fit for building the project, this repository is availible to demonstraight the code and is missing
API access keys and other key features**

**This project is still undergoing development and is by no means complete, please visit http://46.101.8.127:3000/ to see the current version hosted on on Digital Ocean**

## Overview 
The project aims to make financial information availible on the Zade Web Application such as the current price of financial assets, todays high, low, open, close and also provides candlestick graphs so that the data can be seen in the context of trends in the market.

This repoisitory contains the server-side web API components of the Project built in Spring(Java) and uses Apache Tomcat. Periodically retrieves data from https://www.alphavantage.co/ and saves it to an integrated database so that it can be provided to the Zade Financial Web Application via and custom API. This was done for two main reasons, to demonstraight my ability in back-end development and to make the JSON data more appropriate to my needs.

## Project Structure - Main Components

### AlphaVantage\RequestFX & RequestCrpy
These classes provide the requests to https://www.alphavantage.co/ API for the relevant data on financial assets. 

### Assets\Asset.java
Allows an instance of an Asset to be created and provides part of the format for the JSON from the REST API.

### LoadDatabase.java
Preloads a template of the data which is to be held in the database.

### UpdateDatabase.java
Schedules periodic the update of the database, upon where RequestFX and RequestCrpy retrieve the data and instances of the Asset are saved to the database. 

### AssetController.java
Provides the REST API controller for single and multiple asset functions: GET, PUT, POST and DELETE.


