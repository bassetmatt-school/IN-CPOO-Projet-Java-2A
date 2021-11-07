package data;

public class DeviceProp {
    private String name;
    private double power;
    private int w_sch_id;
    private int m_sch_id;
    private double multiplier;

    public DeviceProp(String name,double power,
    int w_sch_id,int m_sch_id,double multiplier ) {
        this.name = name;
        this.power = power;
        this.w_sch_id = w_sch_id;
        this.m_sch_id = m_sch_id;
        this.multiplier = multiplier;
    }

    @Override
    public String toString() {
    return "{" +
        " name='" + name + "'" +
        ", power='" + power + "'" +
        ", w_sch_id='" + w_sch_id + "'" +
        ", m_sch_id='" + m_sch_id + "'" +
        ", multiplier='" + multiplier + "'" +
        "}";
    }
}
