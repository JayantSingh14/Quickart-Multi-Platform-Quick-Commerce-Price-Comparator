package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSourceEventListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7899a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f7900b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7901c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f7902d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f7903e;

    public /* synthetic */ f(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i2) {
        this.f7899a = i2;
        this.f7900b = eventDispatcher;
        this.f7901c = mediaSourceEventListener;
        this.f7902d = loadEventInfo;
        this.f7903e = mediaLoadData;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.media3.exoplayer.source.MediaSourceEventListener, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.media3.exoplayer.source.MediaSourceEventListener, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.media3.exoplayer.source.MediaSourceEventListener, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7899a) {
            case 0:
                MediaSourceEventListener.EventDispatcher eventDispatcher = this.f7900b;
                int i2 = eventDispatcher.f7614a;
                this.f7901c.B(i2, eventDispatcher.f7615b, this.f7902d, this.f7903e);
                break;
            case 1:
                MediaSourceEventListener.EventDispatcher eventDispatcher2 = this.f7900b;
                int i3 = eventDispatcher2.f7614a;
                this.f7901c.Q(i3, eventDispatcher2.f7615b, this.f7902d, this.f7903e);
                break;
            default:
                MediaSourceEventListener.EventDispatcher eventDispatcher3 = this.f7900b;
                int i4 = eventDispatcher3.f7614a;
                this.f7901c.M(i4, eventDispatcher3.f7615b, this.f7902d, this.f7903e);
                break;
        }
    }
}
