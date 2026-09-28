package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public final void a(int i2, int i3) {
    }

    public static final class SizeViewTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public final void b(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void g(Object obj, Transition transition) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void d() {
        }
    }
}
