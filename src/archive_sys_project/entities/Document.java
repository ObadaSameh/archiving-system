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
public class Document extends BaseEntity {

    private Integer categoryId;
    private Integer topicId;
    private List<Integer> tagsIds;

    /**
     * @return the categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the topicId
     */
    public Integer getTopicId() {
        return topicId;
    }

    /**
     * @param topicId the topicId to set
     */
    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    /**
     * @return the tagsIds
     */
    public List<Integer> getTagsIds() {
        return tagsIds;
    }

    /**
     * @param tagsIds the tagsIds to set
     */
    public void setTagsIds(List<Integer> tagsIds) {
        this.tagsIds = tagsIds;
    }

    

}
