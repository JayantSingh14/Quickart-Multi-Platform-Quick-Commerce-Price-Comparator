package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
final class zzcnf implements zzfei {

    /* renamed from: a, reason: collision with root package name */
    public final Context f26664a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzr f26665b;

    /* renamed from: c, reason: collision with root package name */
    public final String f26666c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcmv f26667d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f26668e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f26669f;

    public zzcnf(zzcmv zzcmvVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.f26667d = zzcmvVar;
        this.f26664a = context;
        this.f26665b = zzrVar;
        this.f26666c = str;
        zzijh zzijhVarA = zzijh.a(context);
        zzijh zzijhVarA2 = zzijh.a(zzrVar);
        zzijf zzijfVarA = zzijf.a(new zzeqq(zzcmvVar.f26587l));
        this.f26668e = zzijfVarA;
        zzijf zzijfVarA2 = zzijf.a(zzequ.f30117a);
        zzijf zzijfVarA3 = zzijf.a(zzdfr.f27709a);
        int i2 = zzfil.f31226a;
        this.f26669f = zzijf.a(new zzfeg(zzcmvVar.f26579d, zzijfVarA, zzijfVarA2, zzijfVarA3, zzijhVarA, zzijhVarA2, zzcmvVar.H));
    }

    @Override // com.google.android.gms.internal.ads.zzfei
    public final zzepu zza() {
        zzfef zzfefVar = (zzfef) this.f26669f.zzb();
        zzeqp zzeqpVar = (zzeqp) this.f26668e.zzb();
        zzcmv zzcmvVar = this.f26667d;
        zzijf zzijfVar = zzcmvVar.f26587l;
        VersionInfoParcel versionInfoParcel = zzcmvVar.f26577b.f26509a;
        zzijo.a(versionInfoParcel);
        zzdxe zzdxeVar = (zzdxe) zzijfVar.zzb();
        return new zzepu(this.f26664a, this.f26665b, this.f26666c, zzfefVar, zzeqpVar, versionInfoParcel, zzdxeVar);
    }
}
