#!/bin/bash
set -e  # exit immediately if any command fails

./mvnw clean package 

# Rebuild Docker images 
docker compose build

# Start containers
docker compose up
