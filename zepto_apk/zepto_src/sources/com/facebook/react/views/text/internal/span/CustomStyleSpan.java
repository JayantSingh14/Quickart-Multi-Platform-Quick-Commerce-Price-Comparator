package com.facebook.react.views.text.internal.span;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.facebook.react.views.text.ReactTypefaceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class CustomStyleSpan extends MetricAffectingSpan implements ReactSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f20159a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20160b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20161c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20162d;

    /* renamed from: e, reason: collision with root package name */
    public final AssetManager f20163e;

    @Metadata
    public static final class Companion {
    }

    public CustomStyleSpan(int i2, int i3, String str, String str2, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        this.f20159a = i2;
        this.f20160b = i3;
        this.f20161c = str;
        this.f20162d = str2;
        this.f20163e = assetManager;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        Typeface typefaceA = ReactTypefaceUtils.a(ds.getTypeface(), this.f20159a, this.f20160b, this.f20162d, this.f20163e);
        ds.setFontFeatureSettings(this.f20161c);
        ds.setTypeface(typefaceA);
        ds.setSubpixelText(true);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Typeface typefaceA = ReactTypefaceUtils.a(paint.getTypeface(), this.f20159a, this.f20160b, this.f20162d, this.f20163e);
        paint.setFontFeatureSettings(this.f20161c);
        paint.setTypeface(typefaceA);
        paint.setSubpixelText(true);
    }
}
