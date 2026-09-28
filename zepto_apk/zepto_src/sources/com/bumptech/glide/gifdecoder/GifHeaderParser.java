package com.bumptech.glide.gifdecoder;

import android.support.v4.media.b;
import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class GifHeaderParser {

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f15772b;

    /* renamed from: c, reason: collision with root package name */
    public GifHeader f15773c;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f15771a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    public int f15774d = 0;

    public final boolean a() {
        return this.f15773c.f15761b != 0;
    }

    public final GifHeader b() {
        byte[] bArr;
        if (this.f15772b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (a()) {
            return this.f15773c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) c());
        }
        if (sb.toString().startsWith("GIF")) {
            this.f15773c.f15765f = this.f15772b.getShort();
            this.f15773c.f15766g = this.f15772b.getShort();
            int iC = c();
            GifHeader gifHeader = this.f15773c;
            gifHeader.f15767h = (iC & 128) != 0;
            gifHeader.f15768i = (int) Math.pow(2.0d, (iC & 7) + 1);
            this.f15773c.f15769j = c();
            GifHeader gifHeader2 = this.f15773c;
            c();
            gifHeader2.getClass();
            if (this.f15773c.f15767h && !a()) {
                GifHeader gifHeader3 = this.f15773c;
                gifHeader3.f15760a = e(gifHeader3.f15768i);
                GifHeader gifHeader4 = this.f15773c;
                gifHeader4.f15770k = gifHeader4.f15760a[gifHeader4.f15769j];
            }
        } else {
            this.f15773c.f15761b = 1;
        }
        if (!a()) {
            boolean z = false;
            while (!z && !a() && this.f15773c.f15762c <= Integer.MAX_VALUE) {
                int iC2 = c();
                if (iC2 == 33) {
                    int iC3 = c();
                    if (iC3 == 1) {
                        f();
                    } else if (iC3 == 249) {
                        this.f15773c.f15763d = new GifFrame();
                        c();
                        int iC4 = c();
                        GifFrame gifFrame = this.f15773c.f15763d;
                        int i3 = (iC4 & 28) >> 2;
                        gifFrame.f15755g = i3;
                        if (i3 == 0) {
                            gifFrame.f15755g = 1;
                        }
                        gifFrame.f15754f = (iC4 & 1) != 0;
                        short s = this.f15772b.getShort();
                        if (s < 2) {
                            s = 10;
                        }
                        GifFrame gifFrame2 = this.f15773c.f15763d;
                        gifFrame2.f15757i = s * 10;
                        gifFrame2.f15756h = c();
                        c();
                    } else if (iC3 == 254) {
                        f();
                    } else if (iC3 != 255) {
                        f();
                    } else {
                        d();
                        StringBuilder sb2 = new StringBuilder();
                        int i4 = 0;
                        while (true) {
                            bArr = this.f15771a;
                            if (i4 >= 11) {
                                break;
                            }
                            sb2.append((char) bArr[i4]);
                            i4++;
                        }
                        if (sb2.toString().equals("NETSCAPE2.0")) {
                            do {
                                d();
                                if (bArr[0] == 1) {
                                    byte b2 = bArr[1];
                                    byte b3 = bArr[2];
                                    this.f15773c.getClass();
                                }
                                if (this.f15774d > 0) {
                                }
                            } while (!a());
                        } else {
                            f();
                        }
                    }
                } else if (iC2 == 44) {
                    GifHeader gifHeader5 = this.f15773c;
                    if (gifHeader5.f15763d == null) {
                        gifHeader5.f15763d = new GifFrame();
                    }
                    gifHeader5.f15763d.f15749a = this.f15772b.getShort();
                    this.f15773c.f15763d.f15750b = this.f15772b.getShort();
                    this.f15773c.f15763d.f15751c = this.f15772b.getShort();
                    this.f15773c.f15763d.f15752d = this.f15772b.getShort();
                    int iC5 = c();
                    boolean z2 = (iC5 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iC5 & 7) + 1);
                    GifFrame gifFrame3 = this.f15773c.f15763d;
                    gifFrame3.f15753e = (iC5 & 64) != 0;
                    if (z2) {
                        gifFrame3.f15759k = e(iPow);
                    } else {
                        gifFrame3.f15759k = null;
                    }
                    this.f15773c.f15763d.f15758j = this.f15772b.position();
                    c();
                    f();
                    if (!a()) {
                        GifHeader gifHeader6 = this.f15773c;
                        gifHeader6.f15762c++;
                        gifHeader6.f15764e.add(gifHeader6.f15763d);
                    }
                } else if (iC2 != 59) {
                    this.f15773c.f15761b = 1;
                } else {
                    z = true;
                }
            }
            GifHeader gifHeader7 = this.f15773c;
            if (gifHeader7.f15762c < 0) {
                gifHeader7.f15761b = 1;
            }
        }
        return this.f15773c;
    }

    public final int c() {
        try {
            return this.f15772b.get() & 255;
        } catch (Exception unused) {
            this.f15773c.f15761b = 1;
            return 0;
        }
    }

    public final void d() {
        int iC = c();
        this.f15774d = iC;
        if (iC <= 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                i3 = this.f15774d;
                if (i2 >= i3) {
                    return;
                }
                i3 -= i2;
                this.f15772b.get(this.f15771a, i2, i3);
                i2 += i3;
            } catch (Exception e2) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    StringBuilder sbT = b.t(i2, i3, "Error Reading Block n: ", " count: ", " blockSize: ");
                    sbT.append(this.f15774d);
                    Log.d("GifHeaderParser", sbT.toString(), e2);
                }
                this.f15773c.f15761b = 1;
                return;
            }
        }
    }

    public final int[] e(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.f15772b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = bArr[i4] & 255;
                int i6 = i4 + 2;
                int i7 = bArr[i4 + 1] & 255;
                i4 += 3;
                int i8 = i3 + 1;
                iArr[i3] = (i7 << 8) | (i5 << 16) | (-16777216) | (bArr[i6] & 255);
                i3 = i8;
            }
            return iArr;
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f15773c.f15761b = 1;
            return iArr;
        }
    }

    public final void f() {
        int iC;
        do {
            iC = c();
            this.f15772b.position(Math.min(this.f15772b.position() + iC, this.f15772b.limit()));
        } while (iC > 0);
    }
}
