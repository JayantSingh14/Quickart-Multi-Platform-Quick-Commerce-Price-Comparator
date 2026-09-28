package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzabs extends zzabv {

    /* renamed from: d, reason: collision with root package name */
    public final int f37361d;

    public zzabs(byte[] bArr, int i2) {
        super(bArr);
        zzaby.p(0, i2, bArr.length);
        this.f37361d = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzabv, com.google.android.gms.internal.pal.zzaby
    public final byte b(int i2) {
        int i3 = this.f37361d;
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return this.f37362c[i2];
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(android.support.v4.media.b.f(i2, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(android.support.v4.media.b.d(i2, i3, "Index > length: ", ", "));
    }

    @Override // com.google.android.gms.internal.pal.zzabv, com.google.android.gms.internal.pal.zzaby
    public final byte d(int i2) {
        return this.f37362c[i2];
    }

    @Override // com.google.android.gms.internal.pal.zzabv, com.google.android.gms.internal.pal.zzaby
    public final int f() {
        return this.f37361d;
    }

    @Override // com.google.android.gms.internal.pal.zzabv, com.google.android.gms.internal.pal.zzaby
    public final void g(int i2, byte[] bArr) {
        System.arraycopy(this.f37362c, 0, bArr, 0, i2);
    }
}
