package ESI.BC06_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;
    private CondicionesMeteorologicas condiciones;
    private Espacio espacio;

    // Se ejecuta antes de cada test
    @BeforeEach
    public void setUp() {
        // Inicialización de los objetos con valores de prueba
        usuario = new Usuario(true, false, false, true);  // Usuario sano, sin síntomas, sin contacto y con pasaporte Covid
        condiciones = new CondicionesMeteorologicas(20, 50, false);  // Condiciones meteorológicas ejemplo
        espacio = new Espacio(10, 50, false);  // Espacio con aforo 10 de 50 máximo y sin restricciones
    }

    // Test de la recomendación para un usuario sano y condiciones favorables
    @Test
    public void testRecomendarActividadCondicionesNormales() {
        // El usuario está sano, el espacio tiene aforo y las condiciones meteorológicas son aceptables.
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("Puedes ir a hacer senderismo.", recomendacion, "La recomendación para las condiciones normales debería ser hacer senderismo.");
    }

    // Test para un caso con temperatura muy baja y condiciones que requieren quedarse en casa
    @Test
    public void testRecomendarActividadCondicionesFrías() {
        condiciones = new CondicionesMeteorologicas(-5, 10, true);  // Baja temperatura, poca humedad y precipitaciones
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("Quedarse en casa.", recomendacion, "La recomendación para condiciones frías y con precipitaciones debería ser quedarse en casa.");
    }

    // Test para un caso con aforo completo para una actividad
    @Test
    public void testRecomendarActividadAforoCompleto() {
        espacio = new Espacio(60, 50, false);  // El aforo es mayor que el máximo permitido
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("El aforo está completo para esquiar.", recomendacion, "La recomendación debería ser que el aforo está completo para esquiar.");
    }

    // Test para una actividad con restricciones por confinamiento
    @Test
    public void testRecomendarActividadConRestricciones() {
        espacio = new Espacio(30, 50, true);  // Restricciones de confinamiento activas
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("No se puede realizar turismo al aire libre debido a restricciones.", recomendacion, "La recomendación debería ser que no se puede hacer turismo debido a restricciones.");
    }

    // Test para condiciones muy cálidas que permiten ir a la playa
    @Test
    public void testRecomendarActividadCondicionesCálidas() {
        condiciones = new CondicionesMeteorologicas(35, 30, false);  // Alta temperatura, sin precipitaciones
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("Puedes ir a la playa o a la piscina.", recomendacion, "La recomendación debería ser ir a la playa o piscina.");
    }

    // Test para aforo completo en la piscina
    @Test
    public void testRecomendarActividadAforoPiscinaCompleto() {
        condiciones = new CondicionesMeteorologicas(35, 30, false);  // Alta temperatura, sin precipitaciones
        espacio = new Espacio(60, 50, false);  // Aforo completo para la piscina
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("El aforo de la piscina está completo.", recomendacion, "La recomendación debería ser que el aforo de la piscina está completo.");
    }

    // Test para un caso con usuario enfermo
    @Test
    public void testRecomendarActividadUsuarioEnfermo() {
        usuario = new Usuario(false, true, false, true);  // Usuario enfermo
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("No puedes realizar ninguna actividad.", recomendacion, "El usuario enfermo no debería poder realizar ninguna actividad.");
    }

    // Test para un caso con usuario que tuvo contacto con infectados
    @Test
    public void testRecomendarActividadContactoConInfectados() {
        usuario = new Usuario(true, false, true, true);  // Usuario sano pero en contacto con infectados
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("No puedes realizar ninguna actividad.", recomendacion, "El usuario con contacto con infectados no debería poder realizar ninguna actividad.");
    }

    // Test para un caso con usuario sin pasaporte Covid
    @Test
    public void testRecomendarActividadSinPasaporteCovid() {
        usuario = new Usuario(true, false, false, false);  // Usuario sano pero sin pasaporte Covid
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("No puedes realizar ninguna actividad.", recomendacion, "El usuario sin pasaporte Covid no debería poder realizar ninguna actividad.");
    }

    // Test para un usuario con síntomas
    @Test
    public void testRecomendarActividadUsuarioConSintomas() {
        usuario = new Usuario(true, true, false, true);  // Usuario con síntomas
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("No puedes realizar ninguna actividad.", recomendacion, "El usuario con síntomas no debería poder realizar ninguna actividad.");
    }

    // Test para un usuario que está sano, tiene pasaporte Covid, sin síntomas ni contacto con infectados
    @Test
    public void testRecomendarActividadUsuarioSano() {
        usuario = new Usuario(true, false, false, true);  // Usuario sano con pasaporte Covid
        condiciones = new CondicionesMeteorologicas(20, 50, false);  // Condiciones meteorológicas normales
        espacio = new Espacio(10, 50, false);  // Espacio con aforo disponible
        String recomendacion = Principal.recomendarActividad(usuario, condiciones, espacio);
        assertEquals("Puedes ir a hacer senderismo.", recomendacion, "El usuario sano debería poder realizar senderismo.");
    }
}
