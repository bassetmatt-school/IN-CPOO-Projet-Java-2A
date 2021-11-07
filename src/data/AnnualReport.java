package data;

public class AnnualReport {
    /**
     * The class that manages the report to do on the whole year
     */
    /** An array with all the days */
    private int[] day;
    /** The array of all the consumptions per day */
    private double[] consoInstant;
    /** The array of all the productions per day */
    private double[] prodInstant;
    /** The array of all the cumulated consumptions */
    private double[] consoCumul;
    /** The array of all the cumulated productions */
    private double[] prodCumul;
    /** The list of all the daily reports */
    private DailyReport[] dRepList;

    /**
     * The constructor of the class that initializes the arrays with zeros and the
     * report list with blank reports
     */
    public AnnualReport() {

        this.day = new int[365];
        this.consoInstant = new double[365];
        this.prodInstant = new double[365];
        this.consoCumul = new double[365];
        this.prodCumul = new double[365];
        this.dRepList = new DailyReport[365];
    }

    public int[] getDay() {
        return this.day;
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

    public DailyReport[] getdRepList() {
        return dRepList;
    }

    /**
     * A setter to put elements directly in the array
     * 
     * @param dRep the report list
     * @param i    the index of the list where one want to put a report
     */
    public void setdRepList(DailyReport dRep, int i) {
        this.dRepList[i] = dRep;
    }

    @Override
    public String toString() {
        String result = "";
        // TODO optimize !!
        for (int day = 0; day < 365; day++) {
            result += this.getDay()[day] + 1 + ";" + this.getConsoInstant()[day] + ";" + this.getProdInstant()[day]
                    + ";" + Math.round(this.getConsoCumul()[day] * 100) / 100. + ";"
                    + Math.round(this.getProdCumul()[day] * 100) / 100. + "\n";
        }
        return result;
    }

    public void complete() {
        int i = 0;
        for (DailyReport dRep : this.dRepList) {
            this.day[i] = i;
            this.consoInstant[i] = dRep.getConsoInstant()[1439];
            this.prodInstant[i] = dRep.getProdInstant()[1439];
            this.consoCumul[i] = dRep.getConsoCumul()[1439];
            this.prodCumul[i] = dRep.getProdCumul()[1439];
            if (i > 0) {
                this.consoCumul[i] += this.consoCumul[i - 1];
                this.prodCumul[i] += this.prodCumul[i - 1];
            }
            i++;
        }
    }
}
