package kotlinx.serialization.internal;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class TripleSerializer<A, B, C> implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {

    /* renamed from: a, reason: collision with root package name */
    public final KSerializer f55910a;

    /* renamed from: b, reason: collision with root package name */
    public final KSerializer f55911b;

    /* renamed from: c, reason: collision with root package name */
    public final KSerializer f55912c;

    /* renamed from: d, reason: collision with root package name */
    public final SerialDescriptorImpl f55913d;

    public TripleSerializer(KSerializer aSerializer, KSerializer bSerializer, KSerializer cSerializer) {
        Intrinsics.checkNotNullParameter(aSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(bSerializer, "bSerializer");
        Intrinsics.checkNotNullParameter(cSerializer, "cSerializer");
        this.f55910a = aSerializer;
        this.f55911b = bSerializer;
        this.f55912c = cSerializer;
        this.f55913d = SerialDescriptorsKt.b("kotlin.Triple", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.internal.TripleSerializer$descriptor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ClassSerialDescriptorBuilder buildClassSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
                Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                TripleSerializer tripleSerializer = this.f55914c;
                SerialDescriptor serialDescriptorA = tripleSerializer.f55910a.a();
                EmptyList emptyList = EmptyList.f53609a;
                buildClassSerialDescriptor.a("first", serialDescriptorA, emptyList, false);
                buildClassSerialDescriptor.a("second", tripleSerializer.f55911b.a(), emptyList, false);
                buildClassSerialDescriptor.a("third", tripleSerializer.f55912c.a(), emptyList, false);
                return Unit.f53572a;
            }
        });
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return this.f55913d;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptorImpl serialDescriptorImpl = this.f55913d;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorImpl);
        Object obj = TuplesKt.f55915a;
        Object objX = obj;
        Object objX2 = objX;
        Object objX3 = objX2;
        while (true) {
            int iO = compositeDecoderB.o(serialDescriptorImpl);
            if (iO == -1) {
                compositeDecoderB.c(serialDescriptorImpl);
                if (objX == obj) {
                    throw new SerializationException("Element 'first' is missing");
                }
                if (objX2 == obj) {
                    throw new SerializationException("Element 'second' is missing");
                }
                if (objX3 != obj) {
                    return new Triple(objX, objX2, objX3);
                }
                throw new SerializationException("Element 'third' is missing");
            }
            if (iO == 0) {
                objX = compositeDecoderB.x(serialDescriptorImpl, 0, this.f55910a, null);
            } else if (iO == 1) {
                objX2 = compositeDecoderB.x(serialDescriptorImpl, 1, this.f55911b, null);
            } else {
                if (iO != 2) {
                    throw new SerializationException(b.f(iO, "Unexpected index "));
                }
                objX3 = compositeDecoderB.x(serialDescriptorImpl, 2, this.f55912c, null);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        Triple value = (Triple) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptorImpl serialDescriptorImpl = this.f55913d;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorImpl);
        compositeEncoderB.B(serialDescriptorImpl, 0, this.f55910a, value.f53548a);
        compositeEncoderB.B(serialDescriptorImpl, 1, this.f55911b, value.f53549b);
        compositeEncoderB.B(serialDescriptorImpl, 2, this.f55912c, value.f53550c);
        compositeEncoderB.c(serialDescriptorImpl);
    }
}
