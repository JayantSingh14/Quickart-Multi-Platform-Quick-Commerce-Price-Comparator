package androidx.core.view;

import android.util.Log;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ShareActionProvider;

/* loaded from: classes3.dex */
public abstract class ActionProvider {

    /* renamed from: a, reason: collision with root package name */
    public SubUiVisibilityListener f3016a;

    /* renamed from: b, reason: collision with root package name */
    public VisibilityListener f3017b;

    @RestrictTo
    public interface SubUiVisibilityListener {
    }

    public interface VisibilityListener {
    }

    public boolean a() {
        return this instanceof ShareActionProvider;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItemImpl menuItemImpl) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public void h(VisibilityListener visibilityListener) {
        if (this.f3017b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f3017b = visibilityListener;
    }

    public void f(SubMenuBuilder subMenuBuilder) {
    }
}
