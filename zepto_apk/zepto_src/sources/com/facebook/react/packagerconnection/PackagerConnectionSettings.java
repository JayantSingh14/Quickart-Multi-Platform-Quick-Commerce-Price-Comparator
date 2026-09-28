package com.facebook.react.packagerconnection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class PackagerConnectionSettings {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19208a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f19209b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19210c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f19211d;

    @Metadata
    public static final class Companion {
    }

    public PackagerConnectionSettings(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.f19208a = appContext;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.f19209b = defaultSharedPreferences;
        String packageName = appContext.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        this.f19210c = packageName;
        this.f19211d = new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a() {
        /*
            r8 = this;
            r0 = 0
            android.content.SharedPreferences r1 = r8.f19209b
            java.lang.String r2 = "debug_http_host"
            java.lang.String r0 = r1.getString(r2, r0)
            if (r0 == 0) goto L12
            int r1 = r0.length()
            if (r1 <= 0) goto L12
            return r0
        L12:
            android.content.Context r0 = r8.f19208a
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            com.facebook.react.modules.systeminfo.AndroidInfoHelpers r2 = com.facebook.react.modules.systeminfo.AndroidInfoHelpers.f19180a
            android.content.res.Resources r3 = r0.getResources()
            int r4 = com.facebook.react.R.integer.react_native_dev_server_port
            int r3 = r3.getInteger(r4)
            java.lang.String r4 = r2.c()
            int r4 = r4.length()
            java.lang.String r5 = "localhost"
            if (r4 <= 0) goto L36
            java.lang.String r2 = r2.c()
            goto L64
        L36:
            java.lang.String r2 = android.os.Build.FINGERPRINT
            java.lang.String r4 = "FINGERPRINT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r6 = "vbox"
            r7 = 0
            boolean r6 = kotlin.text.StringsKt.n(r2, r6, r7)
            if (r6 == 0) goto L49
            java.lang.String r2 = "10.0.3.2"
            goto L64
        L49:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r6 = "generic"
            boolean r6 = kotlin.text.StringsKt.n(r2, r6, r7)
            if (r6 != 0) goto L62
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r4 = "google/sdk_gphone"
            boolean r2 = kotlin.text.StringsKt.O(r2, r4, r7)
            if (r2 == 0) goto L60
            goto L62
        L60:
            r2 = r5
            goto L64
        L62:
            java.lang.String r2 = "10.0.2.2"
        L64:
            java.util.Locale r4 = java.util.Locale.US
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r3}
            r3 = 2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String r3 = "%s:%d"
            java.lang.String r2 = java.lang.String.format(r4, r3, r2)
            java.lang.String r3 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r3 = r2.equals(r5)
            if (r3 == 0) goto Lb1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.facebook.react.R.integer.react_native_dev_server_port
            int r0 = r0.getInteger(r1)
            java.lang.String r1 = "adb reverse tcp:"
            java.lang.String r3 = " tcp:"
            java.lang.String r0 = android.support.v4.media.b.d(r0, r0, r1, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "You seem to be running on device. Run '"
            r1.<init>(r3)
            r1.append(r0)
            java.lang.String r0 = "' to forward the debug server's port to the device."
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "PackagerConnectionSettings"
            com.facebook.common.logging.FLog.q(r1, r0)
        Lb1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.packagerconnection.PackagerConnectionSettings.a():java.lang.String");
    }
}
