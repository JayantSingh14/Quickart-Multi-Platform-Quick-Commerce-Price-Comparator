package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfst implements zzfsr {

    /* renamed from: a, reason: collision with root package name */
    public final zzfsu f31808a;

    public zzfst(zzfsu zzfsuVar) {
        this.f31808a = zzfsuVar;
    }

    public final JSONObject a(View view) throws JSONException {
        JSONObject jSONObjectA = zzftb.a(0, 0, 0, 0);
        UiModeManager uiModeManager = zzfta.f31820a;
        zzfrn zzfrnVar = zzfrn.OTHER;
        zzfrn zzfrnVar2 = zzfrn.CTV;
        if (uiModeManager != null) {
            int currentModeType = uiModeManager.getCurrentModeType();
            if (currentModeType == 1) {
                zzfrnVar = zzfrn.MOBILE;
            } else if (currentModeType == 4) {
                zzfrnVar = zzfrnVar2;
            }
        }
        int i2 = zzfrnVar != zzfrnVar2 ? 2 : zzfte.f31824a;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        try {
            jSONObjectA.put("noOutputDevice", i3 == 0);
            return jSONObjectA;
        } catch (JSONException e2) {
            zzftc.a("Error with setting output device status", e2);
            return jSONObjectA;
        }
    }
}
