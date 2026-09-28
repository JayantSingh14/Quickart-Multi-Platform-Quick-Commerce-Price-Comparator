package androidx.appcompat.app;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes3.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: androidx.appcompat.app.ActionBarDrawerToggle$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            throw null;
        }
    }

    public interface Delegate {
    }

    /* loaded from: classes.dex */
    public interface DelegateProvider {
    }

    public static class FrameworkActionBarDelegate implements Delegate {
    }

    public static class ToolbarCompatDelegate implements Delegate {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void a(View view) {
        throw null;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void b(View view) {
        throw null;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void c(int i2) {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void d(View view, float f2) {
        throw null;
    }
}
