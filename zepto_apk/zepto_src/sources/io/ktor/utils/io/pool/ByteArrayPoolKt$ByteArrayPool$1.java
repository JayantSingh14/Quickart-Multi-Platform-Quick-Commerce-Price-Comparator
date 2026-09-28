package io.ktor.utils.io.pool;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ByteArrayPoolKt$ByteArrayPool$1 extends DefaultPool<byte[]> {
    @Override // io.ktor.utils.io.pool.DefaultPool
    public final Object l() {
        return new byte[4096];
    }
}
