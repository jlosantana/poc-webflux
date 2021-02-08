# poc-webflux

### Aplicação de exemplo

#### 1. Subir o Mongo e o Express

```
docker-compose -f docker-stack-mongo.yml up
```

#### 2. Executar o springboot

```
mvn spring-boot:run
```

#### 3. NOT Funcional endpoint

```
url --location --request POST 'http://localhost:8080/products' --header 'Content-Type: application/json' --data-raw '{"name": "Not Functional Product 1"}'
```

#### 4. Functional endpoint

```
url --location --request POST 'http://localhost:8080/functional/products' --header 'Content-Type: application/json' --data-raw '{"name": "Functional Product 1"}'
```

