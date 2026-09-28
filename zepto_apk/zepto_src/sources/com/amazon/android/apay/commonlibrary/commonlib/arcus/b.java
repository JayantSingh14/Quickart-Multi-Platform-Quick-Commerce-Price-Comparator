package com.amazon.android.apay.commonlibrary.commonlib.arcus;

import android.content.Context;
import androidx.work.impl.WorkManagerImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final WorkManagerImpl f14864a;

    public b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WorkManagerImpl workManagerImplF = WorkManagerImpl.f(context);
        Intrinsics.checkNotNullExpressionValue(workManagerImplF, "getInstance(context)");
        this.f14864a = workManagerImplF;
    }
}
