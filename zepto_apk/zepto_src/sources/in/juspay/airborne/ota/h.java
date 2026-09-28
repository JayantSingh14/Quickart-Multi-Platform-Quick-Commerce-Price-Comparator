package in.juspay.airborne.ota;

import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingModule;
import io.sentry.android.core.internal.util.CpuInfoUtils;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* loaded from: classes4.dex */
public final /* synthetic */ class h implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48474a;

    public /* synthetic */ h(int i2) {
        this.f48474a = i2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f48474a) {
            case 0:
                return Unit.f53572a;
            case 1:
                return ReactNativeFirebaseMessagingModule.lambda$isNotificationDelegationEnabled$2();
            default:
                return CpuInfoUtils.f52309b.a();
        }
    }
}
