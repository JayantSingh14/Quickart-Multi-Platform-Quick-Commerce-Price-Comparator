package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzegd implements zzflu {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f29274d = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);

    /* renamed from: a, reason: collision with root package name */
    public final String f29275a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfne f29276b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfno f29277c;

    public zzegd(String str, zzfno zzfnoVar, zzfne zzfneVar) {
        this.f29275a = str;
        this.f29277c = zzfnoVar;
        this.f29276b = zzfneVar;
    }

    @Override // com.google.android.gms.internal.ads.zzflu
    public final Object zza(Object obj) throws zzebr, IOException {
        String strJoin;
        zzebr zzebrVar;
        byte[] bArr;
        JSONObject jSONObject;
        String strConcat;
        zzegc zzegcVar = (zzegc) obj;
        int iOptInt = zzegcVar.f29272a.optInt("http_timeout_millis", 60000);
        zzbzc zzbzcVar = zzegcVar.f29273b;
        int i2 = zzbzcVar.f25739g;
        zzfno zzfnoVar = this.f29277c;
        zzfne zzfneVar = this.f29276b;
        int i3 = 1;
        strJoin = "";
        if (i2 != -2) {
            if (i2 == 1) {
                List list = zzbzcVar.f25733a;
                if (list != null) {
                    strJoin = TextUtils.join(", ", list);
                    int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.c(strJoin);
                }
                zzebrVar = new zzebr(2, "Error building request URL: ".concat(String.valueOf(strJoin)));
            } else {
                zzebrVar = new zzebr(1);
            }
            zzfneVar.c(zzebrVar);
            zzfneVar.a(false);
            zzfnoVar.a(zzfneVar);
            throw zzebrVar;
        }
        HashMap map = new HashMap();
        if (zzbzcVar.f25737e) {
            String str = this.f29275a;
            if (!TextUtils.isEmpty(str)) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.k1)).booleanValue()) {
                    if (TextUtils.isEmpty(str)) {
                        strConcat = "";
                    } else {
                        Matcher matcher = f29274d.matcher(str);
                        strConcat = "";
                        while (matcher.find()) {
                            String strGroup = matcher.group(i3);
                            if (strGroup != null) {
                                Locale locale = Locale.ROOT;
                                if (strGroup.toLowerCase(locale).startsWith("id=") || strGroup.toLowerCase(locale).startsWith("ide=")) {
                                    if (!TextUtils.isEmpty(strConcat)) {
                                        strConcat = strConcat.concat("; ");
                                    }
                                    strConcat = strConcat.concat(strGroup);
                                }
                            }
                            i3 = 1;
                        }
                    }
                    if (!TextUtils.isEmpty(strConcat)) {
                        map.put("Cookie", strConcat);
                    }
                } else {
                    map.put("Cookie", str);
                }
            }
        }
        if (zzbzcVar.f25736d && (jSONObject = zzegcVar.f29272a) != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pii");
            if (jSONObjectOptJSONObject != null) {
                if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos", ""))) {
                    map.put("x-afma-drt-cookie", jSONObjectOptJSONObject.optString("doritos", ""));
                }
                if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos_v2", ""))) {
                    map.put("x-afma-drt-v2-cookie", jSONObjectOptJSONObject.optString("doritos_v2", ""));
                }
            } else {
                com.google.android.gms.ads.internal.util.zze.k("DSID signal does not exist.");
            }
        }
        byte[] byteArray = new byte[0];
        String str2 = zzbzcVar.f25735c;
        if (TextUtils.isEmpty(str2)) {
            bArr = byteArray;
        } else {
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            if (zzbzcVar.f25744l) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.finish();
                        byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                    } finally {
                    }
                } catch (IOException e2) {
                    com.google.android.gms.ads.internal.util.zze.l("gzip compression failed, sending uncompressed.", e2);
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("PrepareRequestFunction.apply", e2);
                    byteArray = null;
                }
                if (byteArray != null) {
                    map.put("Content-Encoding", "gzip");
                    bArr = byteArray;
                }
            }
            bArr = bytes;
        }
        String str3 = zzbzcVar.f25745m;
        strJoin = TextUtils.isEmpty(str3) ? "" : str3;
        zzfneVar.a(true);
        zzfnoVar.a(zzfneVar);
        return new zzefy(zzbzcVar.f25738f, iOptInt, map, bArr, strJoin);
    }
}
