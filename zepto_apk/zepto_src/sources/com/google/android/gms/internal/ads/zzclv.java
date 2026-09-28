package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes4.dex */
public final class zzclv implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f26526a;

    public zzclv(zzclp zzclpVar) {
        this.f26526a = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        com.google.android.gms.ads.internal.client.zzfc liteSdkVersion;
        com.google.android.gms.ads.internal.client.zzcy zzcyVar = zzfjg.a(this.f26526a.a()).f31268b;
        if (zzcyVar != null) {
            try {
                liteSdkVersion = zzcyVar.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        } else {
            liteSdkVersion = null;
        }
        if (liteSdkVersion != null) {
            return liteSdkVersion.f21229c;
        }
        return null;
    }
}
