package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonEncoder;

@Metadata
/* loaded from: classes.dex */
public final class JsonStreamsKt {
    public static final void a(Json json, JsonToStringWriter sb, KSerializer serializer, Object obj) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(sb, "writer");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        WriteMode mode = WriteMode.f56108c;
        JsonEncoder[] modeReuseCache = new JsonEncoder[((AbstractCollection) WriteMode.f56113h).b()];
        Intrinsics.checkNotNullParameter(sb, "output");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(modeReuseCache, "modeReuseCache");
        Intrinsics.checkNotNullParameter(sb, "sb");
        Intrinsics.checkNotNullParameter(json, "json");
        JsonConfiguration jsonConfiguration = json.f55945a;
        new StreamingJsonEncoder(new Composer(sb), json, mode, modeReuseCache).e(serializer, obj);
    }
}
