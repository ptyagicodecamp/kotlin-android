package org.pcc.startup;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.pcc.Utils;
import org.pcc.kotlinandroid.FullDetailsFragment;
import org.pcc.kotlinandroid.R;
import org.pcc.startup.model.CardViewModel;

import java.util.ArrayList;

import static org.pcc.kotlin.DefiningFunctionsKt.sum;

public class MainActivityList extends AppCompatActivity implements
        ListFragment.OnListFragmentInteractionListener,
FullDetailsFragment.OnFragmentInteractionListener {
    // Remove the below line after defining your own ad unit ID.
    private static final String TOAST_TEXT = "Test ads are being shown. "
            + "To show live ads, replace the ad unit ID in res/values/strings.xml with your own ad unit ID.";

    private ArrayList<CardViewModel> myDatasetLevel1 = new ArrayList<CardViewModel>();
    private ArrayList<CardViewModel> mDatasetForBasicSyntax = new ArrayList<CardViewModel>();

    android.support.v4.app.FragmentManager mFragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        myDatasetLevel1 = Utils.getData(this).getData();

//        mDatasetForBasicSyntax.add(new CardViewModel(1, "Defining packages", "Importing Packages in Kotlin"));;
//        mDatasetForBasicSyntax.add(new CardViewModel(2, "Defining Functions", "Functions in Kotlin"));
//
//        myDatasetLevel1 = new ArrayList<CardViewModel>();
//        myDatasetLevel1.add(new CardViewModel(1, "Basic Syntax", "Basic Syntax for Kotlin", mDatasetForBasicSyntax));

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
    public void onListFragmentInteraction(CardViewModel cardItem) {
        Log.d("Test", "Selected item: " + cardItem.getTitle());

        if (cardItem.getChildren().size() < 1) {
            //TODO: Check if href is available.
//            if (cardItem.getCodeTag().equals("executeDefiningFunctions1")) {
//                executeDefiningFunctions1();
//            }

            mFragmentManager.beginTransaction().replace(R.id.replaceme, FullDetailsFragment.newInstance(cardItem)).commitAllowingStateLoss();
        } else {
            mFragmentManager.beginTransaction().replace(R.id.replaceme, new ListFragment(cardItem.getChildren())).commitAllowingStateLoss();
        }
    }

    public void executeDefiningFunctions() {
        int result = sum(3, 5);
        Log.d("Test", String.valueOf(result));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
