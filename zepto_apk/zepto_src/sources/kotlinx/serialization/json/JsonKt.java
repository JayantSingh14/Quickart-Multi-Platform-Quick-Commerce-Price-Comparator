package kotlinx.serialization.json;

import com.zeptonow.horizon.utils.AnyValueSerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.PolymorphismValidator;
import kotlinx.serialization.modules.ContextualProvider;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModuleCollector;
import kotlinx.serialization.modules.SerializersModuleKt;

@Metadata
/* loaded from: classes.dex */
public final class JsonKt {
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object, java.util.Map] */
    public static Json a(Function1 builderAction) {
        Json.Default json = Json.f55944d;
        Intrinsics.checkNotNullParameter(json, "from");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Intrinsics.checkNotNullParameter(json, "json");
        JsonBuilder jsonBuilder = new JsonBuilder();
        JsonConfiguration jsonConfiguration = json.f55945a;
        jsonBuilder.f55954a = jsonConfiguration.f55966a;
        jsonBuilder.f55955b = jsonConfiguration.f55970e;
        jsonBuilder.f55956c = jsonConfiguration.f55967b;
        jsonBuilder.f55957d = jsonConfiguration.f55968c;
        jsonBuilder.f55958e = jsonConfiguration.f55969d;
        String str = jsonConfiguration.f55971f;
        jsonBuilder.f55959f = str;
        jsonBuilder.f55960g = jsonConfiguration.f55972g;
        jsonBuilder.f55961h = jsonConfiguration.f55973h;
        jsonBuilder.f55962i = jsonConfiguration.f55976k;
        jsonBuilder.f55963j = jsonConfiguration.f55974i;
        jsonBuilder.f55964k = jsonConfiguration.f55975j;
        jsonBuilder.f55965l = json.f55946b;
        builderAction.invoke(jsonBuilder);
        if (!Intrinsics.b(str, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        boolean z = jsonBuilder.f55954a;
        boolean z2 = jsonBuilder.f55956c;
        boolean z3 = jsonBuilder.f55957d;
        boolean z4 = jsonBuilder.f55958e;
        boolean z5 = jsonBuilder.f55955b;
        boolean z6 = jsonBuilder.f55960g;
        boolean z7 = jsonBuilder.f55963j;
        ClassDiscriminatorMode classDiscriminatorMode = jsonBuilder.f55962i;
        String str2 = jsonBuilder.f55959f;
        String str3 = jsonBuilder.f55961h;
        JsonConfiguration configuration = new JsonConfiguration(z, z2, z3, z4, z5, str2, z6, str3, z7, jsonBuilder.f55964k, classDiscriminatorMode);
        SerialModuleImpl module = jsonBuilder.f55965l;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(module, "module");
        JsonImpl jsonImpl = new JsonImpl(configuration, module);
        if (!Intrinsics.b(module, SerializersModuleKt.f56126a)) {
            PolymorphismValidator collector = new PolymorphismValidator(str3);
            module.getClass();
            Intrinsics.checkNotNullParameter(collector, "collector");
            for (Map.Entry entry : module.f56116a.entrySet()) {
                KClass kClass = (KClass) entry.getKey();
                ContextualProvider contextualProvider = (ContextualProvider) entry.getValue();
                if (contextualProvider instanceof ContextualProvider.Argless) {
                    Intrinsics.d(kClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                    ((ContextualProvider.Argless) contextualProvider).getClass();
                    AnyValueSerializer anyValueSerializer = AnyValueSerializer.f48230a;
                    SerializersModuleCollector.DefaultImpls.a(collector, kClass);
                } else if (contextualProvider instanceof ContextualProvider.WithTypeArguments) {
                    collector.a(kClass, ((ContextualProvider.WithTypeArguments) contextualProvider).b());
                }
            }
            for (Map.Entry entry2 : module.f56117b.entrySet()) {
                KClass baseClass = (KClass) entry2.getKey();
                for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                    KClass actualClass = (KClass) entry3.getKey();
                    KSerializer actualSerializer = (KSerializer) entry3.getValue();
                    Intrinsics.d(baseClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                    Intrinsics.d(actualClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                    Intrinsics.d(actualSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    Intrinsics.checkNotNullParameter(baseClass, "baseClass");
                    Intrinsics.checkNotNullParameter(actualClass, "actualClass");
                    Intrinsics.checkNotNullParameter(actualSerializer, "actualSerializer");
                    SerialDescriptor serialDescriptorA = actualSerializer.a();
                    SerialKind serialKindD = serialDescriptorA.d();
                    if ((serialKindD instanceof PolymorphicKind) || Intrinsics.b(serialKindD, SerialKind.CONTEXTUAL.f55763a)) {
                        throw new IllegalArgumentException("Serializer for " + actualClass.i() + " can't be registered as a subclass for polymorphic serialization because its kind " + serialKindD + " is not concrete. To work with multiple hierarchies, register it as a base class.");
                    }
                    if (Intrinsics.b(serialKindD, StructureKind.LIST.f55766a) || Intrinsics.b(serialKindD, StructureKind.MAP.f55767a) || (serialKindD instanceof PrimitiveKind) || (serialKindD instanceof SerialKind.ENUM)) {
                        throw new IllegalArgumentException("Serializer for " + actualClass.i() + " of kind " + serialKindD + " cannot be serialized polymorphically with class discriminator.");
                    }
                    int iE = serialDescriptorA.e();
                    for (int i2 = 0; i2 < iE; i2++) {
                        String strF = serialDescriptorA.f(i2);
                        if (Intrinsics.b(strF, collector.f56084a)) {
                            throw new IllegalArgumentException("Polymorphic serializer for " + actualClass + " has property '" + strF + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
                        }
                    }
                }
            }
            for (Map.Entry entry4 : module.f56118c.entrySet()) {
                KClass baseClass2 = (KClass) entry4.getKey();
                Function1 defaultSerializerProvider = (Function1) entry4.getValue();
                Intrinsics.d(baseClass2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.d(defaultSerializerProvider, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
                TypeIntrinsics.b(1, defaultSerializerProvider);
                Intrinsics.checkNotNullParameter(baseClass2, "baseClass");
                Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
            }
            for (Map.Entry entry5 : module.f56120e.entrySet()) {
                KClass baseClass3 = (KClass) entry5.getKey();
                Function1 defaultDeserializerProvider = (Function1) entry5.getValue();
                Intrinsics.d(baseClass3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.d(defaultDeserializerProvider, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
                TypeIntrinsics.b(1, defaultDeserializerProvider);
                Intrinsics.checkNotNullParameter(baseClass3, "baseClass");
                Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
            }
        }
        return jsonImpl;
    }
}
