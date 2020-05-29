/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project.functions;

import archive_sys_project.entities.BaseEntity;
import java.util.List;

/**
 *
 * @author sameh
 */
public interface CrudInterface<T extends BaseEntity> {

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    List<T> getAll();

    T getOne(Integer id);

}
