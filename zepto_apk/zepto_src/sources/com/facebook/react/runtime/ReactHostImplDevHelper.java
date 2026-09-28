package com.facebook.react.runtime;

import android.app.Activity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.ReactInstanceDevHelper;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ReactHostImplDevHelper implements ReactInstanceDevHelper {

    /* renamed from: a, reason: collision with root package name */
    public final ReactHostImpl f19260a;

    public ReactHostImplDevHelper(ReactHostImpl delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f19260a = delegate;
    }

    public final Activity a() {
        WeakReference weakReference = (WeakReference) this.f19260a.o.get();
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public final void b() {
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
        ReactContext reactContextM = this.f19260a.m();
        if (reactContextM == null || (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContextM.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) == null) {
            return;
        }
        rCTDeviceEventEmitter.emit("toggleElementInspector", null);
    }
}
