# language: es
	Característica: solicitar voto
	  Escenario: Datos del votante correctos
	    Cuando entra en la web
	    Entonces se ve la lista de las votaciones disponibles
	    Y decide la votacion y hace click en solicitar
	    Entonces se le piden sus datos para solicitar el voto telematico
	    Y introduce su email "pepe@gmail.com" y password "12345"
	    Entonces se le muestra el mensaje "Voto telematico admitido" referente al voto telematico
	    
	 Escenario: Datos del votante correctos pero ya ha pedido el voto telematico
	    Cuando entra en la web
	    Entonces se ve la lista de las votaciones disponibles
	    Y decide la votacion y hace click en solicitar
	    Entonces se le piden sus datos para solicitar el voto telematico
	    Y introduce su email "pepe@gmail.com" y password "12345"
	    Entonces se le muestra el mensaje "Ya solicito el voto tematico" referente al voto telematico
	    
	  Escenario: Datos del votante incorrectos
	    Cuando entra en la web
	    Entonces se ve la lista de las votaciones disponibles
	    Y decide la votacion y hace click en solicitar
	    Entonces se le piden sus datos para solicitar el voto telematico
	    Y introduce su email "pepe@pepe.com" y password "12345"
	    Entonces se le muestra el mensaje "Correo electronico y/o contraseña incorrectos" referente al voto telematico