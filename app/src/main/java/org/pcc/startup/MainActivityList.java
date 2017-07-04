package org.pcc.startup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.pcc.kotlinandroid.R;
import org.pcc.startup.model.CardViewModel;

import java.util.ArrayList;

import static org.pcc.kotlin.DefiningFunctionsKt.executeDefiningFunctions1;
import static org.pcc.kotlin.DefiningFunctionsKt.sum;

public class MainActivityList extends AppCompatActivity implements ListFragment.OnListFragmentInteractionListener {
    // Remove the below line after defining your own ad unit ID.
    private static final String TOAST_TEXT = "Test ads are being shown. "
            + "To show live ads, replace the ad unit ID in res/values/strings.xml with your own ad unit ID.";

    private ArrayList<CardViewModel> myDatasetLevel1 = new ArrayList<CardViewModel>();
    private ArrayList<CardViewModel> mDatasetForBasicSyntax = new ArrayList<CardViewModel>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    android.support.v4.app.FragmentManager mFragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
//        mRecyclerView = (RecyclerView) findViewById(R.id.kotProRecyclerView);
//
//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);

        mDatasetForBasicSyntax.add(new CardViewModel(1, "Defining packages", "Importing Packages in Kotlin"));;
        mDatasetForBasicSyntax.add(new CardViewModel(2, "Defining Functions", "Functions in Kotlin"));

        myDatasetLevel1 = new ArrayList<CardViewModel>();
        myDatasetLevel1.add(new CardViewModel(1, "Basic Syntax", "Basic Syntax for Kotlin", mDatasetForBasicSyntax));
        //myDatasetLevel1.add(new CardViewModel(2, "Basic Types", ""));

        // specify an adapter (see also next example)
//        mAdapter = new MyAdapter(myDatasetLevel1);
//        mRecyclerView.setAdapter(mAdapter);

        if (null == savedInstanceState) {
            mFragmentManager = getSupportFragmentManager();
            mFragmentManager.beginTransaction().replace(R.id.replaceme, new ListFragment(myDatasetLevel1)).commitAllowingStateLoss();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(CardViewModel item) {
        Log.d("Test", "Selected item: " + item.getTitle());

        if (item.getChildren().size() < 1) {
            //TODO: Check if href is available.
            if (item.getCodeTag().equals("executeDefiningFunctions1")) {
                executeDefiningFunctions1();
            }

            return;
        }

        mFragmentManager.beginTransaction().replace(R.id.replaceme, new ListFragment(item.getChildren())).commitAllowingStateLoss();
    }

    public void executeDefiningFunctions() {
        int result = sum(3, 5);
        Log.d("Test", String.valueOf(result));
    }
}
