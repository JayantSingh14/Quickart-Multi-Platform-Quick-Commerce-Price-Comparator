package com.swmansion.rnscreens;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.audio.h;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.ext.ViewExtKt;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class ScreenFragment extends Fragment implements ScreenFragmentWrapper {
    public boolean A0;
    public boolean B0;
    public boolean C0;
    public final Screen Q;
    public final ArrayList X;
    public boolean Y;
    public float Z;

    @Metadata
    public static final class Companion {
        public static short a(float f2) {
            return (short) (f2 == 0.0f ? 1 : f2 == 1.0f ? 2 : 3);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    /* loaded from: classes4.dex */
    public static final class ScreenLifecycleEvent {

        /* renamed from: a, reason: collision with root package name */
        public static final ScreenLifecycleEvent f47009a;

        /* renamed from: b, reason: collision with root package name */
        public static final ScreenLifecycleEvent f47010b;

        /* renamed from: c, reason: collision with root package name */
        public static final ScreenLifecycleEvent f47011c;

        /* renamed from: d, reason: collision with root package name */
        public static final ScreenLifecycleEvent f47012d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ ScreenLifecycleEvent[] f47013e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f47014f;

        static {
            ScreenLifecycleEvent screenLifecycleEvent = new ScreenLifecycleEvent("DID_APPEAR", 0);
            f47009a = screenLifecycleEvent;
            ScreenLifecycleEvent screenLifecycleEvent2 = new ScreenLifecycleEvent("WILL_APPEAR", 1);
            f47010b = screenLifecycleEvent2;
            ScreenLifecycleEvent screenLifecycleEvent3 = new ScreenLifecycleEvent("DID_DISAPPEAR", 2);
            f47011c = screenLifecycleEvent3;
            ScreenLifecycleEvent screenLifecycleEvent4 = new ScreenLifecycleEvent("WILL_DISAPPEAR", 3);
            f47012d = screenLifecycleEvent4;
            ScreenLifecycleEvent[] screenLifecycleEventArr = {screenLifecycleEvent, screenLifecycleEvent2, screenLifecycleEvent3, screenLifecycleEvent4};
            f47013e = screenLifecycleEventArr;
            f47014f = EnumEntriesKt.a(screenLifecycleEventArr);
        }

        public static ScreenLifecycleEvent valueOf(String str) {
            return (ScreenLifecycleEvent) Enum.valueOf(ScreenLifecycleEvent.class, str);
        }

        public static ScreenLifecycleEvent[] values() {
            return (ScreenLifecycleEvent[]) f47013e.clone();
        }
    }

    @Metadata
    public static final class ScreensFrameLayout extends FrameLayout {
        @Override // android.view.ViewGroup, android.view.View
        public final void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[ScreenLifecycleEvent.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ScreenLifecycleEvent screenLifecycleEvent = ScreenLifecycleEvent.f47009a;
                iArr[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ScreenLifecycleEvent screenLifecycleEvent2 = ScreenLifecycleEvent.f47009a;
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ScreenLifecycleEvent screenLifecycleEvent3 = ScreenLifecycleEvent.f47009a;
                iArr[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ScreenFragment() {
        this.X = new ArrayList();
        this.Z = -1.0f;
        this.A0 = true;
        this.B0 = true;
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    public final void A(float f2, boolean z) {
        if (!(this instanceof ScreenStackFragment) || this.Z == f2) {
            return;
        }
        float fMax = Math.max(0.0f, Math.min(1.0f, f2));
        this.Z = fMax;
        short sA = Companion.a(fMax);
        ScreenStackFragment screenStackFragment = (ScreenStackFragment) this;
        ScreenContainer container = screenStackFragment.k().getContainer();
        boolean goingForward = container instanceof ScreenStack ? ((ScreenStack) container).getGoingForward() : false;
        Context context = screenStackFragment.k().getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        EventDispatcher eventDispatcherB = UIManagerHelper.b(reactContext, screenStackFragment.k().getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new ScreenTransitionProgressEvent(UIManagerHelper.d(reactContext), screenStackFragment.k().getId(), this.Z, z, goingForward, sA));
        }
    }

    public final void B(boolean z) {
        this.C0 = !z;
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || ((parentFragment instanceof ScreenFragment) && !((ScreenFragment) parentFragment).C0)) {
            if (isResumed()) {
                UiThreadUtil.runOnUiThread(new h(z, this, 2));
            } else if (z) {
                z(ScreenLifecycleEvent.f47011c, this);
                A(1.0f, true);
            } else {
                z(ScreenLifecycleEvent.f47012d, this);
                A(0.0f, true);
            }
        }
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public final void b(ScreenLifecycleEvent event) {
        ScreenFragmentWrapper fragmentWrapper;
        Intrinsics.checkNotNullParameter(event, "event");
        ArrayList arrayList = this.X;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((ScreenContainer) obj).getScreenCount() > 0) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Screen topScreen = ((ScreenContainer) it.next()).getTopScreen();
            if (topScreen != null && (fragmentWrapper = topScreen.getFragmentWrapper()) != null) {
                z(event, fragmentWrapper);
            }
        }
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public final void c(ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int iOrdinal = event.ordinal();
        if (iOrdinal == 0) {
            this.B0 = false;
            return;
        }
        if (iOrdinal == 1) {
            this.A0 = false;
        } else if (iOrdinal == 2) {
            this.B0 = true;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.A0 = true;
        }
    }

    @Override // com.swmansion.rnscreens.FragmentHolder
    public final Fragment j() {
        return this;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final Screen k() {
        Screen screen = this.Q;
        if (screen != null) {
            return screen;
        }
        Intrinsics.h(PaymentConstants.Event.SCREEN);
        throw null;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public boolean l() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment, com.swmansion.rnscreens.ScreenFragmentWrapper
    public final Activity m() {
        Fragment fragment;
        FragmentActivity activity;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            return activity2;
        }
        Context context = k().getContext();
        if (context instanceof ReactContext) {
            ReactContext reactContext = (ReactContext) context;
            if (reactContext.getCurrentActivity() != null) {
                return reactContext.getCurrentActivity();
            }
        }
        for (ViewParent container = k().getContainer(); container != null; container = container.getParent()) {
            if ((container instanceof Screen) && (fragment = ((Screen) container).getFragment()) != null && (activity = fragment.getActivity()) != null) {
                return activity;
            }
        }
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final List n() {
        return this.X;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final void o(ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.X.add(container);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        k().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = getContext();
        if (context == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ScreensFrameLayout screensFrameLayout = new ScreensFrameLayout(context);
        Screen screenK = k();
        ViewExtKt.a(screenK);
        screensFrameLayout.addView(screenK);
        return screensFrameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ScreenContainer container = k().getContainer();
        if (container == null || !container.c(k().getFragmentWrapper())) {
            Context context = k().getContext();
            if (context instanceof ReactContext) {
                int iD = UIManagerHelper.d(context);
                EventDispatcher eventDispatcherB = UIManagerHelper.b((ReactContext) context, k().getId());
                if (eventDispatcherB != null) {
                    eventDispatcherB.g(new ScreenDismissedEvent(iD, k().getId()));
                }
            }
        }
        this.X.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.Y) {
            this.Y = false;
            ScreenWindowTraits.k(k(), m(), r());
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void p() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            this.Y = true;
        } else {
            ScreenWindowTraits.k(k(), activity, r());
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final void q(ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.X.remove(container);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public final ReactContext r() {
        if (getContext() instanceof ReactContext) {
            Context context = getContext();
            Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context;
        }
        if (k().getContext() instanceof ReactContext) {
            Context context2 = k().getContext();
            Intrinsics.d(context2, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context2;
        }
        for (ViewParent container = k().getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen = (Screen) container;
                if (screen.getContext() instanceof ReactContext) {
                    Context context3 = screen.getContext();
                    Intrinsics.d(context3, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                    return (ReactContext) context3;
                }
            }
        }
        return null;
    }

    public final void y() {
        Context context = k().getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int iD = UIManagerHelper.d(reactContext);
        EventDispatcher eventDispatcherB = UIManagerHelper.b(reactContext, k().getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new HeaderBackButtonClickedEvent(iD, k().getId()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(com.swmansion.rnscreens.ScreenFragment.ScreenLifecycleEvent r7, com.swmansion.rnscreens.ScreenFragmentWrapper r8) {
        /*
            r6 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r1 = "fragmentWrapper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            androidx.fragment.app.Fragment r1 = r8.j()
            boolean r2 = r1 instanceof com.swmansion.rnscreens.ScreenStackFragment
            if (r2 == 0) goto La6
            com.swmansion.rnscreens.ScreenStackFragment r1 = (com.swmansion.rnscreens.ScreenStackFragment) r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r0 = r7.ordinal()
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L3b
            if (r0 == r4) goto L38
            r5 = 0
            if (r0 == r3) goto L33
            if (r0 != r2) goto L2d
            boolean r0 = r1.A0
            if (r0 != 0) goto L3d
        L2b:
            r5 = r4
            goto L3d
        L2d:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L33:
            boolean r0 = r1.B0
            if (r0 != 0) goto L3d
            goto L2b
        L38:
            boolean r5 = r1.A0
            goto L3d
        L3b:
            boolean r5 = r1.B0
        L3d:
            if (r5 == 0) goto La6
            com.swmansion.rnscreens.Screen r0 = r1.k()
            r8.c(r7)
            int r1 = com.facebook.react.uimanager.UIManagerHelper.e(r0)
            int r5 = r7.ordinal()
            if (r5 == 0) goto L7a
            if (r5 == r4) goto L70
            if (r5 == r3) goto L66
            if (r5 != r2) goto L60
            com.swmansion.rnscreens.events.ScreenWillDisappearEvent r2 = new com.swmansion.rnscreens.events.ScreenWillDisappearEvent
            int r0 = r0.getId()
            r2.<init>(r1, r0)
            goto L83
        L60:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L66:
            com.swmansion.rnscreens.events.ScreenDisappearEvent r2 = new com.swmansion.rnscreens.events.ScreenDisappearEvent
            int r0 = r0.getId()
            r2.<init>(r1, r0)
            goto L83
        L70:
            com.swmansion.rnscreens.events.ScreenWillAppearEvent r2 = new com.swmansion.rnscreens.events.ScreenWillAppearEvent
            int r0 = r0.getId()
            r2.<init>(r1, r0)
            goto L83
        L7a:
            com.swmansion.rnscreens.events.ScreenAppearEvent r2 = new com.swmansion.rnscreens.events.ScreenAppearEvent
            int r0 = r0.getId()
            r2.<init>(r1, r0)
        L83:
            com.swmansion.rnscreens.Screen r0 = r6.k()
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext"
            kotlin.jvm.internal.Intrinsics.d(r0, r1)
            com.facebook.react.bridge.ReactContext r0 = (com.facebook.react.bridge.ReactContext) r0
            com.swmansion.rnscreens.Screen r1 = r6.k()
            int r1 = r1.getId()
            com.facebook.react.uimanager.events.EventDispatcher r0 = com.facebook.react.uimanager.UIManagerHelper.b(r0, r1)
            if (r0 == 0) goto La3
            r0.g(r2)
        La3:
            r8.b(r7)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenFragment.z(com.swmansion.rnscreens.ScreenFragment$ScreenLifecycleEvent, com.swmansion.rnscreens.ScreenFragmentWrapper):void");
    }

    public ScreenFragment(Screen screenView) {
        Intrinsics.checkNotNullParameter(screenView, "screenView");
        this.X = new ArrayList();
        this.Z = -1.0f;
        this.A0 = true;
        this.B0 = true;
        Intrinsics.checkNotNullParameter(screenView, "<set-?>");
        this.Q = screenView;
    }
}
