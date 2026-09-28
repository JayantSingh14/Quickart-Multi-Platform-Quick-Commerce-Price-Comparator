package kotlinx.serialization.modules;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SerialModuleImpl extends SerializersModule {

    /* renamed from: a, reason: collision with root package name */
    public final Object f56116a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f56117b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f56118c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f56119d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f56120e;

    public SerialModuleImpl(Map class2ContextualFactory, Map polyBase2Serializers, Map polyBase2DefaultSerializerProvider, Map polyBase2NamedSerializers, Map polyBase2DefaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(class2ContextualFactory, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(polyBase2Serializers, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.f56116a = class2ContextualFactory;
        this.f56117b = polyBase2Serializers;
        this.f56118c = polyBase2DefaultSerializerProvider;
        this.f56119d = polyBase2NamedSerializers;
        this.f56120e = polyBase2DefaultDeserializerProvider;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    @Override // kotlinx.serialization.modules.SerializersModule
    public final KSerializer a(KClass kClass, List typeArgumentsSerializers) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        ContextualProvider contextualProvider = (ContextualProvider) this.f56116a.get(kClass);
        KSerializer kSerializerA = contextualProvider != null ? contextualProvider.a(typeArgumentsSerializers) : null;
        if (kSerializerA != null) {
            return kSerializerA;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, java.util.Map] */
    @Override // kotlinx.serialization.modules.SerializersModule
    public final DeserializationStrategy b(String str, KClass baseClass) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Map map = (Map) this.f56119d.get(baseClass);
        KSerializer kSerializer = map != null ? (KSerializer) map.get(str) : null;
        if (kSerializer == null) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Object obj = this.f56120e.get(baseClass);
        Function1 function1 = TypeIntrinsics.c(1, obj) ? (Function1) obj : null;
        if (function1 != null) {
            return (DeserializationStrategy) function1.invoke(str);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object, java.util.Map] */
    @Override // kotlinx.serialization.modules.SerializersModule
    public final SerializationStrategy c(KClass baseClass, Object value) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(value, "value");
        if (baseClass.h(value)) {
            Map map = (Map) this.f56117b.get(baseClass);
            KSerializer kSerializer = map != null ? (KSerializer) map.get(Reflection.a(value.getClass())) : null;
            if (kSerializer == null) {
                kSerializer = null;
            }
            if (kSerializer != null) {
                return kSerializer;
            }
            Object obj = this.f56118c.get(baseClass);
            Function1 function1 = TypeIntrinsics.c(1, obj) ? (Function1) obj : null;
            if (function1 != null) {
                return (SerializationStrategy) function1.invoke(value);
            }
        }
        return null;
    }
}
