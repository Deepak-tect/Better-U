package com.healthcare.healthcare.Services.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.healthcare.Models.Activity;
import com.healthcare.healthcare.Models.Question;
import com.healthcare.healthcare.Models.QuestionOption;
import com.healthcare.healthcare.Payloads.ResponseActivity;
import com.healthcare.healthcare.Payloads.ResponseOption;
import com.healthcare.healthcare.Payloads.ResponseQuestion;
import com.healthcare.healthcare.Repositories.ActivityRepo;
import com.healthcare.healthcare.Repositories.QuestionRepo;
import com.healthcare.healthcare.Services.QuestionService;
import java.util.*;

@Service
public class QuestionServiceImp implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired 
    private ActivityRepo activityRepo;

    @Override
    public ResponseQuestion addQuestion(ResponseQuestion responseQuestion, int id) {
        Question question = this.modelMapper.map(responseQuestion, Question.class);
        Optional<Activity> activity = this.activityRepo.findById(id);
        List<QuestionOption> options = new ArrayList<>();
        for(ResponseOption responseOption : responseQuestion.getOption()){
            QuestionOption option = this.modelMapper.map(responseOption, QuestionOption.class);
            option.setQuestion(question);
            options.add(option);
        }
        question.setOption(options);
        question.setActivity(activity.get());
        Question updatedQuestion = this.questionRepo.save(question);
        ResponseQuestion result = this.modelMapper.map(updatedQuestion, ResponseQuestion.class);
        result.setRresponseActivity(this.modelMapper.map(activity.get(), ResponseActivity.class));
        return result;
    }

    @Override
    public List<ResponseQuestion> getAllQuestion() {
        List<Question> questions = this.questionRepo.findAll();
        List<ResponseQuestion> result = new ArrayList<>();
        for(Question question : questions){
            ResponseQuestion responseQuestion = this.modelMapper.map(question, ResponseQuestion.class);
            responseQuestion.setRresponseActivity(this.modelMapper.map(question.getActivity(), ResponseActivity.class));
            result.add(responseQuestion);
        }
        return result;
    }
    
}
