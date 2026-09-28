package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.TreeMap;

/* loaded from: classes4.dex */
final class zzr {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21664a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21665b;

    /* renamed from: c, reason: collision with root package name */
    public final TreeMap f21666c = new TreeMap();

    /* renamed from: d, reason: collision with root package name */
    public String f21667d;

    /* renamed from: e, reason: collision with root package name */
    public String f21668e;

    /* renamed from: f, reason: collision with root package name */
    public final String f21669f;

    public zzr(Context context, String str) {
        String strConcat;
        this.f21664a = context.getApplicationContext();
        this.f21665b = str;
        String packageName = context.getPackageName();
        try {
            String str2 = Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 1 + String.valueOf(str2).length());
            sb.append(packageName);
            sb.append("-");
            sb.append(str2);
            strConcat = sb.toString();
        } catch (PackageManager.NameNotFoundException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to get package version name for reporting", e2);
            strConcat = String.valueOf(packageName).concat("-missing");
        }
        this.f21669f = strConcat;
    }
}
