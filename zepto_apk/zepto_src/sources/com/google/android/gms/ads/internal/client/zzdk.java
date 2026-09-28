package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* loaded from: classes4.dex */
public final class zzdk implements MuteThisAdReason {

    /* renamed from: a, reason: collision with root package name */
    public final String f21159a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdj f21160b;

    public zzdk(zzdj zzdjVar) {
        String strZze;
        this.f21160b = zzdjVar;
        try {
            strZze = zzdjVar.zze();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            strZze = null;
        }
        this.f21159a = strZze;
    }

    public final String toString() {
        return this.f21159a;
    }
}
