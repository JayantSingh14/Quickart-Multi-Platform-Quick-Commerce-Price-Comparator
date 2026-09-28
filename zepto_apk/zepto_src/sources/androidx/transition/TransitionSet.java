package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class TransitionSet extends Transition {
    public ArrayList F;
    public boolean G;
    public int H;
    public boolean I;
    public int J;

    public static class TransitionSetListener extends TransitionListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public TransitionSet f12158a;

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void h(Transition transition) {
            TransitionSet transitionSet = this.f12158a;
            if (transitionSet.I) {
                return;
            }
            transitionSet.M();
            transitionSet.I = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void j(Transition transition) {
            TransitionSet transitionSet = this.f12158a;
            int i2 = transitionSet.H - 1;
            transitionSet.H = i2;
            if (i2 == 0) {
                transitionSet.I = false;
                transitionSet.m();
            }
            transition.B(this);
        }
    }

    public TransitionSet() {
        this.F = new ArrayList();
        this.G = true;
        this.I = false;
        this.J = 0;
    }

    @Override // androidx.transition.Transition
    public final void A() {
        this.y = 0L;
        TransitionListenerAdapter transitionListenerAdapter = new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.2
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public final void l(Transition transition) {
                TransitionSet transitionSet = TransitionSet.this;
                transitionSet.F.remove(transition);
                if (transitionSet.u()) {
                    return;
                }
                transitionSet.y(transitionSet, Transition.TransitionNotification.f12146c, false);
                transitionSet.r = true;
                transitionSet.y(transitionSet, Transition.TransitionNotification.f12145b, false);
            }
        };
        for (int i2 = 0; i2 < this.F.size(); i2++) {
            Transition transition = (Transition) this.F.get(i2);
            transition.a(transitionListenerAdapter);
            transition.A();
            long j2 = transition.y;
            if (this.G) {
                this.y = Math.max(this.y, j2);
            } else {
                long j3 = this.y;
                transition.A = j3;
                this.y = j3 + j2;
            }
        }
    }

    @Override // androidx.transition.Transition
    public final Transition B(Transition.TransitionListener transitionListener) {
        super.B(transitionListener);
        return this;
    }

    @Override // androidx.transition.Transition
    public final void C(View view) {
        for (int i2 = 0; i2 < this.F.size(); i2++) {
            ((Transition) this.F.get(i2)).C(view);
        }
        this.f12120f.remove(view);
    }

    @Override // androidx.transition.Transition
    public final void D(View view) {
        super.D(view);
        int size = this.F.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Transition) this.F.get(i2)).D(view);
        }
    }

    @Override // androidx.transition.Transition
    public final void E() {
        if (this.F.isEmpty()) {
            M();
            m();
            return;
        }
        TransitionSetListener transitionSetListener = new TransitionSetListener();
        transitionSetListener.f12158a = this;
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).a(transitionSetListener);
        }
        this.H = this.F.size();
        if (this.G) {
            Iterator it2 = this.F.iterator();
            while (it2.hasNext()) {
                ((Transition) it2.next()).E();
            }
            return;
        }
        for (int i2 = 1; i2 < this.F.size(); i2++) {
            Transition transition = (Transition) this.F.get(i2 - 1);
            final Transition transition2 = (Transition) this.F.get(i2);
            transition.a(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public final void j(Transition transition3) {
                    transition2.E();
                    transition3.B(this);
                }
            });
        }
        Transition transition3 = (Transition) this.F.get(0);
        if (transition3 != null) {
            transition3.E();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(long r20, long r22) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionSet.F(long, long):void");
    }

    @Override // androidx.transition.Transition
    public final void H(Transition.EpicenterCallback epicenterCallback) {
        this.w = epicenterCallback;
        this.J |= 8;
        int size = this.F.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Transition) this.F.get(i2)).H(epicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    public final void J(PathMotion pathMotion) {
        super.J(pathMotion);
        this.J |= 4;
        if (this.F != null) {
            for (int i2 = 0; i2 < this.F.size(); i2++) {
                ((Transition) this.F.get(i2)).J(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void K(VisibilityPropagation visibilityPropagation) {
        this.v = visibilityPropagation;
        this.J |= 2;
        int size = this.F.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Transition) this.F.get(i2)).K(visibilityPropagation);
        }
    }

    @Override // androidx.transition.Transition
    public final void L(long j2) {
        this.f12116b = j2;
    }

    @Override // androidx.transition.Transition
    public final String O(String str) {
        String strO = super.O(str);
        for (int i2 = 0; i2 < this.F.size(); i2++) {
            StringBuilder sbX = android.support.v4.media.b.x(strO, StringUtils.LF);
            sbX.append(((Transition) this.F.get(i2)).O(str + "  "));
            strO = sbX.toString();
        }
        return strO;
    }

    public final void P(Transition transition) {
        this.F.add(transition);
        transition.f12123i = this;
        long j2 = this.f12117c;
        if (j2 >= 0) {
            transition.G(j2);
        }
        if ((this.J & 1) != 0) {
            transition.I(this.f12118d);
        }
        if ((this.J & 2) != 0) {
            transition.K(this.v);
        }
        if ((this.J & 4) != 0) {
            transition.J(this.x);
        }
        if ((this.J & 8) != 0) {
            transition.H(this.w);
        }
    }

    public final Transition Q(int i2) {
        if (i2 < 0 || i2 >= this.F.size()) {
            return null;
        }
        return (Transition) this.F.get(i2);
    }

    @Override // androidx.transition.Transition
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public final void G(long j2) {
        ArrayList arrayList;
        this.f12117c = j2;
        if (j2 < 0 || (arrayList = this.F) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Transition) this.F.get(i2)).G(j2);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public final void I(TimeInterpolator timeInterpolator) {
        this.J |= 1;
        ArrayList arrayList = this.F;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((Transition) this.F.get(i2)).I(timeInterpolator);
            }
        }
        this.f12118d = timeInterpolator;
    }

    public final void T(int i2) {
        if (i2 == 0) {
            this.G = true;
        } else {
            if (i2 != 1) {
                throw new AndroidRuntimeException(android.support.v4.media.b.f(i2, "Invalid parameter for TransitionSet ordering: "));
            }
            this.G = false;
        }
    }

    @Override // androidx.transition.Transition
    public final void b(View view) {
        for (int i2 = 0; i2 < this.F.size(); i2++) {
            ((Transition) this.F.get(i2)).b(view);
        }
        this.f12120f.add(view);
    }

    @Override // androidx.transition.Transition
    public final void cancel() {
        super.cancel();
        int size = this.F.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Transition) this.F.get(i2)).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public final void d(TransitionValues transitionValues) {
        if (x(transitionValues.f12164b)) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.x(transitionValues.f12164b)) {
                    transition.d(transitionValues);
                    transitionValues.f12165c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void f(TransitionValues transitionValues) {
        super.f(transitionValues);
        int size = this.F.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Transition) this.F.get(i2)).f(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public final void g(TransitionValues transitionValues) {
        if (x(transitionValues.f12164b)) {
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.x(transitionValues.f12164b)) {
                    transition.g(transitionValues);
                    transitionValues.f12165c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: j */
    public final Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.F = new ArrayList();
        int size = this.F.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transitionClone = ((Transition) this.F.get(i2)).clone();
            transitionSet.F.add(transitionClone);
            transitionClone.f12123i = transitionSet;
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    public final void l(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList arrayList, ArrayList arrayList2) {
        long j2 = this.f12116b;
        int size = this.F.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transition = (Transition) this.F.get(i2);
            if (j2 > 0 && (this.G || i2 == 0)) {
                long j3 = transition.f12116b;
                if (j3 > 0) {
                    transition.L(j3 + j2);
                } else {
                    transition.L(j2);
                }
            }
            transition.l(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    public final boolean u() {
        for (int i2 = 0; i2 < this.F.size(); i2++) {
            if (((Transition) this.F.get(i2)).u()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public final boolean v() {
        int size = this.F.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!((Transition) this.F.get(i2)).v()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.transition.Transition
    public final void z(ViewGroup viewGroup) {
        super.z(viewGroup);
        int size = this.F.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Transition) this.F.get(i2)).z(viewGroup);
        }
    }

    public TransitionSet(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = new ArrayList();
        this.G = true;
        this.I = false;
        this.J = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f12112g);
        T(TypedArrayUtils.f(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
