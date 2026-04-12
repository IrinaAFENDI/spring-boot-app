package com.vasheprime.lashmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class AppointmentDTO {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime appointmentDate;

    private String clientVolume;
    private String clientEffect;
    private String masterCurl;
    private String masterLength;
    private String masterNotes;
    private Long clientId;  // ID клиента, без полной связи

    public AppointmentDTO() {}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getClientVolume() { return clientVolume; }
    public void setClientVolume(String clientVolume) {
        this.clientVolume = clientVolume;
    }

    public String getClientEffect() { return clientEffect; }
    public void setClientEffect(String clientEffect) { this.clientEffect = clientEffect; }

    public String getMasterCurl() { return masterCurl; }
    public void setMasterCurl(String masterCurl) { this.masterCurl = masterCurl; }

    public String getMasterLength() { return this.masterLength; }
    public void setMasterLength(String masterLength) { this.masterLength = masterLength; }

    public String getMasterNotes() { return masterNotes; }
    public void setMasterNotes(String masterNotes) { this.masterNotes = masterNotes; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
}




