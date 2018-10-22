package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class BudgetInputActivityFragment extends Fragment {

    private EditText incomeentry;
    private EditText percententry;
    private EditText goalentry;
    private EditText timelineentry;
    private Button launchbudgetbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_budget_input, container, false);

        incomeentry = (EditText)view.findViewById(R.id.income_input_textbox);
        percententry = (EditText)view.findViewById(R.id.budget_percent_textbox);
        goalentry = (EditText)view.findViewById(R.id.budget_goal_textbox);
        timelineentry = (EditText)view.findViewById(R.id.budget_timeline_textbox);

        launchbudgetbutton = (Button)view.findViewById(R.id.budget_button);
        launchbudgetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String incomeval = incomeentry.getText().toString();
                String percentval = percententry.getText().toString();
                String goalval = goalentry.getText().toString();
                String timelineval = timelineentry.getText().toString();

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
                    Intent intent = new Intent(getActivity(), BudgetInputActivity.class);
                    intent.putExtra("incomeval",incomeval);
                    intent.putExtra("percentval",percentval);
                    intent.putExtra("goalval",goalval);
                    intent.putExtra("timelineval",timelineval);
                    startActivity(intent);
                }

            }
        });

        return view;
    }
}
