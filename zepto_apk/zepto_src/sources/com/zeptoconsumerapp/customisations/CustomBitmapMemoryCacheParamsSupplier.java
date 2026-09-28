package com.zeptoconsumerapp.customisations;

import android.app.ActivityManager;
import android.content.Context;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class CustomBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {

    /* renamed from: a, reason: collision with root package name */
    public final ActivityManager f47595a;

    public CustomBitmapMemoryCacheParamsSupplier(Context context) {
        this.f47595a = (ActivityManager) context.getSystemService("activity");
    }

    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        int iMin = Math.min(this.f47595a.getMemoryClass() * 1048576, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return new MemoryCacheParams(iMin < 33554432 ? 4194304 : iMin < 67108864 ? 6291456 : iMin / 8, 256, Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, TimeUnit.MINUTES.toMillis(5L));
    }
}
