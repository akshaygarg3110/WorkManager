package Rating.abstractfactory;
import Rating.PersistenceRatingMock;
import Rating.RatingAssignee;
import Rating.RatingQuestionnaire;
import Rating.interfaces.*;
public class RatingFactoryTest implements IRatingFactoryTest
{
    private static IRatingFactoryTest uniqueInstance = null;

    private RatingFactoryTest()
    {

    }

    public static IRatingFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new RatingFactoryTest();
        }
        return uniqueInstance;
    }

    public IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire)
    {
        IPersistenceRating persistenceRatingMock = getPersistenceRatingMock();
        return new RatingAssignee(questionnaire, persistenceRatingMock);
    }

    public IPersistenceRating getPersistenceRatingMock()
    {
        return new PersistenceRatingMock();
    }

    public IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating)
    {
        return new RatingQuestionnaire(userSatisfactionRating, userFeedbackRating, userExperienceRating, userRecommendationRating);
    }
}