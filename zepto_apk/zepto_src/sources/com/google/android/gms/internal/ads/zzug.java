package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public interface zzug {
    ByteBuffer A(int i2);

    void a0(int i2);

    void b0(int i2, long j2);

    void c0(Bundle bundle);

    void d0(Surface surface);

    int e0(MediaCodec.BufferInfo bufferInfo);

    void f0(int i2, zzie zzieVar, long j2, int i3);

    default void g0(Runnable runnable) {
        ((zzun) runnable).run();
    }

    void h0(int i2, int i3, long j2, int i4);

    default boolean i0(zzuf zzufVar) {
        return false;
    }

    void l(int i2);

    int zze();

    MediaFormat zzg();

    ByteBuffer zzh(int i2);

    void zzk();

    void zzl();

    void zzo();
}
