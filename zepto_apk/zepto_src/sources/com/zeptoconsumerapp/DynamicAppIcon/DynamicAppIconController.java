package com.zeptoconsumerapp.DynamicAppIcon;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.media.b;
import bridges.CommsModule;
import com.zeptoconsumerapp.Utils;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public class DynamicAppIconController {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f47395a = {"MainActivity", "APP_ICON_CAMPAIGN_1", "APP_ICON_CAMPAIGN_2"};

    /* renamed from: b, reason: collision with root package name */
    public final String[] f47396b = {"Home", "CategoryList"};

    /* renamed from: c, reason: collision with root package name */
    public final String[] f47397c = new String[0];

    /* renamed from: d, reason: collision with root package name */
    public final Context f47398d;

    /* renamed from: e, reason: collision with root package name */
    public final SharedPreferences f47399e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes4.dex */
    public static final class ACTIVITY_STATE {

        /* renamed from: a, reason: collision with root package name */
        public static final ACTIVITY_STATE f47400a;

        /* renamed from: b, reason: collision with root package name */
        public static final ACTIVITY_STATE f47401b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ ACTIVITY_STATE[] f47402c;

        static {
            ACTIVITY_STATE activity_state = new ACTIVITY_STATE("Enabled", 0);
            f47400a = activity_state;
            ACTIVITY_STATE activity_state2 = new ACTIVITY_STATE("Disabled", 1);
            f47401b = activity_state2;
            f47402c = new ACTIVITY_STATE[]{activity_state, activity_state2};
        }

        public static ACTIVITY_STATE valueOf(String str) {
            return (ACTIVITY_STATE) Enum.valueOf(ACTIVITY_STATE.class, str);
        }

        public static ACTIVITY_STATE[] values() {
            return (ACTIVITY_STATE[]) f47402c.clone();
        }
    }

    public DynamicAppIconController(Context context) {
        this.f47398d = context;
        this.f47399e = context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0);
    }

    public final void a(String str) {
        for (String str2 : this.f47395a) {
            if (!Objects.equals(str2, str)) {
                String strC = b.C("com.zeptoconsumerapp.", str2);
                Context context = this.f47398d;
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), strC), 2, 1);
            }
        }
    }

    public final void b(String str) {
        String strC = b.C("com.zeptoconsumerapp.", str);
        Context context = this.f47398d;
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getPackageName(), strC), 1, 1);
    }

    public final ACTIVITY_STATE c(String str) {
        int componentEnabledSetting;
        ACTIVITY_STATE activity_state;
        ACTIVITY_STATE activity_state2;
        String strC = b.C("com.zeptoconsumerapp.", str);
        Context context = this.f47398d;
        componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context.getPackageName(), strC));
        activity_state = ACTIVITY_STATE.f47400a;
        activity_state2 = ACTIVITY_STATE.f47401b;
        switch (strC) {
            case "MainActivity":
                return Arrays.asList(0, 1).contains(Integer.valueOf(componentEnabledSetting)) ? activity_state : activity_state2;
            case "APP_ICON_CAMPAIGN_1":
            case "APP_ICON_CAMPAIGN_2":
                return componentEnabledSetting == 1 ? activity_state : activity_state2;
            default:
                return activity_state2;
        }
    }

    public final void d() {
        SharedPreferences sharedPreferences = this.f47399e;
        try {
            String string = sharedPreferences.getString("currentScreenInView", "");
            String str = Utils.f47559a;
            if (Arrays.asList(this.f47396b).contains(string)) {
                String[] strArr = this.f47397c;
                int length = strArr.length;
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (str.contains(strArr[i2])) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (!z && !c("MainActivity").equals(ACTIVITY_STATE.f47400a)) {
                    sharedPreferences.edit().remove("currentAppIconCampaign").commit();
                    sharedPreferences.edit().putString("shouldUpdateShortcutsOnAppIconUpdate", "false").commit();
                    b("MainActivity");
                    a("MainActivity");
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void e(String str, String str2) {
        SharedPreferences sharedPreferences = this.f47399e;
        try {
            String string = sharedPreferences.getString("currentScreenInView", "");
            String str3 = Utils.f47559a;
            if (Arrays.asList(this.f47396b).contains(string)) {
                String[] strArr = this.f47397c;
                int length = strArr.length;
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (str3.contains(strArr[i2])) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (!z && !c(str2).equals(ACTIVITY_STATE.f47400a)) {
                    sharedPreferences.edit().putString("currentAppIconCampaign", str).commit();
                    sharedPreferences.edit().putString("shouldUpdateShortcutsOnAppIconUpdate", "true").commit();
                    b(str2);
                    a(str2);
                }
            }
        } catch (Exception unused) {
        }
    }
}
