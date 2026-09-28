package com.google.android.gms.internal.pal;

import java.security.MessageDigest;
import java.security.Provider;

/* loaded from: classes4.dex */
public final class zzyf implements zzyh {
    @Override // com.google.android.gms.internal.pal.zzyh
    public final /* bridge */ /* synthetic */ Object a(String str, Provider provider) {
        return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
    }
}
