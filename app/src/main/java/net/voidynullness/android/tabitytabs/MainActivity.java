package net.voidynullness.android.tabitytabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity
        implements MainListFragment.OnOptionSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionSelected(int id) {
        if (id == MainListFragment.IDX_LIST_PAGERTABSTRIP) {
            Intent intent = new Intent(this, PagerTabStripActivity.class);
            startActivity(intent);
        }
        else if (id == MainListFragment.IDX_LIST_TABLAYOUT) {
            Intent intent = new Intent(this, TabLayoutActivity.class);
            startActivity(intent);
        }
    }
}
