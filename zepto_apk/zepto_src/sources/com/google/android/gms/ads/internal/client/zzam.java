package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbsz;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzam extends zzba {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f21101b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzr f21102c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f21103d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzbsz f21104e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzaz f21105f;

    public zzam(zzaz zzazVar, Context context, zzr zzrVar, String str, zzbsz zzbszVar) {
        this.f21101b = context;
        this.f21102c = zzrVar;
        this.f21103d = str;
        this.f21104e = zzbszVar;
        Objects.requireNonNull(zzazVar);
        this.f21105f = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object a() {
        zzaz.k(this.f21101b, "app_open");
        return new zzfk();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* synthetic */ Object b() {
        return this.f21105f.f21132a.a(this.f21101b, this.f21102c, this.f21103d, this.f21104e, 4);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object c(zzcr zzcrVar) {
        return zzcrVar.r6(new ObjectWrapper(this.f21101b), this.f21102c, this.f21103d, this.f21104e, ModuleDescriptor.MODULE_VERSION);
    }
}
