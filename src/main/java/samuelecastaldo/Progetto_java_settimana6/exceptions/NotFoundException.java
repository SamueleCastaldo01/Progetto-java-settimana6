package samuelecastaldo.Progetto_java_settimana6.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
	public NotFoundException(long id) {
		super("Il record con id " + id + " non è stato trovato!");
	}
}
