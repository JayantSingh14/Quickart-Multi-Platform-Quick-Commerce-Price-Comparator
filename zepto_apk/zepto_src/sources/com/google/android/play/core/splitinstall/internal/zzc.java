package com.google.android.play.core.splitinstall.internal;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
final class zzc implements zzb {

    /* renamed from: a, reason: collision with root package name */
    public final FileChannel f41975a;

    /* renamed from: b, reason: collision with root package name */
    public final long f41976b;

    /* renamed from: c, reason: collision with root package name */
    public final long f41977c;

    public zzc(FileChannel fileChannel, long j2, long j3) {
        this.f41975a = fileChannel;
        this.f41976b = j2;
        this.f41977c = j3;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzb
    public final long zza() {
        return this.f41977c;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzb
    public final void zzb(MessageDigest[] messageDigestArr, long j2, int i2) throws IOException {
        MappedByteBuffer map = this.f41975a.map(FileChannel.MapMode.READ_ONLY, this.f41976b + j2, i2);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
