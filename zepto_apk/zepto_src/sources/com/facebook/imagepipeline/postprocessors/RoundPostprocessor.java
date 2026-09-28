package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class RoundPostprocessor extends BasePostprocessor {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f18085c = true;

    /* renamed from: d, reason: collision with root package name */
    public final SimpleCacheKey f18086d = new SimpleCacheKey("XferRoundFilter");

    @JvmOverloads
    public RoundPostprocessor() {
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        return this.f18086d;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void e(Bitmap output, Bitmap source) {
        Paint paint;
        Paint paint2;
        Intrinsics.checkNotNullParameter(output, "destBitmap");
        Intrinsics.checkNotNullParameter(source, "sourceBitmap");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(source, "source");
        output.setHasAlpha(true);
        if (this.f18085c) {
            paint = new Paint(1);
            paint2 = new Paint(1);
        } else {
            paint = new Paint();
            paint2 = new Paint();
        }
        paint.setColor(-16777216);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        float width = source.getWidth() / 2.0f;
        float height = source.getHeight() / 2.0f;
        Canvas canvas = new Canvas(output);
        canvas.drawCircle(width, height, Math.min(width, height), paint);
        canvas.drawBitmap(source, 0.0f, 0.0f, paint2);
    }
}
