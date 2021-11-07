package data;
public class DailyReport {
    private int day;
    private int[] time;
    private double[] consoInstant;
    private double[] prodInstant ;
    private double[] consoCumul  ;
    private double[] prodCumul   ;

    public DailyReport(int i) {
        this.day = i;
        this.time = new int[1440] ;
        this.consoInstant = new double[1440] ;
        this.prodInstant  = new double[1440] ;
        this.consoCumul   = new double[1440] ;
        this.prodCumul    = new double[1440] ;
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

    public void addMinuteConso(int i, double consoInstant) {
        this.time[i] = i;
        this.consoInstant[i] = consoInstant;
        this.consoCumul[i] = this.consoInstant[i];
        if (i > 0) {
            this.consoCumul[i] += this.consoCumul[i-1];
        }

    }
    public void addMinuteProd(int i, double prodInstant) {
        this.time[i] = i;
        this.prodInstant[i] = prodInstant;
        this.prodCumul[i] = this.prodInstant[i];
        if (i > 0) {
            this.prodCumul[i] += this.prodCumul[i-1];
        }
    }

    @Override
    public String toString() {
        String result = "";
        result += "Day number : " + (this.getDay()+1) + "\n";
        //TODO optimize !!
        for(int min = 0; min < 1440; min++) {
            result += this.getTime()[min]+1 + ";" 
                    + this.getConsoInstant()[min] + ";"
                    + this.getProdInstant()[min] + ";"
                    + Math.round(this.getConsoCumul()[min]/60*100)/100. + ";"
                    + Math.round(this.getProdCumul()[min]/60*100)/100. + "\n";
        }
        return result;
    }


}
