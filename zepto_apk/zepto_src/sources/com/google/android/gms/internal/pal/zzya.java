package com.google.android.gms.internal.pal;

import java.security.Provider;
import javax.crypto.Cipher;

/* loaded from: classes4.dex */
public final class zzya implements zzyh {
    @Override // com.google.android.gms.internal.pal.zzyh
    public final /* bridge */ /* synthetic */ Object a(String str, Provider provider) {
        return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
    }
}
