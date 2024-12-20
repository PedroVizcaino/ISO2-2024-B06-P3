package ESI.BC06_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EspacioTest {

    private Espacio espacio;

    // Método que se ejecuta antes de cada prueba
    @BeforeEach
    public void setUp() {
        // Inicializamos el objeto Espacio con valores de prueba
        espacio = new Espacio(50, 100, true);
    }

    // Test para verificar la correcta asignación y obtención de aforo
    @Test
    public void testGetAforo() {
        assertEquals(50, espacio.getAforo(), "El aforo no es correcto.");
    }

    // Test para verificar la correcta asignación y obtención del aforo máximo
    @Test
    public void testGetAforoMaximo() {
        assertEquals(100, espacio.getAforoMaximo(), "El aforo máximo no es correcto.");
    }

    // Test para verificar la correcta asignación y obtención de restricciones de confinamiento
    @Test
    public void testIsRestriccionesConfinamiento() {
        assertTrue(espacio.isRestriccionesConfinamiento(), "Las restricciones de confinamiento deberían ser verdaderas.");
    }

    // Test para verificar el comportamiento con otros valores
    @Test
    public void testValoresAlternativos() {
        Espacio espacioAlternativo = new Espacio(30, 50, false);

        assertEquals(30, espacioAlternativo.getAforo(), "El aforo alternativo no es correcto.");
        assertEquals(50, espacioAlternativo.getAforoMaximo(), "El aforo máximo alternativo no es correcto.");
        assertFalse(espacioAlternativo.isRestriccionesConfinamiento(), "Las restricciones de confinamiento alternativo deberían ser falsas.");
    }

    // Test para verificar que el aforo no puede superar el aforo máximo
    @Test
    public void testAforoNoExcedaMaximo() {
        espacio = new Espacio(120, 100, true); // Aforo mayor que el máximo
        assertTrue(espacio.getAforo() <= espacio.getAforoMaximo(), "El aforo no debe exceder el aforo máximo.");
    }
}
