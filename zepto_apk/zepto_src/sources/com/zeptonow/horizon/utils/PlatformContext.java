package com.zeptonow.horizon.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class PlatformContext {

    /* renamed from: a, reason: collision with root package name */
    public final Context f48274a;

    public PlatformContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f48274a = context;
    }
}
