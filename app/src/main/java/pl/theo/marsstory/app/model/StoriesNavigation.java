package pl.theo.marsstory.app.model;

/**
 * Created by michal.matlosz on 03.01.2015.
 */
public class StoriesNavigation {

  private int[][] choiceMap = {
      {1, 2},
      {3, 4},
      {4, 6},
      {5, 4},
      {5, 6}
  };

  private String[][] choiceButtonNameMap = {
      {"STOP AND INVESTIGATE", "CONTINUE HOME TO EARTH"},
      {"EXPLORE THE CAVE", "EXPLORE THE ROVER"},
      {"HEAD BACK TO MARS TO INVESTIGATE", "CONTINUE HOME TO EARTH"},
      {"CONTINUE TOWARDS THE FAINT LIGHT", "REFILL AT SHIP AND EXPLORE THE ROVER"},
      {"EXPLORE THE COORDINATES", "RETURN TO EARTH"},
      {"PLAY AGAIN"},
      {"PLAY AGAIN"}
  };


  public boolean hasNextStoryIdForChoiceId(int storyId, int choiceId) {
    if (isElementExists(choiceMap, storyId)) {
      return true;
    }
    return false;
  }

  public boolean hasChoice(int storyId, int choiceId) {
    if (isElementExists(choiceButtonNameMap, storyId)) {
      if (isElementExists(choiceButtonNameMap[storyId], choiceId)) {
        return true;
      }
    }
    return false;
  }

  public String getChoiceTextLabel(int storyId, int choiceId) {
    return choiceButtonNameMap[storyId][choiceId];
  }

  public int getNextStoryIdForChoiceId(int storyId, int choiceId) {
    return choiceMap[storyId][choiceId];
  }

  public static boolean isElementExists(Object[] data, int index) {
    try {
      Object o = data[index];
      return true;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}
