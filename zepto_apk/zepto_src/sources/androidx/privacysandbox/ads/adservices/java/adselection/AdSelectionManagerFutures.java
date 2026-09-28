package androidx.privacysandbox.ads.adservices.java.adselection;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportEventRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.adselection.UpdateAdCounterHistogramRequest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public abstract class AdSelectionManagerFutures {

    @Metadata
    public static final class Api33Ext4JavaImpl extends AdSelectionManagerFutures {
        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<GetAdSelectionDataOutcome> a(@NotNull GetAdSelectionDataRequest getAdSelectionDataRequest) {
            Intrinsics.checkNotNullParameter(getAdSelectionDataRequest, "getAdSelectionDataRequest");
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$getAdSelectionDataAsync$1(this, getAdSelectionDataRequest, null), 3));
        }

        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<AdSelectionOutcome> b(@NotNull PersistAdSelectionResultRequest persistAdSelectionResultRequest) {
            Intrinsics.checkNotNullParameter(persistAdSelectionResultRequest, "persistAdSelectionResultRequest");
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(this, persistAdSelectionResultRequest, null), 3));
        }

        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<Unit> c(@NotNull ReportEventRequest reportEventRequest) {
            Intrinsics.checkNotNullParameter(reportEventRequest, "reportEventRequest");
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1(this, reportEventRequest, null), 3));
        }

        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<Unit> d(@NotNull ReportImpressionRequest reportImpressionRequest) {
            Intrinsics.checkNotNullParameter(reportImpressionRequest, "reportImpressionRequest");
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1(this, reportImpressionRequest, null), 3));
        }

        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<AdSelectionOutcome> e(@NotNull AdSelectionConfig adSelectionConfig) {
            Intrinsics.checkNotNullParameter(adSelectionConfig, "adSelectionConfig");
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$1(this, adSelectionConfig, null), 3));
        }

        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<AdSelectionOutcome> f(@NotNull AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig) {
            Intrinsics.checkNotNullParameter(adSelectionFromOutcomesConfig, "adSelectionFromOutcomesConfig");
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2(this, adSelectionFromOutcomesConfig, null), 3));
        }

        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<Unit> g(@NotNull UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest) {
            Intrinsics.checkNotNullParameter(updateAdCounterHistogramRequest, "updateAdCounterHistogramRequest");
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$updateAdCounterHistogramAsync$1(this, updateAdCounterHistogramRequest, null), 3));
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }
}
