package com.dewey.jsdroidy;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up user button and user text

        final Button runButton = (Button) findViewById(R.id.button);
        final EditText htmlInput = (EditText) findViewById(R.id.editText);
        final EditText jsInput = (EditText) findViewById(R.id.editText2);
        final EditText cssInput = (EditText) findViewById(R.id.editText3);

        final Switch jqueryswitch = (Switch) findViewById(R.id.jqueryswitch);

        runButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Perform action on click

                String html = htmlInput.getText().toString();
                String js = jsInput.getText().toString();
                String css = cssInput.getText().toString();

                String postmessage = "http://jsfiddle.net/api/post/";

                // Contact jsfiddle api by creating a string based on user specified settings

                if(jqueryswitch.isChecked() == true){

                    // Add jquery to the post message

                    postmessage = "http://jsfiddle.net/api/post/jquery/1.9/";

                }

                // Call the activity

                Intent intent = new Intent(getApplicationContext(), output.class);
                intent.putExtra("HTML",html);
                intent.putExtra("JS",js);
                intent.putExtra("CSS",css);


                startActivity(intent);


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void callServer(String url){





    }

}
