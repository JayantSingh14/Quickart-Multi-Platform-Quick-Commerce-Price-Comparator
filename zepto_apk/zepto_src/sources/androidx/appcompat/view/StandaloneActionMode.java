package androidx.appcompat.view;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

@RestrictTo
/* loaded from: classes3.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {

    /* renamed from: c, reason: collision with root package name */
    public final Context f475c;

    /* renamed from: d, reason: collision with root package name */
    public final ActionBarContextView f476d;

    /* renamed from: e, reason: collision with root package name */
    public final ActionMode.Callback f477e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f478f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f479g;

    /* renamed from: h, reason: collision with root package name */
    public final MenuBuilder f480h;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback) {
        this.f475c = context;
        this.f476d = actionBarContextView;
        this.f477e = callback;
        MenuBuilder menuBuilder = new MenuBuilder(actionBarContextView.getContext());
        menuBuilder.f614l = 1;
        this.f480h = menuBuilder;
        menuBuilder.f607e = this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f477e.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final void b(MenuBuilder menuBuilder) {
        i();
        this.f476d.i();
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void c() {
        if (this.f479g) {
            return;
        }
        this.f479g = true;
        this.f477e.a(this);
    }

    @Override // androidx.appcompat.view.ActionMode
    public final View d() {
        WeakReference weakReference = this.f478f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.ActionMode
    public final MenuBuilder e() {
        return this.f480h;
    }

    @Override // androidx.appcompat.view.ActionMode
    public final MenuInflater f() {
        return new SupportMenuInflater(this.f476d.getContext());
    }

    @Override // androidx.appcompat.view.ActionMode
    public final CharSequence g() {
        return this.f476d.getSubtitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public final CharSequence h() {
        return this.f476d.getTitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void i() {
        this.f477e.d(this, this.f480h);
    }

    @Override // androidx.appcompat.view.ActionMode
    public final boolean j() {
        return this.f476d.s;
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void k(View view) {
        this.f476d.setCustomView(view);
        this.f478f = view != null ? new WeakReference(view) : null;
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void l(int i2) {
        m(this.f475c.getString(i2));
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void m(CharSequence charSequence) {
        this.f476d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void n(int i2) {
        o(this.f475c.getString(i2));
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void o(CharSequence charSequence) {
        this.f476d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    public final void p(boolean z) {
        this.f468b = z;
        this.f476d.setTitleOptional(z);
    }
}
