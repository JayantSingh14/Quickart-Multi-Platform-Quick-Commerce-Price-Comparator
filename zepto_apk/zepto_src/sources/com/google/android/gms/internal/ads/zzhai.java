package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzhai implements zzhih {

    /* renamed from: a, reason: collision with root package name */
    public final List f33432a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhip f33433b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhai f33434c;

    public zzhai(ArrayList arrayList, zzhip zzhipVar, zzhai zzhaiVar) {
        this.f33432a = arrayList;
        this.f33433b = zzhipVar;
        this.f33434c = zzhaiVar;
    }

    public static final zzhai a(zzhpj zzhpjVar) {
        zzgzx zzhimVar;
        boolean z;
        if (zzhpjVar == null || zzhpjVar.E() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        ArrayList arrayList = new ArrayList(zzhpjVar.E());
        for (zzhpi zzhpiVar : zzhpjVar.D()) {
            int iE = zzhpiVar.E();
            try {
                zzhjz zzhjzVarG = g(zzhpiVar);
                zzhje zzhjeVar = zzhje.f33884b;
                zzhki zzhkiVar = (zzhki) zzhjeVar.f33885a.get();
                zzhkiVar.getClass();
                zzhimVar = !zzhkiVar.f33929b.containsKey(new zzhkg(zzhjz.class, zzhjzVarG.f33910b)) ? new zzhim(zzhjzVarG) : zzhjeVar.e(zzhjzVarG);
                z = false;
            } catch (GeneralSecurityException e2) {
                if (((zzhgy) zzhgz.f33781a).f33780a.get()) {
                    throw e2;
                }
                zzhimVar = new zzhim(g(zzhpiVar));
                z = true;
            }
            if (((zzhgy) zzhgz.f33781a).f33780a.get() && !h(zzhpiVar.K())) {
                throw new GeneralSecurityException("Parsing of a single key failed (wrong status) and Tink is configured via validateKeysetsOnParsing to reject such keysets.");
            }
            boolean z2 = true;
            int iK = zzhpiVar.K();
            if (iE != zzhpjVar.C()) {
                z2 = false;
            }
            arrayList.add(new zzhag(zzhimVar, iK, iE, z2, z, zzhaf.f33424a));
        }
        return new zzhai(Collections.unmodifiableList(arrayList), zzhip.f33865b);
    }

    public static final zzhai e(zzhan zzhanVar) throws GeneralSecurityException {
        int i2;
        int i3;
        zzhad zzhadVar = new zzhad();
        zzhab zzhabVar = new zzhab(zzhanVar);
        zzhac zzhacVar = zzhac.f33420a;
        zzhabVar.f33419c = zzhacVar;
        zzhabVar.f33417a = true;
        ArrayList arrayList = zzhadVar.f33421a;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((zzhab) it.next()).f33417a = false;
        }
        arrayList.add(zzhabVar);
        if (zzhadVar.f33423c) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        zzhadVar.f33423c = true;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int i4 = 0;
        while (i4 < arrayList.size() - 1) {
            int i5 = i4 + 1;
            if (((zzhab) arrayList.get(i4)).f33419c == zzhacVar && ((zzhab) arrayList.get(i5)).f33419c != zzhacVar) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
            i4 = i5;
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = arrayList.iterator();
        Integer num = null;
        while (it2.hasNext()) {
            zzhab zzhabVar2 = (zzhab) it2.next();
            zzhabVar2.getClass();
            zzhac zzhacVar2 = zzhabVar2.f33419c;
            if (zzhacVar2 == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            int i6 = 3;
            if (zzhacVar2 == zzhacVar) {
                int i7 = 0;
                while (true) {
                    if (i7 != 0 && !hashSet.contains(Integer.valueOf(i7))) {
                        break;
                    }
                    int i8 = zzhkl.f33932a;
                    i7 = 0;
                    while (i7 == 0) {
                        byte[] bArrA = zzhkc.a(4);
                        i7 = (bArrA[3] & 255) | ((bArrA[0] & 255) << 24) | ((bArrA[1] & 255) << 16) | ((bArrA[2] & 255) << 8);
                    }
                }
                i2 = i7;
            } else {
                i2 = 0;
            }
            Integer numValueOf = Integer.valueOf(i2);
            if (hashSet.contains(numValueOf)) {
                int i9 = i2;
                throw new GeneralSecurityException(androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i9).length() + 31), "Id ", i9, " is used twice in the keyset"));
            }
            hashSet.add(numValueOf);
            zzhan zzhanVar2 = zzhabVar2.f33418b;
            zzgzx zzgzxVarB = zzhiv.f33870c.b(zzhanVar2, true != zzhanVar2.a() ? null : numValueOf);
            Object obj = zzgzz.f33407b;
            if (obj.equals(obj)) {
                i3 = i6;
            } else if (zzgzz.f33408c.equals(obj)) {
                i3 = 4;
            } else {
                if (!zzgzz.f33409d.equals(obj)) {
                    throw new IllegalStateException("Unknown key status");
                }
                i6 = 5;
                i3 = i6;
            }
            boolean z = zzhabVar2.f33417a;
            zzhag zzhagVar = new zzhag(zzgzxVarB, i3, i2, z, false, zzhaf.f33424a);
            if (z) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                num = numValueOf;
            }
            arrayList2.add(zzhagVar);
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzhip zzhipVar = zzhadVar.f33422b;
        zzhai zzhaiVar = new zzhai(arrayList2, zzhipVar);
        if (zzhipVar.f33866a.isEmpty()) {
            return zzhaiVar;
        }
        zzhah zzhahVar = new zzhah();
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            zzhag zzhagVar2 = (zzhag) it3.next();
            arrayList3.add(new zzhag(zzhagVar2.f33425a, zzhagVar2.f33431g, zzhagVar2.f33427c, zzhagVar2.f33428d, zzhagVar2.f33429e, zzhahVar));
        }
        return new zzhai(arrayList3, zzhipVar, zzhaiVar);
    }

    public static zzhjz g(zzhpi zzhpiVar) {
        return zzhjz.a(zzhpiVar.D().C(), zzhpiVar.D().D(), zzhpiVar.D().E(), zzhpiVar.F(), zzhpiVar.F() == zzhpw.RAW ? null : Integer.valueOf(zzhpiVar.E()));
    }

    public static boolean h(int i2) {
        int i3 = i2 - 2;
        return i3 == 1 || i3 == 2 || i3 == 3;
    }

    public final zzhpj b() throws GeneralSecurityException {
        try {
            zzhpg zzhpgVarI = zzhpj.I();
            for (zzhag zzhagVar : this.f33432a) {
                zzgzx zzgzxVarA = zzhagVar.a();
                int i2 = zzhagVar.f33431g;
                zzhjz zzhjzVar = (zzhjz) zzhje.f33884b.f(zzgzxVarA);
                Integer numB = zzgzxVarA.b();
                int i3 = zzhagVar.f33427c;
                if (numB != null && numB.intValue() != i3) {
                    throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
                }
                zzhph zzhphVarG = zzhpi.G();
                zzhoy zzhoyVarF = zzhpa.F();
                String str = zzhjzVar.f33909a;
                zzhoyVarF.j();
                ((zzhpa) zzhoyVarF.f34638b).H(str);
                zzhzl zzhzlVar = zzhjzVar.f33911c;
                zzhoyVarF.j();
                ((zzhpa) zzhoyVarF.f34638b).I(zzhzlVar);
                zzhoz zzhozVar = zzhjzVar.f33912d;
                zzhoyVarF.j();
                ((zzhpa) zzhoyVarF.f34638b).J(zzhozVar);
                zzhphVarG.j();
                ((zzhpi) zzhphVarG.f34638b).H((zzhpa) zzhoyVarF.l());
                zzhphVarG.j();
                ((zzhpi) zzhphVarG.f34638b).L(i2);
                zzhphVarG.j();
                ((zzhpi) zzhphVarG.f34638b).I(i3);
                zzhpw zzhpwVar = zzhjzVar.f33913e;
                zzhphVarG.j();
                ((zzhpi) zzhphVarG.f34638b).J(zzhpwVar);
                zzhpi zzhpiVar = (zzhpi) zzhphVarG.l();
                zzhpgVarI.j();
                ((zzhpj) zzhpgVarI.f34638b).K(zzhpiVar);
                if (zzhagVar.f33428d) {
                    zzhpgVarI.j();
                    ((zzhpj) zzhpgVarI.f34638b).J(i3);
                }
            }
            return (zzhpj) zzhpgVarI.l();
        } catch (GeneralSecurityException e2) {
            throw new zzhkk(e2);
        }
    }

    public final zzhag c() {
        for (zzhag zzhagVar : this.f33432a) {
            if (zzhagVar != null && zzhagVar.f33428d) {
                if (zzhagVar.f33426b == zzgzz.f33407b) {
                    return zzhagVar;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no valid primary");
    }

    public final zzhag d(int i2) {
        List list = this.f33432a;
        if (i2 < 0 || i2 >= list.size()) {
            int size = list.size();
            throw new IndexOutOfBoundsException(androidx.fragment.app.e.n(i2, size, "Invalid index ", " for keyset of size ", new StringBuilder(String.valueOf(i2).length() + 34 + String.valueOf(size).length())));
        }
        zzhag zzhagVar = (zzhag) list.get(i2);
        if (!h(zzhagVar.f33431g)) {
            throw new IllegalStateException(androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i2).length() + 42), "Keyset-Entry at position ", i2, " has wrong status"));
        }
        if (zzhagVar.f33429e) {
            throw new IllegalStateException(androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i2).length() + 48), "Keyset-Entry at position ", i2, " didn't parse correctly"));
        }
        return (zzhag) list.get(i2);
    }

    public final Object f(zzhhv zzhhvVar, Class cls) throws GeneralSecurityException {
        if (zzhhvVar == null) {
            throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
        }
        zzhai zzhaiVar = this.f33434c;
        zzhpj zzhpjVarB = (zzhaiVar == null ? this : zzhaiVar).b();
        int i2 = zzhau.f33436a;
        int iC = zzhpjVarB.C();
        int i3 = 0;
        boolean z = true;
        int i4 = 0;
        boolean z2 = false;
        for (zzhpi zzhpiVar : zzhpjVarB.D()) {
            if (zzhpiVar.K() == 3) {
                if (!zzhpiVar.C()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzhpiVar.E())));
                }
                if (zzhpiVar.F() == zzhpw.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzhpiVar.E())));
                }
                if (zzhpiVar.K() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzhpiVar.E())));
                }
                if (zzhpiVar.E() == iC) {
                    if (z2) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z2 = true;
                }
                z &= zzhpiVar.D().E() == zzhoz.ASYMMETRIC_PUBLIC;
                i4++;
            }
        }
        if (i4 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z2 && !z) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        while (true) {
            List list = this.f33432a;
            if (i3 >= list.size()) {
                if (zzhaiVar == null) {
                    zzhaiVar = this;
                }
                return zzhhvVar.a(zzhaiVar, this.f33433b, cls);
            }
            if (((zzhag) list.get(i3)).f33429e || !h(((zzhag) list.get(i3)).f33431g)) {
                break;
            }
            i3++;
        }
        String strC = zzhpjVarB.F(i3).D().C();
        StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + String.valueOf(i3).length() + 44 + 32);
        sb.append("Key parsing of key with index ");
        sb.append(i3);
        sb.append(" and type_url ");
        sb.append(strC);
        sb.append(" failed, unable to get primitive");
        throw new GeneralSecurityException(sb.toString());
    }

    public final String toString() throws GeneralSecurityException {
        zzhpj zzhpjVarB = b();
        int i2 = zzhau.f33436a;
        zzhpk zzhpkVarC = zzhpn.C();
        int iC = zzhpjVarB.C();
        zzhpkVarC.j();
        ((zzhpn) zzhpkVarC.f34638b).D(iC);
        for (zzhpi zzhpiVar : zzhpjVarB.D()) {
            zzhpl zzhplVarC = zzhpm.C();
            String strC = zzhpiVar.D().C();
            zzhplVarC.j();
            ((zzhpm) zzhplVarC.f34638b).D(strC);
            int iK = zzhpiVar.K();
            zzhplVarC.j();
            ((zzhpm) zzhplVarC.f34638b).G(iK);
            zzhpw zzhpwVarF = zzhpiVar.F();
            zzhplVarC.j();
            ((zzhpm) zzhplVarC.f34638b).F(zzhpwVarF);
            int iE = zzhpiVar.E();
            zzhplVarC.j();
            ((zzhpm) zzhplVarC.f34638b).E(iE);
            zzhpm zzhpmVar = (zzhpm) zzhplVarC.l();
            zzhpkVarC.j();
            ((zzhpn) zzhpkVarC.f34638b).E(zzhpmVar);
        }
        return ((zzhpn) zzhpkVarC.l()).toString();
    }

    public zzhai(List list, zzhip zzhipVar) throws GeneralSecurityException {
        this.f33432a = list;
        this.f33433b = zzhipVar;
        if (((zzhgy) zzhgz.f33781a).f33780a.get()) {
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            boolean z = false;
            while (it.hasNext()) {
                zzhag zzhagVar = (zzhag) it.next();
                boolean zContains = hashSet.contains(Integer.valueOf(zzhagVar.f33427c));
                int i2 = zzhagVar.f33427c;
                if (zContains) {
                    throw new GeneralSecurityException(androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i2).length() + WKSRecord.Service.ERPC), "KeyID ", i2, " is duplicated in the keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing."));
                }
                hashSet.add(Integer.valueOf(i2));
                z |= zzhagVar.f33428d;
            }
            if (!z) {
                throw new GeneralSecurityException("Primary key id not found in keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
            }
        }
        this.f33434c = null;
    }
}
