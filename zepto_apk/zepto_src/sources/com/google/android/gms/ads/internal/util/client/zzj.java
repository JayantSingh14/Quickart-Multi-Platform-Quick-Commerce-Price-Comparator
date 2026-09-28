package com.google.android.gms.ads.internal.util.client;

import android.util.JsonWriter;
import com.google.android.gms.common.util.Base64Utils;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes4.dex */
final /* synthetic */ class zzj implements zzk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21425a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21426b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f21427c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ byte[] f21428d;

    public /* synthetic */ zzj(String str, String str2, Map map, byte[] bArr) {
        this.f21425a = str;
        this.f21426b = str2;
        this.f21427c = map;
        this.f21428d = bArr;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzk
    public final /* synthetic */ void a(JsonWriter jsonWriter) throws IOException {
        Object obj = zzl.f21429b;
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(this.f21425a);
        jsonWriter.name("verb").value(this.f21426b);
        jsonWriter.endObject();
        zzl.h(jsonWriter, this.f21427c);
        byte[] bArr = this.f21428d;
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }
}
