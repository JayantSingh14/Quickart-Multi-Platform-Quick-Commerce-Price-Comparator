package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f481a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionMode f482b;

    @RestrictTo
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f483a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f484b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f485c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final SimpleArrayMap f486d = new SimpleArrayMap();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f484b = context;
            this.f483a = callback;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final void a(ActionMode actionMode) {
            this.f483a.onDestroyActionMode(e(actionMode));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean b(ActionMode actionMode, MenuBuilder menuBuilder) {
            SupportActionModeWrapper supportActionModeWrapperE = e(actionMode);
            SimpleArrayMap simpleArrayMap = this.f486d;
            Menu menuWrapperICS = (Menu) simpleArrayMap.get(menuBuilder);
            if (menuWrapperICS == null) {
                menuWrapperICS = new MenuWrapperICS(this.f484b, menuBuilder);
                simpleArrayMap.put(menuBuilder, menuWrapperICS);
            }
            return this.f483a.onCreateActionMode(supportActionModeWrapperE, menuWrapperICS);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean c(ActionMode actionMode, MenuItem menuItem) {
            return this.f483a.onActionItemClicked(e(actionMode), new MenuItemWrapperICS(this.f484b, (SupportMenuItem) menuItem));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean d(ActionMode actionMode, MenuBuilder menuBuilder) {
            SupportActionModeWrapper supportActionModeWrapperE = e(actionMode);
            SimpleArrayMap simpleArrayMap = this.f486d;
            Menu menuWrapperICS = (Menu) simpleArrayMap.get(menuBuilder);
            if (menuWrapperICS == null) {
                menuWrapperICS = new MenuWrapperICS(this.f484b, menuBuilder);
                simpleArrayMap.put(menuBuilder, menuWrapperICS);
            }
            return this.f483a.onPrepareActionMode(supportActionModeWrapperE, menuWrapperICS);
        }

        public final SupportActionModeWrapper e(ActionMode actionMode) {
            ArrayList arrayList = this.f485c;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) arrayList.get(i2);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f482b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f484b, actionMode);
            arrayList.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f481a = context;
        this.f482b = actionMode;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f482b.c();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f482b.d();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new MenuWrapperICS(this.f481a, this.f482b.e());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f482b.f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f482b.g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f482b.f467a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f482b.h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f482b.f468b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f482b.i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f482b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f482b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f482b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f482b.f467a = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f482b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z) {
        this.f482b.p(z);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i2) {
        this.f482b.l(i2);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i2) {
        this.f482b.n(i2);
    }
}
