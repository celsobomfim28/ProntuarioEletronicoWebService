package com.br.wilton.prontuarioeletronico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static LocalDate toLocalDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(data, formatter);
        return localDate;
    }

    public static String toString(LocalDate data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String formattedString = data.format(formatter);
        return formattedString;
    }

    public static String getDataHoraAtual() {
        return LocalDateTime.now().toString();
    }
}
