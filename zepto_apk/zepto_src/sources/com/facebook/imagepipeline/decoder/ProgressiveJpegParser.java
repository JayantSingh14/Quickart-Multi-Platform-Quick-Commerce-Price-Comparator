package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe
/* loaded from: classes3.dex */
public class ProgressiveJpegParser {

    /* renamed from: a, reason: collision with root package name */
    public int f17936a;

    /* renamed from: b, reason: collision with root package name */
    public int f17937b;

    /* renamed from: c, reason: collision with root package name */
    public int f17938c;

    /* renamed from: d, reason: collision with root package name */
    public int f17939d;

    /* renamed from: e, reason: collision with root package name */
    public int f17940e;

    /* renamed from: f, reason: collision with root package name */
    public int f17941f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f17942g;

    /* renamed from: h, reason: collision with root package name */
    public final ByteArrayPool f17943h;

    public ProgressiveJpegParser(ByteArrayPool byteArrayPool) {
        byteArrayPool.getClass();
        this.f17943h = byteArrayPool;
        this.f17938c = 0;
        this.f17937b = 0;
        this.f17939d = 0;
        this.f17941f = 0;
        this.f17940e = 0;
        this.f17936a = 0;
    }

    public final boolean a(PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream) throws Throwable {
        int i2;
        int i3 = this.f17940e;
        while (this.f17936a != 6 && (i2 = pooledByteArrayBufferedInputStream.read()) != -1) {
            try {
                int i4 = this.f17938c;
                this.f17938c = i4 + 1;
                if (this.f17942g) {
                    this.f17936a = 6;
                    this.f17942g = false;
                    return false;
                }
                int i5 = this.f17936a;
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                if (i5 == 4) {
                                    this.f17936a = 5;
                                } else if (i5 != 5) {
                                    Preconditions.e(false);
                                } else {
                                    int i6 = ((this.f17937b << 8) + i2) - 2;
                                    StreamUtil.a(pooledByteArrayBufferedInputStream, i6);
                                    this.f17938c += i6;
                                    this.f17936a = 2;
                                }
                            } else if (i2 == 255) {
                                this.f17936a = 3;
                            } else if (i2 == 0) {
                                this.f17936a = 2;
                            } else if (i2 == 217) {
                                this.f17942g = true;
                                int i7 = i4 - 1;
                                int i8 = this.f17939d;
                                if (i8 > 0) {
                                    this.f17941f = i7;
                                }
                                this.f17939d = i8 + 1;
                                this.f17940e = i8;
                                this.f17936a = 2;
                            } else {
                                if (i2 == 218) {
                                    int i9 = i4 - 1;
                                    int i10 = this.f17939d;
                                    if (i10 > 0) {
                                        this.f17941f = i9;
                                    }
                                    this.f17939d = i10 + 1;
                                    this.f17940e = i10;
                                }
                                if (i2 == 1 || ((i2 >= 208 && i2 <= 215) || i2 == 217 || i2 == 216)) {
                                    this.f17936a = 2;
                                } else {
                                    this.f17936a = 4;
                                }
                            }
                        } else if (i2 == 255) {
                            this.f17936a = 3;
                        }
                    } else if (i2 == 216) {
                        this.f17936a = 2;
                    } else {
                        this.f17936a = 6;
                    }
                } else if (i2 == 255) {
                    this.f17936a = 1;
                } else {
                    this.f17936a = 6;
                }
                this.f17937b = i2;
            } catch (IOException e2) {
                Throwables.b(e2);
                throw new RuntimeException(e2);
            }
        }
        return (this.f17936a == 6 || this.f17940e == i3) ? false : true;
    }

    public final boolean b(EncodedImage encodedImage) {
        if (this.f17936a == 6 || encodedImage.A() <= this.f17938c) {
            return false;
        }
        InputStream inputStreamS = encodedImage.s();
        inputStreamS.getClass();
        ByteArrayPool byteArrayPool = this.f17943h;
        PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(inputStreamS, (byte[]) byteArrayPool.get(16384), byteArrayPool);
        try {
            try {
                StreamUtil.a(pooledByteArrayBufferedInputStream, this.f17938c);
                return a(pooledByteArrayBufferedInputStream);
            } catch (IOException e2) {
                Throwables.b(e2);
                throw new RuntimeException(e2);
            }
        } finally {
            Closeables.b(pooledByteArrayBufferedInputStream);
        }
    }
}
