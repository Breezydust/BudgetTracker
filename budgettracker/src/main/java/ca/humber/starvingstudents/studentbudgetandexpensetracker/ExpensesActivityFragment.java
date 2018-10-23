//This fragment allows the user to quickly enter an expense; will pull possible categories from a predetermined list + any user defined categories within budgetinputactivity, and default
//today's date for time logging
package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class ExpensesActivityFragment extends Fragment {

    public ExpensesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expenses, container, false);
    }
}
