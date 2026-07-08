package com.ath.euroquiz.loaders;

import com.ath.euroquiz.enums.Category;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ath.euroquiz.enums.Category;
import com.ath.euroquiz.models.Question;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.List;
import java.lang.reflect.Type;

public class JsonQuestionLoader {
    public static List<Question> loadQuestions(Category category) {
        String fileName = category.getFileName();
        InputStream inputStream = JsonQuestionLoader.class.getResourceAsStream("/" + fileName);

        if (inputStream == null) {
            throw new RuntimeException("Could not find file: " + fileName);
        }

        Gson gson = new Gson();
        Type questionListType = new TypeToken<List<Question>>() {}.getType();

        return gson.fromJson(
                new InputStreamReader(inputStream),
                questionListType
        );
    }
}
