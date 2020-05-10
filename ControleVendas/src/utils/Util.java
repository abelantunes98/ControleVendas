package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
    public static Date stringToDate(String data1) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        java.util.Date data = null;
        try {
            data = formato.parse(data1);
        } catch (ParseException e) {}
        return data;
    }
}
