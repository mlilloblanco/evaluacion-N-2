package electrodomesticos;

import java.util.Arrays;

/**
 * Superclase electrodomestico que contiene los atributos precio base, color,
 * consumo Energetico y peso los cuales sirven para determinar un precio final
 * segun su eficiencia energetica y su peso.
 * 
 * @author Manuel Lillo Blanco
 *
 */
public class Electrodomestico {

	// dado que 100.000 parecen ser pesos se hace la transformacion a 113 euros
	// (1 euro = 882.78 pesos)
	public final static float PRECIO_BASE_DEFECTO = 113;
	public final static String COLOR_DEFECTO = "blanco";
	public final static char CONSUMO_ENERGETICO_DEFECTO = 'F';
	public final static float PESO_DEFECTO = 5;
	public final static Character[] LETRAS_CONSUMO_ENERGETICO = { 'A', 'B', 'C', 'D', 'E', 'F' };
	public final static String[] COLORES_DISPONIBLES = { "blanco", "negro", "rojo", "azul", "gris" };
	public final static float[] DELTA_PRECIO_CONSUMO_ENERGETICO = { 100, 80, 60, 50, 30, 10 };
	public final static float[] DELTA_PRECIO_PESO = { 10, 50, 80, 100 };
	public final static float[] LIMITES_PESO = { 0, 19, 20, 49, 50, 79, 80 };

	private float precioBase;
	private String color;
	private char consumoEnergetico;
	private float peso;

	public Electrodomestico() {
		this.precioBase = PRECIO_BASE_DEFECTO;
		this.color = COLOR_DEFECTO;
		this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
		this.peso = PESO_DEFECTO;
		// precioFinal();

	}

	// se redondea peso para que no exista posibilidad de que quede fuera de los
	// margenes establecidos
	public Electrodomestico(float precioBase, float peso) {

		this.precioBase = precioBase;
		this.color = COLOR_DEFECTO;
		this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
		this.peso = Math.round(peso);

	}

	// se redondea peso para que no exista posibilidad de que quede fuera de los
	// margenes establecidos
	public Electrodomestico(float precioBase, String color, char consumoEnergetico, float peso) {

		this.precioBase = precioBase;
		comprobarColor(color);
		comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = Math.round(peso);

	}

	// GETTERS

	public float getPrecioBase() {
		return precioBase;
	}

	public String getColor() {
		return color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public float getPeso() {
		return peso;
	}

	// METODOS

	/**
	 * Este metodo verifica que la letra ingresada como consumo eficiente este
	 * dentro del rango de valores posibles y si se ingresa minuscula la transforma
	 * a mayuscula
	 * 
	 * @param letra letra ingresada por el usuario al preguntar el consumo
	 *              energetico del electrodomestico
	 */
	private void comprobarConsumoEnergetico(char letra) {

		char letraMayuscula = Character.toUpperCase(letra);
		boolean estaPermitida = Arrays.asList(LETRAS_CONSUMO_ENERGETICO).contains(letraMayuscula);

		if (!estaPermitida) {
			this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
		} else {
			this.consumoEnergetico = letraMayuscula;
		}
	}

	/**
	 * Este metodo valida que el color ingresado por el usuario (transformado a
	 * minusculas) este disponible en la gama de electrodomesticos
	 * 
	 * @param color color ingresado por el usuario
	 */
	private void comprobarColor(String color) {

		boolean estaPermitida = Arrays.asList(COLORES_DISPONIBLES).contains(color.toLowerCase());
		if (!estaPermitida) {
			this.color = COLOR_DEFECTO;
		} else {
			this.color = color.toLowerCase();
		}
	}

	/**
	 * este metodo agrega al precio base un delta dependiendo de su peso y/o
	 * eficiencia energetica
	 * 
	 * @return devuelve el precio final con el delta ya agregado
	 */
	public float precioFinal() {

		float precioFinal = this.precioBase;

		if (this.peso >= LIMITES_PESO[0] && this.peso <= LIMITES_PESO[1]) {
			precioFinal += DELTA_PRECIO_PESO[0];
		} else if (this.peso >= LIMITES_PESO[2] && this.peso <= LIMITES_PESO[3])
			precioFinal += DELTA_PRECIO_PESO[1];
		else if (this.peso >= LIMITES_PESO[4] && this.peso <= LIMITES_PESO[5])
			precioFinal += DELTA_PRECIO_PESO[2];
		else if (this.peso >= LIMITES_PESO[6])
			precioFinal += DELTA_PRECIO_PESO[3];
		else
			System.out.println("ingresaste un numero negativo, se te mantendra automaticamente el precio base");

		switch (this.consumoEnergetico) {
		case 'A':
			precioFinal += DELTA_PRECIO_CONSUMO_ENERGETICO[0];
			break;
		case 'B':
			precioFinal += DELTA_PRECIO_CONSUMO_ENERGETICO[1];
			break;
		case 'C':
			precioFinal += DELTA_PRECIO_CONSUMO_ENERGETICO[2];
			break;
		case 'D':
			precioFinal += DELTA_PRECIO_CONSUMO_ENERGETICO[3];
			break;
		case 'E':
			precioFinal += DELTA_PRECIO_CONSUMO_ENERGETICO[4];
			break;
		case 'F':
			precioFinal += DELTA_PRECIO_CONSUMO_ENERGETICO[5];
			break;
		}

		return precioFinal;

	}
}
