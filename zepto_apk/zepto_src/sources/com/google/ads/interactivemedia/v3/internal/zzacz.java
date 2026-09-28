package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
public class zzacz extends IOException {
    private zzadz zza;

    public zzacz(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    public static zzacy zza() {
        return new zzacy("Protocol message tag had invalid wire type.");
    }

    public static zzacz zzb() {
        return new zzacz("Protocol message end-group tag did not match expected tag.");
    }

    public static zzacz zzc() {
        return new zzacz("Protocol message contained an invalid tag (zero).");
    }

    public static zzacz zzd() {
        return new zzacz("Protocol message had invalid UTF-8.");
    }

    public static zzacz zze() {
        return new zzacz("CodedInputStream encountered a malformed varint.");
    }

    public static zzacz zzf() {
        return new zzacz("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzacz zzg() {
        return new zzacz("Failed to parse the message.");
    }

    public static zzacz zzi() {
        return new zzacz("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzacz zzh(zzadz zzadzVar) {
        this.zza = zzadzVar;
        return this;
    }

    public zzacz(String str) {
        super(str);
        this.zza = null;
    }
}
