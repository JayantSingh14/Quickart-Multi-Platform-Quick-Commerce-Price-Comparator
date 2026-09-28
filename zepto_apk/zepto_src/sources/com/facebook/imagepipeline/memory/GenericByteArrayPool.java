package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ThreadSafe
@Metadata
/* loaded from: classes.dex */
public class GenericByteArrayPool extends BasePool<byte[]> implements ByteArrayPool {

    /* renamed from: j, reason: collision with root package name */
    public final int[] f18019j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericByteArrayPool(NoOpMemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, NoOpPoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        Intrinsics.checkNotNullParameter(memoryTrimmableRegistry, "memoryTrimmableRegistry");
        Intrinsics.checkNotNullParameter(poolParams, "poolParams");
        Intrinsics.checkNotNullParameter(poolStatsTracker, "poolStatsTracker");
        SparseIntArray sparseIntArray = poolParams.f18059c;
        if (sparseIntArray != null) {
            this.f18019j = new int[sparseIntArray.size()];
            int size = sparseIntArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f18019j[i2] = sparseIntArray.keyAt(i2);
            }
        } else {
            this.f18019j = new int[0];
        }
        this.f17983b.getClass();
        this.f17990i.getClass();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final Object e(int i2) {
        return new byte[i2];
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final void g(Object obj) {
        byte[] value = (byte[]) obj;
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int i(int i2) {
        if (i2 <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i2));
        }
        for (int i3 : this.f18019j) {
            if (i3 >= i2) {
                return i3;
            }
        }
        return i2;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int j(Object obj) {
        byte[] value = (byte[]) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        return value.length;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int k(int i2) {
        return i2;
    }
}
