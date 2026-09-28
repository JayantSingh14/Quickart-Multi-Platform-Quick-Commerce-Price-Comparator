package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class CacheBuilder<K, V> {

    /* renamed from: c, reason: collision with root package name */
    public static final Supplier f42332c = Suppliers.b(new AnonymousClass1());

    /* renamed from: d, reason: collision with root package name */
    public static final Ticker f42333d = new AnonymousClass3();

    /* renamed from: a, reason: collision with root package name */
    public LocalCache.Strength.AnonymousClass3 f42334a;

    /* renamed from: b, reason: collision with root package name */
    public Supplier f42335b;

    /* renamed from: com.google.common.cache.CacheBuilder$2, reason: invalid class name */
    public class AnonymousClass2 implements Supplier<AbstractCache.StatsCounter> {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new AbstractCache.SimpleStatsCounter();
        }
    }

    /* renamed from: com.google.common.cache.CacheBuilder$3, reason: invalid class name */
    public class AnonymousClass3 extends Ticker {
        @Override // com.google.common.base.Ticker
        public final long a() {
            return 0L;
        }
    }

    public static final class LoggerHolder {
        static {
            Logger.getLogger(CacheBuilder.class.getName());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class NullListener implements RemovalListener<Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final NullListener f42336a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ NullListener[] f42337b;

        static {
            NullListener nullListener = new NullListener("INSTANCE", 0);
            f42336a = nullListener;
            f42337b = new NullListener[]{nullListener};
        }

        public static NullListener valueOf(String str) {
            return (NullListener) Enum.valueOf(NullListener.class, str);
        }

        public static NullListener[] values() {
            return (NullListener[]) f42337b.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class OneWeigher implements Weigher<Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final OneWeigher f42338a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ OneWeigher[] f42339b;

        static {
            OneWeigher oneWeigher = new OneWeigher("INSTANCE", 0);
            f42338a = oneWeigher;
            f42339b = new OneWeigher[]{oneWeigher};
        }

        public static OneWeigher valueOf(String str) {
            return (OneWeigher) Enum.valueOf(OneWeigher.class, str);
        }

        public static OneWeigher[] values() {
            return (OneWeigher[]) f42339b.clone();
        }
    }

    public static CacheBuilder b() {
        CacheBuilder cacheBuilder = new CacheBuilder();
        cacheBuilder.f42335b = f42332c;
        return cacheBuilder;
    }

    public final LoadingCache a(CacheLoader cacheLoader) {
        return new LocalCache.LocalLoadingCache(new LocalCache(this, cacheLoader));
    }

    public final void c() {
        LocalCache.Strength.AnonymousClass3 anonymousClass3 = LocalCache.Strength.f42393b;
        LocalCache.Strength.AnonymousClass3 anonymousClass32 = this.f42334a;
        Preconditions.o(anonymousClass32 == null, "Key strength was already set to %s", anonymousClass32);
        this.f42334a = anonymousClass3;
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperB = MoreObjects.b(this);
        LocalCache.Strength.AnonymousClass3 anonymousClass3 = this.f42334a;
        if (anonymousClass3 != null) {
            toStringHelperB.a(Ascii.b(anonymousClass3.toString()), "keyStrength");
        }
        return toStringHelperB.toString();
    }

    /* renamed from: com.google.common.cache.CacheBuilder$1, reason: invalid class name */
    public class AnonymousClass1 implements AbstractCache.StatsCounter {
        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public final void b() {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public final void c(long j2) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public final void d(long j2) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public final void a() {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public final void e() {
        }
    }
}
