package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewParent;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class JSResponderHandler implements OnInterceptTouchEventListener {

    /* renamed from: a, reason: collision with root package name */
    public volatile int f19366a = -1;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f19367b;

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.touch.OnInterceptTouchEventListener
    public final boolean a(ReactViewGroup view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        int i2 = this.f19366a;
        return (i2 == -1 || event.getAction() == 1 || view.getId() != i2) ? false : true;
    }

    public final void b(int i2, ViewParent viewParent) {
        this.f19366a = i2;
        ViewParent viewParent2 = this.f19367b;
        if (viewParent2 != null) {
            viewParent2.requestDisallowInterceptTouchEvent(false);
        }
        this.f19367b = null;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
            this.f19367b = viewParent;
        }
    }
}
