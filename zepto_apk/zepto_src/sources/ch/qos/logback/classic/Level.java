package ch.qos.logback.classic;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import org.apache.commons.codec.language.bm.Rule;

/* loaded from: classes.dex */
public final class Level implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Level f13233c = new Level(Api.BaseClientBuilder.API_PRIORITY_OTHER, "OFF");

    /* renamed from: d, reason: collision with root package name */
    public static final Level f13234d = new Level(40000, MerchantConstants.ERROR);

    /* renamed from: e, reason: collision with root package name */
    public static final Level f13235e = new Level(30000, "WARN");

    /* renamed from: f, reason: collision with root package name */
    public static final Level f13236f = new Level(20000, "INFO");

    /* renamed from: g, reason: collision with root package name */
    public static final Level f13237g = new Level(10000, "DEBUG");

    /* renamed from: h, reason: collision with root package name */
    public static final Level f13238h = new Level(5000, "TRACE");

    /* renamed from: i, reason: collision with root package name */
    public static final Level f13239i = new Level(Integer.MIN_VALUE, Rule.ALL);

    /* renamed from: a, reason: collision with root package name */
    public final int f13240a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13241b;

    public Level(int i2, String str) {
        this.f13240a = i2;
        this.f13241b = str;
    }

    public static Level a(String str) {
        Level level = f13237g;
        if (str != null) {
            if (str.equalsIgnoreCase(Rule.ALL)) {
                return f13239i;
            }
            if (str.equalsIgnoreCase("TRACE")) {
                return f13238h;
            }
            if (str.equalsIgnoreCase("DEBUG")) {
                return level;
            }
            if (str.equalsIgnoreCase("INFO")) {
                return f13236f;
            }
            if (str.equalsIgnoreCase("WARN")) {
                return f13235e;
            }
            if (str.equalsIgnoreCase(MerchantConstants.ERROR)) {
                return f13234d;
            }
            if (str.equalsIgnoreCase("OFF")) {
                return f13233c;
            }
        }
        return level;
    }

    public final String toString() {
        return this.f13241b;
    }
}
