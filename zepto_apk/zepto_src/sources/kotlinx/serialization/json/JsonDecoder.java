package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

@Metadata
/* loaded from: classes.dex */
public interface JsonDecoder extends Decoder, CompositeDecoder {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    Json d();

    JsonElement j();
}
