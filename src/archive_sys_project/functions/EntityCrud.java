/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project.functions;

import archive_sys_project.entities.BaseEntity;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author sameh
 * @param <T>
 */
public class EntityCrud<T extends BaseEntity> implements CrudInterface<T> {

    ListGetter<T> listGetter;
    EntityCounter entityCounter;

    public EntityCrud(ListGetter<T> listGetter, EntityCounter entityCounter) {
        this.entityCounter = entityCounter;
        this.listGetter = listGetter;

    }

    @Override
    public T create(T entity) {
        if (entity.getId() != null) {
            throw new RuntimeException("Error id exists in create function.");
        }

        entity.setId(entityCounter.getNewId());
        listGetter.getList().add((T) entity.clone());

        return entity;
    }

    @Override
    public T update(T entity) {
        if (entity.getId() == null) {
            throw new RuntimeException("Error id not exists in update function.");
        }

        int index = indexOf(entity);
        if (index < 0) {
            throw new RuntimeException("Error id not found while updating entity.");
        }

        listGetter.getList().set(index, (T) entity.clone());

        return entity;
    }

    @Override
    public void delete(T entity) {
        if (entity.getId() == null) {
            throw new RuntimeException("Error id not exists in delete function.");
        }

        int index = indexOf(entity);
        if (index < 0) {
            throw new RuntimeException("Error id not found while deleting entity.");
        }

        listGetter.getList().remove(index);

    }

    @Override
    public List<T> getAll() {
        return (List<T>) listGetter.getList().stream().map((T e) -> e.clone()).collect(Collectors.toList());
    }

    @Override
    public T getOne(Integer id) {
        List<T> l = listGetter.getList();
        for (T o : l) {
            if (Objects.equals(o.getId(), id)) {
                return (T) o.clone();
            }
        }
        return null;
    }

    public int indexOf(T entity) {
        return indexOf(entity.getId());
    }

    public int indexOf(Integer id) {
        int index = -1;
        List<T> l = listGetter.getList();
        for (int i = 0; i < l.size(); i++) {
            if (Objects.equals(l.get(i).getId(), id)) {
                index = i;
                break;
            }
        }
        return index;
    }

}
