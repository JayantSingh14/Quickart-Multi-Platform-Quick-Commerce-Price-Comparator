package androidx.core.view;

import android.net.http.NetworkException;
import android.net.http.UrlResponseInfo;
import android.window.SurfaceSyncGroup;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class j {
    public static /* bridge */ /* synthetic */ NetworkException e(Object obj) {
        return (NetworkException) obj;
    }

    public static /* bridge */ /* synthetic */ UrlResponseInfo i(Object obj) {
        return (UrlResponseInfo) obj;
    }

    public static /* synthetic */ SurfaceSyncGroup j() {
        return new SurfaceSyncGroup("exo-sync-b-334901521");
    }

    public static /* bridge */ /* synthetic */ boolean x(Object obj) {
        return obj instanceof NetworkException;
    }
}
