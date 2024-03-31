package com.example.ProjectTestMySql.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

public class DateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = ISO_OFFSET_DATE_TIME;

    @Override
    public OffsetDateTime deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        String date = parser.getText();
        return OffsetDateTime.parse(date, DATE_TIME_FORMATTER);
    }
}

