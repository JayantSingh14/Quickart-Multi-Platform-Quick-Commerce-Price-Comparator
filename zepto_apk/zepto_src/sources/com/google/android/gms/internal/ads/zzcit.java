package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcit implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f26345a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f26346b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f26347c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzcjc f26348d;

    public zzcit(zzcjc zzcjcVar, List list, String str, Uri uri) {
        this.f26345a = list;
        this.f26346b = str;
        this.f26347c = uri;
        Objects.requireNonNull(zzcjcVar);
        this.f26348d = zzcjcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        String strValueOf = String.valueOf(this.f26347c);
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Failed to parse gmsg params for: ".concat(strValueOf));
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* synthetic */ void zzb(Object obj) {
        this.f26348d.T((Map) obj, this.f26345a, this.f26346b);
    }
}
