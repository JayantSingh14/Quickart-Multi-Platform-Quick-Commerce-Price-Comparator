package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class zzxm extends zzaas {
    private static final Writer zza = new zzxl();
    private static final zzuh zzb = new zzuh("closed");
    private final List zzc;
    private String zzd;
    private zzuc zze;

    public zzxm() {
        super(zza);
        this.zzc = new ArrayList();
        this.zze = zzue.zza;
    }

    private final zzuc zzv() {
        return (zzuc) this.zzc.get(this.zzc.size() - 1);
    }

    private final void zzw(zzuc zzucVar) {
        if (this.zzd != null) {
            if (!(zzucVar instanceof zzue) || zzs()) {
                ((zzuf) zzv()).zzb(this.zzd, zzucVar);
            }
            this.zzd = null;
            return;
        }
        if (this.zzc.isEmpty()) {
            this.zze = zzucVar;
            return;
        }
        zzuc zzucVarZzv = zzv();
        if (!(zzucVarZzv instanceof zzua)) {
            throw new IllegalStateException();
        }
        ((zzua) zzucVarZzv).zza(zzucVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (!this.zzc.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.zzc.add(zzb);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas, java.io.Flushable
    public final void flush() throws IOException {
    }

    public final zzuc zza() {
        if (this.zzc.isEmpty()) {
            return this.zze;
        }
        throw new IllegalStateException("Expected one JSON element but was ".concat(this.zzc.toString()));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzb() throws IOException {
        zzua zzuaVar = new zzua();
        zzw(zzuaVar);
        this.zzc.add(zzuaVar);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzc() throws IOException {
        zzuf zzufVar = new zzuf();
        zzw(zzufVar);
        this.zzc.add(zzufVar);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzd() throws IOException {
        if (this.zzc.isEmpty() || this.zzd != null) {
            throw new IllegalStateException();
        }
        if (!(zzv() instanceof zzua)) {
            throw new IllegalStateException();
        }
        this.zzc.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zze() throws IOException {
        if (this.zzc.isEmpty() || this.zzd != null) {
            throw new IllegalStateException();
        }
        if (!(zzv() instanceof zzuf)) {
            throw new IllegalStateException();
        }
        this.zzc.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzf(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.zzc.isEmpty() || this.zzd != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(zzv() instanceof zzuf)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.zzd = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzg() throws IOException {
        zzw(zzue.zza);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzh(double d2) throws IOException {
        if (zzu() || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
            zzw(new zzuh(Double.valueOf(d2)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzi(long j2) throws IOException {
        zzw(new zzuh(Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzj(Boolean bool) throws IOException {
        if (bool == null) {
            zzw(zzue.zza);
            return this;
        }
        zzw(new zzuh(bool));
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzk(Number number) throws IOException {
        if (number == null) {
            zzw(zzue.zza);
            return this;
        }
        if (!zzu()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(number.toString()));
            }
        }
        zzw(new zzuh(number));
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzl(String str) throws IOException {
        if (str == null) {
            zzw(zzue.zza);
            return this;
        }
        zzw(new zzuh(str));
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaas
    public final zzaas zzm(boolean z) throws IOException {
        zzw(new zzuh(Boolean.valueOf(z)));
        return this;
    }
}
