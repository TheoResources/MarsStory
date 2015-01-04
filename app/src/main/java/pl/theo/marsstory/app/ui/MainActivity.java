package pl.theo.marsstory.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import pl.theo.marsstory.app.R;


public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button runStoryActivityButton = (Button) findViewById(R.id.runStoryActivityButton);

    runStoryActivityButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent storyActivity = new Intent(MainActivity.this.getApplicationContext(), StoryActivity.class);
        startActivity(storyActivity);
      }
    });
  }

}
