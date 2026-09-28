package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzhvy implements zzhwb {

    /* renamed from: a, reason: collision with root package name */
    public final zzhwk f34411a;

    @Override // com.google.android.gms.internal.ads.zzhwb
    public final Object a(String str) {
        String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
        zzhwc zzhwcVar = zzhwc.f34414b;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            Provider provider = Security.getProvider(strArr[i2]);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            zzhwk zzhwkVar = this.f34411a;
            if (!zHasNext) {
                return zzhwkVar.a(str, null);
            }
            try {
                return zzhwkVar.a(str, (Provider) it.next());
            } catch (Exception unused) {
            }
        }
    }
}
