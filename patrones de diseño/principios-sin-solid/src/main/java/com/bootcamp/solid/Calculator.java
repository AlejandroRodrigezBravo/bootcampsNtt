package com.bootcamp.solid;

public class Calculator {

	public void calculate(IOperacionService opercacion) throws Exception {
		opercacion.operacionCuentas();
	}

	public static void main(String[] args) throws Exception {

		Addition add = new Addition(10, 5);
		add.operacionCuentas();
		System.out.println("Resultado calculator: " + add.result);

		Dividir dv = new Dividir(10, 5);
		dv.operacionCuentas();
		System.out.println("Resultado division " + dv.result);

		Multiplication ml = new Multiplication(10, 5);
		ml.operacionCuentas();
		System.out.println("Resultado multiplication " + ml.result);

		Substraction sb = new Substraction(10, 5);
		sb.operacionCuentas();
		System.out.println("Resultado susbration " + sb.result);
		
		
	}

}