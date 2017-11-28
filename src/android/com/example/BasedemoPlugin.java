/**
 */
package com.example;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

//import android.util.Log;

import java.util.Date;

public class BasedemoPlugin extends CordovaPlugin {
	private static final String TAG = "BasedemoPlugin";

	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);

//		 Log.d(TAG, "Initializing BasedemoPlugin");
	}

	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("echo")) {
			String phrase = args.getString(0);
			// Echo back the first argument
			// Log.d(TAG, phrase);
			callbackContext.success("hello:" + phrase);
		} else if (action.equals("echoArray")) {
			JSONArray result = new JSONArray();
			for (int i = 0; i < args.length(); i++) {
				JSONObject object = new JSONObject();
				object.put("name", "hello:" + args.getString(i));
				result.put(object);
			}
			callbackContext.success(result);
		} else if (action.equals("getList")) {
			// An example of returning data back to the web layer
			// callbackContext.success(this.getList());
			callbackContext.sendPluginResult(this.getList());
		} else if (action.equals("getError")) {
			callbackContext.sendPluginResult(this.getError());
		} else if (action.equals("getDate")) {
			// An example of returning data back to the web layer
			PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
			callbackContext.sendPluginResult(result);
		}
		return true;
	}

	private PluginResult getList() throws JSONException {
		PluginResult pr = null;
		JSONArray result = new JSONArray();
		String file = "file";
		for (int i = 0; i < 8; i++) {
			JSONObject object = new JSONObject();
			object.put("name", file + i);
			object.put("path", file + i + "/Path/");
			object.put("size", file + i + "_size");
			result.put(object);
		}
		pr = new PluginResult(PluginResult.Status.OK, result);

		return pr;

	}

	private PluginResult getError() throws JSONException {
		PluginResult pr = null;
		try {
			String a = null;
			System.out.println(a.toString());
			pr = new PluginResult(PluginResult.Status.OK, a);
		} catch (Exception e) {
			JSONArray result = new JSONArray();
			JSONObject object = new JSONObject();
			object.put("error", e.getMessage());
			result.put(object);
			pr = new PluginResult(PluginResult.Status.ERROR, result);
		}
		return pr;

	}

}
