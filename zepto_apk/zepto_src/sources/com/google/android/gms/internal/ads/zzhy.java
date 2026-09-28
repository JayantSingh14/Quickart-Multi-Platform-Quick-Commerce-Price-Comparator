package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzhy implements zzhb {

    /* renamed from: a, reason: collision with root package name */
    public final zzhb f34492a;

    /* renamed from: b, reason: collision with root package name */
    public Uri f34493b = Uri.EMPTY;

    /* renamed from: c, reason: collision with root package name */
    public Map f34494c = Collections.EMPTY_MAP;

    public zzhy(zzhb zzhbVar) {
        this.f34492a = zzhbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) {
        zzhb zzhbVar = this.f34492a;
        this.f34493b = zzhfVar.f33691a;
        this.f34494c = Collections.EMPTY_MAP;
        try {
            long jA = zzhbVar.a(zzhfVar);
            Uri uriZzc = zzhbVar.zzc();
            if (uriZzc != null) {
                this.f34493b = uriZzc;
            }
            this.f34494c = zzhbVar.zzj();
            return jA;
        } catch (Throwable th) {
            Uri uriZzc2 = zzhbVar.zzc();
            if (uriZzc2 != null) {
                this.f34493b = uriZzc2;
            }
            this.f34494c = zzhbVar.zzj();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) {
        return this.f34492a.b(i2, bArr, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void c(zzhz zzhzVar) {
        zzhzVar.getClass();
        this.f34492a.c(zzhzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        return this.f34492a.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        this.f34492a.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhu
    public final Map zzj() {
        return this.f34492a.zzj();
    }
}
