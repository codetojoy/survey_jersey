package net.codetojoy.survey.service;

import net.codetojoy.survey.model.*;
import static net.codetojoy.survey.model.Constants.*;

import java.util.*;
import java.util.stream.*;

public class SurveyService {
    // This is obviously a toy example.
    private static Map<Long,Survey> mockStorage = new HashMap<>();
    private static long nextId;

    static {
        SurveyFactory surveyFactory = new SurveyFactory();

        Survey survey1 = surveyFactory.buildSurvey(SURVEY1_ID);
        Survey survey2 = surveyFactory.buildSurvey(SURVEY2_ID);
        Survey survey3 = surveyFactory.buildSurvey(SURVEY3_ID);

        mockStorage.put(survey1.getId(), survey1);
        mockStorage.put(survey2.getId(), survey2);
        mockStorage.put(survey3.getId(), survey3);

        nextId = Constants.NEXT_ID;
    }

    public List<Survey> getSurveys() {
        List<Survey> surveys = mockStorage.entrySet()
                                          .stream()
                                          .map(Map.Entry::getValue)
                                          .collect(Collectors.toList());

        return surveys;
    }

    public Survey getSurvey(long id) {
        Survey survey = mockStorage.get(id);
        return survey;
    }

    public long createSurvey(long userId) {
        long surveyId = nextId;
        Survey survey = new SurveyFactory().buildSurvey(surveyId, userId);
        mockStorage.put(surveyId, survey);
        nextId++;
        return surveyId;
    }

    /*
    public void updateGreeting(long id, Greeting greeting) {
        mockStorage.put(id, greeting);
    }
    */
}
