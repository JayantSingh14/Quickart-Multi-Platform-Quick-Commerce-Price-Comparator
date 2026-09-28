package com.kevinresol.react_native_default_preference;

import android.content.SharedPreferences;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class RNDefaultPreferenceModule extends ReactContextBaseJavaModule {
    private String preferencesName;
    private final ReactApplicationContext reactContext;

    public RNDefaultPreferenceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        this.preferencesName = reactApplicationContext.getPackageName() + "_preferences";
    }

    private SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }

    private SharedPreferences getPreferences() {
        return getReactApplicationContext().getSharedPreferences(this.preferencesName, 0);
    }

    @ReactMethod
    public void clear(String str, Promise promise) {
        getEditor().remove(str).commit();
        promise.resolve(null);
    }

    @ReactMethod
    public void clearAll(Promise promise) {
        SharedPreferences.Editor editor = getEditor();
        Iterator<Map.Entry<String, ?>> it = getPreferences().getAll().entrySet().iterator();
        while (it.hasNext()) {
            editor.remove(it.next().getKey());
        }
        editor.commit();
        promise.resolve(null);
    }

    @ReactMethod
    public void clearMultiple(ReadableArray readableArray, Promise promise) {
        SharedPreferences.Editor editor = getEditor();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            editor.remove(readableArray.getString(i2));
        }
        editor.commit();
        promise.resolve(null);
    }

    @ReactMethod
    public void get(String str, Promise promise) {
        promise.resolve(getPreferences().getString(str, null));
    }

    @ReactMethod
    public void getAll(Promise promise) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        for (Map.Entry<String, ?> entry : getPreferences().getAll().entrySet()) {
            writableMapCreateMap.putString(entry.getKey(), entry.getValue().toString());
        }
        promise.resolve(writableMapCreateMap);
    }

    @ReactMethod
    public void getMultiple(ReadableArray readableArray, Promise promise) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            writableArrayCreateArray.pushString(getPreferences().getString(readableArray.getString(i2), null));
        }
        promise.resolve(writableArrayCreateArray);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNDefaultPreference";
    }

    @ReactMethod
    public void set(String str, String str2, Promise promise) {
        getEditor().putString(str, str2).commit();
        promise.resolve(null);
    }

    @ReactMethod
    public void setMultiple(ReadableMap readableMap, Promise promise) {
        SharedPreferences.Editor editor = getEditor();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            editor.putString(strNextKey, readableMap.getString(strNextKey)).commit();
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void setName(String str, Promise promise) {
        this.preferencesName = str;
        promise.resolve(null);
    }

    @ReactMethod
    public void getName(Promise promise) {
        promise.resolve(this.preferencesName);
    }
}
