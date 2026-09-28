package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public class CsiParamDefaults {

    /* renamed from: a, reason: collision with root package name */
    public final String f21964a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21965b;

    public CsiParamDefaults(Context context, VersionInfoParcel versionInfoParcel) {
        this.f21964a = context.getPackageName();
        this.f21965b = versionInfoParcel.f21400a;
    }
}
