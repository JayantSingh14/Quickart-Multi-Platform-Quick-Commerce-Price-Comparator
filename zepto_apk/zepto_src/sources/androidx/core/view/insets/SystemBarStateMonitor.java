package androidx.core.view.insets;

import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.insets.SystemBarStateMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
class SystemBarStateMonitor {

    /* renamed from: a, reason: collision with root package name */
    public final View f3237a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3238b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public Insets f3239c;

    /* renamed from: d, reason: collision with root package name */
    public Insets f3240d;

    /* renamed from: e, reason: collision with root package name */
    public int f3241e;

    public interface Callback {
        void a();

        void b(Insets insets, Insets insets2);

        void c();

        void d();

        void e(int i2);
    }

    public SystemBarStateMonitor(final ViewGroup viewGroup) {
        Insets insets = Insets.f2807e;
        this.f3239c = insets;
        this.f3240d = insets;
        Drawable background = viewGroup.getBackground();
        this.f3241e = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        View view = new View(viewGroup.getContext()) { // from class: androidx.core.view.insets.SystemBarStateMonitor.1
            @Override // android.view.View
            public final void onConfigurationChanged(Configuration configuration) {
                Drawable background2 = viewGroup.getBackground();
                int color = background2 instanceof ColorDrawable ? ((ColorDrawable) background2).getColor() : 0;
                SystemBarStateMonitor systemBarStateMonitor = SystemBarStateMonitor.this;
                if (systemBarStateMonitor.f3241e != color) {
                    systemBarStateMonitor.f3241e = color;
                    for (int size = systemBarStateMonitor.f3238b.size() - 1; size >= 0; size--) {
                        ((Callback) systemBarStateMonitor.f3238b.get(size)).e(color);
                    }
                }
            }
        };
        this.f3237a = view;
        view.setWillNotDraw(true);
        ViewCompat.H(view, new OnApplyWindowInsetsListener() { // from class: androidx.core.view.insets.a
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat b(View view2, WindowInsetsCompat windowInsetsCompat) {
                SystemBarStateMonitor systemBarStateMonitor = this.f3246a;
                systemBarStateMonitor.getClass();
                Insets insetsB = Insets.b(windowInsetsCompat.d(519), windowInsetsCompat.d(64));
                Insets insetsB2 = Insets.b(windowInsetsCompat.e(519), windowInsetsCompat.e(64));
                if (!insetsB.equals(systemBarStateMonitor.f3239c) || !insetsB2.equals(systemBarStateMonitor.f3240d)) {
                    systemBarStateMonitor.f3239c = insetsB;
                    systemBarStateMonitor.f3240d = insetsB2;
                    ArrayList arrayList = systemBarStateMonitor.f3238b;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ((SystemBarStateMonitor.Callback) arrayList.get(size)).b(insetsB, insetsB2);
                    }
                }
                return windowInsetsCompat;
            }
        });
        ViewCompat.O(view, new WindowInsetsAnimationCompat.Callback() { // from class: androidx.core.view.insets.SystemBarStateMonitor.2

            /* renamed from: a, reason: collision with root package name */
            public final HashMap f3244a = new HashMap();

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public final void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
                if ((windowInsetsAnimationCompat.d() & 519) != 0) {
                    this.f3244a.remove(windowInsetsAnimationCompat);
                    SystemBarStateMonitor systemBarStateMonitor = SystemBarStateMonitor.this;
                    for (int size = systemBarStateMonitor.f3238b.size() - 1; size >= 0; size--) {
                        ((Callback) systemBarStateMonitor.f3238b.get(size)).a();
                    }
                }
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public final void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
                if ((windowInsetsAnimationCompat.d() & 519) != 0) {
                    SystemBarStateMonitor systemBarStateMonitor = SystemBarStateMonitor.this;
                    for (int size = systemBarStateMonitor.f3238b.size() - 1; size >= 0; size--) {
                        ((Callback) systemBarStateMonitor.f3238b.get(size)).c();
                    }
                }
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public final WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
                RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) list.get(size);
                    Integer num = (Integer) this.f3244a.get(windowInsetsAnimationCompat);
                    if (num != null) {
                        int iIntValue = num.intValue();
                        float fA = windowInsetsAnimationCompat.a();
                        if ((iIntValue & 1) != 0) {
                            rectF.left = fA;
                        }
                        if ((iIntValue & 2) != 0) {
                            rectF.top = fA;
                        }
                        if ((iIntValue & 4) != 0) {
                            rectF.right = fA;
                        }
                        if ((iIntValue & 8) != 0) {
                            rectF.bottom = fA;
                        }
                    }
                }
                SystemBarStateMonitor systemBarStateMonitor = SystemBarStateMonitor.this;
                systemBarStateMonitor.getClass();
                Insets.b(windowInsetsCompat.d(519), windowInsetsCompat.d(64));
                ArrayList arrayList = systemBarStateMonitor.f3238b;
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    ((Callback) arrayList.get(size2)).d();
                }
                return windowInsetsCompat;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public final WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
                if ((windowInsetsAnimationCompat.d() & 519) != 0) {
                    Insets insets2 = boundsCompat.f3122b;
                    int i2 = insets2.f2808a;
                    Insets insets3 = boundsCompat.f3121a;
                    int i3 = i2 != insets3.f2808a ? 1 : 0;
                    if (insets2.f2809b != insets3.f2809b) {
                        i3 |= 2;
                    }
                    if (insets2.f2810c != insets3.f2810c) {
                        i3 |= 4;
                    }
                    if (insets2.f2811d != insets3.f2811d) {
                        i3 |= 8;
                    }
                    this.f3244a.put(windowInsetsAnimationCompat, Integer.valueOf(i3));
                }
                return boundsCompat;
            }
        });
        viewGroup.addView(view, 0);
    }
}
