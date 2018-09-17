package net.liaocy.smartcar.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import net.liaocy.smartcar.AppContext;
import net.liaocy.smartcar.R;


public class Audio extends Fragment {

    private final String TAG = "Dashboard";
    private Button btnSpeak, btnSpeakFlush;
    private TextView txtMsg;

    private AppContext appContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_audio, container, false);
        return rootView;
    }

//    @Override
//    protected void onCreateView(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dashboard);
//        this.appContext = ((AppContext)getApplication()).getInstance();
//
//        this.btnSpeak = this.findViewById(R.id.btnSpeak);
//        this.btnSpeakFlush = this.findViewById(R.id.btnSpeakFlush);
//        this.txtMsg = this.findViewById(R.id.txtMsg);
//
//        this.btnSpeak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "speak");
//
//                appContext.getBizSpeaker().Speak("System Activated.");
//
//                txtMsg.setText("here");
//            }
//        });
//
//        this.btnSpeakFlush.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "speak");
//
//                appContext.getBizSpeaker().SpeakNow("燃油剩余12%");
//
//                txtMsg.setText("here");
//            }
//        });
//    }


}
