package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzfpe {

    /* renamed from: a, reason: collision with root package name */
    public final zzemr f31537a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31538b;

    /* renamed from: c, reason: collision with root package name */
    public final String f31539c;

    /* renamed from: d, reason: collision with root package name */
    public final String f31540d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f31541e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfid f31542f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfie f31543g;

    /* renamed from: h, reason: collision with root package name */
    public final Clock f31544h;

    /* renamed from: i, reason: collision with root package name */
    public final zzayq f31545i;

    public zzfpe(zzemr zzemrVar, VersionInfoParcel versionInfoParcel, String str, String str2, Context context, zzfid zzfidVar, zzfie zzfieVar, Clock clock, zzayq zzayqVar) {
        this.f31537a = zzemrVar;
        this.f31538b = versionInfoParcel.f21400a;
        this.f31539c = str;
        this.f31540d = str2;
        this.f31541e = context;
        this.f31542f = zzfidVar;
        this.f31543g = zzfieVar;
        this.f31544h = clock;
        this.f31545i = zzayqVar;
    }

    public static String c(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public final ArrayList a(zzfic zzficVar, zzfhr zzfhrVar, List list) {
        return b(zzficVar, zzfhrVar, false, "", "", list, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList b(com.google.android.gms.internal.ads.zzfic r20, com.google.android.gms.internal.ads.zzfhr r21, boolean r22, java.lang.String r23, java.lang.String r24, java.util.List r25, com.google.android.gms.internal.ads.zzcze r26, com.google.android.gms.internal.ads.zzcdb r27) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfpe.b(com.google.android.gms.internal.ads.zzfic, com.google.android.gms.internal.ads.zzfhr, boolean, java.lang.String, java.lang.String, java.util.List, com.google.android.gms.internal.ads.zzcze, com.google.android.gms.internal.ads.zzcdb):java.util.ArrayList");
    }
}
