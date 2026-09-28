package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.fragment.R;
import androidx.fragment.app.DefaultSpecialEffectsController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f4690a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4691b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f4692c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4693d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4694e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4695f;

    @Metadata
    public static final class Companion {
        public static SpecialEffectsController a(ViewGroup container, SpecialEffectsControllerFactory factory) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(factory, "factory");
            Object tag = container.getTag(R.id.special_effects_controller_view_tag);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            DefaultSpecialEffectsController defaultSpecialEffectsControllerA = factory.a(container);
            Intrinsics.checkNotNullExpressionValue(defaultSpecialEffectsControllerA, "factory.createController(container)");
            container.setTag(R.id.special_effects_controller_view_tag, defaultSpecialEffectsControllerA);
            return defaultSpecialEffectsControllerA;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static class Effect {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4696a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4697b;

        public final void a(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (!this.f4697b) {
                c(container);
            }
            this.f4697b = true;
        }

        public boolean b() {
            return this instanceof DefaultSpecialEffectsController.AnimatorEffect;
        }

        public void c(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
        }

        public void d(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
        }

        public void e(BackEventCompat backEvent, ViewGroup container) {
            Intrinsics.checkNotNullParameter(backEvent, "backEvent");
            Intrinsics.checkNotNullParameter(container, "container");
        }

        public void f(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
        }

        public final void g(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (!this.f4696a) {
                f(container);
            }
            this.f4696a = true;
        }
    }

    @Metadata
    public static final class FragmentStateManagerOperation extends Operation {

        /* renamed from: l, reason: collision with root package name */
        public final FragmentStateManager f4698l;

        /* JADX WARN: Illegal instructions before constructor call */
        public FragmentStateManagerOperation(Operation.State finalState, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
            Intrinsics.checkNotNullParameter(finalState, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
            Fragment fragment = fragmentStateManager.f4621c;
            Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, fragment);
            this.f4698l = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public final void b() {
            super.b();
            this.f4701c.mTransitioning = false;
            this.f4698l.k();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public final void e() {
            if (this.f4706h) {
                return;
            }
            this.f4706h = true;
            Operation.LifecycleImpact lifecycleImpact = this.f4700b;
            Operation.LifecycleImpact lifecycleImpact2 = Operation.LifecycleImpact.f4711b;
            FragmentStateManager fragmentStateManager = this.f4698l;
            if (lifecycleImpact != lifecycleImpact2) {
                if (lifecycleImpact == Operation.LifecycleImpact.f4712c) {
                    Fragment fragment = fragmentStateManager.f4621c;
                    Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
                    View viewRequireView = fragment.requireView();
                    Intrinsics.checkNotNullExpressionValue(viewRequireView, "fragment.requireView()");
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + fragment);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragment2 = fragmentStateManager.f4621c;
            Intrinsics.checkNotNullExpressionValue(fragment2, "fragmentStateManager.fragment");
            View viewFindFocus = fragment2.mView.findFocus();
            if (viewFindFocus != null) {
                fragment2.setFocusedView(viewFindFocus);
                if (FragmentManager.O(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment2);
                }
            }
            View viewRequireView2 = this.f4701c.requireView();
            Intrinsics.checkNotNullExpressionValue(viewRequireView2, "this.fragment.requireView()");
            if (viewRequireView2.getParent() == null) {
                fragmentStateManager.b();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(fragment2.getPostOnViewCreatedAlpha());
        }
    }

    @Metadata
    @SourceDebugExtension
    public static class Operation {

        /* renamed from: a, reason: collision with root package name */
        public State f4699a;

        /* renamed from: b, reason: collision with root package name */
        public LifecycleImpact f4700b;

        /* renamed from: c, reason: collision with root package name */
        public final Fragment f4701c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f4702d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4703e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f4704f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f4705g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f4706h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f4707i;

        /* renamed from: j, reason: collision with root package name */
        public final ArrayList f4708j;

        /* renamed from: k, reason: collision with root package name */
        public final ArrayList f4709k;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata
        public static final class LifecycleImpact {

            /* renamed from: a, reason: collision with root package name */
            public static final LifecycleImpact f4710a;

            /* renamed from: b, reason: collision with root package name */
            public static final LifecycleImpact f4711b;

            /* renamed from: c, reason: collision with root package name */
            public static final LifecycleImpact f4712c;

            /* renamed from: d, reason: collision with root package name */
            public static final /* synthetic */ LifecycleImpact[] f4713d;

            static {
                LifecycleImpact lifecycleImpact = new LifecycleImpact("NONE", 0);
                f4710a = lifecycleImpact;
                LifecycleImpact lifecycleImpact2 = new LifecycleImpact("ADDING", 1);
                f4711b = lifecycleImpact2;
                LifecycleImpact lifecycleImpact3 = new LifecycleImpact("REMOVING", 2);
                f4712c = lifecycleImpact3;
                f4713d = new LifecycleImpact[]{lifecycleImpact, lifecycleImpact2, lifecycleImpact3};
            }

            public static LifecycleImpact valueOf(String str) {
                return (LifecycleImpact) Enum.valueOf(LifecycleImpact.class, str);
            }

            public static LifecycleImpact[] values() {
                return (LifecycleImpact[]) f4713d.clone();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata
        public static final class State {

            /* renamed from: a, reason: collision with root package name */
            public static final State f4714a;

            /* renamed from: b, reason: collision with root package name */
            public static final State f4715b;

            /* renamed from: c, reason: collision with root package name */
            public static final State f4716c;

            /* renamed from: d, reason: collision with root package name */
            public static final State f4717d;

            /* renamed from: e, reason: collision with root package name */
            public static final /* synthetic */ State[] f4718e;

            @Metadata
            public static final class Companion {
                public static State a(View view) {
                    Intrinsics.checkNotNullParameter(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? State.f4717d : b(view.getVisibility());
                }

                public static State b(int i2) {
                    if (i2 == 0) {
                        return State.f4715b;
                    }
                    if (i2 == 4) {
                        return State.f4717d;
                    }
                    if (i2 == 8) {
                        return State.f4716c;
                    }
                    throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Unknown visibility "));
                }
            }

            @Metadata
            public /* synthetic */ class WhenMappings {
                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[0] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[1] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[2] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[3] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                }
            }

            static {
                State state = new State("REMOVED", 0);
                f4714a = state;
                State state2 = new State("VISIBLE", 1);
                f4715b = state2;
                State state3 = new State("GONE", 2);
                f4716c = state3;
                State state4 = new State("INVISIBLE", 3);
                f4717d = state4;
                f4718e = new State[]{state, state2, state3, state4};
            }

            public static State valueOf(String str) {
                return (State) Enum.valueOf(State.class, str);
            }

            public static State[] values() {
                return (State[]) f4718e.clone();
            }

            public final void a(View view, ViewGroup container) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(container, "container");
                int iOrdinal = ordinal();
                if (iOrdinal == 0) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (FragmentManager.O(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (iOrdinal == 1) {
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (FragmentManager.O(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + container);
                        }
                        container.addView(view);
                    }
                    view.setVisibility(0);
                    return;
                }
                if (iOrdinal == 2) {
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (iOrdinal != 3) {
                    return;
                }
                if (FragmentManager.O(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[LifecycleImpact.values().length];
                try {
                    iArr[1] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[2] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[0] = 3;
                } catch (NoSuchFieldError unused3) {
                }
            }
        }

        public Operation(State finalState, LifecycleImpact lifecycleImpact, Fragment fragment) {
            Intrinsics.checkNotNullParameter(finalState, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.f4699a = finalState;
            this.f4700b = lifecycleImpact;
            this.f4701c = fragment;
            this.f4702d = new ArrayList();
            this.f4707i = true;
            ArrayList arrayList = new ArrayList();
            this.f4708j = arrayList;
            this.f4709k = arrayList;
        }

        public final void a(ViewGroup container) {
            Intrinsics.checkNotNullParameter(container, "container");
            this.f4706h = false;
            if (this.f4703e) {
                return;
            }
            this.f4703e = true;
            if (this.f4708j.isEmpty()) {
                b();
                return;
            }
            Iterator it = CollectionsKt.e0(this.f4709k).iterator();
            while (it.hasNext()) {
                ((Effect) it.next()).a(container);
            }
        }

        public void b() {
            this.f4706h = false;
            if (this.f4704f) {
                return;
            }
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f4704f = true;
            Iterator it = this.f4702d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void c(Effect effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            ArrayList arrayList = this.f4708j;
            if (arrayList.remove(effect) && arrayList.isEmpty()) {
                b();
            }
        }

        public final void d(State finalState, LifecycleImpact lifecycleImpact) {
            Intrinsics.checkNotNullParameter(finalState, "finalState");
            Intrinsics.checkNotNullParameter(lifecycleImpact, "lifecycleImpact");
            int iOrdinal = lifecycleImpact.ordinal();
            State state = State.f4714a;
            Fragment fragment = this.f4701c;
            if (iOrdinal == 0) {
                if (this.f4699a != state) {
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + this.f4699a + " -> " + finalState + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    }
                    this.f4699a = finalState;
                    return;
                }
                return;
            }
            if (iOrdinal == 1) {
                if (this.f4699a == state) {
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f4700b + " to ADDING.");
                    }
                    this.f4699a = State.f4715b;
                    this.f4700b = LifecycleImpact.f4711b;
                    this.f4707i = true;
                    return;
                }
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + this.f4699a + " -> REMOVED. mLifecycleImpact  = " + this.f4700b + " to REMOVING.");
            }
            this.f4699a = state;
            this.f4700b = LifecycleImpact.f4712c;
            this.f4707i = true;
        }

        public void e() {
            this.f4706h = true;
        }

        public final String toString() {
            StringBuilder sbY = android.support.v4.media.b.y("Operation {", Integer.toHexString(System.identityHashCode(this)), "} {finalState = ");
            sbY.append(this.f4699a);
            sbY.append(" lifecycleImpact = ");
            sbY.append(this.f4700b);
            sbY.append(" fragment = ");
            sbY.append(this.f4701c);
            sbY.append('}');
            return sbY.toString();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4719a;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f4719a = iArr;
        }
    }

    public SpecialEffectsController(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.f4690a = container;
        this.f4691b = new ArrayList();
        this.f4692c = new ArrayList();
    }

    public static final SpecialEffectsController m(ViewGroup container, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        SpecialEffectsControllerFactory specialEffectsControllerFactoryM = fragmentManager.M();
        Intrinsics.checkNotNullExpressionValue(specialEffectsControllerFactoryM, "fragmentManager.specialEffectsControllerFactory");
        return Companion.a(container, specialEffectsControllerFactoryM);
    }

    public static boolean n(ArrayList arrayList) {
        boolean z;
        Iterator it = arrayList.iterator();
        loop0: while (true) {
            z = true;
            while (it.hasNext()) {
                Operation operation = (Operation) it.next();
                if (!operation.f4709k.isEmpty()) {
                    ArrayList arrayList2 = operation.f4709k;
                    if (arrayList2 == null || !arrayList2.isEmpty()) {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            if (!((Effect) it2.next()).b()) {
                                break;
                            }
                        }
                    }
                }
                z = false;
            }
            break loop0;
        }
        if (z) {
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                CollectionsKt.i(arrayList3, ((Operation) it3.next()).f4709k);
            }
            if (!arrayList3.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final void a(Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (operation.f4707i) {
            Operation.State state = operation.f4699a;
            View viewRequireView = operation.f4701c.requireView();
            Intrinsics.checkNotNullExpressionValue(viewRequireView, "operation.fragment.requireView()");
            state.a(viewRequireView, this.f4690a);
            operation.f4707i = false;
        }
    }

    public abstract void b(ArrayList arrayList, boolean z);

    public final void c(ArrayList operations) {
        Intrinsics.checkNotNullParameter(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            CollectionsKt.i(arrayList, ((Operation) it.next()).f4709k);
        }
        List listE0 = CollectionsKt.e0(CollectionsKt.h0(arrayList));
        int size = listE0.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Effect) listE0.get(i2)).d(this.f4690a);
        }
        int size2 = operations.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a((Operation) operations.get(i3));
        }
        List listE02 = CollectionsKt.e0(operations);
        int size3 = listE02.size();
        for (int i4 = 0; i4 < size3; i4++) {
            Operation operation = (Operation) listE02.get(i4);
            if (operation.f4709k.isEmpty()) {
                operation.b();
            }
        }
    }

    public final void d(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        synchronized (this.f4691b) {
            try {
                Fragment fragment = fragmentStateManager.f4621c;
                Intrinsics.checkNotNullExpressionValue(fragment, "fragmentStateManager.fragment");
                Operation operationJ = j(fragment);
                if (operationJ == null) {
                    Fragment fragment2 = fragmentStateManager.f4621c;
                    if (fragment2.mTransitioning) {
                        Intrinsics.checkNotNullExpressionValue(fragment2, "fragmentStateManager.fragment");
                        operationJ = k(fragment2);
                    } else {
                        operationJ = null;
                    }
                }
                if (operationJ != null) {
                    operationJ.d(state, lifecycleImpact);
                    return;
                }
                FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager);
                this.f4691b.add(fragmentStateManagerOperation);
                j listener = new j(this, fragmentStateManagerOperation, 0);
                Intrinsics.checkNotNullParameter(listener, "listener");
                fragmentStateManagerOperation.f4702d.add(listener);
                j listener2 = new j(this, fragmentStateManagerOperation, 1);
                Intrinsics.checkNotNullParameter(listener2, "listener");
                fragmentStateManagerOperation.f4702d.add(listener2);
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(Operation.State finalState, FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(finalState, "finalState");
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.O(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.f4621c);
        }
        d(finalState, Operation.LifecycleImpact.f4711b, fragmentStateManager);
    }

    public final void f(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.O(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.f4621c);
        }
        d(Operation.State.f4716c, Operation.LifecycleImpact.f4710a, fragmentStateManager);
    }

    public final void g(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.O(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.f4621c);
        }
        d(Operation.State.f4714a, Operation.LifecycleImpact.f4712c, fragmentStateManager);
    }

    public final void h(FragmentStateManager fragmentStateManager) {
        Intrinsics.checkNotNullParameter(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.O(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.f4621c);
        }
        d(Operation.State.f4715b, Operation.LifecycleImpact.f4710a, fragmentStateManager);
    }

    public final void i() {
        if (this.f4695f) {
            return;
        }
        if (!this.f4690a.isAttachedToWindow()) {
            l();
            this.f4694e = false;
            return;
        }
        synchronized (this.f4691b) {
            try {
                ArrayList arrayListF0 = CollectionsKt.f0(this.f4692c);
                this.f4692c.clear();
                Iterator it = arrayListF0.iterator();
                while (it.hasNext()) {
                    Operation operation = (Operation) it.next();
                    operation.f4705g = !this.f4691b.isEmpty() && operation.f4701c.mTransitioning;
                }
                Iterator it2 = arrayListF0.iterator();
                while (it2.hasNext()) {
                    Operation operation2 = (Operation) it2.next();
                    if (this.f4693d) {
                        if (FragmentManager.O(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Completing non-seekable operation " + operation2);
                        }
                        operation2.b();
                    } else {
                        if (FragmentManager.O(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation2);
                        }
                        operation2.a(this.f4690a);
                    }
                    this.f4693d = false;
                    if (!operation2.f4704f) {
                        this.f4692c.add(operation2);
                    }
                }
                if (!this.f4691b.isEmpty()) {
                    q();
                    ArrayList arrayListF02 = CollectionsKt.f0(this.f4691b);
                    if (arrayListF02.isEmpty()) {
                        return;
                    }
                    this.f4691b.clear();
                    this.f4692c.addAll(arrayListF02);
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    b(arrayListF02, this.f4694e);
                    boolean zN = n(arrayListF02);
                    Iterator it3 = arrayListF02.iterator();
                    boolean z = true;
                    while (it3.hasNext()) {
                        if (!((Operation) it3.next()).f4701c.mTransitioning) {
                            z = false;
                        }
                    }
                    this.f4693d = z && !zN;
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Operation seekable = " + zN + " \ntransition = " + z);
                    }
                    if (!z) {
                        p(arrayListF02);
                        c(arrayListF02);
                    } else if (zN) {
                        p(arrayListF02);
                        int size = arrayListF02.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            a((Operation) arrayListF02.get(i2));
                        }
                    }
                    this.f4694e = false;
                    if (FragmentManager.O(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Operation j(Fragment fragment) {
        Object next;
        Iterator it = this.f4691b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (Intrinsics.b(operation.f4701c, fragment) && !operation.f4703e) {
                break;
            }
        }
        return (Operation) next;
    }

    public final Operation k(Fragment fragment) {
        Object next;
        Iterator it = this.f4692c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (Intrinsics.b(operation.f4701c, fragment) && !operation.f4703e) {
                break;
            }
        }
        return (Operation) next;
    }

    public final void l() {
        String str;
        String str2;
        if (FragmentManager.O(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.f4690a.isAttachedToWindow();
        synchronized (this.f4691b) {
            try {
                q();
                p(this.f4691b);
                ArrayList arrayListF0 = CollectionsKt.f0(this.f4692c);
                Iterator it = arrayListF0.iterator();
                while (it.hasNext()) {
                    ((Operation) it.next()).f4705g = false;
                }
                Iterator it2 = arrayListF0.iterator();
                while (it2.hasNext()) {
                    Operation operation = (Operation) it2.next();
                    if (FragmentManager.O(2)) {
                        if (zIsAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f4690a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str2 + "Cancelling running operation " + operation);
                    }
                    operation.a(this.f4690a);
                }
                ArrayList arrayListF02 = CollectionsKt.f0(this.f4691b);
                Iterator it3 = arrayListF02.iterator();
                while (it3.hasNext()) {
                    ((Operation) it3.next()).f4705g = false;
                }
                Iterator it4 = arrayListF02.iterator();
                while (it4.hasNext()) {
                    Operation operation2 = (Operation) it4.next();
                    if (FragmentManager.O(2)) {
                        if (zIsAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.f4690a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str + "Cancelling pending operation " + operation2);
                    }
                    operation2.a(this.f4690a);
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o() {
        Object objPrevious;
        synchronized (this.f4691b) {
            try {
                q();
                ArrayList arrayList = this.f4691b;
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    Operation operation = (Operation) objPrevious;
                    View view = operation.f4701c.mView;
                    Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                    Operation.State stateA = Operation.State.Companion.a(view);
                    Operation.State state = operation.f4699a;
                    Operation.State state2 = Operation.State.f4715b;
                    if (state == state2 && stateA != state2) {
                        break;
                    }
                }
                Operation operation2 = (Operation) objPrevious;
                Fragment fragment = operation2 != null ? operation2.f4701c : null;
                this.f4695f = fragment != null ? fragment.isPostponed() : false;
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Operation) arrayList.get(i2)).e();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CollectionsKt.i(arrayList2, ((Operation) it.next()).f4709k);
        }
        List listE0 = CollectionsKt.e0(CollectionsKt.h0(arrayList2));
        int size2 = listE0.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((Effect) listE0.get(i3)).g(this.f4690a);
        }
    }

    public final void q() {
        Iterator it = this.f4691b.iterator();
        while (it.hasNext()) {
            Operation operation = (Operation) it.next();
            if (operation.f4700b == Operation.LifecycleImpact.f4711b) {
                View viewRequireView = operation.f4701c.requireView();
                Intrinsics.checkNotNullExpressionValue(viewRequireView, "fragment.requireView()");
                operation.d(Operation.State.Companion.b(viewRequireView.getVisibility()), Operation.LifecycleImpact.f4710a);
            }
        }
    }
}
