package io.invertase.firebase.common;

import android.content.SharedPreferences;
import io.invertase.firebase.app.ReactNativeFirebaseApp;

/* loaded from: classes.dex */
public class ReactNativeFirebasePreferences {

    /* renamed from: b, reason: collision with root package name */
    public static final ReactNativeFirebasePreferences f49240b = new ReactNativeFirebasePreferences();

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f49241a;

    public final SharedPreferences a() {
        if (this.f49241a == null) {
            this.f49241a = ReactNativeFirebaseApp.f49227a.getSharedPreferences("io.invertase.firebase", 0);
        }
        return this.f49241a;
    }
}
