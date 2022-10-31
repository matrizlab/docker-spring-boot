## Spring Boot MongoDB Basic CRUD


### Start

run mongodb container

```zsh
docker run -d -p 28000:27017 --name mongodb-container mongo:latest
```

run spring boot docker container and link it with mongodb container

```zsh
docker run -p 8090:8081 --name spring-boot-mongodb-container-3 --link mongodb-container:mongo -d matrizlab/spring-boot-mongodb:v3
```

check endpoint

```zsh
curl -v http://localhost:8090/api/welcome
```

### Create

```zsh

curl -X POST localhost:8090/api/categories -H 'Content-type:application/json' -d '{"name": "Category 1"}'

curl -X POST localhost:8090/api/product -H 'Content-type:application/json' -d '{"name": "Product 1", "description": "Desc 1", "price": "123.45", "categoryId": "635f84e60795e14871534960"}'
```

### Read

```zsh
curl -v localhost:8090/api/categories | json_pp

   {
      "id" : "635f84e60795e14871534960",
      "name" : "Category 1"
   },
   {
      "id" : "635f85100795e14871534961",
      "name" : "Category 2"
   },
   {
      "id" : "635f85150795e14871534962",
      "name" : "Category 3"
   }

curl -v localhost:8090/api/products | json_pp

```

### Update

```zsh
curl -X PATCH localhost:8090/api/product/635f871e0795e14871534964 -H 'Content-type:application/json' -d '{"price": "999999.22"}'
```

### Delete

```zsh
curl -X DELETE localhost:8090/api/product/635f888b0795e14871534968

```