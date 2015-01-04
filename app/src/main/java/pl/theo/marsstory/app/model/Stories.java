package pl.theo.marsstory.app.model;

import pl.theo.marsstory.app.R;

/**
 * Created by michal.matlosz on 03.01.2015.
 */
public class Stories {

  private int storyId = 0;

  private String[] storyDescriptions = {
      "Page 0 desc",
      "Page 1 desc",
      "Page 2 desc",
      "Page 3 desc",
      "Page 4 desc",
      "Page 5 desc",
      "Page 6 desc"
  };

  private int[] storyImages = {
      R.drawable.page0,
      R.drawable.page1,
      R.drawable.page2,
      R.drawable.page3,
      R.drawable.page4,
      R.drawable.page5,
      R.drawable.page6
  };

  private StoriesNavigation storiesNavigation = new StoriesNavigation();

  public String getDescription() {
    return storyDescriptions[storyId];
  }

  public void setStoryId(int storyId) {
    this.storyId = storyId;
  }

  public int getImage() {
    return storyImages[storyId];
  }

  public String getChoiceText(int choiceId) {
    return storiesNavigation.getChoiceTextLabel(storyId, choiceId);
  }

  public int getNextStoryId(int choiceId) {
    return storiesNavigation.getNextStoryIdForChoiceId(storyId, choiceId);
  }

  public boolean hasNextStoryId(int choiceId) {
    return storiesNavigation.hasNextStoryIdForChoiceId(storyId, choiceId);
  }

  public boolean hasChoice(int choiceId) {
    return storiesNavigation.hasChoice(storyId, choiceId);
  }
}
