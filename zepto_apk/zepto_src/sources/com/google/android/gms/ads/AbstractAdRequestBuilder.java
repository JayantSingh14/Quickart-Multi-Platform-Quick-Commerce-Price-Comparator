package com.google.android.gms.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AbstractAdRequestBuilder;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public abstract class AbstractAdRequestBuilder<T extends AbstractAdRequestBuilder<T>> {

    /* renamed from: a, reason: collision with root package name */
    public final zzej f20979a;

    public AbstractAdRequestBuilder() {
        zzej zzejVar = new zzej();
        this.f20979a = zzejVar;
        zzejVar.f21170d.add("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.contains(",")) {
            StringBuilder sb = new StringBuilder(str2.length() + Type.EUI48);
            sb.append("Value ");
            sb.append(str2);
            sb.append(" contains invalid character ',' (comma). The server will parse it as a list of comma-separated values.");
            zzo.f(sb.toString());
        }
        this.f20979a.f21171e.putString(str, str2);
    }

    public final void b(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!TextUtils.isEmpty(str2) && str2.contains(",")) {
                StringBuilder sb = new StringBuilder(str2.length() + Type.EUI48);
                sb.append("Value ");
                sb.append(str2);
                sb.append(" contains invalid character ',' (comma). The server will parse it as a list of comma-separated values.");
                zzo.f(sb.toString());
            }
        }
        this.f20979a.f21171e.putString(str, TextUtils.join(",", arrayList));
    }

    public final AbstractAdRequestBuilder c(Bundle bundle) {
        zzej zzejVar = this.f20979a;
        zzejVar.getClass();
        zzejVar.f21168b.putBundle(AdMobAdapter.class.getName(), bundle);
        if (AdMobAdapter.class.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
            zzejVar.f21170d.remove("B3EEABB8EE11C2BE770B684D95219ECB");
        }
        return d();
    }

    public abstract AbstractAdRequestBuilder d();

    public final AbstractAdRequestBuilder e(String str) {
        this.f20979a.f21179m = str;
        return d();
    }

    public final void f(String str) {
        Preconditions.checkNotNull(str, "Content URL must be non-null.");
        Preconditions.checkNotEmpty(str, "Content URL must be non-empty.");
        int length = str.length();
        Preconditions.checkArgument(length <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
        this.f20979a.f21173g = str;
    }

    public final void g(List list) {
        if (list == null) {
            zzo.f("neighboring content URLs list should not be null");
            return;
        }
        ArrayList arrayList = this.f20979a.f21174h;
        arrayList.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (TextUtils.isEmpty(str)) {
                zzo.f("neighboring content URL should not be null or empty");
            } else {
                arrayList.add(str);
            }
        }
    }
}
