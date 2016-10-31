package karrel.com.launchmodetest;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int onNewIntentCount = 0;
    private int onCreateCount = 0;
    private int onResumeCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateCount++;

    }


    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        onNewIntentCount++;
    }

    protected void initButtons() {
        findViewById(R.id.singeTop).setOnClickListener(onSingleTopListener);
        findViewById(R.id.singleInstance).setOnClickListener(onSingleInstanceListener);
        findViewById(R.id.singleTask).setOnClickListener(onSingleTaskListener);
        findViewById(R.id.standard).setOnClickListener(onStandardListener);
    }

    private View.OnClickListener onSingleTopListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getBaseContext(), SingleTopActivity.class));
        }
    };

    private View.OnClickListener onSingleInstanceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getBaseContext(), SingleInstanceActivity.class));
        }
    };

    private View.OnClickListener onSingleTaskListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getBaseContext(), SingleTaskActivity.class));
        }
    };

    private View.OnClickListener onStandardListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getBaseContext(), StandardActivity.class));
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        onResumeCount ++;
        showTask();

        TextView lifeCycle = (TextView) findViewById(R.id.tv_lifecycle);
        lifeCycle.setText(String.format("onCreate(%s)\nonNewIntent(%s)\nonResume(%s)\n", onCreateCount, onNewIntentCount, onResumeCount));
    }

    protected final void showTask() {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        TextView tv = (TextView) findViewById(R.id.tv);
        String text = "";
        for (ActivityManager.RunningTaskInfo info : am.getRunningTasks(100)) {
            text += String.format("top : %s \nbase : %s\ncount %s\n\n"
                    , info.topActivity.getShortClassName()
                    , info.baseActivity.getShortClassName()
                    , info.numActivities);
        }

        tv.setText(text);
    }
}
