package io.ktor.utils.io.streams;

import android.support.v4.media.b;
import io.ktor.utils.io.pool.DefaultPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ByteArraysKt$ByteArrayPool$1 extends DefaultPool<byte[]> {
    @Override // io.ktor.utils.io.pool.DefaultPool
    public final Object l() {
        return new byte[4096];
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void s(Object obj) {
        byte[] instance = (byte[]) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (instance.length != 4096) {
            throw new IllegalArgumentException(b.o(new StringBuilder("Unable to recycle buffer of wrong size: "), instance.length, " != 4096").toString());
        }
        Intrinsics.checkNotNullParameter(instance, "instance");
    }
}
