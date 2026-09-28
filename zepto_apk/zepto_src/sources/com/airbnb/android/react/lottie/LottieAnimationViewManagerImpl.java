package com.airbnb.android.react.lottie;

import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class LottieAnimationViewManagerImpl {
    public static final void a(LottieAnimationView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ThemedReactContext themedReactContext = (ThemedReactContext) context;
        EventDispatcher eventDispatcherB = UIManagerHelper.b(themedReactContext, view.getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new OnAnimationFinishEvent(themedReactContext.f19481c, view.getId(), z));
        }
    }
}
