package com.google.android.gms.internal.pal;

import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class zzzs {
    public static zzyy a(zzabc zzabcVar) {
        boolean z;
        try {
            try {
                zzabcVar.e();
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
            try {
                return (zzyy) zzaba.f37327a.a(zzabcVar);
            } catch (EOFException e3) {
                e = e3;
                z = false;
                if (z) {
                    return zzza.f38166a;
                }
                throw new zzze(e);
            }
        } catch (zzabf e4) {
            throw new zzze(e4);
        } catch (IOException e5) {
            throw new zzyz(e5);
        } catch (NumberFormatException e6) {
            throw new zzze(e6);
        }
    }
}
