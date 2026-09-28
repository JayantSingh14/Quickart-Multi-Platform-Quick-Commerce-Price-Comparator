package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzsh extends zzcp {

    /* renamed from: i, reason: collision with root package name */
    public int[] f35507i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f35508j;

    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ed  */
    @Override // com.google.android.gms.internal.ads.zzco
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.nio.ByteBuffer r17) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsh.b(java.nio.ByteBuffer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcl e(zzcl zzclVar) throws zzcn {
        int[] iArr = this.f35507i;
        if (iArr == null) {
            return zzcl.f26484e;
        }
        int i2 = zzclVar.f26487c;
        if (!zzfj.a(i2)) {
            throw new zzcn("Unhandled input format:", zzclVar);
        }
        int length = iArr.length;
        int i3 = zzclVar.f26486b;
        boolean z = i3 != length;
        int i4 = 0;
        while (true) {
            int length2 = iArr.length;
            if (i4 >= length2) {
                return z ? new zzcl(zzclVar.f26485a, length2, i2) : zzcl.f26484e;
            }
            int i5 = iArr[i4];
            if (i5 >= i3) {
                String string = Arrays.toString(iArr);
                throw new zzcn(android.support.v4.media.b.s(new StringBuilder(String.valueOf(string).length() + 59), "Channel map (", string, ") trying to access non-existent input channel."), zzclVar);
            }
            z |= i5 != i4;
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void g() {
        this.f35508j = this.f35507i;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void h() {
        this.f35508j = null;
        this.f35507i = null;
    }
}
