package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class ImageHeaderParserUtils {

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$4, reason: invalid class name */
    class AnonymousClass4 implements OrientationReader {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f15807a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LruArrayPool f15808b;

        public AnonymousClass4(InputStream inputStream, LruArrayPool lruArrayPool) {
            this.f15807a = inputStream;
            this.f15808b = lruArrayPool;
        }
    }

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$5, reason: invalid class name */
    class AnonymousClass5 implements OrientationReader {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f15809a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LruArrayPool f15810b;

        public AnonymousClass5(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, LruArrayPool lruArrayPool) {
            this.f15809a = parcelFileDescriptorRewinder;
            this.f15810b = lruArrayPool;
        }
    }

    public interface OrientationReader {
    }

    public interface TypeReader {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(LruArrayPool lruArrayPool, InputStream inputStream, ArrayList arrayList) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, lruArrayPool);
        }
        inputStream.mark(5242880);
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(inputStream, lruArrayPool);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser imageHeaderParser = (ImageHeaderParser) arrayList.get(i2);
            InputStream inputStream2 = anonymousClass4.f15807a;
            try {
                int iA = imageHeaderParser.a(inputStream2, anonymousClass4.f15808b);
                if (iA != -1) {
                    return iA;
                }
            } finally {
                inputStream2.reset();
            }
        }
        return -1;
    }

    public static int b(ArrayList arrayList, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, LruArrayPool lruArrayPool) throws Throwable {
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(parcelFileDescriptorRewinder, lruArrayPool);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser imageHeaderParser = (ImageHeaderParser) arrayList.get(i2);
            LruArrayPool lruArrayPool2 = anonymousClass5.f15810b;
            ParcelFileDescriptorRewinder parcelFileDescriptorRewinder2 = anonymousClass5.f15809a;
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder2.a().getFileDescriptor()), lruArrayPool2);
                try {
                    int iA = imageHeaderParser.a(recyclableBufferedInputStream2, lruArrayPool2);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    parcelFileDescriptorRewinder2.a();
                    if (iA != -1) {
                        return iA;
                    }
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    parcelFileDescriptorRewinder2.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType c(LruArrayPool lruArrayPool, final InputStream inputStream, ArrayList arrayList) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, lruArrayPool);
        }
        inputStream.mark(5242880);
        return f(arrayList, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.1
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public final ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
                InputStream inputStream2 = inputStream;
                try {
                    return imageHeaderParser.c(inputStream2);
                } finally {
                    inputStream2.reset();
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType d(ArrayList arrayList, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final LruArrayPool lruArrayPool) {
        return f(arrayList, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.3
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public final ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
                ParcelFileDescriptorRewinder parcelFileDescriptorRewinder2 = parcelFileDescriptorRewinder;
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(parcelFileDescriptorRewinder2.a().getFileDescriptor()), lruArrayPool);
                    try {
                        ImageHeaderParser.ImageType imageTypeC = imageHeaderParser.c(recyclableBufferedInputStream2);
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                        parcelFileDescriptorRewinder2.a();
                        return imageTypeC;
                    } catch (Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            try {
                                recyclableBufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        parcelFileDescriptorRewinder2.a();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType e(ArrayList arrayList, final ByteBuffer byteBuffer) {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : f(arrayList, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.2
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public final ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
                return imageHeaderParser.b(byteBuffer);
            }
        });
    }

    public static ImageHeaderParser.ImageType f(ArrayList arrayList, TypeReader typeReader) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType imageTypeA = typeReader.a((ImageHeaderParser) arrayList.get(i2));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
