package com.example.subhankar.text2speech;
import android.app.Activity;

        import java.util.Locale;

        import java.util.Locale;

        import android.app.Activity;
        import android.os.Bundle;
        import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button speak,speedin,speeddec;
    EditText text;
    TextToSpeech tts;
    String data;
    float speed;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speed=(float)1.0;
        speak=(Button)findViewById(R.id.button1);
        text=(EditText)findViewById(R.id.editText1);
        speedin=(Button)findViewById(R.id.button2);
        speeddec=(Button)findViewById(R.id.button3);
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
        speedin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                speed+=0.1;
                tts.setSpeechRate(speed);
            }
        });
        speeddec.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                speed-=0.1;
                tts.setSpeechRate(speed);
            }
        });
    }
}

