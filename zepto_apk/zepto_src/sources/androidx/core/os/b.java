package androidx.core.os;

import android.adservices.adselection.AdSelectionFromOutcomesConfig;
import android.adservices.adselection.GetAdSelectionDataOutcome;
import android.adservices.adselection.GetAdSelectionDataRequest;
import android.adservices.adselection.PersistAdSelectionResultRequest;
import android.adservices.adselection.ReportEventRequest;
import android.adservices.adselection.ReportImpressionRequest;
import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.adservices.signals.UpdateSignalsRequest;
import android.adservices.topics.EncryptedTopic;
import android.net.Uri;
import android.os.ProfilingManager;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ void B() {
    }

    public static /* synthetic */ void C() {
    }

    public static /* synthetic */ void D() {
    }

    public static /* bridge */ /* synthetic */ GetAdSelectionDataOutcome b(Object obj) {
        return (GetAdSelectionDataOutcome) obj;
    }

    public static /* synthetic */ PersistAdSelectionResultRequest.Builder c() {
        return new PersistAdSelectionResultRequest.Builder();
    }

    public static /* synthetic */ ReportEventRequest.Builder f() {
        return new ReportEventRequest.Builder(0L, (String) null, (String) null, 0);
    }

    public static /* synthetic */ ReportImpressionRequest i() {
        return new ReportImpressionRequest(0L);
    }

    public static /* synthetic */ FetchAndJoinCustomAudienceRequest.Builder j() {
        return new FetchAndJoinCustomAudienceRequest.Builder((Uri) null);
    }

    public static /* synthetic */ UpdateSignalsRequest.Builder m() {
        return new UpdateSignalsRequest.Builder((Uri) null);
    }

    public static /* bridge */ /* synthetic */ EncryptedTopic o(Object obj) {
        return (EncryptedTopic) obj;
    }

    public static /* bridge */ /* synthetic */ Class p() {
        return ProfilingManager.class;
    }

    public static /* synthetic */ void r() {
        new AdSelectionFromOutcomesConfig.Builder();
    }

    public static /* synthetic */ void z() {
        new GetAdSelectionDataRequest.Builder();
    }
}
