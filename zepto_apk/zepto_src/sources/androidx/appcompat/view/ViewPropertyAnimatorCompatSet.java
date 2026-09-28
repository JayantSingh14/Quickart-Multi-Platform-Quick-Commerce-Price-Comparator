package androidx.appcompat.view;

import android.view.View;
import android.view.animation.BaseInterpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo
/* loaded from: classes3.dex */
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: c, reason: collision with root package name */
    public BaseInterpolator f511c;

    /* renamed from: d, reason: collision with root package name */
    public ViewPropertyAnimatorListenerAdapter f512d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f513e;

    /* renamed from: b, reason: collision with root package name */
    public long f510b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final ViewPropertyAnimatorListenerAdapter f514f = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.view.ViewPropertyAnimatorCompatSet.1

        /* renamed from: c, reason: collision with root package name */
        public boolean f515c = false;

        /* renamed from: d, reason: collision with root package name */
        public int f516d = 0;

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd(View view) {
            int i2 = this.f516d + 1;
            this.f516d = i2;
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = ViewPropertyAnimatorCompatSet.this;
            if (i2 == viewPropertyAnimatorCompatSet.f509a.size()) {
                ViewPropertyAnimatorListenerAdapter viewPropertyAnimatorListenerAdapter = viewPropertyAnimatorCompatSet.f512d;
                if (viewPropertyAnimatorListenerAdapter != null) {
                    viewPropertyAnimatorListenerAdapter.onAnimationEnd(null);
                }
                this.f516d = 0;
                this.f515c = false;
                viewPropertyAnimatorCompatSet.f513e = false;
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationStart(View view) {
            if (this.f515c) {
                return;
            }
            this.f515c = true;
            ViewPropertyAnimatorListenerAdapter viewPropertyAnimatorListenerAdapter = ViewPropertyAnimatorCompatSet.this.f512d;
            if (viewPropertyAnimatorListenerAdapter != null) {
                viewPropertyAnimatorListenerAdapter.onAnimationStart(null);
            }
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f509a = new ArrayList();

    public final void a() {
        if (this.f513e) {
            Iterator it = this.f509a.iterator();
            while (it.hasNext()) {
                ((ViewPropertyAnimatorCompat) it.next()).b();
            }
            this.f513e = false;
        }
    }

    public final void b() {
        View view;
        if (this.f513e) {
            return;
        }
        Iterator it = this.f509a.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) it.next();
            long j2 = this.f510b;
            if (j2 >= 0) {
                viewPropertyAnimatorCompat.c(j2);
            }
            BaseInterpolator baseInterpolator = this.f511c;
            if (baseInterpolator != null && (view = (View) viewPropertyAnimatorCompat.f3117a.get()) != null) {
                view.animate().setInterpolator(baseInterpolator);
            }
            if (this.f512d != null) {
                viewPropertyAnimatorCompat.d(this.f514f);
            }
            View view2 = (View) viewPropertyAnimatorCompat.f3117a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f513e = true;
    }
}
