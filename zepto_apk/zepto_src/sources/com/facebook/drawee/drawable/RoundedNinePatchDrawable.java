package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class RoundedNinePatchDrawable extends RoundedDrawable {
    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        FrescoSystrace.a();
        if (!this.f17365b && !this.f17366c && this.f17367d <= 0.0f) {
            super.draw(canvas);
            FrescoSystrace.a();
            return;
        }
        d();
        a();
        canvas.clipPath(this.f17368e);
        super.draw(canvas);
        FrescoSystrace.a();
    }
}
