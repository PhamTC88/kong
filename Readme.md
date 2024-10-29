[//]: # (#kafka server docker)
docker pull apache/kafka:3.8.1

docker run -p 9092:9092 apache/kafka:3.8.1

[//]: # (postgres server docker)
docker run -d -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password123 --name db-my -p 5432:5432  --restart=always postgres