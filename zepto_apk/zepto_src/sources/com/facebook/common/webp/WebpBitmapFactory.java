package com.facebook.common.webp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.infer.annotation.Nullsafe;
import java.io.FileDescriptor;

@Nullsafe
/* loaded from: classes3.dex */
public interface WebpBitmapFactory {

    public interface WebpErrorLogger {
    }

    Bitmap a(FileDescriptor fileDescriptor, BitmapFactory.Options options);
}
