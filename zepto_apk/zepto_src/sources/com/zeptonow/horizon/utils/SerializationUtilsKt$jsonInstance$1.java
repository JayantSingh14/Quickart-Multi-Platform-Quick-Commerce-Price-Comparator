package com.zeptonow.horizon.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.modules.SerialModuleImpl;

@Metadata
/* loaded from: classes.dex */
public final class SerializationUtilsKt$jsonInstance$1 extends Lambda implements Function1<JsonBuilder, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final SerializationUtilsKt$jsonInstance$1 f48280c = new SerializationUtilsKt$jsonInstance$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        JsonBuilder Json = (JsonBuilder) obj;
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.f55957d = true;
        Json.f55956c = true;
        Json.f55955b = false;
        Json.f55960g = true;
        SerialModuleImpl serialModuleImpl = SerializationUtilsKt.f48278a;
        Intrinsics.checkNotNullParameter(serialModuleImpl, "<set-?>");
        Json.f55965l = serialModuleImpl;
        return Unit.f53572a;
    }
}
