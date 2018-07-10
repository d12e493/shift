package com.davis.shift.convert;

import com.davis.shift.util.DateTimeUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalTime;

@JsonComponent
public class LocalTimeSerializer extends JsonSerializer<LocalTime> {
    @Override
    public void serialize(LocalTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        gen.writeString(DateTimeUtils.formatHourAndMinute(value));
    }
}
