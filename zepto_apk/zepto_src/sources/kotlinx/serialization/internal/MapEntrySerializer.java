package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class MapEntrySerializer<K, V> extends KeyValueSerializer<K, V, Map.Entry<? extends K, ? extends V>> {

    /* renamed from: c, reason: collision with root package name */
    public final SerialDescriptorImpl f55844c;

    @Metadata
    public static final class MapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final Object f55845a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f55846b;

        public MapEntry(Object obj, Object obj2) {
            this.f55845a = obj;
            this.f55846b = obj2;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MapEntry)) {
                return false;
            }
            MapEntry mapEntry = (MapEntry) obj;
            return Intrinsics.b(this.f55845a, mapEntry.f55845a) && Intrinsics.b(this.f55846b, mapEntry.f55846b);
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f55845a;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.f55846b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Object obj = this.f55845a;
            int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
            Object obj2 = this.f55846b;
            return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final String toString() {
            return "MapEntry(key=" + this.f55845a + ", value=" + this.f55846b + ')';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapEntrySerializer(final KSerializer keySerializer, final KSerializer valueSerializer) {
        super(keySerializer, valueSerializer);
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        this.f55844c = SerialDescriptorsKt.d("kotlin.collections.Map.Entry", StructureKind.MAP.f55767a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.internal.MapEntrySerializer$descriptor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ClassSerialDescriptorBuilder buildSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
                Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                SerialDescriptor serialDescriptorA = keySerializer.a();
                EmptyList emptyList = EmptyList.f53609a;
                buildSerialDescriptor.a("key", serialDescriptorA, emptyList, false);
                buildSerialDescriptor.a(CLConstants.FIELD_PAY_INFO_VALUE, valueSerializer.a(), emptyList, false);
                return Unit.f53572a;
            }
        });
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return this.f55844c;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object e(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getKey();
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object f(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getValue();
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public final Object g(Object obj, Object obj2) {
        return new MapEntry(obj, obj2);
    }
}
