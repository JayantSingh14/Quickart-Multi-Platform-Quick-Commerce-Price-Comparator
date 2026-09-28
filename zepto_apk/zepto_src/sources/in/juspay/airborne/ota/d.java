package in.juspay.airborne.ota;

import in.juspay.airborne.LazyDownloadCallback;
import in.juspay.airborne.ota.ReleaseConfig;
import in.juspay.airborne.ota.UpdateTask;
import in.juspay.airborne.services.TempWriter;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48463a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48464b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f48465c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f48466d;

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, int i2) {
        this.f48463a = i2;
        this.f48464b = obj;
        this.f48465c = obj2;
        this.f48466d = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f48463a) {
            case 0:
                return UpdateTask.ResourceUpdateTask.start$lambda$2$lambda$1((UpdateTask.ResourceUpdateTask) this.f48464b, (ReleaseConfig.Split) this.f48465c, (UpdateTask) this.f48466d);
            case 1:
                return ApplicationManager.loadApplication$lambda$1((ApplicationManager) this.f48464b, (String) this.f48465c, (LazyDownloadCallback) this.f48466d);
            default:
                return UpdateTask.copyFilesAsync$lambda$28$lambda$25$lambda$24((TempWriter) this.f48464b, (String) this.f48465c, (String) this.f48466d);
        }
    }
}
