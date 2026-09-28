package in.juspay.hypersdk.mystique;

import android.widget.AbsListView;
import in.juspay.hypersdk.core.DuiCallback;

/* loaded from: classes4.dex */
public class OnScroll implements AbsListView.OnScrollListener {
    private final DuiCallback duiCallback;
    private String scrollCallback;
    private String scrollChangeCallback;

    public OnScroll(DuiCallback duiCallback) {
        this.duiCallback = duiCallback;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.duiCallback.addJsToWebView("window.callUICallback('" + this.scrollCallback + "','" + i2 + "," + i3 + "," + i4 + "');");
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        this.duiCallback.addJsToWebView("window.callUICallback('" + this.scrollChangeCallback + "'," + i2 + ");");
    }

    public void setScrollCallback(String str) {
        this.scrollCallback = str;
    }

    public void setScrollChangeCallback(String str) {
        this.scrollChangeCallback = str;
    }
}
