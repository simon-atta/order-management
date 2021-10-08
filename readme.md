# Sales Order Application

## Project Background

Sales order application contains:

* Product: The inventory products that orginzation sell.
* Customer: The buyers of products from orginzation.
* Sales Order: The process of selling product to customer. Each sales order consists of one or more order lines.
* Order Lines: The actual products and quantites that a customer need to buy.

### Application architecture

* Frontend : Desk top application which manage all entities.
* Salesorder-api : Web service which expose all entities in rest endpoints.
* Salesorder-sdk : SDK for salesorder-api which will be used by frontend.


