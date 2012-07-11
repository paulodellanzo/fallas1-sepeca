package rules;

public class Car {

	private int selected;
	private int id;
	private String marca;
	private String modelo;
	private String version;
	private int precio;
	private String foto;
	private int farosDelanteros;
	private int farosAntiniebla;
	private int abs;
	private int airbagConductor;
	private int airbagAcomp;
	private int cinturones;
	private int balizaAut;
	private int sensorLluvia;
	private int camaraTrasera;
	private int aireAcondicionado;
	private int asientosDelanteros;
	private int cierrePuertas;
	private int espejosExternos;
	private int computadoraABordo;
	private int gps;
	private int tapizado;
	private int vidrios;
	private int palancaCambio;
	private int encSinLlave;
	private int equipoMusica;
	private int parlantes;
	private int bluetooth;
	private int conexionAuxiliar;
	private int conexionUsb;
	private int controlPorVoz;
	private int comandoSatelital;
	private int llantas;
	//Nafta, Diesel o Hibrido
	private String combustible;
	private int velocidad;
	//Es la cantidad de asientos, no va de 0 a 5
	private int cantAsientos;
	private int frenos;
	private int velocidadCrucero;
	//Es el tamaño del rodado, no va de 0 a 5
	private int neumaticos;
	private int direccion;
	private int capacidadCarga;
	private int transmision;
	private int tanque;
	private int largo;
	private int ancho;
	private int alto;
	
	public Car(){
		
	}
	
	public Car(String[] characteristics) {
		id=Integer.parseInt(characteristics[0].trim());
		selected=0;
		marca=characteristics[1];
		
		modelo=characteristics[2];
		
		version=characteristics[3];
		
		String stringPrecio=characteristics[4];
		
		if(stringPrecio.length() > 0) {
			
			if(stringPrecio.substring(0, 1).compareTo("p")==0){
				precio=Integer.parseInt(stringPrecio.substring(1));
			} else {
				precio=Integer.parseInt(stringPrecio.substring(1)) * 5;
			}
			
		} else {
			precio=0;
		}
		
		foto=characteristics[6];
		
		farosDelanteros=rangoFarosDelanteros(characteristics);
		
		farosAntiniebla=rangoFarosAntiniebla(characteristics);
		
		abs=rangoBooleano(characteristics[63]);
		
		airbagConductor=rangoAirbagConductor(characteristics);
		
		airbagAcomp=rangoAirbagAcomp(characteristics);
		
		cinturones= rangoCinturones(characteristics);
		
		balizaAut=rangoBooleano(characteristics[72]);
		
		sensorLluvia=rangoBooleano(characteristics[71]);
		
		camaraTrasera=rangoBooleano(characteristics[73]);
		
		aireAcondicionado=rangoAireAcondicionado(characteristics);
		
		asientosDelanteros=rangoAsientosDelanteros(characteristics);
		
		cierrePuertas=rangocierrePuertas(characteristics);
		
		espejosExternos=rangoEspejosExternos(characteristics);
		
		computadoraABordo=rangoBooleano(characteristics[56]);
		
		gps=rangoGps(characteristics);
		
		tapizado=rangoTapizado(characteristics);
		
		vidrios=rangoVidrios(characteristics);
		
		palancaCambio=rangoPalancaCambio(characteristics);
		
		encSinLlave=rangoBooleano(characteristics[62]);
		
		equipoMusica=rangoEquipoMusica(characteristics);
		
		parlantes=rangoParlantes(characteristics);
		
		bluetooth=rangoBooleano(characteristics[77]);
		
		conexionAuxiliar=rangoBooleano(characteristics[78]);
		
		conexionUsb=rangoBooleano(characteristics[79]);
		
		controlPorVoz=rangoBooleano(characteristics[80]);
		
		comandoSatelital=rangoComandoSatelital(characteristics);
		
		llantas=rangoLlantas(characteristics);
		
		combustible=characteristics[9];
		if(combustible.matches(".*Eléctrico.*")) combustible="Hibrido";
		
		velocidad=rangoVelocidad(characteristics);
		
		cantAsientos=rangoCantAsientos(characteristics);
		
		frenos=rangoFrenos(characteristics);
		
		velocidadCrucero=rangoBooleano(characteristics[55]);
		
		neumaticos=rangoNeumaticos(characteristics);
		
		direccion=rangoDireccion(characteristics);
		
		capacidadCarga=rangoCapacidadCarga(characteristics);
		
		transmision=rangoTransmision(characteristics);
	}
	
