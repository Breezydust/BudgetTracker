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
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class ExpensesActivityFragment extends Fragment {


        private EditText travelentry;
        private EditText entertainmententry;
        private EditText groceryentry;
        private EditText miscellaneousentry;
        private Button launchbudgetbutton;





    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expenses, container, false);

        travelentry = (EditText)view.findViewById(R.id.travel_input_textbox);
        entertainmententry = (EditText)view.findViewById(R.id.entertainment_input_textbox);
        groceryentry = (EditText)view.findViewById(R.id.grocery_input_textbox);
        miscellaneousentry = (EditText)view.findViewById(R.id.miscellaneous_purchases_textbox);

        launchbudgetbutton = (Button)view.findViewById(R.id.budget_button);
        launchbudgetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String travelval = travelentry.getText().toString();
                String entertainmentval = entertainmententry.getText().toString();
                String groceryval = groceryentry.getText().toString();
                String miscellaneousval = miscellaneousentry.getText().toString();

                if(TextUtils.isEmpty(travelval)){
                    travelentry.setError("Income cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(entertainmentval)){
                    entertainmententry.setError("Percent cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(groceryval)){
                    groceryentry.setError("Goal cannot be empty");
                    return;
                }
                else if(TextUtils.isEmpty(miscellaneousval)){
                    miscellaneousentry.setError("Timeline cannot be empty");
                    return;
                }
                else{
                    Intent intent = new Intent(getActivity(), BudgetInputActivity.class);
                    intent.putExtra("travelval",travelval);
                    intent.putExtra("entertainmentval",entertainmentval);
                    intent.putExtra("groceryval",groceryval);
                    intent.putExtra("miscellaneousval",miscellaneousval);
                    startActivity(intent);
                }

            }
        });

        return view;
    }
}
