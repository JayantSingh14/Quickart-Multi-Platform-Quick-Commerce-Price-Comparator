package com.th3rdwave.safeareacontext;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class SafeAreaProvider extends ReactViewGroup implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public Function3 f47164a;

    /* renamed from: b, reason: collision with root package name */
    public EdgeInsets f47165b;

    /* renamed from: c, reason: collision with root package name */
    public Rect f47166c;

    public final void j() {
        EdgeInsets edgeInsetsB;
        Function3 function3 = this.f47164a;
        if (function3 == null || (edgeInsetsB = SafeAreaUtilsKt.b(this)) == null) {
            return;
        }
        View rootView = getRootView();
        Intrinsics.d(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        Rect rectA = SafeAreaUtilsKt.a(this, (ViewGroup) rootView);
        if (rectA == null) {
            return;
        }
        if (Intrinsics.b(this.f47165b, edgeInsetsB) && Intrinsics.b(this.f47166c, rectA)) {
            return;
        }
        function3.invoke(this, edgeInsetsB, rectA);
        this.f47165b = edgeInsetsB;
        this.f47166c = rectA;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        j();
        return true;
    }

    public final void setOnInsetsChangeHandler(@Nullable Function3<? super SafeAreaProvider, ? super EdgeInsets, ? super Rect, Unit> function3) {
        this.f47164a = function3;
        j();
    }
}
