package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* loaded from: classes4.dex */
public final class zzdsz extends VideoController.VideoLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final zzdnm f28502a;

    public zzdsz(zzdnm zzdnmVar) {
        this.f28502a = zzdnmVar;
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void a() {
        com.google.android.gms.ads.internal.client.zzeg zzegVarZzo;
        com.google.android.gms.ads.internal.client.zzed zzedVarR = this.f28502a.r();
        if (zzedVarR == null) {
            zzegVarZzo = null;
        } else {
            try {
                zzegVarZzo = zzedVarR.zzo();
            } catch (RemoteException unused) {
            }
        }
        if (zzegVarZzo == null) {
            return;
        }
        try {
            zzegVarZzo.zzh();
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Unable to call onVideoEnd()", e2);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void b() {
        com.google.android.gms.ads.internal.client.zzeg zzegVarZzo;
        com.google.android.gms.ads.internal.client.zzed zzedVarR = this.f28502a.r();
        if (zzedVarR == null) {
            zzegVarZzo = null;
        } else {
            try {
                zzegVarZzo = zzedVarR.zzo();
            } catch (RemoteException unused) {
            }
        }
        if (zzegVarZzo == null) {
            return;
        }
        try {
            zzegVarZzo.zzg();
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Unable to call onVideoEnd()", e2);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void c() {
        com.google.android.gms.ads.internal.client.zzeg zzegVarZzo;
        com.google.android.gms.ads.internal.client.zzed zzedVarR = this.f28502a.r();
        if (zzedVarR == null) {
            zzegVarZzo = null;
        } else {
            try {
                zzegVarZzo = zzedVarR.zzo();
            } catch (RemoteException unused) {
            }
        }
        if (zzegVarZzo == null) {
            return;
        }
        try {
            zzegVarZzo.zze();
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Unable to call onVideoEnd()", e2);
        }
    }
}
