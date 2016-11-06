package edu.uw.tacoma.thangvn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.uw.tacoma.thangvn.R;
import edu.uw.tacoma.thangvn.course.CourseContent;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseDetailFragment extends Fragment {

    public static String DETAIL_ARG = "detail_arg";


    public CourseDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_course_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the course text.
        Bundle args = getArguments();
        if (args != null) {
            // Set course based on argument passed in
            updateCourseItemView((CourseContent.CourseItem) args.getSerializable(DETAIL_ARG));
        } else {
            // Set article based on saved instance state defined during onCreateView
            updateCourseItemView(CourseContent.ITEMS.get(0));
        }
    }

    public void updateCourseItemView(CourseContent.CourseItem item) {
        TextView courseIdTextView = (TextView) getActivity().findViewById(R.id.course_item_id);
        courseIdTextView.setText(item.id);
        TextView courseTitleTextView = (TextView) getActivity().findViewById(R.id.course_item_title);
        courseTitleTextView.setText(item.title);
        TextView courseShortDescTextView = (TextView) getActivity().findViewById(R.id.course_item_desc);
        courseShortDescTextView.setText(item.shortDescription);
    }


}
