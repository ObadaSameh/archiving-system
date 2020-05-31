/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project.entities;

import java.util.List;

/**
 *
 * @author sameh
 */
public abstract class BaseEntity {

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    private Integer id;
    private String name;

    public abstract BaseEntity clone();

    protected void cloneBaseEntityData(BaseEntity newEntity) {
        newEntity.setId(id);
        newEntity.setName(name);
    }

    public void serializeProps(List<String> rawData) {
        rawData.add(getClass().getSimpleName());
        rawData.add(id.toString());
        rawData.add(name);
    }

    public BaseEntity deserializeProps(BaseEntity instance, List<String> rawData) {
        if (instance == null) {
            throw new RuntimeException("abstract must receive instance from derived classes");
        }

        if (getClass().getSimpleName().equals(rawData.remove(0)) == false) {
            throw new RuntimeException("entity load error");
        }
        instance.setId(Integer.parseInt(rawData.remove(0)));
        instance.setName(rawData.remove(0));
        return instance;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

}
