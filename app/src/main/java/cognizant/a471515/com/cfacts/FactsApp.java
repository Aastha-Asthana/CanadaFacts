package cognizant.a471515.com.cfacts;

import android.app.Application;
import android.content.Context;

public class FactsApp extends Application {

    public static Context context;

    @Override public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
