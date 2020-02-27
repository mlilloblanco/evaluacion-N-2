package electrodomesticos;

import java.util.Arrays;

/**
 * Superclase electrodomestico que hereda atributos y metodos a sus hijas
 * 
 * @author Manuel Lillo Blanco
 *
 */
public class Electrodomestico {

    public final static int PRECIO_BASE_DEFECTO = 100000;
    public final static String COLOR_DEFECTO = "blanco";
    public final static char CONSUMO_ENERGETICO_DEFECTO = 'F';
    public final static int PESO_DEFECTO = 5;
    public final static Character[] LETRAS_CONSUMO_ENERGETICO = { 'A', 'B', 'C', 'D', 'E', 'F' };
    public final static String[] COLORES_DISPONIBLES = { "blanco", "negro", "rojo", "azul", "gris" };
    public final static int [] DELTA_PRECIO_CONSUMO_ENERGETICO = { 100, 80, 60, 50, 30, 10 };
    public final static int [] DELTA_PRECIO_PESO = { 10, 50, 80, 100 };

    private int precioBase;
    private String color;
    private char consumoEnergetico;
    private int peso;

    public Electrodomestico() {
	this.precioBase = PRECIO_BASE_DEFECTO;
	this.color = COLOR_DEFECTO;
	this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
	this.peso = PESO_DEFECTO;
	//precioFinal();
	
    }

    public Electrodomestico(int precioBase, int peso) {
	this.precioBase = precioBase;
	this.color = COLOR_DEFECTO;
	this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
	this.peso = peso;
	//precioFinal();
    }

    public Electrodomestico(int precioBase, String color, char consumoEnergetico, int peso) {
	this.precioBase = precioBase;
	comprobarColor(color);
	comprobarConsumoEnergetico(consumoEnergetico);
	this.peso = peso;
	//precioFinal();
		
    }

    // GETTERS

    public int getPrecioBase() {
	return precioBase;
    }

    public String getColor() {
	return color;
    }

    public char getConsumoEnergetico() {
	return consumoEnergetico;
    }

    public int getPeso() {
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
     * este metodo agrega al precio base un delta dependiendo de su peso o
     * eficiencia energetica
     */
    public int precioFinal() {
	
	int precioFinal = this.precioBase;
		
	if (this.peso >= 0 && this.peso <= 19) {
	    precioFinal += DELTA_PRECIO_PESO[0];
	} else if (this.peso >= 20 && this.peso <= 49)
	    precioFinal += DELTA_PRECIO_PESO[1];
	else if (this.peso >= 50 && this.peso <= 79)
	    precioFinal += DELTA_PRECIO_PESO[2];
	else if (this.peso >= 80)
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
