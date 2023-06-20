#inicia con la imagen base que contiene Java runtime
FROM openjdk:17-jdk-alpine

# se agregar el jar del microservicio al contenedor
COPY target/usuarios-0.0.1-SNAPSHOT.jar usuarios-0.0.1-SNAPSHOT.jar

#se ejecuta el microservicio
ENTRYPOINT ["java","-jar","/usuarios-0.0.1-SNAPSHOT.jar"]