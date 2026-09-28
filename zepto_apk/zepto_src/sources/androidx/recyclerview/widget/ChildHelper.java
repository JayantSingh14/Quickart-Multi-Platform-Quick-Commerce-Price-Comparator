package androidx.recyclerview.widget;

import android.support.v4.media.a;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
class ChildHelper {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.AnonymousClass5 f11375a;

    /* renamed from: b, reason: collision with root package name */
    public final Bucket f11376b = new Bucket();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f11377c = new ArrayList();

    public static class Bucket {

        /* renamed from: a, reason: collision with root package name */
        public long f11378a = 0;

        /* renamed from: b, reason: collision with root package name */
        public Bucket f11379b;

        public final void a(int i2) {
            if (i2 < 64) {
                this.f11378a &= ~(1 << i2);
                return;
            }
            Bucket bucket = this.f11379b;
            if (bucket != null) {
                bucket.a(i2 - 64);
            }
        }

        public final int b(int i2) {
            Bucket bucket = this.f11379b;
            if (bucket == null) {
                return i2 >= 64 ? Long.bitCount(this.f11378a) : Long.bitCount(this.f11378a & ((1 << i2) - 1));
            }
            if (i2 < 64) {
                return Long.bitCount(this.f11378a & ((1 << i2) - 1));
            }
            return Long.bitCount(this.f11378a) + bucket.b(i2 - 64);
        }

        public final void c() {
            if (this.f11379b == null) {
                this.f11379b = new Bucket();
            }
        }

        public final boolean d(int i2) {
            if (i2 < 64) {
                return (this.f11378a & (1 << i2)) != 0;
            }
            c();
            return this.f11379b.d(i2 - 64);
        }

        public final void e(int i2, boolean z) {
            if (i2 >= 64) {
                c();
                this.f11379b.e(i2 - 64, z);
                return;
            }
            long j2 = this.f11378a;
            boolean z2 = (Long.MIN_VALUE & j2) != 0;
            long j3 = (1 << i2) - 1;
            this.f11378a = ((j2 & (~j3)) << 1) | (j2 & j3);
            if (z) {
                h(i2);
            } else {
                a(i2);
            }
            if (z2 || this.f11379b != null) {
                c();
                this.f11379b.e(0, z2);
            }
        }

        public final boolean f(int i2) {
            if (i2 >= 64) {
                c();
                return this.f11379b.f(i2 - 64);
            }
            long j2 = 1 << i2;
            long j3 = this.f11378a;
            boolean z = (j3 & j2) != 0;
            long j4 = j3 & (~j2);
            this.f11378a = j4;
            long j5 = j2 - 1;
            this.f11378a = (j4 & j5) | Long.rotateRight((~j5) & j4, 1);
            Bucket bucket = this.f11379b;
            if (bucket != null) {
                if (bucket.d(0)) {
                    h(63);
                }
                this.f11379b.f(0);
            }
            return z;
        }

        public final void g() {
            this.f11378a = 0L;
            Bucket bucket = this.f11379b;
            if (bucket != null) {
                bucket.g();
            }
        }

        public final void h(int i2) {
            if (i2 < 64) {
                this.f11378a |= 1 << i2;
            } else {
                c();
                this.f11379b.h(i2 - 64);
            }
        }

        public final String toString() {
            if (this.f11379b == null) {
                return Long.toBinaryString(this.f11378a);
            }
            return this.f11379b.toString() + "xx" + Long.toBinaryString(this.f11378a);
        }
    }

    public interface Callback {
    }

    public ChildHelper(RecyclerView.AnonymousClass5 anonymousClass5) {
        this.f11375a = anonymousClass5;
    }

    public final void a(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView.AnonymousClass5 anonymousClass5 = this.f11375a;
        RecyclerView recyclerView = RecyclerView.this;
        int childCount = i2 < 0 ? recyclerView.getChildCount() : d(i2);
        this.f11376b.e(childCount, z);
        if (z) {
            this.f11377c.add(view);
            RecyclerView.ViewHolder viewHolderN = RecyclerView.N(view);
            if (viewHolderN != null) {
                int i3 = viewHolderN.q;
                View view2 = viewHolderN.f11653a;
                if (i3 != -1) {
                    viewHolderN.p = i3;
                } else {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    viewHolderN.p = view2.getImportantForAccessibility();
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (recyclerView2.S()) {
                    viewHolderN.q = 4;
                    recyclerView2.f1.add(viewHolderN);
                } else {
                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                    view2.setImportantForAccessibility(4);
                }
            }
        }
        RecyclerView.ViewHolder viewHolderN2 = RecyclerView.N(view);
        if (viewHolderN2 != null) {
            if (!viewHolderN2.j() && !viewHolderN2.o()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(viewHolderN2);
                throw new IllegalArgumentException(a.m(recyclerView, sb));
            }
            if (RecyclerView.m1) {
                Log.d("RecyclerView", "reAttach " + viewHolderN2);
            }
            viewHolderN2.f11662j &= -257;
        } else if (RecyclerView.l1) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(childCount);
            throw new IllegalArgumentException(a.m(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public final View b(int i2) {
        return RecyclerView.this.getChildAt(d(i2));
    }

    public final int c() {
        return RecyclerView.this.getChildCount() - this.f11377c.size();
    }

    public final int d(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int childCount = RecyclerView.this.getChildCount();
        int i3 = i2;
        while (i3 < childCount) {
            Bucket bucket = this.f11376b;
            int iB = i2 - (i3 - bucket.b(i3));
            if (iB == 0) {
                while (bucket.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += iB;
        }
        return -1;
    }

    public final void e(View view) {
        if (this.f11377c.remove(view)) {
            this.f11375a.a(view);
        }
    }

    public final String toString() {
        return this.f11376b.toString() + ", hidden list:" + this.f11377c.size();
    }
}
