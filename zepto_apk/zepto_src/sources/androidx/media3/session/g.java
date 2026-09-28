package androidx.media3.session;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10368a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaControllerHolder f10369b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MediaController f10370c;

    public /* synthetic */ g(MediaControllerHolder mediaControllerHolder, MediaController mediaController, int i2) {
        this.f10368a = i2;
        this.f10369b = mediaControllerHolder;
        this.f10370c = mediaController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaController mediaController = this.f10370c;
        MediaControllerHolder mediaControllerHolder = this.f10369b;
        switch (this.f10368a) {
            case 0:
                mediaControllerHolder.f9968i = mediaController;
                if (mediaControllerHolder.f9969j) {
                    mediaControllerHolder.n(mediaController);
                }
                mediaControllerHolder.q(new g(mediaControllerHolder, mediaController, 1), new h(mediaControllerHolder, 0));
                break;
            default:
                int i2 = MediaControllerHolder.f9966k;
                if (mediaControllerHolder.isCancelled()) {
                    mediaController.release();
                    break;
                }
                break;
        }
    }
}
