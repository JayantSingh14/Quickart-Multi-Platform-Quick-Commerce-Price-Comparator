package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ClassValueParametrizedCache<T> implements ParametrizedSerializerCache<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Lambda f55791a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassValueReferences f55792b;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueParametrizedCache(Function2 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.f55791a = (Lambda) compute;
        this.f55792b = new ClassValueReferences();
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    public final Object a(KClass key, ArrayList types) {
        Object objA;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        Object obj = this.f55792b.get(JvmClassMappingKt.a(key));
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        MutableSoftReference mutableSoftReference = (MutableSoftReference) obj;
        Object objA2 = mutableSoftReference.f55854a.get();
        if (objA2 == null) {
            objA2 = mutableSoftReference.a(new Function0<Object>() { // from class: kotlinx.serialization.internal.ClassValueParametrizedCache$get-gIAlu-s$$inlined$getOrSet$1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return new ParametrizedCacheEntry();
                }
            });
        }
        ParametrizedCacheEntry parametrizedCacheEntry = (ParametrizedCacheEntry) objA2;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(types, 10));
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(new KTypeWrapper((KType) it.next()));
        }
        ConcurrentHashMap concurrentHashMap = parametrizedCacheEntry.f55869a;
        Object obj2 = concurrentHashMap.get(arrayList);
        if (obj2 == null) {
            try {
                Result.Companion companion = Result.f53538b;
                objA = (KSerializer) this.f55791a.invoke(key, types);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f53538b;
                objA = ResultKt.a(th);
            }
            Result result = new Result(objA);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(arrayList, result);
            obj2 = objPutIfAbsent == null ? result : objPutIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj2, "getOrPut(...)");
        return ((Result) obj2).f53539a;
    }
}
