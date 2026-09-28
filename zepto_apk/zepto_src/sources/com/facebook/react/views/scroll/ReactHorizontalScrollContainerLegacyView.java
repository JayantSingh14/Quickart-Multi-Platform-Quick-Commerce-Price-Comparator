package com.facebook.react.views.scroll;

import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ReactHorizontalScrollContainerLegacyView extends ReactViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20019a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactHorizontalScrollContainerLegacyView(ThemedReactContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f20019a = I18nUtil.b(context);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f20019a) {
            setLeft(0);
            setTop(i3);
            setRight(i4 - i2);
            setBottom(i5);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup
    public void setRemoveClippedSubviews(boolean z) {
        if (this.f20019a) {
            super.setRemoveClippedSubviews(false);
        } else {
            super.setRemoveClippedSubviews(z);
        }
    }
}
