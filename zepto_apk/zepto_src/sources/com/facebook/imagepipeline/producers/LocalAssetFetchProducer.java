package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class LocalAssetFetchProducer extends LocalFetchProducer {

    /* renamed from: c, reason: collision with root package name */
    public final AssetManager f18204c;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalAssetFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, AssetManager assetManager) {
        super(executor, pooledByteBufferFactory);
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        this.f18204c = assetManager;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage d(ImageRequest imageRequest) throws IOException {
        int length;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        String path = imageRequest.f18348b.getPath();
        Intrinsics.c(path);
        String strSubstring = path.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        AssetManager assetManager = this.f18204c;
        InputStream inputStreamOpen = assetManager.open(strSubstring, 2);
        AssetFileDescriptor assetFileDescriptorOpenFd = null;
        try {
            String path2 = imageRequest.f18348b.getPath();
            Intrinsics.c(path2);
            String strSubstring2 = path2.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            assetFileDescriptorOpenFd = assetManager.openFd(strSubstring2);
            length = (int) assetFileDescriptorOpenFd.getLength();
            try {
                assetFileDescriptorOpenFd.close();
            } catch (IOException unused) {
            }
        } catch (IOException unused2) {
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                } catch (IOException unused3) {
                }
            }
            length = -1;
        } catch (Throwable th) {
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        return c(inputStreamOpen, length);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String e() {
        return "LocalAssetFetchProducer";
    }
}
