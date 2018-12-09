//this fragment allows the user to input their income, percent of income they want to save/budget, their savings goal, and the timeline for saving. it links to the full budget activity
//Team name: Starving Students

package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BudgetInputActivityFragment extends Fragment {

    private EditText incomeentry;
    private EditText percententry;
    private EditText goalentry;
    private EditText timelineentry;
    private Button launchbudgetbutton;
    private Button categorybutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_budget_input, container, false);

        final SharedPreferences budgetvaluespref = this.getActivity().getSharedPreferences("budgetvalues", Context.MODE_PRIVATE);

        //This block of code assigns each view to a variable and populates them with the user's previously entered values, or default 0
        incomeentry = (EditText)view.findViewById(R.id.income_input_textbox);
        incomeentry.setText(String.valueOf(budgetvaluespref.getInt("monthlyincome",0)));
        percententry = (EditText)view.findViewById(R.id.budget_percent_textbox);
        percententry.setText(String.valueOf(budgetvaluespref.getInt("budgetpercentage",0)));
        goalentry = (EditText)view.findViewById(R.id.budget_goal_textbox);
        goalentry.setText(String.valueOf(budgetvaluespref.getInt("savingsgoal",0)));
        timelineentry = (EditText)view.findViewById(R.id.budget_timeline_textbox);
        timelineentry.setText(String.valueOf(budgetvaluespref.getInt("timeline",0)));

        launchbudgetbutton = (Button)view.findViewById(R.id.budget_button);
        launchbudgetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String incomeval = incomeentry.getText().toString();
                final String percentval = percententry.getText().toString();
                final String goalval = goalentry.getText().toString();
                final String timelineval = timelineentry.getText().toString();

                //checks if any field is empty
                if(TextUtils.isEmpty(incomeval)){
                    incomeentry.setError("Income cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(percentval)){
                    percententry.setError("Percent cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(goalval)){
                    goalentry.setError("Goal cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(timelineval)){
                    timelineentry.setError("Timeline cannot be empty");
                    return;
                }
                else{
                    //creates an alert to confirm whether the user wants to save the entered budget data or not
                    AlertDialog.Builder confirmation = new AlertDialog.Builder(getContext());

                    confirmation.setTitle("Confirm Budget Update");
                    confirmation.setMessage("Are you sure you want to update your budget?");
                    confirmation.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            //Saves the user data into sharedprefs then displays a toast confirming to the user
                            //Should probably switch to a SharedPreferences.Editor for performance sake
                            budgetvaluespref.edit().putInt("monthlyincome",Integer.parseInt(incomeval)).apply();
                            budgetvaluespref.edit().putInt("budgetpercentage",Integer.parseInt(percentval)).apply();
                            budgetvaluespref.edit().putInt("savingsgoal",Integer.parseInt(goalval)).apply();
                            budgetvaluespref.edit().putInt("timeline",Integer.parseInt(timelineval)).apply();

                            Toast.makeText(getContext(), "Data saved!", Toast.LENGTH_SHORT).show();
                        }
                    });

                    confirmation.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //If the user selects no, closes the alert/does nothing
                            dialog.dismiss();
                        }
                    });

                    AlertDialog confirmationalert = confirmation.create();
                    confirmationalert.show();

                }

            }
        });

        categorybutton = (Button)view.findViewById(R.id.add_cat_button);
        categorybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BudgetInputActivity.class);
                startActivity(intent);
            }
        });




        return view;
    }
}
