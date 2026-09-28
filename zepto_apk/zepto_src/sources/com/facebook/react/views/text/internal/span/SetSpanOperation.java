package com.facebook.react.views.text.internal.span;

import android.text.SpannableStringBuilder;
import com.facebook.common.logging.FLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SetSpanOperation {

    /* renamed from: a, reason: collision with root package name */
    public final int f20168a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20169b;

    /* renamed from: c, reason: collision with root package name */
    public final ReactSpan f20170c;

    @Metadata
    public static final class Companion {
    }

    public SetSpanOperation(int i2, int i3, ReactSpan what) {
        Intrinsics.checkNotNullParameter(what, "what");
        this.f20168a = i2;
        this.f20169b = i3;
        this.f20170c = what;
    }

    public final void a(SpannableStringBuilder builder, int i2) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (i2 < 0) {
            throw new IllegalStateException("Check failed.");
        }
        int i3 = this.f20168a;
        int i4 = i3 == 0 ? 18 : 34;
        int i5 = 255 - i2;
        if (i5 < 0) {
            FLog.q("SetSpanOperation", "Text tree size exceeded the limit, styling may become unpredictable");
        }
        builder.setSpan(this.f20170c, i3, this.f20169b, ((Math.max(i5, 0) << 16) & 16711680) | (i4 & (-16711681)));
    }
}
