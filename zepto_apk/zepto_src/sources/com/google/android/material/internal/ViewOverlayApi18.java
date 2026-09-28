package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes4.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {

    /* renamed from: a, reason: collision with root package name */
    public final ViewOverlay f40653a;

    public ViewOverlayApi18(View view) {
        this.f40653a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public final void a(Drawable drawable) {
        this.f40653a.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public final void b(Drawable drawable) {
        this.f40653a.remove(drawable);
    }
}
