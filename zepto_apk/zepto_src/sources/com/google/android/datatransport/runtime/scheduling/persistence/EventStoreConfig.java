package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
abstract class EventStoreConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final AutoValue_EventStoreConfig f20932a;

    @AutoValue.Builder
    public static abstract class Builder {
    }

    static {
        AutoValue_EventStoreConfig.Builder builder = new AutoValue_EventStoreConfig.Builder();
        builder.f20924a = 10485760L;
        builder.f20925b = 200;
        builder.f20926c = 10000;
        builder.f20927d = 604800000L;
        builder.f20928e = 81920;
        String strK = builder.f20924a == null ? " maxStorageSizeInBytes" : "";
        if (builder.f20925b == null) {
            strK = strK.concat(" loadBatchSize");
        }
        if (builder.f20926c == null) {
            strK = android.support.v4.media.b.k(strK, " criticalSectionEnterTimeoutMs");
        }
        if (builder.f20927d == null) {
            strK = android.support.v4.media.b.k(strK, " eventCleanUpAge");
        }
        if (builder.f20928e == null) {
            strK = android.support.v4.media.b.k(strK, " maxBlobByteSizePerRow");
        }
        if (!strK.isEmpty()) {
            throw new IllegalStateException("Missing required properties:".concat(strK));
        }
        f20932a = new AutoValue_EventStoreConfig(builder.f20925b.intValue(), builder.f20926c.intValue(), builder.f20928e.intValue(), builder.f20924a.longValue(), builder.f20927d.longValue());
    }

    public abstract int a();

    public abstract long b();

    public abstract int c();

    public abstract int d();

    public abstract long e();
}
