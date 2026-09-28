package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import com.facebook.common.internal.Supplier;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.TimeUnit;

@Nullsafe
/* loaded from: classes3.dex */
public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {

    /* renamed from: b, reason: collision with root package name */
    public static final long f17745b = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: a, reason: collision with root package name */
    public final ActivityManager f17746a;

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager activityManager) {
        this.f17746a = activityManager;
    }

    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        int iMin = Math.min(this.f17746a.getMemoryClass() * 1048576, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return new MemoryCacheParams(iMin < 33554432 ? 4194304 : iMin < 67108864 ? 6291456 : iMin / 4, 256, Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, f17745b);
    }
}
