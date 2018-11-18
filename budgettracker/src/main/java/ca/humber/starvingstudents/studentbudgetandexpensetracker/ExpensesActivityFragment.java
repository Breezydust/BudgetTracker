//This fragment allows the user to quickly enter an expense; will pull possible categories from a predetermined list + any user defined categories within budgetinputactivity, and default
//today's date for time logging
package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpensesActivityFragment extends Fragment {

    private EditText expenseinput;
    private Spinner categoryselect;
    private Button quickentry;
    private Button expensehistory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expenses, container, false);

        expenseinput = (EditText)view.findViewById(R.id.expenseinput);
        quickentry = (Button)view.findViewById(R.id.quickentrybutton);
        expensehistory = (Button)view.findViewById(R.id.expensehistorybutton);

        //This code grabs the default categories from strings.xml and any extra user-defined categories, combines them into a string array variable and populates the Spinner with them
        //Grabbing user-defined categories is currently commented out because the backend is not implemented yet.

        categoryselect = (Spinner)view.findViewById(R.id.categoryspinner);

        //create a string array with the default categories as defined in strings.xml, then turn it into a mutable list so we can add user-defined customs to it
        String[] defaultcategories = getResources().getStringArray(R.array.expensecategories);
        List<String> finalcategories = new ArrayList<String>(Arrays.asList(defaultcategories));

        //code to add the user defined categories should go here



        //create the spinner
        ArrayAdapter<String> categoryadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, finalcategories);
        categoryadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoryselect.setAdapter(categoryadapter);
        
        
        
        //Button logic
        quickentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expenseentry = expenseinput.getText().toString();
                
                if(TextUtils.isEmpty(expenseentry)){
                    expenseinput.setError("Input can't be empty");
                }
                else{
                    //Placeholder - actual implementation will be saving the expense entry
                    Toast.makeText(getActivity(), "Entry saved", Toast.LENGTH_LONG).show();
                }
            }
        });

        expensehistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ExpensesActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
