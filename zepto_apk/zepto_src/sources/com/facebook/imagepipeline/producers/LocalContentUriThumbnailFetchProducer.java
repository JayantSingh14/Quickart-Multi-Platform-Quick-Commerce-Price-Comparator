package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import com.facebook.infer.annotation.Nullsafe;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

@Nullsafe
/* loaded from: classes3.dex */
public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage> {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f18206d = {"_id", "_data"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f18207e = {"_data"};

    /* renamed from: f, reason: collision with root package name */
    public static final Rect f18208f = new Rect(0, 0, 512, 384);

    /* renamed from: g, reason: collision with root package name */
    public static final Rect f18209g = new Rect(0, 0, 96, 96);

    /* renamed from: c, reason: collision with root package name */
    public final ContentResolver f18210c;

    public LocalContentUriThumbnailFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.f18210c = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public final boolean a(ResizeOptions resizeOptions) {
        Rect rect = f18208f;
        return ThumbnailSizeChecker.a(rect.width(), rect.height(), resizeOptions);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage d(ImageRequest imageRequest) {
        ResizeOptions resizeOptions;
        EncodedImage encodedImageF;
        Uri uri = imageRequest.f18348b;
        Uri uri2 = UriUtil.f17148a;
        String string = uri.toString();
        int iA = 0;
        if ((string.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || string.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString())) && (resizeOptions = imageRequest.f18354h) != null) {
            Cursor cursorQuery = this.f18210c.query(uri, f18206d, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (!cursorQuery.moveToFirst() || (encodedImageF = f(resizeOptions, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")))) == null) {
                        cursorQuery.close();
                        return null;
                    }
                    int columnIndex = cursorQuery.getColumnIndex("_data");
                    if (columnIndex >= 0) {
                        String string2 = cursorQuery.getString(columnIndex);
                        if (string2 != null) {
                            try {
                                iA = JfifUtil.a(new ExifInterface(string2).getAttributeInt("Orientation", 1));
                            } catch (IOException e2) {
                                if (FLog.f17086a.a(6)) {
                                    FLogDefaultLoggingDelegate.c(6, "LocalContentUriThumbnailFetchProducer", "Unable to retrieve thumbnail rotation for ".concat(string2), e2);
                                }
                            }
                        }
                        encodedImageF.f17958c = iA;
                    }
                    cursorQuery.close();
                    return encodedImageF;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
        }
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String e() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    public final EncodedImage f(ResizeOptions resizeOptions, long j2) {
        int i2;
        int columnIndex;
        Rect rect = f18209g;
        if (ThumbnailSizeChecker.a(rect.width(), rect.height(), resizeOptions)) {
            i2 = 3;
        } else {
            Rect rect2 = f18208f;
            i2 = ThumbnailSizeChecker.a(rect2.width(), rect2.height(), resizeOptions) ? 1 : 0;
        }
        if (i2 != 0) {
            Cursor cursorQueryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.f18210c, j2, i2, f18207e);
            if (cursorQueryMiniThumbnail != null) {
                try {
                    if (cursorQueryMiniThumbnail.moveToFirst() && (columnIndex = cursorQueryMiniThumbnail.getColumnIndex("_data")) >= 0) {
                        String string = cursorQueryMiniThumbnail.getString(columnIndex);
                        string.getClass();
                        if (new File(string).exists()) {
                            return c(new FileInputStream(string), (int) new File(string).length());
                        }
                    }
                    return null;
                } finally {
                    cursorQueryMiniThumbnail.close();
                }
            }
        }
        return null;
    }
}
