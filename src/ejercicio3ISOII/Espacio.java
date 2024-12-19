package ejercicio3ISOII;
// clase para representar las características del espacio
public class Espacio {

	int aforo;
    int aforoMaximo;
    boolean restriccionesConfinamiento;

    public Espacio(int aforo, int aforoMaximo, boolean restriccionesConfinamiento) {
        this.aforo = aforo;
        this.aforoMaximo = aforoMaximo;
        this.restriccionesConfinamiento = restriccionesConfinamiento;
    }

	public int getAforo() {
		return aforo;
	}

	public int getAforoMaximo() {
		return aforoMaximo;
	}

	public boolean isRestriccionesConfinamiento() {
		return restriccionesConfinamiento;
	}

    
}
