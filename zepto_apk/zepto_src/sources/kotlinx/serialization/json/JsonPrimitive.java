package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = JsonPrimitiveSerializer.class)
/* loaded from: classes.dex */
public abstract class JsonPrimitive extends JsonElement {

    @NotNull
    public static final Companion Companion = new Companion();

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<JsonPrimitive> serializer() {
            return JsonPrimitiveSerializer.f56004a;
        }
    }

    public abstract String b();

    public abstract boolean d();

    public String toString() {
        return b();
    }
}
