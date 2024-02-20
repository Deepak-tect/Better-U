package com.healthcare.healthcare.Services;

import com.healthcare.healthcare.Payloads.ResponseQuestion;
import java.util.*;

public interface QuestionService {
    public ResponseQuestion addQuestion(ResponseQuestion responseQuestion, int id);
    public List<ResponseQuestion> getAllQuestion();
}
