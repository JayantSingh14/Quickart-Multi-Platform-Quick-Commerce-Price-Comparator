package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class LocalContentUriFetchProducer extends LocalFetchProducer {

    /* renamed from: c, reason: collision with root package name */
    public final ContentResolver f18205c;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.f18205c = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage d(ImageRequest imageRequest) throws IOException {
        EncodedImage encodedImageC;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        InputStream inputStreamCreateInputStream;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Uri uri = imageRequest.f18348b;
        Intrinsics.checkNotNullExpressionValue(uri, "getSourceUri(...)");
        Uri uri2 = UriUtil.f17148a;
        String path = uri.getPath();
        ContentResolver contentResolver = this.f18205c;
        if (path == null || !UriUtil.d(uri) || !"com.android.contacts".equals(uri.getAuthority()) || uri.getPath().startsWith(UriUtil.f17148a.getPath())) {
            String string = uri.toString();
            if (string.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || string.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString())) {
                try {
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                } catch (FileNotFoundException unused) {
                    encodedImageC = null;
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                encodedImageC = c(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), (int) parcelFileDescriptorOpenFileDescriptor.getStatSize());
                Intrinsics.checkNotNullExpressionValue(encodedImageC, "getEncodedImage(...)");
                parcelFileDescriptorOpenFileDescriptor.close();
                if (encodedImageC != null) {
                    return encodedImageC;
                }
            }
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                return c(inputStreamOpenInputStream, -1);
            }
            throw new IllegalStateException("Required value was null.");
        }
        String string2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        if (StringsKt.r(string2, "/photo", false)) {
            inputStreamCreateInputStream = contentResolver.openInputStream(uri);
        } else {
            String string3 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
            if (StringsKt.r(string3, "/display_photo", false)) {
                try {
                    AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                    if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    inputStreamCreateInputStream = assetFileDescriptorOpenAssetFileDescriptor.createInputStream();
                } catch (IOException unused2) {
                    throw new IOException(android.support.v4.media.a.l(uri, "Contact photo does not exist: "));
                }
            } else {
                InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
                if (inputStreamOpenContactPhotoInputStream == null) {
                    throw new IOException(android.support.v4.media.a.l(uri, "Contact photo does not exist: "));
                }
                inputStreamCreateInputStream = inputStreamOpenContactPhotoInputStream;
            }
        }
        if (inputStreamCreateInputStream != null) {
            return c(inputStreamCreateInputStream, -1);
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String e() {
        return "LocalContentUriFetchProducer";
    }
}
