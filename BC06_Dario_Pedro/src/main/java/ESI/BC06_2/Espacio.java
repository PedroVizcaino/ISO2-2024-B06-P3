package ESI.BC06_2;
// clase para representar las caracter�sticas del espacio
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
