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
public class Topic extends BaseEntity {

//    private String storageFolder;
    @Override
    public BaseEntity clone() {
        Topic c = new Topic();

        cloneBaseEntityData(c);

        return c;
    }

    @Override
    public void serializeProps(List<String> rawData) {
        super.serializeProps(rawData);
    }

    @Override
    public BaseEntity deserializeProps(BaseEntity instance, List<String> rawData) {
        Topic c = (instance != null) ? (Topic) instance : new Topic();

        super.deserializeProps(c, rawData);

        return c;
    }

//    /**
//     * @return the storageFolder
//     */
//    public String getStorageFolder() {
//        return storageFolder;
//    }
//
//    /**
//     * @param storageFolder the storageFolder to set
//     */
//    public void setStorageFolder(String storageFolder) {
//        this.storageFolder = storageFolder;
//    }
}
