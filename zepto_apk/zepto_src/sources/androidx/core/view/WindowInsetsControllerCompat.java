package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes3.dex */
public final class WindowInsetsControllerCompat {

    /* renamed from: a, reason: collision with root package name */
    public final Impl f3174a;

    public static class Impl {
        public int a() {
            return 1;
        }

        public void b(int i2) {
        }

        public boolean c() {
            return false;
        }

        public void d(boolean z) {
        }

        public void e(boolean z) {
        }

        public void f(int i2) {
        }

        public void g(int i2) {
        }
    }

    @RequiresApi
    public static class Impl20 extends Impl {

        /* renamed from: a, reason: collision with root package name */
        public final Window f3175a;

        /* renamed from: b, reason: collision with root package name */
        public final SoftwareKeyboardControllerCompat f3176b;

        public Impl20(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f3175a = window;
            this.f3176b = softwareKeyboardControllerCompat;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final int a() {
            Object tag = this.f3175a.getDecorView().getTag(356039078);
            if (tag != null) {
                return ((Integer) tag).intValue();
            }
            return 1;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final void b(int i2) {
            for (int i3 = 1; i3 <= 512; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    if (i3 == 1) {
                        h(4);
                    } else if (i3 == 2) {
                        h(2);
                    } else if (i3 == 8) {
                        this.f3176b.f3067a.a();
                    }
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final void f(int i2) {
            this.f3175a.getDecorView().setTag(356039078, Integer.valueOf(i2));
            if (i2 == 0) {
                i(6144);
                return;
            }
            if (i2 == 1) {
                i(4096);
                h(2048);
            } else {
                if (i2 != 2) {
                    return;
                }
                i(2048);
                h(4096);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final void g(int i2) {
            for (int i3 = 1; i3 <= 512; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    if (i3 == 1) {
                        i(4);
                        this.f3175a.clearFlags(1024);
                    } else if (i3 == 2) {
                        i(2);
                    } else if (i3 == 8) {
                        this.f3176b.f3067a.b();
                    }
                }
            }
        }

        public final void h(int i2) {
            View decorView = this.f3175a.getDecorView();
            decorView.setSystemUiVisibility(i2 | decorView.getSystemUiVisibility());
        }

        public final void i(int i2) {
            View decorView = this.f3175a.getDecorView();
            decorView.setSystemUiVisibility((~i2) & decorView.getSystemUiVisibility());
        }
    }

    @RequiresApi
    public static class Impl23 extends Impl20 {
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final boolean c() {
            return (this.f3175a.getDecorView().getSystemUiVisibility() & KEYRecord.Flags.FLAG2) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final void e(boolean z) {
            if (!z) {
                i(KEYRecord.Flags.FLAG2);
                return;
            }
            Window window = this.f3175a;
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            h(KEYRecord.Flags.FLAG2);
        }
    }

    @RequiresApi
    public static class Impl26 extends Impl23 {
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final void d(boolean z) {
            if (!z) {
                i(16);
                return;
            }
            Window window = this.f3175a;
            window.clearFlags(134217728);
            window.addFlags(Integer.MIN_VALUE);
            h(16);
        }
    }

    @RequiresApi
    public static class Impl31 extends Impl30 {
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl30, androidx.core.view.WindowInsetsControllerCompat.Impl
        public final int a() {
            return this.f3177a.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl30, androidx.core.view.WindowInsetsControllerCompat.Impl
        public final void f(int i2) {
            this.f3177a.setSystemBarsBehavior(i2);
        }
    }

    @RequiresApi
    public static class Impl35 extends Impl31 {
        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl30, androidx.core.view.WindowInsetsControllerCompat.Impl
        public final boolean c() {
            return (this.f3177a.getSystemBarsAppearance() & 8) != 0;
        }
    }

    public interface OnControllableInsetsChangedListener {
    }

    public WindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f3174a = new Impl35(windowInsetsController, new SoftwareKeyboardControllerCompat(windowInsetsController));
        } else {
            this.f3174a = new Impl30(windowInsetsController, new SoftwareKeyboardControllerCompat(windowInsetsController));
        }
    }

    public static WindowInsetsControllerCompat h(WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public final int a() {
        return this.f3174a.a();
    }

    public final void b(int i2) {
        this.f3174a.b(i2);
    }

    public final boolean c() {
        return this.f3174a.c();
    }

    public final void d(boolean z) {
        this.f3174a.d(z);
    }

    public final void e(boolean z) {
        this.f3174a.e(z);
    }

    public final void f(int i2) {
        this.f3174a.f(i2);
    }

    public final void g(int i2) {
        this.f3174a.g(i2);
    }

    @RequiresApi
    public static class Impl30 extends Impl {

        /* renamed from: a, reason: collision with root package name */
        public final WindowInsetsController f3177a;

        /* renamed from: b, reason: collision with root package name */
        public final SoftwareKeyboardControllerCompat f3178b;

        /* renamed from: c, reason: collision with root package name */
        public final Window f3179c;

        /* renamed from: androidx.core.view.WindowInsetsControllerCompat$Impl30$1, reason: invalid class name */
        class AnonymousClass1 implements WindowInsetsAnimationControlListener {
            public final void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
                throw null;
            }

            public final void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
                throw null;
            }

            public final void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i2) {
                throw null;
            }
        }

        public Impl30(WindowInsetsController windowInsetsController, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            new SimpleArrayMap();
            this.f3177a = windowInsetsController;
            this.f3178b = softwareKeyboardControllerCompat;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public int a() {
            Window window = this.f3179c;
            if (window == null) {
                return this.f3177a.getSystemBarsBehavior();
            }
            Object tag = window.getDecorView().getTag(356039078);
            if (tag != null) {
                return ((Integer) tag).intValue();
            }
            return 1;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final void b(int i2) {
            if ((i2 & 8) != 0) {
                this.f3178b.f3067a.a();
            }
            this.f3177a.hide(i2 & (-9));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean c() {
            this.f3177a.setSystemBarsAppearance(0, 0);
            return (this.f3177a.getSystemBarsAppearance() & 8) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final void d(boolean z) {
            Window window = this.f3179c;
            if (z) {
                if (window != null) {
                    h(16);
                }
                this.f3177a.setSystemBarsAppearance(16, 16);
            } else {
                if (window != null) {
                    i(16);
                }
                this.f3177a.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final void e(boolean z) {
            Window window = this.f3179c;
            if (z) {
                if (window != null) {
                    h(KEYRecord.Flags.FLAG2);
                }
                this.f3177a.setSystemBarsAppearance(8, 8);
            } else {
                if (window != null) {
                    i(KEYRecord.Flags.FLAG2);
                }
                this.f3177a.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void f(int i2) {
            Window window = this.f3179c;
            if (window == null) {
                this.f3177a.setSystemBarsBehavior(i2);
                return;
            }
            window.getDecorView().setTag(356039078, Integer.valueOf(i2));
            if (i2 == 0) {
                i(6144);
                return;
            }
            if (i2 == 1) {
                i(4096);
                h(2048);
            } else {
                if (i2 != 2) {
                    return;
                }
                i(2048);
                h(4096);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public final void g(int i2) {
            if ((i2 & 8) != 0) {
                this.f3178b.f3067a.b();
            }
            this.f3177a.show(i2 & (-9));
        }

        public final void h(int i2) {
            View decorView = this.f3179c.getDecorView();
            decorView.setSystemUiVisibility(i2 | decorView.getSystemUiVisibility());
        }

        public final void i(int i2) {
            View decorView = this.f3179c.getDecorView();
            decorView.setSystemUiVisibility((~i2) & decorView.getSystemUiVisibility());
        }

        public Impl30(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this(window.getInsetsController(), softwareKeyboardControllerCompat);
            this.f3179c = window;
        }
    }

    public WindowInsetsControllerCompat(Window window, View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 35) {
            this.f3174a = new Impl35(window, softwareKeyboardControllerCompat);
            return;
        }
        if (i2 >= 30) {
            this.f3174a = new Impl30(window, softwareKeyboardControllerCompat);
        } else if (i2 >= 26) {
            this.f3174a = new Impl26(window, softwareKeyboardControllerCompat);
        } else {
            this.f3174a = new Impl23(window, softwareKeyboardControllerCompat);
        }
    }
}
