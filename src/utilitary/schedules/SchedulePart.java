package utilitary.schedules;

import java.util.Objects;

/**
 * Easier to handle than a int[] array
 */
public class SchedulePart {
	/**
	 * A class that describes sub parts of a schedule, each part is characterized by
	 * the fact that its consumption is constant
	 */
	/** The consumption during the period */
	private int conso;
	/** The duration of the period */
	private int duration;
	/** The sum of the durations of the precedent parts */
	private int durationCum;

	/**
	 * Constructor without the cumulated duration
	 * 
	 * @param conso
	 * @param duration
	 */
	public SchedulePart(int conso, int duration) {
		this.conso = conso;
		this.duration = duration;
		this.durationCum = duration;
	}

	/**
	 * Constructor with the cumulated duration
	 * 
	 * @param conso
	 * @param duration
	 */
	public SchedulePart(int conso, int duration, int durationCum) {
		this.conso = conso;
		this.duration = duration;
		this.durationCum = durationCum;
	}

	public int getConso() {
		return this.conso;
	}

	public void setConso(int conso) {
		this.conso = conso;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDurationCum() {
		return this.durationCum;
	}

	public void setDurationCum(int durationCum) {
		this.durationCum = durationCum;
	}

	@Override
	public String toString() {
		return "{" + getConso() + "," + getDuration() + "," + getDurationCum() + "}";
	}


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof SchedulePart)) {
			return false;
		}
		SchedulePart schedulePart = (SchedulePart) o;
		return conso == schedulePart.conso && duration == schedulePart.duration && durationCum == schedulePart.durationCum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conso, duration, durationCum);
	}



}
