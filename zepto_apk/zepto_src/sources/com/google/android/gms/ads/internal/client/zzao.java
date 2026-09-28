package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbsv;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzao extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f21110b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzr f21111c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f21112d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzbsv f21113e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzaz f21114f;

    public zzao(zzaz zzazVar, Context context, zzr zzrVar, String str, zzbsv zzbsvVar) {
        this.f21110b = context;
        this.f21111c = zzrVar;
        this.f21112d = str;
        this.f21113e = zzbsvVar;
        Objects.requireNonNull(zzazVar);
        this.f21114f = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21110b, "interstitial");
        return new zzfk();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* synthetic */ Object b() {
        zzk zzkVar = this.f21114f.f21132a;
        zzbsv zzbsvVar = this.f21113e;
        return zzkVar.a(this.f21110b, this.f21111c, this.f21112d, zzbsvVar, 2);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.F2(new ObjectWrapper(this.f21110b), this.f21111c, this.f21112d, this.f21113e, ModuleDescriptor.MODULE_VERSION);
    }
}
