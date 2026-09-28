package androidx.transition;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.fragment.app.c;
import androidx.media3.exoplayer.analytics.q;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void a(View view, Object obj) {
        ((Transition) obj).b(view);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void b(Object obj, ArrayList arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int size = transitionSet.F.size();
            while (i2 < size) {
                b(transitionSet.Q(i2), arrayList);
                i2++;
            }
            return;
        }
        if (FragmentTransitionImpl.k(transition.f12119e) && FragmentTransitionImpl.k(transition.f12120f)) {
            int size2 = arrayList.size();
            while (i2 < size2) {
                transition.b((View) arrayList.get(i2));
                i2++;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void c(Object obj) {
        ((TransitionSeekController) obj).d();
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void d(Object obj, androidx.fragment.app.b bVar) {
        ((TransitionSeekController) obj).k(bVar);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void e(ViewGroup viewGroup, Object obj) {
        TransitionManager.a(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final boolean g(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object h(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object i(ViewGroup viewGroup, Object obj) {
        Transition transition = (Transition) obj;
        ArrayList arrayList = TransitionManager.f12151c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut() || Build.VERSION.SDK_INT < 34) {
            return null;
        }
        if (!transition.v()) {
            throw new IllegalArgumentException("The Transition must support seeking.");
        }
        arrayList.add(viewGroup);
        Transition transitionClone = transition.clone();
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.P(transitionClone);
        TransitionManager.c(viewGroup, transitionSet);
        viewGroup.setTag(R.id.transition_current_scene, null);
        TransitionManager.MultiListener multiListener = new TransitionManager.MultiListener();
        multiListener.f12152a = transitionSet;
        multiListener.f12153b = viewGroup;
        viewGroup.addOnAttachStateChangeListener(multiListener);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        viewGroup.invalidate();
        Transition.SeekController seekController = new Transition.SeekController(transitionSet);
        transitionSet.z = seekController;
        transitionSet.a(seekController);
        return transitionSet.z;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final boolean l() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final boolean m(Object obj) {
        boolean zV = ((Transition) obj).v();
        if (!zV) {
            Log.v("FragmentManager", "Predictive back not available for AndroidX Transition " + obj + ". Please enable seeking support for the designated transition by overriding isSeekingSupported().");
        }
        return zV;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object n(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.P(transition);
            transitionSet.P(transition2);
            transitionSet.T(1);
            transition = transitionSet;
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet2 = new TransitionSet();
        if (transition != null) {
            transitionSet2.P(transition);
        }
        transitionSet2.P(transition3);
        return transitionSet2;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object o(Object obj, Object obj2) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.P((Transition) obj);
        }
        transitionSet.P((Transition) obj2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void p(Object obj, final View view, final ArrayList arrayList) {
        ((Transition) obj).a(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.2
            @Override // androidx.transition.Transition.TransitionListener
            public final void h(Transition transition) {
                transition.B(this);
                transition.a(this);
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void j(Transition transition) {
                transition.B(this);
                view.setVisibility(8);
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((View) arrayList2.get(i2)).setVisibility(0);
                }
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void l(Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void b() {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void f() {
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void q(Object obj, final Object obj2, final ArrayList arrayList, final Object obj3, final ArrayList arrayList2) {
        ((Transition) obj).a(new TransitionListenerAdapter() { // from class: androidx.transition.FragmentTransitionSupport.3
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public final void h(Transition transition) {
                FragmentTransitionSupport fragmentTransitionSupport = FragmentTransitionSupport.this;
                Object obj4 = obj2;
                if (obj4 != null) {
                    fragmentTransitionSupport.z(obj4, arrayList, null);
                }
                Object obj5 = obj3;
                if (obj5 != null) {
                    fragmentTransitionSupport.z(obj5, arrayList2, null);
                }
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public final void j(Transition transition) {
                transition.B(this);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void r(Object obj, float f2) {
        TransitionSeekController transitionSeekController = (TransitionSeekController) obj;
        if (transitionSeekController.a()) {
            long jG = (long) (f2 * transitionSeekController.g());
            if (jG == 0) {
                jG = 1;
            }
            if (jG == transitionSeekController.g()) {
                jG = transitionSeekController.g() - 1;
            }
            transitionSeekController.i(jG);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void s(View view, Object obj) {
        if (view != null) {
            final Rect rect = new Rect();
            FragmentTransitionImpl.j(rect, view);
            ((Transition) obj).H(new Transition.EpicenterCallback() { // from class: androidx.transition.FragmentTransitionSupport.1
                @Override // androidx.transition.Transition.EpicenterCallback
                public final Rect a() {
                    return rect;
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void t(Object obj, final Rect rect) {
        ((Transition) obj).H(new Transition.EpicenterCallback() { // from class: androidx.transition.FragmentTransitionSupport.5
            @Override // androidx.transition.Transition.EpicenterCallback
            public final Rect a() {
                Rect rect2 = rect;
                if (rect2.isEmpty()) {
                    return null;
                }
                return rect2;
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void u(Fragment fragment, Object obj, CancellationSignal cancellationSignal, Runnable runnable) {
        v(obj, cancellationSignal, null, runnable);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void v(Object obj, CancellationSignal cancellationSignal, c cVar, final Runnable runnable) {
        Transition transition = (Transition) obj;
        q qVar = new q(cVar, transition, runnable, 1);
        synchronized (cancellationSignal) {
            while (cancellationSignal.f2876d) {
                try {
                    try {
                        cancellationSignal.wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (cancellationSignal.f2874b != qVar) {
                cancellationSignal.f2874b = qVar;
                if (cancellationSignal.f2873a) {
                    qVar.b();
                }
            }
        }
        transition.a(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.4
            @Override // androidx.transition.Transition.TransitionListener
            public final void h(Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void j(Transition transition2) {
                runnable.run();
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void l(Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void b() {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void f() {
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void w(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        ArrayList arrayList2 = transitionSet.f12120f;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransitionImpl.f((View) arrayList.get(i2), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void x(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            ArrayList arrayList3 = transitionSet.f12120f;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            z(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object y(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.P((Transition) obj);
        return transitionSet;
    }

    public final void z(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int size = transitionSet.F.size();
            while (i2 < size) {
                z(transitionSet.Q(i2), arrayList, arrayList2);
                i2++;
            }
            return;
        }
        if (FragmentTransitionImpl.k(transition.f12119e)) {
            ArrayList arrayList3 = transition.f12120f;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                while (i2 < size2) {
                    transition.b((View) arrayList2.get(i2));
                    i2++;
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    transition.C((View) arrayList.get(size3));
                }
            }
        }
    }
}
