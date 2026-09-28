package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ConcurrentHashMapCache<T> implements SerializerCache<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Lambda f55794a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f55795b;

    /* JADX WARN: Multi-variable type inference failed */
    public ConcurrentHashMapCache(Function1 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.f55794a = (Lambda) compute;
        this.f55795b = new ConcurrentHashMap();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // kotlinx.serialization.internal.SerializerCache
    public final KSerializer a(KClass key) {
        Object objPutIfAbsent;
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap concurrentHashMap = this.f55795b;
        Class clsA = JvmClassMappingKt.a(key);
        Object cacheEntry = concurrentHashMap.get(clsA);
        if (cacheEntry == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(clsA, (cacheEntry = new CacheEntry((KSerializer) this.f55794a.invoke(key))))) != null) {
            cacheEntry = objPutIfAbsent;
        }
        return ((CacheEntry) cacheEntry).f55780a;
    }
}
