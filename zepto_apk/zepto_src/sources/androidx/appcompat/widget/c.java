package androidx.appcompat.widget;

import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1269a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f1270b;

    public /* synthetic */ c(Toolbar toolbar, int i2) {
        this.f1269a = i2;
        this.f1270b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1269a) {
            case 0:
                Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.f1270b.M;
                MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.f1205b;
                if (menuItemImpl != null) {
                    menuItemImpl.collapseActionView();
                    break;
                }
                break;
            default:
                this.f1270b.o();
                break;
        }
    }
}
