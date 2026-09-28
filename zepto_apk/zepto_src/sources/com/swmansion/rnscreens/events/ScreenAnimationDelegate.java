package com.swmansion.rnscreens.events;

import android.animation.Animator;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenStackFragment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ScreenAnimationDelegate implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final ScreenStackFragment f47116a;

    /* renamed from: b, reason: collision with root package name */
    public final ScreenEventEmitter f47117b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimationType f47118c;

    /* renamed from: d, reason: collision with root package name */
    public LifecycleState f47119d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class AnimationType {

        /* renamed from: a, reason: collision with root package name */
        public static final AnimationType f47120a;

        /* renamed from: b, reason: collision with root package name */
        public static final AnimationType f47121b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AnimationType[] f47122c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f47123d;

        static {
            AnimationType animationType = new AnimationType("ENTER", 0);
            f47120a = animationType;
            AnimationType animationType2 = new AnimationType("EXIT", 1);
            f47121b = animationType2;
            AnimationType[] animationTypeArr = {animationType, animationType2};
            f47122c = animationTypeArr;
            f47123d = EnumEntriesKt.a(animationTypeArr);
        }

        public static AnimationType valueOf(String str) {
            return (AnimationType) Enum.valueOf(AnimationType.class, str);
        }

        public static AnimationType[] values() {
            return (AnimationType[]) f47122c.clone();
        }
    }

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class LifecycleState {

        /* renamed from: a, reason: collision with root package name */
        public static final LifecycleState f47124a;

        /* renamed from: b, reason: collision with root package name */
        public static final LifecycleState f47125b;

        /* renamed from: c, reason: collision with root package name */
        public static final LifecycleState f47126c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ LifecycleState[] f47127d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f47128e;

        static {
            LifecycleState lifecycleState = new LifecycleState("INITIALIZED", 0);
            f47124a = lifecycleState;
            LifecycleState lifecycleState2 = new LifecycleState("START_DISPATCHED", 1);
            f47125b = lifecycleState2;
            LifecycleState lifecycleState3 = new LifecycleState("END_DISPATCHED", 2);
            f47126c = lifecycleState3;
            LifecycleState[] lifecycleStateArr = {lifecycleState, lifecycleState2, lifecycleState3};
            f47127d = lifecycleStateArr;
            f47128e = EnumEntriesKt.a(lifecycleStateArr);
        }

        public static LifecycleState valueOf(String str) {
            return (LifecycleState) Enum.valueOf(LifecycleState.class, str);
        }

        public static LifecycleState[] values() {
            return (LifecycleState[]) f47127d.clone();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[LifecycleState.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                LifecycleState lifecycleState = LifecycleState.f47124a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                LifecycleState lifecycleState2 = LifecycleState.f47124a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[AnimationType.values().length];
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                AnimationType animationType = AnimationType.f47120a;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ScreenAnimationDelegate(ScreenStackFragment wrapper, ScreenEventEmitter screenEventEmitter, AnimationType animationType) {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        this.f47116a = wrapper;
        this.f47117b = screenEventEmitter;
        this.f47118c = animationType;
        this.f47119d = LifecycleState.f47124a;
    }

    public final void a() {
        LifecycleState lifecycleState;
        int iOrdinal = this.f47119d.ordinal();
        if (iOrdinal == 0) {
            lifecycleState = LifecycleState.f47125b;
        } else {
            if (iOrdinal != 1 && iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            lifecycleState = LifecycleState.f47126c;
        }
        this.f47119d = lifecycleState;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (this.f47119d == LifecycleState.f47125b) {
            a();
            animation.removeListener(this);
            AnimationType animationType = this.f47118c;
            int iOrdinal = animationType.ordinal();
            ScreenEventEmitter screenEventEmitter = this.f47117b;
            Screen screen = screenEventEmitter.f47129a;
            if (iOrdinal == 0) {
                EventDispatcher reactEventDispatcher = screen.getReactEventDispatcher();
                if (reactEventDispatcher != null) {
                    reactEventDispatcher.g(new ScreenAppearEvent(UIManagerHelper.e(screen), screen.getId()));
                    Unit unit = Unit.f53572a;
                }
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                EventDispatcher reactEventDispatcher2 = screen.getReactEventDispatcher();
                if (reactEventDispatcher2 != null) {
                    reactEventDispatcher2.g(new ScreenDisappearEvent(UIManagerHelper.e(screen), screen.getId()));
                    Unit unit2 = Unit.f53572a;
                }
            }
            boolean z = animationType == AnimationType.f47121b;
            screenEventEmitter.a(1.0f, z, z);
            Screen screenK = this.f47116a.k();
            if (screenK.f46946k) {
                screenK.f46946k = false;
                Screen.b(screenK);
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (this.f47119d == LifecycleState.f47124a) {
            a();
            AnimationType animationType = this.f47118c;
            int iOrdinal = animationType.ordinal();
            ScreenEventEmitter screenEventEmitter = this.f47117b;
            Screen screen = screenEventEmitter.f47129a;
            if (iOrdinal == 0) {
                EventDispatcher reactEventDispatcher = screen.getReactEventDispatcher();
                if (reactEventDispatcher != null) {
                    reactEventDispatcher.g(new ScreenWillAppearEvent(UIManagerHelper.e(screen), screen.getId()));
                    Unit unit = Unit.f53572a;
                }
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                EventDispatcher reactEventDispatcher2 = screen.getReactEventDispatcher();
                if (reactEventDispatcher2 != null) {
                    reactEventDispatcher2.g(new ScreenWillDisappearEvent(UIManagerHelper.e(screen), screen.getId()));
                    Unit unit2 = Unit.f53572a;
                }
            }
            boolean z = animationType == AnimationType.f47121b;
            screenEventEmitter.a(0.0f, z, z);
        }
    }
}
