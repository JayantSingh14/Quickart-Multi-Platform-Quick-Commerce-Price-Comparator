package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.time.DateUtils;

@AutoValue
/* loaded from: classes.dex */
public abstract class SchedulerConfig {

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Clock f20869a;

        /* renamed from: b, reason: collision with root package name */
        public HashMap f20870b = new HashMap();
    }

    @AutoValue
    public static abstract class ConfigValue {

        @AutoValue.Builder
        public static abstract class Builder {
        }

        public abstract long a();

        public abstract Set b();

        public abstract long c();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Flag {

        /* renamed from: a, reason: collision with root package name */
        public static final Flag f20871a;

        /* renamed from: b, reason: collision with root package name */
        public static final Flag f20872b;

        /* renamed from: c, reason: collision with root package name */
        public static final Flag f20873c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ Flag[] f20874d;

        static {
            Flag flag = new Flag("NETWORK_UNMETERED", 0);
            f20871a = flag;
            Flag flag2 = new Flag("DEVICE_IDLE", 1);
            f20872b = flag2;
            Flag flag3 = new Flag("DEVICE_CHARGING", 2);
            f20873c = flag3;
            f20874d = new Flag[]{flag, flag2, flag3};
        }

        public static Flag valueOf(String str) {
            return (Flag) Enum.valueOf(Flag.class, str);
        }

        public static Flag[] values() {
            return (Flag[]) f20874d.clone();
        }
    }

    public static SchedulerConfig b(Clock clock) {
        Builder builder = new Builder();
        Priority priority = Priority.f20514a;
        AutoValue_SchedulerConfig_ConfigValue.Builder builder2 = new AutoValue_SchedulerConfig_ConfigValue.Builder();
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        builder2.f20864c = set;
        builder2.f20862a = 30000L;
        builder2.f20863b = Long.valueOf(DateUtils.MILLIS_PER_DAY);
        builder.f20870b.put(priority, builder2.a());
        Priority priority2 = Priority.f20516c;
        AutoValue_SchedulerConfig_ConfigValue.Builder builder3 = new AutoValue_SchedulerConfig_ConfigValue.Builder();
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        builder3.f20864c = set;
        builder3.f20862a = 1000L;
        builder3.f20863b = Long.valueOf(DateUtils.MILLIS_PER_DAY);
        builder.f20870b.put(priority2, builder3.a());
        Priority priority3 = Priority.f20515b;
        AutoValue_SchedulerConfig_ConfigValue.Builder builder4 = new AutoValue_SchedulerConfig_ConfigValue.Builder();
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        builder4.f20864c = set;
        builder4.f20862a = Long.valueOf(DateUtils.MILLIS_PER_DAY);
        builder4.f20863b = Long.valueOf(DateUtils.MILLIS_PER_DAY);
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(Flag.f20872b)));
        if (setUnmodifiableSet == null) {
            throw new NullPointerException("Null flags");
        }
        builder4.f20864c = setUnmodifiableSet;
        builder.f20870b.put(priority3, builder4.a());
        builder.f20869a = clock;
        if (clock == null) {
            throw new NullPointerException("missing required property: clock");
        }
        if (builder.f20870b.keySet().size() < Priority.values().length) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        HashMap map = builder.f20870b;
        builder.f20870b = new HashMap();
        return new AutoValue_SchedulerConfig(builder.f20869a, map);
    }

    public abstract Clock a();

    public final long c(Priority priority, long j2, int i2) {
        long jA = j2 - a().a();
        ConfigValue configValue = (ConfigValue) d().get(priority);
        long jA2 = configValue.a();
        return Math.min(Math.max((long) (Math.pow(3.0d, i2 - 1) * jA2 * Math.max(1.0d, Math.log(10000.0d) / Math.log((jA2 > 1 ? jA2 : 2L) * r12))), jA), configValue.c());
    }

    public abstract Map d();
}
