package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class CachingKt {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f55781a;

    static {
        boolean z;
        try {
            Class.forName("java.lang.ClassValue");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        f55781a = z;
    }

    public static final SerializerCache a(Function1 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return f55781a ? new ClassValueCache(factory) : new ConcurrentHashMapCache(factory);
    }

    public static final ParametrizedSerializerCache b(Function2 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return f55781a ? new ClassValueParametrizedCache(factory) : new ConcurrentHashMapParametrizedCache(factory);
    }
}
