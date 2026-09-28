package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzel extends zzbc {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzen f21193c;

    public zzel(zzen zzenVar) {
        Objects.requireNonNull(zzenVar);
        this.f21193c = zzenVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbc, com.google.android.gms.ads.AdListener
    public final void g(LoadAdError loadAdError) {
        zzen zzenVar = this.f21193c;
        VideoController videoController = zzenVar.f21198c;
        zzbx zzbxVar = zzenVar.f21204i;
        zzed zzedVarW = null;
        if (zzbxVar != null) {
            try {
                zzedVarW = zzbxVar.w();
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
        videoController.a(zzedVarW);
        super.g(loadAdError);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbc, com.google.android.gms.ads.AdListener
    public final void m() {
        zzen zzenVar = this.f21193c;
        VideoController videoController = zzenVar.f21198c;
        zzbx zzbxVar = zzenVar.f21204i;
        zzed zzedVarW = null;
        if (zzbxVar != null) {
            try {
                zzedVarW = zzbxVar.w();
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
        videoController.a(zzedVarW);
        super.m();
    }
}
