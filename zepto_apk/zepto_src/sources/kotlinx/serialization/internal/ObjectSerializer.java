package kotlinx.serialization.internal;

import android.support.v4.media.b;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ObjectSerializer<T> implements KSerializer<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Unit f55861a;

    /* renamed from: b, reason: collision with root package name */
    public final EmptyList f55862b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f55863c;

    public ObjectSerializer(Unit objectInstance) {
        Intrinsics.checkNotNullParameter("kotlin.Unit", "serialName");
        Intrinsics.checkNotNullParameter(objectInstance, "objectInstance");
        this.f55861a = objectInstance;
        this.f55862b = EmptyList.f53609a;
        this.f55863c = LazyKt.a(LazyThreadSafetyMode.f53529b, new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.internal.ObjectSerializer$descriptor$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                final ObjectSerializer objectSerializer = this.f55864c;
                return SerialDescriptorsKt.d("kotlin.Unit", StructureKind.OBJECT.f55768a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.internal.ObjectSerializer$descriptor$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        ClassSerialDescriptorBuilder buildSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
                        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        EmptyList emptyList = objectSerializer.f55862b;
                        buildSerialDescriptor.getClass();
                        Intrinsics.checkNotNullParameter(emptyList, "<set-?>");
                        buildSerialDescriptor.f55721b = emptyList;
                        return Unit.f53572a;
                    }
                });
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return (SerialDescriptor) this.f55863c.getValue();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptorA = a();
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorA);
        int iO = compositeDecoderB.o(a());
        if (iO != -1) {
            throw new SerializationException(b.f(iO, "Unexpected index "));
        }
        Unit unit = Unit.f53572a;
        compositeDecoderB.c(serialDescriptorA);
        return this.f55861a;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.b(a()).c(a());
    }
}
