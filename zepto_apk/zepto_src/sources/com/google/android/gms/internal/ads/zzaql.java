package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
final class zzaql implements zzaqk {

    /* renamed from: a, reason: collision with root package name */
    public final FileChannel f24163a;

    /* renamed from: b, reason: collision with root package name */
    public final long f24164b;

    /* renamed from: c, reason: collision with root package name */
    public final long f24165c;

    public zzaql(FileChannel fileChannel, long j2, long j3) {
        this.f24163a = fileChannel;
        this.f24164b = j2;
        this.f24165c = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzaqk
    public final long zza() {
        return this.f24165c;
    }

    @Override // com.google.android.gms.internal.ads.zzaqk
    public final void zzb(MessageDigest[] messageDigestArr, long j2, int i2) throws IOException {
        MappedByteBuffer map = this.f24163a.map(FileChannel.MapMode.READ_ONLY, this.f24164b + j2, i2);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
