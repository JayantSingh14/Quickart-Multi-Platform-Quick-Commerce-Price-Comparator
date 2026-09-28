package com.google.ads.interactivemedia.v3.internal;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public final class zztr {
    public static final zztr zza = new zztr("", "", false);
    public static final zztr zzb = new zztr(StringUtils.LF, "  ", true);
    private final String zzc;
    private final String zzd;
    private final boolean zze;

    private zztr(String str, String str2, boolean z) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.zzc = str;
        this.zzd = str2;
        this.zze = z;
    }

    public final String zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zze;
    }
}
