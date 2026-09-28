package com.zeptoconsumerapp.performancemode.performanceClasses;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class NetworkPerformanceClass extends PerformanceClass<NetworkPerformanceResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f47784a;

    public NetworkPerformanceClass(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f47784a = context;
    }
}
