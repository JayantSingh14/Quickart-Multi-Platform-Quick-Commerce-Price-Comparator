package com.facebook.react.views.debuggingoverlay;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class TraceUpdate {

    /* renamed from: a, reason: collision with root package name */
    public final int f19931a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f19932b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19933c;

    public TraceUpdate(int i2, RectF rectangle, int i3) {
        Intrinsics.checkNotNullParameter(rectangle, "rectangle");
        this.f19931a = i2;
        this.f19932b = rectangle;
        this.f19933c = i3;
    }
}
