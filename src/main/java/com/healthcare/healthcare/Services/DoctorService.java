package com.healthcare.healthcare.Services;

import com.healthcare.healthcare.Payloads.ResponseDoctor;
import com.healthcare.healthcare.Payloads.ResponseDoctorDetail;

public interface DoctorService {
    public ResponseDoctor getAllPatientOfDoctor();
    public ResponseDoctorDetail getDoctorDetails(int id);
}
