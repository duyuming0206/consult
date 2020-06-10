package com.example.consult.entity;

public class User {

    private int id;
    private String email;
    private String password;
    private String name;
    private String phone;
    String block;
    String address;
    public void setBlock(String block) {
        this.block = block;
    }
    public String getBlock() {
        return block;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    String img;
    public void setImg(String img) {
        this.img = img;
    }
    public String getImg() {
        return img;
    }
    private int roleID = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
