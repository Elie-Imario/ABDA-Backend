package com.core.appbackend.playload.response;

import com.core.appbackend.beans.audit.AuditModelDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public class AuditsResponse {
    private List<AuditModelDTO> audits;
    private HttpStatus responseStatus;

    public AuditsResponse(List<AuditModelDTO> audits, HttpStatus responseStatus) {
        this.audits = audits;
        this.responseStatus = responseStatus;
    }

    public List<AuditModelDTO> getAudits() {
        return audits;
    }

    public void setAudits(List<AuditModelDTO> audits) {
        this.audits = audits;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
