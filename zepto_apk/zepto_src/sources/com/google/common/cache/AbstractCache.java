package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    public static final class SimpleStatsCounter implements StatsCounter {

        /* renamed from: a, reason: collision with root package name */
        public final LongAddable f42326a = LongAddables.a();

        /* renamed from: b, reason: collision with root package name */
        public final LongAddable f42327b = LongAddables.a();

        /* renamed from: c, reason: collision with root package name */
        public final LongAddable f42328c = LongAddables.a();

        /* renamed from: d, reason: collision with root package name */
        public final LongAddable f42329d = LongAddables.a();

        /* renamed from: e, reason: collision with root package name */
        public final LongAddable f42330e = LongAddables.a();

        /* renamed from: f, reason: collision with root package name */
        public final LongAddable f42331f = LongAddables.a();

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public final void a() {
            this.f42327b.b(1);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public final void b() {
            this.f42331f.a();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public final void c(long j2) {
            this.f42329d.a();
            this.f42330e.b(j2);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public final void d(long j2) {
            this.f42328c.a();
            this.f42330e.b(j2);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public final void e() {
            this.f42326a.b(1);
        }
    }

    public interface StatsCounter {
        void a();

        void b();

        void c(long j2);

        void d(long j2);

        void e();
    }
}
