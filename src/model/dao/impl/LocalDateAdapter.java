package model.dao.impl;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    @Override
    public JsonElement serialize(LocalDate data, Type tipo, JsonSerializationContext contexto) {
        if (data == null) {
            return JsonNull.INSTANCE;
        }
        return new JsonPrimitive(data.toString());
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type tipo, JsonDeserializationContext contexto){
        if (json == null || json.isJsonNull() || json.getAsString().isBlank()) {
            return null;
        }
        return LocalDate.parse(json.getAsString());
    }
}
