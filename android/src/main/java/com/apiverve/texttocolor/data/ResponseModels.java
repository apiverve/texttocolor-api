// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     TexttoColorData data = Converter.fromJsonString(jsonString);

package com.apiverve.texttocolor.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static TexttoColorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(TexttoColorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(TexttoColorData.class);
        writer = mapper.writerFor(TexttoColorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// TexttoColorData.java

package com.apiverve.texttocolor.data;

import com.fasterxml.jackson.annotation.*;

public class TexttoColorData {
    private String color;
    private String hex;
    private String rgb;
    private String hsl;
    private String cmyk;
    private long ansi16;
    private Channels channels;

    @JsonProperty("color")
    public String getColor() { return color; }
    @JsonProperty("color")
    public void setColor(String value) { this.color = value; }

    @JsonProperty("hex")
    public String getHex() { return hex; }
    @JsonProperty("hex")
    public void setHex(String value) { this.hex = value; }

    @JsonProperty("rgb")
    public String getRGB() { return rgb; }
    @JsonProperty("rgb")
    public void setRGB(String value) { this.rgb = value; }

    @JsonProperty("hsl")
    public String getHsl() { return hsl; }
    @JsonProperty("hsl")
    public void setHsl(String value) { this.hsl = value; }

    @JsonProperty("cmyk")
    public String getCmyk() { return cmyk; }
    @JsonProperty("cmyk")
    public void setCmyk(String value) { this.cmyk = value; }

    @JsonProperty("ansi16")
    public long getAnsi16() { return ansi16; }
    @JsonProperty("ansi16")
    public void setAnsi16(long value) { this.ansi16 = value; }

    @JsonProperty("channels")
    public Channels getChannels() { return channels; }
    @JsonProperty("channels")
    public void setChannels(Channels value) { this.channels = value; }
}

// Channels.java

package com.apiverve.texttocolor.data;

import com.fasterxml.jackson.annotation.*;

public class Channels {
    private long rgbChannels;
    private long cmykChannels;
    private long ansiChannels;
    private long hexChannels;
    private long hslChannels;

    @JsonProperty("rgbChannels")
    public long getRGBChannels() { return rgbChannels; }
    @JsonProperty("rgbChannels")
    public void setRGBChannels(long value) { this.rgbChannels = value; }

    @JsonProperty("cmykChannels")
    public long getCmykChannels() { return cmykChannels; }
    @JsonProperty("cmykChannels")
    public void setCmykChannels(long value) { this.cmykChannels = value; }

    @JsonProperty("ansiChannels")
    public long getANSIChannels() { return ansiChannels; }
    @JsonProperty("ansiChannels")
    public void setANSIChannels(long value) { this.ansiChannels = value; }

    @JsonProperty("hexChannels")
    public long getHexChannels() { return hexChannels; }
    @JsonProperty("hexChannels")
    public void setHexChannels(long value) { this.hexChannels = value; }

    @JsonProperty("hslChannels")
    public long getHslChannels() { return hslChannels; }
    @JsonProperty("hslChannels")
    public void setHslChannels(long value) { this.hslChannels = value; }
}