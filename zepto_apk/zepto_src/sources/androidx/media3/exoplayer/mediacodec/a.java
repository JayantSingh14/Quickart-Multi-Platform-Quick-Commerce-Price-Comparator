package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7352a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f7353b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter f7354c;

    public /* synthetic */ a(MediaCodecAdapter mediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, int i2) {
        this.f7352a = i2;
        this.f7354c = mediaCodecAdapter;
        this.f7353b = onFrameRenderedListener;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j3) {
        switch (this.f7352a) {
            case 0:
                ((AsynchronousMediaCodecAdapter) this.f7354c).getClass();
                this.f7353b.a(j2);
                break;
            default:
                ((SynchronousMediaCodecAdapter) this.f7354c).getClass();
                this.f7353b.a(j2);
                break;
        }
    }
}
