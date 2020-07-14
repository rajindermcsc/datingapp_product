package com.datingapp.configs;
/**
 * @package com.datingapp
 * @subpackage configs
 * @category AppController
 * @author Trioangle Product Team
 * @version 1.0
 **/

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.datingapp.R;
import com.datingapp.dependencies.component.AppComponent;
import com.datingapp.dependencies.component.DaggerAppComponent;
import com.datingapp.dependencies.module.ApplicationModule;
import com.datingapp.dependencies.module.NetworkModule;
//import instagram.InstagramHelper;

/*****************************************************************
 AppController
 ****************************************************************/
public class AppController extends Application {

    private static AppComponent appComponent;
    // private static InstagramHelper instagramHelper;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);    // Multiple dex initialize

        // Dagger%COMPONENT_NAME%
        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .networkModule(new NetworkModule(getResources().getString(R.string.base_url)))
                .build();

        // MultiDex.install(this);
        /*instagramHelper = new InstagramHelper.Builder()
                .withClientId(getResources().getString(R.string.instagram_client_id))
                .withRedirectUrl(getResources().getString(R.string.redirect_url))
                .withScope("basic+public_content+relationships")
                .build();*/
    }

    /* public static InstagramHelper getInstagramHelper() {
         return instagramHelper;
     }*/
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
