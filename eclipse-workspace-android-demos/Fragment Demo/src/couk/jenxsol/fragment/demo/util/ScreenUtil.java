package couk.jenxsol.fragment.demo.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;

public class ScreenUtil
{

    private ScreenUtil()
    {
        // Static class
    }

    /**
     * Will print out screen details to your log
     * 
     * @param ctx
     */
    public static void logScreenDetails(Activity ctx)
    {
        // Figure out what kind of display we have
        int screenLayout = ctx.getResources().getConfiguration().screenLayout;

        if ((screenLayout & Configuration.SCREENLAYOUT_SIZE_SMALL) == Configuration.SCREENLAYOUT_SIZE_SMALL)
            Log.i("Info", "Screen size is Small");
        else if ((screenLayout & Configuration.SCREENLAYOUT_SIZE_NORMAL) == Configuration.SCREENLAYOUT_SIZE_NORMAL)
            Log.i("Info", "Screen size is Normal");
        else if ((screenLayout & Configuration.SCREENLAYOUT_SIZE_LARGE) == Configuration.SCREENLAYOUT_SIZE_LARGE)
            Log.i("Info", "Screen size is Large");

        if ((screenLayout & Configuration.SCREENLAYOUT_LONG_YES) == Configuration.SCREENLAYOUT_LONG_YES)
            Log.i("Info", "Screen size is Long");

        // Get the metrics
        DisplayMetrics metrics = new DisplayMetrics();
        ctx.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int heightPixels = metrics.heightPixels;
        int widthPixels = metrics.widthPixels;
        int densityDpi = metrics.densityDpi;
        float density = metrics.density;
        float scaledDensity = metrics.scaledDensity;
        float xdpi = metrics.xdpi;
        float ydpi = metrics.ydpi;

        Log.i("Info", "Screen W x H pixels: " + widthPixels + " x " + heightPixels);
        Log.i("Info", "Screen W x H dips: " + widthPixels / scaledDensity + " x " + heightPixels
                / scaledDensity);
        Log.i("Info", "Screen X x Y dpi: " + xdpi + " x " + ydpi);
        Log.i("Info", "density = " + density + "  scaledDensity = " + scaledDensity
                + "  densityDpi = " + densityDpi);
    }

}
