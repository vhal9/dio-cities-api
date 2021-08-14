# Cities API

API desenvolvida no Bootcamp de Java Developer na Digital Innovation One.

- Consulta de cidades
- Consulta de Estados
- Consulta de Países
- Cálculo de distância entre cidades

## Requirements

* Linux
* Git
* Java 8
* Docker
* IntelliJ Community
* Heroku CLI

## DataBase

### Postgres

```shell script
CREATE DATABASE nomeDB
```

### Populate

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```shell script
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

psql -h localhost -U RoleName nomeDB -f /tmp/pais.sql
psql -h localhost -U RoleName nomeDB -f /tmp/estado.sql
psql -h localhost -U RoleName nomeDB -f /tmp/cidade.sql

psql -h localhost -U RoleName nameDataBase

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;

```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

### Application Configuration

- Adicione as configurações do seu banco no arquivo application.properties
```shell script
  spring.datasource.url=jdbc:postgresql://localhost:porta/nomeDB
  spring.datasource.username=RoleName
  spring.datasource.password=SENHA

```


### Query Earth Distance

Point
```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

Cube
```roomsql
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

## Spring Boot

* [https://start.spring.io/](https://start.spring.io/)

+ Java 8
+ Gradle Project
+ Jar
+ Spring Web
+ Spring Data JPA
+ PostgreSQL Driver

### Spring Data

* [jpa.query-methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

### Properties

* [appendix-application-properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
* [jdbc-database-connectio](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)

### Types

* [JsonTypes](https://github.com/vladmihalcea/hibernate-types)
* [UserType](https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/usertype/UserType.html)


