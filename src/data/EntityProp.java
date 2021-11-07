package data;

public class EntityProp {
    private String name;
    private double power;
    private int h_sch_id;
    private int w_sch_id;
    private int m_sch_id;

    public EntityProp(String name, double power, int h_sch_id, int w_sch_id, int m_sch_id) {
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

    public int gethid() {
        return this.h_sch_id;
    }

    public int getwid() {
        return this.w_sch_id;
    }

    public int getmid() {
        return this.m_sch_id;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", power='" + getPower() + "'" + ", h_sch_id='" + gethid() + "'"
                + ", w_sch_id='" + getwid() + "'" + ", m_sch_id='" + getmid() + "'" + "}";
    }

}
