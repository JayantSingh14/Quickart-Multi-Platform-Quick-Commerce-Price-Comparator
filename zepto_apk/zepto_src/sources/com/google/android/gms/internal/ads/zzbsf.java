package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbsf {

    /* renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.ads.internal.util.zzbc f25506b = new zzbsd();

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.android.gms.ads.internal.util.zzbc f25507c = new zzbse();

    /* renamed from: a, reason: collision with root package name */
    public final zzbrr f25508a;

    public zzbsf(Context context, VersionInfoParcel versionInfoParcel, String str, zzfnr zzfnrVar) {
        this.f25508a = new zzbrr(context, versionInfoParcel, str, zzfnrVar);
    }

    public final zzbsj a(String str, zzbry zzbryVar, zzbrx zzbrxVar) {
        return new zzbsj(this.f25508a, str, zzbryVar, zzbrxVar);
    }
}
