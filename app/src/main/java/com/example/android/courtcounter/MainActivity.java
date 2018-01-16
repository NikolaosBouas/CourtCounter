package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamA = 0;
    int foulsTeamB = 0;
    int periodNumber = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button two_point_button_a = (Button) findViewById(R.id.two_point_a);
        two_point_button_a.setRotation(45);
        Button two_point_button_a2 = (Button) findViewById(R.id.two_point_a2);
        two_point_button_a2.setRotation(-45);
        Button two_point_button_b = (Button) findViewById(R.id.two_point_b);
        two_point_button_b.setRotation(-45);
        Button two_point_button_b2 = (Button) findViewById(R.id.two_point_b2);
        two_point_button_b2.setRotation(45);
        TextView team_b_txt = (TextView) findViewById(R.id.team_b_textview);
        team_b_txt.setRotation(90);
        TextView team_a_txt = (TextView) findViewById(R.id.team_a_textview);
        team_a_txt.setRotation(-90);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeTeamA(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoTeamA(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void addOneTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given fouls for Team B.
     */
    public void displayFoulsForTeamB(int fouls) {
        TextView foulsView = (TextView) findViewById(R.id.b_fouls_number);
        foulsView.setText(String.valueOf(fouls));
    }

    /**
     * Displays the given fouls for Team A.
     */
    public void displayFoulsForTeamA(int fouls) {
        TextView foulsView = (TextView) findViewById(R.id.a_fouls_number);
        foulsView.setText(String.valueOf(fouls));
    }

    /**
     * Displays the period number .
     */
    public void displayPeriod(int periodNumber) {
        TextView PeriodsView = (TextView) findViewById(R.id.period_number);
        PeriodsView.setText(String.valueOf(periodNumber));
    }

    public void addThreeTeamB(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoTeamB(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void addOneTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void resetBoth(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        periodNumber = 1;
        displayPeriod(periodNumber);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulsForTeamA(foulsTeamA);
        displayFoulsForTeamB(foulsTeamB);
    }

    public void addOneFoulTeamA(View view) {
        if (foulsTeamA >= 4) {
            Toast.makeText(this, R.string.b_has_free_throw, Toast.LENGTH_SHORT).show();
        }
        foulsTeamA = foulsTeamA + 1;
        displayFoulsForTeamA(foulsTeamA);
    }

    public void addOneFoulTeamB(View view) {
        if (foulsTeamB >= 4) {
            Toast.makeText(this, R.string.a_has_free_throw, Toast.LENGTH_SHORT).show();
        }
        foulsTeamB = foulsTeamB + 1;
        displayFoulsForTeamB(foulsTeamB);
    }

    public void nextPeriod(View view) {
        if (periodNumber >= 4) {
            return;
        }
        foulsTeamA = 0;
        displayFoulsForTeamA(foulsTeamA);
        foulsTeamB = 0;
        displayFoulsForTeamB(foulsTeamB);
        periodNumber = periodNumber + 1;
        displayPeriod(periodNumber);
    }

}
