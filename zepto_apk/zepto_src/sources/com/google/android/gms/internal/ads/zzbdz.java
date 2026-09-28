package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzbdz extends AppOpenAd {

    /* renamed from: a, reason: collision with root package name */
    public final zzbed f24820a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbea f24821b = new zzbea();

    public zzbdz(zzbed zzbedVar, String str) {
        new AtomicLong();
        this.f24820a = zzbedVar;
        new AtomicReference(str);
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final ResponseInfo a() {
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzg;
        try {
            zzeaVarZzg = this.f24820a.zzg();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            zzeaVarZzg = null;
        }
        return new ResponseInfo(zzeaVarZzg);
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void c(Activity activity) {
        try {
            this.f24820a.K5(new ObjectWrapper(activity), this.f24821b);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }
}
