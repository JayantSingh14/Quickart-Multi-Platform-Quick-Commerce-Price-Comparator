package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import coil3.network.internal.UtilsKt;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzboh implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final Context f25388a;

    public zzboh(Context context) {
        this.f25388a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        if (!map.containsKey("text") || TextUtils.isEmpty((CharSequence) map.get("text"))) {
            return;
        }
        com.google.android.gms.ads.internal.util.zze.k("Opening Share Sheet with text: ".concat(String.valueOf((String) map.get("text"))));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType(UtilsKt.MIME_TYPE_TEXT_PLAIN);
        intent.putExtra("android.intent.extra.TEXT", (String) map.get("text"));
        if (map.containsKey("title")) {
            intent.putExtra("android.intent.extra.TITLE", (String) map.get("title"));
        }
        try {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            com.google.android.gms.ads.internal.util.zzs.t(this.f25388a, intent);
        } catch (RuntimeException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to open Share Sheet", e2);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("ShareSheetGmsgHandler.onGmsg", e2);
        }
    }
}
