package in.juspay.hypersdk.utils.network;

import android.content.Context;
import in.juspay.airborne.network.NetUtils;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hypersdk.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public class HyperNetUtils extends NetUtils {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static String USER_AGENT;

    @Nullable
    private static final String agent;
    private final int connectionTimeout;

    @NotNull
    private final Context ctx;
    private final int readTimeout;

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
    public HyperNetUtils(@NotNull Context ctx, int i2, int i3, boolean z) {
        super(i2, i3, z);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.ctx = ctx;
        this.connectionTimeout = i2;
        this.readTimeout = i3;
    }

    public final int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    @NotNull
    public final Context getCtx() {
        return this.ctx;
    }

    @Override // in.juspay.airborne.network.NetUtils
    @NotNull
    public Map<String, String> getDefaultSDKHeaders() {
        HashMap map = new HashMap();
        map.put("User-Agent", USER_AGENT);
        map.put("Accept-Language", "en-US,en;q=0.5");
        map.put("X-Powered-By", "Juspay EC SDK for Android");
        String string = this.ctx.getString(R.string.godel_app_name);
        Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(R.string.godel_app_name)");
        map.put("X-App-Name", string);
        String packageName = this.ctx.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "ctx.packageName");
        map.put("Referer", packageName);
        map.put("x-multiclient-integration", String.valueOf(JuspayCoreLib.isMultiClientIntegration()));
        return map;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public /* synthetic */ HyperNetUtils(Context context, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i2, i3, (i4 & 8) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HyperNetUtils(@NotNull Context ctx, int i2, int i3) {
        this(ctx, i2, i3, false);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }
}
