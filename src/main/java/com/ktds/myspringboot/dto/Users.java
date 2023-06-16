package com.ktds.myspringboot.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement
public class Users implements Serializable {
    private static final long serialVersionUID = 22L;
    @JacksonXmlProperty(localName = "User")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<UserResponse> users = new ArrayList<>();

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }
    public List<UserResponse> getUsers() {
        return users;
    }
}