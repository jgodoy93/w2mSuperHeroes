# W2M SuperHeroes Challenge Api

Challenge para W2M.


## Run con Docker

Ubicarse en la carpeta raiz del proyecto y ejecutar el siguiente comando desde la terminal:

```bash
docker build -t w2mapi .
```
Luego verificar que la imagen se haya construido correctamente con el comando:

```bash
docker images
```
Una vez creada la imagen, para levantar el proyecto en el puerto 8000 ejecutar:

```bash
docker run -p 8000:8080 w2mapi
```

## Run con Maven
El proyecto utiliza la versión de Java 17.

Ubicarse en la carpeta raiz del proyecto y ejecutar el siguiente comando desde la terminal:

```bash
mvn spring-boot:run
```


## Swagger UI
La Api se encuentra documentada con Swagger, para ingresar dirigirse a [http://localhost:8000/swagger-ui.html](http://localhost:8000/swagger-ui.html), con user: w2m y pass: w2m

## Observaciones.

La informacion del endpoint GET /superheroes, dispone del uso de cache y con una anotación que muestra por consola el tiempo de repuesta en milisegundos.

El proyecto ha sido refactorizado y subida su versión de spring-boot.