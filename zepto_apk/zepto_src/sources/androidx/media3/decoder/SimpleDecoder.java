package androidx.media3.decoder;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.exoplayer.image.ImageOutputBuffer;
import java.util.ArrayDeque;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends DecoderOutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {

    /* renamed from: a, reason: collision with root package name */
    public final Thread f6079a;

    /* renamed from: e, reason: collision with root package name */
    public final DecoderInputBuffer[] f6083e;

    /* renamed from: f, reason: collision with root package name */
    public final DecoderOutputBuffer[] f6084f;

    /* renamed from: g, reason: collision with root package name */
    public int f6085g;

    /* renamed from: h, reason: collision with root package name */
    public int f6086h;

    /* renamed from: i, reason: collision with root package name */
    public DecoderInputBuffer f6087i;

    /* renamed from: j, reason: collision with root package name */
    public DecoderException f6088j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6089k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6090l;

    /* renamed from: m, reason: collision with root package name */
    public int f6091m;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6080b = new Object();
    public long n = -9223372036854775807L;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f6081c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f6082d = new ArrayDeque();

    public SimpleDecoder(DecoderInputBuffer[] decoderInputBufferArr, DecoderOutputBuffer[] decoderOutputBufferArr) {
        this.f6083e = decoderInputBufferArr;
        this.f6085g = decoderInputBufferArr.length;
        for (int i2 = 0; i2 < this.f6085g; i2++) {
            this.f6083e[i2] = g();
        }
        this.f6084f = decoderOutputBufferArr;
        this.f6086h = decoderOutputBufferArr.length;
        for (int i3 = 0; i3 < this.f6086h; i3++) {
            this.f6084f[i3] = h();
        }
        Thread thread = new Thread() { // from class: androidx.media3.decoder.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                do {
                    try {
                    } catch (InterruptedException e2) {
                        throw new IllegalStateException(e2);
                    }
                } while (SimpleDecoder.this.k());
            }
        };
        this.f6079a = thread;
        thread.start();
    }

    @Override // androidx.media3.decoder.Decoder
    public final void d(long j2) {
        synchronized (this.f6080b) {
            try {
                Assertions.g(this.f6085g == this.f6083e.length || this.f6089k);
                this.n = j2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final Object e() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.f6080b) {
            try {
                DecoderException decoderException = this.f6088j;
                if (decoderException != null) {
                    throw decoderException;
                }
                Assertions.g(this.f6087i == null);
                int i2 = this.f6085g;
                if (i2 == 0) {
                    decoderInputBuffer = null;
                } else {
                    DecoderInputBuffer[] decoderInputBufferArr = this.f6083e;
                    int i3 = i2 - 1;
                    this.f6085g = i3;
                    decoderInputBuffer = decoderInputBufferArr[i3];
                }
                this.f6087i = decoderInputBuffer;
            } catch (Throwable th) {
                throw th;
            }
        }
        return decoderInputBuffer;
    }

    @Override // androidx.media3.decoder.Decoder
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final void b(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.f6080b) {
            try {
                DecoderException decoderException = this.f6088j;
                if (decoderException != null) {
                    throw decoderException;
                }
                Assertions.a(decoderInputBuffer == this.f6087i);
                this.f6081c.addLast(decoderInputBuffer);
                if (!this.f6081c.isEmpty() && this.f6086h > 0) {
                    this.f6080b.notify();
                }
                this.f6087i = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final void flush() {
        synchronized (this.f6080b) {
            try {
                this.f6089k = true;
                this.f6091m = 0;
                DecoderInputBuffer decoderInputBuffer = this.f6087i;
                if (decoderInputBuffer != null) {
                    decoderInputBuffer.h();
                    int i2 = this.f6085g;
                    this.f6085g = i2 + 1;
                    this.f6083e[i2] = decoderInputBuffer;
                    this.f6087i = null;
                }
                while (!this.f6081c.isEmpty()) {
                    DecoderInputBuffer decoderInputBuffer2 = (DecoderInputBuffer) this.f6081c.removeFirst();
                    decoderInputBuffer2.h();
                    int i3 = this.f6085g;
                    this.f6085g = i3 + 1;
                    this.f6083e[i3] = decoderInputBuffer2;
                }
                while (!this.f6082d.isEmpty()) {
                    ((DecoderOutputBuffer) this.f6082d.removeFirst()).i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract DecoderInputBuffer g();

    public abstract DecoderOutputBuffer h();

    public abstract DecoderException i(Throwable th);

    public abstract DecoderException j(DecoderInputBuffer decoderInputBuffer, DecoderOutputBuffer decoderOutputBuffer, boolean z);

    public final boolean k() {
        boolean z;
        DecoderException decoderExceptionI;
        synchronized (this.f6080b) {
            while (!this.f6090l) {
                try {
                    if (!this.f6081c.isEmpty() && this.f6086h > 0) {
                        break;
                    }
                    this.f6080b.wait();
                } finally {
                }
            }
            if (this.f6090l) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f6081c.removeFirst();
            DecoderOutputBuffer[] decoderOutputBufferArr = this.f6084f;
            int i2 = this.f6086h - 1;
            this.f6086h = i2;
            DecoderOutputBuffer decoderOutputBuffer = decoderOutputBufferArr[i2];
            boolean z2 = this.f6089k;
            this.f6089k = false;
            if (decoderInputBuffer.g(4)) {
                decoderOutputBuffer.e(4);
            } else {
                decoderOutputBuffer.f6076b = decoderInputBuffer.f6073f;
                if (decoderInputBuffer.g(134217728)) {
                    decoderOutputBuffer.e(134217728);
                }
                long j2 = decoderInputBuffer.f6073f;
                synchronized (this.f6080b) {
                    long j3 = this.n;
                    z = j3 == -9223372036854775807L || j2 >= j3;
                }
                if (!z) {
                    decoderOutputBuffer.f6078d = true;
                }
                try {
                    decoderExceptionI = j(decoderInputBuffer, decoderOutputBuffer, z2);
                } catch (OutOfMemoryError e2) {
                    decoderExceptionI = i(e2);
                } catch (RuntimeException e3) {
                    decoderExceptionI = i(e3);
                }
                if (decoderExceptionI != null) {
                    synchronized (this.f6080b) {
                        this.f6088j = decoderExceptionI;
                    }
                    return false;
                }
            }
            synchronized (this.f6080b) {
                try {
                    if (this.f6089k) {
                        decoderOutputBuffer.i();
                    } else if (decoderOutputBuffer.f6078d) {
                        this.f6091m++;
                        decoderOutputBuffer.i();
                    } else {
                        decoderOutputBuffer.f6077c = this.f6091m;
                        this.f6091m = 0;
                        this.f6082d.addLast(decoderOutputBuffer);
                    }
                    decoderInputBuffer.h();
                    int i3 = this.f6085g;
                    this.f6085g = i3 + 1;
                    this.f6083e[i3] = decoderInputBuffer;
                } finally {
                }
            }
            return true;
        }
    }

    @Override // androidx.media3.decoder.Decoder
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final DecoderOutputBuffer a() {
        synchronized (this.f6080b) {
            try {
                DecoderException decoderException = this.f6088j;
                if (decoderException != null) {
                    throw decoderException;
                }
                if (this.f6082d.isEmpty()) {
                    return null;
                }
                return (DecoderOutputBuffer) this.f6082d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(DecoderOutputBuffer decoderOutputBuffer) {
        synchronized (this.f6080b) {
            decoderOutputBuffer.h();
            int i2 = this.f6086h;
            this.f6086h = i2 + 1;
            this.f6084f[i2] = decoderOutputBuffer;
            if (!this.f6081c.isEmpty() && this.f6086h > 0) {
                this.f6080b.notify();
            }
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final void release() throws InterruptedException {
        synchronized (this.f6080b) {
            this.f6090l = true;
            this.f6080b.notify();
        }
        try {
            this.f6079a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public /* bridge */ /* synthetic */ ImageOutputBuffer a() {
        return (ImageOutputBuffer) a();
    }
}
