package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.measurement.DeletionRequest;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ void B() {
    }

    public static /* synthetic */ void D() {
    }

    public static /* synthetic */ CustomAudience.Builder c() {
        return new CustomAudience.Builder();
    }

    public static /* synthetic */ DeletionRequest.Builder d() {
        return new DeletionRequest.Builder();
    }

    public static /* synthetic */ GetTopicsRequest.Builder h() {
        return new GetTopicsRequest.Builder();
    }

    public static /* bridge */ /* synthetic */ GetTopicsResponse l(Object obj) {
        return (GetTopicsResponse) obj;
    }

    public static /* bridge */ /* synthetic */ Topic m(Object obj) {
        return (Topic) obj;
    }

    public static /* bridge */ /* synthetic */ TopicsManager o(Object obj) {
        return (TopicsManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class p() {
        return TopicsManager.class;
    }

    public static /* synthetic */ void r() {
        new LeaveCustomAudienceRequest.Builder();
    }

    public static /* synthetic */ void z() {
        new JoinCustomAudienceRequest.Builder();
    }
}
