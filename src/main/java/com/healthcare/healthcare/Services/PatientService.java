package com.healthcare.healthcare.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.healthcare.healthcare.Payloads.ResponseMedicalHistory;
import com.healthcare.healthcare.Payloads.ResponseMood;
import com.healthcare.healthcare.Payloads.ResponsePatients;

import java.util.*;

public interface PatientService {
    public void addPatientMood(JsonNode moods);
    public void getMood(int id);
    public List<ResponseMood> getPatientMood(int id);
    public ResponseMedicalHistory addPatientMedicalHistory(ResponseMedicalHistory responseMedicalHistory);
    public ResponseMedicalHistory getPatientMedicalHistory(int id);
    public List<ResponsePatients> getAllPatients();
}
