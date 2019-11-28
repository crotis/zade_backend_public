# zade_backend_public
Backend server for Zade (Financial Web Application)

**NOTE: I have a private repository fit for building the project, this repository is availible to demonstraight the code and is missing
API access keys and other key features**

**This project is still undergoing development and is by no means complete, please visit http://46.101.8.127:3000/ to see the current version hosted on on Digital Ocean**

## Overview 
The project aims to make financial information availible on the Zade Web Application such as current price of financial assets, todays high, low, open, close and candlestick graphs so that the data can be seen in the context of the trend in the market.
A server-side web API using Spring(Java) and Tomcat. Periodically retrieves data from https://www.alphavantage.co/ and saves it to an integrated database so that it can be provided to the Zade Financial Web Application via and custom API. This was done for two main reasons, to demonstraight my ability in back-end development and to make the JSON data more appropriate to my needs.

## Project Structure

### AlphaVantage\RequestFX & RequestCrpy
These classes provide requests to https://www.alphavantage.co/ for the 

### Assets\Asset.java
Allows an instance of each asset to be created

