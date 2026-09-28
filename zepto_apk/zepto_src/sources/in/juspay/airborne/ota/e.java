package in.juspay.airborne.ota;

import in.juspay.airborne.ota.ReleaseConfig;
import in.juspay.airborne.ota.UpdateTask;
import in.juspay.airborne.services.TempWriter;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class e implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48467a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReleaseConfig.Split f48468b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UpdateTask f48469c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TempWriter f48470d;

    public /* synthetic */ e(ReleaseConfig.Split split, UpdateTask updateTask, TempWriter tempWriter) {
        this.f48468b = split;
        this.f48469c = updateTask;
        this.f48470d = tempWriter;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f48467a) {
            case 0:
                return UpdateTask.ResourceUpdateTask.copyResource$lambda$19(this.f48469c, this.f48470d, this.f48468b);
            default:
                return UpdateTask.downloadPackageUpdate$lambda$14$lambda$13(this.f48468b, this.f48469c, this.f48470d);
        }
    }

    public /* synthetic */ e(UpdateTask updateTask, TempWriter tempWriter, ReleaseConfig.Split split) {
        this.f48469c = updateTask;
        this.f48470d = tempWriter;
        this.f48468b = split;
    }
}
