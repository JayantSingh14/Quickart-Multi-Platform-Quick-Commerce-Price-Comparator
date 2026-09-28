package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;

/* loaded from: classes3.dex */
public final class MediaStoreUtil {
    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
}
