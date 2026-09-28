package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class WakeLockHolder {

    /* renamed from: a, reason: collision with root package name */
    public static final long f44800a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b, reason: collision with root package name */
    public static final Object f44801b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static WakeLock f44802c;

    public static void a(Context context) {
        if (f44802c == null) {
            WakeLock wakeLock = new WakeLock(context);
            f44802c = wakeLock;
            synchronized (wakeLock.f39734a) {
                wakeLock.f39740g = true;
            }
        }
    }

    public static void b(Intent intent) {
        synchronized (f44801b) {
            try {
                if (f44802c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                    intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    f44802c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ComponentName c(Context context, Intent intent) {
        synchronized (f44801b) {
            try {
                a(context);
                boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!booleanExtra) {
                    f44802c.a(f44800a);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
