package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = JsonElementSerializer.class)
/* loaded from: classes.dex */
public abstract class JsonElement {

    @NotNull
    public static final Companion Companion = new Companion();

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<JsonElement> serializer() {
            return JsonElementSerializer.f55978a;
        }
    }
}
