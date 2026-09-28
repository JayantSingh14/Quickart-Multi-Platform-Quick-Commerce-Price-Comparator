package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public abstract class OrientationHelper {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.LayoutManager f11539a;

    /* renamed from: b, reason: collision with root package name */
    public int f11540b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f11541c = new Rect();

    /* renamed from: androidx.recyclerview.widget.OrientationHelper$1, reason: invalid class name */
    class AnonymousClass1 extends OrientationHelper {
        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int b(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            this.f11539a.getClass();
            return RecyclerView.LayoutManager.D(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int c(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            this.f11539a.getClass();
            return RecyclerView.LayoutManager.C(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int d(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            this.f11539a.getClass();
            return RecyclerView.LayoutManager.B(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            this.f11539a.getClass();
            return RecyclerView.LayoutManager.A(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int f() {
            return this.f11539a.n;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int g() {
            RecyclerView.LayoutManager layoutManager = this.f11539a;
            return layoutManager.n - layoutManager.J();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int h() {
            return this.f11539a.J();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int i() {
            return this.f11539a.f11588l;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int j() {
            return this.f11539a.f11589m;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int k() {
            return this.f11539a.I();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int l() {
            RecyclerView.LayoutManager layoutManager = this.f11539a;
            return (layoutManager.n - layoutManager.I()) - layoutManager.J();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int m(View view) {
            RecyclerView.LayoutManager layoutManager = this.f11539a;
            Rect rect = this.f11541c;
            layoutManager.O(rect, view);
            return rect.right;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int n(View view) {
            RecyclerView.LayoutManager layoutManager = this.f11539a;
            Rect rect = this.f11541c;
            layoutManager.O(rect, view);
            return rect.left;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final void o(int i2) {
            this.f11539a.S(i2);
        }
    }

    /* renamed from: androidx.recyclerview.widget.OrientationHelper$2, reason: invalid class name */
    class AnonymousClass2 extends OrientationHelper {
        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int b(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            this.f11539a.getClass();
            return RecyclerView.LayoutManager.y(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int c(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            this.f11539a.getClass();
            return RecyclerView.LayoutManager.B(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int d(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            this.f11539a.getClass();
            return RecyclerView.LayoutManager.C(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            this.f11539a.getClass();
            return RecyclerView.LayoutManager.E(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int f() {
            return this.f11539a.o;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int g() {
            RecyclerView.LayoutManager layoutManager = this.f11539a;
            return layoutManager.o - layoutManager.H();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int h() {
            return this.f11539a.H();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int i() {
            return this.f11539a.f11589m;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int j() {
            return this.f11539a.f11588l;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int k() {
            return this.f11539a.K();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int l() {
            RecyclerView.LayoutManager layoutManager = this.f11539a;
            return (layoutManager.o - layoutManager.K()) - layoutManager.H();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int m(View view) {
            RecyclerView.LayoutManager layoutManager = this.f11539a;
            Rect rect = this.f11541c;
            layoutManager.O(rect, view);
            return rect.bottom;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int n(View view) {
            RecyclerView.LayoutManager layoutManager = this.f11539a;
            Rect rect = this.f11541c;
            layoutManager.O(rect, view);
            return rect.top;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final void o(int i2) {
            this.f11539a.T(i2);
        }
    }

    public OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.f11539a = layoutManager;
    }

    public static OrientationHelper a(RecyclerView.LayoutManager layoutManager, int i2) {
        if (i2 == 0) {
            return new AnonymousClass1(layoutManager);
        }
        if (i2 == 1) {
            return new AnonymousClass2(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m(View view);

    public abstract int n(View view);

    public abstract void o(int i2);
}
