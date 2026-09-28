package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.io.ByteArrayInputStream;

@Nullsafe
/* loaded from: classes3.dex */
public class DataFetchProducer extends LocalFetchProducer {
    public DataFetchProducer(PooledByteBufferFactory pooledByteBufferFactory) {
        super(CallerThreadExecutor.f17069a, pooledByteBufferFactory);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage d(ImageRequest imageRequest) {
        boolean zEquals;
        byte[] bytes;
        String string = imageRequest.f18348b.toString();
        if (!string.substring(0, 5).equals("data:")) {
            throw new IllegalArgumentException();
        }
        int iIndexOf = string.indexOf(44);
        String strSubstring = string.substring(iIndexOf + 1, string.length());
        String strSubstring2 = string.substring(0, iIndexOf);
        if (strSubstring2.contains(";")) {
            zEquals = strSubstring2.split(";")[r5.length - 1].equals("base64");
        } else {
            zEquals = false;
        }
        if (zEquals) {
            bytes = Base64.decode(strSubstring, 0);
        } else {
            String strDecode = Uri.decode(strSubstring);
            strDecode.getClass();
            bytes = strDecode.getBytes();
        }
        return c(new ByteArrayInputStream(bytes), bytes.length);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String e() {
        return "DataFetchProducer";
    }
}
