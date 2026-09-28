package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class WindowInsetsCompat {

    /* renamed from: b, reason: collision with root package name */
    public static final WindowInsetsCompat f3149b;

    /* renamed from: a, reason: collision with root package name */
    public final Impl f3150a;

    @RequiresApi
    @SuppressLint({"SoonBlockedPrivateApi"})
    /* loaded from: classes3.dex */
    public static class Api21ReflectionHolder {
        static {
            try {
                View.class.getDeclaredField("mAttachInfo").setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                cls.getDeclaredField("mStableInsets").setAccessible(true);
                cls.getDeclaredField("mContentInsets").setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
            }
        }
    }

    public static class BuilderImpl {

        /* renamed from: a, reason: collision with root package name */
        public final WindowInsetsCompat f3152a;

        /* renamed from: b, reason: collision with root package name */
        public Insets[] f3153b;

        public BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        public final void a() {
            Insets[] insetsArr = this.f3153b;
            if (insetsArr != null) {
                Insets insetsG = insetsArr[0];
                Insets insetsG2 = insetsArr[1];
                WindowInsetsCompat windowInsetsCompat = this.f3152a;
                if (insetsG2 == null) {
                    insetsG2 = windowInsetsCompat.f3150a.g(2);
                }
                if (insetsG == null) {
                    insetsG = windowInsetsCompat.f3150a.g(1);
                }
                g(Insets.a(insetsG, insetsG2));
                Insets insets = this.f3153b[Type.a(16)];
                if (insets != null) {
                    f(insets);
                }
                Insets insets2 = this.f3153b[Type.a(32)];
                if (insets2 != null) {
                    d(insets2);
                }
                Insets insets3 = this.f3153b[Type.a(64)];
                if (insets3 != null) {
                    h(insets3);
                }
            }
        }

        public WindowInsetsCompat b() {
            a();
            return this.f3152a;
        }

        public void c(int i2, Insets insets) {
            if (this.f3153b == null) {
                this.f3153b = new Insets[10];
            }
            for (int i3 = 1; i3 <= 512; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    this.f3153b[Type.a(i3)] = insets;
                }
            }
        }

        public void d(Insets insets) {
        }

        public void e(Insets insets) {
        }

        public void f(Insets insets) {
        }

        public void g(Insets insets) {
        }

        public void h(Insets insets) {
        }

        public BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
            this.f3152a = windowInsetsCompat;
        }
    }

    @RequiresApi
    public static class BuilderImpl30 extends BuilderImpl29 {
        public BuilderImpl30() {
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void c(int i2, Insets insets) {
            this.f3160c.setInsets(TypeImpl30.a(i2), insets.e());
        }

        public BuilderImpl30(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class BuilderImpl34 extends BuilderImpl30 {
        public BuilderImpl34() {
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl30, androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void c(int i2, Insets insets) {
            this.f3160c.setInsets(TypeImpl34.a(i2), insets.e());
        }

        public BuilderImpl34(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    public static class Impl {

        /* renamed from: b, reason: collision with root package name */
        public static final WindowInsetsCompat f3161b = new Builder().f3151a.b().f3150a.a().f3150a.b().f3150a.c();

        /* renamed from: a, reason: collision with root package name */
        public final WindowInsetsCompat f3162a;

        public Impl(WindowInsetsCompat windowInsetsCompat) {
            this.f3162a = windowInsetsCompat;
        }

        public WindowInsetsCompat a() {
            return this.f3162a;
        }

        public WindowInsetsCompat b() {
            return this.f3162a;
        }

        public WindowInsetsCompat c() {
            return this.f3162a;
        }

        public void d(View view) {
        }

        public void e(WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            return p() == impl.p() && o() == impl.o() && Objects.equals(l(), impl.l()) && Objects.equals(j(), impl.j()) && Objects.equals(f(), impl.f());
        }

        public DisplayCutoutCompat f() {
            return null;
        }

        public Insets g(int i2) {
            return Insets.f2807e;
        }

        public Insets h(int i2) {
            if ((i2 & 8) == 0) {
                return Insets.f2807e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        public Insets i() {
            return l();
        }

        public Insets j() {
            return Insets.f2807e;
        }

        public Insets k() {
            return l();
        }

        public Insets l() {
            return Insets.f2807e;
        }

        public Insets m() {
            return l();
        }

        public WindowInsetsCompat n(int i2, int i3, int i4, int i5) {
            return f3161b;
        }

        public boolean o() {
            return false;
        }

        public boolean p() {
            return false;
        }

        public boolean q(int i2) {
            return true;
        }

        public void r(Insets[] insetsArr) {
        }

        public void s(Insets insets) {
        }

        public void t(WindowInsetsCompat windowInsetsCompat) {
        }

        public void u(Insets insets) {
        }

        public void v(int i2) {
        }
    }

    @RequiresApi
    public static class Impl28 extends Impl21 {
        public Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.r(null, this.f3168c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            return Objects.equals(this.f3168c, impl28.f3168c) && Objects.equals(this.f3172g, impl28.f3172g) && Impl20.C(this.f3173h, impl28.f3173h);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public DisplayCutoutCompat f() {
            return DisplayCutoutCompat.e(this.f3168c.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.f3168c.hashCode();
        }

        public Impl28(WindowInsetsCompat windowInsetsCompat, Impl28 impl28) {
            super(windowInsetsCompat, impl28);
        }
    }

    @RequiresApi
    public static class Impl30 extends Impl29 {
        public static final WindowInsetsCompat r = WindowInsetsCompat.r(null, WindowInsets.CONSUMED);

        public Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public final void d(View view) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets g(int i2) {
            return Insets.d(this.f3168c.getInsets(TypeImpl30.a(i2)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets h(int i2) {
            return Insets.d(this.f3168c.getInsetsIgnoringVisibility(TypeImpl30.a(i2)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean q(int i2) {
            return this.f3168c.isVisible(TypeImpl30.a(i2));
        }

        public Impl30(WindowInsetsCompat windowInsetsCompat, Impl30 impl30) {
            super(windowInsetsCompat, impl30);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Impl34 extends Impl30 {
        public static final WindowInsetsCompat s = WindowInsetsCompat.r(null, WindowInsets.CONSUMED);

        public Impl34(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl30, androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets g(int i2) {
            return Insets.d(this.f3168c.getInsets(TypeImpl34.a(i2)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl30, androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public Insets h(int i2) {
            return Insets.d(this.f3168c.getInsetsIgnoringVisibility(TypeImpl34.a(i2)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl30, androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean q(int i2) {
            return this.f3168c.isVisible(TypeImpl34.a(i2));
        }

        public Impl34(WindowInsetsCompat windowInsetsCompat, Impl34 impl34) {
            super(windowInsetsCompat, impl34);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Side {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface InsetsSide {
        }
    }

    public static final class Type {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        /* loaded from: classes3.dex */
        public @interface InsetsType {
        }

        public static int a(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            if (i2 == 512) {
                return 9;
            }
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "type needs to be >= FIRST and <= LAST, type="));
        }
    }

    @RequiresApi
    public static final class TypeImpl30 {
        public static int a(int i2) {
            int iStatusBars;
            int i3 = 0;
            for (int i4 = 1; i4 <= 512; i4 <<= 1) {
                if ((i2 & i4) != 0) {
                    if (i4 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i3 |= iStatusBars;
                }
            }
            return i3;
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static final class TypeImpl34 {
        public static int a(int i2) {
            int iStatusBars;
            int i3 = 0;
            for (int i4 = 1; i4 <= 512; i4 <<= 1) {
                if ((i2 & i4) != 0) {
                    if (i4 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    } else if (i4 == 512) {
                        iStatusBars = WindowInsets.Type.systemOverlays();
                    }
                    i3 |= iStatusBars;
                }
            }
            return i3;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            f3149b = Impl34.s;
        } else if (i2 >= 30) {
            f3149b = Impl30.r;
        } else {
            f3149b = Impl.f3161b;
        }
    }

    public WindowInsetsCompat(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            this.f3150a = new Impl34(this, windowInsets);
            return;
        }
        if (i2 >= 30) {
            this.f3150a = new Impl30(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.f3150a = new Impl29(this, windowInsets);
        } else if (i2 >= 28) {
            this.f3150a = new Impl28(this, windowInsets);
        } else {
            this.f3150a = new Impl21(this, windowInsets);
        }
    }

    public static Insets m(Insets insets, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, insets.f2808a - i2);
        int iMax2 = Math.max(0, insets.f2809b - i3);
        int iMax3 = Math.max(0, insets.f2810c - i4);
        int iMax4 = Math.max(0, insets.f2811d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? insets : Insets.c(iMax, iMax2, iMax3, iMax4);
    }

    public static WindowInsetsCompat r(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            WindowInsetsCompat windowInsetsCompatA = ViewCompat.Api23Impl.a(view);
            Impl impl = windowInsetsCompat.f3150a;
            impl.t(windowInsetsCompatA);
            impl.d(view.getRootView());
            impl.v(view.getWindowSystemUiVisibility());
        }
        return windowInsetsCompat;
    }

    public final WindowInsetsCompat a() {
        return this.f3150a.a();
    }

    public final WindowInsetsCompat b() {
        return this.f3150a.b();
    }

    public final WindowInsetsCompat c() {
        return this.f3150a.c();
    }

    public final Insets d(int i2) {
        return this.f3150a.g(i2);
    }

    public final Insets e(int i2) {
        return this.f3150a.h(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return Objects.equals(this.f3150a, ((WindowInsetsCompat) obj).f3150a);
    }

    public final Insets f() {
        return this.f3150a.k();
    }

    public final int g() {
        return this.f3150a.l().f2811d;
    }

    public final int h() {
        return this.f3150a.l().f2808a;
    }

    public final int hashCode() {
        Impl impl = this.f3150a;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    public final int i() {
        return this.f3150a.l().f2810c;
    }

    public final int j() {
        return this.f3150a.l().f2809b;
    }

    public final boolean k() {
        return !this.f3150a.l().equals(Insets.f2807e);
    }

    public final WindowInsetsCompat l(int i2, int i3, int i4, int i5) {
        return this.f3150a.n(i2, i3, i4, i5);
    }

    public final boolean n() {
        return this.f3150a.o();
    }

    public final boolean o(int i2) {
        return this.f3150a.q(i2);
    }

    public final WindowInsetsCompat p(int i2, int i3, int i4, int i5) {
        Builder builder = new Builder(this);
        Insets insetsC = Insets.c(i2, i3, i4, i5);
        BuilderImpl builderImpl = builder.f3151a;
        builderImpl.g(insetsC);
        return builderImpl.b();
    }

    public final WindowInsets q() {
        Impl impl = this.f3150a;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).f3168c;
        }
        return null;
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class BuilderImpl20 extends BuilderImpl {

        /* renamed from: e, reason: collision with root package name */
        public static Field f3154e = null;

        /* renamed from: f, reason: collision with root package name */
        public static boolean f3155f = false;

        /* renamed from: g, reason: collision with root package name */
        public static Constructor f3156g = null;

        /* renamed from: h, reason: collision with root package name */
        public static boolean f3157h = false;

        /* renamed from: c, reason: collision with root package name */
        public WindowInsets f3158c;

        /* renamed from: d, reason: collision with root package name */
        public Insets f3159d;

        public BuilderImpl20() {
            this.f3158c = i();
        }

        private static WindowInsets i() {
            if (!f3155f) {
                try {
                    f3154e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f3155f = true;
            }
            Field field = f3154e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f3157h) {
                try {
                    f3156g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f3157h = true;
            }
            Constructor constructor = f3156g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompatR = WindowInsetsCompat.r(null, this.f3158c);
            Insets[] insetsArr = this.f3153b;
            Impl impl = windowInsetsCompatR.f3150a;
            impl.r(insetsArr);
            impl.u(this.f3159d);
            return windowInsetsCompatR;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void e(Insets insets) {
            this.f3159d = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void g(Insets insets) {
            WindowInsets windowInsets = this.f3158c;
            if (windowInsets != null) {
                this.f3158c = windowInsets.replaceSystemWindowInsets(insets.f2808a, insets.f2809b, insets.f2810c, insets.f2811d);
            }
        }

        public BuilderImpl20(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f3158c = windowInsetsCompat.q();
        }
    }

    @RequiresApi
    public static class BuilderImpl29 extends BuilderImpl {

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f3160c;

        public BuilderImpl29() {
            this.f3160c = androidx.appcompat.widget.a.f();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat windowInsetsCompatR = WindowInsetsCompat.r(null, this.f3160c.build());
            windowInsetsCompatR.f3150a.r(this.f3153b);
            return windowInsetsCompatR;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void d(Insets insets) {
            this.f3160c.setMandatorySystemGestureInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void e(Insets insets) {
            this.f3160c.setStableInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void f(Insets insets) {
            this.f3160c.setSystemGestureInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void g(Insets insets) {
            this.f3160c.setSystemWindowInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void h(Insets insets) {
            this.f3160c.setTappableElementInsets(insets.e());
        }

        public BuilderImpl29(WindowInsetsCompat windowInsetsCompat) {
            WindowInsets.Builder builderF;
            super(windowInsetsCompat);
            WindowInsets windowInsetsQ = windowInsetsCompat.q();
            if (windowInsetsQ != null) {
                builderF = androidx.appcompat.widget.e.c(windowInsetsQ);
            } else {
                builderF = androidx.appcompat.widget.a.f();
            }
            this.f3160c = builderF;
        }
    }

    @RequiresApi
    public static class Impl21 extends Impl20 {
        public Insets n;

        public Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.n = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat b() {
            return WindowInsetsCompat.r(null, this.f3168c.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat c() {
            return WindowInsetsCompat.r(null, this.f3168c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public final Insets j() {
            if (this.n == null) {
                WindowInsets windowInsets = this.f3168c;
                this.n = Insets.c(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
            }
            return this.n;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean o() {
            return this.f3168c.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void u(Insets insets) {
            this.n = insets;
        }

        public Impl21(WindowInsetsCompat windowInsetsCompat, Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            this.n = null;
            this.n = impl21.n;
        }
    }

    @RequiresApi
    public static class Impl20 extends Impl {

        /* renamed from: i, reason: collision with root package name */
        public static boolean f3163i = false;

        /* renamed from: j, reason: collision with root package name */
        public static Method f3164j;

        /* renamed from: k, reason: collision with root package name */
        public static Class f3165k;

        /* renamed from: l, reason: collision with root package name */
        public static Field f3166l;

        /* renamed from: m, reason: collision with root package name */
        public static Field f3167m;

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets f3168c;

        /* renamed from: d, reason: collision with root package name */
        public Insets[] f3169d;

        /* renamed from: e, reason: collision with root package name */
        public Insets f3170e;

        /* renamed from: f, reason: collision with root package name */
        public WindowInsetsCompat f3171f;

        /* renamed from: g, reason: collision with root package name */
        public Insets f3172g;

        /* renamed from: h, reason: collision with root package name */
        public int f3173h;

        public Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f3170e = null;
            this.f3168c = windowInsets;
        }

        @SuppressLint({"PrivateApi"})
        private static void B() throws ClassNotFoundException, SecurityException {
            try {
                f3164j = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f3165k = cls;
                f3166l = cls.getDeclaredField("mVisibleInsets");
                f3167m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f3166l.setAccessible(true);
                f3167m.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            f3163i = true;
        }

        public static boolean C(int i2, int i3) {
            return (i2 & 6) == (i3 & 6);
        }

        @SuppressLint({"WrongConstant"})
        private Insets w(int i2, boolean z) {
            Insets insetsA = Insets.f2807e;
            for (int i3 = 1; i3 <= 512; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    insetsA = Insets.a(insetsA, x(i3, z));
                }
            }
            return insetsA;
        }

        private Insets y() {
            WindowInsetsCompat windowInsetsCompat = this.f3171f;
            return windowInsetsCompat != null ? windowInsetsCompat.f3150a.j() : Insets.f2807e;
        }

        private Insets z(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f3163i) {
                B();
            }
            Method method = f3164j;
            if (method != null && f3165k != null && f3166l != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f3166l.get(f3167m.get(objInvoke));
                    if (rect != null) {
                        return Insets.c(rect.left, rect.top, rect.right, rect.bottom);
                    }
                } catch (ReflectiveOperationException e2) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                }
            }
            return null;
        }

        public boolean A(int i2) {
            if (i2 != 1 && i2 != 2) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 != 8 && i2 != 128) {
                    return true;
                }
            }
            return !x(i2, false).equals(Insets.f2807e);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void d(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Insets insetsZ = z(view);
            if (insetsZ == null) {
                insetsZ = Insets.f2807e;
            }
            s(insetsZ);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void e(WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.f3150a.t(this.f3171f);
            Insets insets = this.f3172g;
            Impl impl = windowInsetsCompat.f3150a;
            impl.s(insets);
            impl.v(this.f3173h);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            Impl20 impl20 = (Impl20) obj;
            return Objects.equals(this.f3172g, impl20.f3172g) && C(this.f3173h, impl20.f3173h);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets g(int i2) {
            return w(i2, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets h(int i2) {
            return w(i2, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public final Insets l() {
            if (this.f3170e == null) {
                WindowInsets windowInsets = this.f3168c;
                this.f3170e = Insets.c(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
            return this.f3170e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat n(int i2, int i3, int i4, int i5) {
            Builder builder = new Builder(WindowInsetsCompat.r(null, this.f3168c));
            builder.c(WindowInsetsCompat.m(l(), i2, i3, i4, i5));
            Insets insetsM = WindowInsetsCompat.m(j(), i2, i3, i4, i5);
            BuilderImpl builderImpl = builder.f3151a;
            builderImpl.e(insetsM);
            return builderImpl.b();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean p() {
            return this.f3168c.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @SuppressLint({"WrongConstant"})
        public boolean q(int i2) {
            for (int i3 = 1; i3 <= 512; i3 <<= 1) {
                if ((i2 & i3) != 0 && !A(i3)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void r(Insets[] insetsArr) {
            this.f3169d = insetsArr;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void s(Insets insets) {
            this.f3172g = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void t(WindowInsetsCompat windowInsetsCompat) {
            this.f3171f = windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void v(int i2) {
            this.f3173h = i2;
        }

        public Insets x(int i2, boolean z) {
            Insets insetsJ;
            int i3;
            Insets insets = Insets.f2807e;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 8) {
                        Insets[] insetsArr = this.f3169d;
                        insetsJ = insetsArr != null ? insetsArr[Type.a(8)] : null;
                        if (insetsJ != null) {
                            return insetsJ;
                        }
                        Insets insetsL = l();
                        Insets insetsY = y();
                        int i4 = insetsL.f2811d;
                        if (i4 > insetsY.f2811d) {
                            return Insets.c(0, 0, 0, i4);
                        }
                        Insets insets2 = this.f3172g;
                        if (insets2 != null && !insets2.equals(insets) && (i3 = this.f3172g.f2811d) > insetsY.f2811d) {
                            return Insets.c(0, 0, 0, i3);
                        }
                    } else {
                        if (i2 == 16) {
                            return k();
                        }
                        if (i2 == 32) {
                            return i();
                        }
                        if (i2 == 64) {
                            return m();
                        }
                        if (i2 == 128) {
                            WindowInsetsCompat windowInsetsCompat = this.f3171f;
                            DisplayCutoutCompat displayCutoutCompatF = windowInsetsCompat != null ? windowInsetsCompat.f3150a.f() : f();
                            if (displayCutoutCompatF != null) {
                                return Insets.c(displayCutoutCompatF.b(), displayCutoutCompatF.d(), displayCutoutCompatF.c(), displayCutoutCompatF.a());
                            }
                        }
                    }
                } else {
                    if (z) {
                        Insets insetsY2 = y();
                        Insets insetsJ2 = j();
                        return Insets.c(Math.max(insetsY2.f2808a, insetsJ2.f2808a), 0, Math.max(insetsY2.f2810c, insetsJ2.f2810c), Math.max(insetsY2.f2811d, insetsJ2.f2811d));
                    }
                    if ((this.f3173h & 2) == 0) {
                        Insets insetsL2 = l();
                        WindowInsetsCompat windowInsetsCompat2 = this.f3171f;
                        insetsJ = windowInsetsCompat2 != null ? windowInsetsCompat2.f3150a.j() : null;
                        int iMin = insetsL2.f2811d;
                        if (insetsJ != null) {
                            iMin = Math.min(iMin, insetsJ.f2811d);
                        }
                        return Insets.c(insetsL2.f2808a, 0, insetsL2.f2810c, iMin);
                    }
                }
            } else {
                if (z) {
                    return Insets.c(0, Math.max(y().f2809b, l().f2809b), 0, 0);
                }
                if ((this.f3173h & 4) == 0) {
                    return Insets.c(0, l().f2809b, 0, 0);
                }
            }
            return insets;
        }

        public Impl20(WindowInsetsCompat windowInsetsCompat, Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.f3168c));
        }
    }

    @RequiresApi
    public static class Impl29 extends Impl28 {
        public Insets o;
        public Insets p;
        public Insets q;

        public Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.o = null;
            this.p = null;
            this.q = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets i() {
            if (this.p == null) {
                this.p = Insets.d(this.f3168c.getMandatorySystemGestureInsets());
            }
            return this.p;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets k() {
            if (this.o == null) {
                this.o = Insets.d(this.f3168c.getSystemGestureInsets());
            }
            return this.o;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public Insets m() {
            if (this.q == null) {
                this.q = Insets.d(this.f3168c.getTappableElementInsets());
            }
            return this.q;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public WindowInsetsCompat n(int i2, int i3, int i4, int i5) {
            return WindowInsetsCompat.r(null, this.f3168c.inset(i2, i3, i4, i5));
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void u(Insets insets) {
        }

        public Impl29(WindowInsetsCompat windowInsetsCompat, Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            this.o = null;
            this.p = null;
            this.q = null;
        }
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final BuilderImpl f3151a;

        public Builder() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 34) {
                this.f3151a = new BuilderImpl34();
                return;
            }
            if (i2 >= 30) {
                this.f3151a = new BuilderImpl30();
            } else if (i2 >= 29) {
                this.f3151a = new BuilderImpl29();
            } else {
                this.f3151a = new BuilderImpl20();
            }
        }

        public final WindowInsetsCompat a() {
            return this.f3151a.b();
        }

        public final void b(int i2, Insets insets) {
            this.f3151a.c(i2, insets);
        }

        public final void c(Insets insets) {
            this.f3151a.g(insets);
        }

        public Builder(WindowInsetsCompat windowInsetsCompat) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 34) {
                this.f3151a = new BuilderImpl34(windowInsetsCompat);
                return;
            }
            if (i2 >= 30) {
                this.f3151a = new BuilderImpl30(windowInsetsCompat);
            } else if (i2 >= 29) {
                this.f3151a = new BuilderImpl29(windowInsetsCompat);
            } else {
                this.f3151a = new BuilderImpl20(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.f3150a;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 34 && (impl instanceof Impl34)) {
                this.f3150a = new Impl34(this, (Impl34) impl);
            } else if (i2 >= 30 && (impl instanceof Impl30)) {
                this.f3150a = new Impl30(this, (Impl30) impl);
            } else if (i2 >= 29 && (impl instanceof Impl29)) {
                this.f3150a = new Impl29(this, (Impl29) impl);
            } else if (i2 >= 28 && (impl instanceof Impl28)) {
                this.f3150a = new Impl28(this, (Impl28) impl);
            } else if (impl instanceof Impl21) {
                this.f3150a = new Impl21(this, (Impl21) impl);
            } else if (impl instanceof Impl20) {
                this.f3150a = new Impl20(this, (Impl20) impl);
            } else {
                this.f3150a = new Impl(this);
            }
            impl.e(this);
            return;
        }
        this.f3150a = new Impl(this);
    }
}
