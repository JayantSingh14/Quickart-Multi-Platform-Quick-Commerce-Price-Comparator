package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzgpr;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final /* synthetic */ class zzaq implements zzgpr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzaq f21786a = new zzaq();

    @Override // com.google.android.gms.internal.ads.zzgpr
    public final /* synthetic */ Object apply(Object obj) {
        ArrayList arrayList = zzau.H;
        return ((JSONObject) obj).optString("nas");
    }
}
