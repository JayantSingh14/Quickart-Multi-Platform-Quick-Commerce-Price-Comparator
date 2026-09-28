package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.WildcardTypeImpl;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class TypesJVMKt {

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                KVariance[] kVarianceArr = KVariance.f53878a;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KVariance[] kVarianceArr2 = KVariance.f53878a;
                iArr[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KVariance[] kVarianceArr3 = KVariance.f53878a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final String a(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            String name = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }
        Sequence sequenceK = SequencesKt.k(type, TypesJVMKt$typeToString$unwrap$1.f53887b);
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullParameter(sequenceK, "<this>");
        Iterator it = sequenceK.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        sb.append(((Class) next).getName());
        sb.append(StringsKt.I("[]", SequencesKt.e(sequenceK)));
        return sb.toString();
    }

    public static final Type b(KType kType, boolean z) {
        KClassifier kClassifierF = kType.f();
        if (kClassifierF instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) kClassifierF);
        }
        if (!(kClassifierF instanceof KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        KClass kClass = (KClass) kClassifierF;
        Class clsB = z ? JvmClassMappingKt.b(kClass) : JvmClassMappingKt.a(kClass);
        List listJ = kType.j();
        if (!listJ.isEmpty()) {
            if (!clsB.isArray()) {
                return c(listJ, clsB);
            }
            if (clsB.getComponentType().isPrimitive() || ((KTypeProjection) CollectionsKt.U(listJ)) != null) {
                return clsB;
            }
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        return clsB;
    }

    public static final Type c(List list, Class cls) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(e((KTypeProjection) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List list3 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.r(list3, 10));
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(e((KTypeProjection) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeC = c(list.subList(length, list.size()), declaringClass);
        List listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.r(listSubList, 10));
        Iterator it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(e((KTypeProjection) it3.next()));
        }
        return new ParameterizedTypeImpl(cls, typeC, arrayList3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Type d(TypeReference typeReference) {
        Type typeE;
        Intrinsics.checkNotNullParameter(typeReference, "<this>");
        return (!(typeReference instanceof KTypeBase) || (typeE = ((KTypeBase) typeReference).e()) == null) ? b(typeReference, false) : typeE;
    }

    public static final Type e(KTypeProjection kTypeProjection) {
        kTypeProjection.getClass();
        WildcardTypeImpl.f53888c.getClass();
        return WildcardTypeImpl.Companion.a();
    }
}
