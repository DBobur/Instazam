package org.example.instazam.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.instazam.model.BaseModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class BaseRepository<T extends BaseModel>{
    protected String path = "D:\\My Project\\Instazam\\src\\main\\resources";
    protected Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public T save(T t){
        ArrayList<T> ts = readAll();
        if(hasModel()) return null;
        ts.add(t);
        writeAll(ts);
        return t;
    }

    public ArrayList<T> readAll(){
        try(FileReader reader = new FileReader(path)) {
            TypeToken<ArrayList<T>> typeToken = new TypeToken<>() {};
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
        return null;
    }

    public void writeAll(List<T> ts){
        try(FileWriter writer = new FileWriter(path)) {
            String json = gson.toJson(ts);
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract boolean hasModel();
}