	private int rangoTransmision(String[] characteristics) {
		String caja = characteristics[19].trim();
		
		if (caja.matches(".*Automática secuencial.*")) {
			return 5;
		} else if (caja.matches(".*Automática.*")) {
			return 4;
		} else if (caja.matches(".*ronic.*")) {
			return 3;
		} else if (caja.matches(".*DSG.*")) {
			return 2;
		} else if (caja.matches(".*Manual.*")) {
			return 1;
		}
		return 0;
	}

	private int rangoCapacidadCarga(String[] characteristics) {
		int capacidad = 0;
		try {
			capacidad=Integer.parseInt(characteristics[42].trim());
		} catch (NumberFormatException e) {
			capacidad=0;
		}
		
		if(capacidad>300 && capacidad<=600){
			return 1;
		} else if (capacidad>600 && capacidad<=900) {
			return 2;
		} else if (capacidad>900 && capacidad<=1200) {
			return 3;
		} else if (capacidad>1200 && capacidad<=1600) {
			return 4;
		} else if (capacidad>1600) {
			return 5;
		}
		return 0;
	}

	private int rangoDireccion(String[] characteristics) {
		String dir = characteristics[47].trim();
		if (dir.matches(".*lectr.*") || dir.matches(".*léctr.*")) {
			return 5;
		} else if (dir.matches(".*Servo.*")) {
			return 4;
		} else if (dir.matches(".*Asistida.*")) {
			return 3;
		} else if (dir.matches(".*Hidráulica.*")) {
			return 2;
		}
		return 0;
	}

	private int rangoNeumaticos(String[] characteristics) {
		int rodado = 0;
		String rod = characteristics[24].trim();
		if(!rod.equals("")) rodado = Integer.parseInt(rod);
		return rodado;
	}

	private int rangoFrenos(String[] characteristics) {
		String frenos = characteristics[20];
		if(frenos.matches(".*tambor.*")) {
			return 1;
		} else if (frenos.matches(".*ventilados.*ventilados.*")) {
			return 5;
		} else if (frenos.matches(".*ventilados.*")) {
			return 4;
		} else if (frenos.matches(".*Discos.*")) {
			return 3;
		}
		return 0;
	}

	private int rangoCantAsientos(String[] characteristics) {
		int asientos = 2;
		String asientosTraseros = characteristics[44];
		if (asientosTraseros.matches(".*4ta.*")) {
			asientos = 11;
		} else if (asientosTraseros.matches(".*3ra.*") || asientosTraseros.matches(".*3er.*")) {
			asientos = 8;
		} else if (asientosTraseros.matches(".*..*")) {
			asientos = 5;
		}
		return asientos;
	}

	private int rangoVelocidad(String[] characteristics) {
		int velocidad = 0;
		try {
			velocidad=Integer.parseInt(characteristics[14]);
		} catch (NumberFormatException e) {
			velocidad=0;
		}
		
		if(velocidad>100 && velocidad<=142){
			return 1;
		} else if (velocidad>142 && velocidad<=184) {
			return 2;
		} else if (velocidad>184 && velocidad<=226) {
			return 3;
		} else if (velocidad>226 && velocidad<=268) {
			return 4;
		} else if (velocidad>268) {
			return 5;
		}
		return 0;
	}

	private int rangoLlantas(String[] characteristics) {
		String llantas = characteristics[51];
		if (llantas.matches(".*Aleación.*")) {
			return 5;
		} else if (llantas.matches(".*Acero.*")) {
			return 2;
		}
		return 0;
	}

	private int rangoComandoSatelital(String[] characteristics) {
		String equipoMusica = characteristics[74];
		if (equipoMusica.matches(".*Comando de audio satelital.*") || equipoMusica.matches(".*Comandos de audio al volante.*")) {
			return 5;
		}
		return 0;
	}

