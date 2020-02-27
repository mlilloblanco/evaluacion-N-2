package electrodomesticos;

public class Television extends Electrodomestico {

    public final static int RESOLUCION_DEFECTO = 20;
    public final static boolean SINTONIZADOR_TDT_DEFECTO = false;
    public final static float PORCENTAJE_AUMENTO_PRECIO_RESOLUCION = 0.3f;
    public final static int DELTA_PRECIO_SINTONIZADOR_TDT = 50;

    private int resolucion;
    private boolean sintonizadorTDT;

    public Television() {
	super();
	this.resolucion = RESOLUCION_DEFECTO;
	this.sintonizadorTDT = SINTONIZADOR_TDT_DEFECTO;
	//precioFinal();
    }

    public Television(int precioBase, int peso) {
	super(precioBase, peso);
	this.resolucion = RESOLUCION_DEFECTO;
	this.sintonizadorTDT = SINTONIZADOR_TDT_DEFECTO;
	//precioFinal();
    }

    public Television(int resolucion, boolean sintonizadorTDT) {
	super();
	this.resolucion = resolucion;
	this.sintonizadorTDT = sintonizadorTDT;
	//precioFinal();
	//System.out.println("el precio es:" + precioFinal());
    }

    // GETTERS

    public int getResolucion() {
	return resolucion;
    }

    public boolean isSintonizadorTDT() {
	return sintonizadorTDT;
    }

    // METODOS

    /**
     * Este metodo le hace un override al metodo padre para poder llamarlo y
     * agregarle el delta del precio por resolucion. Primero agrega el aumento
     * porcentual por resolucion sobre la base existente y luego agrega el delta por
     * TDT
     */
    @Override
    public int precioFinal() {

	int precioFinal = super.precioFinal();

	if (this.resolucion > 40) {
	    precioFinal += (int) (precioFinal * PORCENTAJE_AUMENTO_PRECIO_RESOLUCION);
	}

	if (this.sintonizadorTDT) {
	    precioFinal += DELTA_PRECIO_SINTONIZADOR_TDT;
	}

	return precioFinal;

    }

}
