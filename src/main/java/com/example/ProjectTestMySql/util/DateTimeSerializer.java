package com.example.ProjectTestMySql.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

public class DateTimeSerializer extends JsonSerializer<OffsetDateTime> {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = ISO_OFFSET_DATE_TIME;

    @Override
    public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String formattedDateTime = value.format(DATE_TIME_FORMATTER);
        gen.writeString(formattedDateTime);
    }
}
