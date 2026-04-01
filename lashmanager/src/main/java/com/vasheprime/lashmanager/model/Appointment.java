package com.vasheprime.lashmanager.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  private LocalDateTime appointmentDate;



  private String clientVolume;
  private String clientEffect;

    private String masterCurl;
  private String masterLength;
  private String masterNotes;


  //связь с клиенткой
  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

  public Appointment() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }





    public LocalDateTime getDateTime() {
        return appointmentDate;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.appointmentDate = dateTime;
    }


    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getMasterNotes() {
        return masterNotes;
    }

    public void setMasterNotes(String masterNotes) {
        this.masterNotes = masterNotes;
    }

    public String getMasterLength() {
        return masterLength;
    }

    public void setMasterLength(String masterLength) {
        this.masterLength = masterLength;
    }

    public String getMasterCurl() {
        return masterCurl;
    }

    public void setMasterCurl(String masterCurl) {
        this.masterCurl = masterCurl;
    }

    public String getClientEffect() {
        return clientEffect;
    }

    public void setClientEffect(String clientEffect) {
        this.clientEffect = clientEffect;
    }

    public String getClientVolume() {
        return clientVolume;
    }

    public void setClientVolume(String clientVolume) {
        this.clientVolume = clientVolume;
    }
}
