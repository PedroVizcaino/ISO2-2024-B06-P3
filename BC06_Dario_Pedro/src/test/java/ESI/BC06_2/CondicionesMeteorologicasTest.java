package ESI.BC06_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CondicionesMeteorologicasTest {

    private CondicionesMeteorologicas condiciones;

    // Método que se ejecuta antes de cada prueba
    @BeforeEach
    public void setUp() {
        // Inicializamos el objeto CondicionesMeteorologicas con valores de prueba
        condiciones = new CondicionesMeteorologicas(25.5, 80.0, true);
    }

    // Test para verificar la correcta asignación y obtención de temperatura
    @Test
    public void testGetTemperatura() {
        assertEquals(25.5, condiciones.getTemperatura(), "La temperatura no es correcta.");
    }

    // Test para verificar la correcta asignación y obtención de humedad
    @Test
    public void testGetHumedad() {
        assertEquals(80.0, condiciones.getHumedad(), "La humedad no es correcta.");
    }

    // Test para verificar la correcta asignación y obtención de precipitaciones
    @Test
    public void testIsPrecipitaciones() {
        assertTrue(condiciones.isPrecipitaciones(), "Las precipitaciones deberían ser verdaderas.");
    }

    // Test para verificar el comportamiento con otros valores
    @Test
    public void testValoresAlternativos() {
        CondicionesMeteorologicas condicionesAlternativas = new CondicionesMeteorologicas(15.0, 60.0, false);

        assertEquals(15.0, condicionesAlternativas.getTemperatura(), "La temperatura alternativa no es correcta.");
        assertEquals(60.0, condicionesAlternativas.getHumedad(), "La humedad alternativa no es correcta.");
        assertFalse(condicionesAlternativas.isPrecipitaciones(), "Las precipitaciones alternativas deberían ser falsas.");
    }
}
