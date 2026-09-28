package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzfwa {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f31965a;

    /* renamed from: b, reason: collision with root package name */
    public int f31966b;

    /* renamed from: c, reason: collision with root package name */
    public int f31967c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfwb f31968d;

    public /* synthetic */ zzfwa(zzfwb zzfwbVar, byte[] bArr) {
        Objects.requireNonNull(zzfwbVar);
        this.f31968d = zzfwbVar;
        this.f31965a = bArr;
    }

    public final synchronized void a() {
        try {
            zzfwb zzfwbVar = this.f31968d;
            if (zzfwbVar.f31970b) {
                zzfwe zzfweVar = zzfwbVar.f31969a;
                zzfweVar.r4(this.f31965a);
                zzfweVar.zzh(this.f31966b);
                zzfweVar.zzi(this.f31967c);
                zzfweVar.F5();
                zzfweVar.zze();
            }
        } catch (RemoteException e2) {
            Log.d("GASS", "Clearcut log failed", e2);
        }
    }
}
