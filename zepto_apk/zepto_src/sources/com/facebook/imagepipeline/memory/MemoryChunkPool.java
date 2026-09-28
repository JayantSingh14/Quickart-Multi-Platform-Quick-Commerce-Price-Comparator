package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes.dex */
public abstract class MemoryChunkPool extends BasePool<MemoryChunk> {

    /* renamed from: j, reason: collision with root package name */
    public final int[] f18026j;

    public MemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray sparseIntArray = poolParams.f18059c;
        sparseIntArray.getClass();
        this.f18026j = new int[sparseIntArray.size()];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f18026j;
            if (i2 >= iArr.length) {
                this.f17983b.getClass();
                this.f17990i.getClass();
                return;
            } else {
                iArr[i2] = sparseIntArray.keyAt(i2);
                i2++;
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final void g(Object obj) {
        MemoryChunk memoryChunk = (MemoryChunk) obj;
        memoryChunk.getClass();
        memoryChunk.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int i(int i2) {
        if (i2 <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i2));
        }
        for (int i3 : this.f18026j) {
            if (i3 >= i2) {
                return i3;
            }
        }
        return i2;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int j(Object obj) {
        MemoryChunk memoryChunk = (MemoryChunk) obj;
        memoryChunk.getClass();
        return memoryChunk.getSize();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final int k(int i2) {
        return i2;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public final boolean n(Object obj) {
        ((MemoryChunk) obj).getClass();
        return !r1.isClosed();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public abstract MemoryChunk e(int i2);
}
