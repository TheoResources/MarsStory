package pl.theo.marsstory.app.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import pl.theo.marsstory.app.R;
import pl.theo.marsstory.app.model.Stories;

public class StoryActivity extends Activity {

  private Stories stories;
  ImageView storyImageView;
  TextView storyDescription;
  Button choice0;
  Button choice1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_story);

    storyImageView = (ImageView) findViewById(R.id.storyImageView);
    storyDescription = (TextView) findViewById(R.id.storyDescription);
    choice0 = (Button) findViewById(R.id.choice0);
    choice1 = (Button) findViewById(R.id.choice1);

    choice0.setTag(new ButtonTag(0));
    choice1.setTag(new ButtonTag(1));

    stories = new Stories();

    setStoryOnView(0);

    choice0.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        storyOnClick(getChoiceId(choice0));
      }
    });

    choice1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        storyOnClick(getChoiceId(choice1));
      }
    });

  }

  private void storyOnClick(int choiceId) {
    if (stories.hasNextStoryId(choiceId)) {
      setStoryOnView(stories.getNextStoryId(choiceId));
    } else {
      finish();
    }
  }

  private void setStoryOnView(int storyId) {
    stories.setStoryId(storyId);
    storyDescription.setText(stories.getDescription());
    storyImageView.setImageResource(stories.getImage());
    setStoryChoicesOnVIew(choice0);
    setStoryChoicesOnVIew(choice1);
  }

  private void setStoryChoicesOnVIew(Button button) {
    if (stories.hasChoice(getChoiceId(button))) {
      button.setText(stories.getChoiceText(getChoiceId(button)));
    } else {
      button.setVisibility(View.INVISIBLE);
    }
  }

  private int getChoiceId(Button button) {
    return ((ButtonTag)button.getTag()).getId();
  }
}
