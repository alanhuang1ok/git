/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alan
 */
public class UserInfo {

    private int id;
    @NotNull
    @Size(min = 5, max = 50, message = "长度是5-50")
    private String name;
    @NotNull
    private int age;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
