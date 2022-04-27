package com.bootcamp.solid;

public class Multiplication implements IOperacionService{
    public double a;
    public double b;
    public double result = 0.0;

    public Multiplication(double a , double b) {
        this.a = a;
        this.b = b;
    }

	@Override
	public void operacionCuentas() throws Exception {
		
		try {
			this.result = this.a * this.b;
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}