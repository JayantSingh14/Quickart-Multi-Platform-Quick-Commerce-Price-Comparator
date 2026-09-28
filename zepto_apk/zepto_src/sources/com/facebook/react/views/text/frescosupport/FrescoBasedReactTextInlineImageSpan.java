package com.facebook.react.views.text.frescosupport;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.TextView;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.fresco.ImageCacheControl;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.views.image.ImageResizeMode;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
class FrescoBasedReactTextInlineImageSpan extends TextInlineImageSpan {

    /* renamed from: b, reason: collision with root package name */
    public Drawable f20146b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractDraweeControllerBuilder f20147c;

    /* renamed from: d, reason: collision with root package name */
    public final DraweeHolder f20148d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f20149e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20150f;

    /* renamed from: g, reason: collision with root package name */
    public final int f20151g;

    /* renamed from: h, reason: collision with root package name */
    public final Uri f20152h;

    /* renamed from: i, reason: collision with root package name */
    public final int f20153i;

    /* renamed from: j, reason: collision with root package name */
    public final ReadableMap f20154j;

    /* renamed from: k, reason: collision with root package name */
    public final String f20155k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f20156l;

    public FrescoBasedReactTextInlineImageSpan(Resources resources, int i2, int i3, int i4, Uri uri, ReadableMap readableMap, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj, String str) {
        this.f20148d = new DraweeHolder(new GenericDraweeHierarchyBuilder(resources).a());
        this.f20147c = abstractDraweeControllerBuilder;
        this.f20149e = obj;
        this.f20151g = i4;
        this.f20152h = uri == null ? Uri.EMPTY : uri;
        this.f20154j = readableMap;
        this.f20153i = (int) PixelUtil.b(i3);
        this.f20150f = (int) PixelUtil.b(i2);
        this.f20155k = str;
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public final Drawable a() {
        return this.f20146b;
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public final int b() {
        return this.f20150f;
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public final void c() {
        this.f20148d.h();
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public final void d() {
        this.f20148d.i();
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        if (this.f20146b == null) {
            ImageRequestBuilder builder = ImageRequestBuilder.d(this.f20152h);
            Intrinsics.checkNotNullParameter(builder, "builder");
            ReactNetworkImageRequest reactNetworkImageRequestA = ReactNetworkImageRequest.Companion.a(builder, this.f20154j, ImageCacheControl.f19112a);
            DraweeHolder draweeHolder = this.f20148d;
            DraweeHierarchy draweeHierarchy = draweeHolder.f17450d;
            draweeHierarchy.getClass();
            ((GenericDraweeHierarchy) draweeHierarchy).n(ImageResizeMode.c(this.f20155k));
            AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.f20147c;
            abstractDraweeControllerBuilder.d();
            abstractDraweeControllerBuilder.f17270f = draweeHolder.f17451e;
            abstractDraweeControllerBuilder.f17265a = this.f20149e;
            abstractDraweeControllerBuilder.f17266b = reactNetworkImageRequestA;
            draweeHolder.m(abstractDraweeControllerBuilder.a());
            abstractDraweeControllerBuilder.d();
            Drawable drawableF = draweeHolder.f();
            this.f20146b = drawableF;
            drawableF.setBounds(0, 0, this.f20153i, this.f20150f);
            int i7 = this.f20151g;
            if (i7 != 0) {
                this.f20146b.setColorFilter(i7, PorterDuff.Mode.SRC_IN);
            }
            this.f20146b.setCallback(this.f20156l);
        }
        canvas.save();
        canvas.translate(f2, ((i5 + ((int) paint.descent())) - (((int) (paint.descent() - paint.ascent())) / 2)) - ((this.f20146b.getBounds().bottom - this.f20146b.getBounds().top) / 2));
        this.f20146b.draw(canvas);
        canvas.restore();
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public final void e() {
        this.f20148d.h();
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public final void f() {
        this.f20148d.i();
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public final void g(TextView textView) {
        this.f20156l = textView;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            int i4 = -this.f20150f;
            fontMetricsInt.ascent = i4;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i4;
            fontMetricsInt.bottom = 0;
        }
        return this.f20153i;
    }
}
