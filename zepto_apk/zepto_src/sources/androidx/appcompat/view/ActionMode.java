package androidx.appcompat.view;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;

/* loaded from: classes3.dex */
public abstract class ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public Object f467a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f468b;

    public interface Callback {
        void a(ActionMode actionMode);

        boolean b(ActionMode actionMode, MenuBuilder menuBuilder);

        boolean c(ActionMode actionMode, MenuItem menuItem);

        boolean d(ActionMode actionMode, MenuBuilder menuBuilder);
    }

    public abstract void c();

    public abstract View d();

    public abstract MenuBuilder e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public abstract CharSequence h();

    public abstract void i();

    public boolean j() {
        return false;
    }

    public abstract void k(View view);

    public abstract void l(int i2);

    public abstract void m(CharSequence charSequence);

    public abstract void n(int i2);

    public abstract void o(CharSequence charSequence);

    public void p(boolean z) {
        this.f468b = z;
    }
}
