package com.google.android.gms.internal.ads;

import com.amazon.apay.hardened.external.model.APayConstants;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class zzbwd {

    /* renamed from: a, reason: collision with root package name */
    public final zzcir f25649a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25650b;

    public zzbwd(zzcir zzcirVar, String str) {
        this.f25649a = zzcirVar;
        this.f25650b = str;
    }

    public final void b(String str) throws JSONException {
        try {
            JSONObject jSONObjectPut = new JSONObject().put(APayConstants.Error.MESSAGE, str).put("action", this.f25650b);
            zzcir zzcirVar = this.f25649a;
            if (zzcirVar != null) {
                zzcirVar.m("onError", jSONObjectPut);
            }
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while dispatching error event.", e2);
        }
    }

    public final void c(int i2, int i3, int i4, int i5) throws JSONException {
        try {
            this.f25649a.m("onSizeChanged", new JSONObject().put("x", i2).put("y", i3).put(Snapshot.WIDTH, i4).put(Snapshot.HEIGHT, i5));
        } catch (JSONException e2) {
            int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while dispatching size change.", e2);
        }
    }

    public final void d(String str) throws JSONException {
        try {
            this.f25649a.m("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while dispatching state change.", e2);
        }
    }

    public final void e(int i2, int i3, int i4, int i5, float f2, int i6) throws JSONException {
        try {
            this.f25649a.m("onScreenInfoChanged", new JSONObject().put(Snapshot.WIDTH, i2).put(Snapshot.HEIGHT, i3).put("maxSizeWidth", i4).put("maxSizeHeight", i5).put("density", f2).put("rotation", i6));
        } catch (JSONException e2) {
            int i7 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while obtaining screen information.", e2);
        }
    }
}
