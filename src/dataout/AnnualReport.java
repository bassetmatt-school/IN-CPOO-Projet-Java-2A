package dataout;
public class AnnualReport {
    private int[] day;
    private double[] consoInstant;
    private double[] prodInstant ;
    private double[] consoCumul  ;
    private double[] prodCumul   ;

    public AnnualReport() {
        this.day = new int[365] ;
        this.consoInstant = new double[365] ;
        this.prodInstant  = new double[365] ;
        this.consoCumul   = new double[365] ;
        this.prodCumul    = new double[365] ;
    }


    public AnnualReport(int[] day, double[] consoInstant, double[] prodInstant, double[] consoCumul, double[] prodCumul) {
        this.day = day;
        this.consoInstant = consoInstant;
        this.prodInstant = prodInstant;
        this.consoCumul = consoCumul;
        this.prodCumul = prodCumul;
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

    @Override
    public String toString() {
        String result = "";
        //TODO optimize !!
        for(int day = 0; day < 365; day++) {
            result += this.getDay()[day]+1 + ";" 
                    + this.getConsoInstant()[day] + ";"
                    + this.getProdInstant()[day] + ";"
                    + Math.round(this.getConsoCumul()[day]*100)/100. + ";"
                    + Math.round(this.getProdCumul()[day]*100)/100. + "\n";
        }
        return result;
    }


    public void complete(DailyReport[] dRepList) {
        int i = 0;
        for (DailyReport dRep : dRepList) {
            this.day[i] = i;
            this.consoInstant[i] = dRep.getConsoInstant()[1439];
            this.prodInstant[i]  = dRep.getProdInstant()[1439];
            this.consoCumul[i]   = dRep.getConsoCumul()[1439];
            this.prodCumul[i]    = dRep.getProdCumul()[1439];
            if (i > 0) {
                this.consoCumul[i] += this.consoCumul[i-1];
                this.prodCumul[i] += this.prodCumul[i-1];
            }
            i++;
        }
    }
}
