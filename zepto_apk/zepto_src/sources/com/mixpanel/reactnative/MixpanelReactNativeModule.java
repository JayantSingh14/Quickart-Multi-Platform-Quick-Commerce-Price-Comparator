package com.mixpanel.reactnative;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.common.api.Api;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.util.MPLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MixpanelReactNativeModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext mReactContext;

    public MixpanelReactNativeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    @ReactMethod
    public void addGroup(String str, String str2, Dynamic dynamic, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.c(ReactNativeHelper.c(dynamic), str2);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void alias(String str, String str2, String str3, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.d(str2, str3);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void append(String str, String str2, Dynamic dynamic, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.f46036e.j(ReactNativeHelper.c(dynamic), str2);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void clearCharges(String str, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.f46036e.h();
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void clearSuperProperties(String str, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.g();
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void deleteGroup(String str, String str2, Dynamic dynamic, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.k(ReactNativeHelper.c(dynamic), str2).f();
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void deleteUser(String str, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.f46036e.k();
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void eventElapsedTime(String str, String str2, Promise promise) {
        Long l2;
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            synchronized (mixpanelAPIL.f46041j) {
                l2 = (Long) mixpanelAPIL.f46041j.get(str2);
            }
            promise.resolve(Double.valueOf(l2 == null ? 0.0d : (jCurrentTimeMillis - l2.longValue()) / 1000));
        }
    }

    @ReactMethod
    public void flush(String str, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.h();
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void getDistinctId(String str, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            promise.resolve(mixpanelAPIL.j());
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "MixpanelReactNative";
    }

    @ReactMethod
    public void getSuperProperties(String str, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            promise.resolve(ReactNativeHelper.b(mixpanelAPIL.m()));
        }
    }

    @ReactMethod
    public void groupRemovePropertyValue(String str, String str2, Dynamic dynamic, String str3, Dynamic dynamic2, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.k(ReactNativeHelper.c(dynamic), str2).a(ReactNativeHelper.c(dynamic2), str3);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void groupSetProperties(String str, String str2, Dynamic dynamic, ReadableMap readableMap, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.k(ReactNativeHelper.c(dynamic), str2).e(ReactNativeHelper.e(readableMap));
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void groupSetPropertyOnce(String str, String str2, Dynamic dynamic, ReadableMap readableMap, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.k(ReactNativeHelper.c(dynamic), str2).b(ReactNativeHelper.e(readableMap));
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void groupUnionProperty(String str, String str2, Dynamic dynamic, String str3, ReadableArray readableArray, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.k(ReactNativeHelper.c(dynamic), str2).d(str3, ReactNativeHelper.d(readableArray));
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void groupUnsetProperty(String str, String str2, Dynamic dynamic, String str3, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.k(ReactNativeHelper.c(dynamic), str2).c(str3);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void hasOptedOutTracking(String str, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            promise.resolve(Boolean.valueOf(mixpanelAPIL.n()));
        }
    }

    @ReactMethod
    public void identify(String str, String str2, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.o(str2, true);
            mixpanelAPIL.f46036e.i(str2);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void increment(String str, ReadableMap readableMap, Promise promise) {
        HashMap mapG = ReactNativeHelper.g(readableMap);
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.f46036e.f(mapG);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void initialize(String str, boolean z, ReadableMap readableMap, Promise promise) throws JSONException {
        JSONObject jSONObjectE = ReactNativeHelper.e(readableMap);
        AutomaticProperties.f46098a = jSONObjectE;
        MixpanelAPI.l(this.mReactContext, str, jSONObjectE, z);
        promise.resolve(null);
    }

    @ReactMethod
    public void optInTracking(String str, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.p();
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void optOutTracking(String str, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.q();
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void registerSuperProperties(String str, ReadableMap readableMap, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.s(ReactNativeHelper.e(readableMap));
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void registerSuperPropertiesOnce(String str, ReadableMap readableMap, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.t(ReactNativeHelper.e(readableMap));
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void remove(String str, String str2, Dynamic dynamic, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.f46036e.a(ReactNativeHelper.c(dynamic), str2);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void removeGroup(String str, String str2, Dynamic dynamic, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.u(ReactNativeHelper.c(dynamic), str2);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void reset(String str, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.v();
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void set(String str, ReadableMap readableMap, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            JSONObject jSONObjectE = ReactNativeHelper.e(readableMap);
            AutomaticProperties.a(jSONObjectE);
            mixpanelAPIL.f46036e.e(jSONObjectE);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void setGroup(String str, String str2, Dynamic dynamic, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            Object objC = ReactNativeHelper.c(dynamic);
            if (!mixpanelAPIL.n()) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(objC);
                mixpanelAPIL.w(str2, arrayList);
            }
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void setGroups(String str, String str2, ReadableArray readableArray, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.w(str2, Arrays.asList(ReactNativeHelper.f(readableArray)));
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void setLoggingEnabled(String str, boolean z, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.f46034c.getClass();
            MPConfig.q = z;
            MPLog.f46096a = z ? 2 : Api.BaseClientBuilder.API_PRIORITY_OTHER;
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void setOnce(String str, ReadableMap readableMap, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            JSONObject jSONObjectE = ReactNativeHelper.e(readableMap);
            AutomaticProperties.a(jSONObjectE);
            mixpanelAPIL.f46036e.b(jSONObjectE);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void setServerURL(String str, String str2, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            MPConfig mPConfig = mixpanelAPIL.f46034c;
            mPConfig.getClass();
            mPConfig.f46006i = MPConfig.a(str2 + "/track/", mPConfig.o);
            mPConfig.f46007j = MPConfig.a(str2 + "/engage/", mPConfig.o);
            mPConfig.f46008k = str2 + "/groups/";
            mPConfig.f46009l = str2 + "/decide";
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void setUseIpAddressForGeolocation(String str, boolean z, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            MPConfig mPConfig = mixpanelAPIL.f46034c;
            mPConfig.o = z;
            mPConfig.f46006i = MPConfig.a(mPConfig.f46006i, z);
            mPConfig.f46007j = MPConfig.a(mPConfig.f46007j, z);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void timeEvent(String str, String str2, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.x(str2);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void track(String str, String str2, ReadableMap readableMap, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            JSONObject jSONObjectE = ReactNativeHelper.e(readableMap);
            AutomaticProperties.a(jSONObjectE);
            mixpanelAPIL.y(str2, jSONObjectE);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void trackCharge(String str, double d2, ReadableMap readableMap, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.f46036e.g(d2, ReactNativeHelper.e(readableMap));
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void trackWithGroups(String str, String str2, ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            HashMap mapG = ReactNativeHelper.g(readableMap);
            HashMap mapG2 = ReactNativeHelper.g(readableMap2);
            if (!mixpanelAPIL.n()) {
                for (Map.Entry entry : mapG2.entrySet()) {
                    if (entry.getValue() != null) {
                        mapG.put(entry.getKey(), entry.getValue());
                    }
                }
                if (!mixpanelAPIL.n()) {
                    try {
                        mixpanelAPIL.y(str2, new JSONObject(mapG));
                    } catch (NullPointerException unused) {
                        MPLog.f("MixpanelAPI.API", "Can't have null keys in the properties of trackMap!");
                    }
                }
            }
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void union(String str, String str2, ReadableArray readableArray, Promise promise) throws JSONException {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.f46036e.d(str2, ReactNativeHelper.d(readableArray));
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void unregisterSuperProperty(String str, String str2, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.A(str2);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void unset(String str, String str2, Promise promise) {
        MixpanelAPI mixpanelAPIL = MixpanelAPI.l(this.mReactContext, str, null, false);
        synchronized (mixpanelAPIL) {
            mixpanelAPIL.f46036e.c(str2);
            promise.resolve(null);
        }
    }
}
