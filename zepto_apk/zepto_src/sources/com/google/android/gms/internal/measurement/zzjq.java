package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class zzjq implements zzju {

    /* renamed from: h, reason: collision with root package name */
    public static final ArrayMap f37004h = new ArrayMap();

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f37005i = {"key", CLConstants.FIELD_PAY_INFO_VALUE};

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f37006a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f37007b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f37008c;

    /* renamed from: d, reason: collision with root package name */
    public final ContentObserver f37009d;

    /* renamed from: f, reason: collision with root package name */
    public volatile Map f37011f;

    /* renamed from: e, reason: collision with root package name */
    public final Object f37010e = new Object();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f37012g = new ArrayList();

    public zzjq(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        contentResolver.getClass();
        uri.getClass();
        this.f37006a = contentResolver;
        this.f37007b = uri;
        this.f37008c = runnable;
        this.f37009d = new zzjo(this);
    }

    public static zzjq a(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzjq zzjqVar;
        synchronized (zzjq.class) {
            ArrayMap arrayMap = f37004h;
            zzjqVar = (zzjq) arrayMap.get(uri);
            if (zzjqVar == null) {
                try {
                    zzjq zzjqVar2 = new zzjq(contentResolver, uri, runnable);
                    try {
                        contentResolver.registerContentObserver(uri, false, zzjqVar2.f37009d);
                        arrayMap.put(uri, zzjqVar2);
                    } catch (SecurityException unused) {
                    }
                    zzjqVar = zzjqVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzjqVar;
    }

    public static synchronized void c() {
        try {
            ArrayMap arrayMap = f37004h;
            for (zzjq zzjqVar : arrayMap.values()) {
                zzjqVar.f37006a.unregisterContentObserver(zzjqVar.f37009d);
            }
            arrayMap.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0052  */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.StrictMode$ThreadPolicy, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.google.android.gms.internal.measurement.zzjp] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map b() {
        /*
            r5 = this;
            java.util.Map r0 = r5.f37011f
            if (r0 != 0) goto L4f
            java.lang.Object r1 = r5.f37010e
            monitor-enter(r1)
            java.util.Map r0 = r5.f37011f     // Catch: java.lang.Throwable -> L2a
            if (r0 != 0) goto L4b
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()     // Catch: java.lang.Throwable -> L2a
            com.google.android.gms.internal.measurement.zzjp r2 = new com.google.android.gms.internal.measurement.zzjp     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            java.lang.Object r2 = r2.a()     // Catch: java.lang.SecurityException -> L19 java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30
            goto L24
        L19:
            long r3 = android.os.Binder.clearCallingIdentity()     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            java.lang.Object r2 = r2.a()     // Catch: java.lang.Throwable -> L34
            android.os.Binder.restoreCallingIdentity(r3)     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
        L24:
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
        L26:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L2a
            goto L43
        L2a:
            r0 = move-exception
            goto L4d
        L2c:
            r2 = move-exception
            goto L47
        L2e:
            r2 = move-exception
            goto L39
        L30:
            r2 = move-exception
            goto L39
        L32:
            r2 = move-exception
            goto L39
        L34:
            r2 = move-exception
            android.os.Binder.restoreCallingIdentity(r3)     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            throw r2     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
        L39:
            java.lang.String r3 = "ConfigurationContentLdr"
            java.lang.String r4 = "Unable to query ContentProvider, using default values"
            android.util.Log.w(r3, r4, r2)     // Catch: java.lang.Throwable -> L2c
            java.util.Map r2 = java.util.Collections.EMPTY_MAP     // Catch: java.lang.Throwable -> L2c
            goto L26
        L43:
            r5.f37011f = r2     // Catch: java.lang.Throwable -> L2a
            r0 = r2
            goto L4b
        L47:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L2a
            throw r2     // Catch: java.lang.Throwable -> L2a
        L4b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2a
            goto L4f
        L4d:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2a
            throw r0
        L4f:
            if (r0 == 0) goto L52
            return r0
        L52:
            java.util.Map r0 = java.util.Collections.EMPTY_MAP
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjq.b():java.util.Map");
    }
}
