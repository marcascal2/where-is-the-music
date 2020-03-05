package aiss.model.googleCalendar;

import com.google.api.client.util.DateTime;

public class EventDateTime {
	private String dateTime;

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public EventDateTime(String dateTime) {
		super();
		this.dateTime = dateTime;
	}

	public String toString() {
		return "EventDateTime [dateTime=" + dateTime + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventDateTime other = (EventDateTime) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		return true;
	}
	
}
