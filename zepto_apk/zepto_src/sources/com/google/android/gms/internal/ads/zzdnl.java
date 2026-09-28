package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes4.dex */
public final class zzdnl extends com.google.android.gms.ads.internal.client.zzec {

    /* renamed from: a, reason: collision with root package name */
    public final Object f28023a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzed f28024b;

    /* renamed from: c, reason: collision with root package name */
    public final zzbto f28025c;

    public zzdnl(com.google.android.gms.ads.internal.client.zzed zzedVar, zzbto zzbtoVar) {
        this.f28024b = zzedVar;
        this.f28025c = zzbtoVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void B() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void D1(com.google.android.gms.ads.internal.client.zzeg zzegVar) {
        synchronized (this.f28023a) {
            try {
                com.google.android.gms.ads.internal.client.zzed zzedVar = this.f28024b;
                if (zzedVar != null) {
                    zzedVar.D1(zzegVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void N0(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zze() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzf() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzh() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final int zzi() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzj() {
        zzbto zzbtoVar = this.f28025c;
        if (zzbtoVar != null) {
            return zzbtoVar.H();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzk() {
        zzbto zzbtoVar = this.f28025c;
        if (zzbtoVar != null) {
            return zzbtoVar.t();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzm() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzn() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final com.google.android.gms.ads.internal.client.zzeg zzo() {
        synchronized (this.f28023a) {
            try {
                com.google.android.gms.ads.internal.client.zzed zzedVar = this.f28024b;
                if (zzedVar == null) {
                    return null;
                }
                return zzedVar.zzo();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }
}
