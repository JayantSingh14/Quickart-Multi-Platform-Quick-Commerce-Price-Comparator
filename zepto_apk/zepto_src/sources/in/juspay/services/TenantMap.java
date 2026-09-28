package in.juspay.services;

import in.juspay.hypersdk.core.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'GLOBAL' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata
/* loaded from: classes4.dex */
public final class TenantMap {
    private static final /* synthetic */ TenantMap[] $VALUES;
    public static final TenantMap DEFAULT;
    public static final TenantMap GLOBAL;

    @Nullable
    private final JSONObject logsEndPoints;

    @NotNull
    private final String releaseConfigTemplateUrl;

    @NotNull
    private final String tenant;

    private static final /* synthetic */ TenantMap[] $values() {
        return new TenantMap[]{GLOBAL, DEFAULT};
    }

    static {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sandboxLogUrl", "https://debug.logs.juspay.net/godel/analytics");
        jSONObject.put("prodLogUrl", "https://logs.juspay.io/godel/analytics");
        Unit unit = Unit.f53572a;
        GLOBAL = new TenantMap("GLOBAL", 0, "juspayglobal", "https://payments.%sjuspay.io/hyper/bundles/in.juspay.merchants/%s/android/%s/release-config-v2.json?toss=%s", jSONObject);
        DEFAULT = new TenantMap("DEFAULT", 1, "juspay", Constants.RELEASE_CONFIG_TEMPLATE_URL, null);
        $VALUES = $values();
    }

    private TenantMap(String str, int i2, String str2, String str3, JSONObject jSONObject) {
        this.tenant = str2;
        this.releaseConfigTemplateUrl = str3;
        this.logsEndPoints = jSONObject;
    }

    public static TenantMap valueOf(String str) {
        return (TenantMap) Enum.valueOf(TenantMap.class, str);
    }

    public static TenantMap[] values() {
        return (TenantMap[]) $VALUES.clone();
    }

    @Nullable
    public final JSONObject getLogsEndPoints() {
        return this.logsEndPoints;
    }

    @NotNull
    public final String getReleaseConfigTemplateUrl() {
        return this.releaseConfigTemplateUrl;
    }

    @NotNull
    public final String getTenant() {
        return this.tenant;
    }
}
