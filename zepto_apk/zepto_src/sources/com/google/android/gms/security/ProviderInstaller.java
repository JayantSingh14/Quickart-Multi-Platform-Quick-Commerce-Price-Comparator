package com.google.android.gms.security;

import android.content.Context;
import android.util.Log;
import com.amazon.apay.hardened.activity.APayBrowserActivity;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class ProviderInstaller {

    /* renamed from: a, reason: collision with root package name */
    public static final GoogleApiAvailabilityLight f39711a = GoogleApiAvailabilityLight.getInstance();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f39712b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static Method f39713c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f39714d = false;

    public interface ProviderInstallListener {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051 A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0015, B:7:0x001c, B:14:0x003f, B:15:0x0044, B:12:0x002b, B:17:0x0046, B:28:0x00a0, B:29:0x00a5, B:31:0x00a7, B:32:0x00b5, B:20:0x0051, B:22:0x0055, B:25:0x0090), top: B:37:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0 A[Catch: all -> 0x0027, TryCatch #1 {, blocks: (B:4:0x0015, B:7:0x001c, B:14:0x003f, B:15:0x0044, B:12:0x002b, B:17:0x0046, B:28:0x00a0, B:29:0x00a5, B:31:0x00a7, B:32:0x00b5, B:20:0x0051, B:22:0x0055, B:25:0x0090), top: B:37:0x0015, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7 A[Catch: all -> 0x0027, TryCatch #1 {, blocks: (B:4:0x0015, B:7:0x001c, B:14:0x003f, B:15:0x0044, B:12:0x002b, B:17:0x0046, B:28:0x00a0, B:29:0x00a5, B:31:0x00a7, B:32:0x00b5, B:20:0x0051, B:22:0x0055, B:25:0x0090), top: B:37:0x0015, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r11) throws com.google.android.gms.common.GooglePlayServicesRepairableException, com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        /*
            r0 = 1
            java.lang.String r1 = "Context must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11, r1)
            com.google.android.gms.common.GoogleApiAvailabilityLight r1 = com.google.android.gms.security.ProviderInstaller.f39711a
            r2 = 11925000(0xb5f608, float:1.6710484E-38)
            r1.verifyGooglePlayServicesIsAvailable(r11, r2)
            long r1 = android.os.SystemClock.uptimeMillis()
            java.lang.Object r3 = com.google.android.gms.security.ProviderInstaller.f39712b
            monitor-enter(r3)
            boolean r4 = com.google.android.gms.security.ProviderInstaller.f39714d     // Catch: java.lang.Throwable -> L27
            r5 = 0
            if (r4 != 0) goto L46
            java.lang.String r4 = "Failed to load providerinstaller module: "
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r6 = com.google.android.gms.dynamite.DynamiteModule.f22321e     // Catch: java.lang.Throwable -> L27 com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L2a
            java.lang.String r7 = "com.google.android.gms.providerinstaller.dynamite"
            com.google.android.gms.dynamite.DynamiteModule r6 = com.google.android.gms.dynamite.DynamiteModule.c(r11, r6, r7)     // Catch: java.lang.Throwable -> L27 com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L2a
            android.content.Context r4 = r6.f22330a     // Catch: java.lang.Throwable -> L27 com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L2a
            goto L3d
        L27:
            r11 = move-exception
            goto Lb6
        L2a:
            r6 = move-exception
            java.lang.String r7 = "ProviderInstaller"
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L27
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L27
            java.lang.String r4 = r4.concat(r6)     // Catch: java.lang.Throwable -> L27
            android.util.Log.w(r7, r4)     // Catch: java.lang.Throwable -> L27
            r4 = r5
        L3d:
            if (r4 == 0) goto L46
            java.lang.String r11 = "com.google.android.gms.providerinstaller.ProviderInstallerImpl"
            c(r4, r11)     // Catch: java.lang.Throwable -> L27
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L27
            goto La6
        L46:
            boolean r4 = com.google.android.gms.security.ProviderInstaller.f39714d     // Catch: java.lang.Throwable -> L27
            java.lang.String r6 = "Failed to report request stats: "
            android.content.Context r7 = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(r11)     // Catch: java.lang.Throwable -> L27
            if (r7 != 0) goto L51
            goto L9e
        L51:
            com.google.android.gms.security.ProviderInstaller.f39714d = r0     // Catch: java.lang.Throwable -> L27
            if (r4 != 0) goto L9d
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            java.lang.ClassLoader r8 = r7.getClassLoader()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            java.lang.Class<android.content.Context> r9 = android.content.Context.class
            com.google.android.gms.internal.common.zzi r10 = new com.google.android.gms.internal.common.zzi     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            r10.<init>(r9, r11)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            com.google.android.gms.internal.common.zzh r11 = new com.google.android.gms.internal.common.zzh     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            r11.<init>(r2, r1)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            com.google.android.gms.internal.common.zzh r1 = new com.google.android.gms.internal.common.zzh     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            r1.<init>(r2, r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            r2 = 3
            com.google.android.gms.internal.common.zzi[] r2 = new com.google.android.gms.internal.common.zzi[r2]     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            r4 = 0
            r2[r4] = r10     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            r2[r0] = r11     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            r11 = 2
            r2[r11] = r1     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            java.lang.String r11 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.Class r11 = r8.loadClass(r11)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            java.lang.String r0 = "reportRequestStats2"
            com.google.android.gms.internal.common.zzj.b(r11, r0, r2)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L8f
            goto L9d
        L8f:
            r11 = move-exception
            java.lang.String r0 = "ProviderInstaller"
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L27
            java.lang.String r11 = r6.concat(r11)     // Catch: java.lang.Throwable -> L27
            android.util.Log.w(r0, r11)     // Catch: java.lang.Throwable -> L27
        L9d:
            r5 = r7
        L9e:
            if (r5 == 0) goto La7
            java.lang.String r11 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            c(r5, r11)     // Catch: java.lang.Throwable -> L27
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L27
        La6:
            return
        La7:
            java.lang.String r11 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r11, r0)     // Catch: java.lang.Throwable -> L27
            com.google.android.gms.common.GooglePlayServicesNotAvailableException r11 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException     // Catch: java.lang.Throwable -> L27
            r0 = 8
            r11.<init>(r0)     // Catch: java.lang.Throwable -> L27
            throw r11     // Catch: java.lang.Throwable -> L27
        Lb6:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L27
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.security.ProviderInstaller.a(android.content.Context):void");
    }

    public static void b(APayBrowserActivity aPayBrowserActivity, APayBrowserActivity aPayBrowserActivity2) {
        Preconditions.checkNotNull(aPayBrowserActivity, "Context must not be null");
        Preconditions.checkNotNull(aPayBrowserActivity2, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(aPayBrowserActivity, aPayBrowserActivity2).execute(new Void[0]);
    }

    public static void c(Context context, String str) throws IllegalAccessException, GooglePlayServicesNotAvailableException, IllegalArgumentException, InvocationTargetException {
        try {
            if (f39713c == null) {
                f39713c = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            f39713c.invoke(null, context);
        } catch (Exception e2) {
            Throwable cause = e2.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e2.toString() : cause.toString())));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
