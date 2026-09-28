package io.ktor.serialization.kotlinx;

import io.ktor.util.reflect.TypeInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.modules.SerializersModule;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SerializerLookupKt {
    public static final KSerializer a(Collection collection, SerializersModule serializersModule) {
        Collection collection2 = collection;
        ArrayList arrayListX = CollectionsKt.x(collection2);
        ArrayList arrayList = new ArrayList(CollectionsKt.r(arrayListX, 10));
        Iterator it = arrayListX.iterator();
        while (it.hasNext()) {
            arrayList.add(b(it.next(), serializersModule));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (hashSet.add(((KSerializer) next).a().i())) {
                arrayList2.add(next);
            }
        }
        if (arrayList2.size() > 1) {
            StringBuilder sb = new StringBuilder("Serializing collections of different element types is not yet supported. Selected serializers: ");
            ArrayList arrayList3 = new ArrayList(CollectionsKt.r(arrayList2, 10));
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(((KSerializer) it3.next()).a().i());
            }
            sb.append(arrayList3);
            throw new IllegalStateException(sb.toString().toString());
        }
        KSerializer kSerializer = (KSerializer) CollectionsKt.U(arrayList2);
        if (kSerializer == null) {
            BuiltinSerializersKt.d(StringCompanionObject.f53805a);
            kSerializer = StringSerializer.f55902a;
        }
        if (!kSerializer.a().b() && (!(collection2 instanceof Collection) || !collection2.isEmpty())) {
            Iterator it4 = collection2.iterator();
            while (it4.hasNext()) {
                if (it4.next() == null) {
                    return BuiltinSerializersKt.c(kSerializer);
                }
            }
        }
        return kSerializer;
    }

    public static final KSerializer b(Object obj, SerializersModule module) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(module, "module");
        if (obj == null) {
            BuiltinSerializersKt.d(StringCompanionObject.f53805a);
            return BuiltinSerializersKt.c(StringSerializer.f55902a);
        }
        if (obj instanceof List) {
            return BuiltinSerializersKt.a(a((Collection) obj, module));
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            Object obj2 = objArr.length != 0 ? objArr[0] : null;
            if (obj2 != null) {
                return b(obj2, module);
            }
            BuiltinSerializersKt.d(StringCompanionObject.f53805a);
            return BuiltinSerializersKt.a(StringSerializer.f55902a);
        }
        if (obj instanceof Set) {
            KSerializer elementSerializer = a((Collection) obj, module);
            Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
            return new LinkedHashSetSerializer(elementSerializer);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            return BuiltinSerializersKt.b(a(map.keySet(), module), a(map.values(), module));
        }
        KSerializer kSerializerA = module.a(Reflection.a(obj.getClass()), EmptyList.f53609a);
        if (kSerializerA != null) {
            return kSerializerA;
        }
        ClassReference classReferenceA = Reflection.a(obj.getClass());
        Intrinsics.checkNotNullParameter(classReferenceA, "<this>");
        KSerializer kSerializerB = SerializersKt.b(classReferenceA);
        if (kSerializerB != null) {
            return kSerializerB;
        }
        Platform_commonKt.d(classReferenceA);
        throw null;
    }

    public static final KSerializer c(SerializersModule serializersModule, TypeInfo typeInfo) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(typeInfo, "typeInfo");
        TypeReference typeReference = typeInfo.f50604c;
        if (typeReference != null) {
            KSerializer kSerializerC = Collections.EMPTY_LIST.isEmpty() ? null : SerializersKt.c(serializersModule, typeReference);
            if (kSerializerC != null) {
                return kSerializerC;
            }
        }
        KClass kClass = typeInfo.f50602a;
        KSerializer kSerializerA = serializersModule.a(kClass, EmptyList.f53609a);
        TypeReference typeReference2 = typeInfo.f50604c;
        if (kSerializerA != null) {
            return (typeReference2 == null || !typeReference2.a()) ? kSerializerA : BuiltinSerializersKt.c(kSerializerA);
        }
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer kSerializerB = SerializersKt.b(kClass);
        if (kSerializerB != null) {
            return (typeReference2 == null || !typeReference2.a()) ? kSerializerB : BuiltinSerializersKt.c(kSerializerB);
        }
        Platform_commonKt.d(kClass);
        throw null;
    }
}
