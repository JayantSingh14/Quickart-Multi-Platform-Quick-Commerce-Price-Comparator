package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
public interface zzco {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f26781a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    default long a(long j2) {
        return j2;
    }

    void b(ByteBuffer byteBuffer);

    zzcl c(zzcl zzclVar);

    boolean zzc();

    void zze();

    ByteBuffer zzf();

    boolean zzg();

    default void zzh() {
        throw new IllegalStateException("AudioProcessor must implement at least one #flush() overload.");
    }

    default void zzi() {
        zzh();
        throw null;
    }

    void zzj();
}
