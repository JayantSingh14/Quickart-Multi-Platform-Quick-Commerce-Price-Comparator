package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzdzc implements zzdyn {

    /* renamed from: a, reason: collision with root package name */
    public final long f28814a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdyr f28815b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfhi f28816c;

    public zzdzc(long j2, Context context, zzdyr zzdyrVar, zzclg zzclgVar, String str) {
        this.f28814a = j2;
        this.f28815b = zzdyrVar;
        zzcnv zzcnvVar = (zzcnv) zzclgVar.t();
        zzcnvVar.a(context);
        zzcnvVar.f26747c = str;
        this.f28816c = ((zzcnw) zzcnvVar.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    public final void a(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        try {
            this.f28816c.I5(zzmVar, new zzdza(this));
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    public final void zzb() {
        try {
            zzfhi zzfhiVar = this.f28816c;
            zzfhiVar.q5(new zzdzb(this));
            zzfhiVar.N(new ObjectWrapper(null));
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    public final void zzc() {
    }
}
