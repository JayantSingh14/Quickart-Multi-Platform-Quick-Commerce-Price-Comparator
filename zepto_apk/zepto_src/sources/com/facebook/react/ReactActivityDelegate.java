package com.facebook.react;

import android.os.Bundle;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.core.PermissionListener;

/* loaded from: classes.dex */
public class ReactActivityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final ReactActivity f18436a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18437b;

    /* renamed from: c, reason: collision with root package name */
    public PermissionListener f18438c;

    /* renamed from: d, reason: collision with root package name */
    public e f18439d;

    /* renamed from: e, reason: collision with root package name */
    public ReactDelegate f18440e;

    public ReactActivityDelegate(ReactActivity reactActivity, String str) {
        this.f18436a = reactActivity;
        this.f18437b = str;
    }

    public Bundle a() {
        return null;
    }

    public boolean b() {
        return ReactNativeFeatureFlags.f18968a.enableFabricRenderer();
    }
}
