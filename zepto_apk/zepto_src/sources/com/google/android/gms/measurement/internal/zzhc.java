package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzql;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzhc {

    /* renamed from: a, reason: collision with root package name */
    public final String f39004a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f39005b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f39006c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzhg f39007d;

    public zzhc(zzhg zzhgVar, String str) {
        Objects.requireNonNull(zzhgVar);
        this.f39007d = zzhgVar;
        Preconditions.checkNotEmpty(str);
        this.f39004a = str;
        this.f39005b = new Bundle();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0113 A[Catch: NumberFormatException | JSONException -> 0x011b, NumberFormatException | JSONException -> 0x011b, TRY_LEAVE, TryCatch #0 {NumberFormatException | JSONException -> 0x011b, blocks: (B:10:0x0029, B:44:0x0095, B:44:0x0095, B:45:0x00a3, B:45:0x00a3, B:47:0x00b0, B:47:0x00b0, B:49:0x00c2, B:49:0x00c2, B:50:0x00cb, B:50:0x00cb, B:51:0x00cf, B:51:0x00cf, B:53:0x00dc, B:53:0x00dc, B:55:0x00ee, B:55:0x00ee, B:56:0x00f7, B:56:0x00f7, B:57:0x00fb, B:57:0x00fb, B:58:0x0107, B:58:0x0107, B:59:0x0113, B:59:0x0113), top: B:71:0x0029, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle a() throws org.json.JSONException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhc.a():android.os.Bundle");
    }

    public final void b(Bundle bundle) throws JSONException {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean zQ;
        zzgt zzgtVar;
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzhg zzhgVar = this.f39007d;
        SharedPreferences sharedPreferencesK = zzhgVar.k();
        zzib zzibVar = zzhgVar.f39180a;
        SharedPreferences.Editor editorEdit = sharedPreferencesK.edit();
        int size = bundle2.size();
        String str = this.f39004a;
        if (size == 0) {
            editorEdit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it2 = bundle2.keySet().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Object obj = bundle2.get(next);
                if (obj != null) {
                    try {
                        jSONObject = new JSONObject();
                        jSONObject.put("n", next);
                        zzql.a();
                        zQ = zzibVar.f39087d.q(null, zzfx.Q0);
                        zzgtVar = zzibVar.f39089f;
                    } catch (JSONException e2) {
                        e = e2;
                        it = it2;
                    }
                    if (zQ) {
                        it = it2;
                        try {
                        } catch (JSONException e3) {
                            e = e3;
                            zzgt zzgtVar2 = zzibVar.f39089f;
                            zzib.l(zzgtVar2);
                            zzgtVar2.f38958f.b(e, "Cannot serialize bundle value to SharedPreferences");
                            it2 = it;
                        }
                        if (obj instanceof String) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "l");
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put("t", "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put("t", "la");
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "d");
                        } else {
                            zzib.l(zzgtVar);
                            zzgtVar.f38958f.b(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            it2 = it;
                        }
                        jSONArray.put(jSONObject);
                        it2 = it;
                    } else {
                        it = it2;
                        jSONObject.put("v", obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            zzib.l(zzgtVar);
                            zzgtVar.f38958f.b(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            it2 = it;
                        }
                        jSONArray.put(jSONObject);
                        it2 = it;
                    }
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.f39006c = bundle2;
    }
}
