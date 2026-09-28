package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.internal.zzacl;
import com.google.ads.interactivemedia.v3.internal.zzacq;
import java.io.IOException;

/* loaded from: classes3.dex */
public class zzacl<MessageType extends zzacq<MessageType, BuilderType>, BuilderType extends zzacl<MessageType, BuilderType>> extends zzaau<MessageType, BuilderType> {
    protected zzacq zza;
    private final zzacq zzb;

    public zzacl(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzaO()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzaA();
    }

    private static void zza(Object obj, Object obj2) {
        zzaei.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaea
    public final /* synthetic */ zzadz zzaS() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaea
    public final boolean zzaT() {
        return zzacq.zzaN(this.zza, false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaau
    /* renamed from: zzai, reason: merged with bridge method [inline-methods] */
    public final zzacl clone() {
        zzacl zzaclVar = (zzacl) this.zzb.zzj(5, null, null);
        zzaclVar.zza = zzao();
        return zzaclVar;
    }

    public final zzacl zzaj(zzacq zzacqVar) {
        if (!this.zzb.equals(zzacqVar)) {
            if (!this.zza.zzaO()) {
                zzar();
            }
            zza(this.zza, zzacqVar);
        }
        return this;
    }

    public final zzacl zzak(byte[] bArr, int i2, int i3, zzacb zzacbVar) throws zzacz {
        if (!this.zza.zzaO()) {
            zzar();
        }
        try {
            zzaei.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i3, new zzaaz(zzacbVar));
            return this;
        } catch (zzacz e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
        } catch (IndexOutOfBoundsException unused) {
            throw zzacz.zzi();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzady
    /* renamed from: zzal, reason: merged with bridge method [inline-methods] */
    public final MessageType zzan() {
        MessageType messagetype = (MessageType) zzao();
        if (messagetype.zzaT()) {
            return messagetype;
        }
        throw new zzafj(messagetype);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzady
    /* renamed from: zzam, reason: merged with bridge method [inline-methods] */
    public MessageType zzao() {
        if (!this.zza.zzaO()) {
            return (MessageType) this.zza;
        }
        this.zza.zzaJ();
        return (MessageType) this.zza;
    }

    public final void zzaq() {
        if (this.zza.zzaO()) {
            return;
        }
        zzar();
    }

    public void zzar() {
        zzacq zzacqVarZzaA = this.zzb.zzaA();
        zza(zzacqVarZzaA, this.zza);
        this.zza = zzacqVarZzaA;
    }
}
