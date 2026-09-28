package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes3.dex */
public interface MenuPresenter {

    public interface Callback {
        void c(MenuBuilder menuBuilder, boolean z);

        boolean d(MenuBuilder menuBuilder);
    }

    void c(MenuBuilder menuBuilder, boolean z);

    void d(Callback callback);

    boolean e(MenuItemImpl menuItemImpl);

    void f(Parcelable parcelable);

    boolean g(SubMenuBuilder subMenuBuilder);

    int getId();

    Parcelable h();

    boolean i(MenuItemImpl menuItemImpl);

    void j(boolean z);

    boolean k();

    void l(Context context, MenuBuilder menuBuilder);
}
