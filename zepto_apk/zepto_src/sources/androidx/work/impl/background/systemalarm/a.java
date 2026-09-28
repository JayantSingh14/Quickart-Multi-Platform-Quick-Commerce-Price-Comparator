package androidx.work.impl.background.systemalarm;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12776a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f12777b;

    public /* synthetic */ a(DelayMetCommandHandler delayMetCommandHandler, int i2) {
        this.f12776a = i2;
        this.f12777b = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12776a) {
            case 0:
                DelayMetCommandHandler.b(this.f12777b);
                break;
            default:
                DelayMetCommandHandler.c(this.f12777b);
                break;
        }
    }
}
