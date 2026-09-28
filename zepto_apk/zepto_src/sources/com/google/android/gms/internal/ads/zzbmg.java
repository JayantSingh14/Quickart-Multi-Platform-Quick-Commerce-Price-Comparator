package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzbmg implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f25320a = Pattern.compile("^[a-zA-Z]([a-zA-Z0-9]|:|-|_)*$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f25321b = Pattern.compile("^[0-9]*(,[0-9]*)*$");

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws NumberFormatException {
        zzcir zzcirVar = (zzcir) obj;
        String str = (String) map.get("action");
        boolean zEquals = "tick".equals(str);
        Pattern pattern = f25320a;
        if (!zEquals) {
            if ("experiment".equals(str)) {
                String str2 = (String) map.get(CLConstants.FIELD_PAY_INFO_VALUE);
                if (TextUtils.isEmpty(str2)) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("No value given for CSI experiment.");
                    return;
                }
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.v2)).booleanValue() || f25321b.matcher(str2).matches()) {
                    zzcirVar.zzq().f25045b.c("e", str2);
                    return;
                } else {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.a("Invalid value given for CSI experiment. Should be a comma separated list of numbers.");
                    return;
                }
            }
            if ("extra".equals(str)) {
                String str3 = (String) map.get(CLConstants.FIELD_PAY_INFO_NAME);
                String str4 = (String) map.get(CLConstants.FIELD_PAY_INFO_VALUE);
                if (TextUtils.isEmpty(str4)) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("No value given for CSI extra.");
                    return;
                }
                if (TextUtils.isEmpty(str3)) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("No name given for CSI extra.");
                    return;
                }
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.v2)).booleanValue() || pattern.matcher(str3).matches()) {
                    zzcirVar.zzq().f25045b.c(str3, str4);
                    return;
                } else {
                    int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.a("Invalid name given for CSI extra. Should start with a letter and only alphanumerics, :, -, _ are allowed.");
                    return;
                }
            }
            return;
        }
        String str5 = (String) map.get("label");
        String str6 = (String) map.get("start_label");
        String str7 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str5)) {
            int i7 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("No label given for CSI tick.");
            return;
        }
        zzbgb zzbgbVar = zzbgk.v2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && !pattern.matcher(str5).matches()) {
            int i8 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Invalid label given for CSI tick. Should start with a letter and only alphanumerics, :, -, _ are allowed.");
            return;
        }
        if (TextUtils.isEmpty(str7)) {
            int i9 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("No timestamp given for CSI tick.");
            return;
        }
        try {
            long j2 = Long.parseLong(str7);
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            long jCurrentTimeMillis = (j2 - zztVar.f21687k.currentTimeMillis()) + zztVar.f21687k.elapsedRealtime();
            if (true == TextUtils.isEmpty(str6)) {
                str6 = "native:view_load";
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && !pattern.matcher(str6).matches()) {
                int i10 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Invalid start label given for CSI tick. Should start with a letter and only alphanumerics, :, -, _ are allowed.");
                return;
            }
            zzbgx zzbgxVarZzq = zzcirVar.zzq();
            HashMap map2 = zzbgxVarZzq.f25044a;
            zzbgw zzbgwVar = (zzbgw) map2.get(str6);
            String[] strArr = {str5};
            if (zzbgwVar != null) {
                zzbgxVarZzq.f25045b.a(zzbgwVar, jCurrentTimeMillis, strArr);
            }
            map2.put(str5, new zzbgw(jCurrentTimeMillis, null, null));
        } catch (NumberFormatException e2) {
            int i11 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Malformed timestamp for CSI tick.", e2);
        }
    }
}
