package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ImageLoadingTimeControllerListener extends BaseControllerListener<Object> {

    /* renamed from: b, reason: collision with root package name */
    public final DebugControllerOverlayDrawable f17294b;

    /* renamed from: c, reason: collision with root package name */
    public long f17295c = -1;

    public ImageLoadingTimeControllerListener(DebugControllerOverlayDrawable debugControllerOverlayDrawable) {
        this.f17294b = debugControllerOverlayDrawable;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void l(String id, Object obj, Animatable animatable) {
        Intrinsics.checkNotNullParameter(id, "id");
        long jCurrentTimeMillis = System.currentTimeMillis();
        DebugControllerOverlayDrawable debugControllerOverlayDrawable = this.f17294b;
        if (debugControllerOverlayDrawable != null) {
            debugControllerOverlayDrawable.s = jCurrentTimeMillis - this.f17295c;
            debugControllerOverlayDrawable.invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void n(Object obj, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.f17295c = System.currentTimeMillis();
    }
}
