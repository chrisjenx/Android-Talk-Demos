package couk.jenxsol.fragment.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import couk.jenxsol.fragment.demo.util.ScreenUtil;

public class MainActivity extends FragmentActivity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ScreenUtil.logScreenDetails(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public static class MyTimers extends Handler
    {

        public static final int TIMER_1 = 0;
        public static final int TIMER_2 = 1;

        @Override
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case TIMER_1:
                    // Do something etc.
                    Log.d("TimerExample", "Timer 1");
                    sendEmptyMessageDelayed(TIMER_1, 1000);
                    break;
                case TIMER_2:
                    // Do another time update etc..
                    Log.d("TimerExample", "Timer 2");
                    sendEmptyMessageDelayed(TIMER_2, 1000);
                    break;
                default:
                    removeMessages(TIMER_1);
                    removeMessages(TIMER_2);
                    break;
            }
        }
    }

}
