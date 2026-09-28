package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzcao extends RewardedAd {

    /* renamed from: a, reason: collision with root package name */
    public final zzcaf f25788a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f25789b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcax f25790c;

    /* renamed from: d, reason: collision with root package name */
    public final long f25791d;

    public zzcao(Context context, String str) {
        zzcaf zzcafVarF = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21143b.f(context, str, new zzbsv());
        this.f25791d = System.currentTimeMillis();
        new AtomicLong();
        this.f25789b = context.getApplicationContext();
        new AtomicReference(str);
        this.f25788a = zzcafVarF;
        this.f25790c = new zzcax();
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final ResponseInfo a() {
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzm = null;
        try {
            zzcaf zzcafVar = this.f25788a;
            if (zzcafVar != null) {
                zzeaVarZzm = zzcafVar.zzm();
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
        return new ResponseInfo(zzeaVarZzm);
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void c(Activity activity) {
        zzebg zzebgVar = zzebg.f28997a;
        zzcax zzcaxVar = this.f25790c;
        zzcaxVar.f25799a = zzebgVar;
        try {
            zzcaf zzcafVar = this.f25788a;
            if (zzcafVar != null) {
                zzcafVar.q5(zzcaxVar);
                zzcafVar.N(new ObjectWrapper(activity));
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    public final void d(com.google.android.gms.ads.internal.client.zzek zzekVar, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            zzcaf zzcafVar = this.f25788a;
            if (zzcafVar != null) {
                zzekVar.n = this.f25791d;
                zzcafVar.I5(com.google.android.gms.ads.internal.client.zzq.a(this.f25789b, zzekVar), new zzcas(rewardedAdLoadCallback, this));
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }
}
