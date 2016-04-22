# language: es
	Característica: cargar votos como junta electoral
	  Escenario: Campos rellenados con numeros positivos
	    Cuando Entra en la web
	    Entonces se valida con la cuenta "administracion@juntaElectoral.es" y password "cambiar"
	   	Entonces Va a la zona de votaciones para gestionar
	  	Y decide gestionar una votacion que quiere
	    Entonces introduciendo todos los votos y la cuenta "administracion@juntaElectoral.es" y password "cambiar"
	    Entonces se le muestra el mensaje "Carga de votos correcta" en voteInput
	  Escenario: votos con cuenta no administracion primera validacion
	    Cuando entra en la web de nuevo
	   	Entonces se valida incorrectamente con la cuenta "pepe@gmail.com" y password "12345"
	   	Y se me muestra el mensaje "El usuario no tiene permisos" por login malo
	  Escenario: votos con cuenta no administracion segunda validacion
	    Cuando entra en la web de nuevo
	    Entonces se valida de nuevo con la cuenta "administracion@juntaElectoral.es" y password "cambiar"
	    Entonces Va a la zona de votaciones para gestionar de nuevo parasi gestionar una votacion que quiere
	    Entonces introduciendo todos los votos y la cuenta "nosoyAdmin@no.com" y password "nop"
	    Entonces se le muestra el mensaje "Usuario incorrecto."  al no ser admin
	  Escenario: mal login
	    Cuando entra en la web de administracion
	    Entonces se valida incorrectamente con la cuenta "nosoyAdmin@no.com" y password "nop"
	    Y se me muestra el mensaje "Datos de incio de sesion incorrectos" por login malo
		