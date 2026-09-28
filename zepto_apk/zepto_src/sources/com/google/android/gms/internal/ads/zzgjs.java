package com.google.android.gms.internal.ads;

import j$.util.Base64;
import java.security.GeneralSecurityException;
import java.util.Optional;

/* loaded from: classes4.dex */
final class zzgjs {

    /* renamed from: a, reason: collision with root package name */
    public Optional f32755a;

    /* renamed from: b, reason: collision with root package name */
    public Optional f32756b;

    public final boolean a(zzbbo zzbboVar) throws GeneralSecurityException {
        byte[] bArrZ = zzbboVar.C().D().D().z();
        byte[] bArrZ2 = zzbboVar.C().F().z();
        try {
            try {
                if (this.f32755a == null && this.f32756b == null) {
                    try {
                        zzhtr.a();
                        zzhai zzhaiVarA = zzhas.a(new String(Base64.getDecoder().decode("eyJwcmltYXJ5S2V5SWQiOjMzMTUxOTk4MTksImtleSI6W3sia2V5RGF0YSI6eyJ0eXBlVXJsIjoidHlwZS5nb29nbGVhcGlzLmNvbS9nb29nbGUuY3J5cHRvLnRpbmsuRWNkc2FQdWJsaWNLZXkiLCJ2YWx1ZSI6IkVnWUlBeEFDR0FFYUlRQVNoRGZwOUM5QjcrMU1nMmJQbHJ5WExPOHVScDd6YWZJMldSYURmR1ZqVmlJaEFJNFZzTmVrcCs0bVY0d2toZlhVb3pQZWs5TjgxcUdIK2plNnhjOFpoQkhQIiwia2V5TWF0ZXJpYWxUeXBlIjoiQVNZTU1FVFJJQ19QVUJMSUMifSwic3RhdHVzIjoiRU5BQkxFRCIsImtleUlkIjozMzE1MTk5ODE5LCJvdXRwdXRQcmVmaXhUeXBlIjoiVElOSyJ9XX0=")));
                        zzhkd zzhkdVar = zzhkd.f33919a;
                        this.f32755a = Optional.of((zzhaq) zzhaiVarA.f(zzhkdVar, zzhaq.class));
                        this.f32756b = Optional.of((zzhaq) zzhas.a(new String(Base64.getDecoder().decode("eyJwcmltYXJ5S2V5SWQiOjMwODI3ODA4ODgsImtleSI6W3sia2V5RGF0YSI6eyJ0eXBlVXJsIjoidHlwZS5nb29nbGVhcGlzLmNvbS9nb29nbGUuY3J5cHRvLnRpbmsuRWNkc2FQdWJsaWNLZXkiLCJ2YWx1ZSI6IkVnWUlBeEFDR0FFYUlRQkEyWW5HaWFpc3pEcGtJcWpjalorUTJ2alFUUldQZjhFcTlkZVlhNFpKa3lJaEFCQWFESTd6QWJkQXVpQmlnOWdHSkJ1VTUzSGg5Z0RCa0t2amswS2tabDhjIiwia2V5TWF0ZXJpYWxUeXBlIjoiQVNZTU1FVFJJQ19QVUJMSUMifSwic3RhdHVzIjoiRU5BQkxFRCIsImtleUlkIjozMDgyNzgwODg4LCJvdXRwdXRQcmVmaXhUeXBlIjoiVElOSyJ9XX0="))).f(zzhkdVar, zzhaq.class));
                    } catch (Exception e2) {
                        throw new GeneralSecurityException("Failed to verify program", e2);
                    }
                }
                this.f32755a.isPresent();
                ((zzhaq) this.f32755a.get()).zza(bArrZ, bArrZ2);
                return true;
            } catch (GeneralSecurityException unused) {
                return false;
            }
        } catch (GeneralSecurityException unused2) {
            this.f32756b.isPresent();
            ((zzhaq) this.f32756b.get()).zza(bArrZ, bArrZ2);
            return true;
        }
    }
}
