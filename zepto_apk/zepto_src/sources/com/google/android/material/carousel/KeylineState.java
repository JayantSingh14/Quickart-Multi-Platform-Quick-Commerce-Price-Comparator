package com.google.android.material.carousel;

import androidx.fragment.app.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class KeylineState {

    /* renamed from: a, reason: collision with root package name */
    public final float f40160a;

    /* renamed from: b, reason: collision with root package name */
    public final List f40161b;

    /* renamed from: c, reason: collision with root package name */
    public final int f40162c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40163d;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final float f40164a;

        /* renamed from: b, reason: collision with root package name */
        public final float f40165b;

        /* renamed from: d, reason: collision with root package name */
        public Keyline f40167d;

        /* renamed from: e, reason: collision with root package name */
        public Keyline f40168e;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f40166c = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        public int f40169f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f40170g = -1;

        /* renamed from: h, reason: collision with root package name */
        public float f40171h = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        public int f40172i = -1;

        public Builder(float f2, float f3) {
            this.f40164a = f2;
            this.f40165b = f3;
        }

        public final void a(float f2, float f3, float f4, boolean z, boolean z2) {
            float fAbs;
            float f5 = f4 / 2.0f;
            float f6 = f2 - f5;
            float f7 = f5 + f2;
            float f8 = this.f40165b;
            if (f7 > f8) {
                fAbs = Math.abs(f7 - Math.max(f7 - f4, f8));
            } else {
                fAbs = 0.0f;
                if (f6 < 0.0f) {
                    fAbs = Math.abs(f6 - Math.min(f6 + f4, 0.0f));
                }
            }
            b(f2, f3, f4, z, z2, fAbs, 0.0f, 0.0f);
        }

        public final void b(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6, float f7) {
            if (f4 <= 0.0f) {
                return;
            }
            ArrayList arrayList = this.f40166c;
            if (z2) {
                if (z) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i2 = this.f40172i;
                if (i2 != -1 && i2 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f40172i = arrayList.size();
            }
            Keyline keyline = new Keyline(Float.MIN_VALUE, f2, f3, f4, z2, f5, f6, f7);
            if (z) {
                if (this.f40167d == null) {
                    this.f40167d = keyline;
                    this.f40169f = arrayList.size();
                }
                if (this.f40170g != -1 && arrayList.size() - this.f40170g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f4 != this.f40167d.f40176d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f40168e = keyline;
                this.f40170g = arrayList.size();
            } else {
                if (this.f40167d == null && f4 < this.f40171h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f40168e != null && f4 > this.f40171h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f40171h = f4;
            arrayList.add(keyline);
        }

        public final void c(float f2, float f3, float f4, int i2, boolean z) {
            if (i2 <= 0 || f4 <= 0.0f) {
                return;
            }
            int i3 = 0;
            while (i3 < i2) {
                float f5 = f3;
                float f6 = f4;
                boolean z2 = z;
                a((i3 * f4) + f2, f5, f6, z2, false);
                i3++;
                f3 = f5;
                f4 = f6;
                z = z2;
            }
        }

        public final KeylineState d() {
            if (this.f40167d == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                ArrayList arrayList2 = this.f40166c;
                int size = arrayList2.size();
                float f2 = this.f40164a;
                if (i2 >= size) {
                    return new KeylineState(f2, arrayList, this.f40169f, this.f40170g);
                }
                Keyline keyline = (Keyline) arrayList2.get(i2);
                arrayList.add(new Keyline((i2 * f2) + (this.f40167d.f40174b - (this.f40169f * f2)), keyline.f40174b, keyline.f40175c, keyline.f40176d, keyline.f40177e, keyline.f40178f, keyline.f40179g, keyline.f40180h));
                i2++;
            }
        }
    }

    public static final class Keyline {

        /* renamed from: a, reason: collision with root package name */
        public final float f40173a;

        /* renamed from: b, reason: collision with root package name */
        public final float f40174b;

        /* renamed from: c, reason: collision with root package name */
        public final float f40175c;

        /* renamed from: d, reason: collision with root package name */
        public final float f40176d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f40177e;

        /* renamed from: f, reason: collision with root package name */
        public final float f40178f;

        /* renamed from: g, reason: collision with root package name */
        public final float f40179g;

        /* renamed from: h, reason: collision with root package name */
        public final float f40180h;

        public Keyline(float f2, float f3, float f4, float f5, boolean z, float f6, float f7, float f8) {
            this.f40173a = f2;
            this.f40174b = f3;
            this.f40175c = f4;
            this.f40176d = f5;
            this.f40177e = z;
            this.f40178f = f6;
            this.f40179g = f7;
            this.f40180h = f8;
        }
    }

    public KeylineState(float f2, ArrayList arrayList, int i2, int i3) {
        this.f40160a = f2;
        this.f40161b = Collections.unmodifiableList(arrayList);
        this.f40162c = i2;
        this.f40163d = i3;
    }

    public final Keyline a() {
        return (Keyline) this.f40161b.get(this.f40162c);
    }

    public final Keyline b() {
        return (Keyline) this.f40161b.get(0);
    }

    public final Keyline c() {
        return (Keyline) this.f40161b.get(this.f40163d);
    }

    public final Keyline d() {
        return (Keyline) e.k(1, this.f40161b);
    }
}
