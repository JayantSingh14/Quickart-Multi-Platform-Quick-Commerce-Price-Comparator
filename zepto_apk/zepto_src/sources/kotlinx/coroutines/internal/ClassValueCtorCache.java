package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata
@IgnoreJRERequirement
/* loaded from: classes3.dex */
final class ClassValueCtorCache extends CtorCache {
    static {
        new ClassValueCtorCache();
        new ClassValue<Function1<? super Throwable, ? extends Throwable>>() { // from class: kotlinx.coroutines.internal.ClassValueCtorCache$cache$1
            @Override // java.lang.ClassValue
            public final Function1<? super Throwable, ? extends Throwable> computeValue(Class cls) {
                Intrinsics.d(cls, "null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
                return ExceptionsConstructorKt.a(cls);
            }
        };
    }
}
