package in.juspay.hypersdk.analytics;

import java.io.IOException;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48514a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LogManager f48515b;

    public /* synthetic */ a(LogManager logManager, int i2) {
        this.f48514a = i2;
        this.f48515b = logManager;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException, IOException {
        switch (this.f48514a) {
            case 0:
                LogManager.initialize$lambda$0(this.f48515b);
                break;
            case 1:
                LogManager.initialize$lambda$1(this.f48515b);
                break;
            case 2:
                LogManager.initialize$lambda$2(this.f48515b);
                break;
            case 3:
                LogManager.stopLogPusherOnTerminate$lambda$5(this.f48515b);
                break;
            default:
                LogManager.startLogPusherTimer$lambda$4(this.f48515b);
                break;
        }
    }
}
