package com.example.ajopay.dto.RequestDto;

import lombok.Builder;

@Builder
public class EmailDetails {
    private String recipient;
    private String subject;
    private String mesageBody;
    private String attachments;

    public EmailDetails(String recipient, String subject, String mesageBody, String attachments) {
        this.recipient = recipient;
        this.subject = subject;
        this.mesageBody = mesageBody;
        this.attachments = attachments;
    }

    public EmailDetails() {

    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMesageBody() {
        return mesageBody;
    }

    public void setMesageBody(String mesageBody) {
        this.mesageBody = mesageBody;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "EmailDetails{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", mesageBody='" + mesageBody + '\'' +
                ", attachments='" + attachments + '\'' +
                '}';
    }
}