	private int rangoParlantes(String[] characteristics) {
		int parlantes = 0;
		try {
			parlantes=Integer.parseInt(characteristics[75]);
		} catch (NumberFormatException e) {
			parlantes=0;
		}
		if (parlantes==0) {
			return 0;
		} else if (parlantes<=2) {
			return 1;
		} else if (parlantes<=4) {
			return 2;
		} else if (parlantes<=6) {
			return 3;
		} else if (parlantes<=10) {
			return 4;
		} else if (parlantes<=50) {
			return 5;
		}
		return 0;
	}

	private int rangoEquipoMusica(String[] characteristics) {
		String palancaCambio = characteristics[74];
		if (palancaCambio.matches(".* 5.1.*")) {
			return 5;
		} else if (palancaCambio.matches(".*Sistema de sonido.*")) {
			return 4;
		} else if (palancaCambio.matches(".*tarjetas SD.*")) {
			return 3;
		} else if (palancaCambio.matches(".* de audio .*")) {
			return 2;
		} else if (palancaCambio.matches(".*Mp3.*")) {
			return 1;
		}
		return 0;
	}

	private int rangoPalancaCambio(String[] characteristics) {
		String palancaCambio = characteristics[57];
		if (palancaCambio.matches(".*volante.*")) {
			return 5;
		} else if (palancaCambio.matches(".*aluminio.*")) {
			return 2;
		} else if (palancaCambio.matches(".*cuero.*")) {
			return 1;
		}
		return 0;
	}

	private int rangoVidrios(String[] characteristics) {
		String vidrios = characteristics[53];
		if (vidrios.matches(".*Delanteros y traseros eléctricos.*")) {
			return 5;
		} else if (vidrios.matches(".*eléctricos.*")) {
			return 4;
		} else if (vidrios.matches(".*traseros manuales.*")) {
			return 2;
		} else if (vidrios.matches(".*manuales.*")) {
			return 1;
		}
		return 0;
	}

	private int rangoTapizado(String[] characteristics) {
		String tapizado = characteristics[52];
		if (tapizado.matches(".*Alcántara.*")) {
			return 5;
		} else if (tapizado.matches(".*Cuero.*")) {
			return 4;
		} else if (tapizado.matches(".*Gamuza.*") || tapizado.matches(".*Pana.*")) {
			return 3;
		} else if (tapizado.matches(".*Cuerina.*") || tapizado.matches(".*Simil cuero.*")) {
			return 2;
		} else if (tapizado.matches(".*deportivo.*")) {
			return 1;
		}
		return 0;
	}

	private int rangoGps(String[] characteristics) {
		String gps = characteristics[76];
		if(gps.matches(".*Navegador satelital.*") || gps.matches(".*MMI con pantalla color.*")) {
			return 5;
		} else if (gps.matches(".*navegación satelital.*")) {
			return 4;
		}
		return 0;
	}

	private int rangoEspejosExternos(String[] characteristics) {
		String espejo = characteristics[48];
		if(espejo.matches(".*plegado.*") || espejo.matches(".*enfoque.*")) {
			return 5;
		} else if (espejo.matches(".*térmicos.*")) {
			return 4;
		} else if (espejo.matches(".*léctricos.*")) {
			return 2;
		}
		return 0;
	}

	private int rangocierrePuertas(String[] characteristics) {
		String puertas = characteristics[46];
		int resultado = 0;
		if(puertas.matches(".*comando a distancia.*")) {
			resultado=3;
		} else if (puertas.matches(".*Centralizado.*")) {
			resultado=2;
		}
		if(puertas.matches(".*baúl.*")) resultado++;
		if(puertas.matches(".*tanque.*")) resultado++;
		
		return resultado;
	}

	private int rangoAsientosDelanteros(String[] characteristics){
		String asiento = characteristics[45];
		if(asiento.matches(".*masaje.*")) {
			return 5;
		} else if (asiento.matches(".*Calefaccionables.*")) {
			return 4;
		} else if (asiento.matches(".*eléctrico.*")) {
			return 3;
		} else if (asiento.matches(".*Deportivos.*")) {
			return 2;
		}
		return 0;
	}
		
