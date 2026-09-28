package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class StandardGifDecoder implements GifDecoder {

    /* renamed from: a, reason: collision with root package name */
    public int[] f15775a;

    /* renamed from: c, reason: collision with root package name */
    public final GifDecoder.BitmapProvider f15777c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f15778d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f15779e;

    /* renamed from: f, reason: collision with root package name */
    public short[] f15780f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f15781g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f15782h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f15783i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f15784j;

    /* renamed from: k, reason: collision with root package name */
    public int f15785k;

    /* renamed from: l, reason: collision with root package name */
    public GifHeader f15786l;

    /* renamed from: m, reason: collision with root package name */
    public Bitmap f15787m;
    public final boolean n;
    public int o;
    public final int p;
    public final int q;
    public final int r;
    public Boolean s;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f15776b = new int[256];
    public Bitmap.Config t = Bitmap.Config.ARGB_8888;

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
        this.f15777c = bitmapProvider;
        this.f15786l = new GifHeader();
        synchronized (this) {
            try {
                if (i2 <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
                }
                int iHighestOneBit = Integer.highestOneBit(i2);
                this.o = 0;
                this.f15786l = gifHeader;
                this.f15785k = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f15778d = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.f15778d.order(ByteOrder.LITTLE_ENDIAN);
                this.n = false;
                Iterator it = gifHeader.f15764e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((GifFrame) it.next()).f15755g == 3) {
                        this.n = true;
                        break;
                    }
                }
                this.p = iHighestOneBit;
                int i3 = gifHeader.f15765f;
                this.r = i3 / iHighestOneBit;
                int i4 = gifHeader.f15766g;
                this.q = i4 / iHighestOneBit;
                this.f15783i = this.f15777c.b(i3 * i4);
                this.f15784j = this.f15777c.d(this.r * this.q);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public final synchronized Bitmap a() {
        try {
            if (this.f15786l.f15762c <= 0 || this.f15785k < 0) {
                if (Log.isLoggable("StandardGifDecoder", 3)) {
                    Log.d("StandardGifDecoder", "Unable to decode frame, frameCount=" + this.f15786l.f15762c + ", framePointer=" + this.f15785k);
                }
                this.o = 1;
            }
            int i2 = this.o;
            if (i2 != 1 && i2 != 2) {
                this.o = 0;
                if (this.f15779e == null) {
                    this.f15779e = this.f15777c.b(255);
                }
                GifFrame gifFrame = (GifFrame) this.f15786l.f15764e.get(this.f15785k);
                int i3 = this.f15785k - 1;
                GifFrame gifFrame2 = i3 >= 0 ? (GifFrame) this.f15786l.f15764e.get(i3) : null;
                int[] iArr = gifFrame.f15759k;
                if (iArr == null) {
                    iArr = this.f15786l.f15760a;
                }
                this.f15775a = iArr;
                if (iArr == null) {
                    if (Log.isLoggable("StandardGifDecoder", 3)) {
                        Log.d("StandardGifDecoder", "No valid color table found for frame #" + this.f15785k);
                    }
                    this.o = 1;
                    return null;
                }
                if (gifFrame.f15754f) {
                    System.arraycopy(iArr, 0, this.f15776b, 0, iArr.length);
                    int[] iArr2 = this.f15776b;
                    this.f15775a = iArr2;
                    iArr2[gifFrame.f15756h] = 0;
                    if (gifFrame.f15755g == 2 && this.f15785k == 0) {
                        this.s = Boolean.TRUE;
                    }
                }
                return f(gifFrame, gifFrame2);
            }
            if (Log.isLoggable("StandardGifDecoder", 3)) {
                Log.d("StandardGifDecoder", "Unable to decode frame, status=" + this.o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b() {
        this.f15785k = (this.f15785k + 1) % this.f15786l.f15762c;
    }

    public final Bitmap c() {
        Boolean bool = this.s;
        Bitmap bitmapC = this.f15777c.c(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        bitmapC.setHasAlpha(true);
        return bitmapC;
    }

    public final int d() {
        int i2;
        GifHeader gifHeader = this.f15786l;
        int i3 = gifHeader.f15762c;
        if (i3 <= 0 || (i2 = this.f15785k) < 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= i3) {
            return -1;
        }
        return ((GifFrame) gifHeader.f15764e.get(i2)).f15757i;
    }

    public final void e(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap f(com.bumptech.glide.gifdecoder.GifFrame r35, com.bumptech.glide.gifdecoder.GifFrame r36) {
        /*
            Method dump skipped, instructions count: 1027
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.f(com.bumptech.glide.gifdecoder.GifFrame, com.bumptech.glide.gifdecoder.GifFrame):android.graphics.Bitmap");
    }
}
