package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcsh implements zzbck {

    /* renamed from: a, reason: collision with root package name */
    public zzcir f27050a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f27051b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcrt f27052c;

    /* renamed from: d, reason: collision with root package name */
    public final Clock f27053d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f27054e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f27055f = false;

    /* renamed from: g, reason: collision with root package name */
    public final zzcrw f27056g = new zzcrw();

    public zzcsh(Executor executor, zzcrt zzcrtVar, Clock clock) {
        this.f27051b = executor;
        this.f27052c = zzcrtVar;
        this.f27053d = clock;
    }

    public final void a() {
        try {
            final JSONObject jSONObjectZzb = this.f27052c.zzb(this.f27056g);
            if (this.f27050a != null) {
                this.f27051b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsg
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzcsh zzcshVar = this.f27048a;
                        zzcshVar.getClass();
                        JSONObject jSONObject = jSONObjectZzb;
                        String string = jSONObject.toString();
                        String strS = android.support.v4.media.b.s(new StringBuilder(string.length() + 31), "Calling AFMA_updateActiveView(", string, ")");
                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.a(strS);
                        zzcshVar.f27050a.f("AFMA_updateActiveView", jSONObject);
                    }
                });
            }
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Failed to call video active view js", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void u0(zzbcj zzbcjVar) {
        boolean z = this.f27055f ? false : zzbcjVar.f24707j;
        zzcrw zzcrwVar = this.f27056g;
        zzcrwVar.f27006a = z;
        zzcrwVar.f27008c = this.f27053d.elapsedRealtime();
        zzcrwVar.f27010e = zzbcjVar;
        if (this.f27054e) {
            a();
        }
    }
}
