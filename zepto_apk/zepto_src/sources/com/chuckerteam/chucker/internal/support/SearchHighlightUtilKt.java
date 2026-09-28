package com.chuckerteam.chucker.internal.support;

import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SearchHighlightUtilKt {
    public static final void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5) {
        int i6 = i3 + i2;
        spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i6, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i2, i6, 33);
        spannableStringBuilder.setSpan(new BackgroundColorSpan(i4), i2, i6, 33);
    }
}
