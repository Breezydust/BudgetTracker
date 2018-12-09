//This activity will show a breakdown of the users expenses per day and per category as well as a history
package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        table = (TableLayout)findViewById(R.id.expense_table);

        mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("expenses");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    int i = 1;
                    String category = ds.child(Integer.toString(i)).child("category").getValue(String.class);
                    Double expense = ds.child(Integer.toString(i)).child("expense").getValue(Double.class);
                    String date = ds.child(Integer.toString(i)).child("date").getValue(String.class);

                    //Double expense = Double.parseDouble(expensestr);

                    Toast.makeText(ExpensesActivity.this, date, Toast.LENGTH_SHORT).show();

                    TableRow row = new TableRow(getBaseContext());
                    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                    row.setLayoutParams(lp);
                    TextView catTV = new TextView(getBaseContext());
                    TextView expTV = new TextView(getBaseContext());
                    TextView dateTV = new TextView(getBaseContext());

                    catTV.setText(category);
                    //expTV.setText(Double.toString(expense));
                    dateTV.setText(date);

                    row.addView(catTV);
                    row.addView(expTV);
                    row.addView(dateTV);
                    table.addView(row,i-1);

                    i++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}
