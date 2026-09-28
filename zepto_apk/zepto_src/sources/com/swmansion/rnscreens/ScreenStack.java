package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.brentvatne.common.react.r;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategyBase;
import com.swmansion.rnscreens.stack.views.ReverseFromIndex;
import com.swmansion.rnscreens.stack.views.ReverseOrder;
import com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout;
import com.swmansion.rnscreens.utils.FragmentTransactionKtKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.DropWhileSequence;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TakeWhileSequence;
import kotlin.sequences.TransformingSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ScreenStack extends ScreenContainer {
    public static final /* synthetic */ int r = 0;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f47015i;

    /* renamed from: j, reason: collision with root package name */
    public final HashSet f47016j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f47017k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f47018l;

    /* renamed from: m, reason: collision with root package name */
    public ScreenStackFragmentWrapper f47019m;
    public boolean n;
    public ChildrenDrawingOrderStrategyBase o;
    public final ArrayList p;
    public boolean q;

    @Metadata
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final boolean a(ScreenFragmentWrapper screenFragmentWrapper, Screen.StackAnimation stackAnimation) {
            int i2 = ScreenStack.r;
            if (stackAnimation == null) {
                stackAnimation = screenFragmentWrapper.k().getStackAnimation();
            }
            return (Build.VERSION.SDK_INT >= 33 || stackAnimation == Screen.StackAnimation.f46961d || stackAnimation == Screen.StackAnimation.f46964g || stackAnimation == Screen.StackAnimation.f46965h || stackAnimation == Screen.StackAnimation.f46966i) && stackAnimation != Screen.StackAnimation.f46959b;
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public final class DrawingOp {

        /* renamed from: a, reason: collision with root package name */
        public Canvas f47020a;

        /* renamed from: b, reason: collision with root package name */
        public View f47021b;

        /* renamed from: c, reason: collision with root package name */
        public long f47022c;

        public DrawingOp() {
        }

        public final void a() {
            ScreenStack.j(ScreenStack.this, this);
            this.f47020a = null;
            this.f47021b = null;
            this.f47022c = 0L;
        }

        public final Canvas b() {
            return this.f47020a;
        }

        public final View c() {
            return this.f47021b;
        }

        public final long d() {
            return this.f47022c;
        }

        public final void e(Canvas canvas) {
            this.f47020a = canvas;
        }

        public final void f(View view) {
            this.f47021b = view;
        }

        public final void g(long j2) {
            this.f47022c = j2;
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47024a;

        static {
            int[] iArr = new int[Screen.StackPresentation.values().length];
            try {
                Screen.StackPresentation stackPresentation = Screen.StackPresentation.f46969a;
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f47024a = iArr;
        }
    }

    public ScreenStack(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f47015i = new ArrayList();
        this.f47016j = new HashSet();
        this.f47017k = new ArrayList();
        this.f47018l = new ArrayList();
        this.p = new ArrayList();
    }

    public static final void j(ScreenStack screenStack, DrawingOp drawingOp) {
        Canvas canvasB = drawingOp.b();
        Intrinsics.c(canvasB);
        super.drawChild(canvasB, drawingOp.c(), drawingOp.d());
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public final ScreenFragmentWrapper a(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return WhenMappings.f47024a[screen.getStackPresentation().ordinal()] == 1 ? new ScreenStackFragment(screen) : new ScreenStackFragment(screen);
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public final boolean c(ScreenFragmentWrapper screenFragmentWrapper) {
        return CollectionsKt.s(this.f46990a, screenFragmentWrapper) && !CollectionsKt.s(this.f47016j, screenFragmentWrapper);
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public final void d() {
        Iterator it = this.f47015i.iterator();
        while (it.hasNext()) {
            ((ScreenStackFragmentWrapper) it.next()).p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        ChildrenDrawingOrderStrategyBase childrenDrawingOrderStrategyBase = this.o;
        if (childrenDrawingOrderStrategyBase != null) {
            childrenDrawingOrderStrategyBase.a(this.f47018l);
        }
        ArrayList arrayList = this.f47018l;
        this.f47018l = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            DrawingOp drawingOp = (DrawingOp) it.next();
            drawingOp.a();
            this.f47017k.add(drawingOp);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View child, long j2) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        ArrayList arrayList = this.f47018l;
        ArrayList arrayList2 = this.f47017k;
        DrawingOp drawingOp = arrayList2.isEmpty() ? new DrawingOp() : (DrawingOp) arrayList2.remove(CollectionsKt.B(arrayList2));
        drawingOp.e(canvas);
        drawingOp.f(child);
        drawingOp.g(j2);
        arrayList.add(drawingOp);
        return true;
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ChildrenDrawingOrderStrategyBase childrenDrawingOrderStrategyBase;
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        ArrayList arrayList = this.p;
        arrayList.remove(view);
        if (arrayList.isEmpty() && (childrenDrawingOrderStrategyBase = this.o) != null) {
            childrenDrawingOrderStrategyBase.b();
        }
        if (this.n) {
            this.n = false;
            k();
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public final void f() {
        Screen.StackAnimation stackAnimation;
        boolean z;
        ScreenStackFragmentWrapper screenStackFragmentWrapper;
        ScreenContentWrapper contentWrapper;
        CustomToolbar toolbar;
        ScreenStackFragmentWrapper screenStackFragmentWrapper2;
        CustomToolbar toolbar2;
        Object obj;
        Screen screenK;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        this.o = null;
        ArrayList arrayList = this.f46990a;
        final int i2 = 0;
        FilteringSequence filteringSequenceG = SequencesKt.g(CollectionsKt.n(CollectionsKt.m(arrayList)), new Function1(this) { // from class: com.swmansion.rnscreens.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ScreenStack f47085b;

            {
                this.f47085b = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                ScreenStack screenStack = this.f47085b;
                switch (i2) {
                    case 0:
                        ScreenFragmentWrapper it = (ScreenFragmentWrapper) obj2;
                        int i3 = ScreenStack.r;
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf((CollectionsKt.s(screenStack.f47016j, it) || it.k().getActivityState() == Screen.ActivityState.f46949a) ? false : true);
                    default:
                        ScreenStackFragmentWrapper wrapper = (ScreenStackFragmentWrapper) obj2;
                        int i4 = ScreenStack.r;
                        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
                        if (screenStack.f46990a.contains(wrapper) && !screenStack.f47016j.contains(wrapper)) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                }
            }
        });
        objectRef.f53801a = SequencesKt.h(filteringSequenceG);
        r predicate = new r(12);
        Intrinsics.checkNotNullParameter(filteringSequenceG, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) SequencesKt.h(new DropWhileSequence(filteringSequenceG, predicate));
        if (screenFragmentWrapper == null || screenFragmentWrapper == objectRef.f53801a) {
            screenFragmentWrapper = null;
        }
        objectRef2.f53801a = screenFragmentWrapper;
        ArrayList arrayList2 = this.f47015i;
        boolean zS = CollectionsKt.s(arrayList2, objectRef.f53801a);
        Object obj2 = objectRef.f53801a;
        ScreenStackFragmentWrapper screenStackFragmentWrapper3 = this.f47019m;
        boolean z2 = obj2 != screenStackFragmentWrapper3;
        if (obj2 == null || zS) {
            if (obj2 == null || screenStackFragmentWrapper3 == null || !z2) {
                stackAnimation = null;
                z = true;
            } else {
                Screen screenK2 = screenStackFragmentWrapper3.k();
                stackAnimation = screenK2 != null ? screenK2.getStackAnimation() : null;
                z = false;
            }
        } else if (screenStackFragmentWrapper3 != null) {
            z = (arrayList.contains(screenStackFragmentWrapper3)) || (((ScreenFragmentWrapper) objectRef.f53801a).k().getReplaceAnimation() == Screen.ReplaceAnimation.f46954a);
            if (z) {
                screenK = ((ScreenFragmentWrapper) objectRef.f53801a).k();
            } else {
                ScreenStackFragmentWrapper screenStackFragmentWrapper4 = this.f47019m;
                if (screenStackFragmentWrapper4 == null || (screenK = screenStackFragmentWrapper4.k()) == null) {
                    stackAnimation = null;
                }
            }
            stackAnimation = screenK.getStackAnimation();
        } else {
            stackAnimation = Screen.StackAnimation.f46959b;
            this.q = true;
            z = true;
        }
        this.q = z;
        if (z && (obj = objectRef.f53801a) != null && Companion.a((ScreenFragmentWrapper) obj, stackAnimation) && objectRef2.f53801a == null) {
            this.o = new ReverseOrder();
        } else if (objectRef.f53801a != null && zS && (screenStackFragmentWrapper = this.f47019m) != null && screenStackFragmentWrapper.l() && !((ScreenFragmentWrapper) objectRef.f53801a).l()) {
            CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1N = CollectionsKt.n(CollectionsKt.m(arrayList2));
            final int i3 = 0;
            Function1 predicate2 = new Function1() { // from class: com.swmansion.rnscreens.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    Ref.ObjectRef objectRef3 = objectRef;
                    switch (i3) {
                        case 0:
                            ScreenStackFragmentWrapper it = (ScreenStackFragmentWrapper) obj3;
                            int i4 = ScreenStack.r;
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (it != objectRef3.f53801a && it.l()) {
                                z = true;
                            }
                            return Boolean.valueOf(z);
                        case 1:
                            ScreenFragmentWrapper it2 = (ScreenFragmentWrapper) obj3;
                            int i5 = ScreenStack.r;
                            Intrinsics.checkNotNullParameter(it2, "it");
                            return Boolean.valueOf(it2 != objectRef3.f53801a);
                        default:
                            ScreenFragmentWrapper it3 = (ScreenFragmentWrapper) obj3;
                            int i6 = ScreenStack.r;
                            Intrinsics.checkNotNullParameter(it3, "it");
                            return Boolean.valueOf(it3 != objectRef3.f53801a);
                    }
                }
            };
            Intrinsics.checkNotNullParameter(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1N, "<this>");
            Intrinsics.checkNotNullParameter(predicate2, "predicate");
            int iE = SequencesKt.e(new TakeWhileSequence(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1N, predicate2));
            if (iE > 1) {
                this.o = new ReverseFromIndex(Math.max((CollectionsKt.B(arrayList2) - iE) + 1, 0));
            }
        }
        FragmentTransaction fragmentTransactionB = b();
        if (stackAnimation != null) {
            FragmentTransactionKtKt.a(fragmentTransactionB, stackAnimation, z);
        }
        final int i4 = 1;
        FilteringSequence.AnonymousClass1 anonymousClass1 = new FilteringSequence.AnonymousClass1();
        while (anonymousClass1.hasNext()) {
            fragmentTransactionB.i(((ScreenStackFragmentWrapper) anonymousClass1.next()).j());
        }
        CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1N2 = CollectionsKt.n(arrayList);
        final int i5 = 1;
        Function1 predicate3 = new Function1() { // from class: com.swmansion.rnscreens.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                Ref.ObjectRef objectRef3 = objectRef2;
                switch (i5) {
                    case 0:
                        ScreenStackFragmentWrapper it = (ScreenStackFragmentWrapper) obj3;
                        int i42 = ScreenStack.r;
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it != objectRef3.f53801a && it.l()) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    case 1:
                        ScreenFragmentWrapper it2 = (ScreenFragmentWrapper) obj3;
                        int i52 = ScreenStack.r;
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return Boolean.valueOf(it2 != objectRef3.f53801a);
                    default:
                        ScreenFragmentWrapper it3 = (ScreenFragmentWrapper) obj3;
                        int i6 = ScreenStack.r;
                        Intrinsics.checkNotNullParameter(it3, "it");
                        return Boolean.valueOf(it3 != objectRef3.f53801a);
                }
            }
        };
        Intrinsics.checkNotNullParameter(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1N2, "<this>");
        Intrinsics.checkNotNullParameter(predicate3, "predicate");
        FilteringSequence.AnonymousClass1 anonymousClass12 = new FilteringSequence.AnonymousClass1();
        while (anonymousClass12.hasNext()) {
            fragmentTransactionB.i(((ScreenFragmentWrapper) anonymousClass12.next()).j());
        }
        Object obj3 = objectRef2.f53801a;
        if (obj3 == null || ((ScreenFragmentWrapper) obj3).j().isAdded()) {
            Object obj4 = objectRef.f53801a;
            if (obj4 != null && !((ScreenFragmentWrapper) obj4).j().isAdded()) {
                Screen screenK3 = ((ScreenFragmentWrapper) objectRef.f53801a).k();
                Intrinsics.checkNotNullParameter(screenK3, "<this>");
                if (SheetUtilsKt.c(screenK3) && (!SheetUtilsKt.a(screenK3) || (contentWrapper = screenK3.getContentWrapper()) == null || !SheetUtilsKt.a(contentWrapper))) {
                    ((ScreenFragmentWrapper) objectRef.f53801a).j().postponeEnterTransition();
                }
                fragmentTransactionB.h(getId(), ((ScreenFragmentWrapper) objectRef.f53801a).j(), null, 1);
            }
        } else {
            ScreenFragmentWrapper screenFragmentWrapper2 = (ScreenFragmentWrapper) objectRef.f53801a;
            CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1N3 = CollectionsKt.n(arrayList);
            final int i6 = 2;
            Function1 predicate4 = new Function1() { // from class: com.swmansion.rnscreens.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj32) {
                    Ref.ObjectRef objectRef3 = objectRef2;
                    switch (i6) {
                        case 0:
                            ScreenStackFragmentWrapper it = (ScreenStackFragmentWrapper) obj32;
                            int i42 = ScreenStack.r;
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (it != objectRef3.f53801a && it.l()) {
                                z = true;
                            }
                            return Boolean.valueOf(z);
                        case 1:
                            ScreenFragmentWrapper it2 = (ScreenFragmentWrapper) obj32;
                            int i52 = ScreenStack.r;
                            Intrinsics.checkNotNullParameter(it2, "it");
                            return Boolean.valueOf(it2 != objectRef3.f53801a);
                        default:
                            ScreenFragmentWrapper it3 = (ScreenFragmentWrapper) obj32;
                            int i62 = ScreenStack.r;
                            Intrinsics.checkNotNullParameter(it3, "it");
                            return Boolean.valueOf(it3 != objectRef3.f53801a);
                    }
                }
            };
            Intrinsics.checkNotNullParameter(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1N3, "<this>");
            Intrinsics.checkNotNullParameter(predicate4, "predicate");
            Iterator it = new DropWhileSequence(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1N3, predicate4).iterator();
            while (true) {
                DropWhileSequence.AnonymousClass1 anonymousClass13 = (DropWhileSequence.AnonymousClass1) it;
                if (!anonymousClass13.hasNext()) {
                    break;
                }
                fragmentTransactionB.h(getId(), ((ScreenFragmentWrapper) anonymousClass13.next()).j(), null, 1);
                com.swmansion.gesturehandler.react.b bVar = new com.swmansion.gesturehandler.react.b(screenFragmentWrapper2, 1);
                fragmentTransactionB.g();
                if (fragmentTransactionB.s == null) {
                    fragmentTransactionB.s = new ArrayList();
                }
                fragmentTransactionB.s.add(bVar);
            }
        }
        Object obj5 = objectRef.f53801a;
        this.f47019m = obj5 instanceof ScreenStackFragmentWrapper ? (ScreenStackFragmentWrapper) obj5 : null;
        arrayList2.clear();
        TransformingSequence elements = SequencesKt.m(CollectionsKt.n(arrayList), new r(13));
        Intrinsics.checkNotNullParameter(arrayList2, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        TransformingSequence.AnonymousClass1 anonymousClass14 = new TransformingSequence.AnonymousClass1();
        while (anonymousClass14.f53946a.hasNext()) {
            arrayList2.add(anonymousClass14.next());
        }
        ScreenFragmentWrapper screenFragmentWrapper3 = (ScreenFragmentWrapper) objectRef2.f53801a;
        if (arrayList.size() > 1 && screenFragmentWrapper3 != null && (screenStackFragmentWrapper2 = this.f47019m) != null && screenStackFragmentWrapper2.l()) {
            IntRange indices = RangesKt.f(0, arrayList.size() - 1);
            Intrinsics.checkNotNullParameter(arrayList, "<this>");
            Intrinsics.checkNotNullParameter(indices, "indices");
            for (ScreenFragmentWrapper screenFragmentWrapper4 : CollectionsKt.l(indices.isEmpty() ? EmptyList.f53609a : CollectionsKt.e0(arrayList.subList(indices.f53838a, indices.f53839b + 1)))) {
                Screen screenK4 = screenFragmentWrapper4.k();
                screenK4.setImportantForAccessibility(4);
                ScreenStackHeaderConfig headerConfig = screenK4.getHeaderConfig();
                if (headerConfig != null && (toolbar2 = headerConfig.getToolbar()) != null) {
                    toolbar2.setImportantForAccessibility(4);
                }
                if (screenFragmentWrapper4.equals(screenFragmentWrapper3)) {
                    break;
                }
            }
        }
        Screen topScreen = getTopScreen();
        if (topScreen != null) {
            topScreen.setImportantForAccessibility(0);
            ScreenStackHeaderConfig headerConfig2 = topScreen.getHeaderConfig();
            if (headerConfig2 != null && (toolbar = headerConfig2.getToolbar()) != null) {
                toolbar.setImportantForAccessibility(0);
            }
        }
        fragmentTransactionB.f();
    }

    @NotNull
    public final ArrayList<ScreenStackFragmentWrapper> getFragments() {
        return this.f47015i;
    }

    public final boolean getGoingForward() {
        return this.q;
    }

    @NotNull
    public final Screen getRootScreen() {
        Object next;
        Screen screenK;
        Iterator it = this.f46990a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!CollectionsKt.s(this.f47016j, (ScreenFragmentWrapper) next)) {
                break;
            }
        }
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) next;
        if (screenFragmentWrapper == null || (screenK = screenFragmentWrapper.k()) == null) {
            throw new IllegalStateException("[RNScreens] Stack has no root screen set");
        }
        return screenK;
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    @Nullable
    public Screen getTopScreen() {
        ScreenStackFragmentWrapper screenStackFragmentWrapper = this.f47019m;
        if (screenStackFragmentWrapper != null) {
            return screenStackFragmentWrapper.k();
        }
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public final void h() {
        this.f47016j.clear();
        super.h();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public final void i(int i2) {
        HashSet hashSet = this.f47016j;
        Object obj = this.f46990a.get(i2);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) obj;
        if ((hashSet instanceof KMappedMarker) && !(hashSet instanceof KMutableCollection)) {
            TypeIntrinsics.d(hashSet, "kotlin.collections.MutableCollection");
            throw null;
        }
        hashSet.remove(screenFragmentWrapper);
        super.i(i2);
    }

    public final void k() {
        int iE = UIManagerHelper.e(this);
        Context context = getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherB = UIManagerHelper.b((ReactContext) context, getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new StackFinishTransitioningEvent(iE, getId()));
        }
    }

    public final void setGoingForward(boolean z) {
        this.q = z;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        ChildrenDrawingOrderStrategyBase childrenDrawingOrderStrategyBase;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof ScreensCoordinatorLayout)) {
            throw new IllegalStateException(("[RNScreens] Unexpected type of ScreenStack direct subview " + view.getClass()).toString());
        }
        super.startViewTransition(view);
        boolean zIsRemoving = ((ScreensCoordinatorLayout) view).getFragment$react_native_screens_release().isRemoving();
        ArrayList arrayList = this.p;
        if (zIsRemoving) {
            arrayList.add(view);
        }
        if (!arrayList.isEmpty() && (childrenDrawingOrderStrategyBase = this.o) != null) {
            childrenDrawingOrderStrategyBase.c();
        }
        this.n = true;
    }
}
