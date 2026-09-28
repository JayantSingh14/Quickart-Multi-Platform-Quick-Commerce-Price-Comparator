package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;

@Deprecated
/* loaded from: classes4.dex */
public abstract class NativeAd {

    @Deprecated
    public static abstract class AdChoicesInfo {
    }

    @Deprecated
    public static abstract class Image {
        public abstract Drawable a();

        public abstract double b();

        public abstract Uri c();

        public int d() {
            return -1;
        }

        public int e() {
            return -1;
        }
    }
}