	private int rangoAireAcondicionado(String[] characteristics){
		String aire = characteristics[43];
		if(aire.matches(".*de cuatro zonas.*")) {
			return 5;
		} else if (aire.matches(".*trizona.*")) {
			return 4;
		} else if (aire.matches(".*bizona.*")) {
			return 3;
		} else if (aire.matches(".*Climatizador.*")) {
			return 2;
		} else if (aire.matches(".*Aire acondicionado.*")) {
			return 1;
		}
		return 0;
	}
	
	private int rangoCinturones(String[] characteristics){
		String cinturon = characteristics[66];
		if(cinturon.matches(".*delanteros y traseros.*")) {
			return 5;
		} else if (cinturon.matches(".*delanteros.*")) {
			return 3;
		}
		return 0;
	}
	
	private int rangoAirbagConductor(String[] characteristics) {
		String airbag = characteristics[64];
		if(airbag.matches(".*odilla.*")) {
			return 5;
		} else if (airbag.matches(".*Cabeza.*")) {
			return 4;
		} else if (airbag.matches(".*Laterales delanteros y traseros.*")) {
			return 2;
		} else if (airbag.matches(".*Conductor.*")) {
			return 1;
		}
		return 0;
	}
	
	private int rangoAirbagAcomp(String[] characteristics) {
		String airbag = characteristics[64];
		if(airbag.matches(".*Rodilla conductor y acompañante.*")) {
			return 5;
		} else if (airbag.matches(".*Cabeza.*") || airbag.matches(".*rodilla.*")) {
			return 4;
		} else if (airbag.matches(".*Laterales delanteros y traseros.*")) {
			return 3;
		} else if (airbag.matches(".*Laterales delanteros.*")) {
			return 2;
		} else if (airbag.matches(".*Conductor y acompañante.*")) {
			return 1;
		}
		return 0;
	}
	
	private int rangoFarosAntiniebla(String[] characteristics) {
		String faros = characteristics[49];
		if(faros.matches(".*Delanteros y traseros.*")) {
			return 5;
		} else if (faros.matches(".*Delanteros.*")) {
			return 3;
		} else if (faros.matches(".*raseros.*")) {
			return 2;
		}
		return 0;
	}
	
	private int rangoFarosDelanteros(String[] characteristics){
		String faros = characteristics[50];
		
		if(faros.matches(".*Con regulación automática y lava faros.*") || faros.matches(".*Con regulación interna y lava faros.*")){
			return 5;
		} else if (faros.matches(".*Con regulación.*")){
			return 4;
		} else if (faros.matches(".*apagado automático.*") || faros.matches(".*encendido automático.*")) {
			return 3;
		} else if (faros.matches(".*Lavafaros.*")) {
			return 2;
		} else if (faros.matches(".*Faros fijos.*")) {
			return 1;
		}
		return 0;
	}
	
