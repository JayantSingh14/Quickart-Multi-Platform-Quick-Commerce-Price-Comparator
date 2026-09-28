package com.chuckerteam.chucker.api;

import android.content.Context;
import android.content.Intent;
import com.chuckerteam.chucker.internal.ui.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Chucker {

    /* renamed from: a, reason: collision with root package name */
    public static final Chucker$logger$1 f16595a = new Chucker$logger$1();

    public static final Intent a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent flags = new Intent(context, (Class<?>) MainActivity.class).setFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(flags, "setFlags(...)");
        return flags;
    }
}
