package com.example.subhankar.text2speech;
import android.app.Activity;

        import java.util.Locale;

        import java.util.Locale;

        import android.app.Activity;
        import android.os.Bundle;
        import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private Button speak,speedin,speeddec;
    private EditText text;
    private TextToSpeech tts;
    private String data;
    private SeekBar seekBar;
    private float speed;
    private TextView speedView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speed=(float)1.0;
        speak=(Button)findViewById(R.id.button1);
        text=(EditText)findViewById(R.id.editText1);
//        speedin=(Button)findViewById(R.id.button2);
//        speeddec=(Button)findViewById(R.id.button3);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        speedView = (TextView) findViewById(R.id.speed);
        speedView.setText("Speed: " + speed);
        tts= new TextToSpeech(this,new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                // TODO Auto-generated method stub
                if(!(status==TextToSpeech.ERROR))
                {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });
        speak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                data=text.getText().toString();
                tts.speak(data, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                speed = ((float)2/100) * progress;
                tts.setSpeechRate(speed);
                speedView.setText("Speed: " + speed);
                Log.println(Log.ASSERT,TAG, "Progress: " + progress + "\tSpeed: " + speed);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        speedin.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                speed+=0.1;
//                tts.setSpeechRate(speed);
//            }
//        });
//        speeddec.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                speed-=0.1;
//                tts.setSpeechRate(speed);
//            }
//        });
    }
}

