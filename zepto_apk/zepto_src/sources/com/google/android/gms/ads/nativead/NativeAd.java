package com.google.android.gms.ads.nativead;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class NativeAd {

    public static abstract class AdChoicesInfo {
    }

    public static abstract class Image {

        /* renamed from: a, reason: collision with root package name */
        public Map f21720a;
    }

    public interface OnNativeAdLoadedListener {
    }

    public interface UnconfirmedClickListener {
    }

    public abstract String a();

    public abstract String b();

    public abstract ResponseInfo c();

    public abstract IObjectWrapper d();

    @KeepForSdk
    public abstract void recordEvent(@NonNull Bundle bundle);
}
