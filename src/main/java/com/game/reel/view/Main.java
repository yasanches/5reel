package com.game.reel.view;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import com.game.reel.R;

public class Main extends Activity {

    private static String TAG = "5reel";

    private PowerManager.WakeLock wakeLock;

    /** A handle to the thread that's actually running the animation. */
    private RenderSurface.RSThread mRSThread;
    /** A handle to the View in which the game is running. */
    private RenderSurface mRenderSurface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");

        //setRequestedOrientation(ActivityInfo.LAUNCH_SINGLE_TOP);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        /*PowerManager powerManager =
                (PowerManager)this.getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Lock");*/

        setContentView(R.layout.main);

        // get handles to the RenderSurface from XML, and its RenderSurface.RSThread
        mRenderSurface = (RenderSurface) findViewById(R.id.renderSurface);
        mRSThread = mRenderSurface.getThread();

        if (savedInstanceState == null) {
            // we were just launched: set up a new game
            mRSThread.setState(RenderSurface.RSThread.STATE_READY);
            Log.w(this.getClass().getName(), "SIS is null");
        } else {
            // we are being restored: resume a previous game
            mRSThread.restoreState(savedInstanceState);
            Log.w(this.getClass().getName(), "SIS is nonnull");
        }
    }

    /**
     * Invoked when the Activity loses user focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mRenderSurface.getThread().pause(); // pause game when Activity pauses
    }

    /**
     * Notification that something is about to happen, to give the Activity a
     * chance to save state.
     *
     * @param outState a Bundle into which this Activity should save its state
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // just have the View's thread save its state into our Bundle
        super.onSaveInstanceState(outState);
        mRSThread.saveState(outState);
        Log.w(this.getClass().getName(), "SIS called");
    }


}

