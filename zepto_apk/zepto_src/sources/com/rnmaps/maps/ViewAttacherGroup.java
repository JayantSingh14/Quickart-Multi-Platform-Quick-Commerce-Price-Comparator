package com.rnmaps.maps;

import android.graphics.Rect;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;

/* loaded from: classes4.dex */
public class ViewAttacherGroup extends ReactViewGroup {
    public ViewAttacherGroup(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        setWillNotDraw(true);
        setVisibility(0);
        setAlpha(0.0f);
        setRemoveClippedSubviews(false);
        setClipBounds(new Rect(0, 0, 0, 0));
        setOverflow("hidden");
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public final boolean hasOverlappingRendering() {
        return false;
    }
}
