package hello;

import java.time.LocalDate;

public class Event {
    private final long id;
    private final LocalDate when;
	public long getId() {
		return id;
	}
	public LocalDate getWhen() {
		return when;
	}
	public Event(long id, LocalDate when) {
		super();
		this.id = id;
		this.when = when;
	}
	
}
