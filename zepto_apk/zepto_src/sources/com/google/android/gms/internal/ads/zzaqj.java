package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
final class zzaqj implements zzaqk {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f24162a;

    public zzaqj(ByteBuffer byteBuffer) {
        this.f24162a = byteBuffer.slice();
    }

    @Override // com.google.android.gms.internal.ads.zzaqk
    public final long zza() {
        return this.f24162a.capacity();
    }

    @Override // com.google.android.gms.internal.ads.zzaqk
    public final void zzb(MessageDigest[] messageDigestArr, long j2, int i2) {
        ByteBuffer byteBufferSlice;
        ByteBuffer byteBuffer = this.f24162a;
        synchronized (byteBuffer) {
            int i3 = (int) j2;
            byteBuffer.position(i3);
            byteBuffer.limit(i3 + i2);
            byteBufferSlice = byteBuffer.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            byteBufferSlice.position(0);
            messageDigest.update(byteBufferSlice);
        }
    }
}
