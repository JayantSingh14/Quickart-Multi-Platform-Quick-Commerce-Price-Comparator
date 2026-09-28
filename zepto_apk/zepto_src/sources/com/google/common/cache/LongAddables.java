package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
final class LongAddables {

    /* renamed from: a, reason: collision with root package name */
    public static final Supplier f42435a;

    /* renamed from: com.google.common.cache.LongAddables$1, reason: invalid class name */
    public class AnonymousClass1 implements Supplier<LongAddable> {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new LongAdder();
        }
    }

    /* renamed from: com.google.common.cache.LongAddables$2, reason: invalid class name */
    public class AnonymousClass2 implements Supplier<LongAddable> {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new PureJavaLongAddable();
        }
    }

    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        @Override // com.google.common.cache.LongAddable
        public final void a() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public final void b(long j2) {
            getAndAdd(j2);
        }
    }

    static {
        Supplier anonymousClass2;
        try {
            new LongAdder();
            anonymousClass2 = new AnonymousClass1();
        } catch (Throwable unused) {
            anonymousClass2 = new AnonymousClass2();
        }
        f42435a = anonymousClass2;
    }

    public static LongAddable a() {
        return (LongAddable) f42435a.get();
    }
}
