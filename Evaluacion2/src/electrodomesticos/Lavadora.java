package electrodomesticos;

/**
 * Este metodo define a Lavadora como clase hija de electrodomestico, le asigna
 * todos sus atributos y ademas le genera un nuevo atributo propio llamado
 * carga. Ademas posee un nuevo metodo precioFinal que agrega un delta adicional
 * al precio de acuerdo a la carga de la lavadora
 * 
 * @author Manuel Lillo Blanco
 *
 */
public class Lavadora extends Electrodomestico {

	public final static float CARGA_DEFECTO = 5;
	public final static float DELTA_PRECIO_CARGA_30KG = 50;

	private float carga;

	public Lavadora() {

		super();
		this.carga = CARGA_DEFECTO;
	}

	public Lavadora(float precioBase, float peso) {

		super(precioBase, peso);
		this.carga = CARGA_DEFECTO;
	}

	public Lavadora(float carga) {

		super();
		this.carga = carga;
	}

	// GETTERS

	public float getCarga() {
		return carga;
	}

	// METODOS
	/**
	 * Este metodo le hace un override al metodo padre para poder llamarlo y
	 * agregarle el delta del precio por carga
	 */
	@Override
	public float precioFinal() {

		float precioFinal = super.precioFinal();

		if (this.carga > 30) {
			precioFinal += DELTA_PRECIO_CARGA_30KG;
		}
		return precioFinal;

	}

}
