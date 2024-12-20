package ESI.BC06_2;

public class Principal {

	public static void main(String[] args) {
		
		 // Crear un usuario ejemplo
        Usuario usuario = new Usuario(true, false, false, true);

        // Crear las condiciones meteorol�gicas ejemplo
        CondicionesMeteorologicas condiciones = new CondicionesMeteorologicas(20, 50, false);

        // Crear las caracter�sticas del espacio ejemplo
        Espacio espacio = new Espacio(10, 50, false);

        // Obtener la recomendaci�n
        String recomendacion = recomendarActividad(usuario, condiciones, espacio);
        
        // Mostrar la recomendaci�n
        System.out.println(recomendacion);
    
	}
	 // M�todo para generar la recomendaci�n de actividad
    public static String recomendarActividad(Usuario usuario, CondicionesMeteorologicas condiciones, Espacio espacio) {
        // Verificaci�n del estado de salud del usuario
        if (!usuario.estaSano || usuario.tieneSintomas || usuario.contactoInfectados || !usuario.pasaporteCovid) {
            return "No puedes realizar ninguna actividad.";
        }

        // Condiciones meteorol�gicas
        double temperatura = condiciones.temperatura;
        double humedad = condiciones.humedad;
        boolean precipitaciones = condiciones.precipitaciones;

        // Actividades basadas en condiciones meteorol�gicas
        if (temperatura < 0 && humedad < 15 && precipitaciones) {
            return "Quedarse en casa.";
        }

        if (temperatura < 0 && humedad < 15 && !precipitaciones) {
            if (espacio.aforo <= espacio.aforoMaximo) {
                return "Puedes ir a esquiar.";
            } else {
                return "El aforo est� completo para esquiar.";
            }
        }

        if (temperatura >= 0 && temperatura <= 15 && !precipitaciones) {
            if (espacio.aforo <= espacio.aforoMaximo) {
                return "Puedes ir a hacer senderismo.";
            } else {
                return "El aforo para senderismo est� completo.";
            }
        }

        if (temperatura >= 15 && temperatura <= 25 && !precipitaciones && humedad < 60) {
            if (!espacio.restriccionesConfinamiento) {
                return "Puedes hacer turismo al aire libre.";
            } else {
                return "No se puede realizar turismo al aire libre debido a restricciones.";
            }
        }

        if (temperatura >= 25 && temperatura <= 35 && !precipitaciones) {
            if (espacio.aforo <= espacio.aforoMaximo) {
                return "Puedes irte de ca�as.";
            } else {
                return "El establecimiento tiene problemas de aforo.";
            }
        }

        if (temperatura > 30 && !precipitaciones) {
            if (espacio.aforo <= espacio.aforoMaximo) {
                return "Puedes ir a la playa o a la piscina.";
            } else {
                return "El aforo de la piscina est� completo.";
            }
        }

        return "Condiciones meteorol�gicas no adecuadas para realizar actividades.";
    }

}
