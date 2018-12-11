//This activity will show a breakdown of the users expenses per day and per category as well as a history
//Team name: Starving Students

package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ExpensesActivity extends AppCompatActivity {

    public TableLayout table;
    FirebaseDatabase mDatabase;
    //public int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);



        table = (TableLayout)findViewById(R.id.expense_table);

        //connect to firebase for reading
        mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference();
        myRef.child("expenses").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                        //Get the values stored in each JSON object and assign them to variables
                        String category = ds.child("category").getValue(String.class);
                        Double expense = ds.child("expense").getValue(Double.class);
                        String date = ds.child("date").getValue(String.class);


                        //code to add table rows - not currently working
                        TableRow row = new TableRow(getApplicationContext());
                        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                        row.setLayoutParams(lp);
                        TextView catTV = new TextView(getBaseContext());
                        TextView expTV = new TextView(getBaseContext());
                        TextView dateTV = new TextView(getBaseContext());

                        catTV.setText(category);
                        row.addView(catTV);
                        expTV.setText(Double.toString(expense));
                        row.addView(expTV);
                        dateTV.setText(date);
                        row.addView(dateTV);


                        table.addView(row,new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,TableLayout.LayoutParams.WRAP_CONTENT));

                        //i++;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}
