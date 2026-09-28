package io.ktor.serialization.kotlinx.json;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonBuilder;

@Metadata
/* loaded from: classes.dex */
public final class JsonSupportKt$DefaultJson$1 extends Lambda implements Function1<JsonBuilder, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final JsonSupportKt$DefaultJson$1 f50386c = new JsonSupportKt$DefaultJson$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        JsonBuilder Json = (JsonBuilder) obj;
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.f55954a = true;
        Json.f55957d = true;
        Json.f55963j = true;
        Json.f55958e = true;
        return Unit.f53572a;
    }
}
