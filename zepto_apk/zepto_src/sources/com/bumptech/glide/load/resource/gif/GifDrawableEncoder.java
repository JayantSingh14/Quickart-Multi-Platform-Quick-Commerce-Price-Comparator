package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
    @Override // com.bumptech.glide.load.Encoder
    public final boolean a(Object obj, File file, Options options) throws Throwable {
        try {
            ByteBufferUtil.c(((GifDrawable) ((Resource) obj).get()).b(), file);
            return true;
        } catch (IOException e2) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e2);
            return false;
        }
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public final EncodeStrategy b(Options options) {
        return EncodeStrategy.f15798a;
    }
}
