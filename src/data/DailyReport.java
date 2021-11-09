package data;

public class DailyReport {
	private int day;
	private int[] time;
	private double[] consoInstant;
	private double[] prodInstant;
	private double[] consoCumul;
	private double[] prodCumul;

	public DailyReport(int i) {
		this.day = i;
		this.time = new int[1440];
		this.consoInstant = new double[1440];
		this.prodInstant = new double[1440];
		this.consoCumul = new double[1440];
		this.prodCumul = new double[1440];
	}

	public DailyReport(int day, double[] conso, double[] prod) {
		this.day = day;
		this.consoInstant = conso;
		this.prodInstant = prod;
		int[] time = new int[1440];
		double[] consoCumul = new double[1440];
		double[] prodCumul = new double[1440];
		consoCumul[0] = conso[0];
		prodCumul[0] = prod[0];
		for (int i = 0; i < 1440; i++) {
			time[i] = i;
			if (i != 0) {
				consoCumul[i] += consoCumul[i - 1] + conso[i];
				prodCumul[i] += prodCumul[i - 1] + prod[i];
			}
		}
		this.time = time;
		this.consoCumul = consoCumul;
		this.prodCumul = prodCumul;
	}

	public int getDay() {
		return day;
	}

	public int[] getTime() {
		return this.time;
	}

	public double[] getConsoInstant() {
		return this.consoInstant;
	}

	public double[] getProdInstant() {
		return this.prodInstant;
	}

	public double[] getConsoCumul() {
		return this.consoCumul;
	}

	public double[] getProdCumul() {
		return this.prodCumul;
	}

	@Override
	public String toString() {
		String result = "";
		result += "Day number : " + (this.getDay() + 1) + "\n";
		for (int min = 0; min < 1440; min++) {
			result += time[min] + ";" + consoInstant[min] + ";" + prodInstant[min] + ";"
					+ Math.round(consoCumul[min] / 60 * 100) / 100. + ";" + Math.round(prodCumul[min] / 60 * 100) / 100.
					+ "\n";
		}
		return result;
	}

}
