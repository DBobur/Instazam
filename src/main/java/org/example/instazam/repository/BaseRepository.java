package org.example.instazam.repository;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.example.instazam.excaption.DataNotFoundExcaption;
import org.example.instazam.model.BaseModel;
import org.example.instazam.model.User;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class BaseRepository<T extends BaseModel>{
    protected String path = "D:\\My Project\\Instazam\\src\\main\\resources";
    protected Gson gson = new GsonBuilder().setPrettyPrinting()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .create();

    public T save(T t){
        ArrayList<T> ts = readAll();
        if(hasModel(t)) throw new DataNotFoundExcaption("Data not found");
        ts.add(t);
        writeAll(ts);
        return t;
    }

    public ArrayList<T> readAll(){
        try(FileReader reader = new FileReader(path)) {
            Type typeToken = TypeToken.getParameterized(ArrayList.class, getTypeClass()).getType();
            return gson.fromJson(reader, typeToken);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T read(UUID id){
        ArrayList<T> ts = readAll();
        for (T t : ts) {
            if(Objects.equals(t.getId(),id)) return t;
        }
        throw new DataNotFoundExcaption("Data not found");
    }

    public void writeAll(List<T> ts){
        try(FileWriter writer = new FileWriter(path)) {
            String json = gson.toJson(ts);
            //Writer
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract boolean hasModel(T t);
    protected abstract Class<T> getTypeClass();
}

class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {
    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}

class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
