package com.arodriguezbravo.stream;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("=========================================");
		System.out.println("");

		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);

		System.out.println("Números de la lista: " + numbers);
		System.out.println("");

		for (Integer prueba : numbers) {
			if (prueba > 10) {
				System.out.println("Números mayores de 10: " + prueba);
				System.out.println("");
			}
		}
	
		System.out.println("=========================================");
		
		IComprobar vx = list ->{
			numbers.forEach(n -> System.out.println("Número de la lista: " +n));
		};
		
		vx.comprobar(numbers);

		System.out.println("=========================================");
		ICalcular clAcortado = (lista) -> numbers.stream().filter(num -> num > 10).count();
		System.out.println("Núemro mayores de 10: " + clAcortado.calculando(numbers));
		System.out.println("Números mayores de 10 Lambda: " + numbers.stream().filter(num -> num > 10).count());

		System.out.println("");
		System.out.println("=========================================");

		List<String> ciudades = List.of("Cártama", "Málaga", "Madrid", "Barcelona");

		 List<String> obj = ciudades.stream()
				.filter(s -> !s.equals("Madrid"))
				.peek(System.out::println)
				.map(c -> c.toUpperCase())
				.peek(System.out::println)
				.collect(Collectors.toList());
		
		System.out.println("Resultado: " + obj);
		

		List<Producto> shopping = List.of(new Producto("Clothes", new BigDecimal("15.90"), Impuesto.NORMAL),
				new Producto("Bread", new BigDecimal("1.5"), Impuesto.SUPERREDUCED),
				new Producto("Meat", new BigDecimal("13.99"), Impuesto.REDUCED),
				new Producto("Cheese", new BigDecimal("3.59"), Impuesto.SUPERREDUCED),
				new Producto("Coke", new BigDecimal("1.89"), Impuesto.REDUCED),
				new Producto("Whiskey", new BigDecimal("19.90"), Impuesto.NORMAL));

		List<String> producto = shopping.stream().filter(t -> t.name.startsWith("C")).map(t -> t.name).sorted()
				.collect(Collectors.toList());

		System.out.println("=========================================");
		System.out.println("");

		System.out.println("Resultado de lista que empieza por C: " + producto.toString());

		System.out.println("");

		BigDecimal numTotal = shopping.stream()
				.map(t -> t.price.add(t.price.multiply(new BigDecimal(t.impuesto.percent)).divide(new BigDecimal(100))))
				.reduce(BigDecimal.ZERO, (x, y) -> x.add(y)).setScale(2, RoundingMode.CEILING);

		System.out.println("Total de Impuesto " + numTotal + "$");

	}

}
