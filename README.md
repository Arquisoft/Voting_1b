# Voting System


[![Build Status](https://travis-ci.org/Arquisoft/Voting_1b.svg?branch=master)](https://travis-ci.org/Arquisoft/Voting_1b)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/39b52c66678e46ee8116807748b6d053)](https://www.codacy.com/app/jelabra/Voting_1b)
[![codecov.io](https://codecov.io/github/Arquisoft/Voting_1b/coverage.svg?branch=master)](https://codecov.io/github/Arquisoft/Voting_1b?branch=master)

BPM: https://drive.google.com/open?id=0B9Emp-4y7X_7N2l0WS1aVHYwSjQ

## Censuses
**Censuses** es una aplicación tipo de batch que permite cargar el censo que se utilizara en las elecciones creadas con el sistema.

Admite los siguientes formatos de entrada del censo:
* **Excel(xls y xlsx)**

A la vez que se importan los usuarios se genera una contraseña para cada uno de ellos.

Los formatos de salida de las cartas:
* **TXT** (opcion **-c txt** al ejecutar)
* **PDF** (opcion **-c pdf** al ejecutar)

Para utilizarlo hay que ejecutar, primero necesita se necesita la **[base de datos HSQLDB](#base-de-datos-hsqldb)**, y luego **java -jar censuses1b-0.0.1.jar -e "ruta al fichero excel"** 
 
## Voters

## VotingSystem
**VotingSystem** es un sistema de votación telemática que permite:
* **Configurar elecciones.**
* **Solicitar voto telemático.**
* **Votar telemáticamente** a los votantes que lo haya solicitado.

Para un despligue local se necesita la **[base de datos HSQLDB](#base-de-datos-hsqldb)**, ejecutar el comando **mvn spring-boot:run** y entrar en la dirección [http://localhost:8080](http://localhost:8080) del navegador.

## VoteCounting

## Base de datos HSQLDB
Puede descargarse desde [aqui](https://drive.google.com/open?id=0B-BDcJOyciIGekhBZDBIX20wZ1E). Se ejecuta con el archivo **startup.bat** y tambien contiene un gestor que se contecta automaticamente y se puede lanzar ejecutando **RunManagerSwing.bat**

## Autores
* [Santiago Martín Agra](https://github.com/SantiMA10)
* David Sánchez Luis
* [Xurxo García Vázquez](https://github.com/garciavazquez)
* Adrian Suarez Garcia
* Ana González Garcia
* Enol Matilla Blanco


