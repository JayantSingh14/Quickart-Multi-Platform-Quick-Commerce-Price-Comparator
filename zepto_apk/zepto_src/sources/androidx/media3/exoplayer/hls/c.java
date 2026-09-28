package androidx.media3.exoplayer.hls;

import androidx.media3.exoplayer.hls.HlsSampleStreamWrapper;
import java.util.Set;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7091a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7092b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f7091a = i2;
        this.f7092b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f7092b;
        switch (this.f7091a) {
            case 0:
                Set set = HlsSampleStreamWrapper.H0;
                ((HlsSampleStreamWrapper) obj).B();
                break;
            case 1:
                HlsSampleStreamWrapper hlsSampleStreamWrapper = (HlsSampleStreamWrapper) obj;
                hlsSampleStreamWrapper.C = true;
                hlsSampleStreamWrapper.B();
                break;
            default:
                ((HlsSampleStreamWrapper.Callback) obj).c();
                break;
        }
    }
}
