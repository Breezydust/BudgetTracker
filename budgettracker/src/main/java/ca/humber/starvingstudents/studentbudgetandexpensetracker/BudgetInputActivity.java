//This activity will allow the user to sub-categorise their budget and create different custom categories. These categories will be fed into the expenses fragment as well.
//Team name: Starving Students

package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BudgetInputActivity extends AppCompatActivity {

    private EditText categoryinput;
    private Button savecategory;
    private TextView currenttotalbudgetview;
    private SeekBar transportationseekbar;
    private TextView transportationseekbartext;
    private SeekBar foodseekbar;
    private TextView foodseekbartext;
    private SeekBar entertainmentseekbar;
    private TextView entertainmentseekbartext;
    private SeekBar billsseekbar;
    private TextView billsseekbartext;
    private SeekBar miscseekbar;
    private TextView miscseekbartext;
    private SeekBar groceriesseekbar;
    private TextView groceriesseekbartext;
    private TextView totalseekbarvalue;
    private float totalbudget;
    private int budgetpercent;
    private int income;
    private float totalseekbarvaluefloat = 0;
    private Button savebutton;
    private Button resetbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        currenttotalbudgetview = (TextView)findViewById(R.id.current_budget_textview);
        totalseekbarvalue = (TextView)findViewById(R.id.total_seekbar_value);
        totalseekbarvalue.setText(Integer.toString(0));

        //logic to map out transporation seekbar/textview, initialise and handle touching/tracking
        transportationseekbar = (SeekBar)findViewById(R.id.transport_seekbar);
        transportationseekbartext = (TextView)findViewById(R.id.transport_seekbar_progress);

        transportationseekbartext.setText(Integer.toString(transportationseekbar.getProgress()));
        transportationseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float transportationdollars = (transportationseekbar.getProgress()*totalbudget)/100;
                transportationseekbartext.setText(Float.toString(transportationdollars));
                totalseekbarvaluefloat += transportationdollars;
                totalseekbarvalue.setText(Float.toString(totalseekbarvaluefloat));
            }
        });

        //logic to map out food seekbar/textview, initialise and handle touching/tracking
        foodseekbar = (SeekBar)findViewById(R.id.food_seekbar);
        foodseekbartext = (TextView)findViewById(R.id.food_seekbar_progress);

        foodseekbartext.setText(Integer.toString(foodseekbar.getProgress()));
        foodseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float fooddollars = (foodseekbar.getProgress()*totalbudget)/100;
                foodseekbartext.setText(Float.toString(fooddollars));
                totalseekbarvaluefloat += fooddollars;
                totalseekbarvalue.setText(Float.toString(totalseekbarvaluefloat));
            }
        });

        //logic to map out entertainment seekbar/textview, initialise and handle touching/tracking
        entertainmentseekbar = (SeekBar)findViewById(R.id.entertainment_seekbar);
        entertainmentseekbartext = (TextView)findViewById(R.id.entertainment_seekbar_progress);

        entertainmentseekbartext.setText(Integer.toString(entertainmentseekbar.getProgress()));
        entertainmentseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float entertainmentdollars = (entertainmentseekbar.getProgress()*totalbudget)/100;
                entertainmentseekbartext.setText(Float.toString(entertainmentdollars));
                totalseekbarvaluefloat += entertainmentdollars;
                totalseekbarvalue.setText(Float.toString(totalseekbarvaluefloat));
            }
        });

        //logic to map out bills seekbar/textview, initialise and handle touching/tracking
        billsseekbar = (SeekBar)findViewById(R.id.bills_seekbar);
        billsseekbartext = (TextView)findViewById(R.id.bills_seekbar_progress);

        billsseekbartext.setText(Integer.toString(billsseekbar.getProgress()));
        billsseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float billsdollars = (billsseekbar.getProgress()*totalbudget)/100;
                billsseekbartext.setText(Float.toString(billsdollars));
                totalseekbarvaluefloat += billsdollars;
                totalseekbarvalue.setText(Float.toString(totalseekbarvaluefloat));
            }
        });

        //logic to map out misc seekbar/textview, initialise and handle touching/tracking
        miscseekbar = (SeekBar)findViewById(R.id.misc_seekbar);
        miscseekbartext = (TextView)findViewById(R.id.misc_seekbar_progress);

        miscseekbartext.setText(Integer.toString(miscseekbar.getProgress()));
        miscseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float miscdollars = (miscseekbar.getProgress()*totalbudget)/100;
                miscseekbartext.setText(Float.toString(miscdollars));
                totalseekbarvaluefloat += miscdollars;
                totalseekbarvalue.setText(Float.toString(totalseekbarvaluefloat));
            }
        });

        //logic to map out groceries seekbar/textview, initialise and handle touching/tracking
        groceriesseekbar = (SeekBar)findViewById(R.id.groceries_seekbar);
        groceriesseekbartext = (TextView)findViewById(R.id.groceries_seekbar_progress);

        groceriesseekbartext.setText(Integer.toString(groceriesseekbar.getProgress()));
        groceriesseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float groceriesdollars = (groceriesseekbar.getProgress()*totalbudget)/100;
                groceriesseekbartext.setText(Float.toString(groceriesdollars));
                totalseekbarvaluefloat += groceriesdollars;
                totalseekbarvalue.setText(Float.toString(totalseekbarvaluefloat));
            }
        });


        final SharedPreferences budgetvaluespref = this.getSharedPreferences("budgetvalues",MODE_PRIVATE);

        //get the user's total income and budget and display it
        income = budgetvaluespref.getInt("monthlyincome",1);
        budgetpercent = budgetvaluespref.getInt("budgetpercentage",1);
        totalbudget = (income * budgetpercent) / 100;
        currenttotalbudgetview.append(Float.toString(totalbudget));

        savebutton = (Button)findViewById(R.id.budget_save_button);
        resetbutton = (Button)findViewById(R.id.budget_reset_button);

        savebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v){
                if (totalseekbarvaluefloat > totalbudget){
                    Toast.makeText(BudgetInputActivity.this, "Total budgeted value cannot exceed your actual budget", Toast.LENGTH_LONG).show();
                }
                else{
                    //Code to save comes soon
                    Toast.makeText(BudgetInputActivity.this, "Budgeting preferences saved!", Toast.LENGTH_LONG).show();
                }
            }
        });

        resetbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v){
               transportationseekbar.setProgress(0);
               transportationseekbartext.setText(Float.toString(transportationseekbar.getProgress()));
               foodseekbar.setProgress(0);
               foodseekbartext.setText(Float.toString(foodseekbar.getProgress()));
               entertainmentseekbar.setProgress(0);
               entertainmentseekbartext.setText(Float.toString(entertainmentseekbar.getProgress()));
               billsseekbar.setProgress(0);
               billsseekbartext.setText(Float.toString(billsseekbar.getProgress()));
               miscseekbar.setProgress(0);
               miscseekbartext.setText(Float.toString(miscseekbar.getProgress()));
               groceriesseekbar.setProgress(0);
               groceriesseekbartext.setText(Float.toString(groceriesseekbar.getProgress()));
               totalseekbarvaluefloat = 0;
               totalseekbarvalue.setText(Float.toString(totalseekbarvaluefloat));
            }
        });

    }
}


