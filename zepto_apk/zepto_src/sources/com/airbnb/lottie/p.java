package com.airbnb.lottie;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.model.layer.CompositionLayer;
import java.util.concurrent.Semaphore;

/* loaded from: classes3.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14678a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14679b;

    public /* synthetic */ p(LottieDrawable lottieDrawable, int i2) {
        this.f14678a = i2;
        this.f14679b = lottieDrawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LottieDrawable lottieDrawable = this.f14679b;
        switch (this.f14678a) {
            case 0:
                boolean z = LottieDrawable.C0;
                Drawable.Callback callback = lottieDrawable.getCallback();
                if (callback != null) {
                    callback.invalidateDrawable(lottieDrawable);
                    return;
                }
                return;
            default:
                Semaphore semaphore = lottieDrawable.X;
                CompositionLayer compositionLayer = lottieDrawable.s;
                if (compositionLayer == null) {
                    return;
                }
                try {
                    semaphore.acquire();
                    compositionLayer.t(lottieDrawable.f14153b.c());
                    if (LottieDrawable.C0 && lottieDrawable.M) {
                        if (lottieDrawable.Y == null) {
                            lottieDrawable.Y = new Handler(Looper.getMainLooper());
                            lottieDrawable.Z = new p(lottieDrawable, 0);
                        }
                        lottieDrawable.Y.post(lottieDrawable.Z);
                    }
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    semaphore.release();
                    throw th;
                }
                semaphore.release();
                return;
        }
    }
}
