package com.vasheprime.lashmanager.dto;

public class ClientDTO {
    private Long id;
     private String firstName;

     private String lastName;
     private String phoneNumber;
    private String notes;


    public ClientDTO() {}


    public ClientDTO(Long id, String firstName,
                     String lastName, String phoneNumber, String notes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}





