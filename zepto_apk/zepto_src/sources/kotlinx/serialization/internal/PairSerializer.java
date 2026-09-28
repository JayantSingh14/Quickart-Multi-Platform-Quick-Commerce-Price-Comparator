package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class PairSerializer<K, V> extends KeyValueSerializer<K, V, Pair<? extends K, ? extends V>> {

    /* renamed from: c, reason: collision with root package name */
    public final SerialDescriptorImpl f55866c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PairSerializer(final KSerializer keySerializer, final KSerializer valueSerializer) {
        super(keySerializer, valueSerializer);
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        this.f55866c = SerialDescriptorsKt.b("kotlin.Pair", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.internal.PairSerializer$descriptor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ClassSerialDescriptorBuilder buildClassSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
                Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                SerialDescriptor serialDescriptorA = keySerializer.a();
                EmptyList emptyList = EmptyList.f53609a;
                buildClassSerialDescriptor.a("first", serialDescriptorA, emptyList, false);
                buildClassSerialDescriptor.a("second", valueSerializer.a(), emptyList, false);
                return Unit.f53572a;
            }
        });
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return this.f55866c;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object e(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.f53533a;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object f(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.f53534b;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object g(Object obj, Object obj2) {
        return new Pair(obj, obj2);
    }
}
