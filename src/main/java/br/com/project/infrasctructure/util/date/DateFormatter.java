package br.com.project.infrasctructure.util.date;

import br.com.project.infrasctructure.exception.RFC3339DateFormatConverterException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
public class DateFormatter {
    public static LocalDateTime string2LocalDateTime(String value, String pattern) throws RFC3339DateFormatConverterException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern).withZone(ZoneId.of("UTC"));
            return LocalDateTime.parse(value, formatter);
        }catch(Exception ex){
            throw new RFC3339DateFormatConverterException(ex.getMessage());
        }
    }

    public static String localDateTime2string(LocalDateTime datetime) throws RFC3339DateFormatConverterException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            return datetime.format(formatter);
        }catch(Exception ex){
            throw new RFC3339DateFormatConverterException(ex.getMessage());
        }
    }
}