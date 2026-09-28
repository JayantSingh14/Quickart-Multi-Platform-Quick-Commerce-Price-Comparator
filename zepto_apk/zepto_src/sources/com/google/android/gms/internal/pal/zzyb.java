package com.google.android.gms.internal.pal;

import java.security.Provider;
import javax.crypto.KeyAgreement;

/* loaded from: classes4.dex */
public final class zzyb implements zzyh {
    @Override // com.google.android.gms.internal.pal.zzyh
    public final /* bridge */ /* synthetic */ Object a(String str, Provider provider) {
        return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
    }
}
