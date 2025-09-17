#!/bin/bash
set -e  # exit immediately if any command fails

# Rebuild Docker images without cache
docker compose build --no-cache

# Start containers
docker compose up
