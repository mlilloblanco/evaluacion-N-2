package electrodomesticos;

public class Lavadora extends Electrodomestico {

    public final static int CARGA_DEFECTO = 5;
    public final static int DELTA_PRECIO_CARGA_30KG = 50;

    private int carga;

    public Lavadora() {
	super();
	this.carga = 5;
	//precioFinal();
    }

    public Lavadora(int precioBase, int peso) {
	super(precioBase, peso);
	this.carga = 5;
	//precioFinal();
    }

    public Lavadora(int carga) {
	super();
	this.carga = carga;
	//precioFinal();
	//System.out.println("el precio final es " + precioFinal());
    }

    // GETTERS

    public int getCarga() {
	return carga;
    }

    // METODOS
    /**
     * Este metodo le hace un override al metodo padre para poder llamarlo y
     * agregarle el delta del precio por carga
     */
    @Override
    public int precioFinal() {

	int precioFinal = super.precioFinal();

	if (this.carga > 30) {
	    precioFinal += DELTA_PRECIO_CARGA_30KG;
	}
	return precioFinal;

    }

}
