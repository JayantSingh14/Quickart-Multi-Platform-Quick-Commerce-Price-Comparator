package io.invertase.firebase.common;

import com.facebook.react.bridge.ReactApplicationContext;

/* loaded from: classes.dex */
public class UniversalFirebaseModule {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f49247a;

    public UniversalFirebaseModule(ReactApplicationContext reactApplicationContext) {
        this.f49247a = reactApplicationContext;
        new TaskExecutorService("UniversalAnalyticsModule");
    }
}
