package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.TimeUnit;
import org.xbill.DNS.TTL;

@Nullsafe
/* loaded from: classes.dex */
public class DefaultEncodedMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {

    /* renamed from: a, reason: collision with root package name */
    public static final long f17748a = TimeUnit.MINUTES.toMillis(5);

    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), TTL.MAX_VALUE);
        int i2 = iMin < 16777216 ? 1048576 : iMin < 33554432 ? 2097152 : 4194304;
        return new MemoryCacheParams(i2, Api.BaseClientBuilder.API_PRIORITY_OTHER, i2, i2 / 8, f17748a);
    }
}
