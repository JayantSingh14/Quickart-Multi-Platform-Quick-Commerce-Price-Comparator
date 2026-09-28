package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ClassValueCache<T> implements SerializerCache<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Lambda f55787a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassValueReferences f55788b;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueCache(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.f55787a = (Lambda) compute;
        this.f55788b = new ClassValueReferences();
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public final KSerializer a(final KClass key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = this.f55788b.get(JvmClassMappingKt.a(key));
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        MutableSoftReference mutableSoftReference = (MutableSoftReference) obj;
        Object objA = mutableSoftReference.f55854a.get();
        if (objA == null) {
            objA = mutableSoftReference.a(new Function0<Object>() { // from class: kotlinx.serialization.internal.ClassValueCache$get$$inlined$getOrSet$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return new CacheEntry((KSerializer) this.f55789c.f55787a.invoke(key));
                }
            });
        }
        return ((CacheEntry) objA).f55780a;
    }
}
