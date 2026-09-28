package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzfep implements zzfkt {

    /* renamed from: a, reason: collision with root package name */
    public final zzffi f30973a;

    /* renamed from: b, reason: collision with root package name */
    public final zzffk f30974b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzm f30975c;

    /* renamed from: d, reason: collision with root package name */
    public final String f30976d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgyw f30977e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzx f30978f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfkj f30979g;

    public zzfep(zzffi zzffiVar, zzffk zzffkVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzgyw zzgywVar, com.google.android.gms.ads.internal.client.zzx zzxVar, zzfkj zzfkjVar) {
        this.f30973a = zzffiVar;
        this.f30974b = zzffkVar;
        this.f30975c = zzmVar;
        this.f30976d = str;
        this.f30977e = zzgywVar;
        this.f30978f = zzxVar;
        this.f30979g = zzfkjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final Executor zza() {
        return this.f30977e;
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final zzfkj zzb() {
        return this.f30979g;
    }
}
