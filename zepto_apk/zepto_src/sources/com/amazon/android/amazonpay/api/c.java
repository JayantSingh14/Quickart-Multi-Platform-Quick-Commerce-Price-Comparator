package com.amazon.android.amazonpay.api;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import in.juspay.hypersdk.core.PrefetchServices;
import in.juspay.hypersdk.core.SdkTracker;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14846a;

    public /* synthetic */ c(int i2) {
        this.f14846a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f14846a) {
            case 0:
                AmazonPay.f14840a.shutdown();
                break;
            case 1:
                int i2 = AlarmManagerSchedulerBroadcastReceiver.f20856a;
                break;
            case 2:
                PrefetchServices.lambda$preFetch$0();
                break;
            default:
                SdkTracker.lambda$new$0();
                break;
        }
    }
}
