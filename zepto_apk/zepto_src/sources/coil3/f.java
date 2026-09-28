package coil3;

import android.content.Context;
import coil3.SingletonImageLoader;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements SingletonImageLoader.Factory {
    @Override // coil3.SingletonImageLoader.Factory
    public final ImageLoader newImageLoader(Context context) {
        return SingletonImageLoaderKt.DefaultSingletonImageLoaderFactory$lambda$1(context);
    }
}
