package net.voidynullness.android.tabitytabs;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainListFragment extends ListFragment {
    private OnOptionSelectedListener mListener;

    public static final String[] LIST_OPTIONS = { "PagerTabStrip", "TabLayout" };
    public static final int IDX_LIST_PAGERTABSTRIP = 0;
    public static final int IDX_LIST_TABLAYOUT = 1;

    public MainListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                LIST_OPTIONS));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnOptionSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnMainListOptionSelectListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (null != mListener) {
            mListener.onOptionSelected(position);
        }
    }

    public interface OnOptionSelectedListener {
        void onOptionSelected(int id);
    }
}
