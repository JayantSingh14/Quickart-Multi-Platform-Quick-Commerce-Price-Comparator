package kotlinx.serialization.json.internal;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.UStringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModule;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractJsonLexer f56039a;

    /* renamed from: b, reason: collision with root package name */
    public final SerialModuleImpl f56040b;

    public JsonDecoderForUnsignedTypes(AbstractJsonLexer lexer, Json json) {
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(json, "json");
        this.f56039a = lexer;
        this.f56040b = json.f55946b;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final byte D() {
        AbstractJsonLexer abstractJsonLexer = this.f56039a;
        String strK = abstractJsonLexer.k();
        try {
            return UStringsKt.a(strK);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.p(abstractJsonLexer, e.l('\'', "Failed to parse type 'UByte' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public final SerializersModule a() {
        return this.f56040b;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final int k() {
        AbstractJsonLexer abstractJsonLexer = this.f56039a;
        String strK = abstractJsonLexer.k();
        try {
            return UStringsKt.b(strK);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.p(abstractJsonLexer, e.l('\'', "Failed to parse type 'UInt' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final long m() {
        AbstractJsonLexer abstractJsonLexer = this.f56039a;
        String strK = abstractJsonLexer.k();
        try {
            return UStringsKt.d(strK);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.p(abstractJsonLexer, e.l('\'', "Failed to parse type 'ULong' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int o(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public final short r() {
        AbstractJsonLexer abstractJsonLexer = this.f56039a;
        String strK = abstractJsonLexer.k();
        try {
            return UStringsKt.f(strK);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.p(abstractJsonLexer, e.l('\'', "Failed to parse type 'UShort' for input '", strK), 0, null, 6);
            throw null;
        }
    }
}
