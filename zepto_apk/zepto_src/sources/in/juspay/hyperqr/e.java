package in.juspay.hyperqr;

import android.content.Intent;
import in.juspay.hyper.core.ResultAwaitingDuiHook;
import java.io.File;

/* loaded from: classes4.dex */
public final /* synthetic */ class e implements ResultAwaitingDuiHook {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48495a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QrBridge f48496b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f48497c;

    public /* synthetic */ e(QrBridge qrBridge, String str) {
        this.f48496b = qrBridge;
        this.f48497c = str;
    }

    @Override // in.juspay.hyper.core.ResultAwaitingDuiHook
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        switch (this.f48495a) {
            case 0:
                return QrBridge.scanQRFromGallery$lambda$1(this.f48496b, (String) this.f48497c, i2, i3, intent);
            default:
                return QrBridge.shareImage$lambda$4((File) this.f48497c, this.f48496b, i2, i3, intent);
        }
    }

    public /* synthetic */ e(File file, QrBridge qrBridge) {
        this.f48497c = file;
        this.f48496b = qrBridge;
    }
}
