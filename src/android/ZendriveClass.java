package com.dryver.zendrive;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import android.util.Log;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.PluginResult;
import android.content.Context;

import com.zendrive.sdk.*;

public class ZendriveClass extends CordovaPlugin {
    String TAG = "ZendrivePlugin";
    CallbackContext _callbackContext;

    public void login(String driverId, String zendriveApplicationKey, CallbackContext callbackContext) throws JSONException
    {
        _callbackContext = callbackContext;
        Log.d(TAG, "We are entering login");
        // ZendriveDriverAttributes driverAttributes = new ZendriveDriverAttributes();
        // driverAttributes.setFirstName("Homer");
        // driverAttributes.setLastName("Simpson");
        // driverAttributes.setEmail("homer@springfield.com");
        // driverAttributes.setPhoneNumber("14155557334");

        ZendriveConfiguration zendriveConfiguration = new ZendriveConfiguration(
            zendriveApplicationKey, driverId);   // an unique id of the driver specific to your application
        // zendriveConfiguration.setDriverAttributes(driverAttributes);

        Context context = cordova.getActivity();

        Zendrive.setup(
            context,
            zendriveConfiguration,
            ZendriveBroadcastReceiver.class,        // can be null.
            ZendriveNotificationProvider.class,     // must be non-null.
            new ZendriveOperationCallback() {
                @Override
                public void onCompletion(ZendriveOperationResult result) {
                    PluginResult r;

                    if (result.isSuccess()) {
                        Log.d(TAG, "login - Success!");
                        r = new PluginResult(PluginResult.Status.OK);
                        _callbackContext.sendPluginResult(r);
                    }
                    else {
                        Log.d(TAG, "login - Error!");
                        r = new PluginResult(PluginResult.Status.ERROR);
                        _callbackContext.sendPluginResult(r);
                    }
                }
            }
        );
    }

    public void setDriverDetectionOn() throws JSONException {
        Context context = cordova.getActivity();
        // Turn on automatic drive detection in the SDK.
        Zendrive.setZendriveDriveDetectionMode(context, ZendriveDriveDetectionMode.AUTO_ON,
            new ZendriveOperationCallback() {
                @Override
                public void onCompletion(ZendriveOperationResult result) {
                    // if (result.isSuccess()) {  ...  }
                    // else { ... }
                }
            }
        );
    }

    public void setDriverDetectionOff() throws JSONException {
        Context context = cordova.getActivity();
        // Turn off automatic drive detection in the SDK.
        Zendrive.setZendriveDriveDetectionMode(context, ZendriveDriveDetectionMode.AUTO_OFF,
            new ZendriveOperationCallback() {
                @Override
                public void onCompletion(ZendriveOperationResult result) {
                    // if (result.isSuccess()) {  ...  }
                    // else { ... }
                }
            }
        );
    }
}
