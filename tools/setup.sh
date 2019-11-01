#!/bin/bach
SERVER_LOCATION=$HOME/http-server
mkdir $SERVER_LOCATION
cd $SERVER_LOCATION

function downloadRedis() {
  echo "============================================================================"
  echo "Downloading Redis...."
  echo "============================================================================"
  if [ -x "$(command -v wget)" ]; then
    wget http://download.redis.io/redis-stable.tar.gz
  elif [ -x "$(command -v curl)" ]; then
    curl -O http://download.redis.io/redis-stable.tar.gz
  else
    echo "Neither wget nor curl are installed"
    exit
  fi

}

function extractAndRemove() {
  tar xvzf redis-stable.tar.gz
  rm redis-stable.tar.gz
  cd redis-stable
}

downloadRedis
extractAndRemove
make
# Run Redis test cases
make test

