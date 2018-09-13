# Betting Application

# SpringBoot Application with Secure REST with JSON Web Token (JWT)

Application can be used to save bets as per customers and various REST API's are exposed to check the satus.

JWT Token Security requires user to have the token before initiating any request for API's. To get token first user has to generate JWT token using below steps:-

## To retrieve JWT Token

1) Hit POST Request on http://localhost:8080/login
   #### Payload
	 
   {
   
   "username":"admin",
   
   "password":"password"
   
   }
		
2) Response Header will contains the JWT Autherization token, copy the token including Bearer

3) Use this token as Autherization Header for other request URL's



# Exposed API's

1.**Save Bets**

@POST

http://localhost:8080/betsapp/bettings

API is exposed to save the betting data.

Use payload as below:-

[

{

        "customerId": "customer111",
        "dateTime":"01-01-1986 10:10",
        "propNumber": "123",
        "betType": "WIN",
        "investment": 10
    },
    {
        "customerId": "customer222",
        "dateTime":"01-01-1986 10:10",
        "propNumber": "123",
        "betType": "WIN",
        "investment": 10
        
 }
 
 ]


2.**Total investment per bet type**

@GET

http://localhost:8080/betsapp/bettings/investment/bettype

Api exposed to fetch total investment for each bettype

	


3.**Total investment per CustomerID**

@GET

http://localhost:8080/betsapp/bettings/investment/customer

API exposed to get total investment for each customer



4.**Total bets sold per bet type**

@GET

http://localhost:8080/betsapp/bettings/betscount

API exposed to get total bets sold for each bet type



5.**Total number of bets sold per hour**

@GET

http://localhost:8080/betsapp/bettings/betshourlycount

API exposed to fetch total bets completed on hourly bases
