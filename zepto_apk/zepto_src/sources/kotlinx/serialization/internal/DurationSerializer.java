package kotlinx.serialization.internal;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.apache.commons.codec.language.Soundex;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class DurationSerializer implements KSerializer<Duration> {

    /* renamed from: a, reason: collision with root package name */
    public static final DurationSerializer f55803a = new DurationSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final PrimitiveSerialDescriptor f55804b = new PrimitiveSerialDescriptor("kotlin.time.Duration", PrimitiveKind.STRING.f55740a);

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55804b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Duration.Companion companion = Duration.f54014b;
        String value = decoder.y();
        companion.getClass();
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            return new Duration(DurationKt.a(value, true));
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(b.D("Invalid ISO duration string format: '", value, "'."), e2);
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        long j2;
        int iH;
        long j3 = ((Duration) obj).f54017a;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Duration.Companion companion = Duration.f54014b;
        StringBuilder sb = new StringBuilder();
        if (j3 < 0) {
            sb.append(Soundex.SILENT_MARKER);
        }
        sb.append("PT");
        long jL = j3 < 0 ? Duration.l(j3) : j3;
        long jH = Duration.h(jL, DurationUnit.f54024g);
        boolean z = false;
        if (Duration.e(jL)) {
            j2 = 0;
            iH = 0;
        } else {
            j2 = 0;
            iH = (int) (Duration.h(jL, DurationUnit.f54023f) % 60);
        }
        int iH2 = Duration.e(jL) ? 0 : (int) (Duration.h(jL, DurationUnit.f54022e) % 60);
        int iD = Duration.d(jL);
        if (Duration.e(j3)) {
            jH = 9999999999999L;
        }
        boolean z2 = jH != j2;
        boolean z3 = (iH2 == 0 && iD == 0) ? false : true;
        if (iH != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(jH);
            sb.append('H');
        }
        if (z) {
            sb.append(iH);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            Duration.b(sb, iH2, iD, 9, "S", true);
        }
        encoder.F(sb.toString());
    }
}
