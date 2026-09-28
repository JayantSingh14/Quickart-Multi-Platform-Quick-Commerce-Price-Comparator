package kotlinx.serialization.json.internal;

import androidx.fragment.app.e;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.ChunkedDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.internal.JsonPath;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModule;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder, ChunkedDecoder {

    /* renamed from: a, reason: collision with root package name */
    public final Json f56086a;

    /* renamed from: b, reason: collision with root package name */
    public final WriteMode f56087b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractJsonLexer f56088c;

    /* renamed from: d, reason: collision with root package name */
    public final SerialModuleImpl f56089d;

    /* renamed from: e, reason: collision with root package name */
    public int f56090e;

    /* renamed from: f, reason: collision with root package name */
    public DiscriminatorHolder f56091f;

    /* renamed from: g, reason: collision with root package name */
    public final JsonConfiguration f56092g;

    /* renamed from: h, reason: collision with root package name */
    public final JsonElementMarker f56093h;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DiscriminatorHolder {

        /* renamed from: a, reason: collision with root package name */
        public String f56094a;

        public DiscriminatorHolder(String str) {
            this.f56094a = str;
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[WriteMode.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                WriteMode writeMode = WriteMode.f56108c;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                WriteMode writeMode2 = WriteMode.f56108c;
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                WriteMode writeMode3 = WriteMode.f56108c;
                iArr[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public StreamingJsonDecoder(Json json, WriteMode mode, AbstractJsonLexer lexer, SerialDescriptor descriptor, DiscriminatorHolder discriminatorHolder) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.f56086a = json;
        this.f56087b = mode;
        this.f56088c = lexer;
        this.f56089d = json.f55946b;
        this.f56090e = -1;
        this.f56091f = discriminatorHolder;
        JsonConfiguration jsonConfiguration = json.f55945a;
        this.f56092g = jsonConfiguration;
        this.f56093h = jsonConfiguration.f55970e ? null : new JsonElementMarker(descriptor);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean A() {
        JsonElementMarker jsonElementMarker = this.f56093h;
        return ((jsonElementMarker != null ? jsonElementMarker.f56042b : false) || this.f56088c.A(true)) ? false : true;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final byte D() {
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        long jI = abstractJsonLexer.i();
        byte b2 = (byte) jI;
        if (jI == b2) {
            return b2;
        }
        AbstractJsonLexer.p(abstractJsonLexer, "Failed to parse byte for input '" + jI + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public final SerializersModule a() {
        return this.f56089d;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final CompositeDecoder b(SerialDescriptor sd) {
        Intrinsics.checkNotNullParameter(sd, "descriptor");
        Json json = this.f56086a;
        WriteMode writeModeB = WriteModeKt.b(sd, json);
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        JsonPath jsonPath = abstractJsonLexer.f56007b;
        jsonPath.getClass();
        Intrinsics.checkNotNullParameter(sd, "sd");
        int i2 = jsonPath.f56050c + 1;
        jsonPath.f56050c = i2;
        Object[] objArr = jsonPath.f56048a;
        if (i2 == objArr.length) {
            int i3 = i2 * 2;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i3);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            jsonPath.f56048a = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(jsonPath.f56049b, i3);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            jsonPath.f56049b = iArrCopyOf;
        }
        jsonPath.f56048a[i2] = sd;
        abstractJsonLexer.h(writeModeB.f56114a);
        if (abstractJsonLexer.u() == 4) {
            AbstractJsonLexer.p(abstractJsonLexer, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        int iOrdinal = writeModeB.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
            return new StreamingJsonDecoder(this.f56086a, writeModeB, this.f56088c, sd, this.f56091f);
        }
        if (this.f56087b == writeModeB && json.f55945a.f55970e) {
            return this;
        }
        return new StreamingJsonDecoder(this.f56086a, writeModeB, this.f56088c, sd, this.f56091f);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public final void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.f56086a.f55945a.f55967b && descriptor.e() == 0) {
            while (o(descriptor) != -1) {
            }
        }
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        if (abstractJsonLexer.z()) {
            JsonExceptionsKt.e(abstractJsonLexer, "");
            throw null;
        }
        abstractJsonLexer.h(this.f56087b.f56115b);
        JsonPath jsonPath = abstractJsonLexer.f56007b;
        int i2 = jsonPath.f56050c;
        int[] iArr = jsonPath.f56049b;
        if (iArr[i2] == -2) {
            iArr[i2] = -1;
            jsonPath.f56050c = i2 - 1;
        }
        int i3 = jsonPath.f56050c;
        if (i3 != -1) {
            jsonPath.f56050c = i3 - 1;
        }
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final Json d() {
        return this.f56086a;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int g(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.d(enumDescriptor, this.f56086a, y(), " at path " + this.f56088c.f56007b.a());
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final JsonElement j() {
        return new JsonTreeReader(this.f56086a.f55945a, this.f56088c).b();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int k() {
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        long jI = abstractJsonLexer.i();
        int i2 = (int) jI;
        if (jI == i2) {
            return i2;
        }
        AbstractJsonLexer.p(abstractJsonLexer, "Failed to parse int for input '" + jI + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final long m() {
        return this.f56088c.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x010e, code lost:
    
        if (r11 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0110, code lost:
    
        r1 = r11.f56041a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0112, code lost:
    
        if (r9 >= 64) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0114, code lost:
    
        r1.f55808c |= 1 << r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x011b, code lost:
    
        r11 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x011e, code lost:
    
        r3 = (r9 >>> 6) - 1;
        r1 = r1.f55809d;
        r1[r3] = r1[r3] | (1 << (r9 & 63));
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x014a, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, "key");
        r4.o(kotlin.text.StringsKt.C(r4.y(0, r4.f56006a), r12, 0, 6), androidx.fragment.app.e.l('\'', "Encountered an unknown key '", r12), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0169, code lost:
    
        throw null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.encoding.CompositeDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int o(kotlinx.serialization.descriptors.SerialDescriptor r21) {
        /*
            Method dump skipped, instructions count: 684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonDecoder.o(kotlinx.serialization.descriptors.SerialDescriptor):int");
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final Decoder p(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (StreamingJsonEncoderKt.b(descriptor)) {
            return new JsonDecoderForUnsignedTypes(this.f56088c, this.f56086a);
        }
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final short r() {
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        long jI = abstractJsonLexer.i();
        short s = (short) jI;
        if (jI == s) {
            return s;
        }
        AbstractJsonLexer.p(abstractJsonLexer, "Failed to parse short for input '" + jI + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final float s() throws NumberFormatException {
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        String strK = abstractJsonLexer.k();
        try {
            float f2 = Float.parseFloat(strK);
            if (this.f56086a.f55945a.f55974i || !(Float.isInfinite(f2) || Float.isNaN(f2))) {
                return f2;
            }
            JsonExceptionsKt.h(abstractJsonLexer, Float.valueOf(f2));
            throw null;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.p(abstractJsonLexer, e.l('\'', "Failed to parse type 'float' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final double t() throws NumberFormatException {
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        String strK = abstractJsonLexer.k();
        try {
            double d2 = Double.parseDouble(strK);
            if (this.f56086a.f55945a.f55974i || !(Double.isInfinite(d2) || Double.isNaN(d2))) {
                return d2;
            }
            JsonExceptionsKt.h(abstractJsonLexer, Double.valueOf(d2));
            throw null;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.p(abstractJsonLexer, e.l('\'', "Failed to parse type 'double' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean u() {
        boolean z;
        boolean z2;
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        int iX = abstractJsonLexer.x();
        if (iX == abstractJsonLexer.s().length()) {
            AbstractJsonLexer.p(abstractJsonLexer, "EOF", 0, null, 6);
            throw null;
        }
        if (abstractJsonLexer.s().charAt(iX) == '\"') {
            iX++;
            z = true;
        } else {
            z = false;
        }
        int iW = abstractJsonLexer.w(iX);
        if (iW >= abstractJsonLexer.s().length() || iW == -1) {
            AbstractJsonLexer.p(abstractJsonLexer, "EOF", 0, null, 6);
            throw null;
        }
        int i2 = iW + 1;
        int iCharAt = abstractJsonLexer.s().charAt(iW) | ' ';
        if (iCharAt == 102) {
            abstractJsonLexer.d(i2, "alse");
            z2 = false;
        } else {
            if (iCharAt != 116) {
                AbstractJsonLexer.p(abstractJsonLexer, "Expected valid boolean literal prefix, but had '" + abstractJsonLexer.k() + '\'', 0, null, 6);
                throw null;
            }
            abstractJsonLexer.d(i2, "rue");
            z2 = true;
        }
        if (!z) {
            return z2;
        }
        if (abstractJsonLexer.f56006a == abstractJsonLexer.s().length()) {
            AbstractJsonLexer.p(abstractJsonLexer, "EOF", 0, null, 6);
            throw null;
        }
        if (abstractJsonLexer.s().charAt(abstractJsonLexer.f56006a) == '\"') {
            abstractJsonLexer.f56006a++;
            return z2;
        }
        AbstractJsonLexer.p(abstractJsonLexer, "Expected closing quotation mark", 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final char v() {
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        String strK = abstractJsonLexer.k();
        if (strK.length() == 1) {
            return strK.charAt(0);
        }
        AbstractJsonLexer.p(abstractJsonLexer, e.l('\'', "Expected single char, but got '", strK), 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final Object w(DeserializationStrategy deserializer) {
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        Json json = this.f56086a;
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        try {
            if (!(deserializer instanceof AbstractPolymorphicSerializer)) {
                return deserializer.b(this);
            }
            JsonConfiguration jsonConfiguration = json.f55945a;
            String strC = PolymorphicKt.c(deserializer.a(), json);
            String strT = abstractJsonLexer.t(strC, this.f56092g.f55968c);
            if (strT == null) {
                return PolymorphicKt.d(this, deserializer);
            }
            try {
                DeserializationStrategy deserializationStrategyA = PolymorphicSerializerKt.a((AbstractPolymorphicSerializer) deserializer, this, strT);
                this.f56091f = new DiscriminatorHolder(strC);
                return deserializationStrategyA.b(this);
            } catch (SerializationException e2) {
                String message = e2.getMessage();
                Intrinsics.c(message);
                String strG = StringsKt.G(StringsKt.U(message, '\n'), CLConstants.DOT_SALT_DELIMETER);
                String message2 = e2.getMessage();
                Intrinsics.c(message2);
                AbstractJsonLexer.p(abstractJsonLexer, strG, 0, StringsKt.R('\n', message2, ""), 2);
                throw null;
            }
        } catch (MissingFieldException e3) {
            String message3 = e3.getMessage();
            Intrinsics.c(message3);
            if (StringsKt.n(message3, "at path", false)) {
                throw e3;
            }
            throw new MissingFieldException(e3.f55693a, e3.getMessage() + " at path: " + abstractJsonLexer.f56007b.a(), e3);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public final Object x(SerialDescriptor descriptor, int i2, DeserializationStrategy deserializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        boolean z = this.f56087b == WriteMode.f56110e && (i2 & 1) == 0;
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        if (z) {
            JsonPath jsonPath = abstractJsonLexer.f56007b;
            int[] iArr = jsonPath.f56049b;
            int i3 = jsonPath.f56050c;
            if (iArr[i3] == -2) {
                jsonPath.f56048a[i3] = JsonPath.Tombstone.f56051a;
            }
        }
        Object objX = super.x(descriptor, i2, deserializer, obj);
        if (z) {
            JsonPath jsonPath2 = abstractJsonLexer.f56007b;
            int[] iArr2 = jsonPath2.f56049b;
            int i4 = jsonPath2.f56050c;
            if (iArr2[i4] != -2) {
                int i5 = i4 + 1;
                jsonPath2.f56050c = i5;
                Object[] objArr = jsonPath2.f56048a;
                if (i5 == objArr.length) {
                    int i6 = i5 * 2;
                    Object[] objArrCopyOf = Arrays.copyOf(objArr, i6);
                    Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                    jsonPath2.f56048a = objArrCopyOf;
                    int[] iArrCopyOf = Arrays.copyOf(jsonPath2.f56049b, i6);
                    Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
                    jsonPath2.f56049b = iArrCopyOf;
                }
            }
            Object[] objArr2 = jsonPath2.f56048a;
            int i7 = jsonPath2.f56050c;
            objArr2[i7] = objX;
            jsonPath2.f56049b[i7] = -2;
        }
        return objX;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final String y() {
        boolean z = this.f56092g.f55968c;
        AbstractJsonLexer abstractJsonLexer = this.f56088c;
        return z ? abstractJsonLexer.l() : abstractJsonLexer.j();
    }
}
