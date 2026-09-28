package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes3.dex */
public class zzuc {
    @Deprecated
    public zzuc() {
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            zzaas zzaasVar = new zzaas(stringWriter);
            zzaasVar.zzr(zzuq.LENIENT);
            zzzt.zzV.write(zzaasVar, this);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
