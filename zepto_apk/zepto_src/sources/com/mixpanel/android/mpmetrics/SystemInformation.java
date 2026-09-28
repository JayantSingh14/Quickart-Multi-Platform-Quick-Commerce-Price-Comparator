package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: classes.dex */
class SystemInformation {

    /* renamed from: g, reason: collision with root package name */
    public static SystemInformation f46085g;

    /* renamed from: h, reason: collision with root package name */
    public static final Object f46086h = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Context f46087a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f46088b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f46089c;

    /* renamed from: d, reason: collision with root package name */
    public final DisplayMetrics f46090d;

    /* renamed from: e, reason: collision with root package name */
    public final String f46091e;

    /* renamed from: f, reason: collision with root package name */
    public final Integer f46092f;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SystemInformation(android.content.Context r9) throws java.lang.NoSuchMethodException, android.content.pm.PackageManager.NameNotFoundException, java.lang.SecurityException {
        /*
            r8 = this;
            java.lang.String r0 = "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it."
            java.lang.String r1 = "MixpanelAPI.SysInfo"
            r8.<init>()
            r8.f46087a = r9
            android.content.pm.PackageManager r2 = r9.getPackageManager()
            r3 = 0
            java.lang.String r4 = r9.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            r5 = 0
            android.content.pm.PackageInfo r4 = r2.getPackageInfo(r4, r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            java.lang.String r5 = r4.versionName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L20
            int r4 = r4.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L21
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L21
            goto L27
        L20:
            r5 = r3
        L21:
            java.lang.String r4 = "System information constructed with a context that apparently doesn't exist."
            com.mixpanel.android.util.MPLog.f(r1, r4)
            r4 = r3
        L27:
            android.content.pm.ApplicationInfo r6 = r9.getApplicationInfo()
            int r7 = r6.labelRes
            r8.f46091e = r5
            r8.f46092f = r4
            if (r7 != 0) goto L3c
            java.lang.CharSequence r9 = r6.nonLocalizedLabel
            if (r9 != 0) goto L38
            goto L3f
        L38:
            r9.toString()
            goto L3f
        L3c:
            r9.getString(r7)
        L3f:
            java.lang.Class r9 = r2.getClass()
            java.lang.String r4 = "hasSystemFeature"
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            java.lang.Class[] r5 = new java.lang.Class[]{r5}     // Catch: java.lang.NoSuchMethodException -> L50
            java.lang.reflect.Method r9 = r9.getMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L50
            goto L51
        L50:
            r9 = r3
        L51:
            if (r9 == 0) goto L7a
            java.lang.String r4 = "android.hardware.nfc"
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch: java.lang.IllegalAccessException -> L6d java.lang.reflect.InvocationTargetException -> L6f
            java.lang.Object r4 = r9.invoke(r2, r4)     // Catch: java.lang.IllegalAccessException -> L6d java.lang.reflect.InvocationTargetException -> L6f
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.IllegalAccessException -> L6d java.lang.reflect.InvocationTargetException -> L6f
            java.lang.String r5 = "android.hardware.telephony"
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch: java.lang.IllegalAccessException -> L71 java.lang.reflect.InvocationTargetException -> L76
            java.lang.Object r9 = r9.invoke(r2, r5)     // Catch: java.lang.IllegalAccessException -> L71 java.lang.reflect.InvocationTargetException -> L76
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.IllegalAccessException -> L71 java.lang.reflect.InvocationTargetException -> L76
        L6b:
            r3 = r4
            goto L7b
        L6d:
            r4 = r3
            goto L71
        L6f:
            r4 = r3
            goto L76
        L71:
            com.mixpanel.android.util.MPLog.f(r1, r0)
        L74:
            r9 = r3
            goto L6b
        L76:
            com.mixpanel.android.util.MPLog.f(r1, r0)
            goto L74
        L7a:
            r9 = r3
        L7b:
            r8.f46088b = r3
            r8.f46089c = r9
            android.util.DisplayMetrics r9 = new android.util.DisplayMetrics
            r9.<init>()
            r8.f46090d = r9
            android.content.Context r0 = r8.f46087a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            r0.getMetrics(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.SystemInformation.<init>(android.content.Context):void");
    }

    public static SystemInformation a(Context context) {
        synchronized (f46086h) {
            try {
                if (f46085g == null) {
                    f46085g = new SystemInformation(context.getApplicationContext());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f46085g;
    }
}
