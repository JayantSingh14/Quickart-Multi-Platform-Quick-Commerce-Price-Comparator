package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.media.b;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    public static TimeInterpolator s;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f11381h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f11382i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f11383j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f11384k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f11385l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f11386m = new ArrayList();
    public final ArrayList n = new ArrayList();
    public final ArrayList o = new ArrayList();
    public final ArrayList p = new ArrayList();
    public final ArrayList q = new ArrayList();
    public final ArrayList r = new ArrayList();

    public static class ChangeInfo {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f11415a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.ViewHolder f11416b;

        /* renamed from: c, reason: collision with root package name */
        public int f11417c;

        /* renamed from: d, reason: collision with root package name */
        public int f11418d;

        /* renamed from: e, reason: collision with root package name */
        public int f11419e;

        /* renamed from: f, reason: collision with root package name */
        public int f11420f;

        public final String toString() {
            StringBuilder sb = new StringBuilder("ChangeInfo{oldHolder=");
            sb.append(this.f11415a);
            sb.append(", newHolder=");
            sb.append(this.f11416b);
            sb.append(", fromX=");
            sb.append(this.f11417c);
            sb.append(", fromY=");
            sb.append(this.f11418d);
            sb.append(", toX=");
            sb.append(this.f11419e);
            sb.append(", toY=");
            return b.n(sb, this.f11420f, '}');
        }
    }

    public static class MoveInfo {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f11421a;

        /* renamed from: b, reason: collision with root package name */
        public int f11422b;

        /* renamed from: c, reason: collision with root package name */
        public int f11423c;

        /* renamed from: d, reason: collision with root package name */
        public int f11424d;

        /* renamed from: e, reason: collision with root package name */
        public int f11425e;
    }

    public static void q(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((RecyclerView.ViewHolder) arrayList.get(size)).f11653a.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean g(RecyclerView.ViewHolder viewHolder, List list) {
        return !list.isEmpty() || f(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void i(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.f11653a;
        view.animate().cancel();
        ArrayList arrayList = this.f11383j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((MoveInfo) arrayList.get(size)).f11421a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                h(viewHolder);
                arrayList.remove(size);
            }
        }
        s(this.f11384k, viewHolder);
        if (this.f11381h.remove(viewHolder)) {
            view.setAlpha(1.0f);
            h(viewHolder);
        }
        if (this.f11382i.remove(viewHolder)) {
            view.setAlpha(1.0f);
            h(viewHolder);
        }
        ArrayList arrayList2 = this.n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            s(arrayList3, viewHolder);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f11386m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((MoveInfo) arrayList5.get(size4)).f11421a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    h(viewHolder);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.f11385l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(viewHolder)) {
                view.setAlpha(1.0f);
                h(viewHolder);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.q.remove(viewHolder);
        this.o.remove(viewHolder);
        this.r.remove(viewHolder);
        this.p.remove(viewHolder);
        r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void j() {
        ArrayList arrayList = this.f11383j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = (MoveInfo) arrayList.get(size);
            View view = moveInfo.f11421a.f11653a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            h(moveInfo.f11421a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f11381h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            h((RecyclerView.ViewHolder) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f11382i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) arrayList3.get(size3);
            viewHolder.f11653a.setAlpha(1.0f);
            h(viewHolder);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f11384k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            ChangeInfo changeInfo = (ChangeInfo) arrayList4.get(size4);
            RecyclerView.ViewHolder viewHolder2 = changeInfo.f11415a;
            if (viewHolder2 != null) {
                t(changeInfo, viewHolder2);
            }
            RecyclerView.ViewHolder viewHolder3 = changeInfo.f11416b;
            if (viewHolder3 != null) {
                t(changeInfo, viewHolder3);
            }
        }
        arrayList4.clear();
        if (k()) {
            ArrayList arrayList5 = this.f11386m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList6.get(size6);
                    View view2 = moveInfo2.f11421a.f11653a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    h(moveInfo2.f11421a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.f11385l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder4 = (RecyclerView.ViewHolder) arrayList8.get(size8);
                    viewHolder4.f11653a.setAlpha(1.0f);
                    h(viewHolder4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    ChangeInfo changeInfo2 = (ChangeInfo) arrayList10.get(size10);
                    RecyclerView.ViewHolder viewHolder5 = changeInfo2.f11415a;
                    if (viewHolder5 != null) {
                        t(changeInfo2, viewHolder5);
                    }
                    RecyclerView.ViewHolder viewHolder6 = changeInfo2.f11416b;
                    if (viewHolder6 != null) {
                        t(changeInfo2, viewHolder6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            q(this.q);
            q(this.p);
            q(this.o);
            q(this.r);
            ArrayList arrayList11 = this.f11569b;
            int size11 = arrayList11.size();
            for (int i2 = 0; i2 < size11; i2++) {
                ((RecyclerView.ItemAnimator.ItemAnimatorFinishedListener) arrayList11.get(i2)).a();
            }
            arrayList11.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean k() {
        return (this.f11382i.isEmpty() && this.f11384k.isEmpty() && this.f11383j.isEmpty() && this.f11381h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.f11386m.isEmpty() && this.f11385l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void l() {
        long j2;
        ArrayList arrayList = this.f11381h;
        boolean zIsEmpty = arrayList.isEmpty();
        ArrayList arrayList2 = this.f11383j;
        boolean zIsEmpty2 = arrayList2.isEmpty();
        ArrayList arrayList3 = this.f11384k;
        boolean zIsEmpty3 = arrayList3.isEmpty();
        ArrayList arrayList4 = this.f11382i;
        boolean zIsEmpty4 = arrayList4.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            j2 = this.f11571d;
            if (!zHasNext) {
                break;
            }
            final RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) it.next();
            final View view = viewHolder.f11653a;
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
            this.q.add(viewHolder);
            viewPropertyAnimatorAnimate.setDuration(j2).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view.setAlpha(1.0f);
                    DefaultItemAnimator defaultItemAnimator = this;
                    RecyclerView.ViewHolder viewHolder2 = viewHolder;
                    defaultItemAnimator.h(viewHolder2);
                    defaultItemAnimator.q.remove(viewHolder2);
                    defaultItemAnimator.r();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    this.getClass();
                }
            }).start();
        }
        arrayList.clear();
        if (!zIsEmpty2) {
            final ArrayList arrayList5 = new ArrayList();
            arrayList5.addAll(arrayList2);
            this.f11386m.add(arrayList5);
            arrayList2.clear();
            Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                @Override // java.lang.Runnable
                public final void run() {
                    ArrayList arrayList6 = arrayList5;
                    Iterator it2 = arrayList6.iterator();
                    while (true) {
                        boolean zHasNext2 = it2.hasNext();
                        final DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                        if (!zHasNext2) {
                            arrayList6.clear();
                            defaultItemAnimator.f11386m.remove(arrayList6);
                            return;
                        }
                        MoveInfo moveInfo = (MoveInfo) it2.next();
                        final RecyclerView.ViewHolder viewHolder2 = moveInfo.f11421a;
                        defaultItemAnimator.getClass();
                        final View view2 = viewHolder2.f11653a;
                        final int i2 = moveInfo.f11424d - moveInfo.f11422b;
                        final int i3 = moveInfo.f11425e - moveInfo.f11423c;
                        if (i2 != 0) {
                            view2.animate().translationX(0.0f);
                        }
                        if (i3 != 0) {
                            view2.animate().translationY(0.0f);
                        }
                        final ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view2.animate();
                        defaultItemAnimator.p.add(viewHolder2);
                        viewPropertyAnimatorAnimate2.setDuration(defaultItemAnimator.f11572e).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationCancel(Animator animator) {
                                int i4 = i2;
                                View view3 = view2;
                                if (i4 != 0) {
                                    view3.setTranslationX(0.0f);
                                }
                                if (i3 != 0) {
                                    view3.setTranslationY(0.0f);
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                viewPropertyAnimatorAnimate2.setListener(null);
                                DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                                RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                                defaultItemAnimator2.h(viewHolder3);
                                defaultItemAnimator2.p.remove(viewHolder3);
                                defaultItemAnimator2.r();
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationStart(Animator animator) {
                                DefaultItemAnimator.this.getClass();
                            }
                        }).start();
                    }
                }
            };
            if (zIsEmpty) {
                runnable.run();
            } else {
                View view2 = ((MoveInfo) arrayList5.get(0)).f11421a.f11653a;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                view2.postOnAnimationDelayed(runnable, j2);
            }
        }
        if (!zIsEmpty3) {
            final ArrayList arrayList6 = new ArrayList();
            arrayList6.addAll(arrayList3);
            this.n.add(arrayList6);
            arrayList3.clear();
            Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.2
                @Override // java.lang.Runnable
                public final void run() {
                    ArrayList arrayList7 = arrayList6;
                    Iterator it2 = arrayList7.iterator();
                    while (true) {
                        boolean zHasNext2 = it2.hasNext();
                        final DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                        if (!zHasNext2) {
                            arrayList7.clear();
                            defaultItemAnimator.n.remove(arrayList7);
                            return;
                        }
                        final ChangeInfo changeInfo = (ChangeInfo) it2.next();
                        defaultItemAnimator.getClass();
                        RecyclerView.ViewHolder viewHolder2 = changeInfo.f11415a;
                        final View view3 = viewHolder2 == null ? null : viewHolder2.f11653a;
                        RecyclerView.ViewHolder viewHolder3 = changeInfo.f11416b;
                        final View view4 = viewHolder3 != null ? viewHolder3.f11653a : null;
                        ArrayList arrayList8 = defaultItemAnimator.r;
                        long j3 = defaultItemAnimator.f11573f;
                        if (view3 != null) {
                            final ViewPropertyAnimator duration = view3.animate().setDuration(j3);
                            arrayList8.add(changeInfo.f11415a);
                            duration.translationX(changeInfo.f11419e - changeInfo.f11417c);
                            duration.translationY(changeInfo.f11420f - changeInfo.f11418d);
                            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    duration.setListener(null);
                                    View view5 = view3;
                                    view5.setAlpha(1.0f);
                                    view5.setTranslationX(0.0f);
                                    view5.setTranslationY(0.0f);
                                    ChangeInfo changeInfo2 = changeInfo;
                                    RecyclerView.ViewHolder viewHolder4 = changeInfo2.f11415a;
                                    DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                                    defaultItemAnimator2.h(viewHolder4);
                                    defaultItemAnimator2.r.remove(changeInfo2.f11415a);
                                    defaultItemAnimator2.r();
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationStart(Animator animator) {
                                    RecyclerView.ViewHolder viewHolder4 = changeInfo.f11415a;
                                    DefaultItemAnimator.this.getClass();
                                }
                            }).start();
                        }
                        if (view4 != null) {
                            final ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view4.animate();
                            arrayList8.add(changeInfo.f11416b);
                            viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.8
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    viewPropertyAnimatorAnimate2.setListener(null);
                                    View view5 = view4;
                                    view5.setAlpha(1.0f);
                                    view5.setTranslationX(0.0f);
                                    view5.setTranslationY(0.0f);
                                    ChangeInfo changeInfo2 = changeInfo;
                                    RecyclerView.ViewHolder viewHolder4 = changeInfo2.f11416b;
                                    DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                                    defaultItemAnimator2.h(viewHolder4);
                                    defaultItemAnimator2.r.remove(changeInfo2.f11416b);
                                    defaultItemAnimator2.r();
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationStart(Animator animator) {
                                    RecyclerView.ViewHolder viewHolder4 = changeInfo.f11416b;
                                    DefaultItemAnimator.this.getClass();
                                }
                            }).start();
                        }
                    }
                }
            };
            if (zIsEmpty) {
                runnable2.run();
            } else {
                View view3 = ((ChangeInfo) arrayList6.get(0)).f11415a.f11653a;
                WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                view3.postOnAnimationDelayed(runnable2, j2);
            }
        }
        if (zIsEmpty4) {
            return;
        }
        final ArrayList arrayList7 = new ArrayList();
        arrayList7.addAll(arrayList4);
        this.f11385l.add(arrayList7);
        arrayList4.clear();
        Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList arrayList8 = arrayList7;
                Iterator it2 = arrayList8.iterator();
                while (true) {
                    boolean zHasNext2 = it2.hasNext();
                    final DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                    if (!zHasNext2) {
                        arrayList8.clear();
                        defaultItemAnimator.f11385l.remove(arrayList8);
                        return;
                    }
                    final RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) it2.next();
                    defaultItemAnimator.getClass();
                    final View view4 = viewHolder2.f11653a;
                    final ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view4.animate();
                    defaultItemAnimator.o.add(viewHolder2);
                    viewPropertyAnimatorAnimate2.alpha(1.0f).setDuration(defaultItemAnimator.f11570c).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationCancel(Animator animator) {
                            view4.setAlpha(1.0f);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            viewPropertyAnimatorAnimate2.setListener(null);
                            DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                            RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                            defaultItemAnimator2.h(viewHolder3);
                            defaultItemAnimator2.o.remove(viewHolder3);
                            defaultItemAnimator2.r();
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator) {
                            defaultItemAnimator.getClass();
                        }
                    }).start();
                }
            }
        };
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            runnable3.run();
            return;
        }
        if (zIsEmpty) {
            j2 = 0;
        }
        long jMax = Math.max(!zIsEmpty2 ? this.f11572e : 0L, zIsEmpty3 ? 0L : this.f11573f) + j2;
        View view4 = ((RecyclerView.ViewHolder) arrayList7.get(0)).f11653a;
        WeakHashMap weakHashMap3 = ViewCompat.f3080a;
        view4.postOnAnimationDelayed(runnable3, jMax);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void m(RecyclerView.ViewHolder viewHolder) {
        u(viewHolder);
        viewHolder.f11653a.setAlpha(0.0f);
        this.f11382i.add(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean n(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        if (viewHolder == viewHolder2) {
            return o(viewHolder, i2, i3, i4, i5);
        }
        float translationX = viewHolder.f11653a.getTranslationX();
        View view = viewHolder.f11653a;
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        u(viewHolder);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        if (viewHolder2 != null) {
            u(viewHolder2);
            View view2 = viewHolder2.f11653a;
            view2.setTranslationX(-i6);
            view2.setTranslationY(-i7);
            view2.setAlpha(0.0f);
        }
        ArrayList arrayList = this.f11384k;
        ChangeInfo changeInfo = new ChangeInfo();
        changeInfo.f11415a = viewHolder;
        changeInfo.f11416b = viewHolder2;
        changeInfo.f11417c = i2;
        changeInfo.f11418d = i3;
        changeInfo.f11419e = i4;
        changeInfo.f11420f = i5;
        arrayList.add(changeInfo);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean o(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        View view = viewHolder.f11653a;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) viewHolder.f11653a.getTranslationY());
        u(viewHolder);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            h(viewHolder);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        ArrayList arrayList = this.f11383j;
        MoveInfo moveInfo = new MoveInfo();
        moveInfo.f11421a = viewHolder;
        moveInfo.f11422b = translationX;
        moveInfo.f11423c = translationY;
        moveInfo.f11424d = i4;
        moveInfo.f11425e = i5;
        arrayList.add(moveInfo);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void p(RecyclerView.ViewHolder viewHolder) {
        u(viewHolder);
        this.f11381h.add(viewHolder);
    }

    public final void r() {
        if (k()) {
            return;
        }
        ArrayList arrayList = this.f11569b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((RecyclerView.ItemAnimator.ItemAnimatorFinishedListener) arrayList.get(i2)).a();
        }
        arrayList.clear();
    }

    public final void s(ArrayList arrayList, RecyclerView.ViewHolder viewHolder) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = (ChangeInfo) arrayList.get(size);
            if (t(changeInfo, viewHolder) && changeInfo.f11415a == null && changeInfo.f11416b == null) {
                arrayList.remove(changeInfo);
            }
        }
    }

    public final boolean t(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        if (changeInfo.f11416b == viewHolder) {
            changeInfo.f11416b = null;
        } else {
            if (changeInfo.f11415a != viewHolder) {
                return false;
            }
            changeInfo.f11415a = null;
        }
        viewHolder.f11653a.setAlpha(1.0f);
        View view = viewHolder.f11653a;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        h(viewHolder);
        return true;
    }

    public final void u(RecyclerView.ViewHolder viewHolder) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        viewHolder.f11653a.animate().setInterpolator(s);
        i(viewHolder);
    }
}
