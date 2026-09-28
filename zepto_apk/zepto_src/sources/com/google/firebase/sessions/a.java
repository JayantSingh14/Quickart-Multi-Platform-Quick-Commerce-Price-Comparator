package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.FirebaseAppLifecycleListener;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements FirebaseAppLifecycleListener {
    @Override // com.google.firebase.FirebaseAppLifecycleListener
    public final void a() {
        Log.w(FirebaseSessionsRegistrar.TAG, "FirebaseApp instance deleted. Sessions library will stop collecting data.");
        SessionsActivityLifecycleCallbacks.f45122c = null;
    }
}
