package org.example.instazam.Service;

import org.example.instazam.model.BaseModel;
import org.example.instazam.repository.BaseRepository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<T extends BaseModel, R extends BaseRepository<T>> {
    protected R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    public T save(T t){
        return repository.save(t);
    }

    public ArrayList<T> getAll(){
        return repository.readAll();
    }
    public T getById(UUID id){
        return repository.read(id);
    }
    public boolean update(UUID id, T ut){
        ArrayList<T> all = getAll();
        int i = 0;
        for (T t : all) {
           if(Objects.equals(t.getId(),id)){
               T tt = updateT(t,ut);
               all.set(i,tt);
           }
           i++;
        }
        return false;
    }
    public boolean delete(UUID id){
        ArrayList<T> all = getAll();
        for (T t : all) {
            if(Objects.equals(t.getId(),id)){
                all.remove(t);
                return true;
            }
        }
        return false;
    }

    protected abstract T updateT(T t, T ut);
}
