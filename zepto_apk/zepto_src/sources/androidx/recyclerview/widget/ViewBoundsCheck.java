package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
class ViewBoundsCheck {

    /* renamed from: a, reason: collision with root package name */
    public final Callback f11707a;

    /* renamed from: b, reason: collision with root package name */
    public final BoundFlags f11708b;

    public static class BoundFlags {

        /* renamed from: a, reason: collision with root package name */
        public int f11709a;

        /* renamed from: b, reason: collision with root package name */
        public int f11710b;

        /* renamed from: c, reason: collision with root package name */
        public int f11711c;

        /* renamed from: d, reason: collision with root package name */
        public int f11712d;

        /* renamed from: e, reason: collision with root package name */
        public int f11713e;

        public final boolean a() {
            int i2 = this.f11709a;
            int i3 = 2;
            if ((i2 & 7) != 0) {
                int i4 = this.f11712d;
                int i5 = this.f11710b;
                if (((i4 > i5 ? 1 : i4 == i5 ? 2 : 4) & i2) == 0) {
                    return false;
                }
            }
            if ((i2 & 112) != 0) {
                int i6 = this.f11712d;
                int i7 = this.f11711c;
                if ((((i6 > i7 ? 1 : i6 == i7 ? 2 : 4) << 4) & i2) == 0) {
                    return false;
                }
            }
            if ((i2 & 1792) != 0) {
                int i8 = this.f11713e;
                int i9 = this.f11710b;
                if ((((i8 > i9 ? 1 : i8 == i9 ? 2 : 4) << 8) & i2) == 0) {
                    return false;
                }
            }
            if ((i2 & 28672) != 0) {
                int i10 = this.f11713e;
                int i11 = this.f11711c;
                if (i10 > i11) {
                    i3 = 1;
                } else if (i10 != i11) {
                    i3 = 4;
                }
                if ((i2 & (i3 << 12)) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public interface Callback {
        View a(int i2);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    public ViewBoundsCheck(Callback callback) {
        this.f11707a = callback;
        BoundFlags boundFlags = new BoundFlags();
        boundFlags.f11709a = 0;
        this.f11708b = boundFlags;
    }

    public final View a(int i2, int i3, int i4, int i5) {
        Callback callback = this.f11707a;
        int iC = callback.c();
        int iD = callback.d();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View viewA = callback.a(i2);
            int iB = callback.b(viewA);
            int iE = callback.e(viewA);
            BoundFlags boundFlags = this.f11708b;
            boundFlags.f11710b = iC;
            boundFlags.f11711c = iD;
            boundFlags.f11712d = iB;
            boundFlags.f11713e = iE;
            if (i4 != 0) {
                boundFlags.f11709a = i4;
                if (boundFlags.a()) {
                    return viewA;
                }
            }
            if (i5 != 0) {
                boundFlags.f11709a = i5;
                if (boundFlags.a()) {
                    view = viewA;
                }
            }
            i2 += i6;
        }
        return view;
    }

    public final boolean b(View view) {
        Callback callback = this.f11707a;
        int iC = callback.c();
        int iD = callback.d();
        int iB = callback.b(view);
        int iE = callback.e(view);
        BoundFlags boundFlags = this.f11708b;
        boundFlags.f11710b = iC;
        boundFlags.f11711c = iD;
        boundFlags.f11712d = iB;
        boundFlags.f11713e = iE;
        boundFlags.f11709a = 24579;
        return boundFlags.a();
    }
}
