package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbsz;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzal extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f21096b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzr f21097c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f21098d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzbsz f21099e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzaz f21100f;

    public zzal(zzaz zzazVar, Context context, zzr zzrVar, String str, zzbsz zzbszVar) {
        this.f21096b = context;
        this.f21097c = zzrVar;
        this.f21098d = str;
        this.f21099e = zzbszVar;
        Objects.requireNonNull(zzazVar);
        this.f21100f = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21096b, "banner");
        return new zzfk();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* synthetic */ Object b() {
        return this.f21100f.f21132a.a(this.f21096b, this.f21097c, this.f21098d, this.f21099e, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.m3(new ObjectWrapper(this.f21096b), this.f21097c, this.f21098d, this.f21099e, ModuleDescriptor.MODULE_VERSION);
    }
}
