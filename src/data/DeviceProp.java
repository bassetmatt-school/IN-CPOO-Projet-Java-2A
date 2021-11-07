package data;

public class DeviceProp {
    private String name;
    private double power;
    private int h_sch_id;
    private int w_sch_id;
    private int m_sch_id;

    public DeviceProp(String name,double power,
    int h_sch_id, int w_sch_id,int m_sch_id) {
        this.name = name;
        this.power = power;
        this.h_sch_id = h_sch_id;
        this.w_sch_id = w_sch_id;
        this.m_sch_id = m_sch_id;
    }

    public String getName() {
        return this.name;
    }

    public double getPower() {
        return this.power;
    }

    public int getH_sch_id() {
        return this.h_sch_id;
    }

    public int getW_sch_id() {
        return this.w_sch_id;
    }

    public int getM_sch_id() {
        return this.m_sch_id;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", power='" + getPower() + "'" +
            ", h_sch_id='" + getH_sch_id() + "'" +
            ", w_sch_id='" + getW_sch_id() + "'" +
            ", m_sch_id='" + getM_sch_id() + "'" +
            "}";
    }
   
}
