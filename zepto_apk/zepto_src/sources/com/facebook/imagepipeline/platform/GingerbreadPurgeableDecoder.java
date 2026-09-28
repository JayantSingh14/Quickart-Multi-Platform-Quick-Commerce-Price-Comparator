package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.webpsupport.WebpBitmapFactoryImpl;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

@DoNotStrip
@Nullsafe
/* loaded from: classes3.dex */
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {

    /* renamed from: d, reason: collision with root package name */
    public static Method f18077d;

    /* renamed from: c, reason: collision with root package name */
    public final WebpBitmapFactory f18078c;

    @DoNotStrip
    public GingerbreadPurgeableDecoder() {
        WebpBitmapFactory webpBitmapFactory = null;
        if (!WebpSupportStatus.f17149a) {
            try {
                webpBitmapFactory = (WebpBitmapFactory) WebpBitmapFactoryImpl.class.newInstance();
            } catch (Throwable unused) {
            }
            WebpSupportStatus.f17149a = true;
        }
        this.f18078c = webpBitmapFactory;
    }

    public static MemoryFile g(CloseableReference closeableReference, int i2, byte[] bArr) throws Throwable {
        OutputStream outputStream;
        LimitedInputStream limitedInputStream;
        PooledByteBufferInputStream pooledByteBufferInputStream = null;
        OutputStream outputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i2);
        memoryFile.allowPurging(false);
        try {
            PooledByteBufferInputStream pooledByteBufferInputStream2 = new PooledByteBufferInputStream((PooledByteBuffer) closeableReference.l());
            try {
                limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream2, i2);
                try {
                    outputStream2 = memoryFile.getOutputStream();
                    outputStream2.getClass();
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int i3 = limitedInputStream.read(bArr2);
                        if (i3 == -1) {
                            break;
                        }
                        outputStream2.write(bArr2, 0, i3);
                    }
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i2, bArr.length);
                    }
                    closeableReference.close();
                    Closeables.b(pooledByteBufferInputStream2);
                    Closeables.b(limitedInputStream);
                    Closeables.a(outputStream2);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    pooledByteBufferInputStream = pooledByteBufferInputStream2;
                    closeableReference.close();
                    Closeables.b(pooledByteBufferInputStream);
                    Closeables.b(limitedInputStream);
                    Closeables.a(outputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                limitedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            limitedInputStream = null;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public final Bitmap c(CloseableReference closeableReference, BitmapFactory.Options options) {
        return h(closeableReference, ((PooledByteBuffer) closeableReference.l()).size(), null, options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public final Bitmap d(CloseableReference closeableReference, int i2, BitmapFactory.Options options) {
        return h(closeableReference, i2, DalvikPurgeableDecoder.e(closeableReference, i2) ? null : DalvikPurgeableDecoder.f18062b, options);
    }

    public final Bitmap h(CloseableReference closeableReference, int i2, byte[] bArr, BitmapFactory.Options options) {
        MemoryFile memoryFile = null;
        try {
            try {
                MemoryFile memoryFileG = g(closeableReference, i2, bArr);
                FileDescriptor fileDescriptorI = i(memoryFileG);
                WebpBitmapFactory webpBitmapFactory = this.f18078c;
                if (webpBitmapFactory == null) {
                    throw new IllegalStateException("WebpBitmapFactory is null");
                }
                Bitmap bitmapA = webpBitmapFactory.a(fileDescriptorI, options);
                Preconditions.d(bitmapA, "BitmapFactory returned null");
                memoryFileG.close();
                return bitmapA;
            } catch (IOException e2) {
                Throwables.b(e2);
                throw new RuntimeException(e2);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                memoryFile.close();
            }
            throw th;
        }
    }

    public final FileDescriptor i(MemoryFile memoryFile) throws Throwable {
        Method method;
        try {
            synchronized (this) {
                if (f18077d == null) {
                    try {
                        f18077d = MemoryFile.class.getDeclaredMethod("getFileDescriptor", null);
                    } catch (Exception e2) {
                        Throwables.b(e2);
                        throw new RuntimeException(e2);
                    }
                }
                method = f18077d;
            }
            Object objInvoke = method.invoke(memoryFile, null);
            objInvoke.getClass();
            return (FileDescriptor) objInvoke;
        } catch (Exception e3) {
            Throwables.b(e3);
            throw new RuntimeException(e3);
        }
    }
}
