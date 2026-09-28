package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.Method;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzgfk extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final Context f32461f;

    public zzgfk(zzavs zzavsVar, zzgev zzgevVar, Context context, zzgnc zzgncVar) {
        super("ElEd4VcZAEfP2Wn07dNn4m5KzOJYeOBfSNpGODwEVMM987QtZ6G7lEZTIkvpOYy8", "f+lS1NLa9mNIIiIqU+oCtIwtOpjS/HcJD4HNhQ2VxXc=", zzavsVar, zzgevVar, zzgncVar.a(WKSRecord.Service.SFTP));
        this.f32461f = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        Object[] objArr = (Object[]) method.invoke("", this.f32461f);
        objArr.getClass();
        synchronized (zzavsVar) {
            try {
                long jIntValue = ((Integer) objArr[0]).intValue();
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).a0(jIntValue);
                int i2 = 1;
                long jIntValue2 = ((Integer) objArr[1]).intValue();
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).K0(jIntValue2);
                long jIntValue3 = ((Integer) objArr[2]).intValue();
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).L0(jIntValue3);
                long jIntValue4 = ((Integer) objArr[3]).intValue();
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).p0(jIntValue4);
                Boolean bool = (Boolean) objArr[4];
                if (bool == null) {
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).t0(3);
                } else {
                    int i3 = true != bool.booleanValue() ? 1 : 2;
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).t0(i3);
                }
                Boolean bool2 = (Boolean) objArr[5];
                if (bool2 == null) {
                    zzavsVar.n(3);
                } else {
                    if (true == bool2.booleanValue()) {
                        i2 = 2;
                    }
                    zzavsVar.n(i2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
