# Betting Application

# SpringBoot Application with Secure REST with JSON Web Token (JWT)

Application can be used to save bets as per customers and various REST API's are exposed to check the satus.

JWT Token Security requires user to have the token before initiating any request for API's. To get token first user has to generate JWT token using below steps:-

## How to Run Application

Build the project by maven command ** mvn clean install**. This command will generte the jar file inside trget folder. Copy this jar to some location and then start the application by running following command:
**java -jar betsapplication-0.0.1-SNAPSHOT.jar**
Command will start the tomcat server and expose the API's on port _8080_

## To retrieve JWT Token

1) Hit POST Request on http://localhost:8080/login
   #### Payload
  ``` {
   "username":"admin",
   "password":"password"
   }
   ```
		
2) 200 OK Response will contain the Header containing the JWT Autherization token, copy the token including Bearer. for eg.
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTUzNzkzMDczNn0.__Wl1JBooLZqID4jwVrYogX5Fr8fkmZPxPCWHojFUi_90TyaF4fnPYXeWuGZhzjwmOVSMlEwsPvfjDICXY1GyA


3) This token will be used to Autherization other request URL's. Add **Autherization** header in **HEADER** for all request POST/GET 


# Exposed API's

1.**Save Bets**

@POST

http://localhost:8080/betsapp/bettings

API is exposed to save the betting data.

Use payload as below:-
```
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
```

2.**Total investment per bet type**

@GET

http://localhost:8080/betsapp/bettings/investment/bettype

Api exposed to fetch total investment for each bettype

### **Output**
```
[
    {
        "betType": "QUADDIE",
        "investmentAmount": 20
    },
    {
        "betType": "WIN",
        "investmentAmount": 10
    },
    {
        "betType": "PLACE",
        "investmentAmount": 40
    }
]
```


3.**Total investment per CustomerID**

@GET

http://localhost:8080/betsapp/bettings/investment/customer

API exposed to get total investment for each customer

### **Output**
```
[
    {
        "customerId": "customer7",
        "totalInvestment": 10
    },
    {
        "customerId": "customer1",
        "totalInvestment": 10
    },
    {
        "customerId": "customer2",
        "totalInvestment": 10
    },
    {
        "customerId": "customer3",
        "totalInvestment": 10
    },
    {
        "customerId": "customer4",
        "totalInvestment": 10
    },
    {
        "customerId": "customer5",
        "totalInvestment": 10
    },
    {
        "customerId": "customer6",
        "totalInvestment": 10
    }
]
```


4.**Total bets sold per bet type**

@GET

http://localhost:8080/betsapp/bettings/betscount

API exposed to get total bets sold for each bet type

### **Output**
```
[
    {
        "betType": "QUADDIE",
        "count": 2
    },
    {
        "betType": "WIN",
        "count": 1
    },
    {
        "betType": "PLACE",
        "count": 4
    }
]
```


5.**Total number of bets sold per hour**

@GET

http://localhost:8080/betsapp/bettings/betshourlycount

API exposed to fetch total bets completed on hourly bases
### **Output**

```
[
    {
        "dateTime": "2018-09-16T13:00",
        "betsSoldCount": 1
    },
    {
        "dateTime": "2018-09-16T10:00",
        "betsSoldCount": 2
    },
    {
        "dateTime": "2018-09-16T11:00",
        "betsSoldCount": 3
    },
    {
        "dateTime": "2018-09-16T12:00",
        "betsSoldCount": 1
    }
]
```
