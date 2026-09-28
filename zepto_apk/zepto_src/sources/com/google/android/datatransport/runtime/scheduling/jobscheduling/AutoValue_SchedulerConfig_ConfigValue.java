package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* loaded from: classes.dex */
final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.ConfigValue {

    /* renamed from: a, reason: collision with root package name */
    public final long f20859a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20860b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f20861c;

    public static final class Builder extends SchedulerConfig.ConfigValue.Builder {

        /* renamed from: a, reason: collision with root package name */
        public Long f20862a;

        /* renamed from: b, reason: collision with root package name */
        public Long f20863b;

        /* renamed from: c, reason: collision with root package name */
        public Set f20864c;

        public final SchedulerConfig.ConfigValue a() {
            String strK = this.f20862a == null ? " delta" : "";
            if (this.f20863b == null) {
                strK = strK.concat(" maxAllowedDelay");
            }
            if (this.f20864c == null) {
                strK = android.support.v4.media.b.k(strK, " flags");
            }
            if (strK.isEmpty()) {
                return new AutoValue_SchedulerConfig_ConfigValue(this.f20862a.longValue(), this.f20863b.longValue(), this.f20864c);
            }
            throw new IllegalStateException("Missing required properties:".concat(strK));
        }
    }

    public AutoValue_SchedulerConfig_ConfigValue(long j2, long j3, Set set) {
        this.f20859a = j2;
        this.f20860b = j3;
        this.f20861c = set;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public final long a() {
        return this.f20859a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public final Set b() {
        return this.f20861c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public final long c() {
        return this.f20860b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
        return this.f20859a == configValue.a() && this.f20860b == configValue.c() && this.f20861c.equals(configValue.b());
    }

    public final int hashCode() {
        long j2 = this.f20859a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        long j3 = this.f20860b;
        return ((i2 ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f20861c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f20859a + ", maxAllowedDelay=" + this.f20860b + ", flags=" + this.f20861c + "}";
    }
}
