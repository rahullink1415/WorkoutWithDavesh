package com.rahulkumar.workoutwithdavesh;

import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar, progressBarB, progressBarC, progressBarD;
    private CountDownTimer mCountDownTimer;
    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBarB = findViewById(R.id.progressBarB);
        progressBarC = findViewById(R.id.progressBarC);
        progressBarD = findViewById(R.id.progressBarD);
        time = findViewById(R.id.timeTxtId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            progressBarB.setIndeterminateDrawable(getDrawable(R.drawable.progrss));

            progressBarC.setIndeterminateDrawable(getDrawable(R.drawable.custom_progress_bar));

            progressBarC.getIndeterminateDrawable().setColorFilter(0xFFFFFFAA, PorterDuff.Mode.MULTIPLY);

        }

        final int[] i = {0};
        progressBarD.setProgress(0);
        progressBarD.setMax(100);
        progressBarD.setSecondaryProgress(10);
        progressBarD.setProgressDrawable(getDrawable(R.drawable.circular));

        mCountDownTimer = new CountDownTimer(100000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                time.setText(String.valueOf(millisUntilFinished / 1000));
                int progress = (int) (millisUntilFinished / 100);
                i[0]++;
                //(i[0] *100/(100))
                progressBarD.setProgress((i[0] * 100 / (100)));
                Log.e("Log_tag", "Tick of Progress" + i[0] + "rrrr" + (i[0] * 100 / (300)) + "progress" + progressBar.getProgress());
            }

            @Override
            public void onFinish() {
                //  i[0]++;
                progressBarD.setProgress(100);

                Toast.makeText(MainActivity.this, "timer over!", Toast.LENGTH_SHORT).show();

            }
        };
        mCountDownTimer.start();
        //progressBarC.getIndeterminateDrawable().setColorFilter(0xFF0000AA, PorterDuff.Mode.MULTIPLY);

        //progressBar.setIndeterminate(true);
        // progressBar.showContextMenu();

    }
}
