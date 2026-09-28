package in.juspay.airborne.network;

import android.content.Context;
import in.juspay.airborne.R;
import in.juspay.airborne.services.Workspace;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class OTANetUtils extends NetUtils {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static String USER_AGENT;

    @Nullable
    private static final String agent;

    @NotNull
    private final String appVersion;

    @NotNull
    private final String clientId;

    @NotNull
    private final Context ctx;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String property = System.getProperty("http.agent");
        agent = property;
        if (property == null || property.length() == 0) {
            property = "Juspay Express Checkout Android SDK";
        }
        USER_AGENT = property;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OTANetUtils(@NotNull Context ctx, @NotNull String clientId, @NotNull String appVersion, int i2, int i3, boolean z) {
        super(i2, i3, z);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        this.ctx = ctx;
        this.clientId = clientId;
        this.appVersion = appVersion;
    }

    @NotNull
    public final String getClientId() {
        return this.clientId;
    }

    @NotNull
    public final Context getCtx() {
        return this.ctx;
    }

    @Override // in.juspay.airborne.network.NetUtils
    @NotNull
    public Map<String, String> getDefaultSDKHeaders() {
        String string;
        HashMap map = new HashMap();
        map.put("User-Agent", USER_AGENT);
        map.put("Accept-Language", "en-US,en;q=0.5");
        map.put("X-Powered-By", "Juspay Airborne Android");
        map.put("X-App-Name", "Airborne");
        String packageName = this.ctx.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "ctx.packageName");
        map.put("Referer", packageName);
        map.put("x-client-id", this.clientId);
        Context ctx = Workspace.Companion.getCtx();
        if (ctx == null || (string = ctx.getString(R.string.airborne_version)) == null) {
            string = "undefined";
        }
        map.put("x-airborne-version", string);
        return map;
    }

    public /* synthetic */ OTANetUtils(Context context, String str, String str2, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, i2, i3, (i4 & 32) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OTANetUtils(@NotNull Context ctx, @NotNull String clientId, @NotNull String appVersion) {
        this(ctx, clientId, appVersion, 0, 0, false);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
    }
}
