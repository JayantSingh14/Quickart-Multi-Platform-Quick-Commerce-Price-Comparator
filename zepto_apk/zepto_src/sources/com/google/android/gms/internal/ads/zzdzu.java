package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.util.Base64;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdzu {

    /* renamed from: a, reason: collision with root package name */
    public final Context f28870a;

    /* renamed from: b, reason: collision with root package name */
    public final ApplicationInfo f28871b;

    /* renamed from: c, reason: collision with root package name */
    public final int f28872c;

    /* renamed from: d, reason: collision with root package name */
    public final int f28873d;

    /* renamed from: e, reason: collision with root package name */
    public String f28874e = "";

    public zzdzu(Context context) {
        this.f28870a = context;
        this.f28871b = context.getApplicationInfo();
        zzbgb zzbgbVar = zzbgk.na;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        this.f28872c = ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue();
        this.f28873d = ((Integer) zzbdVar.f21153c.a(zzbgk.oa)).intValue();
    }

    public final JSONObject a() throws JSONException {
        String strQ;
        String strEncodeToString;
        ApplicationInfo applicationInfo = this.f28871b;
        Context context = this.f28870a;
        JSONObject jSONObject = new JSONObject();
        try {
            String str = applicationInfo.packageName;
            com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
            jSONObject.put(CLConstants.FIELD_PAY_INFO_NAME, Wrappers.packageManager(context).getApplicationLabel(str));
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONObject.put("packageName", applicationInfo.packageName);
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        Drawable drawable = null;
        try {
            strQ = com.google.android.gms.ads.internal.util.zzs.Q(context);
        } catch (RemoteException unused2) {
            strQ = null;
        }
        jSONObject.put("adMobAppId", strQ);
        boolean zIsEmpty = this.f28874e.isEmpty();
        int i2 = this.f28873d;
        int i3 = this.f28872c;
        if (zIsEmpty) {
            try {
                drawable = Wrappers.packageManager(context).getApplicationLabelAndIcon(applicationInfo.packageName).f2990b;
            } catch (PackageManager.NameNotFoundException unused3) {
            }
            if (drawable == null) {
                strEncodeToString = "";
            } else {
                drawable.setBounds(0, 0, i3, i2);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
                drawable.draw(new Canvas(bitmapCreateBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            }
            this.f28874e = strEncodeToString;
        }
        if (!this.f28874e.isEmpty()) {
            jSONObject.put("icon", this.f28874e);
            jSONObject.put("iconWidthPx", i3);
            jSONObject.put("iconHeightPx", i2);
        }
        return jSONObject;
    }
}
