package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public final LazySpanLookup B;
    public final int C;
    public boolean D;
    public boolean E;
    public SavedState F;
    public final Rect G;
    public final AnchorInfo H;
    public final boolean I;
    public int[] J;
    public final Runnable K;
    public final int p;
    public final Span[] q;
    public final OrientationHelper r;
    public final OrientationHelper s;
    public final int t;
    public int u;
    public final LayoutState v;
    public boolean w;
    public final BitSet y;
    public boolean x = false;
    public int z = -1;
    public int A = Integer.MIN_VALUE;

    public class AnchorInfo {

        /* renamed from: a, reason: collision with root package name */
        public int f11677a;

        /* renamed from: b, reason: collision with root package name */
        public int f11678b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11679c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11680d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11681e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f11682f;

        public AnchorInfo() {
            a();
        }

        public final void a() {
            this.f11677a = -1;
            this.f11678b = Integer.MIN_VALUE;
            this.f11679c = false;
            this.f11680d = false;
            this.f11681e = false;
            int[] iArr = this.f11682f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e, reason: collision with root package name */
        public Span f11684e;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class LazySpanLookup {

        /* renamed from: a, reason: collision with root package name */
        public int[] f11685a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f11686b;

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new AnonymousClass1();

            /* renamed from: a, reason: collision with root package name */
            public int f11687a;

            /* renamed from: b, reason: collision with root package name */
            public int f11688b;

            /* renamed from: c, reason: collision with root package name */
            public int[] f11689c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f11690d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1, reason: invalid class name */
            public class AnonymousClass1 implements Parcelable.Creator<FullSpanItem> {
                @Override // android.os.Parcelable.Creator
                public final FullSpanItem createFromParcel(Parcel parcel) {
                    FullSpanItem fullSpanItem = new FullSpanItem();
                    fullSpanItem.f11687a = parcel.readInt();
                    fullSpanItem.f11688b = parcel.readInt();
                    fullSpanItem.f11690d = parcel.readInt() == 1;
                    int i2 = parcel.readInt();
                    if (i2 > 0) {
                        int[] iArr = new int[i2];
                        fullSpanItem.f11689c = iArr;
                        parcel.readIntArray(iArr);
                    }
                    return fullSpanItem;
                }

                @Override // android.os.Parcelable.Creator
                public final FullSpanItem[] newArray(int i2) {
                    return new FullSpanItem[i2];
                }
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public final String toString() {
                return "FullSpanItem{mPosition=" + this.f11687a + ", mGapDir=" + this.f11688b + ", mHasUnwantedGapAfter=" + this.f11690d + ", mGapPerSpan=" + Arrays.toString(this.f11689c) + '}';
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f11687a);
                parcel.writeInt(this.f11688b);
                parcel.writeInt(this.f11690d ? 1 : 0);
                int[] iArr = this.f11689c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f11689c);
                }
            }
        }

        public final void a() {
            int[] iArr = this.f11685a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f11686b = null;
        }

        public final void b(int i2) {
            int[] iArr = this.f11685a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i2, 10) + 1];
                this.f11685a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int length = iArr.length;
                while (length <= i2) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.f11685a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f11685a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public final void c(int i2, int i3) {
            int[] iArr = this.f11685a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            b(i4);
            int[] iArr2 = this.f11685a;
            System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
            Arrays.fill(this.f11685a, i2, i4, -1);
            ArrayList arrayList = this.f11686b;
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f11686b.get(size);
                int i5 = fullSpanItem.f11687a;
                if (i5 >= i2) {
                    fullSpanItem.f11687a = i5 + i3;
                }
            }
        }

        public final void d(int i2, int i3) {
            int[] iArr = this.f11685a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            b(i4);
            int[] iArr2 = this.f11685a;
            System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
            int[] iArr3 = this.f11685a;
            Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
            ArrayList arrayList = this.f11686b;
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f11686b.get(size);
                int i5 = fullSpanItem.f11687a;
                if (i5 >= i2) {
                    if (i5 < i4) {
                        this.f11686b.remove(size);
                    } else {
                        fullSpanItem.f11687a = i5 - i3;
                    }
                }
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public int f11691a;

        /* renamed from: b, reason: collision with root package name */
        public int f11692b;

        /* renamed from: c, reason: collision with root package name */
        public int f11693c;

        /* renamed from: d, reason: collision with root package name */
        public int[] f11694d;

        /* renamed from: e, reason: collision with root package name */
        public int f11695e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f11696f;

        /* renamed from: g, reason: collision with root package name */
        public ArrayList f11697g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f11698h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f11699i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f11700j;

        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState();
                savedState.f11691a = parcel.readInt();
                savedState.f11692b = parcel.readInt();
                int i2 = parcel.readInt();
                savedState.f11693c = i2;
                if (i2 > 0) {
                    int[] iArr = new int[i2];
                    savedState.f11694d = iArr;
                    parcel.readIntArray(iArr);
                }
                int i3 = parcel.readInt();
                savedState.f11695e = i3;
                if (i3 > 0) {
                    int[] iArr2 = new int[i3];
                    savedState.f11696f = iArr2;
                    parcel.readIntArray(iArr2);
                }
                savedState.f11698h = parcel.readInt() == 1;
                savedState.f11699i = parcel.readInt() == 1;
                savedState.f11700j = parcel.readInt() == 1;
                savedState.f11697g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
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
            parcel.writeInt(this.f11691a);
            parcel.writeInt(this.f11692b);
            parcel.writeInt(this.f11693c);
            if (this.f11693c > 0) {
                parcel.writeIntArray(this.f11694d);
            }
            parcel.writeInt(this.f11695e);
            if (this.f11695e > 0) {
                parcel.writeIntArray(this.f11696f);
            }
            parcel.writeInt(this.f11698h ? 1 : 0);
            parcel.writeInt(this.f11699i ? 1 : 0);
            parcel.writeInt(this.f11700j ? 1 : 0);
            parcel.writeList(this.f11697g);
        }
    }

    public class Span {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f11701a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public int f11702b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        public int f11703c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        public int f11704d = 0;

        /* renamed from: e, reason: collision with root package name */
        public final int f11705e;

        public Span(int i2) {
            this.f11705e = i2;
        }

        public final void a() {
            View view = (View) b.c(1, this.f11701a);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.f11703c = StaggeredGridLayoutManager.this.r.b(view);
            layoutParams.getClass();
        }

        public final void b() {
            this.f11701a.clear();
            this.f11702b = Integer.MIN_VALUE;
            this.f11703c = Integer.MIN_VALUE;
            this.f11704d = 0;
        }

        public final int c() {
            return StaggeredGridLayoutManager.this.w ? e(r1.size() - 1, -1) : e(0, this.f11701a.size());
        }

        public final int d() {
            return StaggeredGridLayoutManager.this.w ? e(0, this.f11701a.size()) : e(r1.size() - 1, -1);
        }

        public final int e(int i2, int i3) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            int iK = staggeredGridLayoutManager.r.k();
            int iG = staggeredGridLayoutManager.r.g();
            int i4 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = (View) this.f11701a.get(i2);
                int iE = staggeredGridLayoutManager.r.e(view);
                int iB = staggeredGridLayoutManager.r.b(view);
                boolean z = iE <= iG;
                boolean z2 = iB >= iK;
                if (z && z2 && (iE < iK || iB > iG)) {
                    return RecyclerView.LayoutManager.L(view);
                }
                i2 += i4;
            }
            return -1;
        }

        public final int f(int i2) {
            int i3 = this.f11703c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f11701a.size() == 0) {
                return i2;
            }
            a();
            return this.f11703c;
        }

        public final View g(int i2, int i3) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            ArrayList arrayList = this.f11701a;
            View view = null;
            if (i3 != -1) {
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    View view2 = (View) arrayList.get(size);
                    if ((staggeredGridLayoutManager.w && RecyclerView.LayoutManager.L(view2) >= i2) || ((!staggeredGridLayoutManager.w && RecyclerView.LayoutManager.L(view2) <= i2) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
                return view;
            }
            int size2 = arrayList.size();
            int i4 = 0;
            while (i4 < size2) {
                View view3 = (View) arrayList.get(i4);
                if ((staggeredGridLayoutManager.w && RecyclerView.LayoutManager.L(view3) <= i2) || ((!staggeredGridLayoutManager.w && RecyclerView.LayoutManager.L(view3) >= i2) || !view3.hasFocusable())) {
                    break;
                }
                i4++;
                view = view3;
            }
            return view;
        }

        public final int h(int i2) {
            int i3 = this.f11702b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f11701a.size() == 0) {
                return i2;
            }
            View view = (View) this.f11701a.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.f11702b = StaggeredGridLayoutManager.this.r.e(view);
            layoutParams.getClass();
            return this.f11702b;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.p = -1;
        this.w = false;
        LazySpanLookup lazySpanLookup = new LazySpanLookup();
        this.B = lazySpanLookup;
        this.C = 2;
        this.G = new Rect();
        this.H = new AnchorInfo();
        this.I = true;
        this.K = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
            @Override // java.lang.Runnable
            public final void run() {
                StaggeredGridLayoutManager.this.H0();
            }
        };
        RecyclerView.LayoutManager.Properties propertiesM = RecyclerView.LayoutManager.M(context, attributeSet, i2, i3);
        int i4 = propertiesM.f11592a;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i4 != this.t) {
            this.t = i4;
            OrientationHelper orientationHelper = this.r;
            this.r = this.s;
            this.s = orientationHelper;
            s0();
        }
        int i5 = propertiesM.f11593b;
        c(null);
        if (i5 != this.p) {
            lazySpanLookup.a();
            s0();
            this.p = i5;
            this.y = new BitSet(this.p);
            this.q = new Span[this.p];
            for (int i6 = 0; i6 < this.p; i6++) {
                this.q[i6] = new Span(i6);
            }
            s0();
        }
        boolean z = propertiesM.f11594c;
        c(null);
        SavedState savedState = this.F;
        if (savedState != null && savedState.f11698h != z) {
            savedState.f11698h = z;
        }
        this.w = z;
        s0();
        LayoutState layoutState = new LayoutState();
        layoutState.f11494a = true;
        layoutState.f11499f = 0;
        layoutState.f11500g = 0;
        this.v = layoutState;
        this.r = OrientationHelper.a(this, this.t);
        this.s = OrientationHelper.a(this, 1 - this.t);
    }

    public static int j1(int i2, int i3, int i4) {
        int mode;
        return (!(i3 == 0 && i4 == 0) && ((mode = View.MeasureSpec.getMode(i2)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void E0(int i2, RecyclerView recyclerView) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.f11618a = i2;
        F0(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean G0() {
        return this.F == null;
    }

    public final boolean H0() {
        int iQ0;
        if (v() != 0 && this.C != 0 && this.f11583g) {
            if (this.x) {
                iQ0 = R0();
                Q0();
            } else {
                iQ0 = Q0();
                R0();
            }
            LazySpanLookup lazySpanLookup = this.B;
            if (iQ0 == 0 && V0() != null) {
                lazySpanLookup.a();
                this.f11582f = true;
                s0();
                return true;
            }
        }
        return false;
    }

    public final int I0(RecyclerView.State state) {
        if (v() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.r;
        boolean z = !this.I;
        return ScrollbarHelper.a(state, orientationHelper, N0(z), M0(z), this, this.I);
    }

    public final int J0(RecyclerView.State state) {
        if (v() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.r;
        boolean z = !this.I;
        return ScrollbarHelper.b(state, orientationHelper, N0(z), M0(z), this, this.I, this.x);
    }

    public final int K0(RecyclerView.State state) {
        if (v() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.r;
        boolean z = !this.I;
        return ScrollbarHelper.c(state, orientationHelper, N0(z), M0(z), this, this.I);
    }

    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean, int] */
    public final int L0(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        Span span;
        ?? r6;
        int i2;
        int iH;
        int iC;
        int iK;
        int iC2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 1;
        this.y.set(0, this.p, true);
        LayoutState layoutState2 = this.v;
        int i8 = layoutState2.f11502i ? layoutState.f11498e == 1 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : Integer.MIN_VALUE : layoutState.f11498e == 1 ? layoutState.f11500g + layoutState.f11495b : layoutState.f11499f - layoutState.f11495b;
        int i9 = layoutState.f11498e;
        for (int i10 = 0; i10 < this.p; i10++) {
            if (!this.q[i10].f11701a.isEmpty()) {
                i1(this.q[i10], i9, i8);
            }
        }
        int iG = this.x ? this.r.g() : this.r.k();
        boolean z = false;
        while (true) {
            int i11 = layoutState.f11496c;
            if (((i11 < 0 || i11 >= state.b()) ? i6 : i7) == 0 || (!layoutState2.f11502i && this.y.isEmpty())) {
                break;
            }
            View view = recycler.k(layoutState.f11496c, Long.MAX_VALUE).f11653a;
            layoutState.f11496c += layoutState.f11497d;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int iB = layoutParams.f11596a.b();
            LazySpanLookup lazySpanLookup = this.B;
            int[] iArr = lazySpanLookup.f11685a;
            int i12 = (iArr == null || iB >= iArr.length) ? -1 : iArr[iB];
            if (i12 == -1) {
                if (Z0(layoutState.f11498e)) {
                    i5 = this.p - i7;
                    i4 = -1;
                    i3 = -1;
                } else {
                    i3 = i7;
                    i4 = this.p;
                    i5 = i6;
                }
                Span span2 = null;
                if (layoutState.f11498e == i7) {
                    int iK2 = this.r.k();
                    int i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    while (i5 != i4) {
                        Span span3 = this.q[i5];
                        int iF = span3.f(iK2);
                        if (iF < i13) {
                            i13 = iF;
                            span2 = span3;
                        }
                        i5 += i3;
                    }
                } else {
                    int iG2 = this.r.g();
                    int i14 = Integer.MIN_VALUE;
                    while (i5 != i4) {
                        Span span4 = this.q[i5];
                        int iH2 = span4.h(iG2);
                        if (iH2 > i14) {
                            span2 = span4;
                            i14 = iH2;
                        }
                        i5 += i3;
                    }
                }
                span = span2;
                lazySpanLookup.b(iB);
                lazySpanLookup.f11685a[iB] = span.f11705e;
            } else {
                span = this.q[i12];
            }
            layoutParams.f11684e = span;
            if (layoutState.f11498e == 1) {
                r6 = 0;
                b(-1, view, false);
            } else {
                r6 = 0;
                b(0, view, false);
            }
            if (this.t == 1) {
                i2 = 1;
                X0(view, RecyclerView.LayoutManager.w(r6, this.u, this.f11588l, r6, ((ViewGroup.MarginLayoutParams) layoutParams).width), RecyclerView.LayoutManager.w(true, this.o, this.f11589m, H() + K(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
            } else {
                i2 = 1;
                X0(view, RecyclerView.LayoutManager.w(true, this.n, this.f11588l, J() + I(), ((ViewGroup.MarginLayoutParams) layoutParams).width), RecyclerView.LayoutManager.w(false, this.u, this.f11589m, 0, ((ViewGroup.MarginLayoutParams) layoutParams).height));
            }
            if (layoutState.f11498e == i2) {
                iC = span.f(iG);
                iH = this.r.c(view) + iC;
            } else {
                iH = span.h(iG);
                iC = iH - this.r.c(view);
            }
            if (layoutState.f11498e == 1) {
                Span span5 = layoutParams.f11684e;
                span5.getClass();
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.f11684e = span5;
                ArrayList arrayList = span5.f11701a;
                arrayList.add(view);
                span5.f11703c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    span5.f11702b = Integer.MIN_VALUE;
                }
                if (layoutParams2.f11596a.h() || layoutParams2.f11596a.k()) {
                    span5.f11704d = StaggeredGridLayoutManager.this.r.c(view) + span5.f11704d;
                }
            } else {
                Span span6 = layoutParams.f11684e;
                span6.getClass();
                LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                layoutParams3.f11684e = span6;
                ArrayList arrayList2 = span6.f11701a;
                arrayList2.add(0, view);
                span6.f11702b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    span6.f11703c = Integer.MIN_VALUE;
                }
                if (layoutParams3.f11596a.h() || layoutParams3.f11596a.k()) {
                    span6.f11704d = StaggeredGridLayoutManager.this.r.c(view) + span6.f11704d;
                }
            }
            if (W0() && this.t == 1) {
                iC2 = this.s.g() - (((this.p - 1) - span.f11705e) * this.u);
                iK = iC2 - this.s.c(view);
            } else {
                iK = this.s.k() + (span.f11705e * this.u);
                iC2 = this.s.c(view) + iK;
            }
            if (this.t == 1) {
                RecyclerView.LayoutManager.R(view, iK, iC, iC2, iH);
            } else {
                RecyclerView.LayoutManager.R(view, iC, iK, iH, iC2);
            }
            i1(span, layoutState2.f11498e, i8);
            b1(recycler, layoutState2);
            if (layoutState2.f11501h && view.hasFocusable()) {
                this.y.set(span.f11705e, false);
            }
            i7 = 1;
            z = true;
            i6 = 0;
        }
        if (!z) {
            b1(recycler, layoutState2);
        }
        int iK3 = layoutState2.f11498e == -1 ? this.r.k() - T0(this.r.k()) : S0(this.r.g()) - this.r.g();
        if (iK3 > 0) {
            return Math.min(layoutState.f11495b, iK3);
        }
        return 0;
    }

    public final View M0(boolean z) {
        int iK = this.r.k();
        int iG = this.r.g();
        View view = null;
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            int iE = this.r.e(viewU);
            int iB = this.r.b(viewU);
            if (iB > iK && iE < iG) {
                if (iB <= iG || !z) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final View N0(boolean z) {
        int iK = this.r.k();
        int iG = this.r.g();
        int iV = v();
        View view = null;
        for (int i2 = 0; i2 < iV; i2++) {
            View viewU = u(i2);
            int iE = this.r.e(viewU);
            if (this.r.b(viewU) > iK && iE < iG) {
                if (iE >= iK || !z) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final void O0(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iG;
        int iS0 = S0(Integer.MIN_VALUE);
        if (iS0 != Integer.MIN_VALUE && (iG = this.r.g() - iS0) > 0) {
            int i2 = iG - (-f1(-iG, recycler, state));
            if (!z || i2 <= 0) {
                return;
            }
            this.r.o(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean P() {
        return this.C != 0;
    }

    public final void P0(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iK;
        int iT0 = T0(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (iT0 != Integer.MAX_VALUE && (iK = iT0 - this.r.k()) > 0) {
            int iF1 = iK - f1(iK, recycler, state);
            if (!z || iF1 <= 0) {
                return;
            }
            this.r.o(-iF1);
        }
    }

    public final int Q0() {
        if (v() == 0) {
            return 0;
        }
        return RecyclerView.LayoutManager.L(u(0));
    }

    public final int R0() {
        int iV = v();
        if (iV == 0) {
            return 0;
        }
        return RecyclerView.LayoutManager.L(u(iV - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void S(int i2) {
        super.S(i2);
        for (int i3 = 0; i3 < this.p; i3++) {
            Span span = this.q[i3];
            int i4 = span.f11702b;
            if (i4 != Integer.MIN_VALUE) {
                span.f11702b = i4 + i2;
            }
            int i5 = span.f11703c;
            if (i5 != Integer.MIN_VALUE) {
                span.f11703c = i5 + i2;
            }
        }
    }

    public final int S0(int i2) {
        int iF = this.q[0].f(i2);
        for (int i3 = 1; i3 < this.p; i3++) {
            int iF2 = this.q[i3].f(i2);
            if (iF2 > iF) {
                iF = iF2;
            }
        }
        return iF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void T(int i2) {
        super.T(i2);
        for (int i3 = 0; i3 < this.p; i3++) {
            Span span = this.q[i3];
            int i4 = span.f11702b;
            if (i4 != Integer.MIN_VALUE) {
                span.f11702b = i4 + i2;
            }
            int i5 = span.f11703c;
            if (i5 != Integer.MIN_VALUE) {
                span.f11703c = i5 + i2;
            }
        }
    }

    public final int T0(int i2) {
        int iH = this.q[0].h(i2);
        for (int i3 = 1; i3 < this.p; i3++) {
            int iH2 = this.q[i3].h(i2);
            if (iH2 < iH) {
                iH = iH2;
            }
        }
        return iH;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void U() {
        this.B.a();
        for (int i2 = 0; i2 < this.p; i2++) {
            this.q[i2].b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U0(int r10, int r11, int r12) {
        /*
            r9 = this;
            boolean r0 = r9.x
            if (r0 == 0) goto L9
            int r0 = r9.R0()
            goto Ld
        L9:
            int r0 = r9.Q0()
        Ld:
            r1 = 8
            if (r12 != r1) goto L1b
            if (r10 >= r11) goto L17
            int r2 = r11 + 1
        L15:
            r3 = r10
            goto L1e
        L17:
            int r2 = r10 + 1
            r3 = r11
            goto L1e
        L1b:
            int r2 = r10 + r11
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r9.B
            int[] r5 = r4.f11685a
            r6 = -1
            if (r5 != 0) goto L27
            goto L9a
        L27:
            int r5 = r5.length
            if (r3 < r5) goto L2c
            goto L9a
        L2c:
            java.util.ArrayList r5 = r4.f11686b
            if (r5 != 0) goto L32
        L30:
            r5 = r6
            goto L80
        L32:
            if (r5 != 0) goto L35
            goto L4d
        L35:
            int r5 = r5.size()
            int r5 = r5 + (-1)
        L3b:
            if (r5 < 0) goto L4d
            java.util.ArrayList r7 = r4.f11686b
            java.lang.Object r7 = r7.get(r5)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r7 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r7
            int r8 = r7.f11687a
            if (r8 != r3) goto L4a
            goto L4e
        L4a:
            int r5 = r5 + (-1)
            goto L3b
        L4d:
            r7 = 0
        L4e:
            if (r7 == 0) goto L55
            java.util.ArrayList r5 = r4.f11686b
            r5.remove(r7)
        L55:
            java.util.ArrayList r5 = r4.f11686b
            int r5 = r5.size()
            r7 = 0
        L5c:
            if (r7 >= r5) goto L6e
            java.util.ArrayList r8 = r4.f11686b
            java.lang.Object r8 = r8.get(r7)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r8
            int r8 = r8.f11687a
            if (r8 < r3) goto L6b
            goto L6f
        L6b:
            int r7 = r7 + 1
            goto L5c
        L6e:
            r7 = r6
        L6f:
            if (r7 == r6) goto L30
            java.util.ArrayList r5 = r4.f11686b
            java.lang.Object r5 = r5.get(r7)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r5 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r5
            java.util.ArrayList r8 = r4.f11686b
            r8.remove(r7)
            int r5 = r5.f11687a
        L80:
            if (r5 != r6) goto L8c
            int[] r5 = r4.f11685a
            int r7 = r5.length
            java.util.Arrays.fill(r5, r3, r7, r6)
            int[] r5 = r4.f11685a
            int r5 = r5.length
            goto L9a
        L8c:
            int r5 = r5 + 1
            int[] r7 = r4.f11685a
            int r7 = r7.length
            int r5 = java.lang.Math.min(r5, r7)
            int[] r7 = r4.f11685a
            java.util.Arrays.fill(r7, r3, r5, r6)
        L9a:
            r5 = 1
            if (r12 == r5) goto Lae
            r6 = 2
            if (r12 == r6) goto Laa
            if (r12 == r1) goto La3
            goto Lb1
        La3:
            r4.d(r10, r5)
            r4.c(r11, r5)
            goto Lb1
        Laa:
            r4.d(r10, r11)
            goto Lb1
        Lae:
            r4.c(r10, r11)
        Lb1:
            if (r2 > r0) goto Lb4
            goto Lc6
        Lb4:
            boolean r10 = r9.x
            if (r10 == 0) goto Lbd
            int r10 = r9.Q0()
            goto Lc1
        Lbd:
            int r10 = r9.R0()
        Lc1:
            if (r3 > r10) goto Lc6
            r9.s0()
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.U0(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View V0() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.V0():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void W(RecyclerView recyclerView) {
        Runnable runnable = this.K;
        RecyclerView recyclerView2 = this.f11578b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(runnable);
        }
        for (int i2 = 0; i2 < this.p; i2++) {
            this.q[i2].b();
        }
        recyclerView.requestLayout();
    }

    public final boolean W0() {
        return G() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0051  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View X(android.view.View r9, int r10, androidx.recyclerview.widget.RecyclerView.Recycler r11, androidx.recyclerview.widget.RecyclerView.State r12) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.X(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public final void X0(View view, int i2, int i3) {
        RecyclerView recyclerView = this.f11578b;
        Rect rect = this.G;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.P(view));
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iJ1 = j1(i2, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int iJ12 = j1(i3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.bottom);
        if (B0(view, iJ1, iJ12, layoutParams)) {
            view.measure(iJ1, iJ12);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void Y(AccessibilityEvent accessibilityEvent) {
        super.Y(accessibilityEvent);
        if (v() > 0) {
            View viewN0 = N0(false);
            View viewM0 = M0(false);
            if (viewN0 == null || viewM0 == null) {
                return;
            }
            int iL = RecyclerView.LayoutManager.L(viewN0);
            int iL2 = RecyclerView.LayoutManager.L(viewM0);
            if (iL < iL2) {
                accessibilityEvent.setFromIndex(iL);
                accessibilityEvent.setToIndex(iL2);
            } else {
                accessibilityEvent.setFromIndex(iL2);
                accessibilityEvent.setToIndex(iL);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0417  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y0(androidx.recyclerview.widget.RecyclerView.Recycler r17, androidx.recyclerview.widget.RecyclerView.State r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1074
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Y0(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    public final boolean Z0(int i2) {
        if (this.t == 0) {
            return (i2 == -1) != this.x;
        }
        return ((i2 == -1) == this.x) == W0();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF a(int r4) {
        /*
            r3 = this;
            int r0 = r3.v()
            r1 = -1
            r2 = 1
            if (r0 != 0) goto Le
            boolean r4 = r3.x
            if (r4 == 0) goto L1b
        Lc:
            r1 = r2
            goto L1b
        Le:
            int r0 = r3.Q0()
            if (r4 >= r0) goto L16
            r4 = r2
            goto L17
        L16:
            r4 = 0
        L17:
            boolean r0 = r3.x
            if (r4 == r0) goto Lc
        L1b:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>()
            if (r1 != 0) goto L24
            r4 = 0
            return r4
        L24:
            int r0 = r3.t
            r2 = 0
            if (r0 != 0) goto L2f
            float r0 = (float) r1
            r4.x = r0
            r4.y = r2
            return r4
        L2f:
            r4.x = r2
            float r0 = (float) r1
            r4.y = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int):android.graphics.PointF");
    }

    public final void a1(int i2, RecyclerView.State state) {
        int iQ0;
        int i3;
        if (i2 > 0) {
            iQ0 = R0();
            i3 = 1;
        } else {
            iQ0 = Q0();
            i3 = -1;
        }
        LayoutState layoutState = this.v;
        layoutState.f11494a = true;
        h1(iQ0, state);
        g1(i3);
        layoutState.f11496c = iQ0 + layoutState.f11497d;
        layoutState.f11495b = Math.abs(i2);
    }

    public final void b1(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.f11494a || layoutState.f11502i) {
            return;
        }
        if (layoutState.f11495b == 0) {
            if (layoutState.f11498e == -1) {
                c1(recycler, layoutState.f11500g);
                return;
            } else {
                d1(recycler, layoutState.f11499f);
                return;
            }
        }
        int i2 = 1;
        if (layoutState.f11498e == -1) {
            int i3 = layoutState.f11499f;
            int iH = this.q[0].h(i3);
            while (i2 < this.p) {
                int iH2 = this.q[i2].h(i3);
                if (iH2 > iH) {
                    iH = iH2;
                }
                i2++;
            }
            int i4 = i3 - iH;
            c1(recycler, i4 < 0 ? layoutState.f11500g : layoutState.f11500g - Math.min(i4, layoutState.f11495b));
            return;
        }
        int i5 = layoutState.f11500g;
        int iF = this.q[0].f(i5);
        while (i2 < this.p) {
            int iF2 = this.q[i2].f(i5);
            if (iF2 < iF) {
                iF = iF2;
            }
            i2++;
        }
        int i6 = iF - layoutState.f11500g;
        d1(recycler, i6 < 0 ? layoutState.f11499f : Math.min(i6, layoutState.f11495b) + layoutState.f11499f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void c0(int i2, int i3) {
        U0(i2, i3, 1);
    }

    public final void c1(RecyclerView.Recycler recycler, int i2) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            if (this.r.e(viewU) < i2 || this.r.n(viewU) < i2) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) viewU.getLayoutParams();
            layoutParams.getClass();
            if (layoutParams.f11684e.f11701a.size() == 1) {
                return;
            }
            Span span = layoutParams.f11684e;
            ArrayList arrayList = span.f11701a;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.f11684e = null;
            if (layoutParams2.f11596a.h() || layoutParams2.f11596a.k()) {
                span.f11704d -= StaggeredGridLayoutManager.this.r.c(view);
            }
            if (size == 1) {
                span.f11702b = Integer.MIN_VALUE;
            }
            span.f11703c = Integer.MIN_VALUE;
            p0(viewU, recycler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean d() {
        return this.t == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void d0() {
        this.B.a();
        s0();
    }

    public final void d1(RecyclerView.Recycler recycler, int i2) {
        while (v() > 0) {
            View viewU = u(0);
            if (this.r.b(viewU) > i2 || this.r.m(viewU) > i2) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) viewU.getLayoutParams();
            layoutParams.getClass();
            if (layoutParams.f11684e.f11701a.size() == 1) {
                return;
            }
            Span span = layoutParams.f11684e;
            ArrayList arrayList = span.f11701a;
            View view = (View) arrayList.remove(0);
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.f11684e = null;
            if (arrayList.size() == 0) {
                span.f11703c = Integer.MIN_VALUE;
            }
            if (layoutParams2.f11596a.h() || layoutParams2.f11596a.k()) {
                span.f11704d -= StaggeredGridLayoutManager.this.r.c(view);
            }
            span.f11702b = Integer.MIN_VALUE;
            p0(viewU, recycler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean e() {
        return this.t == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void e0(int i2, int i3) {
        U0(i2, i3, 8);
    }

    public final void e1() {
        if (this.t == 1 || !W0()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean f(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void f0(int i2, int i3) {
        U0(i2, i3, 2);
    }

    public final int f1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (v() == 0 || i2 == 0) {
            return 0;
        }
        a1(i2, state);
        LayoutState layoutState = this.v;
        int iL0 = L0(recycler, layoutState, state);
        if (layoutState.f11495b >= iL0) {
            i2 = i2 < 0 ? -iL0 : iL0;
        }
        this.r.o(-i2);
        this.D = this.x;
        layoutState.f11495b = 0;
        b1(recycler, layoutState);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void g0(int i2, int i3) {
        U0(i2, i3, 4);
    }

    public final void g1(int i2) {
        LayoutState layoutState = this.v;
        layoutState.f11498e = i2;
        layoutState.f11497d = this.x != (i2 == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void h(int i2, int i3, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        LayoutState layoutState;
        int iF;
        int iH;
        if (this.t != 0) {
            i2 = i3;
        }
        if (v() == 0 || i2 == 0) {
            return;
        }
        a1(i2, state);
        int[] iArr = this.J;
        if (iArr == null || iArr.length < this.p) {
            this.J = new int[this.p];
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.p;
            layoutState = this.v;
            if (i4 >= i6) {
                break;
            }
            if (layoutState.f11497d == -1) {
                iF = layoutState.f11499f;
                iH = this.q[i4].h(iF);
            } else {
                iF = this.q[i4].f(layoutState.f11500g);
                iH = layoutState.f11500g;
            }
            int i7 = iF - iH;
            if (i7 >= 0) {
                this.J[i5] = i7;
                i5++;
            }
            i4++;
        }
        Arrays.sort(this.J, 0, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = layoutState.f11496c;
            if (i9 < 0 || i9 >= state.b()) {
                return;
            }
            ((GapWorker.LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).a(layoutState.f11496c, this.J[i8]);
            layoutState.f11496c += layoutState.f11497d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void h0(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Y0(recycler, state, true);
    }

    public final void h1(int i2, RecyclerView.State state) {
        int iL;
        int iL2;
        int i3;
        LayoutState layoutState = this.v;
        boolean z = false;
        layoutState.f11495b = 0;
        layoutState.f11496c = i2;
        RecyclerView.SmoothScroller smoothScroller = this.f11581e;
        if (!(smoothScroller != null && smoothScroller.f11622e) || (i3 = state.f11633a) == -1) {
            iL = 0;
            iL2 = 0;
        } else {
            if (this.x == (i3 < i2)) {
                iL = this.r.l();
                iL2 = 0;
            } else {
                iL2 = this.r.l();
                iL = 0;
            }
        }
        RecyclerView recyclerView = this.f11578b;
        if (recyclerView == null || !recyclerView.f11551h) {
            layoutState.f11500g = this.r.f() + iL;
            layoutState.f11499f = -iL2;
        } else {
            layoutState.f11499f = this.r.k() - iL2;
            layoutState.f11500g = this.r.g() + iL;
        }
        layoutState.f11501h = false;
        layoutState.f11494a = true;
        if (this.r.i() == 0 && this.r.f() == 0) {
            z = true;
        }
        layoutState.f11502i = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void i0(RecyclerView.State state) {
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    public final void i1(Span span, int i2, int i3) {
        int i4 = span.f11704d;
        int i5 = span.f11705e;
        if (i2 != -1) {
            int i6 = span.f11703c;
            if (i6 == Integer.MIN_VALUE) {
                span.a();
                i6 = span.f11703c;
            }
            if (i6 - i4 >= i3) {
                this.y.set(i5, false);
                return;
            }
            return;
        }
        int i7 = span.f11702b;
        if (i7 == Integer.MIN_VALUE) {
            View view = (View) span.f11701a.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            span.f11702b = StaggeredGridLayoutManager.this.r.e(view);
            layoutParams.getClass();
            i7 = span.f11702b;
        }
        if (i7 + i4 <= i3) {
            this.y.set(i5, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int j(RecyclerView.State state) {
        return I0(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void j0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.F = savedState;
            if (this.z != -1) {
                savedState.f11694d = null;
                savedState.f11693c = 0;
                savedState.f11691a = -1;
                savedState.f11692b = -1;
                savedState.f11694d = null;
                savedState.f11693c = 0;
                savedState.f11695e = 0;
                savedState.f11696f = null;
                savedState.f11697g = null;
            }
            s0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int k(RecyclerView.State state) {
        return J0(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final Parcelable k0() {
        int iH;
        int iK;
        int[] iArr;
        SavedState savedState = this.F;
        if (savedState != null) {
            SavedState savedState2 = new SavedState();
            savedState2.f11693c = savedState.f11693c;
            savedState2.f11691a = savedState.f11691a;
            savedState2.f11692b = savedState.f11692b;
            savedState2.f11694d = savedState.f11694d;
            savedState2.f11695e = savedState.f11695e;
            savedState2.f11696f = savedState.f11696f;
            savedState2.f11698h = savedState.f11698h;
            savedState2.f11699i = savedState.f11699i;
            savedState2.f11700j = savedState.f11700j;
            savedState2.f11697g = savedState.f11697g;
            return savedState2;
        }
        SavedState savedState3 = new SavedState();
        savedState3.f11698h = this.w;
        savedState3.f11699i = this.D;
        savedState3.f11700j = this.E;
        LazySpanLookup lazySpanLookup = this.B;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f11685a) == null) {
            savedState3.f11695e = 0;
        } else {
            savedState3.f11696f = iArr;
            savedState3.f11695e = iArr.length;
            savedState3.f11697g = lazySpanLookup.f11686b;
        }
        if (v() <= 0) {
            savedState3.f11691a = -1;
            savedState3.f11692b = -1;
            savedState3.f11693c = 0;
            return savedState3;
        }
        savedState3.f11691a = this.D ? R0() : Q0();
        View viewM0 = this.x ? M0(true) : N0(true);
        savedState3.f11692b = viewM0 != null ? RecyclerView.LayoutManager.L(viewM0) : -1;
        int i2 = this.p;
        savedState3.f11693c = i2;
        savedState3.f11694d = new int[i2];
        for (int i3 = 0; i3 < this.p; i3++) {
            if (this.D) {
                iH = this.q[i3].f(Integer.MIN_VALUE);
                if (iH != Integer.MIN_VALUE) {
                    iK = this.r.g();
                    iH -= iK;
                }
            } else {
                iH = this.q[i3].h(Integer.MIN_VALUE);
                if (iH != Integer.MIN_VALUE) {
                    iK = this.r.k();
                    iH -= iK;
                }
            }
            savedState3.f11694d[i3] = iH;
        }
        return savedState3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int l(RecyclerView.State state) {
        return K0(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void l0(int i2) {
        if (i2 == 0) {
            H0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int m(RecyclerView.State state) {
        return I0(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int n(RecyclerView.State state) {
        return J0(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int o(RecyclerView.State state) {
        return K0(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams r() {
        return this.t == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams s(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int t0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return f1(i2, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void u0(int i2) {
        SavedState savedState = this.F;
        if (savedState != null && savedState.f11691a != i2) {
            savedState.f11694d = null;
            savedState.f11693c = 0;
            savedState.f11691a = -1;
            savedState.f11692b = -1;
        }
        this.z = i2;
        this.A = Integer.MIN_VALUE;
        s0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int v0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return f1(i2, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void y0(Rect rect, int i2, int i3) {
        int iG;
        int iG2;
        int i4 = this.p;
        int iJ = J() + I();
        int iH = H() + K();
        if (this.t == 1) {
            int iHeight = rect.height() + iH;
            RecyclerView recyclerView = this.f11578b;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            iG2 = RecyclerView.LayoutManager.g(i3, iHeight, recyclerView.getMinimumHeight());
            iG = RecyclerView.LayoutManager.g(i2, (this.u * i4) + iJ, this.f11578b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iJ;
            RecyclerView recyclerView2 = this.f11578b;
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            iG = RecyclerView.LayoutManager.g(i2, iWidth, recyclerView2.getMinimumWidth());
            iG2 = RecyclerView.LayoutManager.g(i3, (this.u * i4) + iH, this.f11578b.getMinimumHeight());
        }
        this.f11578b.setMeasuredDimension(iG, iG2);
    }
}
