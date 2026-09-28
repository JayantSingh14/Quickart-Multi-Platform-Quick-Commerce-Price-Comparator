package com.facebook.react.views.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ForwardingDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class ReactImageDownloadListener<INFO> extends ForwardingDrawable implements ControllerListener<INFO> {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class EmptyDrawable extends Drawable {
        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i2) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public ReactImageDownloadListener() {
        super(new EmptyDrawable());
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void a(Object obj, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void e(String id, Throwable throwable) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void f(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void l(String id, Object obj, Animatable animatable) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void n(Object obj, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        v(i2);
        return super.onLevelChange(i2);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void q(String id, Throwable throwable) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    public void v(int i2) {
    }
}
