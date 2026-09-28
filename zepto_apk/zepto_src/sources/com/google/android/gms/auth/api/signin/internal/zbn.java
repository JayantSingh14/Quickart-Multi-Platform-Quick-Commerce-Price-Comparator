package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zbn {

    /* renamed from: b, reason: collision with root package name */
    public static zbn f22217b;

    /* renamed from: a, reason: collision with root package name */
    public final Storage f22218a;

    public zbn(Context context) {
        String strD;
        Storage storageA = Storage.a(context);
        this.f22218a = storageA;
        storageA.b();
        String strD2 = storageA.d("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strD2) || (strD = storageA.d(Storage.g("googleSignInOptions", strD2))) == null) {
            return;
        }
        try {
            GoogleSignInOptions.b(strD);
        } catch (JSONException unused) {
        }
    }

    public static synchronized zbn a(Context context) {
        zbn zbnVar;
        Context applicationContext = context.getApplicationContext();
        synchronized (zbn.class) {
            zbnVar = f22217b;
            if (zbnVar == null) {
                zbnVar = new zbn(applicationContext);
                f22217b = zbnVar;
            }
        }
        return zbnVar;
        return zbnVar;
    }

    public final synchronized void b() {
        Storage storage = this.f22218a;
        ReentrantLock reentrantLock = storage.f22205a;
        reentrantLock.lock();
        try {
            storage.f22206b.edit().clear().apply();
        } finally {
            reentrantLock.unlock();
        }
    }
}
