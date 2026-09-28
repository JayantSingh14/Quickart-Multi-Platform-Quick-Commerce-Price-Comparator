package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@RestrictTo
/* loaded from: classes3.dex */
public class NetworkFetcher {

    /* renamed from: a, reason: collision with root package name */
    public final NetworkCache f14672a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultLottieNetworkFetcher f14673b;

    /* renamed from: com.airbnb.lottie.network.NetworkFetcher$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14674a;

        static {
            int[] iArr = new int[FileExtension.values().length];
            f14674a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14674a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public NetworkFetcher(NetworkCache networkCache, DefaultLottieNetworkFetcher defaultLottieNetworkFetcher) {
        this.f14672a = networkCache;
        this.f14673b = defaultLottieNetworkFetcher;
    }

    public final LottieResult a(Context context, String str, InputStream inputStream, String str2, String str3) {
        LottieResult lottieResultN;
        FileExtension fileExtension;
        if (str2 == null) {
            str2 = "application/json";
        }
        boolean zContains = str2.contains("application/zip");
        NetworkCache networkCache = this.f14672a;
        if (zContains || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            Logger.a();
            FileExtension fileExtension2 = FileExtension.ZIP;
            lottieResultN = str3 != null ? LottieCompositionFactory.n(context, new ZipInputStream(new FileInputStream(networkCache.d(str, inputStream, fileExtension2))), str) : LottieCompositionFactory.n(context, new ZipInputStream(inputStream), null);
            fileExtension = fileExtension2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            Logger.a();
            fileExtension = FileExtension.GZIP;
            lottieResultN = str3 != null ? LottieCompositionFactory.f(new GZIPInputStream(new FileInputStream(networkCache.d(str, inputStream, fileExtension))), str) : LottieCompositionFactory.f(new GZIPInputStream(inputStream), null);
        } else {
            Logger.a();
            fileExtension = FileExtension.JSON;
            lottieResultN = str3 != null ? LottieCompositionFactory.f(new FileInputStream(networkCache.d(str, inputStream, fileExtension).getAbsolutePath()), str) : LottieCompositionFactory.f(inputStream, null);
        }
        if (str3 != null && lottieResultN.f14191a != null) {
            File file = new File(networkCache.c(), NetworkCache.a(str, fileExtension, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean zRenameTo = file.renameTo(file2);
            file2.toString();
            Logger.a();
            if (!zRenameTo) {
                Logger.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + CLConstants.DOT_SALT_DELIMETER);
            }
        }
        return lottieResultN;
    }
}
