# Mongo DB Sample application

This is a POC for springboot connecting to Mongo DB . This also contains the docker module which contains the following
1. MongoDB
2. Scripts to insert data into MongoDB

## Overview  

The application uses spring-data-MongoDB dependency to connect to mongo db and perform CRUD operations.
Also there is a docker folder which contains the following files:
- docker-compose.yml
  This spins up the docker image for mongo db. Also the port and configuration files are mounted to the docker container
- addentries.sh
  This script is used to import data into mongo db.This is for reference only and should not be executed directly
- importtodocker.sh
  This script takes in the docker container id as input and runs addentries to import data to mongodb docker image
  '''
  usage :
  ./importtodocker.sh <containerid>
  eg:
  ./importtodocker.sh 47978b1a8861
  '''

The swagger code is available at:
src/main/resources/smr-poc-MongoDB
