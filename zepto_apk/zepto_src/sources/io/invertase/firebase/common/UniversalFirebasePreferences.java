package io.invertase.firebase.common;

import android.content.SharedPreferences;
import io.invertase.firebase.app.ReactNativeFirebaseApp;

/* loaded from: classes4.dex */
public class UniversalFirebasePreferences {

    /* renamed from: b, reason: collision with root package name */
    public static final UniversalFirebasePreferences f49248b = new UniversalFirebasePreferences();

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f49249a;

    public final SharedPreferences a() {
        if (this.f49249a == null) {
            this.f49249a = ReactNativeFirebaseApp.f49227a.getSharedPreferences("io.invertase.firebase", 0);
        }
        return this.f49249a;
    }
}
