package com.facebook.imagepipeline.platform;

import androidx.core.util.Pools;
import com.facebook.common.memory.DecodeBufferHelper;
import com.facebook.imagepipeline.memory.PoolFactory;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class PlatformDecoderFactory {
    public static final Pools.Pool a(PoolFactory poolFactory) {
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        int i2 = poolFactory.f18049a.f18041c.f18060d;
        Pools.SynchronizedPool synchronizedPool = new Pools.SynchronizedPool(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(DecodeBufferHelper.f17092a);
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
            synchronizedPool.a(byteBufferAllocate);
        }
        return synchronizedPool;
    }
}
