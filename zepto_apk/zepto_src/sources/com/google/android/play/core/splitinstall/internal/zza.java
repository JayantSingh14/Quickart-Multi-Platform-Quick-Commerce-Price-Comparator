package com.google.android.play.core.splitinstall.internal;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
final class zza implements zzb {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f41935a;

    public zza(ByteBuffer byteBuffer) {
        this.f41935a = byteBuffer.slice();
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzb
    public final long zza() {
        return this.f41935a.capacity();
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzb
    public final void zzb(MessageDigest[] messageDigestArr, long j2, int i2) {
        ByteBuffer byteBufferSlice;
        synchronized (this.f41935a) {
            int i3 = (int) j2;
            this.f41935a.position(i3);
            this.f41935a.limit(i3 + i2);
            byteBufferSlice = this.f41935a.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            byteBufferSlice.position(0);
            messageDigest.update(byteBufferSlice);
        }
    }
}
