#!/bin/bash

docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8090:8080 -t geografiaunifal/sisgeo-business-api:$1
