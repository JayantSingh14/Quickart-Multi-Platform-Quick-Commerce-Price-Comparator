package androidx.media3.datasource.cache;

import android.view.View;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.swmansion.reanimated.layoutReanimation.SharedTransitionManager;
import in.juspay.hypersdk.analytics.LogPusherExp;
import io.sentry.ISpan;
import io.sentry.SentryNanotimeDate;
import io.sentry.android.core.SpanFrameMetricsCollector;
import java.io.File;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Comparator;
import org.xbill.DNS.config.BaseResolverConfigProvider;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6041a;

    public /* synthetic */ a(int i2) {
        this.f6041a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f6041a) {
            case 0:
                CacheSpan cacheSpan = (CacheSpan) obj;
                CacheSpan cacheSpan2 = (CacheSpan) obj2;
                long j2 = cacheSpan.f5988f;
                long j3 = cacheSpan2.f5988f;
                return j2 - j3 == 0 ? cacheSpan.compareTo(cacheSpan2) : j2 < j3 ? -1 : 1;
            case 1:
                return ((CrashlyticsReport.CustomAttribute) obj).b().compareTo(((CrashlyticsReport.CustomAttribute) obj2).b());
            case 2:
                Charset charset = CrashlyticsReportPersistence.f44375e;
                String name = ((File) obj).getName();
                int i2 = CrashlyticsReportPersistence.f44376f;
                return name.substring(0, i2).compareTo(((File) obj2).getName().substring(0, i2));
            case 3:
                return SharedTransitionManager.lambda$sortViewsByTags$0((View) obj, (View) obj2);
            case 4:
                return LogPusherExp.lambda$checkFolderLimit$4((File) obj, (File) obj2);
            case 5:
                ISpan iSpan = (ISpan) obj;
                ISpan iSpan2 = (ISpan) obj2;
                SentryNanotimeDate sentryNanotimeDate = SpanFrameMetricsCollector.f52206i;
                int iCompareTo = iSpan.r().compareTo(iSpan2.r());
                return iCompareTo != 0 ? iCompareTo : iSpan.o().f51922b.f51932a.compareTo(iSpan2.o().f51922b.f51932a);
            default:
                return BaseResolverConfigProvider.lambda$servers$0((InetSocketAddress) obj, (InetSocketAddress) obj2);
        }
    }
}
