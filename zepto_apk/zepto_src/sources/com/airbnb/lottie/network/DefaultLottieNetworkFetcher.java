package com.airbnb.lottie.network;

import androidx.annotation.RestrictTo;
import coil3.network.internal.UtilsKt;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@RestrictTo
/* loaded from: classes3.dex */
public class DefaultLottieNetworkFetcher implements LottieNetworkFetcher {
    public final DefaultLottieFetchResult a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(UtilsKt.HTTP_METHOD_GET);
        httpURLConnection.connect();
        return new DefaultLottieFetchResult(httpURLConnection);
    }
}
