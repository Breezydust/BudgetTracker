//This activity will allow the user to sub-categorise their budget and create different custom categories. These categories will be fed into the expenses fragment as well.

package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BudgetInputActivity extends AppCompatActivity {

    private EditText categoryinput;
    private Button savecategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        categoryinput = (EditText)findViewById(R.id.customcategoryinput);
        savecategory = (Button)findViewById(R.id.savecustomcategorybutton);

        final List<String> customcategories = new ArrayList<String>();
        savecategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String customcategoryval = categoryinput.getText().toString();

                if (TextUtils.isEmpty(customcategoryval)){
                    categoryinput.setError("Custom category can't be blank");
                }
                else{
                    customcategories.add(customcategoryval);
                    Toast.makeText(BudgetInputActivity.this, "Custom category saved", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}


