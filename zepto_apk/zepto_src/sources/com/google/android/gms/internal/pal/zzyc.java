package com.google.android.gms.internal.pal;

import java.security.KeyFactory;
import java.security.Provider;

/* loaded from: classes4.dex */
public final class zzyc implements zzyh {
    @Override // com.google.android.gms.internal.pal.zzyh
    public final /* bridge */ /* synthetic */ Object a(String str, Provider provider) {
        return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
    }
}
