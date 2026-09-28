package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonNamingStrategy;

@Metadata
/* loaded from: classes3.dex */
public final class JsonNamingStrategy$Builtins$SnakeCase$1 implements JsonNamingStrategy {
    @Override // kotlinx.serialization.json.JsonNamingStrategy
    public final String a(SerialDescriptor descriptor, String serialName) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        return JsonNamingStrategy.Builtins.a(serialName, '_');
    }

    public final String toString() {
        return "kotlinx.serialization.json.JsonNamingStrategy.SnakeCase";
    }
}
