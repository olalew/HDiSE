package com.alexluk.worker.infrastructure;

public class JSONConverter {
    public static String convertToCamelCase(String str) {
        StringBuilder camelCase = new StringBuilder();
        boolean capitalizeNext = false;
        boolean firstLetter = true;
        for (char c : str.toCharArray()) {
            if(c == '_') {
                if (!firstLetter)
                    capitalizeNext = true;
                continue;
            }

            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                camelCase.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                camelCase.append(Character.toLowerCase(c));
                firstLetter = false;
            }
        }
        return camelCase.toString();
    }

    public static String convertFirstLetterToCamelCase(String str) {
        return str.substring(0, 1).toLowerCase() +  str.substring(1, str.length());
    }
}
