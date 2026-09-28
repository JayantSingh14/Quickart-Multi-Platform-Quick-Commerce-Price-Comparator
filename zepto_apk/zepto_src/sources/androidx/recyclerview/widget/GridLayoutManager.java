package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public final DefaultSpanSizeLookup K;
    public final Rect L;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
    }

    public static abstract class SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        public final SparseIntArray f11490a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        public final SparseIntArray f11491b = new SparseIntArray();

        public final int a(int i2, int i3) {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i4++;
                if (i4 == i3) {
                    i5++;
                    i4 = 0;
                } else if (i4 > i3) {
                    i5++;
                    i4 = 1;
                }
            }
            return i4 + 1 > i3 ? i5 + 1 : i5;
        }

        public final void b() {
            this.f11490a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new DefaultSpanSizeLookup();
        this.L = new Rect();
        u1(RecyclerView.LayoutManager.M(context, attributeSet, i2, i3).f11593b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean G0() {
        return this.z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void I0(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i2;
        int i3 = this.F;
        for (int i4 = 0; i4 < this.F && (i2 = layoutState.f11515d) >= 0 && i2 < state.b() && i3 > 0; i4++) {
            ((GapWorker.LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).a(layoutState.f11515d, Math.max(0, layoutState.f11518g));
            this.K.getClass();
            i3--;
            layoutState.f11515d += layoutState.f11516e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int N(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.p == 0) {
            return this.F;
        }
        if (state.b() < 1) {
            return 0;
        }
        return q1(state.b() - 1, recycler, state) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View V0(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int i2;
        int iV;
        int iV2 = v();
        int i3 = 1;
        if (z2) {
            iV = v() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            i2 = iV2;
            iV = 0;
        }
        int iB = state.b();
        N0();
        int iK = this.r.k();
        int iG = this.r.g();
        View view = null;
        View view2 = null;
        while (iV != i2) {
            View viewU = u(iV);
            int iL = RecyclerView.LayoutManager.L(viewU);
            if (iL >= 0 && iL < iB && r1(iL, recycler, state) == 0) {
                if (((RecyclerView.LayoutParams) viewU.getLayoutParams()).f11596a.h()) {
                    if (view2 == null) {
                        view2 = viewU;
                    }
                } else {
                    if (this.r.e(viewU) < iG && this.r.b(viewU) >= iK) {
                        return viewU;
                    }
                    if (view == null) {
                        view = viewU;
                    }
                }
            }
            iV += i3;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e0, code lost:
    
        if (r13 == (r2 > r15)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0140, code lost:
    
        if (r16 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0142, code lost:
    
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0143, code lost:
    
        return r17;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View X(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.Recycler r25, androidx.recyclerview.widget.RecyclerView.State r26) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.X(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void Z(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.Z(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.m(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void b0(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            a0(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int iQ1 = q1(layoutParams2.f11596a.b(), recycler, state);
        if (this.p == 0) {
            accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(layoutParams2.f11488e, layoutParams2.f11489f, iQ1, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(iQ1, 1, layoutParams2.f11488e, layoutParams2.f11489f, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void c0(int i2, int i3) {
        DefaultSpanSizeLookup defaultSpanSizeLookup = this.K;
        defaultSpanSizeLookup.b();
        defaultSpanSizeLookup.f11491b.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v37 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void c1(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i2;
        int i3;
        int i4;
        int iD;
        int I;
        int iK;
        int iD2;
        int iW;
        int iW2;
        ?? r8;
        int i5;
        View viewB;
        int iJ = this.r.j();
        boolean z = iJ != 1073741824;
        int i6 = v() > 0 ? this.G[this.F] : 0;
        if (z) {
            v1();
        }
        boolean z2 = layoutState.f11516e == 1;
        int iR1 = this.F;
        if (!z2) {
            iR1 = r1(layoutState.f11515d, recycler, state) + s1(layoutState.f11515d, recycler, state);
        }
        int i7 = 0;
        while (i7 < this.F && (i5 = layoutState.f11515d) >= 0 && i5 < state.b() && iR1 > 0) {
            int i8 = layoutState.f11515d;
            int iS1 = s1(i8, recycler, state);
            if (iS1 > this.F) {
                throw new IllegalArgumentException(b.o(b.t(i8, iS1, "Item at position ", " requires ", " spans but GridLayoutManager has only "), this.F, " spans."));
            }
            iR1 -= iS1;
            if (iR1 < 0 || (viewB = layoutState.b(recycler)) == null) {
                break;
            }
            this.H[i7] = viewB;
            i7++;
        }
        if (i7 == 0) {
            layoutChunkResult.f11509b = true;
            return;
        }
        if (z2) {
            i4 = 1;
            i3 = i7;
            i2 = 0;
        } else {
            i2 = i7 - 1;
            i3 = -1;
            i4 = -1;
        }
        int i9 = 0;
        while (i2 != i3) {
            View view = this.H[i2];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int iS12 = s1(RecyclerView.LayoutManager.L(view), recycler, state);
            layoutParams.f11489f = iS12;
            layoutParams.f11488e = i9;
            i9 += iS12;
            i2 += i4;
        }
        float f2 = 0.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < i7; i11++) {
            View view2 = this.H[i11];
            if (layoutState.f11522k != null) {
                r8 = 0;
                r8 = 0;
                if (z2) {
                    b(-1, view2, true);
                } else {
                    b(0, view2, true);
                }
            } else if (z2) {
                r8 = 0;
                b(-1, view2, false);
            } else {
                r8 = 0;
                b(0, view2, false);
            }
            RecyclerView recyclerView = this.f11578b;
            Rect rect = this.L;
            if (recyclerView == null) {
                rect.set(r8, r8, r8, r8);
            } else {
                rect.set(recyclerView.P(view2));
            }
            t1(iJ, view2, r8);
            int iC = this.r.c(view2);
            if (iC > i10) {
                i10 = iC;
            }
            float fD = (this.r.d(view2) * 1.0f) / ((LayoutParams) view2.getLayoutParams()).f11489f;
            if (fD > f2) {
                f2 = fD;
            }
        }
        if (z) {
            n1(Math.max(Math.round(f2 * this.F), i6));
            i10 = 0;
            for (int i12 = 0; i12 < i7; i12++) {
                View view3 = this.H[i12];
                t1(1073741824, view3, true);
                int iC2 = this.r.c(view3);
                if (iC2 > i10) {
                    i10 = iC2;
                }
            }
        }
        for (int i13 = 0; i13 < i7; i13++) {
            View view4 = this.H[i13];
            if (this.r.c(view4) != i10) {
                LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
                Rect rect2 = layoutParams2.f11597b;
                int i14 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                int i15 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                int iP1 = p1(layoutParams2.f11488e, layoutParams2.f11489f);
                if (this.p == 1) {
                    iW2 = RecyclerView.LayoutManager.w(false, iP1, 1073741824, i15, ((ViewGroup.MarginLayoutParams) layoutParams2).width);
                    iW = View.MeasureSpec.makeMeasureSpec(i10 - i14, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - i15, 1073741824);
                    iW = RecyclerView.LayoutManager.w(false, iP1, 1073741824, i14, ((ViewGroup.MarginLayoutParams) layoutParams2).height);
                    iW2 = iMakeMeasureSpec;
                }
                if (D0(view4, iW2, iW, (RecyclerView.LayoutParams) view4.getLayoutParams())) {
                    view4.measure(iW2, iW);
                }
            }
        }
        layoutChunkResult.f11508a = i10;
        if (this.p != 1) {
            if (layoutState.f11517f == -1) {
                int i16 = layoutState.f11513b;
                I = i16 - i10;
                iD = i16;
            } else {
                int i17 = layoutState.f11513b;
                iD = i17 + i10;
                I = i17;
            }
            iK = 0;
            iD2 = 0;
        } else if (layoutState.f11517f == -1) {
            iD2 = layoutState.f11513b;
            iK = iD2 - i10;
            I = 0;
            iD = 0;
        } else {
            int i18 = layoutState.f11513b;
            iK = i18;
            iD = 0;
            iD2 = i18 + i10;
            I = 0;
        }
        for (int i19 = 0; i19 < i7; i19++) {
            View view5 = this.H[i19];
            LayoutParams layoutParams3 = (LayoutParams) view5.getLayoutParams();
            if (this.p != 1) {
                iK = K() + this.G[layoutParams3.f11488e];
                iD2 = this.r.d(view5) + iK;
            } else if (b1()) {
                int I2 = I() + this.G[this.F - layoutParams3.f11488e];
                iD = I2;
                I = I2 - this.r.d(view5);
            } else {
                I = I() + this.G[layoutParams3.f11488e];
                iD = this.r.d(view5) + I;
            }
            RecyclerView.LayoutManager.R(view5, I, iK, iD, iD2);
            if (layoutParams3.f11596a.h() || layoutParams3.f11596a.k()) {
                layoutChunkResult.f11510c = true;
            }
            layoutChunkResult.f11511d = view5.hasFocusable() | layoutChunkResult.f11511d;
        }
        Arrays.fill(this.H, (Object) null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void d0() {
        DefaultSpanSizeLookup defaultSpanSizeLookup = this.K;
        defaultSpanSizeLookup.b();
        defaultSpanSizeLookup.f11491b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void d1(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i2) {
        v1();
        if (state.b() > 0 && !state.f11639g) {
            boolean z = i2 == 1;
            int iR1 = r1(anchorInfo.f11504b, recycler, state);
            if (z) {
                while (iR1 > 0) {
                    int i3 = anchorInfo.f11504b;
                    if (i3 <= 0) {
                        break;
                    }
                    int i4 = i3 - 1;
                    anchorInfo.f11504b = i4;
                    iR1 = r1(i4, recycler, state);
                }
            } else {
                int iB = state.b() - 1;
                int i5 = anchorInfo.f11504b;
                while (i5 < iB) {
                    int i6 = i5 + 1;
                    int iR12 = r1(i6, recycler, state);
                    if (iR12 <= iR1) {
                        break;
                    }
                    i5 = i6;
                    iR1 = iR12;
                }
                anchorInfo.f11504b = i5;
            }
        }
        o1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void e0(int i2, int i3) {
        DefaultSpanSizeLookup defaultSpanSizeLookup = this.K;
        defaultSpanSizeLookup.b();
        defaultSpanSizeLookup.f11491b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean f(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void f0(int i2, int i3) {
        DefaultSpanSizeLookup defaultSpanSizeLookup = this.K;
        defaultSpanSizeLookup.b();
        defaultSpanSizeLookup.f11491b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void g0(int i2, int i3) {
        DefaultSpanSizeLookup defaultSpanSizeLookup = this.K;
        defaultSpanSizeLookup.b();
        defaultSpanSizeLookup.f11491b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void h0(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.f11639g;
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z) {
            int iV = v();
            for (int i2 = 0; i2 < iV; i2++) {
                LayoutParams layoutParams = (LayoutParams) u(i2).getLayoutParams();
                int iB = layoutParams.f11596a.b();
                sparseIntArray2.put(iB, layoutParams.f11489f);
                sparseIntArray.put(iB, layoutParams.f11488e);
            }
        }
        super.h0(recycler, state);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void i0(RecyclerView.State state) {
        super.i0(state);
        this.E = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void j1(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.j1(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int k(RecyclerView.State state) {
        return K0(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int l(RecyclerView.State state) {
        return L0(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int n(RecyclerView.State state) {
        return K0(state);
    }

    public final void n1(int i2) {
        int i3;
        int[] iArr = this.G;
        int i4 = this.F;
        if (iArr == null || iArr.length != i4 + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i4 + 1];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i2 / i4;
        int i7 = i2 % i4;
        int i8 = 0;
        for (int i9 = 1; i9 <= i4; i9++) {
            i5 += i7;
            if (i5 <= 0 || i4 - i5 >= i7) {
                i3 = i6;
            } else {
                i3 = i6 + 1;
                i5 -= i4;
            }
            i8 += i3;
            iArr[i9] = i8;
        }
        this.G = iArr;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int o(RecyclerView.State state) {
        return L0(state);
    }

    public final void o1() {
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    public final int p1(int i2, int i3) {
        if (this.p != 1 || !b1()) {
            int[] iArr = this.G;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.G;
        int i4 = this.F;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    public final int q1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.f11639g;
        DefaultSpanSizeLookup defaultSpanSizeLookup = this.K;
        if (!z) {
            return defaultSpanSizeLookup.a(i2, this.F);
        }
        int iB = recycler.b(i2);
        if (iB != -1) {
            return defaultSpanSizeLookup.a(iB, this.F);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams r() {
        return this.p == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    public final int r1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.f11639g;
        DefaultSpanSizeLookup defaultSpanSizeLookup = this.K;
        if (!z) {
            int i3 = this.F;
            defaultSpanSizeLookup.getClass();
            return i2 % i3;
        }
        int i4 = this.J.get(i2, -1);
        if (i4 != -1) {
            return i4;
        }
        int iB = recycler.b(i2);
        if (iB != -1) {
            int i5 = this.F;
            defaultSpanSizeLookup.getClass();
            return iB % i5;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams s(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final int s1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.f11639g;
        DefaultSpanSizeLookup defaultSpanSizeLookup = this.K;
        if (!z) {
            defaultSpanSizeLookup.getClass();
            return 1;
        }
        int i3 = this.I.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        if (recycler.b(i2) != -1) {
            defaultSpanSizeLookup.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            LayoutParams layoutParams2 = new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            layoutParams2.f11488e = -1;
            layoutParams2.f11489f = 0;
            return layoutParams2;
        }
        LayoutParams layoutParams3 = new LayoutParams(layoutParams);
        layoutParams3.f11488e = -1;
        layoutParams3.f11489f = 0;
        return layoutParams3;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int t0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        v1();
        o1();
        return super.t0(i2, recycler, state);
    }

    public final void t1(int i2, View view, boolean z) {
        int iW;
        int iW2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f11597b;
        int i3 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i4 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int iP1 = p1(layoutParams.f11488e, layoutParams.f11489f);
        if (this.p == 1) {
            iW2 = RecyclerView.LayoutManager.w(false, iP1, i2, i4, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            iW = RecyclerView.LayoutManager.w(true, this.r.l(), this.f11589m, i3, ((ViewGroup.MarginLayoutParams) layoutParams).height);
        } else {
            int iW3 = RecyclerView.LayoutManager.w(false, iP1, i2, i3, ((ViewGroup.MarginLayoutParams) layoutParams).height);
            int iW4 = RecyclerView.LayoutManager.w(true, this.r.l(), this.f11588l, i4, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            iW = iW3;
            iW2 = iW4;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z ? D0(view, iW2, iW, layoutParams2) : B0(view, iW2, iW, layoutParams2)) {
            view.measure(iW2, iW);
        }
    }

    public final void u1(int i2) {
        if (i2 == this.F) {
            return;
        }
        this.E = true;
        if (i2 < 1) {
            throw new IllegalArgumentException(b.f(i2, "Span count should be at least 1. Provided "));
        }
        this.F = i2;
        this.K.b();
        s0();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int v0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        v1();
        o1();
        return super.v0(i2, recycler, state);
    }

    public final void v1() {
        int iH;
        int iK;
        if (this.p == 1) {
            iH = this.n - J();
            iK = I();
        } else {
            iH = this.o - H();
            iK = K();
        }
        n1(iH - iK);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int x(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.p == 1) {
            return this.F;
        }
        if (state.b() < 1) {
            return 0;
        }
        return q1(state.b() - 1, recycler, state) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void y0(Rect rect, int i2, int i3) {
        int iG;
        int iG2;
        if (this.G == null) {
            super.y0(rect, i2, i3);
        }
        int iJ = J() + I();
        int iH = H() + K();
        if (this.p == 1) {
            int iHeight = rect.height() + iH;
            RecyclerView recyclerView = this.f11578b;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            iG2 = RecyclerView.LayoutManager.g(i3, iHeight, recyclerView.getMinimumHeight());
            int[] iArr = this.G;
            iG = RecyclerView.LayoutManager.g(i2, iArr[iArr.length - 1] + iJ, this.f11578b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iJ;
            RecyclerView recyclerView2 = this.f11578b;
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            iG = RecyclerView.LayoutManager.g(i2, iWidth, recyclerView2.getMinimumWidth());
            int[] iArr2 = this.G;
            iG2 = RecyclerView.LayoutManager.g(i3, iArr2[iArr2.length - 1] + iH, this.f11578b.getMinimumHeight());
        }
        this.f11578b.setMeasuredDimension(iG, iG2);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e, reason: collision with root package name */
        public int f11488e;

        /* renamed from: f, reason: collision with root package name */
        public int f11489f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f11488e = -1;
            this.f11489f = 0;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f11488e = -1;
            this.f11489f = 0;
        }
    }

    public GridLayoutManager(int i2) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new DefaultSpanSizeLookup();
        this.L = new Rect();
        u1(i2);
    }
}
