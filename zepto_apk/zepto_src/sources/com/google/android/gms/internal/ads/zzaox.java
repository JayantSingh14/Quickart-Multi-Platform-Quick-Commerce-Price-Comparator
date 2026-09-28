package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzaox {

    /* renamed from: a, reason: collision with root package name */
    public final int f24013a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f24014b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f24015c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f24016d;

    /* renamed from: e, reason: collision with root package name */
    public int f24017e;

    public zzaox(int i2) {
        this.f24013a = i2;
        byte[] bArr = new byte[WKSRecord.Service.CISCO_TNA];
        this.f24016d = bArr;
        bArr[2] = 1;
    }

    public final void a() {
        this.f24014b = false;
        this.f24015c = false;
    }

    public final void b(int i2) {
        zzgqa.f(!this.f24014b);
        boolean z = i2 == this.f24013a;
        this.f24014b = z;
        if (z) {
            this.f24017e = 3;
            this.f24015c = false;
        }
    }

    public final void c(int i2, byte[] bArr, int i3) {
        if (this.f24014b) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f24016d;
            int length = bArr2.length;
            int i5 = this.f24017e + i4;
            if (length < i5) {
                this.f24016d = Arrays.copyOf(bArr2, i5 + i5);
            }
            System.arraycopy(bArr, i2, this.f24016d, this.f24017e, i4);
            this.f24017e += i4;
        }
    }

    public final boolean d(int i2) {
        if (!this.f24014b) {
            return false;
        }
        this.f24017e -= i2;
        this.f24014b = false;
        this.f24015c = true;
        return true;
    }
}
