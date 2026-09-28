package in.juspay.hypersdk.analytics;

import java.io.IOException;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48529a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LogSessioniserExp f48530b;

    public /* synthetic */ h(LogSessioniserExp logSessioniserExp, int i2) {
        this.f48529a = i2;
        this.f48530b = logSessioniserExp;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException, IOException {
        switch (this.f48529a) {
            case 0:
                LogSessioniserExp.access$200(this.f48530b);
                break;
            case 1:
                this.f48530b.updatePushFile();
                break;
            case 2:
                this.f48530b.lambda$startPushing$2();
                break;
            default:
                this.f48530b.lambda$stopLogSessioniserOnTerminate$0();
                break;
        }
    }
}
