package com.chuckerteam.chucker.internal.support;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class JsonConverter {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f16772a = LazyKt.b(new coil3.decode.b(3));

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f16773b = LazyKt.b(new coil3.decode.b(4));

    public static Gson a() {
        Object value = f16773b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Gson) value;
    }
}
