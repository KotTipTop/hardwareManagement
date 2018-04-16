package pl.inz.cymerman.app.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class StringToDateConverter implements Converter<String, Date> {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date convert(String arg0) {
		try {
			return DATE_FORMAT.parse(arg0);
		} catch (Exception e) {
			return null;
		}
	}

}
