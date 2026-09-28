package kotlinx.serialization;

import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class PolymorphicSerializer<T> extends AbstractPolymorphicSerializer<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ClassReference f55694a;

    /* renamed from: b, reason: collision with root package name */
    public final EmptyList f55695b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f55696c;

    public PolymorphicSerializer(ClassReference baseClass) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        this.f55694a = baseClass;
        this.f55695b = EmptyList.f53609a;
        this.f55696c = LazyKt.a(LazyThreadSafetyMode.f53529b, new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                final PolymorphicSerializer polymorphicSerializer = this.f55697c;
                return ContextAwareKt.c(SerialDescriptorsKt.d("kotlinx.serialization.Polymorphic", PolymorphicKind.OPEN.f55730a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2.1
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
                        StringBuilder sb = new StringBuilder("kotlinx.serialization.Polymorphic<");
                        PolymorphicSerializer polymorphicSerializer2 = polymorphicSerializer;
                        sb.append(polymorphicSerializer2.f55694a.i());
                        sb.append('>');
                        buildSerialDescriptor.a(CLConstants.FIELD_PAY_INFO_VALUE, SerialDescriptorsKt.d(sb.toString(), SerialKind.CONTEXTUAL.f55763a, new SerialDescriptor[0], SerialDescriptorsKt$buildSerialDescriptor$1.f55762c), emptyList, false);
                        EmptyList emptyList2 = polymorphicSerializer2.f55695b;
                        Intrinsics.checkNotNullParameter(emptyList2, "<set-?>");
                        buildSerialDescriptor.f55721b = emptyList2;
                        return Unit.f53572a;
                    }
                }), polymorphicSerializer.f55694a);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return (SerialDescriptor) this.f55696c.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final KClass g() {
        return this.f55694a;
    }

    public final String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.f55694a + ')';
    }
}
