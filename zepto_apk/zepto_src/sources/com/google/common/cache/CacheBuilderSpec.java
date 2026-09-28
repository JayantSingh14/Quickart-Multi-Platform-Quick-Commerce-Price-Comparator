package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public final class CacheBuilderSpec {

    /* renamed from: com.google.common.cache.CacheBuilderSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42340a;

        static {
            int[] iArr = new int[LocalCache.Strength.values().length];
            f42340a = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42340a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class AccessDurationParser extends DurationParser {
    }

    public static class ConcurrencyLevelParser extends IntegerParser {
    }

    public static abstract class DurationParser implements ValueParser {
    }

    public static class InitialCapacityParser extends IntegerParser {
    }

    public static abstract class IntegerParser implements ValueParser {
    }

    public static class KeyStrengthParser implements ValueParser {
    }

    public static abstract class LongParser implements ValueParser {
    }

    public static class MaximumSizeParser extends LongParser {
    }

    public static class MaximumWeightParser extends LongParser {
    }

    public static class RecordStatsParser implements ValueParser {
    }

    public static class RefreshDurationParser extends DurationParser {
    }

    public interface ValueParser {
    }

    public static class ValueStrengthParser implements ValueParser {
    }

    public static class WriteDurationParser extends DurationParser {
    }

    static {
        Splitter.a(',').d();
        Splitter.a('=').d();
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        builder.c("initialCapacity", new InitialCapacityParser());
        builder.c("maximumSize", new MaximumSizeParser());
        builder.c("maximumWeight", new MaximumWeightParser());
        builder.c("concurrencyLevel", new ConcurrencyLevelParser());
        builder.c("weakKeys", new KeyStrengthParser());
        builder.c("softValues", new ValueStrengthParser());
        builder.c("weakValues", new ValueStrengthParser());
        builder.c("recordStats", new RecordStatsParser());
        builder.c("expireAfterAccess", new AccessDurationParser());
        builder.c("expireAfterWrite", new WriteDurationParser());
        builder.c("refreshAfterWrite", new RefreshDurationParser());
        builder.c("refreshInterval", new RefreshDurationParser());
        builder.a(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        ((CacheBuilderSpec) obj).getClass();
        return Objects.a(null, null) && Objects.a(null, null) && Objects.a(null, null) && Objects.a(null, null) && Objects.a(null, null) && Objects.a(null, null) && Objects.a(null, null) && Objects.a(null, null) && Objects.a(null, null) && Objects.a(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{null, null, null, null, null, null, null, null, null, null});
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperB = MoreObjects.b(this);
        toStringHelperB.c(null);
        return toStringHelperB.toString();
    }
}
