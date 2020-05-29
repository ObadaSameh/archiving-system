/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sameh
 */
public class Document extends BaseEntity {

    private Integer categoryId;
    private Integer topicId;
    private List<Integer> tagsIds;

    private String visibleName;

    @Override
    public BaseEntity clone() {
        Document c = new Document();

        cloneBaseEntityData(c);

        c.setCategoryId(categoryId);
        c.setTopicId(topicId);
        c.setTagsIds(tagsIds.subList(0, tagsIds.size() - 1));
        c.setVisibleName(visibleName);

        return c;
    }

    @Override
    public void serializeProps(List<String> rawData) {
        super.serializeProps(rawData);

        rawData.add(categoryId.toString());
        rawData.add(topicId.toString());

        rawData.add(String.valueOf(tagsIds.size()));

        for (Integer n : tagsIds) {
            rawData.add(String.valueOf(n));
        }

    }

    @Override
    public BaseEntity deserializeProps(BaseEntity instance, List<String> rawData) {
        Category c = (instance != null) ? (Category) instance : new Category();

        super.deserializeProps(c, rawData);

        categoryId = Integer.parseInt(rawData.remove(0));
        topicId = Integer.parseInt(rawData.remove(0));

        int tagCount = Integer.parseInt(rawData.remove(0));

        tagsIds = new ArrayList<>();
        for (int i = 0; i < tagCount; i++) {
            tagsIds.add(Integer.parseInt(rawData.remove(0)));
        }

        return c;
    }

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

    /**
     * @return the visibleName
     */
    public String getVisibleName() {
        return visibleName;
    }

    /**
     * @param visibleName the visibleName to set
     */
    private void setVisibleName(String visibleName) {
        this.visibleName = visibleName;
    }

}
