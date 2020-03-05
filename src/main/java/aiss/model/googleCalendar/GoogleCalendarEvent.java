package aiss.model.googleCalendar;

public class GoogleCalendarEvent {

	private String calendarId;
	private EventDateTime start;
	private EventDateTime end;
	private String summary;
	
	public GoogleCalendarEvent() {
		super();
		this.calendarId = null;
		this.start = null;
		this.end = null;
		this.summary = null;
	}
	
	public GoogleCalendarEvent(String calendarId, EventDateTime start, EventDateTime end, String summary) {
		super();
		this.calendarId = calendarId;
		this.start = start;
		this.end = end;
		this.summary = summary;
	}

	public String getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}

	public EventDateTime getStart() {
		return start;
	}

	public void setStart(EventDateTime start) {
		this.start = start;
	}

	public EventDateTime getEnd() {
		return end;
	}

	public void setEnd(EventDateTime end) {
		this.end = end;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calendarId == null) ? 0 : calendarId.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoogleCalendarEvent other = (GoogleCalendarEvent) obj;
		if (calendarId == null) {
			if (other.calendarId != null)
				return false;
		} else if (!calendarId.equals(other.calendarId))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}

	public String toString() {
		return "GoogleCalendarEvent [calendarId=" + calendarId + ", start=" + start + ", end=" + end + ", summary="
				+ summary + "]";
	}

}
