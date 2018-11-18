//Main activity is the home page. This will feature the amount of money left in teh day for 3 of the user's favorite categories, as well as a countdown to next payday (in days)
//as well as an info button showing off the features of the app

package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.support.design.widget.BottomNavigationView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    private TextView textView;
    private int income;
    private int budgetpercent;
    private float totalbudget;
    private TextView totalbudgetremaning;
    private TextView nextpaydaycount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Home");

        final SharedPreferences budgetvaluespref = this.getSharedPreferences("budgetvalues",MODE_PRIVATE);
        income = budgetvaluespref.getInt("monthlyincome",1);
        budgetpercent = budgetvaluespref.getInt("budgetpercentage",1);
        totalbudget = (income * budgetpercent) / 100;

        totalbudgetremaning = (TextView)findViewById(R.id.budget_remaining);
        totalbudgetremaning.append(Float.toString(totalbudget));

        nextpaydaycount = (TextView)findViewById(R.id.next_payday);
        nextpaydaycount.append("14");


        BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()){
                case R.id.navigation_budgeting:
                    toolbar.setTitle("Budgeting");
                    totalbudgetremaning.setText("");
                    nextpaydaycount.setText("");
                    fragment = new BudgetingActivityFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_budgetinput:
                    toolbar.setTitle("Budget Input");
                    totalbudgetremaning.setText("");
                    nextpaydaycount.setText("");
                    fragment = new BudgetInputActivityFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_expenseinput:
                    toolbar.setTitle("Expenses Input");
                    totalbudgetremaning.setText("");
                    nextpaydaycount.setText("");
                    fragment = new ExpensesActivityFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_home:
                    finish();
                    startActivity(getIntent());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
