package model.logic;

public class Viaje 
{
	//Atributos
	
	private int sourceID;
	
	private int dstID;
	
	private int identificador;
	
	private double meanTravelTime;
	
	private double standardDeviationTravelTime;
	
	private double geometricMeanTravelTime;
	
	private double geometricStandardDeviationTravelTime;
	
	//Constructor
	
	public Viaje (int p1, int p2, int p3, double p4, double p5, double p6, double p7)
	{
		sourceID=p1;
		dstID=p2;
		identificador=p3;
		meanTravelTime=p4;
		standardDeviationTravelTime=p5;
		geometricMeanTravelTime=p6;
		geometricStandardDeviationTravelTime=p7;
	}

	
	
	//Métodos
	
	public int getSourceID() {
		return sourceID;
	}

	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}

	public int getDstID() {
		return dstID;
	}

	public void setDstID(int dstID) {
		this.dstID = dstID;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int numero) {
		this.identificador = numero;
	}

	public double getMeanTravelTime() {
		return meanTravelTime;
	}

	public void setMeanTravelTime(double meanTravelTime) {
		this.meanTravelTime = meanTravelTime;
	}

	public double getStandardDeviationTravelTime() {
		return standardDeviationTravelTime;
	}

	public void setStandardDeviationTravelTime(double standardDeviationTravelTime) {
		this.standardDeviationTravelTime = standardDeviationTravelTime;
	}

	public double getGeometricMeanTravelTime() {
		return geometricMeanTravelTime;
	}

	public void setGeometricMeanTravelTime(double geometricMeanTravelTime) {
		this.geometricMeanTravelTime = geometricMeanTravelTime;
	}

	public double getGeometricStandardDeviationTravelTime() {
		return geometricStandardDeviationTravelTime;
	}

	public void setGeometricStandardDeviationTravelTime(double geometricStandardDeviationTravelTime) {
		this.geometricStandardDeviationTravelTime = geometricStandardDeviationTravelTime;
	}
	
	
	
	
	
	
}
