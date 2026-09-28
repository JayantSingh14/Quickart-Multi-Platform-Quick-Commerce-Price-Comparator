package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.support.v4.media.b;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AndroidInfoHelpers {

    /* renamed from: a, reason: collision with root package name */
    public static final AndroidInfoHelpers f19180a = new AndroidInfoHelpers();

    /* renamed from: b, reason: collision with root package name */
    public static String f19181b;

    public static final String a() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (StringsKt.n(FINGERPRINT, "vbox", false)) {
            String str = Build.MODEL;
            Intrinsics.c(str);
            return str;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    public static final Map b(Context context) {
        String packageName;
        String string;
        String strJ;
        if (context != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            packageName = context.getPackageName();
            if (i2 == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i2);
                Intrinsics.c(string);
            }
        } else {
            packageName = null;
            string = null;
        }
        Pair pair = new Pair("appDisplayName", string);
        Pair pair2 = new Pair("appIdentifier", packageName);
        Pair pair3 = new Pair("platform", LogSubCategory.LifeCycle.ANDROID);
        Pair pair4 = new Pair("deviceName", Build.MODEL);
        HashMap map = ReactNativeVersion.f19182a;
        Object obj = map.get("major");
        Object obj2 = map.get("minor");
        Object obj3 = map.get("patch");
        Object obj4 = map.get("prerelease");
        if (obj4 == null || (strJ = b.j(obj4, "-")) == null) {
            strJ = "";
        }
        return MapsKt.h(pair, pair2, pair3, pair4, new Pair("reactNativeVersion", obj + CLConstants.DOT_SALT_DELIMETER + obj2 + CLConstants.DOT_SALT_DELIMETER + obj3 + strJ));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.lang.String c() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.f19181b     // Catch: java.lang.Throwable -> L3f
            if (r0 == 0) goto L7
            monitor-exit(r7)
            return r0
        L7:
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L54
            java.lang.String r2 = "/system/bin/getprop"
            java.lang.String r3 = "metro.host"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L54
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L54
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4a
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4a
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4a
            java.lang.String r5 = "UTF-8"
            java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4a
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4a
            java.lang.String r0 = ""
        L2e:
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r3 == 0) goto L36
            r0 = r3
            goto L2e
        L36:
            com.facebook.react.modules.systeminfo.AndroidInfoHelpers.f19181b = r0     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r2.close()     // Catch: java.lang.Throwable -> L3f
        L3b:
            r1.destroy()     // Catch: java.lang.Throwable -> L3f
            goto L6b
        L3f:
            r0 = move-exception
            goto L7e
        L41:
            r0 = move-exception
            goto L73
        L43:
            r0 = move-exception
            goto L58
        L45:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L73
        L4a:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L58
        L4f:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L73
        L54:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L58:
            java.lang.String r3 = "AndroidInfoHelpers"
            java.lang.String r4 = "Failed to query for metro.host prop:"
            com.facebook.common.logging.FLog.r(r3, r4, r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = ""
            com.facebook.react.modules.systeminfo.AndroidInfoHelpers.f19181b = r0     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L68
            r2.close()     // Catch: java.lang.Throwable -> L3f
        L68:
            if (r1 == 0) goto L6b
            goto L3b
        L6b:
            java.lang.String r0 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.f19181b     // Catch: java.lang.Throwable -> L3f
            if (r0 != 0) goto L71
            java.lang.String r0 = ""
        L71:
            monitor-exit(r7)
            return r0
        L73:
            if (r2 == 0) goto L78
            r2.close()     // Catch: java.lang.Throwable -> L3f
        L78:
            if (r1 == 0) goto L7d
            r1.destroy()     // Catch: java.lang.Throwable -> L3f
        L7d:
            throw r0     // Catch: java.lang.Throwable -> L3f
        L7e:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L3f
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.systeminfo.AndroidInfoHelpers.c():java.lang.String");
    }
}
