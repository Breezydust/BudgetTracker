package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Home");

        textView = (TextView)findViewById(R.id.home_text_view);

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
                    textView.setText("");
                    fragment = new BudgetingActivityFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_budgetinput:
                    toolbar.setTitle("Budget Input");
                    textView.setText("");
                    fragment = new BudgetInputActivityFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_expenseinput:
                    toolbar.setTitle("Expenses Input");
                    textView.setText("");
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