	private int rangoBooleano(String valor){
		if(valor.matches(".*si.*")){
			return 5;
		} else {
			return 0;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getFarosDelanteros() {
		return farosDelanteros;
	}

	public void setFarosDelanteros(int farosDelanteros) {
		this.farosDelanteros = farosDelanteros;
	}

	public int getFarosAntiniebla() {
		return farosAntiniebla;
	}

	public void setFarosAntiniebla(int farosAntiniebla) {
		this.farosAntiniebla = farosAntiniebla;
	}

	public int getAbs() {
		return abs;
	}

	public void setAbs(int abs) {
		this.abs = abs;
	}

	public int getAirbagConductor() {
		return airbagConductor;
	}

	public void setAirbagConductor(int airbagConductor) {
		this.airbagConductor = airbagConductor;
	}

	public int getAirbagAcomp() {
		return airbagAcomp;
	}

	public void setAirbagAcomp(int airbagAcomp) {
		this.airbagAcomp = airbagAcomp;
	}

	public int getCinturones() {
		return cinturones;
	}

	public void setCinturones(int cinturones) {
		this.cinturones = cinturones;
	}

	public int getBalizaAut() {
		return balizaAut;
	}

	public void setBalizaAut(int balizaAut) {
		this.balizaAut = balizaAut;
	}

	public int getSensorLluvia() {
		return sensorLluvia;
	}

	public void setSensorLluvia(int sensorLluvia) {
		this.sensorLluvia = sensorLluvia;
	}

	public int getCamaraTrasera() {
		return camaraTrasera;
	}

	public void setCamaraTrasera(int camaraTrasera) {
		this.camaraTrasera = camaraTrasera;
	}

	public int getAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(int aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public int getAsientosDelanteros() {
		return asientosDelanteros;
	}

	public void setAsientosDelanteros(int asientosDelanteros) {
		this.asientosDelanteros = asientosDelanteros;
	}

	public int getCierrePuertas() {
		return cierrePuertas;
	}

	public void setCierrePuertas(int cierrePuertas) {
		this.cierrePuertas = cierrePuertas;
	}

	public int getEspejosExternos() {
		return espejosExternos;
	}

	public void setEspejosExternos(int espejosExternos) {
		this.espejosExternos = espejosExternos;
	}

	public int getComputadoraABordo() {
		return computadoraABordo;
	}

	public void setComputadoraABordo(int computadoraABordo) {
		this.computadoraABordo = computadoraABordo;
	}

	public int getGps() {
		return gps;
	}

	public void setGps(int gps) {
		this.gps = gps;
	}

	public int getTapizado() {
		return tapizado;
	}

	public void setTapizado(int tapizado) {
		this.tapizado = tapizado;
	}

	public int getVidrios() {
		return vidrios;
	}

	public void setVidrios(int vidrios) {
		this.vidrios = vidrios;
	}

	public int getPalancaCambio() {
		return palancaCambio;
	}

	public void setPalancaCambio(int palancaCambio) {
		this.palancaCambio = palancaCambio;
	}

	public int getEncSinLlave() {
		return encSinLlave;
	}

	public void setEncSinLlave(int encSinLlave) {
		this.encSinLlave = encSinLlave;
	}

	public int getEquipoMusica() {
		return equipoMusica;
	}

	public void setEquipoMusica(int equipoMusica) {
		this.equipoMusica = equipoMusica;
	}

	public int getParlantes() {
		return parlantes;
	}

	public void setParlantes(int parlantes) {
		this.parlantes = parlantes;
	}

	public int getBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(int bluetooth) {
		this.bluetooth = bluetooth;
	}

	public int getConexionAuxiliar() {
		return conexionAuxiliar;
	}

	public void setConexionAuxiliar(int conexionAuxiliar) {
		this.conexionAuxiliar = conexionAuxiliar;
	}

	public int getConexionUsb() {
		return conexionUsb;
	}

	public void setConexionUsb(int conexionUsb) {
		this.conexionUsb = conexionUsb;
	}

	public int getControlPorVoz() {
		return controlPorVoz;
	}

	public void setControlPorVoz(int controlPorVoz) {
		this.controlPorVoz = controlPorVoz;
	}

	public int getComandoSatelital() {
		return comandoSatelital;
	}

	public void setComandoSatelital(int comandoSatelital) {
		this.comandoSatelital = comandoSatelital;
	}

	public int getLlantas() {
		return llantas;
	}

	public void setLlantas(int llantas) {
		this.llantas = llantas;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getCantAsientos() {
		return cantAsientos;
	}

	public void setCantAsientos(int cantAsientos) {
		this.cantAsientos = cantAsientos;
	}

	public int getFrenos() {
		return frenos;
	}

	public void setFrenos(int frenos) {
		this.frenos = frenos;
	}

	public int getVelocidadCrucero() {
		return velocidadCrucero;
	}

	public void setVelocidadCrucero(int velocidadCrucero) {
		this.velocidadCrucero = velocidadCrucero;
	}

	public int getNeumaticos() {
		return neumaticos;
	}

	public void setNeumaticos(int neumaticos) {
		this.neumaticos = neumaticos;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public int getTransmision() {
		return transmision;
	}

	public void setTransmision(int transmision) {
		this.transmision = transmision;
	}
	
	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public int getTanque() {
		return tanque;
	}

	public void setTanque(int tanque) {
		this.tanque = tanque;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
}
    
    