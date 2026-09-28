package io.invertase.firebase.common;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import in.juspay.hypernfc.b;
import io.invertase.firebase.interfaces.NativeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ReactNativeFirebaseEventEmitter {

    /* renamed from: g, reason: collision with root package name */
    public static final ReactNativeFirebaseEventEmitter f49230g = new ReactNativeFirebaseEventEmitter();

    /* renamed from: d, reason: collision with root package name */
    public ReactContext f49234d;

    /* renamed from: f, reason: collision with root package name */
    public int f49236f;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f49231a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f49232b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f49233c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public Boolean f49235e = Boolean.FALSE;

    public final boolean a(NativeEvent nativeEvent) {
        ReactContext reactContext;
        if (this.f49235e.booleanValue() && (reactContext = this.f49234d) != null && reactContext.hasActiveCatalystInstance()) {
            try {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.f49234d.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("rnfb_" + nativeEvent.b(), nativeEvent.a());
                return true;
            } catch (Exception e2) {
                Log.wtf("RNFB_EMITTER", "Error sending Event " + nativeEvent.b(), e2);
            }
        }
        return false;
    }

    public final void b(NativeEvent nativeEvent) {
        this.f49232b.post(new b(16, this, nativeEvent));
    }

    public final void c() {
        synchronized (this.f49233c) {
            try {
                Iterator it = new ArrayList(this.f49231a).iterator();
                while (it.hasNext()) {
                    NativeEvent nativeEvent = (NativeEvent) it.next();
                    if (this.f49233c.containsKey(nativeEvent.b())) {
                        this.f49231a.remove(nativeEvent);
                        b(nativeEvent);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
