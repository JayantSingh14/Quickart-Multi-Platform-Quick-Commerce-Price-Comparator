package com.swmansion.rnscreens;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.ScreenFragment;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "RNSModule")
@Metadata
/* loaded from: classes.dex */
public final class ScreensModule extends NativeScreensModuleSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "RNSModule";

    @NotNull
    private final AtomicBoolean isActiveTransition;

    @Nullable
    private NativeProxy proxy;

    @NotNull
    private final ReactApplicationContext reactContext;
    private int topScreenId;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreensModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.topScreenId = -1;
        this.isActiveTransition = new AtomicBoolean(false);
        try {
            System.loadLibrary("rnscreens");
            JavaScriptContextHolder javaScriptContextHolder = getReactApplicationContext().getJavaScriptContextHolder();
            if (javaScriptContextHolder != null) {
                nativeInstall(javaScriptContextHolder.get());
            } else {
                Log.e("[RNScreens]", "Could not install JSI bindings.");
            }
        } catch (UnsatisfiedLinkError unused) {
            Log.w("[RNScreens]", "Could not load RNScreens module.");
        }
    }

    @DoNotStrip
    private final void finishTransition(Integer num, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (!this.isActiveTransition.get() || num == null) {
            Log.e("[RNScreens]", "Unable to call `finishTransition` method before transition start.");
            return;
        }
        UIManager uIManagerF = UIManagerHelper.f(this.reactContext, ViewUtil.a(num.intValue()), true);
        View viewResolveView = uIManagerF != null ? uIManagerF.resolveView(num.intValue()) : null;
        if (viewResolveView instanceof ScreenStack) {
            if (z) {
                ScreenStack screenStack = (ScreenStack) viewResolveView;
                ArrayList arrayList = screenStack.f46990a;
                if (arrayList.size() < 2) {
                    throw new RuntimeException("[RNScreens] Unable to run transition for less than 2 screens.");
                }
                FragmentTransaction fragmentTransactionB = screenStack.b();
                fragmentTransactionB.i(((ScreenFragmentWrapper) android.support.v4.media.b.c(2, arrayList)).j());
                fragmentTransactionB.f();
            } else {
                ScreenStack screenStack2 = (ScreenStack) viewResolveView;
                Screen topScreen = screenStack2.getTopScreen();
                Intrinsics.d(topScreen, "null cannot be cast to non-null type com.swmansion.rnscreens.Screen");
                if (screenStack2.getContext() instanceof ReactContext) {
                    int iD = UIManagerHelper.d(screenStack2.getContext());
                    Context context = screenStack2.getContext();
                    Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                    EventDispatcher eventDispatcherB = UIManagerHelper.b((ReactContext) context, topScreen.getId());
                    if (eventDispatcherB != null) {
                        eventDispatcherB.g(new ScreenDismissedEvent(iD, topScreen.getId()));
                    }
                }
            }
            this.isActiveTransition.set(false);
        }
        this.topScreenId = -1;
    }

    private final native void nativeInstall(long j2);

    private final native void nativeUninstall();

    @DoNotStrip
    private final int[] startTransition(Integer num) {
        ScreenStack screenStack;
        ArrayList<ScreenStackFragmentWrapper> fragments;
        int size;
        UiThreadUtil.assertOnUiThread();
        if (this.isActiveTransition.get() || num == null) {
            return new int[]{-1, -1};
        }
        this.topScreenId = -1;
        int[] iArr = {-1, -1};
        UIManager uIManagerF = UIManagerHelper.f(this.reactContext, ViewUtil.a(num.intValue()), true);
        View viewResolveView = uIManagerF != null ? uIManagerF.resolveView(num.intValue()) : null;
        if (!(viewResolveView instanceof ScreenStack) || (size = (fragments = (screenStack = (ScreenStack) viewResolveView).getFragments()).size()) <= 1) {
            return iArr;
        }
        this.isActiveTransition.set(true);
        ArrayList arrayList = screenStack.f46990a;
        if (arrayList.size() < 2) {
            throw new RuntimeException("[RNScreens] Unable to run transition for less than 2 screens.");
        }
        FragmentTransaction fragmentTransactionB = screenStack.b();
        Screen topScreen = screenStack.getTopScreen();
        Intrinsics.d(topScreen, "null cannot be cast to non-null type com.swmansion.rnscreens.Screen");
        Fragment fragment = topScreen.getFragment();
        Intrinsics.d(fragment, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        fragmentTransactionB.i(fragment);
        fragmentTransactionB.h(screenStack.getId(), ((ScreenFragmentWrapper) arrayList.get(arrayList.size() - 2)).j(), null, 1);
        Fragment fragment2 = topScreen.getFragment();
        Intrinsics.d(fragment2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        fragmentTransactionB.h(screenStack.getId(), fragment2, null, 1);
        fragmentTransactionB.f();
        int id = fragments.get(size - 1).k().getId();
        this.topScreenId = id;
        iArr[0] = id;
        iArr[1] = fragments.get(size - 2).k().getId();
        return iArr;
    }

    @DoNotStrip
    private final void updateTransition(double d2) {
        UiThreadUtil.assertOnUiThread();
        if (this.topScreenId == -1) {
            return;
        }
        float f2 = (float) d2;
        short sA = ScreenFragment.Companion.a(f2);
        EventDispatcher eventDispatcherB = UIManagerHelper.b(this.reactContext, this.topScreenId);
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new ScreenTransitionProgressEvent(UIManagerHelper.d(this.reactContext), this.topScreenId, f2, true, true, sA));
        }
    }

    @Override // com.swmansion.rnscreens.NativeScreensModuleSpec, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "RNSModule";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        nativeUninstall();
    }
}
