package com.facebook.react.views.modal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.common.ContextUtils;
import com.facebook.react.views.modal.ReactModalHostView;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.WindowUtilKt;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;
import org.xbill.DNS.KEYRecord;

@Metadata
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReactModalHostView extends ViewGroup implements LifecycleEventListener {

    /* renamed from: a, reason: collision with root package name */
    public Dialog f19972a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19973b;

    /* renamed from: c, reason: collision with root package name */
    public DialogInterface.OnShowListener f19974c;

    /* renamed from: d, reason: collision with root package name */
    public OnRequestCloseListener f19975d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19976e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19977f;

    /* renamed from: g, reason: collision with root package name */
    public String f19978g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f19979h;

    /* renamed from: i, reason: collision with root package name */
    public final DialogRootViewGroup f19980i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f19981j;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class DialogRootViewGroup extends ReactViewGroup implements RootView {

        /* renamed from: a, reason: collision with root package name */
        public StateWrapper f19982a;

        /* renamed from: b, reason: collision with root package name */
        public EventDispatcher f19983b;

        /* renamed from: c, reason: collision with root package name */
        public int f19984c;

        /* renamed from: d, reason: collision with root package name */
        public int f19985d;

        /* renamed from: e, reason: collision with root package name */
        public final JSTouchDispatcher f19986e;

        /* renamed from: f, reason: collision with root package name */
        public final JSPointerDispatcher f19987f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DialogRootViewGroup(ThemedReactContext context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f19986e = new JSTouchDispatcher(this);
            if (ReactFeatureFlags.dispatchPointerEvents) {
                this.f19987f = new JSPointerDispatcher(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ThemedReactContext getReactContext() {
            Context context = getContext();
            Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
            return (ThemedReactContext) context;
        }

        @Override // com.facebook.react.uimanager.RootView
        public final void a(View view, MotionEvent ev) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            EventDispatcher eventDispatcher = this.f19983b;
            if (eventDispatcher != null) {
                this.f19986e.c(ev, eventDispatcher);
                JSPointerDispatcher jSPointerDispatcher = this.f19987f;
                if (jSPointerDispatcher != null) {
                    jSPointerDispatcher.g(view, ev, eventDispatcher);
                }
            }
        }

        @Override // com.facebook.react.uimanager.RootView
        public final void d(ViewGroup childView, MotionEvent ev) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            Intrinsics.checkNotNullParameter(ev, "ev");
            if (this.f19983b != null) {
                this.f19986e.f19384c = false;
            }
            JSPointerDispatcher jSPointerDispatcher = this.f19987f;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.f19377e = -1;
            }
        }

        @Nullable
        public final EventDispatcher getEventDispatcher$ReactAndroid_release() {
            return this.f19983b;
        }

        @Nullable
        public final StateWrapper getStateWrapper$ReactAndroid_release() {
            return this.f19982a;
        }

        @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
        public final boolean onHoverEvent(MotionEvent event) {
            JSPointerDispatcher jSPointerDispatcher;
            Intrinsics.checkNotNullParameter(event, "event");
            EventDispatcher eventDispatcher = this.f19983b;
            if (eventDispatcher != null && (jSPointerDispatcher = this.f19987f) != null) {
                jSPointerDispatcher.d(event, eventDispatcher, false);
            }
            return super.onHoverEvent(event);
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(info);
            String str = (String) getTag(R.id.react_test_id);
            if (str != null) {
                info.setViewIdResourceName(str);
            }
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptHoverEvent(MotionEvent event) {
            JSPointerDispatcher jSPointerDispatcher;
            Intrinsics.checkNotNullParameter(event, "event");
            EventDispatcher eventDispatcher = this.f19983b;
            if (eventDispatcher != null && (jSPointerDispatcher = this.f19987f) != null) {
                jSPointerDispatcher.d(event, eventDispatcher, true);
            }
            return super.onHoverEvent(event);
        }

        @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            EventDispatcher eventDispatcher = this.f19983b;
            if (eventDispatcher != null) {
                this.f19986e.b(event, eventDispatcher, getReactContext());
                JSPointerDispatcher jSPointerDispatcher = this.f19987f;
                if (jSPointerDispatcher != null) {
                    jSPointerDispatcher.d(event, eventDispatcher, true);
                }
            }
            return super.onInterceptTouchEvent(event);
        }

        @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
        public final void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f19984c = i2;
            this.f19985d = i3;
            float fA = PixelUtil.a(i2);
            float fA2 = PixelUtil.a(i3);
            StateWrapper stateWrapper = this.f19982a;
            if (stateWrapper == null) {
                ThemedReactContext reactContext = getReactContext();
                final ThemedReactContext reactContext2 = getReactContext();
                reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext2) { // from class: com.facebook.react.views.modal.ReactModalHostView$DialogRootViewGroup$updateState$2$1
                    @Override // com.facebook.react.bridge.GuardedRunnable
                    public final void runGuarded() {
                        ReactModalHostView.DialogRootViewGroup dialogRootViewGroup = this.f19988a;
                        UIManagerModule uIManagerModule = (UIManagerModule) dialogRootViewGroup.getReactContext().f19479a.getNativeModule(UIManagerModule.class);
                        if (uIManagerModule != null) {
                            uIManagerModule.updateNodeSize(dialogRootViewGroup.getId(), dialogRootViewGroup.f19984c, dialogRootViewGroup.f19985d);
                        }
                    }
                });
            } else {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putDouble("screenWidth", fA);
                writableNativeMap.putDouble("screenHeight", fA2);
                stateWrapper.updateState(writableNativeMap);
            }
        }

        @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
        public final boolean onTouchEvent(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            EventDispatcher eventDispatcher = this.f19983b;
            if (eventDispatcher != null) {
                this.f19986e.b(event, eventDispatcher, getReactContext());
                JSPointerDispatcher jSPointerDispatcher = this.f19987f;
                if (jSPointerDispatcher != null) {
                    jSPointerDispatcher.d(event, eventDispatcher, false);
                }
            }
            super.onTouchEvent(event);
            return true;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public final void requestDisallowInterceptTouchEvent(boolean z) {
        }

        public final void setEventDispatcher$ReactAndroid_release(@Nullable EventDispatcher eventDispatcher) {
            this.f19983b = eventDispatcher;
        }

        public final void setStateWrapper$ReactAndroid_release(@Nullable StateWrapper stateWrapper) {
            this.f19982a = stateWrapper;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface OnRequestCloseListener {
        void a(DialogInterface dialogInterface);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactModalHostView(ThemedReactContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f19980i = new DialogRootViewGroup(context);
    }

    private final View getContentView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.f19980i);
        if (!this.f19976e) {
            frameLayout.setFitsSystemWindows(true);
        }
        return frameLayout;
    }

    private final Activity getCurrentActivity() {
        Context context = getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        return ((ThemedReactContext) context).f19479a.getCurrentActivity();
    }

    public final void a() {
        Activity activity;
        UiThreadUtil.assertOnUiThread();
        Dialog dialog = this.f19972a;
        if (dialog != null) {
            if (dialog.isShowing() && ((activity = (Activity) ContextUtils.a(dialog.getContext())) == null || !activity.isFinishing())) {
                dialog.dismiss();
            }
            this.f19972a = null;
            this.f19981j = true;
            ViewParent parent = this.f19980i.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeViewAt(0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addChildrenForAccessibility(ArrayList outChildren) {
        Intrinsics.checkNotNullParameter(outChildren, "outChildren");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2) {
        UiThreadUtil.assertOnUiThread();
        this.f19980i.addView(view, i2);
    }

    public final void b() {
        Context context = getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ((ThemedReactContext) context).removeLifecycleEventListener(this);
        a();
    }

    public final void c() {
        Window window;
        Window window2;
        UiThreadUtil.assertOnUiThread();
        if (!this.f19981j) {
            d();
            return;
        }
        a();
        this.f19981j = false;
        String str = this.f19978g;
        int i2 = Intrinsics.b(str, "fade") ? R.style.Theme_FullScreenDialogAnimatedFade : Intrinsics.b(str, "slide") ? R.style.Theme_FullScreenDialogAnimatedSlide : R.style.Theme_FullScreenDialog;
        Activity currentActivity = getCurrentActivity();
        Dialog dialog = new Dialog(currentActivity != null ? currentActivity : getContext(), i2);
        this.f19972a = dialog;
        Window window3 = dialog.getWindow();
        Objects.requireNonNull(window3);
        window3.setFlags(8, 8);
        dialog.setContentView(getContentView());
        d();
        dialog.setOnShowListener(this.f19974c);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.facebook.react.views.modal.ReactModalHostView$showOrUpdate$1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialog2, int i3, KeyEvent event) {
                Intrinsics.checkNotNullParameter(dialog2, "dialog");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.getAction() != 1) {
                    return false;
                }
                ReactModalHostView reactModalHostView = this.f19989a;
                if (i3 == 4 || i3 == 111) {
                    ReactModalHostView.OnRequestCloseListener onRequestCloseListener = reactModalHostView.getOnRequestCloseListener();
                    if (onRequestCloseListener == null) {
                        throw new IllegalStateException("onRequestClose callback must be set if back key is expected to close the modal");
                    }
                    onRequestCloseListener.a(dialog2);
                    return true;
                }
                Context context = reactModalHostView.getContext();
                Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                Activity currentActivity2 = ((ReactContext) context).getCurrentActivity();
                if (currentActivity2 != null) {
                    return currentActivity2.onKeyUp(i3, event);
                }
                return false;
            }
        });
        Window window4 = dialog.getWindow();
        if (window4 != null) {
            window4.setSoftInputMode(16);
        }
        if (this.f19979h && (window2 = dialog.getWindow()) != null) {
            window2.addFlags(16777216);
        }
        if (currentActivity != null && (currentActivity.getWindow().getAttributes().flags & KEYRecord.Flags.FLAG2) != 0 && (window = dialog.getWindow()) != null) {
            window.setFlags(KEYRecord.Flags.FLAG2, KEYRecord.Flags.FLAG2);
        }
        if (currentActivity == null || currentActivity.isFinishing()) {
            return;
        }
        dialog.show();
        Activity currentActivity2 = getCurrentActivity();
        if (currentActivity2 != null) {
            Dialog dialog2 = this.f19972a;
            if (dialog2 == null) {
                throw new IllegalStateException("dialog must exist when we call updateProperties");
            }
            Window window5 = dialog2.getWindow();
            if (window5 == null) {
                throw new IllegalStateException("dialog must have window when we call updateProperties");
            }
            Window window6 = currentActivity2.getWindow();
            if (Build.VERSION.SDK_INT > 30) {
                WindowInsetsController insetsController = window6.getInsetsController();
                if (insetsController == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                int systemBarsAppearance = insetsController.getSystemBarsAppearance() & 8;
                WindowInsetsController insetsController2 = window5.getInsetsController();
                if (insetsController2 != null) {
                    insetsController2.setSystemBarsAppearance(systemBarsAppearance, 8);
                }
            } else {
                window5.getDecorView().setSystemUiVisibility(window6.getDecorView().getSystemUiVisibility());
            }
        }
        Window window7 = dialog.getWindow();
        if (window7 != null) {
            window7.clearFlags(8);
        }
    }

    public final void d() {
        Dialog dialog = this.f19972a;
        if (dialog == null) {
            throw new IllegalStateException("dialog must exist when we call updateProperties");
        }
        Window window = dialog.getWindow();
        if (window == null) {
            throw new IllegalStateException("dialog must have window when we call updateProperties");
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing() || currentActivity.isDestroyed()) {
            return;
        }
        try {
            Window window2 = currentActivity.getWindow();
            if (window2 != null) {
                if ((window2.getAttributes().flags & 1024) != 0) {
                    window.addFlags(1024);
                } else {
                    window.clearFlags(1024);
                }
            }
            WindowUtilKt.b(window, this.f19977f);
            if (!this.f19977f) {
                WindowUtilKt.a(window, this.f19976e);
            }
            if (this.f19973b) {
                window.clearFlags(2);
            } else {
                window.setDimAmount(0.5f);
                window.setFlags(2, 2);
            }
        } catch (IllegalArgumentException e2) {
            FLog.i("ReactNative", "ReactModalHostView: error while setting window flags: ", e2.getMessage());
        }
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideStructure(ViewStructure structure) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        this.f19980i.dispatchProvideStructure(structure);
    }

    @Nullable
    public final String getAnimationType() {
        return this.f19978g;
    }

    @Override // android.view.ViewGroup
    public final View getChildAt(int i2) {
        return this.f19980i.getChildAt(i2);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        return this.f19980i.getChildCount();
    }

    @VisibleForTesting
    @Nullable
    public final Dialog getDialog() {
        return this.f19972a;
    }

    @Nullable
    public final EventDispatcher getEventDispatcher() {
        return this.f19980i.getEventDispatcher$ReactAndroid_release();
    }

    public final boolean getHardwareAccelerated() {
        return this.f19979h;
    }

    public final boolean getNavigationBarTranslucent() {
        return this.f19977f;
    }

    @Nullable
    public final OnRequestCloseListener getOnRequestCloseListener() {
        return this.f19975d;
    }

    @Nullable
    public final DialogInterface.OnShowListener getOnShowListener() {
        return this.f19974c;
    }

    @Nullable
    public final StateWrapper getStateWrapper() {
        return this.f19980i.getStateWrapper$ReactAndroid_release();
    }

    public final boolean getStatusBarTranslucent() {
        return this.f19976e;
    }

    public final boolean getTransparent() {
        return this.f19973b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Context context = getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ((ThemedReactContext) context).addLifecycleEventListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostDestroy() {
        b();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostResume() {
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        if (view != null) {
            this.f19980i.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i2) {
        UiThreadUtil.assertOnUiThread();
        DialogRootViewGroup dialogRootViewGroup = this.f19980i;
        dialogRootViewGroup.removeView(dialogRootViewGroup.getChildAt(i2));
    }

    public final void setAnimationType(@Nullable String str) {
        this.f19978g = str;
        this.f19981j = true;
    }

    public final void setDialogRootViewGroupTestId(@Nullable String str) {
        this.f19980i.setTag(R.id.react_test_id, str);
    }

    public final void setEventDispatcher(@Nullable EventDispatcher eventDispatcher) {
        this.f19980i.setEventDispatcher$ReactAndroid_release(eventDispatcher);
    }

    public final void setHardwareAccelerated(boolean z) {
        this.f19979h = z;
        this.f19981j = true;
    }

    @Override // android.view.View
    public void setId(int i2) {
        super.setId(i2);
        this.f19980i.setId(i2);
    }

    public final void setNavigationBarTranslucent(boolean z) {
        this.f19977f = z;
        this.f19981j = true;
    }

    public final void setOnRequestCloseListener(@Nullable OnRequestCloseListener onRequestCloseListener) {
        this.f19975d = onRequestCloseListener;
    }

    public final void setOnShowListener(@Nullable DialogInterface.OnShowListener onShowListener) {
        this.f19974c = onShowListener;
    }

    public final void setStateWrapper(@Nullable StateWrapper stateWrapper) {
        this.f19980i.setStateWrapper$ReactAndroid_release(stateWrapper);
    }

    public final void setStatusBarTranslucent(boolean z) {
        this.f19976e = z;
        this.f19981j = true;
    }

    public final void setTransparent(boolean z) {
        this.f19973b = z;
    }
}
