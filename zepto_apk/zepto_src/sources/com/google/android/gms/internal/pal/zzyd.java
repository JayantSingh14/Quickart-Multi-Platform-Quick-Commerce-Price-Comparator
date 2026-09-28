package com.google.android.gms.internal.pal;

import java.security.KeyPairGenerator;
import java.security.Provider;

/* loaded from: classes4.dex */
public final class zzyd implements zzyh {
    @Override // com.google.android.gms.internal.pal.zzyh
    public final /* bridge */ /* synthetic */ Object a(String str, Provider provider) {
        return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
    }
}
