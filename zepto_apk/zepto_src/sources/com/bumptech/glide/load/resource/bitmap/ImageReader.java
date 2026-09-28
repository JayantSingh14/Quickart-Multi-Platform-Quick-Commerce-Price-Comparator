package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes3.dex */
interface ImageReader {

    public static final class InputStreamImageReader implements ImageReader {

        /* renamed from: a, reason: collision with root package name */
        public final InputStreamRewinder f16298a;

        /* renamed from: b, reason: collision with root package name */
        public final LruArrayPool f16299b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f16300c;

        public InputStreamImageReader(LruArrayPool lruArrayPool, InputStream inputStream, ArrayList arrayList) {
            Preconditions.c(lruArrayPool, "Argument must not be null");
            this.f16299b = lruArrayPool;
            Preconditions.c(arrayList, "Argument must not be null");
            this.f16300c = arrayList;
            this.f16298a = new InputStreamRewinder(inputStream, lruArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final Bitmap a(BitmapFactory.Options options) {
            RecyclableBufferedInputStream recyclableBufferedInputStream = this.f16298a.f15840a;
            recyclableBufferedInputStream.reset();
            return BitmapFactory.decodeStream(recyclableBufferedInputStream, null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final void b() {
            RecyclableBufferedInputStream recyclableBufferedInputStream = this.f16298a.f15840a;
            synchronized (recyclableBufferedInputStream) {
                recyclableBufferedInputStream.f16310c = recyclableBufferedInputStream.f16308a.length;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final int c() {
            RecyclableBufferedInputStream recyclableBufferedInputStream = this.f16298a.f15840a;
            recyclableBufferedInputStream.reset();
            return ImageHeaderParserUtils.a(this.f16299b, recyclableBufferedInputStream, this.f16300c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final ImageHeaderParser.ImageType d() {
            RecyclableBufferedInputStream recyclableBufferedInputStream = this.f16298a.f15840a;
            recyclableBufferedInputStream.reset();
            return ImageHeaderParserUtils.c(this.f16299b, recyclableBufferedInputStream, this.f16300c);
        }
    }

    @RequiresApi
    public static final class ParcelFileDescriptorImageReader implements ImageReader {

        /* renamed from: a, reason: collision with root package name */
        public final LruArrayPool f16301a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f16302b;

        /* renamed from: c, reason: collision with root package name */
        public final ParcelFileDescriptorRewinder f16303c;

        public ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, LruArrayPool lruArrayPool) {
            Preconditions.c(lruArrayPool, "Argument must not be null");
            this.f16301a = lruArrayPool;
            Preconditions.c(arrayList, "Argument must not be null");
            this.f16302b = arrayList;
            this.f16303c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.f16303c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final void b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final int c() {
            return ImageHeaderParserUtils.b(this.f16302b, this.f16303c, this.f16301a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final ImageHeaderParser.ImageType d() {
            return ImageHeaderParserUtils.d(this.f16302b, this.f16303c, this.f16301a);
        }
    }

    Bitmap a(BitmapFactory.Options options);

    void b();

    int c();

    ImageHeaderParser.ImageType d();
}
