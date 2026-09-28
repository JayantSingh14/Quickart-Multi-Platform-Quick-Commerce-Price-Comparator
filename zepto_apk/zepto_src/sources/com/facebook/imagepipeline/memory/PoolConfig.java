package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.Immutable;
import org.xbill.DNS.KEYRecord;
import org.xbill.DNS.TTL;

@Nullsafe
@Immutable
/* loaded from: classes.dex */
public class PoolConfig {

    /* renamed from: a, reason: collision with root package name */
    public final PoolParams f18039a;

    /* renamed from: b, reason: collision with root package name */
    public final NoOpPoolStatsTracker f18040b;

    /* renamed from: c, reason: collision with root package name */
    public final PoolParams f18041c;

    /* renamed from: d, reason: collision with root package name */
    public final NoOpMemoryTrimmableRegistry f18042d;

    /* renamed from: e, reason: collision with root package name */
    public final PoolParams f18043e;

    /* renamed from: f, reason: collision with root package name */
    public final NoOpPoolStatsTracker f18044f;

    /* renamed from: g, reason: collision with root package name */
    public final PoolParams f18045g;

    /* renamed from: h, reason: collision with root package name */
    public final NoOpPoolStatsTracker f18046h;

    /* renamed from: i, reason: collision with root package name */
    public final String f18047i;

    /* renamed from: j, reason: collision with root package name */
    public final int f18048j;

    public static final class Builder {
    }

    public PoolConfig(Builder builder) {
        FrescoSystrace.a();
        this.f18039a = DefaultBitmapPoolParams.a();
        this.f18040b = NoOpPoolStatsTracker.a();
        int i2 = DefaultFlexByteArrayPoolParams.f18017a;
        int i3 = i2 * 4194304;
        SparseIntArray sparseIntArray = new SparseIntArray();
        for (int i4 = 131072; i4 <= 4194304; i4 *= 2) {
            sparseIntArray.put(i4, i2);
        }
        this.f18041c = new PoolParams(4194304, i3, sparseIntArray, DefaultFlexByteArrayPoolParams.f18017a);
        this.f18042d = NoOpMemoryTrimmableRegistry.a();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sparseIntArray2.put(1024, 5);
        sparseIntArray2.put(2048, 5);
        sparseIntArray2.put(4096, 5);
        sparseIntArray2.put(KEYRecord.Flags.FLAG2, 5);
        sparseIntArray2.put(16384, 5);
        sparseIntArray2.put(32768, 5);
        sparseIntArray2.put(65536, 5);
        sparseIntArray2.put(131072, 5);
        sparseIntArray2.put(262144, 2);
        sparseIntArray2.put(524288, 2);
        sparseIntArray2.put(1048576, 2);
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), TTL.MAX_VALUE);
        int i5 = iMin < 16777216 ? 3145728 : iMin < 33554432 ? 6291456 : 12582912;
        int iMin2 = (int) Math.min(Runtime.getRuntime().maxMemory(), TTL.MAX_VALUE);
        this.f18043e = new PoolParams(i5, iMin2 < 16777216 ? iMin2 / 2 : (iMin2 / 4) * 3, sparseIntArray2, -1);
        this.f18044f = NoOpPoolStatsTracker.a();
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        sparseIntArray3.put(16384, 5);
        this.f18045g = new PoolParams(81920, 1048576, sparseIntArray3, -1);
        this.f18046h = NoOpPoolStatsTracker.a();
        this.f18047i = "legacy";
        this.f18048j = 4194304;
        FrescoSystrace.a();
    }
}
