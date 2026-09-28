package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
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
final class ConcurrentHashMapParametrizedCache<T> implements ParametrizedSerializerCache<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Lambda f55796a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f55797b;

    /* JADX WARN: Multi-variable type inference failed */
    public ConcurrentHashMapParametrizedCache(Function2 compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.f55796a = (Lambda) compute;
        this.f55797b = new ConcurrentHashMap();
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    public final Object a(KClass key, ArrayList types) {
        Object objA;
        Object objPutIfAbsent;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        ConcurrentHashMap concurrentHashMap = this.f55797b;
        Class clsA = JvmClassMappingKt.a(key);
        Object parametrizedCacheEntry = concurrentHashMap.get(clsA);
        if (parametrizedCacheEntry == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(clsA, (parametrizedCacheEntry = new ParametrizedCacheEntry()))) != null) {
            parametrizedCacheEntry = objPutIfAbsent;
        }
        ParametrizedCacheEntry parametrizedCacheEntry2 = (ParametrizedCacheEntry) parametrizedCacheEntry;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(types, 10));
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(new KTypeWrapper((KType) it.next()));
        }
        ConcurrentHashMap concurrentHashMap2 = parametrizedCacheEntry2.f55869a;
        Object obj = concurrentHashMap2.get(arrayList);
        if (obj == null) {
            try {
                Result.Companion companion = Result.f53538b;
                objA = (KSerializer) this.f55796a.invoke(key, types);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f53538b;
                objA = ResultKt.a(th);
            }
            Result result = new Result(objA);
            Object objPutIfAbsent2 = concurrentHashMap2.putIfAbsent(arrayList, result);
            obj = objPutIfAbsent2 == null ? result : objPutIfAbsent2;
        }
        Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
        return ((Result) obj).f53539a;
    }
}
