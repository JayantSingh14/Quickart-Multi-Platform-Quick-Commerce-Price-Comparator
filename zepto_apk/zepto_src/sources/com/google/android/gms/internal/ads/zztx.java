package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
final class zztx extends zzih {

    /* renamed from: i, reason: collision with root package name */
    public long f35630i;

    /* renamed from: j, reason: collision with root package name */
    public int f35631j;

    /* renamed from: k, reason: collision with root package name */
    public int f35632k;

    public zztx() {
        super(2);
        this.f35632k = 32;
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void c() {
        super.c();
        this.f35631j = 0;
    }

    public final int h() {
        return this.f35631j;
    }

    public final boolean i() {
        return this.f35631j > 0;
    }

    public final boolean j(zzih zzihVar) {
        ByteBuffer byteBuffer;
        zzgqa.a(!zzihVar.b(1073741824));
        zzgqa.a(!zzihVar.b(268435456));
        zzgqa.a(!zzihVar.b(4));
        if (i()) {
            if (this.f35631j >= this.f35632k) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzihVar.f34829d;
            if (byteBuffer2 != null && (byteBuffer = this.f34829d) != null) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i2 = this.f35631j;
        this.f35631j = i2 + 1;
        if (i2 == 0) {
            this.f34831f = zzihVar.f34831f;
            if (zzihVar.b(1)) {
                this.f34703a = 1;
            }
        }
        ByteBuffer byteBuffer3 = zzihVar.f34829d;
        if (byteBuffer3 != null) {
            d(byteBuffer3.remaining());
            this.f34829d.put(byteBuffer3);
        }
        this.f35630i = zzihVar.f34831f;
        return true;
    }
}
