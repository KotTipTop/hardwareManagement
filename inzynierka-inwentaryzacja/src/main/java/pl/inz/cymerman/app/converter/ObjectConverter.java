package pl.inz.cymerman.app.converter;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Value;

@Service
public class ObjectConverter {

	@SuppressWarnings("rawtypes")
	private Map<ConverterKey, SimpleObjectConverter> converters;

	@Autowired
	public <T, R> ObjectConverter(Set<SimpleObjectConverter<T, R>> allConverters) {
		this.converters = new HashMap<>();
		for (SimpleObjectConverter<T, R> c : allConverters) {
			converters.put(getConverterType(c), c);
		}
	}

	@SuppressWarnings("unchecked")
	private <T, R> ConverterKey<T, R> getConverterType(SimpleObjectConverter<T, R> converter) {
		Class<R> typeFrom = (Class<R>) ((ParameterizedType) converter.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
		Class<T> typeTo = (Class<T>) ((ParameterizedType) converter.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[1];
		return new ConverterKey<>(typeFrom, typeTo);
	}

	@SuppressWarnings("unchecked")
	public <T, R> List<T> convertAll(List<R> allObjects, Class<T> typeTo) {
		if (allObjects.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		ConverterKey<T, R> key = new ConverterKey<>((Class<R>) allObjects.get(0).getClass(), typeTo);
		return converters.get(key).mapTo(allObjects);
	}

	@SuppressWarnings("unchecked")
	public <T, R> T convert(R from, Class<T> typeTo) {
		ConverterKey<T, R> key = new ConverterKey<>((Class<R>) from.getClass(), typeTo);
		return (T) converters.get(key).mapTo(from);
	}

	@Value
	private class ConverterKey<T, R> {
		private Class<R> typeFrom;
		private Class<T> typeTo;
	}

}
