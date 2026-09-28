package com.facebook.imagepipeline.image;

import android.graphics.ColorSpace;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.Immutable;

@Nullsafe
@Immutable
/* loaded from: classes3.dex */
public class EncodedImage implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final CloseableReference f17956a;

    /* renamed from: b, reason: collision with root package name */
    public ImageFormat f17957b = ImageFormat.f17694c;

    /* renamed from: c, reason: collision with root package name */
    public int f17958c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f17959d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f17960e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f17961f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f17962g = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f17963h = -1;

    /* renamed from: i, reason: collision with root package name */
    public BytesRange f17964i;

    /* renamed from: j, reason: collision with root package name */
    public ColorSpace f17965j;

    /* renamed from: k, reason: collision with root package name */
    public String f17966k;

    public EncodedImage(CloseableReference closeableReference) {
        if (!CloseableReference.A(closeableReference)) {
            throw new IllegalArgumentException();
        }
        this.f17956a = closeableReference.clone();
    }

    public static boolean O(EncodedImage encodedImage) {
        return encodedImage.f17958c >= 0 && encodedImage.f17960e >= 0 && encodedImage.f17961f >= 0;
    }

    public static boolean V(EncodedImage encodedImage) {
        return encodedImage != null && encodedImage.T();
    }

    public static EncodedImage a(EncodedImage encodedImage) throws IOException {
        EncodedImage encodedImage2 = null;
        if (encodedImage == null) {
            return null;
        }
        CloseableReference closeableReferenceC = CloseableReference.c(encodedImage.f17956a);
        if (closeableReferenceC != null) {
            try {
                encodedImage2 = new EncodedImage(closeableReferenceC);
            } catch (Throwable th) {
                closeableReferenceC.close();
                throw th;
            }
        }
        CloseableReference.e(closeableReferenceC);
        if (encodedImage2 != null) {
            encodedImage2.c(encodedImage);
        }
        return encodedImage2;
    }

    public static void b(EncodedImage encodedImage) {
        if (encodedImage != null) {
            encodedImage.close();
        }
    }

    public final int A() {
        CloseableReference closeableReference = this.f17956a;
        if (closeableReference == null) {
            return this.f17963h;
        }
        closeableReference.l();
        return ((PooledByteBuffer) closeableReference.l()).size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x01ba, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x008b -> B:141:0x0147). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.EncodedImage.D():void");
    }

    public final int H0() throws IOException {
        Z();
        return this.f17959d;
    }

    public final boolean N(int i2) {
        ImageFormat imageFormat = this.f17957b;
        if (imageFormat == DefaultImageFormats.f17681a || imageFormat == DefaultImageFormats.f17692l) {
            CloseableReference closeableReference = this.f17956a;
            closeableReference.getClass();
            PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) closeableReference.l();
            if (i2 < 2 || pooledByteBuffer.q(i2 - 2) != -1 || pooledByteBuffer.q(i2 - 1) != -39) {
                return false;
            }
        }
        return true;
    }

    public final synchronized boolean T() {
        return CloseableReference.A(this.f17956a);
    }

    public final int X0() throws IOException {
        Z();
        return this.f17958c;
    }

    public final void Z() throws IOException {
        if (this.f17960e < 0 || this.f17961f < 0) {
            D();
        }
    }

    public final void c(EncodedImage encodedImage) throws IOException {
        encodedImage.Z();
        this.f17957b = encodedImage.f17957b;
        encodedImage.Z();
        this.f17960e = encodedImage.f17960e;
        encodedImage.Z();
        this.f17961f = encodedImage.f17961f;
        encodedImage.Z();
        this.f17958c = encodedImage.f17958c;
        encodedImage.Z();
        this.f17959d = encodedImage.f17959d;
        this.f17962g = encodedImage.f17962g;
        this.f17963h = encodedImage.A();
        this.f17964i = encodedImage.f17964i;
        encodedImage.Z();
        this.f17965j = encodedImage.f17965j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        CloseableReference.e(this.f17956a);
    }

    public final ColorSpace e() throws IOException {
        Z();
        return this.f17965j;
    }

    public final int getHeight() throws IOException {
        Z();
        return this.f17961f;
    }

    public final int getWidth() throws IOException {
        Z();
        return this.f17960e;
    }

    public final void j0(ImageFormat imageFormat) {
        this.f17957b = imageFormat;
    }

    public final String l() {
        CloseableReference closeableReferenceC = CloseableReference.c(this.f17956a);
        if (closeableReferenceC == null) {
            return "";
        }
        int iMin = Math.min(A(), 10);
        byte[] bArr = new byte[iMin];
        try {
            ((PooledByteBuffer) closeableReferenceC.l()).u(0, 0, bArr, iMin);
            closeableReferenceC.close();
            StringBuilder sb = new StringBuilder(iMin * 2);
            for (int i2 = 0; i2 < iMin; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } catch (Throwable th) {
            closeableReferenceC.close();
            throw th;
        }
    }

    public final ImageFormat r() throws IOException {
        Z();
        return this.f17957b;
    }

    public final InputStream s() {
        CloseableReference closeableReferenceC = CloseableReference.c(this.f17956a);
        if (closeableReferenceC == null) {
            return null;
        }
        try {
            return new PooledByteBufferInputStream((PooledByteBuffer) closeableReferenceC.l());
        } finally {
            closeableReferenceC.close();
        }
    }

    public final int x() {
        return this.f17962g;
    }
}
