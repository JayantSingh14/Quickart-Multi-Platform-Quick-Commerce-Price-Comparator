package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.RequiresApi;
import androidx.collection.CircularIntArray;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import java.util.ArrayDeque;

@RequiresApi
/* loaded from: classes3.dex */
final class AsynchronousMediaCodecCallback extends MediaCodec.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f7297b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f7298c;

    /* renamed from: h, reason: collision with root package name */
    public MediaFormat f7303h;

    /* renamed from: i, reason: collision with root package name */
    public MediaFormat f7304i;

    /* renamed from: j, reason: collision with root package name */
    public MediaCodec.CodecException f7305j;

    /* renamed from: k, reason: collision with root package name */
    public MediaCodec.CryptoException f7306k;

    /* renamed from: l, reason: collision with root package name */
    public long f7307l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7308m;
    public IllegalStateException n;
    public MediaCodecAdapter.OnBufferAvailableListener o;

    /* renamed from: a, reason: collision with root package name */
    public final Object f7296a = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final CircularIntArray f7299d = new CircularIntArray();

    /* renamed from: e, reason: collision with root package name */
    public final CircularIntArray f7300e = new CircularIntArray();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f7301f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f7302g = new ArrayDeque();

    public AsynchronousMediaCodecCallback(HandlerThread handlerThread) {
        this.f7297b = handlerThread;
    }

    public final void a() {
        ArrayDeque arrayDeque = this.f7302g;
        if (!arrayDeque.isEmpty()) {
            this.f7304i = (MediaFormat) arrayDeque.getLast();
        }
        CircularIntArray circularIntArray = this.f7299d;
        circularIntArray.f1408c = circularIntArray.f1407b;
        CircularIntArray circularIntArray2 = this.f7300e;
        circularIntArray2.f1408c = circularIntArray2.f1407b;
        this.f7301f.clear();
        arrayDeque.clear();
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f7296a) {
            this.f7306k = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f7296a) {
            this.f7305j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
        Renderer.WakeupListener wakeupListener;
        synchronized (this.f7296a) {
            this.f7299d.a(i2);
            MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener = this.o;
            if (onBufferAvailableListener != null && (wakeupListener = MediaCodecRenderer.this.G) != null) {
                wakeupListener.b();
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
        Renderer.WakeupListener wakeupListener;
        synchronized (this.f7296a) {
            try {
                MediaFormat mediaFormat = this.f7304i;
                if (mediaFormat != null) {
                    this.f7300e.a(-2);
                    this.f7302g.add(mediaFormat);
                    this.f7304i = null;
                }
                this.f7300e.a(i2);
                this.f7301f.add(bufferInfo);
                MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener = this.o;
                if (onBufferAvailableListener != null && (wakeupListener = MediaCodecRenderer.this.G) != null) {
                    wakeupListener.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f7296a) {
            this.f7300e.a(-2);
            this.f7302g.add(mediaFormat);
            this.f7304i = null;
        }
    }
}
