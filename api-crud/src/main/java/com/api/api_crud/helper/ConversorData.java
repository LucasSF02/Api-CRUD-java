package com.api.api_crud.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {
    public static String converterDataParaDataEHora(Date data) {
        return new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(data);
    }
}
