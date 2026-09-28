package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class ViewCompat {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f3080a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Field f3081b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f3082c = false;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f3083d = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: e, reason: collision with root package name */
    public static final g f3084e = new g();

    /* renamed from: f, reason: collision with root package name */
    public static final AccessibilityPaneVisibilityManager f3085f = new AccessibilityPaneVisibilityManager();

    /* renamed from: androidx.core.view.ViewCompat$1, reason: invalid class name */
    class AnonymousClass1 extends AccessibilityViewProperty<Boolean> {
        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final Object a(View view) {
            return Boolean.valueOf(Api28Impl.c(view));
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final void b(View view, Object obj) {
            Api28Impl.f(view, ((Boolean) obj).booleanValue());
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final boolean e(Object obj, Object obj2) {
            Boolean bool = (Boolean) obj;
            Boolean bool2 = (Boolean) obj2;
            return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
        }
    }

    /* renamed from: androidx.core.view.ViewCompat$2, reason: invalid class name */
    class AnonymousClass2 extends AccessibilityViewProperty<CharSequence> {
        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final Object a(View view) {
            return Api28Impl.a(view);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final void b(View view, Object obj) {
            Api28Impl.e(view, (CharSequence) obj);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final boolean e(Object obj, Object obj2) {
            return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
        }
    }

    /* renamed from: androidx.core.view.ViewCompat$3, reason: invalid class name */
    class AnonymousClass3 extends AccessibilityViewProperty<CharSequence> {
        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final Object a(View view) {
            return Api30Impl.b(view);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final void b(View view, Object obj) {
            Api30Impl.d(view, (CharSequence) obj);
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final boolean e(Object obj, Object obj2) {
            return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
        }
    }

    /* renamed from: androidx.core.view.ViewCompat$4, reason: invalid class name */
    class AnonymousClass4 extends AccessibilityViewProperty<Boolean> {
        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final Object a(View view) {
            return Boolean.valueOf(Api28Impl.b(view));
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final void b(View view, Object obj) {
            Api28Impl.d(view, ((Boolean) obj).booleanValue());
        }

        @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
        public final boolean e(Object obj, Object obj2) {
            Boolean bool = (Boolean) obj;
            Boolean bool2 = (Boolean) obj2;
            return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
        }
    }

    public static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final WeakHashMap f3086a = new WeakHashMap();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry entry : this.f3086a.entrySet()) {
                    View view = (View) entry.getKey();
                    boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
                    boolean z = view.isShown() && view.getWindowVisibility() == 0;
                    if (zBooleanValue != z) {
                        ViewCompat.s(z ? 16 : 32, view);
                        entry.setValue(Boolean.valueOf(z));
                    }
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    public static abstract class AccessibilityViewProperty<T> {

        /* renamed from: a, reason: collision with root package name */
        public final int f3087a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f3088b;

        /* renamed from: c, reason: collision with root package name */
        public final int f3089c;

        /* renamed from: d, reason: collision with root package name */
        public final int f3090d;

        public AccessibilityViewProperty(int i2, Class cls, int i3, int i4) {
            this.f3087a = i2;
            this.f3088b = cls;
            this.f3090d = i3;
            this.f3089c = i4;
        }

        public abstract Object a(View view);

        public abstract void b(View view, Object obj);

        public final Object c(View view) {
            if (Build.VERSION.SDK_INT >= this.f3089c) {
                return a(view);
            }
            Object tag = view.getTag(this.f3087a);
            if (this.f3088b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public final void d(View view, Object obj) {
            if (Build.VERSION.SDK_INT >= this.f3089c) {
                b(view, obj);
                return;
            }
            if (e(c(view), obj)) {
                AccessibilityDelegateCompat accessibilityDelegateCompatD = ViewCompat.d(view);
                if (accessibilityDelegateCompatD == null) {
                    accessibilityDelegateCompatD = new AccessibilityDelegateCompat();
                }
                ViewCompat.z(view, accessibilityDelegateCompatD);
                view.setTag(this.f3087a, obj);
                ViewCompat.s(this.f3090d, view);
            }
        }

        public boolean e(Object obj, Object obj2) {
            return !obj2.equals(obj);
        }
    }

    @RequiresApi
    public static class Api20Impl {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            int i2 = ViewGroupCompat.f3099a;
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    @RequiresApi
    public static class Api21Impl {
        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets windowInsetsQ = windowInsetsCompat.q();
            if (windowInsetsQ != null) {
                return WindowInsetsCompat.r(view, view.computeSystemWindowInsets(windowInsetsQ, rect));
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        public static ColorStateList c(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode d(View view) {
            return view.getBackgroundTintMode();
        }

        public static float e(View view) {
            return view.getElevation();
        }

        public static String f(View view) {
            return view.getTransitionName();
        }

        public static float g(View view) {
            return view.getTranslationZ();
        }

        public static float h(View view) {
            return view.getZ();
        }

        public static boolean i(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void j(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void k(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void l(View view, float f2) {
            view.setElevation(f2);
        }

        public static void m(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        public static void n(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener != null ? new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.Api21Impl.1

                /* renamed from: a, reason: collision with root package name */
                public WindowInsetsCompat f3091a = null;

                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    WindowInsetsCompat windowInsetsCompatR = WindowInsetsCompat.r(view2, windowInsets);
                    int i2 = Build.VERSION.SDK_INT;
                    OnApplyWindowInsetsListener onApplyWindowInsetsListener3 = onApplyWindowInsetsListener;
                    if (i2 < 30) {
                        Api21Impl.a(windowInsets, view);
                        if (windowInsetsCompatR.equals(this.f3091a)) {
                            return onApplyWindowInsetsListener3.b(view2, windowInsetsCompatR).q();
                        }
                    }
                    this.f3091a = windowInsetsCompatR;
                    WindowInsetsCompat windowInsetsCompatB = onApplyWindowInsetsListener3.b(view2, windowInsetsCompatR);
                    if (i2 >= 30) {
                        return windowInsetsCompatB.q();
                    }
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    Api20Impl.c(view2);
                    return windowInsetsCompatB.q();
                }
            } : null;
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener2);
            }
            if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
                return;
            }
            if (onApplyWindowInsetsListener2 != null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListener2);
            } else {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            }
        }

        public static void o(View view, String str) {
            view.setTransitionName(str);
        }

        public static void p(View view, float f2) {
            view.setTranslationZ(f2);
        }

        public static void q(View view, float f2) {
            view.setZ(f2);
        }

        public static void r(View view) {
            view.stopNestedScroll();
        }
    }

    @RequiresApi
    public static class Api23Impl {
        public static WindowInsetsCompat a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompatR = WindowInsetsCompat.r(null, rootWindowInsets);
            WindowInsetsCompat.Impl impl = windowInsetsCompatR.f3150a;
            impl.t(windowInsetsCompatR);
            impl.d(view.getRootView());
            return windowInsetsCompatR;
        }

        public static void b(View view, int i2, int i3) {
            view.setScrollIndicators(i2, i3);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api24Impl {
        public static void a(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api26Impl {
        public static int a(View view) {
            return view.getImportantForAutofill();
        }

        public static void b(View view, int i2) {
            view.setImportantForAutofill(i2);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        public static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void d(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void f(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    @RequiresApi
    public static class Api29Impl {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    @RequiresApi
    public static class Api30Impl {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static WindowInsetsControllerCompat c(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return WindowInsetsControllerCompat.h(windowInsetsController);
            }
            return null;
        }

        public static void d(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static final class Api31Impl {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat b(View view, ContentInfoCompat contentInfoCompat) {
            ContentInfo contentInfoA = contentInfoCompat.f3018a.a();
            Objects.requireNonNull(contentInfoA);
            ContentInfo contentInfoL = androidx.core.os.a.l(contentInfoA);
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoL);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoL ? contentInfoCompat : new ContentInfoCompat(new ContentInfoCompat.Compat31Impl(contentInfoPerformReceiveContent));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface NestedScrollType {
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {
        public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            new ContentInfoCompat.Compat31Impl(contentInfo);
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public interface OnUnhandledKeyEventListenerCompat {
        boolean a();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface ScrollIndicators {
    }

    /* loaded from: classes3.dex */
    public static class UnhandledKeyEventManager {

        /* renamed from: d, reason: collision with root package name */
        public static final ArrayList f3094d = new ArrayList();

        /* renamed from: a, reason: collision with root package name */
        public WeakHashMap f3095a;

        /* renamed from: b, reason: collision with root package name */
        public SparseArray f3096b;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference f3097c;

        public static UnhandledKeyEventManager a(View view) {
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (unhandledKeyEventManager != null) {
                return unhandledKeyEventManager;
            }
            UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
            unhandledKeyEventManager2.f3095a = null;
            unhandledKeyEventManager2.f3096b = null;
            unhandledKeyEventManager2.f3097c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager2);
            return unhandledKeyEventManager2;
        }

        public static boolean d(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).a()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                WeakHashMap weakHashMap = this.f3095a;
                if (weakHashMap != null) {
                    weakHashMap.clear();
                }
                ArrayList arrayList = f3094d;
                if (!arrayList.isEmpty()) {
                    synchronized (arrayList) {
                        try {
                            if (this.f3095a == null) {
                                this.f3095a = new WeakHashMap();
                            }
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                ArrayList arrayList2 = f3094d;
                                View view2 = (View) ((WeakReference) arrayList2.get(size)).get();
                                if (view2 == null) {
                                    arrayList2.remove(size);
                                } else {
                                    this.f3095a.put(view2, Boolean.TRUE);
                                    for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        this.f3095a.put((View) parent, Boolean.TRUE);
                                    }
                                }
                            }
                        } finally {
                        }
                    }
                }
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    if (this.f3096b == null) {
                        this.f3096b = new SparseArray();
                    }
                    this.f3096b.put(keyCode, new WeakReference(viewC));
                }
            }
            return viewC != null;
        }

        public final View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f3095a;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                    if (viewC != null) {
                        return viewC;
                    }
                }
            }
            if (d(view, keyEvent)) {
                return view;
            }
            return null;
        }
    }

    public static void A(View view, boolean z) {
        new AnonymousClass4(R.id.tag_accessibility_heading, Boolean.class, 0, 28).d(view, Boolean.valueOf(z));
    }

    public static void B(View view, CharSequence charSequence) {
        new AnonymousClass2(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28).d(view, charSequence);
        AccessibilityPaneVisibilityManager accessibilityPaneVisibilityManager = f3085f;
        if (charSequence == null) {
            accessibilityPaneVisibilityManager.f3086a.remove(view);
            view.removeOnAttachStateChangeListener(accessibilityPaneVisibilityManager);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(accessibilityPaneVisibilityManager);
        } else {
            accessibilityPaneVisibilityManager.f3086a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(accessibilityPaneVisibilityManager);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(accessibilityPaneVisibilityManager);
            }
        }
    }

    public static void C(View view, ColorStateList colorStateList) {
        Api21Impl.j(view, colorStateList);
    }

    public static void D(View view, PorterDuff.Mode mode) {
        Api21Impl.k(view, mode);
    }

    public static void E(View view, float f2) {
        Api21Impl.l(view, f2);
    }

    public static void F(ViewGroup viewGroup, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.b(viewGroup, i2);
        }
    }

    public static void G(FrameLayout frameLayout, boolean z) {
        Api21Impl.m(frameLayout, z);
    }

    public static void H(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Api21Impl.n(view, onApplyWindowInsetsListener);
    }

    public static void I(ViewGroup viewGroup, PointerIconCompat pointerIconCompat) {
        Api24Impl.a(viewGroup, pointerIconCompat != null ? pointerIconCompat.a() : null);
    }

    public static void J(View view, boolean z) {
        new AnonymousClass1(R.id.tag_screen_reader_focusable, Boolean.class, 0, 28).d(view, Boolean.valueOf(z));
    }

    public static void K(ViewGroup viewGroup, int i2) {
        Api23Impl.b(viewGroup, i2, 3);
    }

    public static void L(SwitchCompat switchCompat, CharSequence charSequence) {
        new AnonymousClass3(R.id.tag_state_description, CharSequence.class, 64, 30).d(switchCompat, charSequence);
    }

    public static void M(View view, String str) {
        Api21Impl.o(view, str);
    }

    public static void N(View view, float f2) {
        Api21Impl.p(view, f2);
    }

    public static void O(View view, WindowInsetsAnimationCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(callback != null ? new WindowInsetsAnimationCompat.Impl30.ProxyCallback(callback) : null);
        } else {
            WindowInsetsAnimationCompat.Impl21.m(view, callback);
        }
    }

    public static void P(View view, float f2) {
        Api21Impl.q(view, f2);
    }

    public static ViewPropertyAnimatorCompat a(View view) {
        if (f3080a == null) {
            f3080a = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) f3080a.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        f3080a.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    public static void b(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        Api21Impl.b(view, windowInsetsCompat, rect);
    }

    public static WindowInsetsCompat c(View view, WindowInsetsCompat windowInsetsCompat) {
        int i2 = Build.VERSION.SDK_INT;
        WindowInsets windowInsetsQ = windowInsetsCompat.q();
        if (windowInsetsQ != null) {
            WindowInsets windowInsetsA = i2 >= 30 ? Api30Impl.a(view, windowInsetsQ) : Api20Impl.a(view, windowInsetsQ);
            if (!windowInsetsA.equals(windowInsetsQ)) {
                return WindowInsetsCompat.r(view, windowInsetsA);
            }
        }
        return windowInsetsCompat;
    }

    public static AccessibilityDelegateCompat d(View view) {
        View.AccessibilityDelegate accessibilityDelegateE = e(view);
        if (accessibilityDelegateE == null) {
            return null;
        }
        return accessibilityDelegateE instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter ? ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateE).f3015a : new AccessibilityDelegateCompat(accessibilityDelegateE);
    }

    public static View.AccessibilityDelegate e(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(view);
        }
        if (f3082c) {
            return null;
        }
        if (f3081b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f3081b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f3082c = true;
                return null;
            }
        }
        try {
            Object obj = f3081b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f3082c = true;
            return null;
        }
    }

    public static CharSequence f(View view) {
        return (CharSequence) new AnonymousClass2(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28).c(view);
    }

    public static ArrayList g(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static ColorStateList h(View view) {
        return Api21Impl.c(view);
    }

    public static PorterDuff.Mode i(View view) {
        return Api21Impl.d(view);
    }

    public static float j(View view) {
        return Api21Impl.e(view);
    }

    public static int k(RecyclerView recyclerView) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(recyclerView);
        }
        return 0;
    }

    public static String[] l(TextView textView) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.a(textView) : (String[]) textView.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static WindowInsetsCompat m(View view) {
        return Api23Impl.a(view);
    }

    public static String n(View view) {
        return Api21Impl.f(view);
    }

    public static float o(View view) {
        return Api21Impl.g(view);
    }

    public static WindowInsetsControllerCompat p(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.c(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return WindowCompat.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static float q(View view) {
        return Api21Impl.h(view);
    }

    public static boolean r(View view) {
        return Api21Impl.i(view);
    }

    public static void s(int i2, View view) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = f(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i2);
                if (z) {
                    accessibilityEventObtain.getText().add(f(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i2);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(f(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static WindowInsetsCompat t(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsetsQ = windowInsetsCompat.q();
        if (windowInsetsQ != null) {
            WindowInsets windowInsetsB = Api20Impl.b(view, windowInsetsQ);
            if (!windowInsetsB.equals(windowInsetsQ)) {
                return WindowInsetsCompat.r(view, windowInsetsB);
            }
        }
        return windowInsetsCompat;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ContentInfoCompat u(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.b(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.tag_on_receive_content_listener);
        OnReceiveContentViewBehavior onReceiveContentViewBehavior = f3084e;
        if (onReceiveContentListener == null) {
            if (view instanceof OnReceiveContentViewBehavior) {
                onReceiveContentViewBehavior = (OnReceiveContentViewBehavior) view;
            }
            return onReceiveContentViewBehavior.a(contentInfoCompat);
        }
        ContentInfoCompat contentInfoCompatA = onReceiveContentListener.a(view, contentInfoCompat);
        if (contentInfoCompatA == null) {
            return null;
        }
        if (view instanceof OnReceiveContentViewBehavior) {
            onReceiveContentViewBehavior = (OnReceiveContentViewBehavior) view;
        }
        return onReceiveContentViewBehavior.a(contentInfoCompatA);
    }

    public static void v(int i2, View view) {
        ArrayList arrayListG = g(view);
        for (int i3 = 0; i3 < arrayListG.size(); i3++) {
            if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) arrayListG.get(i3)).a() == i2) {
                arrayListG.remove(i3);
                return;
            }
        }
    }

    public static void w(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, String str, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && str == null) {
            v(accessibilityActionCompat.a(), view);
            s(0, view);
            return;
        }
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, accessibilityActionCompat.f3197b, str, accessibilityViewCommand, accessibilityActionCompat.f3198c);
        AccessibilityDelegateCompat accessibilityDelegateCompatD = d(view);
        if (accessibilityDelegateCompatD == null) {
            accessibilityDelegateCompatD = new AccessibilityDelegateCompat();
        }
        z(view, accessibilityDelegateCompatD);
        v(accessibilityActionCompat2.a(), view);
        g(view).add(accessibilityActionCompat2);
        s(0, view);
    }

    public static void x(View view) {
        Api20Impl.c(view);
    }

    public static void y(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.b(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static void z(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        if (accessibilityDelegateCompat == null && (e(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
    }
}
