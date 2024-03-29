package com.healthcare.healthcare.Services.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.healthcare.healthcare.Exceptions.ResourceNotFoundExecption;
import com.healthcare.healthcare.Models.Activity;
import com.healthcare.healthcare.Models.Assignment;
import com.healthcare.healthcare.Models.AssignmentActivity;
import com.healthcare.healthcare.Models.Doctor;
import com.healthcare.healthcare.Models.Patient;
import com.healthcare.healthcare.Models.Question;
import com.healthcare.healthcare.Models.User;
import com.healthcare.healthcare.Payloads.RequestAssignment;
import com.healthcare.healthcare.Payloads.ResponseActivity;
import com.healthcare.healthcare.Payloads.ResponseAssignment;
import com.healthcare.healthcare.Payloads.ResponseAssignmentActivity;
import com.healthcare.healthcare.Payloads.ResponseDoctor;
import com.healthcare.healthcare.Payloads.ResponseQuestion;
import com.healthcare.healthcare.Repositories.ActivityRepo;
import com.healthcare.healthcare.Repositories.AssignmentActivityRepo;
import com.healthcare.healthcare.Repositories.AssignmentRepo;
import com.healthcare.healthcare.Repositories.PatientRepo;
import com.healthcare.healthcare.Services.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private AssignmentActivityRepo assignmentActivityRepo;
     @Override
    public ResponseAssignment addAssignment(RequestAssignment requestAssignment) {
        int id = requestAssignment.getId();
        int level = requestAssignment.getItem_level();
        boolean completed = requestAssignment.isCompleted();
        List<Integer> activityIds = requestAssignment.getActivity(); 
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Doctor doctor = user.getDoctor();
        Patient patient = this.patientRepo.findById(id).orElse(null);

        Assignment assignment = new Assignment();
        assignment.setDoctor(doctor);
        assignment.setPatient(patient);

        // Save the Assignment object first
        assignment = assignmentRepo.save(assignment);

        List<AssignmentActivity> assignmentActivities = new ArrayList<>();
        for(Integer activityId : activityIds){
            Activity activity = this.activityRepo.findById(activityId).orElse(null);
            if (activity != null) {
                AssignmentActivity assignmentActivity = new AssignmentActivity();
                assignmentActivity.setActivity(activity);
                assignmentActivity.setAssignment(assignment);
                assignmentActivity.setCompleted(completed);
                assignmentActivity.setItem_level(level);
                
                assignmentActivities.add(assignmentActivity);
            }
        }
        
        // Save the AssignmentActivity objects

        assignmentActivityRepo.saveAll(assignmentActivities);
        
        // Map to ResponseAssignment and return

        ResponseAssignment responseAssignment = new ResponseAssignment();
        List<ResponseAssignmentActivity> responseAssignmentActivities = new ArrayList<>();
        responseAssignment.setDoctor(this.modelMapper.map(doctor, ResponseDoctor.class));
        
        for(AssignmentActivity activity : assignmentActivities){
            ResponseAssignmentActivity responseAssignmentActivity = new ResponseAssignmentActivity();
             responseAssignmentActivity.setCompleted(completed);
             responseAssignmentActivity.setItem_level(level);
             ResponseActivity responseActivity = this.modelMapper.map(activity, ResponseActivity.class);
             responseActivity.setName(activity.getActivity().getName());
             responseActivity.setDescription(activity.getActivity().getDescription());
             List<ResponseQuestion> responseQuestions = new ArrayList<>();
             for(Question question : activity.getActivity().getQuestions()){
                responseQuestions.add(this.modelMapper.map(question , ResponseQuestion.class));
             }
             responseActivity.setQuestions(responseQuestions);
             responseAssignmentActivity.setResponseActivity(responseActivity);
             responseAssignmentActivities.add(responseAssignmentActivity);
        }
        responseAssignment.setActivities(responseAssignmentActivities);
        return responseAssignment;
    
    }
    @Override
    public ResponseAssignment getAssignment() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = user.getPatient();
        Assignment assignment = this.assignmentRepo.findByPatient(patient);
        Doctor doctor = assignment.getDoctor();
        List<AssignmentActivity> assignmentActivities = assignment.getAssignmentActivities();
        ResponseAssignment responseAssignment = new ResponseAssignment();
        List<ResponseAssignmentActivity> responseAssignmentActivities = new ArrayList<>();
        responseAssignment.setDoctor(this.modelMapper.map(doctor, ResponseDoctor.class));
        
        for(AssignmentActivity activity : assignmentActivities){
            ResponseAssignmentActivity responseAssignmentActivity = new ResponseAssignmentActivity();
             responseAssignmentActivity.setCompleted(activity.isCompleted());
             responseAssignmentActivity.setItem_level(activity.getItem_level());
             ResponseActivity responseActivity = this.modelMapper.map(activity, ResponseActivity.class);
             responseActivity.setName(activity.getActivity().getName());
             responseActivity.setDescription(activity.getActivity().getDescription());
             List<ResponseQuestion> responseQuestions = new ArrayList<>();
             for(Question question : activity.getActivity().getQuestions()){
                responseQuestions.add(this.modelMapper.map(question , ResponseQuestion.class));
             }
             responseActivity.setQuestions(responseQuestions);
             responseAssignmentActivity.setResponseActivity(responseActivity);
             responseAssignmentActivities.add(responseAssignmentActivity);
        }
        responseAssignment.setActivities(responseAssignmentActivities);
        return responseAssignment;
    }
    @Override
    public ResponseAssignment getAssignmentByDoctor(int id) {
        
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Patient> patients = user.getDoctor().getPatients();
        for(Patient patient : patients){
            if(patient.getId() == id){
                Assignment assignment = this.assignmentRepo.findByPatient(patient);
                Doctor doctor = assignment.getDoctor();
                List<AssignmentActivity> assignmentActivities = assignment.getAssignmentActivities();
                ResponseAssignment responseAssignment = new ResponseAssignment();
                List<ResponseAssignmentActivity> responseAssignmentActivities = new ArrayList<>();
                responseAssignment.setDoctor(this.modelMapper.map(doctor, ResponseDoctor.class));
                
                for(AssignmentActivity activity : assignmentActivities){
                    ResponseAssignmentActivity responseAssignmentActivity = new ResponseAssignmentActivity();
                    responseAssignmentActivity.setCompleted(activity.isCompleted());
                    responseAssignmentActivity.setItem_level(activity.getItem_level());
                    ResponseActivity responseActivity = this.modelMapper.map(activity, ResponseActivity.class);
                    responseActivity.setName(activity.getActivity().getName());
                    responseActivity.setDescription(activity.getActivity().getDescription());
                    List<ResponseQuestion> responseQuestions = new ArrayList<>();
                    for(Question question : activity.getActivity().getQuestions()){
                        responseQuestions.add(this.modelMapper.map(question , ResponseQuestion.class));
                    }
                    responseActivity.setQuestions(responseQuestions);
                    responseAssignmentActivity.setResponseActivity(responseActivity);
                    responseAssignmentActivities.add(responseAssignmentActivity);
                }
                responseAssignment.setActivities(responseAssignmentActivities);
                return responseAssignment;
            }
        }
        throw new ResourceNotFoundExecption("Patient id", "id", id);
    }

    
}
