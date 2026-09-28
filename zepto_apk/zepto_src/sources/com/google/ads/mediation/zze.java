package com.google.ads.mediation;

import android.os.RemoteException;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbkt;
import com.google.android.gms.internal.ads.zzbls;
import com.google.android.gms.internal.ads.zzblt;

@VisibleForTesting
/* loaded from: classes3.dex */
final class zze extends AdListener implements zzg, com.google.android.gms.ads.formats.zze, com.google.android.gms.ads.formats.zzd {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractAdViewAdapter f20505a;

    /* renamed from: b, reason: collision with root package name */
    public final MediationNativeListener f20506b;

    public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.f20505a = abstractAdViewAdapter;
        this.f20506b = mediationNativeListener;
    }

    @Override // com.google.android.gms.ads.formats.zze
    public final void a(zzbkt zzbktVar) {
        this.f20506b.s(zzbktVar);
    }

    @Override // com.google.android.gms.ads.formats.zzg
    public final void b(zzblt zzbltVar) throws SecurityException {
        String strZze;
        String strZzg;
        String strZzi;
        String strZzj;
        String strZzl;
        String strZzm;
        double dZzk;
        zzbls zzblsVar = zzbltVar.f25299a;
        zza zzaVar = new zza();
        Object objZ0 = null;
        try {
            strZze = zzblsVar.zze();
        } catch (RemoteException e2) {
            zzo.d("", e2);
            strZze = null;
        }
        zzaVar.f21694a = strZze;
        zzaVar.f21695b = zzbltVar.f25300b;
        try {
            strZzg = zzblsVar.zzg();
        } catch (RemoteException e3) {
            zzo.d("", e3);
            strZzg = null;
        }
        zzaVar.f21696c = strZzg;
        zzaVar.f21697d = zzbltVar.f25301c;
        try {
            strZzi = zzblsVar.zzi();
        } catch (RemoteException e4) {
            zzo.d("", e4);
            strZzi = null;
        }
        zzaVar.f21698e = strZzi;
        try {
            strZzj = zzblsVar.zzj();
        } catch (RemoteException e5) {
            zzo.d("", e5);
            strZzj = null;
        }
        zzaVar.f21699f = strZzj;
        try {
            dZzk = zzblsVar.zzk();
        } catch (RemoteException e6) {
            zzo.d("", e6);
        }
        Double dValueOf = dZzk == -1.0d ? null : Double.valueOf(dZzk);
        zzaVar.f21700g = dValueOf;
        try {
            strZzl = zzblsVar.zzl();
        } catch (RemoteException e7) {
            zzo.d("", e7);
            strZzl = null;
        }
        zzaVar.f21701h = strZzl;
        try {
            strZzm = zzblsVar.zzm();
        } catch (RemoteException e8) {
            zzo.d("", e8);
            strZzm = null;
        }
        zzaVar.f21702i = strZzm;
        try {
            IObjectWrapper iObjectWrapperH = zzblsVar.h();
            if (iObjectWrapperH != null) {
                objZ0 = ObjectWrapper.z0(iObjectWrapperH);
            }
        } catch (RemoteException e9) {
            zzo.d("", e9);
        }
        zzaVar.f21704k = objZ0;
        zzaVar.f21706m = true;
        zzaVar.n = true;
        VideoController videoController = zzbltVar.f25302d;
        try {
            if (zzblsVar.zzn() != null) {
                videoController.a(zzblsVar.zzn());
            }
        } catch (RemoteException e10) {
            zzo.d("Exception occurred while getting video controller", e10);
        }
        zzaVar.f21703j = videoController;
        this.f20506b.r(this.f20505a, zzaVar);
    }

    @Override // com.google.android.gms.ads.formats.zzd
    public final void c(zzbkt zzbktVar, String str) {
        this.f20506b.o(zzbktVar, str);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void f() {
        this.f20506b.k();
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void g(LoadAdError loadAdError) {
        this.f20506b.j(loadAdError);
    }

    @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
    public final void h() {
        this.f20506b.q();
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void j() {
        this.f20506b.e();
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void m() {
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void t() {
        this.f20506b.g();
    }
}
