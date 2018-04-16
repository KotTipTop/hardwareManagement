package pl.inz.cymerman.app.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface SimpleObjectConverter<FROM, TO> {
	TO mapTo(FROM from);

	default List<TO> mapTo(List<FROM> from) {
		return from.stream().map(this::mapTo).collect(Collectors.toList());
	}

}
