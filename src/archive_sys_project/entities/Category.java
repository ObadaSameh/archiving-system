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
public class Category extends BaseEntity {

    @Override
    public BaseEntity clone() {
        Category c = new Category();

        cloneBaseEntityData(c);

        return c;
    }

    @Override
    public void serializeProps(List<String> rawData) {
        super.serializeProps(rawData);
    }
    
    @Override
    public BaseEntity deserializeProps(BaseEntity instance, List<String> rawData) {
        Category c = (instance != null) ? (Category) instance : new Category();
        
        super.deserializeProps(c, rawData);
        
        return c;
    }

}
