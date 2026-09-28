package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
class zzck extends zzcj {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f36094c;

    public zzck(byte[] bArr) {
        this.f36096a = 0;
        bArr.getClass();
        this.f36094c = bArr;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcn
    public byte b(int i2) {
        return this.f36094c[i2];
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcn
    public byte d(int i2) {
        return this.f36094c[i2];
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcn
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzcn) && f() == ((zzcn) obj).f()) {
            if (f() == 0) {
                return true;
            }
            if (!(obj instanceof zzck)) {
                return obj.equals(this);
            }
            zzck zzckVar = (zzck) obj;
            int i2 = this.f36096a;
            int i3 = zzckVar.f36096a;
            if (i2 == 0 || i3 == 0 || i2 == i3) {
                int iF = f();
                if (iF > zzckVar.f()) {
                    throw new IllegalArgumentException("Length too large: " + iF + f());
                }
                if (iF > zzckVar.f()) {
                    throw new IllegalArgumentException(b.d(iF, zzckVar.f(), "Ran off end of other: 0, ", ", "));
                }
                int i4 = 0;
                int i5 = 0;
                while (i4 < iF) {
                    if (this.f36094c[i4] == zzckVar.f36094c[i5]) {
                        i4++;
                        i5++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcn
    public int f() {
        return this.f36094c.length;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcn
    public final int g(int i2, int i3) {
        Charset charset = zzdp.f36125a;
        for (int i4 = 0; i4 < i3; i4++) {
            i2 = (i2 * 31) + this.f36094c[i4];
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcn
    public final zzcn i() {
        zzcn.n(f());
        return new zzch(this.f36094c);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcn
    public final String j(Charset charset) {
        return new String(this.f36094c, 0, f(), charset);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcn
    public final void k(zzcd zzcdVar) {
        ((zzcs) zzcdVar).u(f(), this.f36094c);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcn
    public final boolean m() {
        return zzgd.f36218a.a(f(), this.f36094c) == 0;
    }
}
