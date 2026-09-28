package in.juspay.hypersdk.core;

import android.view.MenuItem;
import android.widget.PopupMenu;

/* loaded from: classes4.dex */
public final /* synthetic */ class k implements PopupMenu.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48608a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f48609b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f48610c;

    public /* synthetic */ k(String str, int i2, Object obj) {
        this.f48608a = i2;
        this.f48610c = obj;
        this.f48609b = str;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (this.f48608a) {
            case 0:
                return ((AndroidInterface) this.f48610c).lambda$showPopup$16(this.f48609b, menuItem);
            default:
                return ((InflateView) this.f48610c).lambda$parseKeys$9(this.f48609b, menuItem);
        }
    }
}
