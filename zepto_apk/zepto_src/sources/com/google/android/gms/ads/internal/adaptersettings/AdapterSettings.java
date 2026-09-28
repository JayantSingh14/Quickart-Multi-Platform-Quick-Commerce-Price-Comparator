package com.google.android.gms.ads.internal.adaptersettings;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbft;

/* loaded from: classes4.dex */
class AdapterSettings {

    @Nullable
    private static volatile AdapterSettings instance;
    private final zzbft adapterSettingsInternal = zzbd.f21150e.f21154d;

    @KeepForSdk
    private boolean getBoolean(String str, boolean z) {
        zzbft zzbftVar = this.adapterSettingsInternal;
        zzbftVar.getClass();
        return !str.startsWith("adapter:") ? z : zzbftVar.f24982c.optBoolean(str, z);
    }

    @KeepForSdk
    private float getFloat(String str, float f2) {
        zzbft zzbftVar = this.adapterSettingsInternal;
        zzbftVar.getClass();
        return !str.startsWith("adapter:") ? f2 : (float) zzbftVar.f24982c.optDouble(str, f2);
    }

    public static AdapterSettings getInstance() {
        if (instance == null) {
            synchronized (AdapterSettings.class) {
                try {
                    if (instance == null) {
                        instance = new AdapterSettings();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    @KeepForSdk
    private int getInt(String str, int i2) {
        zzbft zzbftVar = this.adapterSettingsInternal;
        zzbftVar.getClass();
        return !str.startsWith("adapter:") ? i2 : zzbftVar.f24982c.optInt(str, i2);
    }

    @KeepForSdk
    private long getLong(String str, long j2) {
        zzbft zzbftVar = this.adapterSettingsInternal;
        zzbftVar.getClass();
        return !str.startsWith("adapter:") ? j2 : zzbftVar.f24982c.optLong(str, j2);
    }

    @KeepForSdk
    private String getString(String str, String str2) {
        zzbft zzbftVar = this.adapterSettingsInternal;
        zzbftVar.getClass();
        return !str.startsWith("adapter:") ? str2 : zzbftVar.f24982c.optString(str, str2);
    }
}
