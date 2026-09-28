package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbsj implements zzbrv {

    /* renamed from: a, reason: collision with root package name */
    public final zzbrx f25518a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbry f25519b;

    /* renamed from: c, reason: collision with root package name */
    public final zzbrr f25520c;

    /* renamed from: d, reason: collision with root package name */
    public final String f25521d;

    public zzbsj(zzbrr zzbrrVar, String str, zzbry zzbryVar, zzbrx zzbrxVar) {
        this.f25520c = zzbrrVar;
        this.f25521d = str;
        this.f25519b = zzbryVar;
        this.f25518a = zzbrxVar;
    }

    public final ListenableFuture a(Object obj) {
        zzcdt zzcdtVar = new zzcdt();
        zzbrl zzbrlVarB = this.f25520c.b();
        com.google.android.gms.ads.internal.util.zze.k("callJs > getEngine: Promise created");
        zzbrlVarB.a(new zzbsg(this, zzbrlVarB, obj, zzcdtVar), new zzbsh(zzbrlVarB, this, zzcdtVar));
        return zzcdtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) {
        return a(obj);
    }
}
