package electrodomesticos;

/**
 * Este metodo define a Television como clase hija de electrodomestico, le
 * asigna todos sus atributos y ademas le genera dos nuevos atributos resolucion
 * y sintonizadorTDT. Posee un metodo precioFinal que agrega un delta adicional
 * al precio de acuerdo a la resolucion y/o el sintonizadorTDT
 * 
 * @author Manuel Lillo Blanco
 *
 */
public class Television extends Electrodomestico {

	public final static float RESOLUCION_DEFECTO = 20;
	public final static boolean SINTONIZADOR_TDT_DEFECTO = false;
	public final static float PORCENTAJE_AUMENTO_PRECIO_RESOLUCION = 0.3f;
	public final static float DELTA_PRECIO_SINTONIZADOR_TDT = 50f;
	public final static float LIMITE_RESOLUCION = 40f;

	private float resolucion;
	private boolean sintonizadorTDT;

	public Television() {

		super();
		this.resolucion = RESOLUCION_DEFECTO;
		this.sintonizadorTDT = SINTONIZADOR_TDT_DEFECTO;

	}

	public Television(float precioBase, float peso) {

		super(precioBase, peso);
		this.resolucion = RESOLUCION_DEFECTO;
		this.sintonizadorTDT = SINTONIZADOR_TDT_DEFECTO;

	}

	public Television(float resolucion, boolean sintonizadorTDT) {

		super();
		this.resolucion = resolucion;
		this.sintonizadorTDT = sintonizadorTDT;

	}

	// GETTERS

	public float getResolucion() {
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
	public float precioFinal() {

		float precioFinal = super.precioFinal();

		if (this.resolucion > LIMITE_RESOLUCION) {
			precioFinal += precioFinal * PORCENTAJE_AUMENTO_PRECIO_RESOLUCION;
		}

		if (this.sintonizadorTDT) {
			precioFinal += DELTA_PRECIO_SINTONIZADOR_TDT;
		}

		return precioFinal;

	}

}
