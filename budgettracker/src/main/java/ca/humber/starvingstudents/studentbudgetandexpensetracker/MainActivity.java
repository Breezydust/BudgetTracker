package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        R.string.dial_toast, Toast.LENGTH_SHORT)
                        .show();


                Uri number = Uri.parse("tel:6472745967");
                Intent dial = new Intent(Intent.ACTION_DIAL,number);
                startActivity(dial);

                //startActivity(new Intent(MainActivity.this, Activity2.class));


            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        R.string.budget_toast, Toast.LENGTH_SHORT)
                        .show();
                startActivity(new Intent(MainActivity.this, Activity2.class));


            }
});
    }
}
