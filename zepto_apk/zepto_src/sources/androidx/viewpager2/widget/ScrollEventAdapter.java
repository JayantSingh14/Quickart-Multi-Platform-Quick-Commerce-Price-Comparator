package androidx.viewpager2.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes3.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public ViewPager2.OnPageChangeCallback f12379a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager2 f12380b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f12381c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f12382d;

    /* renamed from: e, reason: collision with root package name */
    public int f12383e;

    /* renamed from: f, reason: collision with root package name */
    public int f12384f;

    /* renamed from: g, reason: collision with root package name */
    public final ScrollEventValues f12385g;

    /* renamed from: h, reason: collision with root package name */
    public int f12386h;

    /* renamed from: i, reason: collision with root package name */
    public int f12387i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12388j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12389k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12390l;

    public static final class ScrollEventValues {

        /* renamed from: a, reason: collision with root package name */
        public int f12391a;

        /* renamed from: b, reason: collision with root package name */
        public float f12392b;

        /* renamed from: c, reason: collision with root package name */
        public int f12393c;
    }

    public ScrollEventAdapter(ViewPager2 viewPager2) {
        this.f12380b = viewPager2;
        RecyclerView recyclerView = viewPager2.f12403j;
        this.f12381c = recyclerView;
        this.f12382d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f12385g = new ScrollEventValues();
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void a(int i2, RecyclerView recyclerView) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        int i3 = this.f12383e;
        boolean z = true;
        if (!(i3 == 1 && this.f12384f == 1) && i2 == 1) {
            this.f12383e = 1;
            int i4 = this.f12387i;
            if (i4 != -1) {
                this.f12386h = i4;
                this.f12387i = -1;
            } else if (this.f12386h == -1) {
                this.f12386h = this.f12382d.R0();
            }
            d(1);
            return;
        }
        if ((i3 == 1 || i3 == 4) && i2 == 2) {
            if (this.f12389k) {
                d(2);
                this.f12388j = true;
                return;
            }
            return;
        }
        if (i3 != 1 && i3 != 4) {
            z = false;
        }
        ScrollEventValues scrollEventValues = this.f12385g;
        if (z && i2 == 0) {
            k();
            if (!this.f12389k) {
                int i5 = scrollEventValues.f12391a;
                if (i5 != -1 && (onPageChangeCallback = this.f12379a) != null) {
                    onPageChangeCallback.b(0.0f, i5, 0);
                }
            } else if (scrollEventValues.f12393c == 0) {
                int i6 = this.f12386h;
                int i7 = scrollEventValues.f12391a;
                if (i6 != i7) {
                    c(i7);
                }
            }
            d(0);
            i();
        }
        if (this.f12383e == 2 && i2 == 0 && this.f12390l) {
            k();
            if (scrollEventValues.f12393c == 0) {
                int i8 = this.f12387i;
                int i9 = scrollEventValues.f12391a;
                if (i8 != i9) {
                    if (i9 == -1) {
                        i9 = 0;
                    }
                    c(i9);
                }
                d(0);
                i();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
        /*
            r5 = this;
            r6 = 1
            r5.f12389k = r6
            r5.k()
            boolean r0 = r5.f12388j
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r1 = r5.f12385g
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L3c
            r5.f12388j = r3
            if (r8 > 0) goto L28
            if (r8 != 0) goto L30
            if (r7 >= 0) goto L18
            r7 = r6
            goto L19
        L18:
            r7 = r3
        L19:
            androidx.viewpager2.widget.ViewPager2 r8 = r5.f12380b
            androidx.recyclerview.widget.LinearLayoutManager r8 = r8.f12400g
            int r8 = r8.G()
            if (r8 != r6) goto L25
            r8 = r6
            goto L26
        L25:
            r8 = r3
        L26:
            if (r7 != r8) goto L30
        L28:
            int r7 = r1.f12393c
            if (r7 == 0) goto L30
            int r7 = r1.f12391a
            int r7 = r7 + r6
            goto L32
        L30:
            int r7 = r1.f12391a
        L32:
            r5.f12387i = r7
            int r8 = r5.f12386h
            if (r8 == r7) goto L48
            r5.c(r7)
            goto L48
        L3c:
            int r7 = r5.f12383e
            if (r7 != 0) goto L48
            int r7 = r1.f12391a
            if (r7 != r2) goto L45
            r7 = r3
        L45:
            r5.c(r7)
        L48:
            int r7 = r1.f12391a
            if (r7 != r2) goto L4d
            r7 = r3
        L4d:
            float r8 = r1.f12392b
            int r0 = r1.f12393c
            androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback r4 = r5.f12379a
            if (r4 == 0) goto L58
            r4.b(r8, r7, r0)
        L58:
            int r7 = r1.f12391a
            int r8 = r5.f12387i
            if (r7 == r8) goto L60
            if (r8 != r2) goto L6e
        L60:
            int r7 = r1.f12393c
            if (r7 != 0) goto L6e
            int r7 = r5.f12384f
            if (r7 == r6) goto L6e
            r5.d(r3)
            r5.i()
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void c(int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f12379a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.c(i2);
        }
    }

    public final void d(int i2) {
        if ((this.f12383e == 3 && this.f12384f == 0) || this.f12384f == i2) {
            return;
        }
        this.f12384f = i2;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f12379a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.a(i2);
        }
    }

    public final double e() {
        k();
        ScrollEventValues scrollEventValues = this.f12385g;
        return scrollEventValues.f12391a + scrollEventValues.f12392b;
    }

    public final int f() {
        return this.f12384f;
    }

    public final boolean g() {
        return this.f12384f == 0;
    }

    public final void h(int i2, boolean z) {
        this.f12383e = z ? 2 : 3;
        boolean z2 = this.f12387i != i2;
        this.f12387i = i2;
        d(2);
        if (z2) {
            c(i2);
        }
    }

    public final void i() {
        this.f12383e = 0;
        this.f12384f = 0;
        ScrollEventValues scrollEventValues = this.f12385g;
        scrollEventValues.f12391a = -1;
        scrollEventValues.f12392b = 0.0f;
        scrollEventValues.f12393c = 0;
        this.f12386h = -1;
        this.f12387i = -1;
        this.f12388j = false;
        this.f12389k = false;
        this.f12390l = false;
    }

    public final void j(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f12379a = onPageChangeCallback;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.k():void");
    }
}
