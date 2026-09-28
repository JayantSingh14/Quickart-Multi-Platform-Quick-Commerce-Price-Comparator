package in.juspay.airborne.ota;

import in.juspay.airborne.ota.UpdateTask;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class f implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48471a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48472b;

    public /* synthetic */ f(Object obj, int i2) {
        this.f48471a = i2;
        this.f48472b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f48471a) {
            case 0:
                return UpdateTask.ResourceUpdateTask.completeResourceDownload$lambda$13((UpdateTask.ResourceUpdateTask) this.f48472b);
            default:
                return UpdateTask.run$lambda$1((UpdateTask) this.f48472b);
        }
    }
}
