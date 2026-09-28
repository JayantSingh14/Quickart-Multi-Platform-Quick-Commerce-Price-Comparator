package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

@Metadata
/* loaded from: classes3.dex */
public final class TreeJsonEncoderKt {
    public static final JsonElement a(Json json, Object obj) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(null, "serializer");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        new JsonTreeEncoder(json, new Function1<JsonElement, Unit>() { // from class: kotlinx.serialization.json.internal.TreeJsonEncoderKt$writeJson$encoder$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                JsonElement it = (JsonElement) obj2;
                Intrinsics.checkNotNullParameter(it, "it");
                objectRef.f53801a = it;
                return Unit.f53572a;
            }
        }).e(null, obj);
        throw null;
    }
}
