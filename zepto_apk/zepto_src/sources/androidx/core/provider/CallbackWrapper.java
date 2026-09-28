package androidx.core.provider;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.RequestExecutor;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
class CallbackWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final TypefaceCompat.ResourcesCallbackAdapter f2888a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f2889b;

    public CallbackWrapper(TypefaceCompat.ResourcesCallbackAdapter resourcesCallbackAdapter, Executor executor) {
        this.f2888a = resourcesCallbackAdapter;
        this.f2889b = executor;
    }

    public final void a(FontRequestWorker.TypefaceResult typefaceResult) {
        final int i2 = typefaceResult.f2920b;
        Executor executor = this.f2889b;
        final TypefaceCompat.ResourcesCallbackAdapter resourcesCallbackAdapter = this.f2888a;
        if (i2 != 0) {
            ((RequestExecutor.HandlerExecutor) executor).execute(new Runnable() { // from class: androidx.core.provider.CallbackWrapper.2
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback fontCallback = resourcesCallbackAdapter.f2824a;
                    if (fontCallback != null) {
                        fontCallback.b(i2);
                    }
                }
            });
        } else {
            final Typeface typeface = typefaceResult.f2919a;
            ((RequestExecutor.HandlerExecutor) executor).execute(new Runnable() { // from class: androidx.core.provider.CallbackWrapper.1
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback fontCallback = resourcesCallbackAdapter.f2824a;
                    if (fontCallback != null) {
                        fontCallback.c(typeface);
                    }
                }
            });
        }
    }
}
