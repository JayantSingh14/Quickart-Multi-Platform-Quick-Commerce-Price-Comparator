package coil3;

import coil3.ImageLoader;
import coil3.request.ImageRequest;
import kotlin.jvm.functions.Function1;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13870a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Image f13871b;

    public /* synthetic */ e(Image image, int i2) {
        this.f13870a = i2;
        this.f13871b = image;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f13870a) {
            case 0:
                return ImageLoader.Builder.error$lambda$15(this.f13871b, (ImageRequest) obj);
            case 1:
                return ImageLoader.Builder.fallback$lambda$17(this.f13871b, (ImageRequest) obj);
            case 2:
                return ImageLoader.Builder.placeholder$lambda$13(this.f13871b, (ImageRequest) obj);
            case 3:
                return ImageRequest.Builder.fallback$lambda$29(this.f13871b, (ImageRequest) obj);
            default:
                return ImageRequest.Builder.error$lambda$27(this.f13871b, (ImageRequest) obj);
        }
    }
}
