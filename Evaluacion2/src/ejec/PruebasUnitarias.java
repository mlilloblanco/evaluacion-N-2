package ejec;

import static org.junit.Assert.*;

import org.junit.Test;

import electrodomesticos.*;

public class PruebasUnitarias {

	/*
	 * se declara una variable e1 de tipo Electrodomestico
	 */
	Electrodomestico e1;

	/*
	 * dado que el metodo ComprobarConsumoEnergetico es privado se validara a traves
	 * del constructor de electrodomestico.
	 */
	@Test
	public void testComprobarConsumoEnergetico() {
		e1 = new Electrodomestico(150, "RoJo", 'C', 20);
		// primero se verifica con una letra dentro del rango de valores permitidos en
		// este caso la letra C.
		assertEquals('C', e1.getConsumoEnergetico());

		// luego se valida ingresando un valor que este fuera del rango permitido en
		// este caso la letra X
		e1 = new Electrodomestico(150, "RoJo", 'X', 20);
		// Dado que se instancia con una letra fuera del rango se debe generar la
		// instancia con la eficiencia energetica por defecto (F)
		assertEquals('F', e1.getConsumoEnergetico());

		// finalmente se valida que al ingresar una letra valida pero en minuscula es
		// considerada tambien como un ingreso correcto.
		e1 = new Electrodomestico(150, "RoJo", 'b', 20);
		assertEquals('B', e1.getConsumoEnergetico());
	}

	/*
	 * dado que el metodo ComprobarColor es privado se validara a traves del
	 * constructor de electrodomestico.
	 */
	@Test
	public void testComprobarColor() {
		e1 = new Electrodomestico(150, "azul", 'C', 20);
		// primero se verifica con un color dentro del rango permitido, en este caso
		// azul.
		assertEquals("azul", e1.getColor());

		// luego se valida ingresando un valor que este fuera del rango permitido en
		// este caso el color lila
		e1 = new Electrodomestico(150, "lila", 'X', 20);
		// Dado que se instancia con color fuera de la gama permitida se debe generar la
		// instancia con el color por defecto (blanco)
		assertEquals("blanco", e1.getColor());

		// finalmente se valida que al ingresar colores en mayusculas o mayusculas y
		// minisculas, se reconozca como valida y se muestre en minusculas
		e1 = new Electrodomestico(150, "RoJo", 'b', 20);
		assertEquals("rojo", e1.getColor());
	}

	/*
	 * se comprueba el metodo precio final de la clase padre validando diversas
	 * salidas de acuerdo a la eficiencia energetico y el peso del electrodomestico
	 */
	@Test
	public void testComprobarPrecioFinalElectrodomestico() {

		// primero se verifica el delta de la eficiencia energetica probando sus rangos
		// y manteniendo fijo el peso y le precio base. El resultado debe ser el precio
		// base (100) + cargo por eficiencia energetica A (100)+ cargo por peso (10)
		e1 = new Electrodomestico(100, "azul", 'A', 15);
		assertEquals(210, e1.precioFinal(), 0);

		// luego se valida ingresando una eficiencia energetica distinta (en este caso
		// B) y manteniendo el peso y el precio base
		e1 = new Electrodomestico(100, "azul", 'B', 15);
		// El resultado debe ser 100+80+10
		assertEquals(190, e1.precioFinal(), 0);

		// Luego se valida el delta de precio por peso, manteniendo fijo el precio base
		// y la eficiencia energetica
		e1 = new Electrodomestico(100, "azul", 'A', 30);
		assertEquals(250, e1.precioFinal(), 0);
	}

	@Test
	public void testComprobarPrecioFinalLavadora() {

		// se utliza el constructor en donde todo es por defecto excepto la carga de la
		// lavadora la cual primero se setea en 10 lo que implica que no deberia tener
		// cargo extra. El valor deberia ser el precio base por defecto (113),
		// eficiencia energetica F (10) y peso 5 (10)
		e1 = new Lavadora(10);
		assertEquals(133, e1.precioFinal(), 0);

		// luego se valida ingresando una carga sobre 30 lo que genera un cargo de 50
		e1 = new Lavadora(30.1f);
		// El resultado debe ser 113+10+10+50
		assertEquals(183, e1.precioFinal(), 0);

	}

	@Test
	public void testComprobarPrecioFinalTelevision() {

		// se utliza el constructor en donde todo es por defecto excepto la resolucion y
		// el sintonizadorTDT. Primero se setea el sintonizadorTDT en falso y una
		// resolucion menor a 40. Por lo tanto, el valor deberia ser el precio base por
		// defecto (113),
		// eficiencia energetica F (10) y peso 5 (10)
		e1 = new Television(20, false);
		assertEquals(133, e1.precioFinal(), 0);

		// luego se valida ingresando una resolucion sobre 40 lo que genera un cargo del
		// 30%
		e1 = new Television(41, false);
		// El resultado debe ser 113+10+10+(113+10+10)*0.3
		assertEquals(172.9, e1.precioFinal(), 0.1);

		// finalmente se valida el sintonizadorTDT seteandolo en verdadero y manteniendo
		// los datos de pulgadas lo que generara un cargo de 50
		e1 = new Television(20, true);
		// El resultado debe ser 113+10+10+50
		assertEquals(183, e1.precioFinal(), 0);

	}

}
