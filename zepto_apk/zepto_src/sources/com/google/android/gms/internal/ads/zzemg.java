package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class zzemg implements zzejg {
    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(zzfic zzficVar, zzfhr zzfhrVar) {
        JSONObject jSONObject = zzfhrVar.v;
        String strOptString = jSONObject.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzfik zzfikVar = zzficVar.f31193a.f31185a;
        zzfij zzfijVar = new zzfij();
        zzfijVar.o.f31183a = zzfikVar.p.f31184a;
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfikVar.f31216d;
        zzfijVar.f31200a = zzmVar;
        zzfijVar.f31201b = zzfikVar.f31218f;
        zzfijVar.w = zzfikVar.w;
        String str = zzfikVar.f31219g;
        zzfijVar.f31202c = str;
        zzfijVar.f31203d = zzfikVar.f31213a;
        zzfijVar.f31205f = zzfikVar.f31220h;
        zzfijVar.f31206g = zzfikVar.f31221i;
        zzfijVar.f31207h = zzfikVar.f31222j;
        zzfijVar.f31208i = zzfikVar.f31223k;
        AdManagerAdViewOptions adManagerAdViewOptions = zzfikVar.f31225m;
        zzfijVar.f31209j = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            zzfijVar.f31204e = adManagerAdViewOptions.f21044a;
        }
        PublisherAdViewOptions publisherAdViewOptions = zzfikVar.n;
        zzfijVar.f31210k = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            zzfijVar.f31204e = publisherAdViewOptions.f21059a;
            zzfijVar.f31211l = publisherAdViewOptions.f21060b;
        }
        zzfijVar.p = zzfikVar.q;
        zzfijVar.q = zzfikVar.r;
        zzfijVar.r = zzfikVar.f31215c;
        zzfijVar.s = zzfikVar.s;
        zzfijVar.t = zzfikVar.t;
        zzfijVar.u.set(zzfikVar.u.get());
        zzfijVar.f31202c = strOptString;
        zzfijVar.v = true;
        Bundle bundle = zzmVar.f21266m;
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        Bundle bundle3 = bundle2.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        Bundle bundle4 = bundle3 == null ? new Bundle() : new Bundle(bundle3);
        bundle4.putInt("gw", 1);
        String strOptString2 = jSONObject.optString("mad_hac", null);
        if (strOptString2 != null) {
            bundle4.putString("mad_hac", strOptString2);
        }
        String strOptString3 = jSONObject.optString("adJson", null);
        if (strOptString3 != null) {
            bundle4.putString("_ad", strOptString3);
        }
        bundle4.putBoolean("_noRefresh", true);
        JSONObject jSONObject2 = zzfhrVar.D;
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString4 = jSONObject2.optString(next, null);
            if (next != null) {
                bundle4.putString(next, strOptString4);
            }
        }
        bundle2.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundle4);
        zzfijVar.f31200a = new com.google.android.gms.ads.internal.client.zzm(zzmVar.f21254a, zzmVar.f21255b, bundle4, zzmVar.f21257d, zzmVar.f21258e, zzmVar.f21259f, zzmVar.f21260g, zzmVar.f21261h, zzmVar.f21262i, zzmVar.f21263j, zzmVar.f21264k, zzmVar.f21265l, bundle2, zzmVar.n, zzmVar.o, zzmVar.p, zzmVar.q, zzmVar.r, zzmVar.s, zzmVar.t, zzmVar.u, zzmVar.v, zzmVar.w, zzmVar.x, zzmVar.y, zzmVar.z, zzmVar.A);
        zzfik zzfikVarA = zzfijVar.a();
        Bundle bundle5 = new Bundle();
        zzfib zzfibVar = zzficVar.f31194b;
        Bundle bundle6 = new Bundle();
        zzfhu zzfhuVar = zzfibVar.f31190b;
        bundle6.putStringArrayList("nofill_urls", new ArrayList<>(zzfhuVar.f31166a));
        bundle6.putInt("refresh_interval", zzfhuVar.f31168c);
        bundle6.putString("gws_query_id", zzfhuVar.f31167b);
        bundle5.putBundle("parent_common_config", bundle6);
        Bundle bundle7 = new Bundle();
        bundle7.putString("initial_ad_unit_id", str);
        bundle7.putString("allocation_id", zzfhrVar.w);
        bundle7.putString("ad_source_name", zzfhrVar.F);
        bundle7.putStringArrayList("click_urls", new ArrayList<>(zzfhrVar.f31151c));
        bundle7.putStringArrayList("imp_urls", new ArrayList<>(zzfhrVar.f31152d));
        bundle7.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzfhrVar.p));
        bundle7.putStringArrayList("fill_urls", new ArrayList<>(zzfhrVar.f31161m));
        bundle7.putStringArrayList("video_start_urls", new ArrayList<>(zzfhrVar.f31155g));
        bundle7.putStringArrayList("video_reward_urls", new ArrayList<>(zzfhrVar.f31156h));
        bundle7.putStringArrayList("video_complete_urls", new ArrayList<>(zzfhrVar.f31157i));
        bundle7.putString("transaction_id", zzfhrVar.f31158j);
        bundle7.putString("valid_from_timestamp", zzfhrVar.f31159k);
        bundle7.putBoolean("is_closable_area_disabled", zzfhrVar.P);
        bundle7.putString("recursive_server_response_data", zzfhrVar.o0);
        bundle7.putBoolean("is_analytics_logging_enabled", zzfhrVar.W);
        zzbzy zzbzyVar = zzfhrVar.f31160l;
        if (zzbzyVar != null) {
            Bundle bundle8 = new Bundle();
            bundle8.putInt("rb_amount", zzbzyVar.f25782b);
            bundle8.putString("rb_type", zzbzyVar.f25781a);
            bundle7.putParcelableArray("rewards", new Bundle[]{bundle8});
        }
        bundle5.putBundle("parent_ad_config", bundle7);
        return c(zzfikVarA, bundle5, zzfhrVar, zzficVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) {
        return !TextUtils.isEmpty(zzfhrVar.v.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    public abstract zzfmb c(zzfik zzfikVar, Bundle bundle, zzfhr zzfhrVar, zzfic zzficVar);
}
