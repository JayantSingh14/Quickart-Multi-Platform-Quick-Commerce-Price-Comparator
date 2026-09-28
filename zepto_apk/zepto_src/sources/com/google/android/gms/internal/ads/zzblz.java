package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzblz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdManagerAdView f25309a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzbx f25310b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbma f25311c;

    public zzblz(zzbma zzbmaVar, AdManagerAdView adManagerAdView, com.google.android.gms.ads.internal.client.zzbx zzbxVar) {
        this.f25309a = adManagerAdView;
        this.f25310b = zzbxVar;
        Objects.requireNonNull(zzbmaVar);
        this.f25311c = zzbmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.client.zzbx zzbxVar = this.f25310b;
        com.google.android.gms.ads.internal.client.zzen zzenVar = this.f25309a.f21016a;
        zzenVar.getClass();
        try {
            IObjectWrapper iObjectWrapperZzb = zzbxVar.zzb();
            if (iObjectWrapperZzb != null && ((View) ObjectWrapper.z0(iObjectWrapperZzb)).getParent() == null) {
                zzenVar.f21207l.addView((View) ObjectWrapper.z0(iObjectWrapperZzb));
                zzenVar.f21204i = zzbxVar;
                this.f25311c.getClass();
                throw null;
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
        com.google.android.gms.ads.internal.util.client.zzo.f("Could not bind.");
    }
}
