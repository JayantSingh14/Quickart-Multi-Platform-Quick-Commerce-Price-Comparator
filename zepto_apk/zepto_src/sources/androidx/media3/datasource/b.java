package androidx.media3.datasource;

import PrefetchAgreementWallet.PrefetchAgreementWalletInterface;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import com.amazon.android.apay.commonlibrary.commonlib.manager.PaymentMetaDataManager;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.google.common.base.Supplier;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.juspay.airborne.ota.ReleaseConfig;
import in.juspay.airborne.ota.UpdateTask;
import io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule;
import io.sentry.ISerializer;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryEnvelopeItem;
import io.sentry.clientreport.ClientReport;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5947a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5948b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5949c;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f5947a = i2;
        this.f5948b = obj;
        this.f5949c = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        Integer num;
        Integer num2;
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedWriter bufferedWriter;
        Object obj = this.f5949c;
        Object obj2 = this.f5948b;
        switch (this.f5947a) {
            case 0:
                Supplier supplier = DataSourceBitmapLoader.f5841c;
                ((DataSourceBitmapLoader) obj2).getClass();
                byte[] bArr = (byte[]) obj;
                return BitmapUtil.a(bArr.length, bArr);
            case 1:
                Uri uri = (Uri) obj;
                DataSource dataSourceA = ((DataSourceBitmapLoader) obj2).f5843b.a();
                try {
                    DataSpec dataSpec = new DataSpec(uri);
                    DefaultDataSource defaultDataSource = (DefaultDataSource) dataSourceA;
                    defaultDataSource.j(dataSpec);
                    byte[] bArrB = DataSourceUtil.b(dataSourceA);
                    Bitmap bitmapA = BitmapUtil.a(bArrB.length, bArrB);
                    defaultDataSource.close();
                    return bitmapA;
                } catch (Throwable th) {
                    ((DefaultDataSource) dataSourceA).close();
                    throw th;
                }
            case 2:
                return PaymentMetaDataManager.a((PaymentMetaDataManager) obj2, (Activity) obj);
            case 3:
                PrefetchAgreementWalletInterface prefetchAgreementWalletInterface = com.amazon.android.apay.commonlibrary.commonlib.service.a.f14871c;
                com.amazon.android.apay.commonlibrary.interfaces.model.c mshopDetails = (com.amazon.android.apay.commonlibrary.interfaces.model.c) obj2;
                Intrinsics.checkNotNullParameter(mshopDetails, "$mshopPackageDetails");
                com.amazon.android.apay.commonlibrary.commonlib.service.a this$0 = (com.amazon.android.apay.commonlibrary.commonlib.service.a) obj;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(mshopDetails, "mshopDetails");
                String str = "";
                if (mshopDetails.f14956a && (num = mshopDetails.f14957b) != null && num.intValue() >= 26 && (num.intValue() != 26 || ((num2 = mshopDetails.f14958c) != null && num2.intValue() >= 22))) {
                    com.amazon.android.apay.commonlibrary.commonlib.utils.b.f14879a.getClass();
                    try {
                        PrefetchAgreementWalletInterface prefetchAgreementWalletInterface2 = com.amazon.android.apay.commonlibrary.commonlib.service.a.f14871c;
                        String strA = prefetchAgreementWalletInterface2 != null ? prefetchAgreementWalletInterface2.a() : null;
                        if (strA != null) {
                            str = strA;
                        }
                    } catch (Exception e2) {
                        StackTraceElement[] stackTrace = e2.getStackTrace();
                        Intrinsics.checkNotNullExpressionValue(stackTrace, "exception.stackTrace");
                        InstrumentUtil.addMetricEvent$default("Error", "IncompatibleMShopVersion", "getDeviceDetailsMshopNotInstalled", ArraysKt.F(stackTrace).toString(), (String) null, 16, (Object) null);
                    }
                } else {
                    InstrumentUtil.addMetricEvent$default("getDeviceDetailsMshopNotInstalled", "BoundService", null, 4, null);
                }
                this$0.f14874a.getSharedPreferences("AMAZON_DEVICE_DETAILS_FILE", 0).edit().putString("AMAZON_DEVICE_DETAILS", str).apply();
                return str;
            case 4:
                BufferedDiskCache this$02 = (BufferedDiskCache) obj2;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                CacheKey key = (CacheKey) obj;
                Intrinsics.checkNotNullParameter(key, "$key");
                try {
                    this$02.f17736g.d(key);
                    this$02.f17730a.f(key);
                    return null;
                } catch (Throwable th2) {
                    Intrinsics.checkNotNullParameter(th2, "th");
                    throw th2;
                }
            case 5:
                throw null;
            case 6:
                return UpdateTask.runInternal$lambda$2((UpdateTask) obj2, (ReleaseConfig) obj);
            case 7:
                FirebaseAnalytics.getInstance(((UniversalFirebaseAnalyticsModule) obj2).f49247a).f43527a.t((String) obj);
                return null;
            case 8:
                ISerializer iSerializer = (ISerializer) obj2;
                SentryBaseEvent sentryBaseEvent = (SentryBaseEvent) obj;
                Charset charset = SentryEnvelopeItem.f51819d;
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, SentryEnvelopeItem.f51819d));
                    try {
                        iSerializer.e(sentryBaseEvent, bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        return byteArray;
                    } finally {
                        try {
                            bufferedWriter.close();
                            throw th;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                } finally {
                }
            default:
                ISerializer iSerializer2 = (ISerializer) obj2;
                ClientReport clientReport = (ClientReport) obj;
                Charset charset2 = SentryEnvelopeItem.f51819d;
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, SentryEnvelopeItem.f51819d));
                    try {
                        iSerializer2.e(clientReport, bufferedWriter);
                        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        return byteArray2;
                    } finally {
                    }
                } finally {
                }
        }
    }
}
