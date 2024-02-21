package com.healthcare.healthcare.Services;

import com.healthcare.healthcare.Payloads.RequestAssignment;
import com.healthcare.healthcare.Payloads.ResponseAssignment;

public interface AssignmentService {
    public ResponseAssignment addAssignment(RequestAssignment requestAssignment);
    public ResponseAssignment getAssignment();
    public ResponseAssignment getAssignmentByDoctor(int id);
}
