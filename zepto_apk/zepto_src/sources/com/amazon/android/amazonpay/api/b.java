package com.amazon.android.amazonpay.api;

import android.app.Activity;
import android.content.Context;
import com.amazon.android.apay.commonlibrary.commonlib.manager.AppConfigManager;
import com.unistyles.UnistylesModule;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14844a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f14845b;

    public /* synthetic */ b(Activity activity, int i2) {
        this.f14844a = i2;
        this.f14845b = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity = this.f14845b;
        switch (this.f14844a) {
            case 0:
                ExecutorService executorService = AmazonPay.f14840a;
                Intrinsics.checkNotNullParameter(activity, "$activity");
                AppConfigManager appConfigManager = new AppConfigManager();
                Context applicationContext = activity.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.getApplicationContext()");
                appConfigManager.createArcusConnection(applicationContext, AmazonPay.f14841b);
                break;
            default:
                UnistylesModule.enableEdgeToEdge$lambda$5$lambda$4(activity);
                break;
        }
    }
}
