package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;

/* loaded from: classes4.dex */
final class zzbfd implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbev f24876a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcdt f24877b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbff f24878c;

    public zzbfd(zzbff zzbffVar, zzbev zzbevVar, zzcdt zzcdtVar) {
        this.f24876a = zzbevVar;
        this.f24877b = zzcdtVar;
        this.f24878c = zzbffVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbff zzbffVar = this.f24878c;
        synchronized (zzbffVar.f24883c) {
            try {
                if (zzbffVar.f24882b) {
                    return;
                }
                zzbffVar.f24882b = true;
                final zzbeu zzbeuVar = zzbffVar.f24881a;
                if (zzbeuVar == null) {
                    return;
                }
                zzgyw zzgywVar = zzcdo.f25982a;
                final zzbev zzbevVar = this.f24876a;
                final zzcdt zzcdtVar = this.f24877b;
                final ListenableFuture listenableFutureSubmit = ((zzgxi) zzgywVar).submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbfc
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        zzbes zzbesVar;
                        boolean z;
                        long j2;
                        zzcdt zzcdtVar2 = zzcdtVar;
                        zzbeu zzbeuVar2 = zzbeuVar;
                        zzbfd zzbfdVar = this.f24872a;
                        try {
                            zzbex zzbexVar = (zzbex) zzbeuVar2.getService();
                            boolean zC = zzbeuVar2.c();
                            zzbev zzbevVar2 = zzbevVar;
                            if (zC) {
                                Parcel parcelG = zzbexVar.g();
                                zzbcd.c(parcelG, zzbevVar2);
                                Parcel parcelZ0 = zzbexVar.z0(2, parcelG);
                                zzbesVar = (zzbes) zzbcd.b(parcelZ0, zzbes.CREATOR);
                                parcelZ0.recycle();
                            } else {
                                Parcel parcelG2 = zzbexVar.g();
                                zzbcd.c(parcelG2, zzbevVar2);
                                Parcel parcelZ02 = zzbexVar.z0(1, parcelG2);
                                zzbesVar = (zzbes) zzbcd.b(parcelZ02, zzbes.CREATOR);
                                parcelZ02.recycle();
                            }
                            if (!zzbesVar.zza()) {
                                zzcdtVar2.c(new RuntimeException("No entry contents."));
                                zzbfdVar.f24878c.a();
                                return;
                            }
                            zzbfa zzbfaVar = new zzbfa(zzbfdVar, zzbesVar.b());
                            int i2 = zzbfaVar.read();
                            if (i2 == -1) {
                                throw new IOException("Unable to read from cache.");
                            }
                            zzbfaVar.unread(i2);
                            synchronized (zzbesVar) {
                                z = zzbesVar.f24853b;
                            }
                            boolean zS = zzbesVar.s();
                            synchronized (zzbesVar) {
                                j2 = zzbesVar.f24855d;
                            }
                            zzcdtVar2.b(new zzbfh(zzbfaVar, z, zS, j2, zzbesVar.r()));
                        } catch (RemoteException e2) {
                            e = e2;
                            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to obtain a cache service instance.", e);
                            zzcdtVar2.c(e);
                            zzbfdVar.f24878c.a();
                        } catch (IOException e3) {
                            e = e3;
                            int i32 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to obtain a cache service instance.", e);
                            zzcdtVar2.c(e);
                            zzbfdVar.f24878c.a();
                        }
                    }
                });
                zzcdtVar.f25992a.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbfb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        if (zzcdtVar.isCancelled()) {
                            listenableFutureSubmit.cancel(true);
                        }
                    }
                }, zzcdo.f25988g);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
    }
}
