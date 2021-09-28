package rob.myappcompany.timercountdowndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String tag = MainActivity.class.getSimpleName();

    TextView countTextView;
    Button stopButton;
    Button startButton;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextView = findViewById(R.id.countTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
            }
        });
        countDownTimer = new CountDownTimer(10000, 100) {
            @Override
            public void onTick(long l) {
                Log.i(tag, String.valueOf(l));
                countTextView.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Log.i(tag, "ist beende");
            }
        };


    }



}