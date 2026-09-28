package com.reactnativecommunity.webview;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class RNCWebViewManagerImpl$setupWebChromeClient$1 extends RNCWebChromeClient {
    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
    }
}
