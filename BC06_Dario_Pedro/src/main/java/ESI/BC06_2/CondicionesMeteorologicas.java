package ESI.BC06_2;


//clase para representar las condiciones meteorol�gicas
public class CondicionesMeteorologicas {
	
	double temperatura;
    double humedad;
    boolean precipitaciones;

    public CondicionesMeteorologicas(double temperatura, double humedad, boolean precipitaciones) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.precipitaciones = precipitaciones;
    }

	public double getTemperatura() {
		return temperatura;
	}

	public double getHumedad() {
		return humedad;
	}

	public boolean isPrecipitaciones() {
		return precipitaciones;
	}

}
