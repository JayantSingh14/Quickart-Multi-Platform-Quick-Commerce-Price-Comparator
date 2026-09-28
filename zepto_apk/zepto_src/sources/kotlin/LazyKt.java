package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class LazyKt extends LazyKt__LazyKt {
    public static Lazy a(LazyThreadSafetyMode mode, Function0 initializer) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        int iOrdinal = mode.ordinal();
        if (iOrdinal == 0) {
            return new SynchronizedLazyImpl(initializer, null, 2, null);
        }
        if (iOrdinal == 1) {
            Intrinsics.checkNotNullParameter(initializer, "initializer");
            SafePublicationLazyImpl safePublicationLazyImpl = new SafePublicationLazyImpl();
            safePublicationLazyImpl.f53543a = initializer;
            safePublicationLazyImpl.f53544b = UNINITIALIZED_VALUE.f53566a;
            return safePublicationLazyImpl;
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        UnsafeLazyImpl unsafeLazyImpl = new UnsafeLazyImpl();
        unsafeLazyImpl.f53573a = initializer;
        unsafeLazyImpl.f53574b = UNINITIALIZED_VALUE.f53566a;
        return unsafeLazyImpl;
    }

    public static Lazy b(Function0 initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }
}
