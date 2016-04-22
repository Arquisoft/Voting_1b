# language: es
	Característica: votar en unas elecciones
	  Escenario: Datos del votante incorrectos
	    Cuando entra en / para votar
	    Entonces se ve la lista de las votaciones disponibles para votar
	    Y decide la votacion y hace click
	    Entonces se le muestrarn las opciones disponibles
	    Entonces elige la opcion que quiere votar la 1
	    Y le piden los datos para confirmar el voto
	   	Entonces introduce su email "pepe@pepe.com" y password "12345" para votar
	    Entonces se le muestra el mensaje "Usuario incorrecto."
	  Escenario: Datos del votante correctos sin solicitar el voto telematico
	    Cuando entra en / para votar
	    Entonces se ve la lista de las votaciones disponibles para votar
	    Y decide la votacion y hace click
	    Entonces se le muestrarn las opciones disponibles
	    Entonces elige la opcion que quiere votar la 2
	    Y le piden los datos para confirmar el voto
	    Entonces introduce su email "juan@gmail.com" y password "12345" para votar
	    Y se le muestra el mensaje "No habias pedido voto telematico."
	  Escenario: Datos del votante correctos con el voto telematico solicitado
	    Cuando entra en / para votar
	    Entonces se ve la lista de las votaciones disponibles para votar
	    Y decide la votacion y hace click
	    Entonces se le muestrarn las opciones disponibles
	    Entonces elige la opcion que quiere votar la 3
	    Y le piden los datos para confirmar el voto
	    Entonces introduce su email "pepe@gmail.com" y password "12345" para votar
	    Y se le muestra el mensaje "Ha votado correctamente"
	   Escenario: Datos del votante correctos con el voto telematico solicitado habiando votado antes
	    Cuando entra en / para votar
	    Entonces se ve la lista de las votaciones disponibles para votar
	    Y decide la votacion y hace click
	    Entonces se le muestrarn las opciones disponibles
	    Entonces elige la opcion que quiere votar la 4
	    Y le piden los datos para confirmar el voto
	    Entonces introduce su email "pepe@gmail.com" y password "12345" para votar
	    Y se le muestra el mensaje "Ya has votado en esta votacion."
	   