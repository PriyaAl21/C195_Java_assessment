package model;

import java.time.LocalDateTime;

public class Appointment {
    public int apptId;
    public String title;
    public String description;
    public String location;
    public String contact;
    public String type;
    public LocalDateTime startDateNTime;
    public LocalDateTime endDateNTime;
    public int customerId;
    public int userId;

    public Appointment(int apptId, String title, String description, String location, String contact, String type, LocalDateTime startDateNTime, LocalDateTime endDateNTime, int customerId, int userId) {
        this.apptId = apptId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.type = type;
        this.startDateNTime = startDateNTime;
        this.endDateNTime = endDateNTime;
        this.customerId = customerId;
        this.userId = userId;
    }

    public int getApptId() {
        return apptId;
    }

    public void setApptId(int apptId) {
        this.apptId = apptId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getStartDateNTime() {
        return startDateNTime;
    }

    public void setStartDateNTime(LocalDateTime startDateNTime) {
        this.startDateNTime = startDateNTime;
    }

    public LocalDateTime getEndDateNTime() {
        return endDateNTime;
    }

    public void setEndDateNTime(LocalDateTime endDateNTime) {
        this.endDateNTime = endDateNTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
