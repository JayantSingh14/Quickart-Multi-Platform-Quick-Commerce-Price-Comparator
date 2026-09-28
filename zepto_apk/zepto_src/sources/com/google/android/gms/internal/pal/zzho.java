package com.google.android.gms.internal.pal;

import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes4.dex */
public final class zzho {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f37799a;

    /* renamed from: b, reason: collision with root package name */
    public int f37800b;

    /* renamed from: c, reason: collision with root package name */
    public int f37801c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzhp f37802d;

    public /* synthetic */ zzho(zzhp zzhpVar, byte[] bArr) {
        this.f37802d = zzhpVar;
        this.f37799a = bArr;
    }

    public final synchronized void a() {
        try {
            zzhp zzhpVar = this.f37802d;
            if (zzhpVar.f37804b) {
                zzhpVar.f37803a.zzj(this.f37799a);
                this.f37802d.f37803a.zzi(this.f37800b);
                this.f37802d.f37803a.zzg(this.f37801c);
                this.f37802d.f37803a.zzh();
                this.f37802d.f37803a.zzf();
            }
        } catch (RemoteException e2) {
            Log.d("GASS", "Clearcut log failed", e2);
        }
    }
}
