package com.swmansion.rnscreens.bottomsheet;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.swmansion.rnscreens.InsetsObserverProxy;
import com.swmansion.rnscreens.KeyboardDidHide;
import com.swmansion.rnscreens.KeyboardNotVisible;
import com.swmansion.rnscreens.KeyboardState;
import com.swmansion.rnscreens.KeyboardVisible;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenStackFragment;
import com.swmansion.rnscreens.events.SheetDetentChangedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class SheetDelegate implements LifecycleEventObserver, OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final Screen f47100a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f47101b;

    /* renamed from: c, reason: collision with root package name */
    public KeyboardState f47102c;

    /* renamed from: d, reason: collision with root package name */
    public int f47103d;

    /* renamed from: e, reason: collision with root package name */
    public final SheetStateObserver f47104e;

    /* renamed from: f, reason: collision with root package name */
    public final KeyboardHandler f47105f;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class KeyboardHandler extends BottomSheetBehavior.BottomSheetCallback {
        public KeyboardHandler() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View bottomSheet, float f2) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View bottomSheet, int i2) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (i2 == 4 && WindowInsetsCompat.r(null, bottomSheet.getRootWindowInsets()).o(8)) {
                bottomSheet.requestFocus();
                ((InputMethodManager) SheetDelegate.this.f47100a.getReactContext().getSystemService(InputMethodManager.class)).hideSoftInputFromWindow(bottomSheet.getWindowToken(), 0);
            }
        }
    }

    @Metadata
    public final class SheetStateObserver extends BottomSheetBehavior.BottomSheetCallback {
        public SheetStateObserver() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View bottomSheet, float f2) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View bottomSheet, int i2) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            SheetDelegate sheetDelegate = SheetDelegate.this;
            sheetDelegate.getClass();
            int i3 = 1;
            boolean z = i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6;
            Screen screen = sheetDelegate.f47100a;
            if (z) {
                int size = screen.getSheetDetents().size();
                if (size == 1) {
                    if (i2 != 3) {
                        if (i2 != 5) {
                            throw new IllegalArgumentException(android.support.v4.media.b.d(i2, size, "[RNScreens] Invalid state ", " for detentCount "));
                        }
                        i3 = -1;
                    }
                    i3 = 0;
                } else if (size != 2) {
                    if (size != 3) {
                        throw new IllegalArgumentException(android.support.v4.media.b.d(i2, size, "[RNScreens] Invalid state ", " for detentCount "));
                    }
                    if (i2 == 3) {
                        i3 = 2;
                    } else if (i2 == 4) {
                        i3 = 0;
                    } else if (i2 == 5) {
                        i3 = -1;
                    } else if (i2 != 6) {
                        throw new IllegalArgumentException(android.support.v4.media.b.d(i2, size, "[RNScreens] Invalid state ", " for detentCount "));
                    }
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            throw new IllegalArgumentException(android.support.v4.media.b.d(i2, size, "[RNScreens] Invalid state ", " for detentCount "));
                        }
                        i3 = -1;
                    }
                    i3 = 0;
                }
                sheetDelegate.f47103d = i3;
            }
            int i4 = sheetDelegate.f47103d;
            int iD = UIManagerHelper.d(screen.f46936a);
            EventDispatcher reactEventDispatcher = screen.getReactEventDispatcher();
            if (reactEventDispatcher != null) {
                reactEventDispatcher.g(new SheetDetentChangedEvent(iD, screen.getId(), i4, z));
            }
            if (i2 == 5) {
                Fragment fragment = screen.getFragment();
                Intrinsics.d(fragment, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragment");
                ((ScreenStackFragment) fragment).E();
            }
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47108a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f47108a = iArr;
        }
    }

    public SheetDelegate(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.f47100a = screen;
        this.f47102c = KeyboardNotVisible.f46934a;
        this.f47103d = screen.getSheetInitialDetentIndex();
        SheetUtils.a(screen.getSheetInitialDetentIndex(), screen.getSheetDetents().size());
        SheetStateObserver sheetStateObserver = new SheetStateObserver();
        this.f47104e = sheetStateObserver;
        this.f47105f = new KeyboardHandler();
        boolean z = screen.getFragment() instanceof ScreenStackFragment;
        Fragment fragment = screen.getFragment();
        Intrinsics.c(fragment);
        fragment.getLifecycle().a(this);
        BottomSheetBehavior<Screen> sheetBehavior = screen.getSheetBehavior();
        if (sheetBehavior == null) {
            throw new IllegalStateException("[RNScreens] Sheet delegate accepts screen with initialized sheet behaviour only.");
        }
        sheetBehavior.y(sheetStateObserver);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(com.swmansion.rnscreens.bottomsheet.SheetDelegate r10, com.google.android.material.bottomsheet.BottomSheetBehavior r11, com.swmansion.rnscreens.KeyboardState r12, int r13) {
        /*
            Method dump skipped, instructions count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.bottomsheet.SheetDelegate.c(com.swmansion.rnscreens.bottomsheet.SheetDelegate, com.google.android.material.bottomsheet.BottomSheetBehavior, com.swmansion.rnscreens.KeyboardState, int):void");
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void a(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i2 = WhenMappings.f47108a[event.ordinal()];
        if (i2 == 1) {
            InsetsObserverProxy insetsObserverProxy = InsetsObserverProxy.f46927a;
            Activity currentActivity = this.f47100a.getReactContext().f19479a.getCurrentActivity();
            if (currentActivity == null) {
                throw new IllegalStateException("[RNScreens] Attempt to access activity on detached context");
            }
            View decorView = currentActivity.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            insetsObserverProxy.a(decorView);
            return;
        }
        if (i2 == 2) {
            InsetsObserverProxy insetsObserverProxy2 = InsetsObserverProxy.f46927a;
            Intrinsics.checkNotNullParameter(this, "listener");
            InsetsObserverProxy.f46928b.add(this);
        } else {
            if (i2 != 3) {
                return;
            }
            InsetsObserverProxy insetsObserverProxy3 = InsetsObserverProxy.f46927a;
            Intrinsics.checkNotNullParameter(this, "listener");
            InsetsObserverProxy.f46928b.remove(this);
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat b(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        boolean zO = insets.o(8);
        Insets insetsD = insets.d(8);
        Intrinsics.checkNotNullExpressionValue(insetsD, "getInsets(...)");
        Screen screen = this.f47100a;
        if (zO) {
            this.f47101b = true;
            int i2 = insetsD.f2811d;
            this.f47102c = new KeyboardVisible();
            BottomSheetBehavior<Screen> sheetBehavior = screen.getSheetBehavior();
            if (sheetBehavior != null) {
                c(this, sheetBehavior, this.f47102c, 4);
            }
            Insets insetsD2 = insets.d(2);
            Intrinsics.checkNotNullExpressionValue(insetsD2, "getInsets(...)");
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(insets);
            builder.b(2, Insets.c(insetsD2.f2808a, insetsD2.f2809b, insetsD2.f2810c, 0));
            WindowInsetsCompat windowInsetsCompatA = builder.a();
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatA, "build(...)");
            return windowInsetsCompatA;
        }
        BottomSheetBehavior<Screen> sheetBehavior2 = screen.getSheetBehavior();
        KeyboardNotVisible keyboardNotVisible = KeyboardNotVisible.f46934a;
        if (sheetBehavior2 != null) {
            if (this.f47101b) {
                c(this, sheetBehavior2, KeyboardDidHide.f46933a, 4);
            } else if (!this.f47102c.equals(keyboardNotVisible)) {
                c(this, sheetBehavior2, keyboardNotVisible, 4);
            }
        }
        this.f47102c = keyboardNotVisible;
        this.f47101b = false;
        Insets insetsD3 = insets.d(2);
        Intrinsics.checkNotNullExpressionValue(insetsD3, "getInsets(...)");
        WindowInsetsCompat.Builder builder2 = new WindowInsetsCompat.Builder(insets);
        builder2.b(2, Insets.c(insetsD3.f2808a, insetsD3.f2809b, insetsD3.f2810c, 0));
        WindowInsetsCompat windowInsetsCompatA2 = builder2.a();
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatA2, "build(...)");
        return windowInsetsCompatA2;
    }
}
