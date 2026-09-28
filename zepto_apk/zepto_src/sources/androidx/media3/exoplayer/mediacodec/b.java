package androidx.media3.exoplayer.mediacodec;

import android.os.HandlerThread;
import com.google.common.base.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7355a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7356b;

    public /* synthetic */ b(int i2, int i3) {
        this.f7355a = i3;
        this.f7356b = i2;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f7355a) {
            case 0:
                return new HandlerThread(AsynchronousMediaCodecAdapter.p(this.f7356b, "ExoPlayer:MediaCodecAsyncAdapter:"));
            default:
                return new HandlerThread(AsynchronousMediaCodecAdapter.p(this.f7356b, "ExoPlayer:MediaCodecQueueingThread:"));
        }
    }
}
