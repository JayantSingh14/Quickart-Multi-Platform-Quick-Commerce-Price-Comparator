package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbpt;
import com.google.android.gms.internal.ads.zzbsz;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzfm extends zzda {

    /* renamed from: a, reason: collision with root package name */
    public zzbpt f21236a;

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void B0(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void H2(IObjectWrapper iObjectWrapper, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void I2(zzfv zzfvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void Y0(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void d5(zzbsz zzbszVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void g0(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void j() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void o0(float f2) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void ra(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void t2(zzdn zzdnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void u0(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void v2(zzbpt zzbptVar) {
        this.f21236a = zzbptVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zze() {
        com.google.android.gms.ads.internal.util.client.zzo.c("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        com.google.android.gms.ads.internal.util.client.zzf.f21413b.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzfl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzbpt zzbptVar = this.f21235a.f21236a;
                if (zzbptVar != null) {
                    try {
                        zzbptVar.r5(Collections.EMPTY_LIST);
                    } catch (RemoteException e2) {
                        com.google.android.gms.ads.internal.util.client.zzo.g("Could not notify onComplete event.", e2);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final float zzk() {
        return 1.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final boolean zzl() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final String zzm() {
        return "";
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final List zzq() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzs() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void T1(IObjectWrapper iObjectWrapper, String str) {
    }
}
