package com.example.savingscalculator;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mainActivity = null;
    private double goal, income, expenditure, rateOfSaving;

    Instrumentation.ActivityMonitor monitor_help = getInstrumentation().addMonitor(HelpActivity.class.getName(), null, false);
    Instrumentation.ActivityMonitor monitor_set_date = getInstrumentation().addMonitor(SetDateActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        goal = 2000;
        income = 700;
        expenditure = 150;
        rateOfSaving = 50;
        mainActivity = activityTestRule.getActivity();
    }

    //test one -- to test the app launching (opens then closes after launching app)
    @Test
    public void testLaunch() {
        View view = mainActivity.findViewById(R.id.editTextGoal);
        assertNotNull(view);
    }

    //test two -- to test if user input is correct or not
    @Test
    public void testUserInputScenario() {
        // placing values into input widgets of app
        onView(withId(R.id.editTextGoal)).perform(typeText(Double.toString(goal)));
        onView(withId(R.id.editTextWeeklyIncome)).perform(typeText(Double.toString(income)));
        onView(withId(R.id.editTextExpenditure)).perform(typeText(Double.toString(expenditure)));
        onView(withId(R.id.editTextPercentage)).perform(typeText(Double.toString(rateOfSaving)));

        //close soft keyboard
        closeSoftKeyboard();

        //click button
        onView(withId(R.id.btnCalculate)).perform(click());
    }

    //test three -- to test if user can click help button
    @Test
    public void testUserClickHelpButton() {
        onView(withId(R.id.btnHelp)).perform(click());
    }

    //test four -- to test if user can click set date button
    @Test
    public void testUserClickSetDateButton() {
        onView(withId(R.id.btnGoCalendar)).perform(click());
    }

    //test five -- to test if user can shift to help activity
    @Test
    public void testShiftToHelpActivity() {
        //to shift from one activity to another
        assertNotNull(mainActivity.findViewById(R.id.btnHelp));
        onView(withId(R.id.btnHelp)).perform(click());

        Activity helpActivity = getInstrumentation().waitForMonitorWithTimeout(monitor_help, 50000);

        assertNotNull(helpActivity);
        helpActivity.finish();
    }

    //test six -- to test if user can shift to set date activity
    @Test
    public void testShiftToSetDateActivity() {
        //to shift from one activity to another
        assertNotNull(mainActivity.findViewById(R.id.btnGoCalendar));
        onView(withId(R.id.btnGoCalendar)).perform(click());

        Activity setDateActivity = getInstrumentation().waitForMonitorWithTimeout(monitor_set_date, 50000);

        assertNotNull(setDateActivity);
        setDateActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}