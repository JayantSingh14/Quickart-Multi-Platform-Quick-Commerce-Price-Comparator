package com.reactnativedocumentpicker;

import android.support.v4.media.b;
import android.util.Log;
import com.facebook.react.bridge.Promise;

/* loaded from: classes4.dex */
public class PromiseWrapper {

    /* renamed from: a, reason: collision with root package name */
    public Promise f46378a;

    /* renamed from: b, reason: collision with root package name */
    public String f46379b;

    public final void a(String str, String str2, Exception exc) {
        Promise promise = this.f46378a;
        if (promise == null) {
            Log.e(NativeDocumentPickerSpec.NAME, "cannot reject promise because it's null");
            return;
        }
        this.f46379b = null;
        this.f46378a = null;
        promise.reject(str, str2, exc);
    }

    public final void b(Object obj) {
        Promise promise = this.f46378a;
        if (promise == null) {
            Log.e(NativeDocumentPickerSpec.NAME, "cannot resolve promise because it's null");
            return;
        }
        this.f46379b = null;
        this.f46378a = null;
        promise.resolve(obj);
    }

    public final boolean c(Promise promise, String str) {
        if (this.f46378a == null) {
            this.f46378a = promise;
            this.f46379b = str;
            return true;
        }
        StringBuilder sbY = b.y("Warning: previous promise did not settle and you attempted to overwrite it. You've called \"", str, "\" while \"");
        sbY.append(this.f46379b);
        sbY.append("\" was already in progress and has not completed yet.");
        promise.reject("ASYNC_OP_IN_PROGRESS", sbY.toString());
        return false;
    }
}
