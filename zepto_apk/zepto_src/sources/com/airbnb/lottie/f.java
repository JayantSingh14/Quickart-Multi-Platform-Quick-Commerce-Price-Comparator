package com.airbnb.lottie;

import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.zip.ZipInputStream;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14406a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14407b;

    public /* synthetic */ f(Object obj, int i2) {
        this.f14406a = i2;
        this.f14407b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Object obj = this.f14407b;
        switch (this.f14406a) {
            case 0:
                HashMap map = LottieCompositionFactory.f14148a;
                Utils.b((InputStream) obj);
                break;
            case 1:
                HashMap map2 = LottieCompositionFactory.f14148a;
                Utils.b((ZipInputStream) obj);
                break;
            default:
                ExecutorService executorService = LottieTask.f14193e;
                ((LottieTask) obj).d();
                break;
        }
    }
}
