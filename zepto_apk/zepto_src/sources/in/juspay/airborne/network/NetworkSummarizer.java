package in.juspay.airborne.network;

import android.support.v4.media.a;
import androidx.fragment.app.e;
import com.amazon.identity.auth.device.authorization.RegionUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes4.dex */
public final class NetworkSummarizer {

    @NotNull
    private List<Metric> metrics = new Vector();
    private long totalLatency;

    @Metadata
    public static final class Metric {

        @NotNull
        private final String latency;
        private final int status;

        @NotNull
        private final URL url;

        @Nullable
        private final String xCache;

        public Metric(@NotNull URL url, int i2, @NotNull String latency, @Nullable String str) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(latency, "latency");
            this.url = url;
            this.status = i2;
            this.latency = latency;
            this.xCache = str;
        }

        public static /* synthetic */ Metric copy$default(Metric metric, URL url, int i2, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                url = metric.url;
            }
            if ((i3 & 2) != 0) {
                i2 = metric.status;
            }
            if ((i3 & 4) != 0) {
                str = metric.latency;
            }
            if ((i3 & 8) != 0) {
                str2 = metric.xCache;
            }
            return metric.copy(url, i2, str, str2);
        }

        @NotNull
        public final URL component1() {
            return this.url;
        }

        public final int component2() {
            return this.status;
        }

        @NotNull
        public final String component3() {
            return this.latency;
        }

        @Nullable
        public final String component4() {
            return this.xCache;
        }

        @NotNull
        public final Metric copy(@NotNull URL url, int i2, @NotNull String latency, @Nullable String str) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(latency, "latency");
            return new Metric(url, i2, latency, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Metric)) {
                return false;
            }
            Metric metric = (Metric) obj;
            return Intrinsics.b(this.url, metric.url) && this.status == metric.status && Intrinsics.b(this.latency, metric.latency) && Intrinsics.b(this.xCache, metric.xCache);
        }

        @NotNull
        public final String getLatency() {
            return this.latency;
        }

        public final int getStatus() {
            return this.status;
        }

        @NotNull
        public final URL getUrl() {
            return this.url;
        }

        @Nullable
        public final String getXCache() {
            return this.xCache;
        }

        public int hashCode() {
            int iE = e.e(a.b(this.status, this.url.hashCode() * 31, 31), 31, this.latency);
            String str = this.xCache;
            return iE + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public final JSONObject toJSON() throws JSONException {
            JSONObject jSONObjectPut = new JSONObject().put("url", this.url.toString()).put(CLConstants.OTP_STATUS, this.status).put("latency", this.latency);
            String str = this.xCache;
            if (str == null) {
                str = RegionUtil.REGION_STRING_NA;
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put("x_cache", str);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut2, "JSONObject()\n           …x_cache\", xCache ?: \"NA\")");
            return jSONObjectPut2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("Metric(url=");
            sb.append(this.url);
            sb.append(", status=");
            sb.append(this.status);
            sb.append(", latency=");
            sb.append(this.latency);
            sb.append(", xCache=");
            return e.t(sb, this.xCache, ')');
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Summary {

        @NotNull
        private final String avgLatency;

        @NotNull
        private final List<Metric> metrics;

        @NotNull
        private final String sessionId;

        @NotNull
        private final String updateId;
        private final boolean updated;

        public Summary(@NotNull String avgLatency, @NotNull String sessionId, @NotNull String updateId, @NotNull List<Metric> metrics, boolean z) {
            Intrinsics.checkNotNullParameter(avgLatency, "avgLatency");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(updateId, "updateId");
            Intrinsics.checkNotNullParameter(metrics, "metrics");
            this.avgLatency = avgLatency;
            this.sessionId = sessionId;
            this.updateId = updateId;
            this.metrics = metrics;
            this.updated = z;
        }

        public static /* synthetic */ Summary copy$default(Summary summary, String str, String str2, String str3, List list, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = summary.avgLatency;
            }
            if ((i2 & 2) != 0) {
                str2 = summary.sessionId;
            }
            if ((i2 & 4) != 0) {
                str3 = summary.updateId;
            }
            if ((i2 & 8) != 0) {
                list = summary.metrics;
            }
            if ((i2 & 16) != 0) {
                z = summary.updated;
            }
            boolean z2 = z;
            String str4 = str3;
            return summary.copy(str, str2, str4, list, z2);
        }

        @NotNull
        public final String component1() {
            return this.avgLatency;
        }

        @NotNull
        public final String component2() {
            return this.sessionId;
        }

        @NotNull
        public final String component3() {
            return this.updateId;
        }

        @NotNull
        public final List<Metric> component4() {
            return this.metrics;
        }

        public final boolean component5() {
            return this.updated;
        }

        @NotNull
        public final Summary copy(@NotNull String avgLatency, @NotNull String sessionId, @NotNull String updateId, @NotNull List<Metric> metrics, boolean z) {
            Intrinsics.checkNotNullParameter(avgLatency, "avgLatency");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(updateId, "updateId");
            Intrinsics.checkNotNullParameter(metrics, "metrics");
            return new Summary(avgLatency, sessionId, updateId, metrics, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Summary)) {
                return false;
            }
            Summary summary = (Summary) obj;
            return Intrinsics.b(this.avgLatency, summary.avgLatency) && Intrinsics.b(this.sessionId, summary.sessionId) && Intrinsics.b(this.updateId, summary.updateId) && Intrinsics.b(this.metrics, summary.metrics) && this.updated == summary.updated;
        }

        @NotNull
        public final String getAvgLatency() {
            return this.avgLatency;
        }

        @NotNull
        public final List<Metric> getMetrics() {
            return this.metrics;
        }

        @NotNull
        public final String getSessionId() {
            return this.sessionId;
        }

        @NotNull
        public final String getUpdateId() {
            return this.updateId;
        }

        public final boolean getUpdated() {
            return this.updated;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iF = e.f(e.e(e.e(this.avgLatency.hashCode() * 31, 31, this.sessionId), 31, this.updateId), 31, this.metrics);
            boolean z = this.updated;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return iF + i2;
        }

        @NotNull
        public final JSONObject toJSON() throws JSONException {
            JSONObject jSONObjectPut = new JSONObject().put("avg_latency", this.avgLatency).put("session_id", this.sessionId).put("update_id", this.updateId);
            List<Metric> list = this.metrics;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Metric) it.next()).toJSON());
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put("metrics", arrayList).put("updated", this.updated);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut2, "JSONObject()\n           … .put(\"updated\", updated)");
            return jSONObjectPut2;
        }

        @NotNull
        public String toString() {
            return "Summary(avgLatency=" + this.avgLatency + ", sessionId=" + this.sessionId + ", updateId=" + this.updateId + ", metrics=" + this.metrics + ", updated=" + this.updated + ')';
        }
    }

    public final void addMetric(@NotNull Response response, long j2) {
        Intrinsics.checkNotNullParameter(response, "response");
        URL url = response.f56350a.f56331a.j();
        this.totalLatency += j2;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        Response response2 = response.f56357h;
        int i2 = response2 != null ? response2.f56353d : response.f56353d;
        String str = String.format("%dms", Arrays.copyOf(new Object[]{Long.valueOf(j2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        response.getClass();
        Intrinsics.checkNotNullParameter("x-cache", CLConstants.FIELD_PAY_INFO_NAME);
        this.metrics.add(new Metric(url, i2, str, response.b("x-cache", null)));
    }

    @NotNull
    public final Summary publishSummary(@NotNull String sessionId, @NotNull String updateId, boolean z) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(updateId, "updateId");
        String str = String.format("%dms", Arrays.copyOf(new Object[]{Integer.valueOf(Integer.max(1, (int) (this.totalLatency / this.metrics.size())))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        Summary summary = new Summary(str, sessionId, updateId, this.metrics, z);
        this.metrics = new Vector();
        this.totalLatency = 0L;
        return summary;
    }
}
