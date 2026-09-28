package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class PackageManagerHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12977a = Logger.g("PackageManagerHelper");

    public static void a(Context context, Class cls, boolean z) {
        String str = f12977a;
        try {
            int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, cls.getName()));
            boolean z2 = false;
            if (componentEnabledSetting != 0 && componentEnabledSetting == 1) {
                z2 = true;
            }
            if (z == z2) {
                Logger.e().a(str, "Skipping component enablement for ".concat(cls.getName()));
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            Logger loggerE = Logger.e();
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(StringUtils.SPACE);
            sb.append(z ? "enabled" : "disabled");
            loggerE.a(str, sb.toString());
        } catch (Exception e2) {
            Logger loggerE2 = Logger.e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            sb2.append(z ? "enabled" : "disabled");
            loggerE2.b(str, sb2.toString(), e2);
        }
    }
}
