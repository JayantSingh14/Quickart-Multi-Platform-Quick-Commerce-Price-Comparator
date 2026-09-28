package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
public final class zzgz extends zzgt {

    /* renamed from: e, reason: collision with root package name */
    public zzhf f33389e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f33390f;

    /* renamed from: g, reason: collision with root package name */
    public int f33391g;

    /* renamed from: h, reason: collision with root package name */
    public int f33392h;

    public zzgz() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) throws zzhc, zzat {
        d(zzhfVar);
        this.f33389e = zzhfVar;
        Uri uriNormalizeScheme = zzhfVar.f33691a.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        zzgqa.e("data".equals(scheme), "Unsupported scheme: %s", scheme);
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        String str = zzfj.f31254a;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw new zzat("Unexpected URI format: ".concat(String.valueOf(uriNormalizeScheme)), null, true, 0);
        }
        String str2 = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.f33390f = Base64.decode(str2, 0);
            } catch (IllegalArgumentException e2) {
                throw new zzat("Error while parsing Base64 encoded string: ".concat(String.valueOf(str2)), e2, true, 0);
            }
        } else {
            this.f33390f = URLDecoder.decode(str2, StandardCharsets.US_ASCII.name()).getBytes(StandardCharsets.UTF_8);
        }
        int length = this.f33390f.length;
        long j2 = length;
        long j3 = zzhfVar.f33693c;
        if (j3 > j2) {
            this.f33390f = null;
            throw new zzhc();
        }
        int i2 = (int) j3;
        this.f33391g = i2;
        int i3 = length - i2;
        this.f33392h = i3;
        long j4 = zzhfVar.f33694d;
        if (j4 != -1) {
            this.f33392h = (int) Math.min(i3, j4);
        }
        e(zzhfVar);
        return j4 != -1 ? j4 : this.f33392h;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f33392h;
        if (i4 == 0) {
            return -1;
        }
        int iMin = Math.min(i3, i4);
        byte[] bArr2 = this.f33390f;
        String str = zzfj.f31254a;
        System.arraycopy(bArr2, this.f33391g, bArr, i2, iMin);
        this.f33391g += iMin;
        this.f33392h -= iMin;
        f(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        zzhf zzhfVar = this.f33389e;
        if (zzhfVar != null) {
            return zzhfVar.f33691a;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        if (this.f33390f != null) {
            this.f33390f = null;
            g();
        }
        this.f33389e = null;
    }
}
