package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.activity.BackEventCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.R;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class AnimationEffect extends SpecialEffectsController.Effect {

        /* renamed from: c, reason: collision with root package name */
        public final AnimationInfo f4463c;

        public AnimationEffect(AnimationInfo animationInfo) {
            Intrinsics.checkNotNullParameter(animationInfo, "animationInfo");
            this.f4463c = animationInfo;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final void c(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            AnimationInfo animationInfo = this.f4463c;
            SpecialEffectsController.Operation operation = animationInfo.f4480a;
            View view = operation.f4701c.mView;
            view.clearAnimation();
            container.endViewTransition(view);
            animationInfo.f4480a.c(this);
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Animation from operation " + operation + " has been cancelled.");
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final void d(final ViewGroup container) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(container, "container");
            AnimationInfo animationInfo = this.f4463c;
            boolean zA = animationInfo.a();
            final SpecialEffectsController.Operation operation = animationInfo.f4480a;
            if (zA) {
                operation.c(this);
                return;
            }
            Context context = container.getContext();
            final View view = operation.f4701c.mView;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator animationOrAnimatorB = animationInfo.b(context);
            if (animationOrAnimatorB == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Animation animation = animationOrAnimatorB.f4541a;
            if (animation == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (operation.f4699a != SpecialEffectsController.Operation.State.f4714a) {
                view.startAnimation(animation);
                operation.c(this);
                return;
            }
            container.startViewTransition(view);
            FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation, container, view);
            endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$AnimationEffect$onCommit$1
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation2) {
                    Intrinsics.checkNotNullParameter(animation2, "animation");
                    View view2 = view;
                    DefaultSpecialEffectsController.AnimationEffect animationEffect = this;
                    ViewGroup viewGroup = container;
                    viewGroup.post(new a(viewGroup, view2, animationEffect, 0));
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "Animation from operation " + operation + " has ended.");
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation2) {
                    Intrinsics.checkNotNullParameter(animation2, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation2) {
                    Intrinsics.checkNotNullParameter(animation2, "animation");
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "Animation from operation " + operation + " has reached onAnimationStart.");
                    }
                }
            });
            view.startAnimation(endViewTransitionAnimation);
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Animation from operation " + operation + " has started.");
            }
        }
    }

    @Metadata
    public static final class AnimationInfo extends SpecialEffectsInfo {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f4468b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4469c;

        /* renamed from: d, reason: collision with root package name */
        public FragmentAnim.AnimationOrAnimator f4470d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimationInfo(SpecialEffectsController.Operation operation, boolean z) {
            super(operation);
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.f4468b = z;
        }

        public final FragmentAnim.AnimationOrAnimator b(Context context) throws Resources.NotFoundException {
            Animation animationLoadAnimation;
            FragmentAnim.AnimationOrAnimator animationOrAnimator;
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.f4469c) {
                return this.f4470d;
            }
            SpecialEffectsController.Operation operation = this.f4480a;
            Fragment fragment = operation.f4701c;
            boolean z = operation.f4699a == SpecialEffectsController.Operation.State.f4715b;
            int nextTransition = fragment.getNextTransition();
            int popEnterAnim = this.f4468b ? z ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z ? fragment.getEnterAnim() : fragment.getExitAnim();
            fragment.setAnimations(0, 0, 0, 0);
            ViewGroup viewGroup = fragment.mContainer;
            FragmentAnim.AnimationOrAnimator animationOrAnimator2 = null;
            if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
                fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
            }
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
                Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z, popEnterAnim);
                if (animationOnCreateAnimation != null) {
                    animationOrAnimator2 = new FragmentAnim.AnimationOrAnimator(animationOnCreateAnimation);
                } else {
                    Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z, popEnterAnim);
                    if (animatorOnCreateAnimator != null) {
                        animationOrAnimator2 = new FragmentAnim.AnimationOrAnimator(animatorOnCreateAnimator);
                    } else {
                        if (popEnterAnim == 0 && nextTransition != 0) {
                            popEnterAnim = nextTransition != 4097 ? nextTransition != 8194 ? nextTransition != 8197 ? nextTransition != 4099 ? nextTransition != 4100 ? -1 : z ? FragmentAnim.a(android.R.attr.activityOpenEnterAnimation, context) : FragmentAnim.a(android.R.attr.activityOpenExitAnimation, context) : z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit : z ? FragmentAnim.a(android.R.attr.activityCloseEnterAnimation, context) : FragmentAnim.a(android.R.attr.activityCloseExitAnimation, context) : z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit : z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                        }
                        if (popEnterAnim != 0) {
                            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
                            if (zEquals) {
                                try {
                                    animationLoadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                                } catch (Resources.NotFoundException e2) {
                                    throw e2;
                                } catch (RuntimeException unused) {
                                }
                                if (animationLoadAnimation != null) {
                                    animationOrAnimator = new FragmentAnim.AnimationOrAnimator(animationLoadAnimation);
                                    animationOrAnimator2 = animationOrAnimator;
                                }
                            } else {
                                try {
                                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                                    if (animatorLoadAnimator != null) {
                                        animationOrAnimator = new FragmentAnim.AnimationOrAnimator(animatorLoadAnimator);
                                        animationOrAnimator2 = animationOrAnimator;
                                    }
                                } catch (RuntimeException e3) {
                                    if (zEquals) {
                                        throw e3;
                                    }
                                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                                    if (animationLoadAnimation2 != null) {
                                        animationOrAnimator2 = new FragmentAnim.AnimationOrAnimator(animationLoadAnimation2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.f4470d = animationOrAnimator2;
            this.f4469c = true;
            return animationOrAnimator2;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class AnimatorEffect extends SpecialEffectsController.Effect {

        /* renamed from: c, reason: collision with root package name */
        public final AnimationInfo f4471c;

        /* renamed from: d, reason: collision with root package name */
        public AnimatorSet f4472d;

        public AnimatorEffect(AnimationInfo animatorInfo) {
            Intrinsics.checkNotNullParameter(animatorInfo, "animatorInfo");
            this.f4471c = animatorInfo;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final void c(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            AnimatorSet animatorSet = this.f4472d;
            AnimationInfo animationInfo = this.f4471c;
            if (animatorSet == null) {
                animationInfo.f4480a.c(this);
                return;
            }
            SpecialEffectsController.Operation operation = animationInfo.f4480a;
            if (!operation.f4705g) {
                animatorSet.end();
            } else if (Build.VERSION.SDK_INT >= 26) {
                Api26Impl.f4479a.a(animatorSet);
            }
            if (FragmentManager.O(2)) {
                StringBuilder sb = new StringBuilder("Animator from operation ");
                sb.append(operation);
                sb.append(" has been canceled");
                sb.append(operation.f4705g ? " with seeking." : CLConstants.DOT_SALT_DELIMETER);
                sb.append(' ');
                Log.v("FragmentManager", sb.toString());
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final void d(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            SpecialEffectsController.Operation operation = this.f4471c.f4480a;
            AnimatorSet animatorSet = this.f4472d;
            if (animatorSet == null) {
                operation.c(this);
                return;
            }
            animatorSet.start();
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Animator from operation " + operation + " has started.");
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final void e(BackEventCompat backEvent, ViewGroup container) {
            Intrinsics.checkNotNullParameter(backEvent, "backEvent");
            Intrinsics.checkNotNullParameter(container, "container");
            SpecialEffectsController.Operation operation = this.f4471c.f4480a;
            AnimatorSet animatorSet = this.f4472d;
            if (animatorSet == null) {
                operation.c(this);
                return;
            }
            if (Build.VERSION.SDK_INT < 34 || !operation.f4701c.mTransitioning) {
                return;
            }
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + operation);
            }
            long jA = Api24Impl.f4478a.a(animatorSet);
            long j2 = (long) (backEvent.f120c * jA);
            if (j2 == 0) {
                j2 = 1;
            }
            if (j2 == jA) {
                j2 = jA - 1;
            }
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Setting currentPlayTime to " + j2 + " for Animator " + animatorSet + " on operation " + operation);
            }
            Api26Impl.f4479a.b(animatorSet, j2);
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final void f(final ViewGroup container) throws Resources.NotFoundException {
            final AnimatorEffect animatorEffect;
            Intrinsics.checkNotNullParameter(container, "container");
            AnimationInfo animationInfo = this.f4471c;
            if (animationInfo.a()) {
                return;
            }
            Context context = container.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentAnim.AnimationOrAnimator animationOrAnimatorB = animationInfo.b(context);
            this.f4472d = animationOrAnimatorB != null ? animationOrAnimatorB.f4542b : null;
            final SpecialEffectsController.Operation operation = animationInfo.f4480a;
            Fragment fragment = operation.f4701c;
            final boolean z = operation.f4699a == SpecialEffectsController.Operation.State.f4716c;
            final View view = fragment.mView;
            container.startViewTransition(view);
            AnimatorSet animatorSet = this.f4472d;
            if (animatorSet != null) {
                animatorEffect = this;
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$AnimatorEffect$onStart$1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator anim) {
                        Intrinsics.checkNotNullParameter(anim, "anim");
                        ViewGroup viewGroup = container;
                        View viewToAnimate = view;
                        viewGroup.endViewTransition(viewToAnimate);
                        boolean z2 = z;
                        SpecialEffectsController.Operation operation2 = operation;
                        if (z2) {
                            SpecialEffectsController.Operation.State state = operation2.f4699a;
                            Intrinsics.checkNotNullExpressionValue(viewToAnimate, "viewToAnimate");
                            state.a(viewToAnimate, viewGroup);
                        }
                        DefaultSpecialEffectsController.AnimatorEffect animatorEffect2 = animatorEffect;
                        animatorEffect2.f4471c.f4480a.c(animatorEffect2);
                        if (FragmentManager.O(2)) {
                            Log.v("FragmentManager", "Animator from operation " + operation2 + " has ended.");
                        }
                    }
                });
            } else {
                animatorEffect = this;
            }
            AnimatorSet animatorSet2 = animatorEffect.f4472d;
            if (animatorSet2 != null) {
                animatorSet2.setTarget(view);
            }
        }
    }

    @RequiresApi
    @Metadata
    /* loaded from: classes3.dex */
    public static final class Api24Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Api24Impl f4478a = new Api24Impl();

        @DoNotInline
        public final long a(@NotNull AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    @RequiresApi
    @Metadata
    /* loaded from: classes3.dex */
    public static final class Api26Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Api26Impl f4479a = new Api26Impl();

        @DoNotInline
        public final void a(@NotNull AnimatorSet animatorSet) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        @DoNotInline
        public final void b(@NotNull AnimatorSet animatorSet, long j2) {
            Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j2);
        }
    }

    @Metadata
    public static class SpecialEffectsInfo {

        /* renamed from: a, reason: collision with root package name */
        public final SpecialEffectsController.Operation f4480a;

        public SpecialEffectsInfo(SpecialEffectsController.Operation operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.f4480a = operation;
        }

        public final boolean a() {
            SpecialEffectsController.Operation operation = this.f4480a;
            View view = operation.f4701c.mView;
            SpecialEffectsController.Operation.State stateA = view != null ? SpecialEffectsController.Operation.State.Companion.a(view) : null;
            SpecialEffectsController.Operation.State state = operation.f4699a;
            if (stateA == state) {
                return true;
            }
            SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.f4715b;
            return (stateA == state2 || state == state2) ? false : true;
        }
    }

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class TransitionEffect extends SpecialEffectsController.Effect {

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f4481c;

        /* renamed from: d, reason: collision with root package name */
        public final SpecialEffectsController.Operation f4482d;

        /* renamed from: e, reason: collision with root package name */
        public final SpecialEffectsController.Operation f4483e;

        /* renamed from: f, reason: collision with root package name */
        public final FragmentTransitionImpl f4484f;

        /* renamed from: g, reason: collision with root package name */
        public final Object f4485g;

        /* renamed from: h, reason: collision with root package name */
        public final ArrayList f4486h;

        /* renamed from: i, reason: collision with root package name */
        public final ArrayList f4487i;

        /* renamed from: j, reason: collision with root package name */
        public final ArrayMap f4488j;

        /* renamed from: k, reason: collision with root package name */
        public final ArrayList f4489k;

        /* renamed from: l, reason: collision with root package name */
        public final ArrayList f4490l;

        /* renamed from: m, reason: collision with root package name */
        public final ArrayMap f4491m;
        public final ArrayMap n;
        public final boolean o;
        public final CancellationSignal p;
        public Object q;

        public TransitionEffect(ArrayList transitionInfos, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, FragmentTransitionImpl transitionImpl, Object obj, ArrayList sharedElementFirstOutViews, ArrayList sharedElementLastInViews, ArrayMap sharedElementNameMapping, ArrayList enteringNames, ArrayList exitingNames, ArrayMap firstOutViews, ArrayMap lastInViews, boolean z) {
            Intrinsics.checkNotNullParameter(transitionInfos, "transitionInfos");
            Intrinsics.checkNotNullParameter(transitionImpl, "transitionImpl");
            Intrinsics.checkNotNullParameter(sharedElementFirstOutViews, "sharedElementFirstOutViews");
            Intrinsics.checkNotNullParameter(sharedElementLastInViews, "sharedElementLastInViews");
            Intrinsics.checkNotNullParameter(sharedElementNameMapping, "sharedElementNameMapping");
            Intrinsics.checkNotNullParameter(enteringNames, "enteringNames");
            Intrinsics.checkNotNullParameter(exitingNames, "exitingNames");
            Intrinsics.checkNotNullParameter(firstOutViews, "firstOutViews");
            Intrinsics.checkNotNullParameter(lastInViews, "lastInViews");
            this.f4481c = transitionInfos;
            this.f4482d = operation;
            this.f4483e = operation2;
            this.f4484f = transitionImpl;
            this.f4485g = obj;
            this.f4486h = sharedElementFirstOutViews;
            this.f4487i = sharedElementLastInViews;
            this.f4488j = sharedElementNameMapping;
            this.f4489k = enteringNames;
            this.f4490l = exitingNames;
            this.f4491m = firstOutViews;
            this.n = lastInViews;
            this.o = z;
            this.p = new CancellationSignal();
        }

        public static void h(View view, ArrayList arrayList) {
            if (!(view instanceof ViewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = ViewGroupCompat.f3099a;
            if (viewGroup.isTransitionGroup()) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(view);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View child = viewGroup.getChildAt(i3);
                if (child.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    h(child, arrayList);
                }
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final boolean b() {
            Object obj;
            FragmentTransitionImpl fragmentTransitionImpl = this.f4484f;
            if (!fragmentTransitionImpl.l()) {
                return false;
            }
            ArrayList<TransitionInfo> arrayList = this.f4481c;
            if (arrayList == null || !arrayList.isEmpty()) {
                for (TransitionInfo transitionInfo : arrayList) {
                    if (Build.VERSION.SDK_INT < 34 || (obj = transitionInfo.f4502b) == null || !fragmentTransitionImpl.m(obj)) {
                        return false;
                    }
                }
            }
            Object obj2 = this.f4485g;
            return obj2 == null || fragmentTransitionImpl.m(obj2);
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final void c(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            this.p.a();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final void d(final ViewGroup container) {
            final Object obj;
            Intrinsics.checkNotNullParameter(container, "container");
            boolean zIsLaidOut = container.isLaidOut();
            ArrayList<TransitionInfo> arrayList = this.f4481c;
            if (!zIsLaidOut) {
                for (TransitionInfo transitionInfo : arrayList) {
                    SpecialEffectsController.Operation operation = transitionInfo.f4480a;
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Completing operation " + operation);
                    }
                    transitionInfo.f4480a.c(this);
                }
                return;
            }
            Object obj2 = this.q;
            FragmentTransitionImpl fragmentTransitionImpl = this.f4484f;
            SpecialEffectsController.Operation operation2 = this.f4483e;
            SpecialEffectsController.Operation operation3 = this.f4482d;
            if (obj2 != null) {
                fragmentTransitionImpl.c(obj2);
                if (FragmentManager.O(2)) {
                    Log.v("FragmentManager", "Ending execution of operations from " + operation3 + " to " + operation2);
                    return;
                }
                return;
            }
            Pair pairI = i(container, operation2, operation3);
            ArrayList arrayList2 = (ArrayList) pairI.f53533a;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.r(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList3.add(((TransitionInfo) it.next()).f4480a);
            }
            Iterator it2 = arrayList3.iterator();
            while (true) {
                boolean zHasNext = it2.hasNext();
                obj = pairI.f53534b;
                if (!zHasNext) {
                    break;
                }
                SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) it2.next();
                fragmentTransitionImpl.u(operation4.f4701c, obj, this.p, new b(operation4, this, 1));
            }
            k(arrayList2, container, new Function0<Unit>() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onCommit$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    this.f4484f.e(container, obj);
                    return Unit.f53572a;
                }
            });
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Completed executing operations from " + operation3 + " to " + operation2);
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final void e(BackEventCompat backEvent, ViewGroup container) {
            Intrinsics.checkNotNullParameter(backEvent, "backEvent");
            Intrinsics.checkNotNullParameter(container, "container");
            Object obj = this.q;
            if (obj != null) {
                this.f4484f.r(obj, backEvent.f120c);
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Effect
        public final void f(final ViewGroup container) {
            Object obj;
            Intrinsics.checkNotNullParameter(container, "container");
            boolean zIsLaidOut = container.isLaidOut();
            ArrayList arrayList = this.f4481c;
            if (!zIsLaidOut) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    SpecialEffectsController.Operation operation = ((TransitionInfo) it.next()).f4480a;
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Skipping onStart for operation " + operation);
                    }
                }
                return;
            }
            boolean zJ = j();
            SpecialEffectsController.Operation operation2 = this.f4483e;
            SpecialEffectsController.Operation operation3 = this.f4482d;
            if (zJ && (obj = this.f4485g) != null && !b()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + obj + " between " + operation3 + " and " + operation2 + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (!b() || !j()) {
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Pair pairI = i(container, operation2, operation3);
            ArrayList arrayList2 = (ArrayList) pairI.f53533a;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.r(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((TransitionInfo) it2.next()).f4480a);
            }
            Iterator it3 = arrayList3.iterator();
            while (true) {
                boolean zHasNext = it3.hasNext();
                final Object obj2 = pairI.f53534b;
                if (!zHasNext) {
                    k(arrayList2, container, new Function0<Unit>() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            final DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.f4495c;
                            FragmentTransitionImpl fragmentTransitionImpl = transitionEffect.f4484f;
                            final ViewGroup viewGroup = container;
                            final Object obj3 = obj2;
                            Object objI = fragmentTransitionImpl.i(viewGroup, obj3);
                            transitionEffect.q = objI;
                            if (objI == null) {
                                throw new IllegalStateException(("Unable to start transition " + obj3 + " for container " + viewGroup + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
                            }
                            objectRef.f53801a = new Function0<Unit>() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
                                @Override // kotlin.jvm.functions.Function0
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct add '--show-bad-code' argument
                                */
                                public final java.lang.Object invoke() {
                                    /*
                                        r6 = this;
                                        androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r0 = r2
                                        java.util.ArrayList r1 = r0.f4481c
                                        androidx.fragment.app.FragmentTransitionImpl r2 = r0.f4484f
                                        java.lang.String r3 = "FragmentManager"
                                        r4 = 2
                                        if (r1 == 0) goto L12
                                        boolean r5 = r1.isEmpty()
                                        if (r5 == 0) goto L12
                                        goto L54
                                    L12:
                                        java.util.Iterator r1 = r1.iterator()
                                    L16:
                                        boolean r5 = r1.hasNext()
                                        if (r5 == 0) goto L54
                                        java.lang.Object r5 = r1.next()
                                        androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r5 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r5
                                        androidx.fragment.app.SpecialEffectsController$Operation r5 = r5.f4480a
                                        boolean r5 = r5.f4705g
                                        if (r5 != 0) goto L16
                                        boolean r1 = androidx.fragment.app.FragmentManager.O(r4)
                                        if (r1 == 0) goto L33
                                        java.lang.String r1 = "Completing animating immediately"
                                        android.util.Log.v(r3, r1)
                                    L33:
                                        androidx.core.os.CancellationSignal r1 = new androidx.core.os.CancellationSignal
                                        r1.<init>()
                                        java.util.ArrayList r3 = r0.f4481c
                                        r4 = 0
                                        java.lang.Object r3 = r3.get(r4)
                                        androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r3 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r3
                                        androidx.fragment.app.SpecialEffectsController$Operation r3 = r3.f4480a
                                        androidx.fragment.app.Fragment r3 = r3.f4701c
                                        androidx.fragment.app.c r4 = new androidx.fragment.app.c
                                        r5 = 0
                                        r4.<init>(r0, r5)
                                        java.lang.Object r0 = r3
                                        r2.u(r3, r0, r1, r4)
                                        r1.a()
                                        goto L6e
                                    L54:
                                        boolean r1 = androidx.fragment.app.FragmentManager.O(r4)
                                        if (r1 == 0) goto L5f
                                        java.lang.String r1 = "Animating to start"
                                        android.util.Log.v(r3, r1)
                                    L5f:
                                        java.lang.Object r1 = r0.q
                                        kotlin.jvm.internal.Intrinsics.c(r1)
                                        androidx.fragment.app.b r3 = new androidx.fragment.app.b
                                        android.view.ViewGroup r4 = r1
                                        r3.<init>(r0, r4)
                                        r2.d(r1, r3)
                                    L6e:
                                        kotlin.Unit r0 = kotlin.Unit.f53572a
                                        return r0
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4.AnonymousClass2.invoke():java.lang.Object");
                                }
                            };
                            if (FragmentManager.O(2)) {
                                Log.v("FragmentManager", "Started executing operations from " + transitionEffect.f4482d + " to " + transitionEffect.f4483e);
                            }
                            return Unit.f53572a;
                        }
                    });
                    return;
                }
                SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) it3.next();
                c cVar = new c(objectRef, 1);
                Fragment fragment = operation4.f4701c;
                this.f4484f.v(obj2, this.p, cVar, new b(operation4, this, 0));
            }
        }

        public final Pair i(ViewGroup viewGroup, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Object obj;
            FragmentTransitionImpl fragmentTransitionImpl;
            Object obj2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            Iterator it;
            TransitionEffect transitionEffect = this;
            View view = new View(viewGroup.getContext());
            Rect rect = new Rect();
            ArrayList arrayList5 = transitionEffect.f4481c;
            Iterator it2 = arrayList5.iterator();
            View view2 = null;
            boolean z = false;
            while (true) {
                boolean zHasNext = it2.hasNext();
                arrayList = transitionEffect.f4487i;
                arrayList2 = transitionEffect.f4486h;
                obj = transitionEffect.f4485g;
                fragmentTransitionImpl = transitionEffect.f4484f;
                if (!zHasNext) {
                    break;
                }
                if (((TransitionInfo) it2.next()).f4504d == null || operation2 == null || operation == null || transitionEffect.f4488j.isEmpty() || obj == null) {
                    arrayList4 = arrayList5;
                    it = it2;
                } else {
                    ArrayMap arrayMap = transitionEffect.f4491m;
                    arrayList4 = arrayList5;
                    it = it2;
                    FragmentTransition.a(operation.f4701c, operation2.f4701c, transitionEffect.o, arrayMap);
                    OneShotPreDrawListener.a(viewGroup, new a(operation, operation2, transitionEffect, 1));
                    arrayList2.addAll(arrayMap.values());
                    ArrayList arrayList6 = transitionEffect.f4490l;
                    if (!arrayList6.isEmpty()) {
                        Object obj3 = arrayList6.get(0);
                        Intrinsics.checkNotNullExpressionValue(obj3, "exitingNames[0]");
                        View view3 = (View) arrayMap.get((String) obj3);
                        fragmentTransitionImpl.s(view3, obj);
                        view2 = view3;
                    }
                    ArrayMap arrayMap2 = transitionEffect.n;
                    arrayList.addAll(arrayMap2.values());
                    ArrayList arrayList7 = transitionEffect.f4489k;
                    if (!arrayList7.isEmpty()) {
                        Object obj4 = arrayList7.get(0);
                        Intrinsics.checkNotNullExpressionValue(obj4, "enteringNames[0]");
                        View view4 = (View) arrayMap2.get((String) obj4);
                        if (view4 != null) {
                            OneShotPreDrawListener.a(viewGroup, new a(fragmentTransitionImpl, view4, rect, 2));
                            z = true;
                        }
                    }
                    fragmentTransitionImpl.w(obj, view, arrayList2);
                    FragmentTransitionImpl fragmentTransitionImpl2 = transitionEffect.f4484f;
                    Object obj5 = transitionEffect.f4485g;
                    fragmentTransitionImpl2.q(obj5, null, null, obj5, arrayList);
                }
                arrayList5 = arrayList4;
                it2 = it;
            }
            ArrayList arrayList8 = arrayList5;
            ArrayList arrayList9 = new ArrayList();
            Iterator it3 = arrayList8.iterator();
            Object objO = null;
            Object objO2 = null;
            while (true) {
                Iterator it4 = it3;
                if (!it3.hasNext()) {
                    break;
                }
                TransitionInfo transitionInfo = (TransitionInfo) it4.next();
                boolean z2 = z;
                SpecialEffectsController.Operation operation3 = transitionInfo.f4480a;
                ArrayList arrayList10 = arrayList2;
                Object objH = fragmentTransitionImpl.h(transitionInfo.f4502b);
                if (objH != null) {
                    Object obj6 = obj;
                    ArrayList arrayList11 = new ArrayList();
                    Object obj7 = objO2;
                    View view5 = operation3.f4701c.mView;
                    Object obj8 = objO;
                    Intrinsics.checkNotNullExpressionValue(view5, "operation.fragment.mView");
                    h(view5, arrayList11);
                    if (obj6 != null && (operation3 == operation2 || operation3 == operation)) {
                        if (operation3 == operation2) {
                            arrayList11.removeAll(CollectionsKt.h0(arrayList10));
                        } else {
                            arrayList11.removeAll(CollectionsKt.h0(arrayList));
                        }
                    }
                    if (arrayList11.isEmpty()) {
                        fragmentTransitionImpl.a(view, objH);
                        obj2 = objH;
                        arrayList3 = arrayList11;
                    } else {
                        fragmentTransitionImpl.b(objH, arrayList11);
                        transitionEffect.f4484f.q(objH, objH, arrayList11, null, null);
                        obj2 = objH;
                        arrayList3 = arrayList11;
                        if (operation3.f4699a == SpecialEffectsController.Operation.State.f4716c) {
                            operation3.f4707i = false;
                            ArrayList arrayList12 = new ArrayList(arrayList3);
                            Fragment fragment = operation3.f4701c;
                            arrayList12.remove(fragment.mView);
                            fragmentTransitionImpl.p(obj2, fragment.mView, arrayList12);
                            OneShotPreDrawListener.a(viewGroup, new c(arrayList3, 2));
                        }
                    }
                    if (operation3.f4699a == SpecialEffectsController.Operation.State.f4715b) {
                        arrayList9.addAll(arrayList3);
                        if (z2) {
                            fragmentTransitionImpl.t(obj2, rect);
                        }
                        if (FragmentManager.O(2)) {
                            Log.v("FragmentManager", "Entering Transition: " + obj2);
                            Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                            Iterator it5 = arrayList3.iterator();
                            while (it5.hasNext()) {
                                Object transitioningViews = it5.next();
                                Intrinsics.checkNotNullExpressionValue(transitioningViews, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) transitioningViews));
                            }
                        }
                    } else {
                        fragmentTransitionImpl.s(view2, obj2);
                        if (FragmentManager.O(2)) {
                            Log.v("FragmentManager", "Exiting Transition: " + obj2);
                            Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                            Iterator it6 = arrayList3.iterator();
                            while (it6.hasNext()) {
                                Object transitioningViews2 = it6.next();
                                Intrinsics.checkNotNullExpressionValue(transitioningViews2, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) transitioningViews2));
                            }
                        }
                    }
                    if (transitionInfo.f4503c) {
                        objO = fragmentTransitionImpl.o(obj8, obj2);
                        transitionEffect = this;
                        it3 = it4;
                        z = z2;
                        arrayList2 = arrayList10;
                        obj = obj6;
                        objO2 = obj7;
                    } else {
                        objO2 = fragmentTransitionImpl.o(obj7, obj2);
                        objO = obj8;
                        it3 = it4;
                        z = z2;
                        arrayList2 = arrayList10;
                        obj = obj6;
                    }
                } else {
                    it3 = it4;
                    z = z2;
                    arrayList2 = arrayList10;
                }
                transitionEffect = this;
            }
            Object objN = fragmentTransitionImpl.n(objO, objO2, obj);
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Final merged transition: " + objN);
            }
            return new Pair(arrayList9, objN);
        }

        public final boolean j() {
            ArrayList arrayList = this.f4481c;
            if (arrayList != null && arrayList.isEmpty()) {
                return true;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((TransitionInfo) it.next()).f4480a.f4701c.mTransitioning) {
                    return false;
                }
            }
            return true;
        }

        public final void k(ArrayList arrayList, ViewGroup viewGroup, Function0 function0) {
            FragmentTransition.d(4, arrayList);
            FragmentTransitionImpl fragmentTransitionImpl = this.f4484f;
            fragmentTransitionImpl.getClass();
            final ArrayList arrayList2 = new ArrayList();
            final ArrayList arrayList3 = this.f4487i;
            int size = arrayList3.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) arrayList3.get(i2);
                arrayList2.add(ViewCompat.n(view));
                ViewCompat.M(view, null);
            }
            boolean zO = FragmentManager.O(2);
            final ArrayList arrayList4 = this.f4486h;
            if (zO) {
                Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
                Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
                Iterator it = arrayList4.iterator();
                while (it.hasNext()) {
                    Object sharedElementFirstOutViews = it.next();
                    Intrinsics.checkNotNullExpressionValue(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                    View view2 = (View) sharedElementFirstOutViews;
                    Log.v("FragmentManager", "View: " + view2 + " Name: " + ViewCompat.n(view2));
                }
                Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    Object sharedElementLastInViews = it2.next();
                    Intrinsics.checkNotNullExpressionValue(sharedElementLastInViews, "sharedElementLastInViews");
                    View view3 = (View) sharedElementLastInViews;
                    Log.v("FragmentManager", "View: " + view3 + " Name: " + ViewCompat.n(view3));
                }
            }
            function0.invoke();
            final int size2 = arrayList3.size();
            final ArrayList arrayList5 = new ArrayList();
            for (int i3 = 0; i3 < size2; i3++) {
                View view4 = (View) arrayList4.get(i3);
                String strN = ViewCompat.n(view4);
                arrayList5.add(strN);
                if (strN != null) {
                    ViewCompat.M(view4, null);
                    String str = (String) this.f4488j.get(strN);
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size2) {
                            break;
                        }
                        if (str.equals(arrayList2.get(i4))) {
                            ViewCompat.M((View) arrayList3.get(i4), strN);
                            break;
                        }
                        i4++;
                    }
                }
            }
            OneShotPreDrawListener.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (int i5 = 0; i5 < size2; i5++) {
                        ViewCompat.M((View) arrayList3.get(i5), (String) arrayList2.get(i5));
                        ViewCompat.M((View) arrayList4.get(i5), (String) arrayList5.get(i5));
                    }
                }
            });
            FragmentTransition.d(0, arrayList);
            fragmentTransitionImpl.x(this.f4485g, arrayList4, arrayList3);
        }
    }

    @Metadata
    public static final class TransitionInfo extends SpecialEffectsInfo {

        /* renamed from: b, reason: collision with root package name */
        public final Object f4502b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f4503c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f4504d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitionInfo(SpecialEffectsController.Operation operation, boolean z, boolean z2) {
            super(operation);
            Intrinsics.checkNotNullParameter(operation, "operation");
            SpecialEffectsController.Operation.State state = operation.f4699a;
            SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.f4715b;
            Fragment fragment = operation.f4701c;
            this.f4502b = state == state2 ? z ? fragment.getReenterTransition() : fragment.getEnterTransition() : z ? fragment.getReturnTransition() : fragment.getExitTransition();
            this.f4503c = operation.f4699a == state2 ? z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() : true;
            this.f4504d = z2 ? z ? fragment.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition() : null;
        }

        public final FragmentTransitionImpl b() {
            Object obj = this.f4502b;
            FragmentTransitionImpl fragmentTransitionImplC = c(obj);
            Object obj2 = this.f4504d;
            FragmentTransitionImpl fragmentTransitionImplC2 = c(obj2);
            if (fragmentTransitionImplC == null || fragmentTransitionImplC2 == null || fragmentTransitionImplC == fragmentTransitionImplC2) {
                return fragmentTransitionImplC == null ? fragmentTransitionImplC2 : fragmentTransitionImplC;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.f4480a.f4701c + " returned Transition " + obj + " which uses a different Transition  type than its shared element transition " + obj2).toString());
        }

        public final FragmentTransitionImpl c(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.f4663a;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.g(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.f4664b;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.g(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f4480a.f4701c + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public static void r(ArrayMap arrayMap, View view) {
        String strN = ViewCompat.n(view);
        if (strN != null) {
            arrayMap.put(strN, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View child = viewGroup.getChildAt(i2);
                if (child.getVisibility() == 0) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    r(arrayMap, child);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04d3 A[LOOP:7: B:155:0x04cd->B:157:0x04d3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dd  */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v2 */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.ArrayList r31, boolean r32) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.b(java.util.ArrayList, boolean):void");
    }
}
