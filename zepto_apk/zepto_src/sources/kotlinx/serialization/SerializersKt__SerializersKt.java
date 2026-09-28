package kotlinx.serialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.SerializerCache;
import kotlinx.serialization.modules.SerializersModule;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final /* synthetic */ class SerializersKt__SerializersKt {
    public static final KSerializer a(SerializersModule serializersModule, KType kType, boolean z) {
        KSerializer kSerializerA;
        KSerializer kSerializerA2;
        KClass clazz = Platform_commonKt.c(kType);
        boolean zA = kType.a();
        List listJ = kType.j();
        final ArrayList types = new ArrayList(CollectionsKt.r(listJ, 10));
        Iterator it = listJ.iterator();
        if (it.hasNext()) {
            KTypeProjection kTypeProjection = (KTypeProjection) it.next();
            Intrinsics.checkNotNullParameter(kTypeProjection, "<this>");
            kTypeProjection.getClass();
            throw new IllegalArgumentException("Star projections in type arguments are not allowed, but had null".toString());
        }
        if (types.isEmpty()) {
            SerializerCache serializerCache = SerializersCacheKt.f55708a;
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            if (zA) {
                kSerializerA = SerializersCacheKt.f55709b.a(clazz);
            } else {
                kSerializerA = SerializersCacheKt.f55708a.a(clazz);
                if (kSerializerA == null) {
                    kSerializerA = null;
                }
            }
        } else {
            SerializerCache serializerCache2 = SerializersCacheKt.f55708a;
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(types, "types");
            Object objA = !zA ? SerializersCacheKt.f55710c.a(clazz, types) : SerializersCacheKt.f55711d.a(clazz, types);
            Result.Companion companion = Result.f53538b;
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            kSerializerA = (KSerializer) objA;
        }
        if (kSerializerA != null) {
            return kSerializerA;
        }
        if (!types.isEmpty()) {
            ArrayList arrayListD = SerializersKt.d(serializersModule, types, z);
            if (arrayListD != null) {
                KSerializer kSerializerA3 = SerializersKt.a(clazz, arrayListD, new Function0<KClassifier>() { // from class: kotlinx.serialization.SerializersKt__SerializersKt$serializerByKTypeImpl$contextualSerializer$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ((KType) types.get(0)).f();
                    }
                });
                kSerializerA2 = kSerializerA3 == null ? serializersModule.a(clazz, arrayListD) : kSerializerA3;
            }
            return null;
        }
        kSerializerA2 = serializersModule.a(clazz, EmptyList.f53609a);
        if (kSerializerA2 != null) {
            return zA ? BuiltinSerializersKt.c(kSerializerA2) : kSerializerA2;
        }
        return null;
    }
}
