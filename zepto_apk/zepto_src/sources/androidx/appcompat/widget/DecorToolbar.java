package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewPropertyAnimatorCompat;

@RestrictTo
/* loaded from: classes3.dex */
public interface DecorToolbar {
    boolean a();

    void b(MenuBuilder menuBuilder, MenuPresenter.Callback callback);

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    void f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    boolean h();

    void i(int i2);

    int j();

    ViewPropertyAnimatorCompat k(int i2, long j2);

    void l();

    void m(boolean z);

    void n();

    void o();

    void p(int i2);

    int q();

    void r();

    void s(Drawable drawable);

    void setIcon(int i2);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setVisibility(int i2);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
