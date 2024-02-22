package com.healthcare.healthcare.Services.ServiceImpl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.healthcare.healthcare.Models.Activity;
import com.healthcare.healthcare.Models.Answer;
import com.healthcare.healthcare.Models.Assignment;
import com.healthcare.healthcare.Models.AssignmentActivity;
import com.healthcare.healthcare.Models.Patient;
import com.healthcare.healthcare.Models.Question;
import com.healthcare.healthcare.Models.User;
import com.healthcare.healthcare.Repositories.AnswerRepo;
import com.healthcare.healthcare.Repositories.AssignmentActivityRepo;
import com.healthcare.healthcare.Repositories.AssignmentRepo;
import com.healthcare.healthcare.Repositories.QuestionRepo;
import com.healthcare.healthcare.Services.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private QuestionRepo questionRepo;


    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private AssignmentActivityRepo assignmentActivityRepo;


    @Override
    public void addAnswerOfPatient(JsonNode jsonNode) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = user.getPatient();
        Assignment assignment = this.assignmentRepo.findByPatient(patient);
        List<AssignmentActivity> assignmentActivities = assignment.getAssignmentActivities();
        Iterator<JsonNode> elements = jsonNode.elements();
        while(elements.hasNext()){
            JsonNode ansJsonNode = elements.next();
            int qid = ansJsonNode.get("questionId").asInt();
            String choice = ansJsonNode.get("choice").asText();
            Question question = this.questionRepo.findById(qid).get();
            for(AssignmentActivity assignmentActivity : assignmentActivities){
                Activity activity = assignmentActivity.getActivity();
                if (activity.getQuestions().contains(question)) {
                    assignmentActivity.setCompleted(true);
                    assignmentActivityRepo.save(assignmentActivity);
                    break;
                }
            }
            Answer answer = new Answer();
            answer.setPatient(patient);
            answer.setQuestion(question);
            answer.setChoice(choice);
            this.answerRepo.save(answer);
        }
    }
    
}
