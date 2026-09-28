package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzcgl implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public boolean f26168a;

    public static int b(Context context, Map map, String str, int i2) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
                i2 = com.google.android.gms.ads.internal.util.client.zzf.b(Integer.parseInt(str2), context);
            } catch (NumberFormatException unused) {
                String strN = android.support.v4.media.a.n(new StringBuilder(str.length() + 34 + str2.length()), "Could not parse ", str, " in a video GMSG: ", str2);
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f(strN);
            }
        }
        if (com.google.android.gms.ads.internal.util.zze.m()) {
            int length = str.length();
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + length + 30 + String.valueOf(str2).length() + 6 + 1);
            android.support.v4.media.b.B(sb, "Parse pixels for ", str, ", got string ", str2);
            sb.append(", int ");
            sb.append(i2);
            sb.append(CLConstants.DOT_SALT_DELIMETER);
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        }
        return i2;
    }

    public static void c(zzcey zzceyVar, Map map) throws NumberFormatException {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        zzceq zzceqVar = zzceyVar.f26044g;
        if (str != null) {
            try {
                int i2 = Integer.parseInt(str);
                if (zzceqVar != null) {
                    zzceqVar.A(i2);
                }
            } catch (NumberFormatException unused) {
                String strM = android.support.v4.media.b.m("Could not parse buffer parameters in loadControl video GMSG: (", str, ", ", str2, ")");
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f(strM);
                return;
            }
        }
        if (str2 != null) {
            int i4 = Integer.parseInt(str2);
            if (zzceqVar != null) {
                zzceqVar.B(i4);
            }
        }
        if (str3 != null) {
            int i5 = Integer.parseInt(str3);
            if (zzceqVar != null) {
                zzceqVar.e(i5);
            }
        }
        if (str4 != null) {
            int i6 = Integer.parseInt(str4);
            if (zzceqVar != null) {
                zzceqVar.f(i6);
            }
        }
        if (str5 != null) {
            int i7 = Integer.parseInt(str5);
            if (zzceqVar == null) {
                return;
            }
            zzceqVar.g(i7);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws JSONException, NumberFormatException {
        int iMin;
        int iMin2;
        int i2;
        boolean z;
        int i3;
        zzcey zzceyVar;
        zzceq zzceqVar;
        zzcfk zzcfkVar = (zzcfk) obj;
        String str = (String) map.get("action");
        if (str == null) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Action missing from video GMSG.");
            return;
        }
        Integer numValueOf = null;
        Integer numValueOf2 = map.containsKey("playerId") ? Integer.valueOf(Integer.parseInt((String) map.get("playerId"))) : null;
        Integer numY = (zzcfkVar.z0() == null || (zzceyVar = zzcfkVar.z0().f26055e) == null || (zzceqVar = zzceyVar.f26044g) == null) ? null : zzceqVar.y();
        if (numValueOf2 != null && numY != null && !numValueOf2.equals(numY) && !str.equals("load")) {
            Locale locale = Locale.US;
            int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e("Event intended for player " + numValueOf2 + ", but sent to player " + numY + " - event ignored");
            return;
        }
        Integer num = numValueOf2;
        if (com.google.android.gms.ads.internal.util.client.zzo.j(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String string = jSONObject.toString();
            StringBuilder sb = new StringBuilder(str.length() + 13 + String.valueOf(string).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(StringUtils.SPACE);
            sb.append(string);
            com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        }
        if (str.equals(AppStateModule.APP_STATE_BACKGROUND)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.client.zzo.f("Color parameter missing from background video GMSG.");
                return;
            }
            try {
                zzcfkVar.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.f("Invalid color parameter in background video GMSG.");
                return;
            }
        }
        if (str.equals("playerBackground")) {
            String str3 = (String) map.get("color");
            if (TextUtils.isEmpty(str3)) {
                com.google.android.gms.ads.internal.util.client.zzo.f("Color parameter missing from playerBackground video GMSG.");
                return;
            }
            try {
                zzcfkVar.i0(Color.parseColor(str3));
                return;
            } catch (IllegalArgumentException unused2) {
                com.google.android.gms.ads.internal.util.client.zzo.f("Invalid color parameter in playerBackground video GMSG.");
                return;
            }
        }
        if (str.equals("decoderProps")) {
            String str4 = (String) map.get("mimeTypes");
            if (str4 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.f("No MIME types specified for decoder properties inspection.");
                HashMap map2 = new HashMap();
                map2.put("event", "decoderProps");
                map2.put("error", "missingMimeTypes");
                zzcfkVar.g("onVideoEvent", map2);
                return;
            }
            HashMap map3 = new HashMap();
            for (String str5 : str4.split(",")) {
                map3.put(str5, com.google.android.gms.ads.internal.util.zzch.a(str5.trim()));
            }
            HashMap map4 = new HashMap();
            map4.put("event", "decoderProps");
            map4.put("mimeTypes", map3);
            zzcfkVar.g("onVideoEvent", map4);
            return;
        }
        zzcez zzcezVarZ0 = zzcfkVar.z0();
        if (zzcezVarZ0 == null) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean zEquals = str.equals("new");
        boolean zEquals2 = str.equals("position");
        if (zEquals || zEquals2) {
            Context context = zzcfkVar.getContext();
            int iB = b(context, map, "x", 0);
            int iB2 = b(context, map, "y", 0);
            int iB3 = b(context, map, "w", -1);
            zzbgb zzbgbVar = zzbgk.z4;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                iMin = iB3 == -1 ? zzcfkVar.b() : Math.min(iB3, zzcfkVar.b());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.m()) {
                    int iB4 = zzcfkVar.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iB).length() + androidx.fragment.app.e.C(String.valueOf(iB3).length() + 72, 4, String.valueOf(iB4)) + 1);
                    sb2.append("Calculate width with original width ");
                    sb2.append(iB3);
                    sb2.append(", videoHost.getVideoBoundingWidth() ");
                    sb2.append(iB4);
                    sb2.append(", x ");
                    sb2.append(iB);
                    sb2.append(CLConstants.DOT_SALT_DELIMETER);
                    com.google.android.gms.ads.internal.util.zze.k(sb2.toString());
                }
                iMin = Math.min(iB3, zzcfkVar.b() - iB);
            }
            int iB5 = b(context, map, "h", -1);
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                iMin2 = iB5 == -1 ? zzcfkVar.y() : Math.min(iB5, zzcfkVar.y());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.m()) {
                    int iY = zzcfkVar.y();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(iB2).length() + androidx.fragment.app.e.C(String.valueOf(iB5).length() + 75, 4, String.valueOf(iY)) + 1);
                    sb3.append("Calculate height with original height ");
                    sb3.append(iB5);
                    sb3.append(", videoHost.getVideoBoundingHeight() ");
                    sb3.append(iY);
                    sb3.append(", y ");
                    sb3.append(iB2);
                    sb3.append(CLConstants.DOT_SALT_DELIMETER);
                    com.google.android.gms.ads.internal.util.zze.k(sb3.toString());
                }
                iMin2 = Math.min(iB5, zzcfkVar.y() - iB2);
            }
            try {
                i2 = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException unused3) {
                i2 = 0;
            }
            boolean z2 = Boolean.parseBoolean((String) map.get("spherical"));
            if (!zEquals || zzcezVarZ0.f26055e != null) {
                Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
                zzcey zzceyVar2 = zzcezVarZ0.f26055e;
                if (zzceyVar2 != null) {
                    zzceyVar2.n(iB, iB2, iMin, iMin2);
                    return;
                }
                return;
            }
            zzcfj zzcfjVar = new zzcfj((String) map.get("flags"));
            if (zzcezVarZ0.f26055e == null) {
                zzcir zzcirVar = zzcezVarZ0.f26052b;
                zzbgr.a(zzcirVar.zzq().f25045b, zzcirVar.zzi(), "vpr2");
                zzcey zzceyVar3 = new zzcey(zzcezVarZ0.f26051a, zzcirVar, i2, z2, zzcirVar.zzq().f25045b, zzcfjVar, zzcezVarZ0.f26054d);
                zzcezVarZ0.f26055e = zzceyVar3;
                zzcezVarZ0.f26053c.addView(zzceyVar3, 0, new ViewGroup.LayoutParams(-1, -1));
                zzcezVarZ0.f26055e.n(iB, iB2, iMin, iMin2);
                zzcirVar.w0();
            }
            zzcey zzceyVar4 = zzcezVarZ0.f26055e;
            if (zzceyVar4 != null) {
                c(zzceyVar4, map);
                return;
            }
            return;
        }
        zzcjx zzcjxVarZzh = zzcfkVar.zzh();
        if (zzcjxVarZzh != null) {
            if (str.equals("timeupdate")) {
                String str6 = (String) map.get("currentTime");
                if (str6 == null) {
                    com.google.android.gms.ads.internal.util.client.zzo.f("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                }
                try {
                    float f2 = Float.parseFloat(str6);
                    synchronized (zzcjxVarZzh.f26444b) {
                        zzcjxVarZzh.f26452j = f2;
                    }
                    return;
                } catch (NumberFormatException unused4) {
                    com.google.android.gms.ads.internal.util.client.zzo.f("Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str6));
                    return;
                }
            }
            if (str.equals("skip")) {
                synchronized (zzcjxVarZzh.f26444b) {
                    z = zzcjxVarZzh.f26450h;
                    i3 = zzcjxVarZzh.f26447e;
                    zzcjxVarZzh.f26447e = 3;
                }
                ((zzcdn) zzcdo.f25987f).execute(new zzcjv(zzcjxVarZzh, i3, 3, z, z));
                return;
            }
        }
        zzcey zzceyVar5 = zzcezVarZ0.f26055e;
        if (zzceyVar5 == null) {
            HashMap map5 = new HashMap();
            map5.put("event", "no_video_view");
            zzcfkVar.g("onVideoEvent", map5);
            return;
        }
        if (str.equals("click")) {
            Context context2 = zzcfkVar.getContext();
            int iB6 = b(context2, map, "x", 0);
            float fB = b(context2, map, "y", 0);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iB6, fB, 0);
            zzceq zzceqVar2 = zzceyVar5.f26044g;
            if (zzceqVar2 != null) {
                zzceqVar2.dispatchTouchEvent(motionEventObtain);
            }
            motionEventObtain.recycle();
            return;
        }
        if (str.equals("currentTime")) {
            String str7 = (String) map.get("time");
            if (str7 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.f("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                int i6 = (int) (Float.parseFloat(str7) * 1000.0f);
                zzceq zzceqVar3 = zzceyVar5.f26044g;
                if (zzceqVar3 == null) {
                    return;
                }
                zzceqVar3.q(i6);
                return;
            } catch (NumberFormatException unused5) {
                com.google.android.gms.ads.internal.util.client.zzo.f("Could not parse time parameter from currentTime video GMSG: ".concat(str7));
                return;
            }
        }
        if (str.equals("hide")) {
            zzceyVar5.setVisibility(4);
            return;
        }
        if (str.equals("remove")) {
            zzceyVar5.setVisibility(8);
            return;
        }
        if (str.equals("load")) {
            zzceq zzceqVar4 = zzceyVar5.f26044g;
            if (zzceqVar4 == null) {
                return;
            }
            if (TextUtils.isEmpty(zzceyVar5.n)) {
                zzceyVar5.c("no_src", new String[0]);
                return;
            } else {
                zzceqVar4.z(zzceyVar5.n, zzceyVar5.o, num);
                return;
            }
        }
        if (str.equals("loadControl")) {
            c(zzceyVar5, map);
            return;
        }
        if (str.equals("muted")) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzceq zzceqVar5 = zzceyVar5.f26044g;
                if (zzceqVar5 == null) {
                    return;
                }
                zzcfo zzcfoVar = zzceqVar5.f26029b;
                zzcfoVar.f26117e = true;
                zzcfoVar.a();
                zzceqVar5.zzq();
                return;
            }
            zzceq zzceqVar6 = zzceyVar5.f26044g;
            if (zzceqVar6 == null) {
                return;
            }
            zzcfo zzcfoVar2 = zzceqVar6.f26029b;
            zzcfoVar2.f26117e = false;
            zzcfoVar2.a();
            zzceqVar6.zzq();
            return;
        }
        if (str.equals(CLConstants.CRED_SUB_TYPE_MANDATE_PAUSE)) {
            zzceq zzceqVar7 = zzceyVar5.f26044g;
            if (zzceqVar7 == null) {
                return;
            }
            zzceqVar7.n();
            return;
        }
        if (str.equals("play")) {
            zzceq zzceqVar8 = zzceyVar5.f26044g;
            if (zzceqVar8 == null) {
                return;
            }
            zzceqVar8.m();
            return;
        }
        if (str.equals("show")) {
            zzceyVar5.setVisibility(0);
            return;
        }
        if (str.equals("src")) {
            String str8 = (String) map.get("src");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.w2)).booleanValue() && TextUtils.isEmpty(str8)) {
                com.google.android.gms.ads.internal.util.client.zzo.f("Src parameter missing from src video GMSG.");
                return;
            }
            if (map.containsKey("periodicReportIntervalMs")) {
                try {
                    numValueOf = Integer.valueOf(Integer.parseInt((String) map.get("periodicReportIntervalMs")));
                } catch (NumberFormatException unused6) {
                    com.google.android.gms.ads.internal.util.client.zzo.f("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ".concat(String.valueOf((String) map.get("periodicReportIntervalMs"))));
                }
            }
            String[] strArr = {str8};
            String str9 = (String) map.get("demuxed");
            if (str9 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str9);
                    ArrayList arrayList = new ArrayList();
                    for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                        String string2 = jSONArray.getString(i7);
                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.w2)).booleanValue() || !TextUtils.isEmpty(string2)) {
                            arrayList.add(string2);
                        }
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.w2)).booleanValue() && arrayList.isEmpty()) {
                        StringBuilder sb4 = new StringBuilder(str9.length() + 41);
                        sb4.append("All demuxed URLs are empty for playback: ");
                        sb4.append(str9);
                        com.google.android.gms.ads.internal.util.client.zzo.f(sb4.toString());
                        return;
                    }
                    strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                } catch (JSONException unused7) {
                    com.google.android.gms.ads.internal.util.client.zzo.f("Malformed demuxed URL list for playback: ".concat(str9));
                    strArr = new String[]{str8};
                }
            }
            if (numValueOf != null) {
                zzcfkVar.P(numValueOf.intValue());
            }
            zzceyVar5.n = str8;
            zzceyVar5.o = strArr;
            return;
        }
        if (str.equals("touchMove")) {
            Context context3 = zzcfkVar.getContext();
            int iB7 = b(context3, map, "dx", 0);
            int iB8 = b(context3, map, "dy", 0);
            float f3 = iB7;
            float f4 = iB8;
            zzceq zzceqVar9 = zzceyVar5.f26044g;
            if (zzceqVar9 != null) {
                zzceqVar9.r(f3, f4);
            }
            if (this.f26168a) {
                return;
            }
            zzcfkVar.zzl();
            this.f26168a = true;
            return;
        }
        if (!str.equals("volume")) {
            if (str.equals("watermark")) {
                zzceyVar5.a();
                return;
            } else {
                com.google.android.gms.ads.internal.util.client.zzo.f("Unknown video action: ".concat(str));
                return;
            }
        }
        String str10 = (String) map.get("volume");
        if (str10 == null) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Level parameter missing from volume video GMSG.");
            return;
        }
        try {
            float f5 = Float.parseFloat(str10);
            zzceq zzceqVar10 = zzceyVar5.f26044g;
            if (zzceqVar10 == null) {
                return;
            }
            zzcfo zzcfoVar3 = zzceqVar10.f26029b;
            zzcfoVar3.f26118f = f5;
            zzcfoVar3.a();
            zzceqVar10.zzq();
        } catch (NumberFormatException unused8) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not parse volume parameter from volume video GMSG: ".concat(str10));
        }
    }
}
