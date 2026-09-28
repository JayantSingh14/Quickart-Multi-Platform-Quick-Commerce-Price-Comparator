package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzfvw {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f31949f = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Context f31950a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f31951b;

    /* renamed from: c, reason: collision with root package name */
    public final String f31952c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfvd f31953d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f31954e;

    public zzfvw(Context context, zzbbq zzbbqVar, zzfvd zzfvdVar, boolean z) {
        this.f31954e = false;
        this.f31950a = context;
        this.f31952c = Integer.toString(zzbbqVar.f24687a);
        this.f31951b = context.getSharedPreferences("pcvmspf", 0);
        this.f31953d = zzfvdVar;
        this.f31954e = z;
    }

    public static String d(zzbbs zzbbsVar) {
        zzbbx zzbbxVarJ = zzbby.J();
        String strC = zzbbsVar.C().C();
        zzbbxVarJ.j();
        ((zzbby) zzbbxVarJ.f34638b).L(strC);
        String strD = zzbbsVar.C().D();
        zzbbxVarJ.j();
        ((zzbby) zzbbxVarJ.f34638b).M(strD);
        long jF = zzbbsVar.C().F();
        zzbbxVarJ.j();
        ((zzbby) zzbbxVarJ.f34638b).O(jF);
        long jG = zzbbsVar.C().G();
        zzbbxVarJ.j();
        ((zzbby) zzbbxVarJ.f34638b).P(jG);
        long jE = zzbbsVar.C().E();
        zzbbxVarJ.j();
        ((zzbby) zzbbxVarJ.f34638b).N(jE);
        return Hex.bytesToStringLowercase(((zzbby) zzbbxVarJ.l()).g());
    }

    public final boolean a(zzbbs zzbbsVar, zzfvv zzfvvVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (f31949f) {
            try {
                zzbby zzbbyVarF = f(1);
                String strC = zzbbsVar.C().C();
                if (zzbbyVarF != null && zzbbyVarF.C().equals(strC)) {
                    e(4014, jCurrentTimeMillis);
                    return false;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                File fileC = c(strC);
                if (fileC.exists()) {
                    String str = true != fileC.isDirectory() ? "0" : "1";
                    String str2 = true != fileC.isFile() ? "0" : "1";
                    StringBuilder sb = new StringBuilder(7);
                    sb.append("d:");
                    sb.append(str);
                    sb.append(",f:");
                    sb.append(str2);
                    this.f31953d.zzb(4023, jCurrentTimeMillis2, sb.toString());
                    e(4015, jCurrentTimeMillis2);
                } else if (!fileC.mkdirs()) {
                    this.f31953d.zzb(4024, jCurrentTimeMillis2, "cw:".concat(true != fileC.canWrite() ? "0" : "1"));
                    e(4015, jCurrentTimeMillis2);
                    return false;
                }
                File fileC2 = c(strC);
                File file = new File(fileC2, "pcam.jar");
                File file2 = new File(fileC2, "pcbc");
                if (!zzfvq.b(file, zzbbsVar.D().z())) {
                    e(4016, jCurrentTimeMillis);
                    return false;
                }
                if (!zzfvq.b(file2, zzbbsVar.E().z())) {
                    e(4017, jCurrentTimeMillis);
                    return false;
                }
                if (zzfvvVar != null && !((zzayg) zzfvvVar).a(file)) {
                    e(4018, jCurrentTimeMillis);
                    zzfvq.e(fileC2);
                    return false;
                }
                String strD = d(zzbbsVar);
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                SharedPreferences sharedPreferences = this.f31951b;
                String string = sharedPreferences.getString("LATMTD".concat(String.valueOf(this.f31952c)), null);
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("LATMTD".concat(String.valueOf(this.f31952c)), strD);
                if (string != null) {
                    editorEdit.putString("FBAMTD".concat(String.valueOf(this.f31952c)), string);
                }
                if (!editorEdit.commit()) {
                    e(4019, jCurrentTimeMillis3);
                    return false;
                }
                HashSet hashSet = new HashSet();
                zzbby zzbbyVarF2 = f(1);
                if (zzbbyVarF2 != null) {
                    hashSet.add(zzbbyVarF2.C());
                }
                zzbby zzbbyVarF3 = f(2);
                if (zzbbyVarF3 != null) {
                    hashSet.add(zzbbyVarF3.C());
                }
                for (File file3 : new File(this.f31950a.getDir("pccache", 0), this.f31952c).listFiles()) {
                    if (!hashSet.contains(file3.getName())) {
                        zzfvq.e(file3);
                    }
                }
                e(5014, jCurrentTimeMillis);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b(zzbbs zzbbsVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (f31949f) {
            try {
                if (!zzfvq.b(new File(c(zzbbsVar.C().C()), "pcbc"), zzbbsVar.E().z())) {
                    e(4020, jCurrentTimeMillis);
                    return false;
                }
                String strD = d(zzbbsVar);
                SharedPreferences.Editor editorEdit = this.f31951b.edit();
                editorEdit.putString("LATMTD".concat(String.valueOf(this.f31952c)), strD);
                boolean zCommit = editorEdit.commit();
                if (zCommit) {
                    e(5015, jCurrentTimeMillis);
                } else {
                    e(4021, jCurrentTimeMillis);
                }
                return zCommit;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final File c(String str) {
        return new File(new File(this.f31950a.getDir("pccache", 0), this.f31952c), str);
    }

    public final void e(int i2, long j2) {
        this.f31953d.zza(i2, j2);
    }

    public final zzbby f(int i2) {
        zziab zziabVarA;
        String str = this.f31952c;
        SharedPreferences sharedPreferences = this.f31951b;
        String string = i2 == 1 ? sharedPreferences.getString("LATMTD".concat(String.valueOf(str)), null) : sharedPreferences.getString("FBAMTD".concat(String.valueOf(str)), null);
        if (string != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                byte[] bArrStringToBytes = Hex.stringToBytes(string);
                zzhzl zzhzlVar = zzhzl.f34557b;
                zzhzl zzhzlVarV = zzhzl.v(0, bArrStringToBytes, bArrStringToBytes.length);
                if (this.f31954e) {
                    zziab zziabVar = zziab.f34620b;
                    int i3 = zzhyy.f34536a;
                    zziabVarA = zziab.f34621c;
                } else {
                    zziabVarA = zziab.a();
                }
                return zzbby.I(zzhzlVarV, zziabVarA);
            } catch (zzibg unused) {
            } catch (NullPointerException unused2) {
                e(2029, jCurrentTimeMillis);
            } catch (RuntimeException unused3) {
                e(2032, jCurrentTimeMillis);
            }
        }
        return null;
    }
}
