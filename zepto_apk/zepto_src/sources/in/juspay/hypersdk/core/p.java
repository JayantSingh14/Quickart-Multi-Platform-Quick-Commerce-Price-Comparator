package in.juspay.hypersdk.core;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import in.juspay.airborne.services.RemoteAssetService;

/* loaded from: classes4.dex */
public final /* synthetic */ class p implements RemoteAssetService.DownloadCallback, SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f48637a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48638b;

    public /* synthetic */ p(Object obj, String str) {
        this.f48638b = obj;
        this.f48637a = str;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void b() {
        ((InflateView) this.f48638b).lambda$parseKeys$5(this.f48637a);
    }

    @Override // in.juspay.airborne.services.RemoteAssetService.DownloadCallback
    public void onDownload(boolean z, String str, String str2) {
        ((DuiInterface) this.f48638b).lambda$fileDownloadCallback$10(this.f48637a, z, str, str2);
    }
}
