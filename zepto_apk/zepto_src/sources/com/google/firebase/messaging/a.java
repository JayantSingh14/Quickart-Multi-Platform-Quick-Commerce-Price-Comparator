package com.google.firebase.messaging;

import com.zeptoconsumerapp.screenShotDetector.ScreenshotDetectionModule;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44813a;

    public /* synthetic */ a(int i2) {
        this.f44813a = i2;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f44813a) {
            case 0:
                runnable.run();
                break;
            default:
                ScreenshotDetectionModule.registerScreenshotDetection$lambda$3$lambda$2$lambda$1(runnable);
                break;
        }
    }
}
