package kotlinx.serialization;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.modules.SerializersModule;

@Metadata
/* loaded from: classes3.dex */
public final class SerializersKt {
    public static final KSerializer a(KClass rootClass, ArrayList serializers, Function0 elementClassifierIfArray) {
        KSerializer tripleSerializer;
        KSerializer referenceArraySerializer;
        Intrinsics.checkNotNullParameter(rootClass, "<this>");
        Intrinsics.checkNotNullParameter(serializers, "serializers");
        Intrinsics.checkNotNullParameter(elementClassifierIfArray, "elementClassifierIfArray");
        if (Intrinsics.b(rootClass, Reflection.a(Collection.class)) ? true : Intrinsics.b(rootClass, Reflection.a(List.class)) ? true : Intrinsics.b(rootClass, Reflection.a(List.class)) ? true : Intrinsics.b(rootClass, Reflection.a(ArrayList.class))) {
            tripleSerializer = new ArrayListSerializer((KSerializer) serializers.get(0));
        } else if (Intrinsics.b(rootClass, Reflection.a(HashSet.class))) {
            tripleSerializer = new HashSetSerializer((KSerializer) serializers.get(0));
        } else {
            if (Intrinsics.b(rootClass, Reflection.a(Set.class)) ? true : Intrinsics.b(rootClass, Reflection.a(Set.class)) ? true : Intrinsics.b(rootClass, Reflection.a(LinkedHashSet.class))) {
                tripleSerializer = new LinkedHashSetSerializer((KSerializer) serializers.get(0));
            } else if (Intrinsics.b(rootClass, Reflection.a(HashMap.class))) {
                tripleSerializer = new HashMapSerializer((KSerializer) serializers.get(0), (KSerializer) serializers.get(1));
            } else {
                if (Intrinsics.b(rootClass, Reflection.a(Map.class)) ? true : Intrinsics.b(rootClass, Reflection.a(Map.class)) ? true : Intrinsics.b(rootClass, Reflection.a(LinkedHashMap.class))) {
                    tripleSerializer = new LinkedHashMapSerializer((KSerializer) serializers.get(0), (KSerializer) serializers.get(1));
                } else {
                    if (Intrinsics.b(rootClass, Reflection.a(Map.Entry.class))) {
                        KSerializer keySerializer = (KSerializer) serializers.get(0);
                        KSerializer valueSerializer = (KSerializer) serializers.get(1);
                        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
                        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
                        referenceArraySerializer = new MapEntrySerializer(keySerializer, valueSerializer);
                    } else if (Intrinsics.b(rootClass, Reflection.a(Pair.class))) {
                        KSerializer keySerializer2 = (KSerializer) serializers.get(0);
                        KSerializer valueSerializer2 = (KSerializer) serializers.get(1);
                        Intrinsics.checkNotNullParameter(keySerializer2, "keySerializer");
                        Intrinsics.checkNotNullParameter(valueSerializer2, "valueSerializer");
                        referenceArraySerializer = new PairSerializer(keySerializer2, valueSerializer2);
                    } else if (Intrinsics.b(rootClass, Reflection.a(Triple.class))) {
                        KSerializer aSerializer = (KSerializer) serializers.get(0);
                        KSerializer bSerializer = (KSerializer) serializers.get(1);
                        KSerializer cSerializer = (KSerializer) serializers.get(2);
                        Intrinsics.checkNotNullParameter(aSerializer, "aSerializer");
                        Intrinsics.checkNotNullParameter(bSerializer, "bSerializer");
                        Intrinsics.checkNotNullParameter(cSerializer, "cSerializer");
                        tripleSerializer = new TripleSerializer(aSerializer, bSerializer, cSerializer);
                    } else {
                        Intrinsics.checkNotNullParameter(rootClass, "rootClass");
                        if (JvmClassMappingKt.a(rootClass).isArray()) {
                            Object objInvoke = elementClassifierIfArray.invoke();
                            Intrinsics.d(objInvoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                            KClass kClass = (KClass) objInvoke;
                            KSerializer elementSerializer = (KSerializer) serializers.get(0);
                            Intrinsics.checkNotNullParameter(kClass, "kClass");
                            Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
                            referenceArraySerializer = new ReferenceArraySerializer(kClass, elementSerializer);
                        } else {
                            tripleSerializer = null;
                        }
                    }
                    tripleSerializer = referenceArraySerializer;
                }
            }
        }
        if (tripleSerializer != null) {
            return tripleSerializer;
        }
        KSerializer[] kSerializerArr = (KSerializer[]) serializers.toArray(new KSerializer[0]);
        return PlatformKt.a(rootClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    public static final KSerializer b(KClass kClass) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer kSerializerA = PlatformKt.a(kClass, new KSerializer[0]);
        if (kSerializerA != null) {
            return kSerializerA;
        }
        Object obj = PrimitivesKt.f55891a;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return (KSerializer) PrimitivesKt.f55891a.get(kClass);
    }

    public static final KSerializer c(SerializersModule serializersModule, KType type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt__SerializersKt.a(serializersModule, type, false);
    }

    public static final ArrayList d(SerializersModule serializersModule, List typeArguments, boolean z) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        if (!z) {
            List list = typeArguments;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                KSerializer kSerializerC = c(serializersModule, (KType) it.next());
                if (kSerializerC == null) {
                    return null;
                }
                arrayList.add(kSerializerC);
            }
            return arrayList;
        }
        List<KType> list2 = typeArguments;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.r(list2, 10));
        for (KType type : list2) {
            Intrinsics.checkNotNullParameter(serializersModule, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            KSerializer kSerializerA = SerializersKt__SerializersKt.a(serializersModule, type, true);
            if (kSerializerA == null) {
                KClass kClassC = Platform_commonKt.c(type);
                Intrinsics.checkNotNullParameter(kClassC, "<this>");
                Platform_commonKt.d(kClassC);
                throw null;
            }
            arrayList2.add(kSerializerA);
        }
        return arrayList2;
    }
}
