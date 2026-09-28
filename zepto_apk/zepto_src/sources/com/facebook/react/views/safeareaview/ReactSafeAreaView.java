package com.facebook.react.views.safeareaview;

import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ReactSafeAreaView extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f19998c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ThemedReactContext f19999a;

    /* renamed from: b, reason: collision with root package name */
    public StateWrapper f20000b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactSafeAreaView(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.f19999a = reactContext;
    }

    @NotNull
    public final ThemedReactContext getReactContext() {
        return this.f19999a;
    }

    @Nullable
    public final StateWrapper getStateWrapper$ReactAndroid_release() {
        return this.f20000b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.H(this, new a(this, 0));
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    public final void setStateWrapper$ReactAndroid_release(@Nullable StateWrapper stateWrapper) {
        this.f20000b = stateWrapper;
    }
}
