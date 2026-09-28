package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import androidx.collection.CircularIntArray;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import java.nio.ByteBuffer;

@RequiresApi
/* loaded from: classes3.dex */
final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f7275a;

    /* renamed from: b, reason: collision with root package name */
    public final AsynchronousMediaCodecCallback f7276b;

    /* renamed from: c, reason: collision with root package name */
    public final MediaCodecBufferEnqueuer f7277c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7278d;

    /* renamed from: e, reason: collision with root package name */
    public int f7279e = 0;

    public static final class Factory implements MediaCodecAdapter.Factory {

        /* renamed from: a, reason: collision with root package name */
        public final b f7280a;

        /* renamed from: b, reason: collision with root package name */
        public final b f7281b;

        public Factory(int i2) {
            b bVar = new b(i2, 0);
            b bVar2 = new b(i2, 1);
            this.f7280a = bVar;
            this.f7281b = bVar2;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Factory
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AsynchronousMediaCodecAdapter a(MediaCodecAdapter.Configuration configuration) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            MediaCodecBufferEnqueuer synchronousMediaCodecBufferEnqueuer;
            int i2;
            AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter;
            String str = configuration.f7314a.f7320a;
            AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter2 = null;
            try {
                Trace.beginSection("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    Format format = configuration.f7316c;
                    int i3 = Util.f5744a;
                    if (i3 >= 34 && (i3 >= 35 || MimeTypes.o(format.f5225m))) {
                        synchronousMediaCodecBufferEnqueuer = new SynchronousMediaCodecBufferEnqueuer(mediaCodecCreateByCodecName);
                        i2 = 4;
                    } else {
                        synchronousMediaCodecBufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(mediaCodecCreateByCodecName, (HandlerThread) this.f7281b.get());
                        i2 = 0;
                    }
                    asynchronousMediaCodecAdapter = new AsynchronousMediaCodecAdapter(mediaCodecCreateByCodecName, (HandlerThread) this.f7280a.get(), synchronousMediaCodecBufferEnqueuer);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                mediaCodecCreateByCodecName = null;
            }
            try {
                Trace.endSection();
                AsynchronousMediaCodecAdapter.o(asynchronousMediaCodecAdapter, configuration.f7315b, configuration.f7317d, configuration.f7318e, i2);
                return asynchronousMediaCodecAdapter;
            } catch (Exception e4) {
                e = e4;
                asynchronousMediaCodecAdapter2 = asynchronousMediaCodecAdapter;
                if (asynchronousMediaCodecAdapter2 != null) {
                    asynchronousMediaCodecAdapter2.release();
                } else if (mediaCodecCreateByCodecName != null) {
                    mediaCodecCreateByCodecName.release();
                }
                throw e;
            }
        }
    }

    public AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, MediaCodecBufferEnqueuer mediaCodecBufferEnqueuer) {
        this.f7275a = mediaCodec;
        this.f7276b = new AsynchronousMediaCodecCallback(handlerThread);
        this.f7277c = mediaCodecBufferEnqueuer;
    }

    public static void o(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = asynchronousMediaCodecAdapter.f7276b;
        Assertions.g(asynchronousMediaCodecCallback.f7298c == null);
        HandlerThread handlerThread = asynchronousMediaCodecCallback.f7297b;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        MediaCodec mediaCodec = asynchronousMediaCodecAdapter.f7275a;
        mediaCodec.setCallback(asynchronousMediaCodecCallback, handler);
        asynchronousMediaCodecCallback.f7298c = handler;
        Trace.beginSection("configureCodec");
        mediaCodec.configure(mediaFormat, surface, mediaCrypto, i2);
        Trace.endSection();
        asynchronousMediaCodecAdapter.f7277c.start();
        Trace.beginSection("startCodec");
        mediaCodec.start();
        Trace.endSection();
        asynchronousMediaCodecAdapter.f7279e = 1;
    }

    public static String p(int i2, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i2 == 1) {
            sb.append("Audio");
        } else if (i2 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i2);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void a(int i2, CryptoInfo cryptoInfo, long j2, int i3) {
        this.f7277c.a(i2, cryptoInfo, j2, i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void b(Bundle bundle) {
        this.f7277c.b(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void c(int i2, int i3, long j2, int i4) {
        this.f7277c.c(i2, i3, j2, i4);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final boolean d(MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener) {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f7276b;
        synchronized (asynchronousMediaCodecCallback.f7296a) {
            asynchronousMediaCodecCallback.o = onBufferAvailableListener;
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void e(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.f7275a.setOnFrameRenderedListener(new a(this, onFrameRenderedListener, 0), handler);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final MediaFormat f() {
        MediaFormat mediaFormat;
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f7276b;
        synchronized (asynchronousMediaCodecCallback.f7296a) {
            try {
                mediaFormat = asynchronousMediaCodecCallback.f7303h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void flush() {
        this.f7277c.flush();
        this.f7275a.flush();
        final AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f7276b;
        synchronized (asynchronousMediaCodecCallback.f7296a) {
            asynchronousMediaCodecCallback.f7307l++;
            Handler handler = asynchronousMediaCodecCallback.f7298c;
            int i2 = Util.f5744a;
            handler.post(new Runnable() { // from class: androidx.media3.exoplayer.mediacodec.c
                @Override // java.lang.Runnable
                public final void run() {
                    AsynchronousMediaCodecCallback asynchronousMediaCodecCallback2 = asynchronousMediaCodecCallback;
                    synchronized (asynchronousMediaCodecCallback2.f7296a) {
                        try {
                            if (asynchronousMediaCodecCallback2.f7308m) {
                                return;
                            }
                            long j2 = asynchronousMediaCodecCallback2.f7307l - 1;
                            asynchronousMediaCodecCallback2.f7307l = j2;
                            if (j2 > 0) {
                                return;
                            }
                            if (j2 >= 0) {
                                asynchronousMediaCodecCallback2.a();
                                return;
                            }
                            IllegalStateException illegalStateException = new IllegalStateException();
                            synchronized (asynchronousMediaCodecCallback2.f7296a) {
                                asynchronousMediaCodecCallback2.n = illegalStateException;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            });
        }
        this.f7275a.start();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void g(int i2) {
        this.f7275a.setVideoScalingMode(i2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final ByteBuffer h(int i2) {
        return this.f7275a.getInputBuffer(i2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void i(Surface surface) {
        this.f7275a.setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void j(int i2, long j2) {
        this.f7275a.releaseOutputBuffer(i2, j2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final int k() {
        this.f7277c.d();
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f7276b;
        synchronized (asynchronousMediaCodecCallback.f7296a) {
            try {
                IllegalStateException illegalStateException = asynchronousMediaCodecCallback.n;
                if (illegalStateException != null) {
                    asynchronousMediaCodecCallback.n = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = asynchronousMediaCodecCallback.f7305j;
                if (codecException != null) {
                    asynchronousMediaCodecCallback.f7305j = null;
                    throw codecException;
                }
                MediaCodec.CryptoException cryptoException = asynchronousMediaCodecCallback.f7306k;
                if (cryptoException != null) {
                    asynchronousMediaCodecCallback.f7306k = null;
                    throw cryptoException;
                }
                boolean z = true;
                int iB = -1;
                if (asynchronousMediaCodecCallback.f7307l > 0 || asynchronousMediaCodecCallback.f7308m) {
                    return -1;
                }
                CircularIntArray circularIntArray = asynchronousMediaCodecCallback.f7299d;
                if (circularIntArray.f1407b != circularIntArray.f1408c) {
                    z = false;
                }
                if (!z) {
                    iB = circularIntArray.b();
                }
                return iB;
            } finally {
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final int l(MediaCodec.BufferInfo bufferInfo) {
        this.f7277c.d();
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f7276b;
        synchronized (asynchronousMediaCodecCallback.f7296a) {
            try {
                IllegalStateException illegalStateException = asynchronousMediaCodecCallback.n;
                if (illegalStateException != null) {
                    asynchronousMediaCodecCallback.n = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = asynchronousMediaCodecCallback.f7305j;
                if (codecException != null) {
                    asynchronousMediaCodecCallback.f7305j = null;
                    throw codecException;
                }
                MediaCodec.CryptoException cryptoException = asynchronousMediaCodecCallback.f7306k;
                if (cryptoException != null) {
                    asynchronousMediaCodecCallback.f7306k = null;
                    throw cryptoException;
                }
                boolean z = true;
                if (asynchronousMediaCodecCallback.f7307l > 0 || asynchronousMediaCodecCallback.f7308m) {
                    return -1;
                }
                CircularIntArray circularIntArray = asynchronousMediaCodecCallback.f7300e;
                if (circularIntArray.f1407b != circularIntArray.f1408c) {
                    z = false;
                }
                if (z) {
                    return -1;
                }
                int iB = circularIntArray.b();
                if (iB >= 0) {
                    Assertions.h(asynchronousMediaCodecCallback.f7303h);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) asynchronousMediaCodecCallback.f7301f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (iB == -2) {
                    asynchronousMediaCodecCallback.f7303h = (MediaFormat) asynchronousMediaCodecCallback.f7302g.remove();
                }
                return iB;
            } finally {
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void m(int i2, boolean z) {
        this.f7275a.releaseOutputBuffer(i2, z);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final ByteBuffer n(int i2) {
        return this.f7275a.getOutputBuffer(i2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void release() {
        try {
            if (this.f7279e == 1) {
                this.f7277c.shutdown();
                AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f7276b;
                synchronized (asynchronousMediaCodecCallback.f7296a) {
                    asynchronousMediaCodecCallback.f7308m = true;
                    asynchronousMediaCodecCallback.f7297b.quit();
                    asynchronousMediaCodecCallback.a();
                }
            }
            this.f7279e = 2;
            if (this.f7278d) {
                return;
            }
            try {
                int i2 = Util.f5744a;
                if (i2 >= 30 && i2 < 33) {
                    this.f7275a.stop();
                }
            } finally {
            }
        } catch (Throwable th) {
            if (!this.f7278d) {
                try {
                    int i3 = Util.f5744a;
                    if (i3 >= 30 && i3 < 33) {
                        this.f7275a.stop();
                    }
                } finally {
                }
            }
            throw th;
        }
    }
}
