package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;

/* loaded from: classes.dex */
final class zzjx implements zzju {

    /* renamed from: d, reason: collision with root package name */
    public static zzjx f37016d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f37017a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentObserver f37018b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f37019c;

    public zzjx() {
        this.f37019c = false;
        this.f37017a = null;
        this.f37018b = null;
    }

    public static zzjx a(Context context) {
        zzjx zzjxVar;
        synchronized (zzjx.class) {
            try {
                if (f37016d == null) {
                    f37016d = PermissionChecker.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzjx(context) : new zzjx();
                }
                zzjx zzjxVar2 = f37016d;
                if (zzjxVar2 != null && zzjxVar2.f37018b != null && !zzjxVar2.f37019c) {
                    try {
                        context.getContentResolver().registerContentObserver(zzjg.f36986a, true, f37016d.f37018b);
                        zzjx zzjxVar3 = f37016d;
                        zzjxVar3.getClass();
                        zzjxVar3.f37019c = true;
                    } catch (SecurityException e2) {
                        Log.e("GservicesLoader", "Unable to register Gservices content observer", e2);
                    }
                }
                zzjxVar = f37016d;
                zzjxVar.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzjxVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0040, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.android.gms.internal.measurement.zzjw] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(final java.lang.String r9) {
        /*
            r8 = this;
            android.content.Context r0 = r8.f37017a
            r1 = 0
            if (r0 == 0) goto L8d
            boolean r2 = com.google.android.gms.internal.measurement.zzjm.f36999b
            r3 = 1
            if (r2 == 0) goto Lb
            goto L59
        Lb:
            java.lang.Class<com.google.android.gms.internal.measurement.zzjm> r2 = com.google.android.gms.internal.measurement.zzjm.class
            monitor-enter(r2)
            boolean r4 = com.google.android.gms.internal.measurement.zzjm.f36999b     // Catch: java.lang.Throwable -> L14
            if (r4 == 0) goto L17
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            goto L59
        L14:
            r9 = move-exception
            goto L8b
        L17:
            r4 = r3
        L18:
            r5 = 2
            r6 = 0
            if (r4 > r5) goto L4f
            android.os.UserManager r5 = com.google.android.gms.internal.measurement.zzjm.f36998a     // Catch: java.lang.Throwable -> L14
            if (r5 != 0) goto L2a
            java.lang.Class<android.os.UserManager> r5 = android.os.UserManager.class
            java.lang.Object r5 = r0.getSystemService(r5)     // Catch: java.lang.Throwable -> L14
            android.os.UserManager r5 = (android.os.UserManager) r5     // Catch: java.lang.Throwable -> L14
            com.google.android.gms.internal.measurement.zzjm.f36998a = r5     // Catch: java.lang.Throwable -> L14
        L2a:
            android.os.UserManager r5 = com.google.android.gms.internal.measurement.zzjm.f36998a     // Catch: java.lang.Throwable -> L14
            if (r5 != 0) goto L30
            r6 = r3
            goto L53
        L30:
            boolean r7 = r5.isUserUnlocked()     // Catch: java.lang.Throwable -> L14 java.lang.NullPointerException -> L42
            if (r7 != 0) goto L40
            android.os.UserHandle r7 = android.os.Process.myUserHandle()     // Catch: java.lang.Throwable -> L14 java.lang.NullPointerException -> L42
            boolean r0 = r5.isUserRunning(r7)     // Catch: java.lang.Throwable -> L14 java.lang.NullPointerException -> L42
            if (r0 != 0) goto L4f
        L40:
            r6 = r3
            goto L4f
        L42:
            r5 = move-exception
            java.lang.String r6 = "DirectBootUtils"
            java.lang.String r7 = "Failed to check if user is unlocked."
            android.util.Log.w(r6, r7, r5)     // Catch: java.lang.Throwable -> L14
            com.google.android.gms.internal.measurement.zzjm.f36998a = r1     // Catch: java.lang.Throwable -> L14
            int r4 = r4 + 1
            goto L18
        L4f:
            if (r6 == 0) goto L53
            com.google.android.gms.internal.measurement.zzjm.f36998a = r1     // Catch: java.lang.Throwable -> L14
        L53:
            if (r6 == 0) goto L57
            com.google.android.gms.internal.measurement.zzjm.f36999b = r3     // Catch: java.lang.Throwable -> L14
        L57:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            r3 = r6
        L59:
            if (r3 != 0) goto L5c
            goto L8d
        L5c:
            com.google.android.gms.internal.measurement.zzjw r0 = new com.google.android.gms.internal.measurement.zzjw     // Catch: java.lang.NullPointerException -> L74 java.lang.SecurityException -> L76 java.lang.IllegalStateException -> L78
            r0.<init>()     // Catch: java.lang.NullPointerException -> L74 java.lang.SecurityException -> L76 java.lang.IllegalStateException -> L78
            java.lang.Object r0 = r0.a()     // Catch: java.lang.SecurityException -> L66 java.lang.NullPointerException -> L74 java.lang.IllegalStateException -> L78
            goto L71
        L66:
            long r2 = android.os.Binder.clearCallingIdentity()     // Catch: java.lang.NullPointerException -> L74 java.lang.SecurityException -> L76 java.lang.IllegalStateException -> L78
            java.lang.Object r0 = r0.a()     // Catch: java.lang.Throwable -> L7a
            android.os.Binder.restoreCallingIdentity(r2)     // Catch: java.lang.NullPointerException -> L74 java.lang.SecurityException -> L76 java.lang.IllegalStateException -> L78
        L71:
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.NullPointerException -> L74 java.lang.SecurityException -> L76 java.lang.IllegalStateException -> L78
            return r0
        L74:
            r0 = move-exception
            goto L7f
        L76:
            r0 = move-exception
            goto L7f
        L78:
            r0 = move-exception
            goto L7f
        L7a:
            r0 = move-exception
            android.os.Binder.restoreCallingIdentity(r2)     // Catch: java.lang.NullPointerException -> L74 java.lang.SecurityException -> L76 java.lang.IllegalStateException -> L78
            throw r0     // Catch: java.lang.NullPointerException -> L74 java.lang.SecurityException -> L76 java.lang.IllegalStateException -> L78
        L7f:
            java.lang.String r2 = "Unable to read GServices for: "
            java.lang.String r9 = r2.concat(r9)
            java.lang.String r2 = "GservicesLoader"
            android.util.Log.e(r2, r9, r0)
            return r1
        L8b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
            throw r9
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjx.b(java.lang.String):java.lang.String");
    }

    public zzjx(Context context) {
        this.f37019c = false;
        this.f37017a = context;
        this.f37018b = new zzjv(this);
    }
}
