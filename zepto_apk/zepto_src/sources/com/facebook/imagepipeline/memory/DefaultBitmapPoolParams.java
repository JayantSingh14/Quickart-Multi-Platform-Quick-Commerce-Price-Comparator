package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import kotlin.Metadata;
import org.xbill.DNS.TTL;

@Metadata
/* loaded from: classes.dex */
public final class DefaultBitmapPoolParams {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f18016a = new SparseIntArray(0);

    public static final PoolParams a() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), TTL.MAX_VALUE);
        return new PoolParams(0, iMin > 16777216 ? (iMin / 4) * 3 : iMin / 2, f18016a, -1);
    }
}
