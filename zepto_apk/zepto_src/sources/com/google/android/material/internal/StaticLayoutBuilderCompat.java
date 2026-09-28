package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.api.Api;
import com.google.android.material.appbar.CollapsingToolbarLayout;

@RestrictTo
/* loaded from: classes4.dex */
final class StaticLayoutBuilderCompat {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f40627a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f40628b;

    /* renamed from: c, reason: collision with root package name */
    public final int f40629c;

    /* renamed from: d, reason: collision with root package name */
    public int f40630d;

    /* renamed from: k, reason: collision with root package name */
    public boolean f40637k;

    /* renamed from: m, reason: collision with root package name */
    public CollapsingToolbarLayout.StaticLayoutBuilderConfigurer f40639m;

    /* renamed from: e, reason: collision with root package name */
    public Layout.Alignment f40631e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public int f40632f = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: g, reason: collision with root package name */
    public float f40633g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f40634h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public int f40635i = 1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f40636j = true;

    /* renamed from: l, reason: collision with root package name */
    public TextUtils.TruncateAt f40638l = null;

    public static class StaticLayoutBuilderCompatException extends Exception {
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f40627a = charSequence;
        this.f40628b = textPaint;
        this.f40629c = i2;
        this.f40630d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f40627a == null) {
            this.f40627a = "";
        }
        int iMax = Math.max(0, this.f40629c);
        CharSequence charSequenceEllipsize = this.f40627a;
        int i2 = this.f40632f;
        TextPaint textPaint = this.f40628b;
        if (i2 == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f40638l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f40630d);
        this.f40630d = iMin;
        if (this.f40637k && this.f40632f == 1) {
            this.f40631e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.f40631e);
        builderObtain.setIncludePad(this.f40636j);
        builderObtain.setTextDirection(this.f40637k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f40638l;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f40632f);
        float f2 = this.f40633g;
        if (f2 != 0.0f || this.f40634h != 1.0f) {
            builderObtain.setLineSpacing(f2, this.f40634h);
        }
        if (this.f40632f > 1) {
            builderObtain.setHyphenationFrequency(this.f40635i);
        }
        CollapsingToolbarLayout.StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer = this.f40639m;
        if (staticLayoutBuilderConfigurer != null) {
            staticLayoutBuilderConfigurer.a();
        }
        return builderObtain.build();
    }
}
