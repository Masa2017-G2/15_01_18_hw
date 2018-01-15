package com.sheygam.masa_g2_15_01_18;

/**
 * Created by gregorysheygam on 15/01/2018.
 */

public class Profile {
    private String name;
    private String email;
    private String phone;
    private String desc;

    public Profile() {
    }

    public Profile(String name, String email, String phone, String desc) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return name + "," + email +","+phone+","+desc;
    }

    public static Profile newInstance(String str){
        String[] arr = str.split(",");
        return new Profile(arr[0],arr[1],arr[2],arr[3]);
    }
}
