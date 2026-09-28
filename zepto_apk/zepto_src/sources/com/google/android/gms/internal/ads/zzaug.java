package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Optional;

/* loaded from: classes4.dex */
public final class zzaug {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f24393a = new ArrayDeque();

    public final void a(long j2, long j3, long j4) {
        int[] iArr = {1857962504, 67802545, 822753858, 1178641841, 1658857550, -1514359837, 393474692, 1520223205, 452867621};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        zzaud zzaudVar = new zzaud(j2, j3, j4);
        ArrayDeque arrayDeque = this.f24393a;
        if (arrayDeque.size() >= (android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8) ^ (i9 % 452867621))) {
            throw new zzaue();
        }
        arrayDeque.push(zzaudVar);
    }

    public final zzaud b() {
        return (zzaud) Optional.ofNullable((zzaud) this.f24393a.peek()).orElseThrow(zzauc.f24387b);
    }
}
