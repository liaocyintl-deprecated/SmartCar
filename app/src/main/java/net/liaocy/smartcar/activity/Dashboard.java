package net.liaocy.smartcar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.liaocy.smartcar.AppContext;
import net.liaocy.smartcar.R;


public class Dashboard extends AppCompatActivity {

    private final String TAG = "Dashboard";
    private Button btnSpeak, btnSpeakFlush;
    private TextView txtMsg;

    private AppContext appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.appContext = ((AppContext)getApplication()).getInstance();

        this.btnSpeak = this.findViewById(R.id.btnSpeak);
        this.btnSpeakFlush = this.findViewById(R.id.btnSpeakFlush);
        this.txtMsg = this.findViewById(R.id.txtMsg);

        this.btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "speak");

                appContext.getSpeaker().Speak("System Activated.");

                txtMsg.setText("here");
            }
        });

        this.btnSpeakFlush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "speak");

                appContext.getSpeaker().SpeakNow("System Activated.");

                txtMsg.setText("here");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop");
    }


}
