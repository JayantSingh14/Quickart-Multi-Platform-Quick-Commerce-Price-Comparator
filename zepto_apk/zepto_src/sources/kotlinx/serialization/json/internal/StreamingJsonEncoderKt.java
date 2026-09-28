package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortSerializer;
import kotlinx.serialization.json.JsonElementKt;

@Metadata
/* loaded from: classes3.dex */
public final class StreamingJsonEncoderKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f56103a;

    static {
        Intrinsics.checkNotNullParameter(UInt.f53556b, "<this>");
        Intrinsics.checkNotNullParameter(ULong.f53561b, "<this>");
        Intrinsics.checkNotNullParameter(UByte.f53551b, "<this>");
        Intrinsics.checkNotNullParameter(UShort.f53567b, "<this>");
        SerialDescriptor[] elements = {UIntSerializer.f55925b, ULongSerializer.f55930b, UByteSerializer.f55920b, UShortSerializer.f55935b};
        Intrinsics.checkNotNullParameter(elements, "elements");
        f56103a = ArraysKt.H(elements);
    }

    public static final boolean a(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return serialDescriptor.isInline() && serialDescriptor.equals(JsonElementKt.f55977a);
    }

    public static final boolean b(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return serialDescriptor.isInline() && f56103a.contains(serialDescriptor);
    }
}
