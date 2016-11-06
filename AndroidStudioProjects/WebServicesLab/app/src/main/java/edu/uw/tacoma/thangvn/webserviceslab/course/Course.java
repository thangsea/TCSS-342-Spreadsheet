package edu.uw.tacoma.thangvn.webserviceslab.course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Course implements Serializable{

    public String m_courseId;
    public String m_shortDescription;
    public String m_longDescription;
    public String m_prereqs;

    public static final String ID = "id", SHORT_DESC = "shortDesc"
            , LONG_DESC = "longDesc", PRE_REQS = "prereqs";

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Course> ITEMS = new ArrayList<Course>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Course> ITEM_MAP = new HashMap<String, Course>();

    private static final int COUNT = 25;

    public Course(final String theCourseId, final String theShoreDescription,
                  final String theLongDescription, final String thePrereqs) {

    }

    public String getCourseId() {
        return m_courseId;
    }

    public String getShortDescription() {
        return m_shortDescription;
    }

    public String getLongDescription() {
        return m_longDescription;
    }

    public String getPrereqs() {
        return m_prereqs;
    }

    public void setCourseId(String m_courseId) {
        this.m_courseId = m_courseId;
    }

    public void setShortDescription(String m_shortDescription) {
        this.m_shortDescription = m_shortDescription;
    }

    public void setLongDescription(String m_longDescription) {
        this.m_longDescription = m_longDescription;
    }

    public void setPrereqs(String m_prereqs) {
        this.m_prereqs = m_prereqs;
    }

//    static {
//        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
//    }

    private static void addItem(Course item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.m_courseId, item);
    }

//    private static Course createDummyItem(int position) {
//        return new Course(String.valueOf(position), "Item " + position, makeDetails(position));
//    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
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




//    /**
//     * A dummy item representing a piece of content.
//     */
//    public static class Course {
//        public final String id;
//        public final String content;
//        public final String details;
//
//        public Course(String id, String content, String details) {
//            this.id = id;
//            this.content = content;
//            this.details = details;
//        }
//
//        @Override
//        public String toString() {
//            return content;
//        }
//    }



}
