//this fragment will show a small graph of 1-week spending trends
//Team name: Starving Students
package ca.humber.starvingstudents.studentbudgetandexpensetracker;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;


public class BudgetingActivityFragment extends Fragment {

    public BudgetingActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_budgeting, container, false);

        GraphView bargraph = (GraphView)view.findViewById(R.id.budgetingfragmentbarchart);
        BarGraphSeries<DataPoint> goalseries = new BarGraphSeries<>(new DataPoint[]{
           new DataPoint(0,4),
           new DataPoint(5,5),
        });
        goalseries.setSpacing(50);
        bargraph.addSeries(goalseries);

        BarGraphSeries<DataPoint> spentseries = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(2,3),
                new DataPoint(4,4),
        });
        spentseries.setSpacing(50);
        bargraph.addSeries(spentseries);

    return view;
    }
}
