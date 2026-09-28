package com.facebook.react.views.text.internal.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ViewGroupClickEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReactClickableSpan extends ClickableSpan implements ReactSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f20164a;

    public ReactClickableSpan(int i2) {
        this.f20164a = i2;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int i2 = this.f20164a;
        EventDispatcher eventDispatcherB = UIManagerHelper.b(reactContext, i2);
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new ViewGroupClickEvent(UIManagerHelper.d(reactContext), i2));
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
    }
}
