/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project.functions;

/**
 *
 * @author sameh
 */
public class ObjectHolder<T> {

    private T obj;

    /**
     * @return the obj
     */
    public T getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj) {
        this.obj = obj;
    }

}
