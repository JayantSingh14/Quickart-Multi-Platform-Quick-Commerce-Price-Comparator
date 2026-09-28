package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class ScreenContentWrapper extends ReactViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public OnLayoutCallback f46998a;

    @Metadata
    public interface OnLayoutCallback {
        void a(int i2, int i3);
    }

    @Nullable
    public final OnLayoutCallback getDelegate$react_native_screens_release() {
        return this.f46998a;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        OnLayoutCallback onLayoutCallback = this.f46998a;
        if (onLayoutCallback != null) {
            onLayoutCallback.a(i3, i5);
        }
    }

    public final void setDelegate$react_native_screens_release(@Nullable OnLayoutCallback onLayoutCallback) {
        this.f46998a = onLayoutCallback;
    }
}
