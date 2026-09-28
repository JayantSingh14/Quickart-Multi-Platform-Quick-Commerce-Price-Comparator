package io.invertase.firebase.messaging;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f49255a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Boolean f49256b;

    public /* synthetic */ a(int i2, Boolean bool) {
        this.f49255a = i2;
        this.f49256b = bool;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f49255a) {
            case 0:
                return ReactNativeFirebaseMessagingModule.lambda$setNotificationDelegationEnabled$4(this.f49256b);
            case 1:
                return ReactNativeFirebaseMessagingModule.lambda$setAutoInitEnabled$0(this.f49256b);
            default:
                return ReactNativeFirebaseMessagingModule.lambda$setDeliveryMetricsExportToBigQuery$16(this.f49256b);
        }
    }
}
