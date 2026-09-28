package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzan extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f21106b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzr f21107c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f21108d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzaz f21109e;

    public zzan(zzaz zzazVar, Context context, zzr zzrVar, String str) {
        this.f21106b = context;
        this.f21107c = zzrVar;
        this.f21108d = str;
        Objects.requireNonNull(zzazVar);
        this.f21109e = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21106b, "search");
        return new zzfk();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* synthetic */ Object b() {
        return this.f21109e.f21132a.a(this.f21106b, this.f21107c, this.f21108d, null, 3);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.H5(new ObjectWrapper(this.f21106b), this.f21107c, this.f21108d, ModuleDescriptor.MODULE_VERSION);
    }
}
