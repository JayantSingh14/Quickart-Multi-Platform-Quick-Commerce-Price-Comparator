package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
/* loaded from: classes.dex */
public interface JsonEncoder extends Encoder, CompositeEncoder {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    Json d();

    void z(JsonElement jsonElement);
}
