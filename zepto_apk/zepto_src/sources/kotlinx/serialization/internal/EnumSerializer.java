package kotlinx.serialization.internal;

import java.lang.Enum;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EnumSerializer<T extends Enum<T>> implements KSerializer<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Enum[] f55815a;

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f55816b;

    public EnumSerializer(final String serialName, Enum[] values) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        this.f55815a = values;
        this.f55816b = LazyKt.b(new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.internal.EnumSerializer$descriptor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                EnumSerializer enumSerializer = this.f55817c;
                enumSerializer.getClass();
                Enum[] enumArr = enumSerializer.f55815a;
                EnumDescriptor enumDescriptor = new EnumDescriptor(serialName, enumArr.length);
                for (Enum r0 : enumArr) {
                    enumDescriptor.k(r0.name(), false);
                }
                return enumDescriptor;
            }
        });
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return (SerialDescriptor) this.f55816b.getValue();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        int iG = decoder.g(a());
        Enum[] enumArr = this.f55815a;
        if (iG >= 0 && iG < enumArr.length) {
            return enumArr[iG];
        }
        throw new SerializationException(iG + " is not among valid " + a().i() + " enum values, values size is " + enumArr.length);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        Enum value = (Enum) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        Enum[] enumArr = this.f55815a;
        int iX = ArraysKt.x(enumArr, value);
        if (iX != -1) {
            encoder.m(a(), iX);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" is not a valid enum ");
        sb.append(a().i());
        sb.append(", must be one of ");
        String string = Arrays.toString(enumArr);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        throw new SerializationException(sb.toString());
    }

    public final String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + a().i() + '>';
    }
}
