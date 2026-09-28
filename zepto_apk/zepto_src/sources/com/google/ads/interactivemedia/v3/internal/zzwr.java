package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class zzwr {
    public static zzuc zza(zzaaq zzaaqVar) throws zzug {
        boolean z;
        try {
            try {
                zzaaqVar.zzr();
                z = false;
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
            try {
                return (zzuc) zzzt.zzV.read(zzaaqVar);
            } catch (EOFException e3) {
                e = e3;
                if (z) {
                    return zzue.zza;
                }
                throw new zzuk(e);
            }
        } catch (zzaat e4) {
            throw new zzuk(e4);
        } catch (IOException e5) {
            throw new zzud(e5);
        } catch (NumberFormatException e6) {
            throw new zzuk(e6);
        }
    }
}
