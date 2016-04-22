# language: es
	Característica: configurar votacion  
	  Escenario: Datos de configuracion incorrectos
	    Cuando entra en /admin/configuration.xhtml
	    Entonces se ven las opciones disponibles
	    Y elige las opciones dejando campos vacios y hace click en validar
	    Entonces se le muestra un mensaje que indica que debe cubrir todos los campos

