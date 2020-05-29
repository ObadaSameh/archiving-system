/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project.entities;

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
