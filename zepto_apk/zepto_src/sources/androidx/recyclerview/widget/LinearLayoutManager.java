package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* loaded from: classes3.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public final AnchorInfo A;
    public final LayoutChunkResult B;
    public final int C;
    public final int[] D;
    public int p;
    public LayoutState q;
    public OrientationHelper r;
    public boolean s;
    public final boolean t;
    public boolean u;
    public boolean v;
    public final boolean w;
    public int x;
    public int y;
    public SavedState z;

    public static class AnchorInfo {

        /* renamed from: a, reason: collision with root package name */
        public OrientationHelper f11503a;

        /* renamed from: b, reason: collision with root package name */
        public int f11504b;

        /* renamed from: c, reason: collision with root package name */
        public int f11505c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11506d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11507e;

        public AnchorInfo() {
            d();
        }

        public final void a() {
            this.f11505c = this.f11506d ? this.f11503a.g() : this.f11503a.k();
        }

        public final void b(int i2, View view) {
            if (this.f11506d) {
                int iB = this.f11503a.b(view);
                OrientationHelper orientationHelper = this.f11503a;
                this.f11505c = (Integer.MIN_VALUE == orientationHelper.f11540b ? 0 : orientationHelper.l() - orientationHelper.f11540b) + iB;
            } else {
                this.f11505c = this.f11503a.e(view);
            }
            this.f11504b = i2;
        }

        public final void c(int i2, View view) {
            OrientationHelper orientationHelper = this.f11503a;
            int iL = Integer.MIN_VALUE == orientationHelper.f11540b ? 0 : orientationHelper.l() - orientationHelper.f11540b;
            if (iL >= 0) {
                b(i2, view);
                return;
            }
            this.f11504b = i2;
            if (!this.f11506d) {
                int iE = this.f11503a.e(view);
                int iK = iE - this.f11503a.k();
                this.f11505c = iE;
                if (iK > 0) {
                    int iG = (this.f11503a.g() - Math.min(0, (this.f11503a.g() - iL) - this.f11503a.b(view))) - (this.f11503a.c(view) + iE);
                    if (iG < 0) {
                        this.f11505c -= Math.min(iK, -iG);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG2 = (this.f11503a.g() - iL) - this.f11503a.b(view);
            this.f11505c = this.f11503a.g() - iG2;
            if (iG2 > 0) {
                int iC = this.f11505c - this.f11503a.c(view);
                int iK2 = this.f11503a.k();
                int iMin = iC - (Math.min(this.f11503a.e(view) - iK2, 0) + iK2);
                if (iMin < 0) {
                    this.f11505c = Math.min(iG2, -iMin) + this.f11505c;
                }
            }
        }

        public final void d() {
            this.f11504b = -1;
            this.f11505c = Integer.MIN_VALUE;
            this.f11506d = false;
            this.f11507e = false;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.f11504b + ", mCoordinate=" + this.f11505c + ", mLayoutFromEnd=" + this.f11506d + ", mValid=" + this.f11507e + '}';
        }
    }

    public static class LayoutChunkResult {

        /* renamed from: a, reason: collision with root package name */
        public int f11508a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11509b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11510c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11511d;
    }

    public static class LayoutState {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11512a;

        /* renamed from: b, reason: collision with root package name */
        public int f11513b;

        /* renamed from: c, reason: collision with root package name */
        public int f11514c;

        /* renamed from: d, reason: collision with root package name */
        public int f11515d;

        /* renamed from: e, reason: collision with root package name */
        public int f11516e;

        /* renamed from: f, reason: collision with root package name */
        public int f11517f;

        /* renamed from: g, reason: collision with root package name */
        public int f11518g;

        /* renamed from: h, reason: collision with root package name */
        public int f11519h;

        /* renamed from: i, reason: collision with root package name */
        public int f11520i;

        /* renamed from: j, reason: collision with root package name */
        public int f11521j;

        /* renamed from: k, reason: collision with root package name */
        public List f11522k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f11523l;

        public final void a(View view) {
            int iB;
            int size = this.f11522k.size();
            View view2 = null;
            int i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = ((RecyclerView.ViewHolder) this.f11522k.get(i3)).f11653a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.f11596a.h() && (iB = (layoutParams.f11596a.b() - this.f11515d) * this.f11516e) >= 0 && iB < i2) {
                    view2 = view3;
                    if (iB == 0) {
                        break;
                    } else {
                        i2 = iB;
                    }
                }
            }
            if (view2 == null) {
                this.f11515d = -1;
            } else {
                this.f11515d = ((RecyclerView.LayoutParams) view2.getLayoutParams()).f11596a.b();
            }
        }

        public final View b(RecyclerView.Recycler recycler) {
            List list = this.f11522k;
            if (list == null) {
                View view = recycler.k(this.f11515d, Long.MAX_VALUE).f11653a;
                this.f11515d += this.f11516e;
                return view;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = ((RecyclerView.ViewHolder) this.f11522k.get(i2)).f11653a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view2.getLayoutParams();
                if (!layoutParams.f11596a.h() && this.f11515d == layoutParams.f11596a.b()) {
                    a(view2);
                    return view2;
                }
            }
            return null;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public int f11524a;

        /* renamed from: b, reason: collision with root package name */
        public int f11525b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11526c;

        /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState();
                savedState.f11524a = parcel.readInt();
                savedState.f11525b = parcel.readInt();
                savedState.f11526c = parcel.readInt() == 1;
                return savedState;
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f11524a);
            parcel.writeInt(this.f11525b);
            parcel.writeInt(this.f11526c ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i2) {
        this.p = 1;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.z = null;
        this.A = new AnchorInfo();
        this.B = new LayoutChunkResult();
        this.C = 2;
        this.D = new int[2];
        i1(i2);
        c(null);
        if (this.t) {
            this.t = false;
            s0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean C0() {
        if (this.f11589m != 1073741824 && this.f11588l != 1073741824) {
            int iV = v();
            for (int i2 = 0; i2 < iV; i2++) {
                ViewGroup.LayoutParams layoutParams = u(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void E0(int i2, RecyclerView recyclerView) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.f11618a = i2;
        F0(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean G0() {
        return this.z == null && this.s == this.v;
    }

    public void H0(RecyclerView.State state, int[] iArr) {
        int i2;
        int iL = state.f11633a != -1 ? this.r.l() : 0;
        if (this.q.f11517f == -1) {
            i2 = 0;
        } else {
            i2 = iL;
            iL = 0;
        }
        iArr[0] = iL;
        iArr[1] = i2;
    }

    public void I0(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i2 = layoutState.f11515d;
        if (i2 < 0 || i2 >= state.b()) {
            return;
        }
        ((GapWorker.LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).a(i2, Math.max(0, layoutState.f11518g));
    }

    public final int J0(RecyclerView.State state) {
        if (v() == 0) {
            return 0;
        }
        N0();
        OrientationHelper orientationHelper = this.r;
        boolean z = !this.w;
        return ScrollbarHelper.a(state, orientationHelper, Q0(z), P0(z), this, this.w);
    }

    public final int K0(RecyclerView.State state) {
        if (v() == 0) {
            return 0;
        }
        N0();
        OrientationHelper orientationHelper = this.r;
        boolean z = !this.w;
        return ScrollbarHelper.b(state, orientationHelper, Q0(z), P0(z), this, this.w, this.u);
    }

    public final int L0(RecyclerView.State state) {
        if (v() == 0) {
            return 0;
        }
        N0();
        OrientationHelper orientationHelper = this.r;
        boolean z = !this.w;
        return ScrollbarHelper.c(state, orientationHelper, Q0(z), P0(z), this, this.w);
    }

    public final int M0(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.p == 1) ? 1 : Integer.MIN_VALUE : this.p == 0 ? 1 : Integer.MIN_VALUE : this.p == 1 ? -1 : Integer.MIN_VALUE : this.p == 0 ? -1 : Integer.MIN_VALUE : (this.p != 1 && b1()) ? -1 : 1 : (this.p != 1 && b1()) ? 1 : -1;
    }

    public final void N0() {
        if (this.q == null) {
            LayoutState layoutState = new LayoutState();
            layoutState.f11512a = true;
            layoutState.f11519h = 0;
            layoutState.f11520i = 0;
            layoutState.f11522k = null;
            this.q = layoutState;
        }
    }

    public final int O0(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z) {
        int i2;
        int i3 = layoutState.f11514c;
        int i4 = layoutState.f11518g;
        if (i4 != Integer.MIN_VALUE) {
            if (i3 < 0) {
                layoutState.f11518g = i4 + i3;
            }
            e1(recycler, layoutState);
        }
        int i5 = layoutState.f11514c + layoutState.f11519h;
        while (true) {
            if ((!layoutState.f11523l && i5 <= 0) || (i2 = layoutState.f11515d) < 0 || i2 >= state.b()) {
                break;
            }
            LayoutChunkResult layoutChunkResult = this.B;
            layoutChunkResult.f11508a = 0;
            layoutChunkResult.f11509b = false;
            layoutChunkResult.f11510c = false;
            layoutChunkResult.f11511d = false;
            c1(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f11509b) {
                int i6 = layoutState.f11513b;
                int i7 = layoutChunkResult.f11508a;
                layoutState.f11513b = (layoutState.f11517f * i7) + i6;
                if (!layoutChunkResult.f11510c || layoutState.f11522k != null || !state.f11639g) {
                    layoutState.f11514c -= i7;
                    i5 -= i7;
                }
                int i8 = layoutState.f11518g;
                if (i8 != Integer.MIN_VALUE) {
                    int i9 = i8 + i7;
                    layoutState.f11518g = i9;
                    int i10 = layoutState.f11514c;
                    if (i10 < 0) {
                        layoutState.f11518g = i9 + i10;
                    }
                    e1(recycler, layoutState);
                }
                if (z && layoutChunkResult.f11511d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i3 - layoutState.f11514c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean P() {
        return true;
    }

    public final View P0(boolean z) {
        return this.u ? U0(0, v(), z) : U0(v() - 1, -1, z);
    }

    public final View Q0(boolean z) {
        return this.u ? U0(v() - 1, -1, z) : U0(0, v(), z);
    }

    public final int R0() {
        View viewU0 = U0(0, v(), false);
        if (viewU0 == null) {
            return -1;
        }
        return RecyclerView.LayoutManager.L(viewU0);
    }

    public final int S0() {
        View viewU0 = U0(v() - 1, -1, false);
        if (viewU0 == null) {
            return -1;
        }
        return RecyclerView.LayoutManager.L(viewU0);
    }

    public final View T0(int i2, int i3) {
        int i4;
        int i5;
        N0();
        if (i3 <= i2 && i3 >= i2) {
            return u(i2);
        }
        if (this.r.e(u(i2)) < this.r.k()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        return this.p == 0 ? this.f11579c.a(i2, i3, i4, i5) : this.f11580d.a(i2, i3, i4, i5);
    }

    public final View U0(int i2, int i3, boolean z) {
        N0();
        int i4 = z ? 24579 : 320;
        return this.p == 0 ? this.f11579c.a(i2, i3, i4, 320) : this.f11580d.a(i2, i3, i4, 320);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View V0(androidx.recyclerview.widget.RecyclerView.Recycler r17, androidx.recyclerview.widget.RecyclerView.State r18, boolean r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r0.N0()
            int r1 = r0.v()
            r2 = 0
            r3 = 1
            if (r20 == 0) goto L15
            int r1 = r0.v()
            int r1 = r1 - r3
            r4 = -1
            r5 = r4
            goto L18
        L15:
            r4 = r1
            r1 = r2
            r5 = r3
        L18:
            int r6 = r18.b()
            androidx.recyclerview.widget.OrientationHelper r7 = r0.r
            int r7 = r7.k()
            androidx.recyclerview.widget.OrientationHelper r8 = r0.r
            int r8 = r8.g()
            r9 = 0
            r10 = r9
            r11 = r10
        L2b:
            if (r1 == r4) goto L7c
            android.view.View r12 = r0.u(r1)
            int r13 = androidx.recyclerview.widget.RecyclerView.LayoutManager.L(r12)
            androidx.recyclerview.widget.OrientationHelper r14 = r0.r
            int r14 = r14.e(r12)
            androidx.recyclerview.widget.OrientationHelper r15 = r0.r
            int r15 = r15.b(r12)
            if (r13 < 0) goto L7a
            if (r13 >= r6) goto L7a
            android.view.ViewGroup$LayoutParams r13 = r12.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$LayoutParams r13 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r13
            androidx.recyclerview.widget.RecyclerView$ViewHolder r13 = r13.f11596a
            boolean r13 = r13.h()
            if (r13 == 0) goto L57
            if (r11 != 0) goto L7a
            r11 = r12
            goto L7a
        L57:
            if (r15 > r7) goto L5d
            if (r14 >= r7) goto L5d
            r13 = r3
            goto L5e
        L5d:
            r13 = r2
        L5e:
            if (r14 < r8) goto L64
            if (r15 <= r8) goto L64
            r14 = r3
            goto L65
        L64:
            r14 = r2
        L65:
            if (r13 != 0) goto L6b
            if (r14 == 0) goto L6a
            goto L6b
        L6a:
            return r12
        L6b:
            if (r19 == 0) goto L73
            if (r14 == 0) goto L70
            goto L75
        L70:
            if (r9 != 0) goto L7a
            goto L79
        L73:
            if (r13 == 0) goto L77
        L75:
            r10 = r12
            goto L7a
        L77:
            if (r9 != 0) goto L7a
        L79:
            r9 = r12
        L7a:
            int r1 = r1 + r5
            goto L2b
        L7c:
            if (r9 == 0) goto L7f
            return r9
        L7f:
            if (r10 == 0) goto L82
            return r10
        L82:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.V0(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean, boolean):android.view.View");
    }

    public final int W0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iG;
        int iG2 = this.r.g() - i2;
        if (iG2 <= 0) {
            return 0;
        }
        int i3 = -h1(-iG2, recycler, state);
        int i4 = i2 + i3;
        if (!z || (iG = this.r.g() - i4) <= 0) {
            return i3;
        }
        this.r.o(iG);
        return iG + i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View X(View view, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iM0;
        g1();
        if (v() != 0 && (iM0 = M0(i2)) != Integer.MIN_VALUE) {
            N0();
            k1(iM0, (int) (this.r.l() * 0.33333334f), false, state);
            LayoutState layoutState = this.q;
            layoutState.f11518g = Integer.MIN_VALUE;
            layoutState.f11512a = false;
            O0(recycler, layoutState, state, true);
            View viewT0 = iM0 == -1 ? this.u ? T0(v() - 1, -1) : T0(0, v()) : this.u ? T0(0, v()) : T0(v() - 1, -1);
            View viewZ0 = iM0 == -1 ? Z0() : Y0();
            if (!viewZ0.hasFocusable()) {
                return viewT0;
            }
            if (viewT0 != null) {
                return viewZ0;
            }
        }
        return null;
    }

    public final int X0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iK;
        int iK2 = i2 - this.r.k();
        if (iK2 <= 0) {
            return 0;
        }
        int i3 = -h1(iK2, recycler, state);
        int i4 = i2 + i3;
        if (!z || (iK = i4 - this.r.k()) <= 0) {
            return i3;
        }
        this.r.o(-iK);
        return i3 - iK;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void Y(AccessibilityEvent accessibilityEvent) {
        super.Y(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(R0());
            accessibilityEvent.setToIndex(S0());
        }
    }

    public final View Y0() {
        return u(this.u ? 0 : v() - 1);
    }

    public final View Z0() {
        return u(this.u ? v() - 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF a(int i2) {
        if (v() == 0) {
            return null;
        }
        int i3 = (i2 < RecyclerView.LayoutManager.L(u(0))) != this.u ? -1 : 1;
        return this.p == 0 ? new PointF(i3, 0.0f) : new PointF(0.0f, i3);
    }

    public final int a1() {
        return this.p;
    }

    public final boolean b1() {
        return G() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void c(String str) {
        if (this.z == null) {
            super.c(str);
        }
    }

    public void c1(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int I;
        int i2;
        int i3;
        int iD;
        View viewB = layoutState.b(recycler);
        if (viewB == null) {
            layoutChunkResult.f11509b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewB.getLayoutParams();
        if (layoutState.f11522k == null) {
            if (this.u == (layoutState.f11517f == -1)) {
                b(-1, viewB, false);
            } else {
                b(0, viewB, false);
            }
        } else {
            if (this.u == (layoutState.f11517f == -1)) {
                b(-1, viewB, true);
            } else {
                b(0, viewB, true);
            }
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) viewB.getLayoutParams();
        Rect rectP = this.f11578b.P(viewB);
        int i4 = rectP.left + rectP.right;
        int i5 = rectP.top + rectP.bottom;
        int iW = RecyclerView.LayoutManager.w(d(), this.n, this.f11588l, J() + I() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams2).width);
        int iW2 = RecyclerView.LayoutManager.w(e(), this.o, this.f11589m, H() + K() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) layoutParams2).height);
        if (B0(viewB, iW, iW2, layoutParams2)) {
            viewB.measure(iW, iW2);
        }
        layoutChunkResult.f11508a = this.r.c(viewB);
        if (this.p == 1) {
            if (b1()) {
                iD = this.n - J();
                I = iD - this.r.d(viewB);
            } else {
                I = I();
                iD = this.r.d(viewB) + I;
            }
            if (layoutState.f11517f == -1) {
                i2 = layoutState.f11513b;
                i3 = i2 - layoutChunkResult.f11508a;
            } else {
                i3 = layoutState.f11513b;
                i2 = layoutChunkResult.f11508a + i3;
            }
        } else {
            int iK = K();
            int iD2 = this.r.d(viewB) + iK;
            if (layoutState.f11517f == -1) {
                int i6 = layoutState.f11513b;
                int i7 = i6 - layoutChunkResult.f11508a;
                iD = i6;
                i2 = iD2;
                I = i7;
                i3 = iK;
            } else {
                int i8 = layoutState.f11513b;
                int i9 = layoutChunkResult.f11508a + i8;
                I = i8;
                i2 = iD2;
                i3 = iK;
                iD = i9;
            }
        }
        RecyclerView.LayoutManager.R(viewB, I, i3, iD, i2);
        if (layoutParams.f11596a.h() || layoutParams.f11596a.k()) {
            layoutChunkResult.f11510c = true;
        }
        layoutChunkResult.f11511d = viewB.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean d() {
        return this.p == 0;
    }

    public void d1(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean e() {
        return this.p == 1;
    }

    public final void e1(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.f11512a || layoutState.f11523l) {
            return;
        }
        int i2 = layoutState.f11518g;
        int i3 = layoutState.f11520i;
        if (layoutState.f11517f == -1) {
            int iV = v();
            if (i2 < 0) {
                return;
            }
            int iF = (this.r.f() - i2) + i3;
            if (this.u) {
                for (int i4 = 0; i4 < iV; i4++) {
                    View viewU = u(i4);
                    if (this.r.e(viewU) < iF || this.r.n(viewU) < iF) {
                        f1(recycler, 0, i4);
                        return;
                    }
                }
                return;
            }
            int i5 = iV - 1;
            for (int i6 = i5; i6 >= 0; i6--) {
                View viewU2 = u(i6);
                if (this.r.e(viewU2) < iF || this.r.n(viewU2) < iF) {
                    f1(recycler, i5, i6);
                    return;
                }
            }
            return;
        }
        if (i2 < 0) {
            return;
        }
        int i7 = i2 - i3;
        int iV2 = v();
        if (!this.u) {
            for (int i8 = 0; i8 < iV2; i8++) {
                View viewU3 = u(i8);
                if (this.r.b(viewU3) > i7 || this.r.m(viewU3) > i7) {
                    f1(recycler, 0, i8);
                    return;
                }
            }
            return;
        }
        int i9 = iV2 - 1;
        for (int i10 = i9; i10 >= 0; i10--) {
            View viewU4 = u(i10);
            if (this.r.b(viewU4) > i7 || this.r.m(viewU4) > i7) {
                f1(recycler, i9, i10);
                return;
            }
        }
    }

    public final void f1(RecyclerView.Recycler recycler, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 <= i2) {
            while (i2 > i3) {
                View viewU = u(i2);
                q0(i2);
                recycler.h(viewU);
                i2--;
            }
            return;
        }
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            View viewU2 = u(i4);
            q0(i4);
            recycler.h(viewU2);
        }
    }

    public final void g1() {
        if (this.p == 1 || !b1()) {
            this.u = this.t;
        } else {
            this.u = !this.t;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void h(int i2, int i3, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.p != 0) {
            i2 = i3;
        }
        if (v() == 0 || i2 == 0) {
            return;
        }
        N0();
        k1(i2 > 0 ? 1 : -1, Math.abs(i2), true, state);
        I0(state, this.q, layoutPrefetchRegistry);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0192  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h0(androidx.recyclerview.widget.RecyclerView.Recycler r18, androidx.recyclerview.widget.RecyclerView.State r19) {
        /*
            Method dump skipped, instructions count: 1081
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.h0(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    public final int h1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (v() != 0 && i2 != 0) {
            N0();
            this.q.f11512a = true;
            int i3 = i2 > 0 ? 1 : -1;
            int iAbs = Math.abs(i2);
            k1(i3, iAbs, true, state);
            LayoutState layoutState = this.q;
            int iO0 = O0(recycler, layoutState, state, false) + layoutState.f11518g;
            if (iO0 >= 0) {
                if (iAbs > iO0) {
                    i2 = i3 * iO0;
                }
                this.r.o(-i2);
                this.q.f11521j = i2;
                return i2;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void i(int i2, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z;
        int i3;
        SavedState savedState = this.z;
        if (savedState == null || (i3 = savedState.f11524a) < 0) {
            g1();
            z = this.u;
            i3 = this.x;
            if (i3 == -1) {
                i3 = z ? i2 - 1 : 0;
            }
        } else {
            z = savedState.f11526c;
        }
        int i4 = z ? -1 : 1;
        for (int i5 = 0; i5 < this.C && i3 >= 0 && i3 < i2; i5++) {
            ((GapWorker.LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).a(i3, 0);
            i3 += i4;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void i0(RecyclerView.State state) {
        this.z = null;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.A.d();
    }

    public final void i1(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException(b.f(i2, "invalid orientation:"));
        }
        c(null);
        if (i2 != this.p || this.r == null) {
            OrientationHelper orientationHelperA = OrientationHelper.a(this, i2);
            this.r = orientationHelperA;
            this.A.f11503a = orientationHelperA;
            this.p = i2;
            s0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int j(RecyclerView.State state) {
        return J0(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void j0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.z = savedState;
            if (this.x != -1) {
                savedState.f11524a = -1;
            }
            s0();
        }
    }

    public void j1(boolean z) {
        c(null);
        if (this.v == z) {
            return;
        }
        this.v = z;
        s0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int k(RecyclerView.State state) {
        return K0(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final Parcelable k0() {
        SavedState savedState = this.z;
        if (savedState != null) {
            SavedState savedState2 = new SavedState();
            savedState2.f11524a = savedState.f11524a;
            savedState2.f11525b = savedState.f11525b;
            savedState2.f11526c = savedState.f11526c;
            return savedState2;
        }
        SavedState savedState3 = new SavedState();
        if (v() <= 0) {
            savedState3.f11524a = -1;
            return savedState3;
        }
        N0();
        boolean z = this.s ^ this.u;
        savedState3.f11526c = z;
        if (z) {
            View viewY0 = Y0();
            savedState3.f11525b = this.r.g() - this.r.b(viewY0);
            savedState3.f11524a = RecyclerView.LayoutManager.L(viewY0);
            return savedState3;
        }
        View viewZ0 = Z0();
        savedState3.f11524a = RecyclerView.LayoutManager.L(viewZ0);
        savedState3.f11525b = this.r.e(viewZ0) - this.r.k();
        return savedState3;
    }

    public final void k1(int i2, int i3, boolean z, RecyclerView.State state) {
        int iK;
        this.q.f11523l = this.r.i() == 0 && this.r.f() == 0;
        this.q.f11517f = i2;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        H0(state, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z2 = i2 == 1;
        LayoutState layoutState = this.q;
        int i4 = z2 ? iMax2 : iMax;
        layoutState.f11519h = i4;
        if (!z2) {
            iMax = iMax2;
        }
        layoutState.f11520i = iMax;
        if (z2) {
            layoutState.f11519h = this.r.h() + i4;
            View viewY0 = Y0();
            LayoutState layoutState2 = this.q;
            layoutState2.f11516e = this.u ? -1 : 1;
            int iL = RecyclerView.LayoutManager.L(viewY0);
            LayoutState layoutState3 = this.q;
            layoutState2.f11515d = iL + layoutState3.f11516e;
            layoutState3.f11513b = this.r.b(viewY0);
            iK = this.r.b(viewY0) - this.r.g();
        } else {
            View viewZ0 = Z0();
            LayoutState layoutState4 = this.q;
            layoutState4.f11519h = this.r.k() + layoutState4.f11519h;
            LayoutState layoutState5 = this.q;
            layoutState5.f11516e = this.u ? 1 : -1;
            int iL2 = RecyclerView.LayoutManager.L(viewZ0);
            LayoutState layoutState6 = this.q;
            layoutState5.f11515d = iL2 + layoutState6.f11516e;
            layoutState6.f11513b = this.r.e(viewZ0);
            iK = (-this.r.e(viewZ0)) + this.r.k();
        }
        LayoutState layoutState7 = this.q;
        layoutState7.f11514c = i3;
        if (z) {
            layoutState7.f11514c = i3 - iK;
        }
        layoutState7.f11518g = iK;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int l(RecyclerView.State state) {
        return L0(state);
    }

    public final void l1(int i2, int i3) {
        this.q.f11514c = this.r.g() - i3;
        LayoutState layoutState = this.q;
        layoutState.f11516e = this.u ? -1 : 1;
        layoutState.f11515d = i2;
        layoutState.f11517f = 1;
        layoutState.f11513b = i3;
        layoutState.f11518g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int m(RecyclerView.State state) {
        return J0(state);
    }

    public final void m1(int i2, int i3) {
        this.q.f11514c = i3 - this.r.k();
        LayoutState layoutState = this.q;
        layoutState.f11515d = i2;
        layoutState.f11516e = this.u ? 1 : -1;
        layoutState.f11517f = -1;
        layoutState.f11513b = i3;
        layoutState.f11518g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int n(RecyclerView.State state) {
        return K0(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int o(RecyclerView.State state) {
        return L0(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final View q(int i2) {
        int iV = v();
        if (iV == 0) {
            return null;
        }
        int iL = i2 - RecyclerView.LayoutManager.L(u(0));
        if (iL >= 0 && iL < iV) {
            View viewU = u(iL);
            if (RecyclerView.LayoutManager.L(viewU) == i2) {
                return viewU;
            }
        }
        return super.q(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams r() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int t0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.p == 1) {
            return 0;
        }
        return h1(i2, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void u0(int i2) {
        this.x = i2;
        this.y = Integer.MIN_VALUE;
        SavedState savedState = this.z;
        if (savedState != null) {
            savedState.f11524a = -1;
        }
        s0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int v0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.p == 0) {
            return 0;
        }
        return h1(i2, recycler, state);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.p = 1;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.z = null;
        this.A = new AnchorInfo();
        this.B = new LayoutChunkResult();
        this.C = 2;
        this.D = new int[2];
        RecyclerView.LayoutManager.Properties propertiesM = RecyclerView.LayoutManager.M(context, attributeSet, i2, i3);
        i1(propertiesM.f11592a);
        boolean z = propertiesM.f11594c;
        c(null);
        if (z != this.t) {
            this.t = z;
            s0();
        }
        j1(propertiesM.f11595d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void W(RecyclerView recyclerView) {
    }
}
