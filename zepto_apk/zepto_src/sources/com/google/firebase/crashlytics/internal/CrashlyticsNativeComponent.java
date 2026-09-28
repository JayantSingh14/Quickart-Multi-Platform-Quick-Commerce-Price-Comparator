package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes.dex */
public interface CrashlyticsNativeComponent {
    NativeSessionFileProvider a(String str);

    boolean b();

    void c(String str, long j2, StaticSessionData staticSessionData);

    boolean d(String str);
}
