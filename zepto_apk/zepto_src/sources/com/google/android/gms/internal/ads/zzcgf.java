package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
final class zzcgf implements zziis {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f26164a;

    public zzcgf(ByteBuffer byteBuffer) {
        this.f26164a = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zziis
    public final int M1(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.f26164a;
        if (byteBuffer2.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), byteBuffer2.remaining());
        byte[] bArr = new byte[iMin];
        byteBuffer2.get(bArr);
        byteBuffer.put(bArr);
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.google.android.gms.internal.ads.zziis
    public final void h(long j2) {
        this.f26164a.position((int) j2);
    }

    @Override // com.google.android.gms.internal.ads.zziis
    public final long zzb() {
        return this.f26164a.limit();
    }

    @Override // com.google.android.gms.internal.ads.zziis
    public final long zzc() {
        return this.f26164a.position();
    }
}
