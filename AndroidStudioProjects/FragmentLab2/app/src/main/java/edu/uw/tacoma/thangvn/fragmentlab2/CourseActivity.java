package edu.uw.tacoma.thangvn.fragmentlab2;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.uw.tacoma.thangvn.fragmentlab2.course.CourseContent;

public class CourseActivity extends AppCompatActivity implements CourseListFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        if (findViewById(R.id.fragment_container)!= null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new CourseListFragment())
                    .commit();
        }
    }


    @Override
    public void onListFragmentInteraction(CourseContent.CourseItem item) {
        // Capture the course fragment from the activity layout
        CourseDetailFragment courseDetailFragment = (CourseDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.course_item_frag);

        if (courseDetailFragment != null) {
            // If courseDetail frag is available, we're in two-pane layout...

            // Call a method in the course detail fragment to update its content
            courseDetailFragment.updateCourseItemView(item);

        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected student
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back

            courseDetailFragment = new CourseDetailFragment();
            Bundle args = new Bundle();
            args.putSerializable(CourseDetailFragment.DETAIL_ARG, item);
            courseDetailFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, courseDetailFragment)
                    .addToBackStack(null);

            // Commit the transaction
            transaction.commit();

        }

    }

}
