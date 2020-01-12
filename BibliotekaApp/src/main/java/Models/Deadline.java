package Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Date;


public abstract class Deadline extends ModelBase {
	public Date StartDate;
	public Date EndDate;

	public Deadline() {}

	public Deadline(int id, Date startDate, Date endDate) {
		super(id);
		StartDate = startDate;
		EndDate = endDate;
	}

	@JsonGetter("StartDate")
	public Date getStartDate() {
		return StartDate;
	}

	@JsonSetter("StartDate")
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	@JsonGetter("EndDate")
	public Date getEndDate() {
		return EndDate;
	}

	@JsonSetter("EndDate")
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

}