package net.voidynullness.android.tabitytabs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 *
 */
public class TabLayoutActivityFragment extends Fragment {

    private static final String ARG_PAGE_NUMBER = "page_number";

    public TabLayoutActivityFragment() {
    }

    public static TabLayoutActivityFragment newInstance(int sectionNumber) {
        TabLayoutActivityFragment fragment = new TabLayoutActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_layout, container, false);

        TextView txt = (TextView) rootView.findViewById(R.id.page_number_label);
        int position = getArguments().getInt(ARG_PAGE_NUMBER, -1);
        txt.setText(String.format("Page %d", position));

        return rootView;
    }
}
