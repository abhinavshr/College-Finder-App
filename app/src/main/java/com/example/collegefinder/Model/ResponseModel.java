package com.example.collegefinder.Model;

public class ResponseModel {

    String College_Name;
    String College_Location;
    String College_District;
    String College_Website;
    String College_Contact;
    String College_Phone;
    String College_Mail;
    String Program;
    String photo;

    public ResponseModel(String College_Name, String College_Location, String College_District, String College_Website, String College_Contact, String College_Phone, String College_Mail, String Program, String photo) {
        this.College_Name = College_Name;
        this.College_Location = College_Location;
        this.College_District = College_District;
        this.College_Website = College_Website;
        this.College_Contact = College_Contact;
        this.College_Phone = College_Phone;
        this.College_Mail = College_Mail;
        this.Program = Program;
        this.photo = photo;
    }

    public String getCollegeName() {
        return College_Name;
    }

    public void setCollegeName(String College_Name) {
        this.College_Name = College_Name;
    }

    public String getCollegeLocation() {
        return College_Location;
    }

    public void setCollegeLocation(String College_Location) {
        this.College_Location = College_Location;
    }

    public String getCollegeDistrict() {
        return College_District;
    }

    public void setCollegeDistrict(String College_District) {
        this.College_District = College_District;
    }

    public String getCollegeWebsite() {
        return College_Website;
    }

    public void setCollegeWebsite(String collegeWebsite) {
        this.College_Website = collegeWebsite;
    }

    public String getCollegeContact() {
        return College_Contact;
    }

    public void setCollegeContact(String College_Contact) {
        this.College_Contact = College_Contact;
    }

    public String getCollegePhone() {
        return College_Phone;
    }

    public void setCollegePhone(String College_Phone) {
        this.College_Phone = College_Phone;
    }

    public String getCollegeMail() {
        return College_Mail;
    }

    public void setCollegeMail(String College_Mail) {
        this.College_Mail = College_Mail;
    }

    public String getProgram() {
        return Program;
    }

    public void setProgram(String program) {
        this.Program = program;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
