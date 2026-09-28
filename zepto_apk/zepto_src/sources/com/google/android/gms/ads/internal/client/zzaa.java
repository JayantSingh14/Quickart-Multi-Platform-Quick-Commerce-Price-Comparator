package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzcar;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzaa extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f21080b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f21081c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzbsv f21082d;

    public zzaa(zzaz zzazVar, Context context, String str, zzbsv zzbsvVar) {
        this.f21080b = context;
        this.f21081c = str;
        this.f21082d = zzbsvVar;
        Objects.requireNonNull(zzazVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21080b, "rewarded");
        return new zzfq();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object b() {
        return zzcar.a(this.f21080b, this.f21081c, this.f21082d);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.Y2(new ObjectWrapper(this.f21080b), this.f21081c, this.f21082d, ModuleDescriptor.MODULE_VERSION);
    }
}
