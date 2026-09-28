package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.time.Clock;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class AutoValue_SchedulerConfig extends SchedulerConfig {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f20857a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f20858b;

    public AutoValue_SchedulerConfig(Clock clock, HashMap map) {
        if (clock == null) {
            throw new NullPointerException("Null clock");
        }
        this.f20857a = clock;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f20858b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public final Clock a() {
        return this.f20857a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public final Map d() {
        return this.f20858b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.f20857a.equals(schedulerConfig.a()) && this.f20858b.equals(schedulerConfig.d());
    }

    public final int hashCode() {
        return ((this.f20857a.hashCode() ^ 1000003) * 1000003) ^ this.f20858b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f20857a + ", values=" + this.f20858b + "}";
    }
}
