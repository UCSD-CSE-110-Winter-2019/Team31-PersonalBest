package com.example.team31_personalbest;

import android.os.Handler;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;



import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class TimerTest {

    private Timer timer;
    private TextView text;
    private WalkRunActivity walkRunActivity;

    @Before
    public void setup() {
        walkRunActivity = Robolectric.setupActivity(WalkRunActivity.class);
        text = walkRunActivity.findViewById(R.id.textViewTimer);
        timer = new Timer(text);

    }

    // Tests if the timer accurately displays the initial time of 0
    @Test
    public void testInitial() {
        assertEquals("00:00:00", text.getText());
    }

    // Tests if the timer accurately displays the time after one hour
    @Test
    public void testOneHour() {
        long millisecondsPerHour = 3600 * 1000;
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                assertEquals("01:00:00", text.getText());
            }
        }, millisecondsPerHour);
    }
}