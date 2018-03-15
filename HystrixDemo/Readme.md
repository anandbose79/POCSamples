# Hystrix Demo

## Overview

This project demonstrates the use of Hystrix as circuit breaker

## Dependencies

Graphite / Graphana containers should be up and running

Graphana can be accessed via the following url

http://172.28.72.144:3000/dashboard/db/hystrixdemo?refresh=5s&panelId=1&fullscreen&edit&orgId=1
user : admin
password : secret


## Run

To start the project, execute:<br/>
`mvn spring-boot:run`

The server will be available in port 8090.

## Commands

To execute the method the following command needs to be executed via postman or command line using curl

```
http://localhost:8090/v1/test/myInput 

```

To set the success percentage
```
http://localhost:8090/v1/test/random/<percentage>
##eg
http://localhost:8090/v1/test/random/20
will set the success % to 20
```
To view hystrix dashboard
```
http://localhost:8090/v1/test/hystrix.dashboard
once the dashboard is up provide the stream as follows
http://localhost:8090/v1/test/hystrix.stream

```
## Application properties for Hystrix
The following are the application properties used in this demo
```

```
