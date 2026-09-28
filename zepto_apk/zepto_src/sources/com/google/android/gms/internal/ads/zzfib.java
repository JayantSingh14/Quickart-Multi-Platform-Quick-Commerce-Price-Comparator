package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzfib {

    /* renamed from: a, reason: collision with root package name */
    public final List f31189a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfhu f31190b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f31191c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f31192d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public zzfib(JsonReader jsonReader, Bundle bundle) throws IOException {
        this.f31192d = bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z2)).booleanValue() && bundle != null) {
            bundle.putLong("server-response-parse-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
        ?? arrayList = Collections.EMPTY_LIST;
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        zzfhu zzfhuVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("responses".equals(strNextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(strNextName2)) {
                        arrayList = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList.add(new zzfhr(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (strNextName2.equals("common")) {
                        zzfhuVar = new zzfhu(jsonReader);
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.A2)).booleanValue() && bundle != null) {
                            bundle.putLong("normalize-ad-response-start", zzfhuVar.s);
                            bundle.putLong("normalize-ad-response-end", zzfhuVar.t);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (strNextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String strNextString = null;
                    JSONObject jSONObjectC = null;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        if (CLConstants.FIELD_PAY_INFO_NAME.equals(strNextName3)) {
                            strNextString = jsonReader.nextString();
                        } else if ("info".equals(strNextName3)) {
                            jSONObjectC = com.google.android.gms.ads.internal.util.zzbp.c(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (strNextString != null) {
                        arrayList2.add(new zzfia(strNextString, jSONObjectC));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.f31191c = arrayList2;
        this.f31189a = arrayList;
        this.f31190b = zzfhuVar == null ? new zzfhu(new JsonReader(new StringReader("{}"))) : zzfhuVar;
    }

    public static zzfib a(Reader reader, Bundle bundle) throws IOException {
        try {
            try {
                return new zzfib(new JsonReader(reader), bundle);
            } finally {
                IOUtils.closeQuietly(reader);
            }
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e2) {
            throw new zzfhv("unable to parse ServerResponse", e2);
        }
    }
}
