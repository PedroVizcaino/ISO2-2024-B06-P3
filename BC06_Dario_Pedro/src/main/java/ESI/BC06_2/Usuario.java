package ESI.BC06_2;
//clase para representar el estado de salud del usuario
public class Usuario {

	 boolean estaSano;
     boolean tieneSintomas;
     boolean contactoInfectados;
     boolean pasaporteCovid;

     public Usuario(boolean estaSano, boolean tieneSintomas, boolean contactoInfectados, boolean pasaporteCovid) {
         this.estaSano = estaSano;
         this.tieneSintomas = tieneSintomas;
         this.contactoInfectados = contactoInfectados;
         this.pasaporteCovid = pasaporteCovid;
     }

	public boolean isEstaSano() {
		return estaSano;
	}

	public boolean isTieneSintomas() {
		return tieneSintomas;
	}

	public boolean isContactoInfectados() {
		return contactoInfectados;
	}

	public boolean isPasaporteCovid() {
		return pasaporteCovid;
	}

}
