package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class TransitionManager {

    /* renamed from: a, reason: collision with root package name */
    public static final AutoTransition f12149a = new AutoTransition();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f12150b = new ThreadLocal();

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f12151c = new ArrayList();

    public static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public Transition f12152a;

        /* renamed from: b, reason: collision with root package name */
        public ViewGroup f12153b;

        /* JADX WARN: Removed duplicated region for block: B:101:0x020e  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x02a9  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x02d7  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x02dd  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x01e6 A[EDGE_INSN: B:154:0x01e6->B:91:0x01e6 BREAK  A[LOOP:1: B:19:0x0084->B:90:0x01dc], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01ed  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean onPreDraw() {
            /*
                Method dump skipped, instructions count: 771
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionManager.MultiListener.onPreDraw():boolean");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            ViewGroup viewGroup = this.f12153b;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            ArrayList arrayList = TransitionManager.f12151c;
            ViewGroup viewGroup2 = this.f12153b;
            arrayList.remove(viewGroup2);
            ArrayList arrayList2 = (ArrayList) TransitionManager.b().get(viewGroup2);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).D(viewGroup2);
                }
            }
            this.f12152a.i(true);
        }
    }

    public TransitionManager() {
        new ArrayMap();
        new ArrayMap();
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = f12151c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (transition == null) {
            transition = f12149a;
        }
        Transition transitionClone = transition.clone();
        c(viewGroup, transitionClone);
        viewGroup.setTag(R.id.transition_current_scene, null);
        MultiListener multiListener = new MultiListener();
        multiListener.f12152a = transitionClone;
        multiListener.f12153b = viewGroup;
        viewGroup.addOnAttachStateChangeListener(multiListener);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
    }

    public static ArrayMap b() {
        ArrayMap arrayMap;
        ThreadLocal threadLocal = f12150b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap arrayMap2 = new ArrayMap();
        threadLocal.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    public static void c(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).z(viewGroup);
            }
        }
        if (transition != null) {
            transition.h(viewGroup, true);
        }
        if (((Scene) viewGroup.getTag(R.id.transition_current_scene)) != null) {
            throw null;
        }
    }
}
