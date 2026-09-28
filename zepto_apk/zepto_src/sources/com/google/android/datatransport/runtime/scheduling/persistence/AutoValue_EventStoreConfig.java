package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

/* loaded from: classes.dex */
final class AutoValue_EventStoreConfig extends EventStoreConfig {

    /* renamed from: b, reason: collision with root package name */
    public final long f20919b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20920c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20921d;

    /* renamed from: e, reason: collision with root package name */
    public final long f20922e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20923f;

    public static final class Builder extends EventStoreConfig.Builder {

        /* renamed from: a, reason: collision with root package name */
        public Long f20924a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f20925b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f20926c;

        /* renamed from: d, reason: collision with root package name */
        public Long f20927d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f20928e;
    }

    public AutoValue_EventStoreConfig(int i2, int i3, int i4, long j2, long j3) {
        this.f20919b = j2;
        this.f20920c = i2;
        this.f20921d = i3;
        this.f20922e = j3;
        this.f20923f = i4;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public final int a() {
        return this.f20921d;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public final long b() {
        return this.f20922e;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public final int c() {
        return this.f20920c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public final int d() {
        return this.f20923f;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public final long e() {
        return this.f20919b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
        return this.f20919b == eventStoreConfig.e() && this.f20920c == eventStoreConfig.c() && this.f20921d == eventStoreConfig.a() && this.f20922e == eventStoreConfig.b() && this.f20923f == eventStoreConfig.d();
    }

    public final int hashCode() {
        long j2 = this.f20919b;
        int i2 = (((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f20920c) * 1000003) ^ this.f20921d) * 1000003;
        long j3 = this.f20922e;
        return ((i2 ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f20923f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.f20919b);
        sb.append(", loadBatchSize=");
        sb.append(this.f20920c);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.f20921d);
        sb.append(", eventCleanUpAge=");
        sb.append(this.f20922e);
        sb.append(", maxBlobByteSizePerRow=");
        return android.support.v4.media.b.o(sb, this.f20923f, "}");
    }
}
