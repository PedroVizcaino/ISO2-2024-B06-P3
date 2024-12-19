package ejercicio3ISOII;

public class Principal {

	public static void main(String[] args) {
		
		 // Crear un usuario ejemplo
        Usuario usuario = new Usuario(true, false, false, true);

        // Crear las condiciones meteorológicas ejemplo
        CondicionesMeteorologicas condiciones = new CondicionesMeteorologicas(20, 50, false);

        // Crear las características del espacio ejemplo
        Espacio espacio = new Espacio(10, 50, false);

        // Obtener la recomendación
        String recomendacion = recomendarActividad(usuario, condiciones, espacio);
        
        // Mostrar la recomendación
        System.out.println(recomendacion);
    
	}
	 // Método para generar la recomendación de actividad
    public static String recomendarActividad(Usuario usuario, CondicionesMeteorologicas condiciones, Espacio espacio) {
        // Verificación del estado de salud del usuario
        if (!usuario.estaSano || usuario.tieneSintomas || usuario.contactoInfectados || !usuario.pasaporteCovid) {
            return "No puedes realizar ninguna actividad.";
        }

        // Condiciones meteorológicas
        double temperatura = condiciones.temperatura;
        double humedad = condiciones.humedad;
        boolean precipitaciones = condiciones.precipitaciones;

        // Actividades basadas en condiciones meteorológicas
        if (temperatura < 0 && humedad < 15 && precipitaciones) {
            return "Quedarse en casa.";
        }

        if (temperatura < 0 && humedad < 15 && !precipitaciones) {
            if (espacio.aforo <= espacio.aforoMaximo) {
                return "Puedes ir a esquiar.";
            } else {
                return "El aforo está completo para esquiar.";
            }
        }

        if (temperatura >= 0 && temperatura <= 15 && !precipitaciones) {
            if (espacio.aforo <= espacio.aforoMaximo) {
                return "Puedes ir a hacer senderismo.";
            } else {
                return "El aforo para senderismo está completo.";
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
                return "Puedes irte de cañas.";
            } else {
                return "El establecimiento tiene problemas de aforo.";
            }
        }

        if (temperatura > 30 && !precipitaciones) {
            if (espacio.aforo <= espacio.aforoMaximo) {
                return "Puedes ir a la playa o a la piscina.";
            } else {
                return "El aforo de la piscina está completo.";
            }
        }

        return "Condiciones meteorológicas no adecuadas para realizar actividades.";
    }

}
