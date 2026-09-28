package kotlinx.serialization;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@InternalSerializationApi
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ClassReference f55699a;

    /* renamed from: b, reason: collision with root package name */
    public final EmptyList f55700b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f55701c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f55702d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f55703e;

    public SealedClassSerializer(final String serialName, ClassReference baseClass, KClass[] subclasses, KSerializer[] other) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(other, "subclassSerializers");
        this.f55699a = baseClass;
        this.f55700b = EmptyList.f53609a;
        this.f55701c = LazyKt.a(LazyThreadSafetyMode.f53529b, new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                final SealedClassSerializer sealedClassSerializer = this;
                Function1<ClassSerialDescriptorBuilder, Unit> function1 = new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        ClassSerialDescriptorBuilder buildSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
                        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        BuiltinSerializersKt.d(StringCompanionObject.f53805a);
                        PrimitiveSerialDescriptor primitiveSerialDescriptor = StringSerializer.f55903b;
                        EmptyList emptyList = EmptyList.f53609a;
                        buildSerialDescriptor.a("type", primitiveSerialDescriptor, emptyList, false);
                        StringBuilder sb = new StringBuilder("kotlinx.serialization.Sealed<");
                        final SealedClassSerializer sealedClassSerializer2 = sealedClassSerializer;
                        sb.append(sealedClassSerializer2.f55699a.i());
                        sb.append('>');
                        buildSerialDescriptor.a(CLConstants.FIELD_PAY_INFO_VALUE, SerialDescriptorsKt.d(sb.toString(), SerialKind.CONTEXTUAL.f55763a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2$1$elementDescriptor$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                ClassSerialDescriptorBuilder buildSerialDescriptor2 = (ClassSerialDescriptorBuilder) obj2;
                                Intrinsics.checkNotNullParameter(buildSerialDescriptor2, "$this$buildSerialDescriptor");
                                for (Map.Entry entry : sealedClassSerializer2.f55703e.entrySet()) {
                                    buildSerialDescriptor2.a((String) entry.getKey(), ((KSerializer) entry.getValue()).a(), EmptyList.f53609a, false);
                                }
                                return Unit.f53572a;
                            }
                        }), emptyList, false);
                        EmptyList emptyList2 = sealedClassSerializer2.f55700b;
                        Intrinsics.checkNotNullParameter(emptyList2, "<set-?>");
                        buildSerialDescriptor.f55721b = emptyList2;
                        return Unit.f53572a;
                    }
                };
                return SerialDescriptorsKt.d(serialName, PolymorphicKind.SEALED.f55731a, new SerialDescriptor[0], function1);
            }
        });
        if (subclasses.length != other.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + baseClass.i() + " should be marked @Serializable");
        }
        Intrinsics.checkNotNullParameter(subclasses, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(subclasses.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(new Pair(subclasses[i2], other[i2]));
        }
        Map mapK = MapsKt.k(arrayList);
        this.f55702d = mapK;
        Set<Map.Entry> setEntrySet = mapK.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : setEntrySet) {
            String strI = ((KSerializer) entry.getValue()).a().i();
            Object obj = linkedHashMap.get(strI);
            if (obj == null) {
                linkedHashMap.containsKey(strI);
            }
            Map.Entry entry2 = (Map.Entry) obj;
            if (entry2 != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + this.f55699a + "' have the same serial name '" + strI + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
            }
            linkedHashMap.put(strI, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.f(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.f55703e = linkedHashMap2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return (SerialDescriptor) this.f55701c.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final DeserializationStrategy e(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        KSerializer kSerializer = (KSerializer) this.f55703e.get(str);
        return kSerializer != null ? kSerializer : super.e(decoder, str);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final SerializationStrategy f(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializationStrategy serializationStrategyF = (KSerializer) this.f55702d.get(Reflection.a(value.getClass()));
        if (serializationStrategyF == null) {
            serializationStrategyF = super.f(encoder, value);
        }
        if (serializationStrategyF != null) {
            return serializationStrategyF;
        }
        return null;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final KClass g() {
        return this.f55699a;
    }
}
