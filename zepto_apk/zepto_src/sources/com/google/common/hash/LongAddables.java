package com.google.common.hash;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class LongAddables {

    /* renamed from: a, reason: collision with root package name */
    public static final Supplier f43215a;

    /* renamed from: com.google.common.hash.LongAddables$1, reason: invalid class name */
    public class AnonymousClass1 implements Supplier<LongAddable> {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new LongAdder();
        }
    }

    /* renamed from: com.google.common.hash.LongAddables$2, reason: invalid class name */
    public class AnonymousClass2 implements Supplier<LongAddable> {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new PureJavaLongAddable();
        }
    }

    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
    }

    static {
        Supplier anonymousClass2;
        try {
            new LongAdder();
            anonymousClass2 = new AnonymousClass1();
        } catch (Throwable unused) {
            anonymousClass2 = new AnonymousClass2();
        }
        f43215a = anonymousClass2;
    }
}
