## Spring Boot MongoDB Basic CRUD


### Start

mvn clean install -Dmaven.test.skip

docker-compose build

docker-compose up -d



#### check endpoint

```zsh
curl -v http://localhost:8080/api/welcome
```

### Create

```zsh

curl -X POST localhost:8080/api/categories -H 'Content-type:application/json' -d '{"name": "Category 1"}'

curl -X POST localhost:8080/api/product -H 'Content-type:application/json' -d '{"name": "Product 1", "description": "Desc 1", "price": "123.45", "categoryId": "635f84e60795e14871534960"}'
```

### Read

```zsh
curl -v localhost:8080/api/categories | json_pp

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