package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi
/* loaded from: classes3.dex */
class AsynchronousMediaCodecBufferEnqueuer implements MediaCodecBufferEnqueuer {

    /* renamed from: g, reason: collision with root package name */
    public static final ArrayDeque f7282g = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    public static final Object f7283h = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f7284a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f7285b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f7286c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f7287d;

    /* renamed from: e, reason: collision with root package name */
    public final ConditionVariable f7288e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7289f;

    public static class MessageParams {

        /* renamed from: a, reason: collision with root package name */
        public int f7291a;

        /* renamed from: b, reason: collision with root package name */
        public int f7292b;

        /* renamed from: c, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f7293c = new MediaCodec.CryptoInfo();

        /* renamed from: d, reason: collision with root package name */
        public long f7294d;

        /* renamed from: e, reason: collision with root package name */
        public int f7295e;
    }

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this.f7284a = mediaCodec;
        this.f7285b = handlerThread;
        this.f7288e = conditionVariable;
        this.f7287d = new AtomicReference();
    }

    public static MessageParams e() {
        ArrayDeque arrayDeque = f7282g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new MessageParams();
                }
                return (MessageParams) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void a(int i2, CryptoInfo cryptoInfo, long j2, int i3) {
        d();
        MessageParams messageParamsE = e();
        messageParamsE.f7291a = i2;
        messageParamsE.f7292b = 0;
        messageParamsE.f7294d = j2;
        messageParamsE.f7295e = i3;
        int i4 = cryptoInfo.f6062f;
        MediaCodec.CryptoInfo cryptoInfo2 = messageParamsE.f7293c;
        cryptoInfo2.numSubSamples = i4;
        int[] iArr = cryptoInfo.f6060d;
        int[] iArrCopyOf = cryptoInfo2.numBytesOfClearData;
        if (iArr != null) {
            if (iArrCopyOf == null || iArrCopyOf.length < iArr.length) {
                iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            } else {
                System.arraycopy(iArr, 0, iArrCopyOf, 0, iArr.length);
            }
        }
        cryptoInfo2.numBytesOfClearData = iArrCopyOf;
        int[] iArr2 = cryptoInfo.f6061e;
        int[] iArrCopyOf2 = cryptoInfo2.numBytesOfEncryptedData;
        if (iArr2 != null) {
            if (iArrCopyOf2 == null || iArrCopyOf2.length < iArr2.length) {
                iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
            } else {
                System.arraycopy(iArr2, 0, iArrCopyOf2, 0, iArr2.length);
            }
        }
        cryptoInfo2.numBytesOfEncryptedData = iArrCopyOf2;
        byte[] bArr = cryptoInfo.f6058b;
        byte[] bArrCopyOf = cryptoInfo2.key;
        if (bArr != null) {
            if (bArrCopyOf == null || bArrCopyOf.length < bArr.length) {
                bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            } else {
                System.arraycopy(bArr, 0, bArrCopyOf, 0, bArr.length);
            }
        }
        bArrCopyOf.getClass();
        cryptoInfo2.key = bArrCopyOf;
        byte[] bArr2 = cryptoInfo.f6057a;
        byte[] bArrCopyOf2 = cryptoInfo2.iv;
        if (bArr2 != null) {
            if (bArrCopyOf2 == null || bArrCopyOf2.length < bArr2.length) {
                bArrCopyOf2 = Arrays.copyOf(bArr2, bArr2.length);
            } else {
                System.arraycopy(bArr2, 0, bArrCopyOf2, 0, bArr2.length);
            }
        }
        bArrCopyOf2.getClass();
        cryptoInfo2.iv = bArrCopyOf2;
        cryptoInfo2.mode = cryptoInfo.f6059c;
        if (Util.f5744a >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.f6063g, cryptoInfo.f6064h));
        }
        this.f7286c.obtainMessage(2, messageParamsE).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void b(Bundle bundle) {
        d();
        Handler handler = this.f7286c;
        int i2 = Util.f5744a;
        handler.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void c(int i2, int i3, long j2, int i4) {
        d();
        MessageParams messageParamsE = e();
        messageParamsE.f7291a = i2;
        messageParamsE.f7292b = i3;
        messageParamsE.f7294d = j2;
        messageParamsE.f7295e = i4;
        Handler handler = this.f7286c;
        int i5 = Util.f5744a;
        handler.obtainMessage(1, messageParamsE).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void d() {
        RuntimeException runtimeException = (RuntimeException) this.f7287d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void flush() {
        if (this.f7289f) {
            try {
                Handler handler = this.f7286c;
                handler.getClass();
                handler.removeCallbacksAndMessages(null);
                ConditionVariable conditionVariable = this.f7288e;
                conditionVariable.c();
                Handler handler2 = this.f7286c;
                handler2.getClass();
                handler2.obtainMessage(3).sendToTarget();
                conditionVariable.a();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void shutdown() {
        if (this.f7289f) {
            flush();
            this.f7285b.quit();
        }
        this.f7289f = false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public final void start() {
        if (this.f7289f) {
            return;
        }
        HandlerThread handlerThread = this.f7285b;
        handlerThread.start();
        this.f7286c = new Handler(handlerThread.getLooper()) { // from class: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) throws MediaCodec.CryptoException {
                AsynchronousMediaCodecBufferEnqueuer asynchronousMediaCodecBufferEnqueuer = AsynchronousMediaCodecBufferEnqueuer.this;
                ArrayDeque arrayDeque = AsynchronousMediaCodecBufferEnqueuer.f7282g;
                asynchronousMediaCodecBufferEnqueuer.getClass();
                int i2 = message.what;
                MessageParams messageParams = null;
                if (i2 == 1) {
                    MessageParams messageParams2 = (MessageParams) message.obj;
                    try {
                        asynchronousMediaCodecBufferEnqueuer.f7284a.queueInputBuffer(messageParams2.f7291a, 0, messageParams2.f7292b, messageParams2.f7294d, messageParams2.f7295e);
                    } catch (RuntimeException e2) {
                        AtomicReference atomicReference = asynchronousMediaCodecBufferEnqueuer.f7287d;
                        while (!atomicReference.compareAndSet(null, e2) && atomicReference.get() == null) {
                        }
                    }
                    messageParams = messageParams2;
                } else if (i2 == 2) {
                    MessageParams messageParams3 = (MessageParams) message.obj;
                    int i3 = messageParams3.f7291a;
                    MediaCodec.CryptoInfo cryptoInfo = messageParams3.f7293c;
                    long j2 = messageParams3.f7294d;
                    int i4 = messageParams3.f7295e;
                    try {
                        synchronized (AsynchronousMediaCodecBufferEnqueuer.f7283h) {
                            asynchronousMediaCodecBufferEnqueuer.f7284a.queueSecureInputBuffer(i3, 0, cryptoInfo, j2, i4);
                        }
                    } catch (RuntimeException e3) {
                        AtomicReference atomicReference2 = asynchronousMediaCodecBufferEnqueuer.f7287d;
                        while (!atomicReference2.compareAndSet(null, e3) && atomicReference2.get() == null) {
                        }
                    }
                    messageParams = messageParams3;
                } else if (i2 == 3) {
                    asynchronousMediaCodecBufferEnqueuer.f7288e.e();
                } else if (i2 != 4) {
                    AtomicReference atomicReference3 = asynchronousMediaCodecBufferEnqueuer.f7287d;
                    IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(message.what));
                    while (!atomicReference3.compareAndSet(null, illegalStateException) && atomicReference3.get() == null) {
                    }
                } else {
                    try {
                        asynchronousMediaCodecBufferEnqueuer.f7284a.setParameters((Bundle) message.obj);
                    } catch (RuntimeException e4) {
                        AtomicReference atomicReference4 = asynchronousMediaCodecBufferEnqueuer.f7287d;
                        while (!atomicReference4.compareAndSet(null, e4) && atomicReference4.get() == null) {
                        }
                    }
                }
                if (messageParams != null) {
                    ArrayDeque arrayDeque2 = AsynchronousMediaCodecBufferEnqueuer.f7282g;
                    synchronized (arrayDeque2) {
                        arrayDeque2.add(messageParams);
                    }
                }
            }
        };
        this.f7289f = true;
    }
}
