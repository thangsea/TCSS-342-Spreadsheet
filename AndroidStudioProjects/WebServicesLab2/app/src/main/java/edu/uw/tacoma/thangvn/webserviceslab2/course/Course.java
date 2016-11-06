package edu.uw.tacoma.thangvn.webserviceslab2.course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thangnguyen on 11/5/16.
 */

public class Course implements Serializable {
    private String mCourseId;
    private String mShortDescription;
    private String mLongDescription;
    private String mPrereqs;

    public static final String ID = "id", SHORT_DESC = "shortDesc"
            , LONG_DESC = "longDesc", PRE_REQS = "prereqs";

    public Course(String mCourseId, String mShortDescription, String mLongDescription, String mPrereqs) {
        this.mCourseId = mCourseId;
        this.mShortDescription = mShortDescription;
        this.mLongDescription = mLongDescription;
        this.mPrereqs = mPrereqs;
    }

    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }


    public String getmCourseId() {
        return mCourseId;
    }

    public String getmShortDescription() {
        return mShortDescription;
    }

    public String getmLongDescription() {
        return mLongDescription;
    }

    public String getmPrereqs() {
        return mPrereqs;
    }

    public void setmCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public void setmShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public void setmLongDescription(String mLongDescription) {
        this.mLongDescription = mLongDescription;
    }

    public void setmPrereqs(String mPrereqs) {
        this.mPrereqs = mPrereqs;
    }
}
