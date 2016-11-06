package edu.uw.tacoma.thangvn.fragmentlab2;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.uw.tacoma.thangvn.fragmentlab2.course.CourseContent;

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
//        TextView textView = new TextView(getActivity());
//        textView.setText(R.string.hello_blank_fragment);
//        return textView;
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


//package edu.uw.tacoma.thangvn.fragmentlab2;
//
//        import android.content.Context;
//        import android.net.Uri;
//        import android.os.Bundle;
//        import android.support.v4.app.Fragment;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.TextView;
//
//        import edu.uw.tacoma.thangvn.fragmentlab2.course.CourseContent;
//
//
///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link OnListFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link CourseDetailFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class CourseDetailFragment extends Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnListFragmentInteractionListener mListener;
//
//    public static String DETAIL_ARG = "detail_arg";
//
//
//    public CourseDetailFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment CourseDetailFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static CourseDetailFragment newInstance(String param1, String param2) {
//        CourseDetailFragment fragment = new CourseDetailFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_course_detail, container, false);
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // During startup, check if there are arguments passed to the fragment.
//        // onStart is a good place to do this because the layout has already been
//        // applied to the fragment at this point so we can safely call the method
//        // below that sets the course text.
//        Bundle args = getArguments();
//        if (args != null) {
//            // Set course based on argument passed in
//            updateCourseItemView((CourseContent.CourseItem) args.getSerializable(DETAIL_ARG));
//        } else {
//            // Set article based on saved instance state defined during onCreateView
//            updateCourseItemView(CourseContent.ITEMS.get(0));
//        }
//    }
//
//    public void updateCourseItemView(CourseContent.CourseItem item) {
//        TextView courseIdTextView = (TextView) getActivity().findViewById(R.id.course_item_id);
//        courseIdTextView.setText(item.id);
//        TextView courseTitleTextView = (TextView) getActivity().findViewById(R.id.course_item_title);
//        courseTitleTextView.setText(item.title);
//        TextView courseShortDescTextView = (TextView) getActivity().findViewById(R.id.course_item_desc);
//        courseShortDescTextView.setText(item.shortDescription);
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
//}
