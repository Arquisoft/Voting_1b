# Voting System

Voting System

[![Build Status](https://travis-ci.org/Arquisoft/VotingSystem_1b.svg?branch=master)](https://travis-ci.org/Arquisoft/VotingSystem_1b)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/43ec857abe7d4b70a0cc93f6a4cc4364)](https://www.codacy.com/app/jelabra/VotingSystem_1b)
[![codecov.io](https://codecov.io/github/Arquisoft/VotingSystem_1b/coverage.svg?branch=master)](https://codecov.io/github/Arquisoft/VotingSystem_1b?branch=master)
[![Sauce Test Status](https://saucelabs.com/buildstatus/SantiMA10?auth=2a20728ed2c204f2b3b860493620581f)](https://saucelabs.com/u/SantiMA10?auth=2a20728ed2c204f2b3b860493620581f)
[![ViewOnHeroku](https://img.shields.io/badge/View%20on-Heroku-ff69b4.svg)](http://voting-system-1b.herokuapp.com)

# Descripción 
VotingSystem_1b es un sistema de votación telemática que permite:
* Configurar elecciones.
* Solicitar voto telemático.
* Votar telemáticamente a los votantes que lo haya solicitado.

El sistema permite cargar los datos del censo para las votaciones mediante la herramienta [censuses_1b](https://github.com/Arquisoft/censuses_1b).

# Despliegue
## En la nube
Simplemente hay que pulsar el botón o visitar [la versión de master ya desplegada](http://voting-system-1b.herokuapp.com).

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

## Local
Para un despligue local se necesita la **[base de datos HSQLDB](#URL)**, ejecutar el comando **mvn spring-boot:run** y entrar en la dirección [http://localhost:8080](http://localhost:8080) del navegador.
Puede descargarse desde [aqui](https://drive.google.com/open?id=0B-BDcJOyciIGekhBZDBIX20wZ1E).

# Test
Para lanzar los test utilizamos una base de datos en memoria H2, por lo que simplemente hay que ejecutar **mvn test**.

# Github Page
[http://arquisoft.github.io/VotingSystem_1b/](http://arquisoft.github.io/VotingSystem_1b/)

# Autores

* Santiago Martín Agra - UO237040
* David Sánchez Luis - UO237085
* Xurxo García Vázquez - UO235241
* Jose Labra
