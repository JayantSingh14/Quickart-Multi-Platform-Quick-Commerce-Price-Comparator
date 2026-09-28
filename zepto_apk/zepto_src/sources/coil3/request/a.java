package coil3.request;

import kotlin.jvm.functions.Function1;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13875a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13876b;

    public /* synthetic */ a(int i2, int i3) {
        this.f13875a = i3;
        this.f13876b = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f13875a) {
            case 0:
                return ImageRequests_androidKt.fallback$lambda$2(this.f13876b, (ImageRequest) obj);
            case 1:
                return ImageRequests_androidKt.error$lambda$1(this.f13876b, (ImageRequest) obj);
            default:
                return ImageRequests_androidKt.placeholder$lambda$0(this.f13876b, (ImageRequest) obj);
        }
    }
}
