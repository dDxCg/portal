#!/bin/bash


echo "1st call (With Cache):"
time curl -s http://localhost:8080/user/1 > /dev/null

echo "2nd call (With Cache):"
time curl -s http://localhost:8080/user/1 > /dev/null

echo "1st call (No Cache):"
time curl -s http://localhost:8080/user/1/non-cache > /dev/null

echo "2nd call (No Cache):"
time curl -s http://localhost:8080/user/1/non-cache > /dev/null
