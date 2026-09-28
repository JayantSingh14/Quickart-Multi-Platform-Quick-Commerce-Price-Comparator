package in.juspay.airborne.ota;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48451a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ApplicationManager f48452b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48453c;

    public /* synthetic */ a(ApplicationManager applicationManager, String str) {
        this.f48452b = applicationManager;
        this.f48453c = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f48451a) {
            case 0:
                return ApplicationManager.readSplits$lambda$11$lambda$10(this.f48453c, this.f48452b);
            default:
                return ApplicationManager.readFileAsync$lambda$19(this.f48452b, this.f48453c);
        }
    }

    public /* synthetic */ a(String str, ApplicationManager applicationManager) {
        this.f48453c = str;
        this.f48452b = applicationManager;
    }
}
