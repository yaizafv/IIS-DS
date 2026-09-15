package es.uniovi.ds.lab.temperature;

public class Temperatura {
	
	private double celsius;
	private double fahrenheit;
	private boolean celsiusOk;
	private boolean fahrenheitOk;
	
	public Temperatura(double celsius) {
		setCelsius(celsius);
	}

	public void setCelsius(double celsius) {
        this.celsius = celsius;
        celsiusOk = true;
        fahrenheitOk = false;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
        celsiusOk = false;
        fahrenheitOk = true;
    }

	public double getCelsius() {
		if(!celsiusOk) {
			celsius = (fahrenheit - 32) / 1.8;
			celsiusOk = true;
		}
		return celsius;
	}
	
	public double getFahrenheit() {
		if(!fahrenheitOk) {
			celsius = fahrenheit * 1.8 + 32;
			fahrenheitOk = true;
		}
		return fahrenheit;
	}	

}
