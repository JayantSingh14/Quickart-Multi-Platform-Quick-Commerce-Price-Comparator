package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzgib {

    /* renamed from: a, reason: collision with root package name */
    public final File f32633a;

    /* renamed from: b, reason: collision with root package name */
    public final File f32634b;

    /* renamed from: c, reason: collision with root package name */
    public final SharedPreferences f32635c;

    /* renamed from: d, reason: collision with root package name */
    public final zzija f32636d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgnc f32637e;

    public zzgib(Context context, SharedPreferences sharedPreferences, zzija zzijaVar, zzgnc zzgncVar) {
        this.f32635c = sharedPreferences;
        File dir = context.getDir("pccache2", 0);
        zzfvq.d(dir, false);
        this.f32633a = dir;
        File dir2 = context.getDir("tmppccache2", 0);
        zzfvq.d(dir2, true);
        this.f32634b = dir2;
        this.f32636d = zzijaVar;
        this.f32637e = zzgncVar;
    }

    public final void a(zzgcs zzgcsVar, byte[] bArr, byte[] bArr2) throws IllegalArgumentException {
        String strC = zzgcsVar.C().C();
        boolean zIsEmpty = TextUtils.isEmpty(strC);
        zzgnc zzgncVar = this.f32637e;
        if (!zIsEmpty && bArr2.length != 0) {
            File file = this.f32634b;
            zzfvq.e(file);
            file.mkdirs();
            File fileC = zzfvq.c(strC, file);
            fileC.getClass();
            fileC.mkdirs();
            File fileA = zzfvq.a(file, strC, "pcam.jar");
            fileA.getClass();
            if (bArr == null || bArr.length <= 0 || zzfvq.b(fileA, bArr)) {
                File fileA2 = zzfvq.a(file, strC, "pcbc");
                fileA2.getClass();
                if (zzfvq.b(fileA2, bArr2)) {
                    String strC2 = zzgcsVar.C().C();
                    if (!TextUtils.isEmpty(strC2)) {
                        File fileA3 = zzfvq.a(file, strC2, "pcam.jar");
                        fileA3.getClass();
                        File fileA4 = zzfvq.a(file, strC2, "pcbc");
                        fileA4.getClass();
                        File fileA5 = zzfvq.a(c(), strC2, "pcam.jar");
                        fileA5.getClass();
                        File fileA6 = zzfvq.a(c(), strC2, "pcbc");
                        fileA6.getClass();
                        if (fileA3.exists() && !fileA3.renameTo(fileA5)) {
                            zzgncVar.b(15318);
                        } else if (fileA4.exists() && fileA4.renameTo(fileA6)) {
                            zzgcs zzgcsVarB = b(1);
                            SharedPreferences.Editor editorEdit = this.f32635c.edit();
                            if (zzgcsVarB != null && !zzgcsVar.C().C().equals(zzgcsVarB.C().C())) {
                                editorEdit.putString(d(), Hex.bytesToStringLowercase(zzgcsVarB.g()));
                            }
                            editorEdit.putString(e(), Hex.bytesToStringLowercase(zzgcsVar.g()));
                            if (!editorEdit.commit()) {
                                zzgncVar.b(15320);
                            }
                        } else {
                            zzgncVar.b(15319);
                        }
                    }
                    HashSet hashSet = new HashSet();
                    zzgcs zzgcsVarB2 = b(1);
                    if (zzgcsVarB2 != null) {
                        hashSet.add(zzgcsVarB2.C().C());
                    }
                    zzgcs zzgcsVarB3 = b(2);
                    if (zzgcsVarB3 != null) {
                        hashSet.add(zzgcsVarB3.C().C());
                    }
                    File[] fileArrListFiles = c().listFiles();
                    if (fileArrListFiles != null) {
                        for (File file2 : fileArrListFiles) {
                            String name = file2.getName();
                            if (!hashSet.contains(name)) {
                                File fileC2 = zzfvq.c(name, c());
                                fileC2.getClass();
                                zzfvq.e(fileC2);
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
        zzgncVar.b(15316);
    }

    public final zzgcs b(int i2) throws IllegalArgumentException {
        SharedPreferences sharedPreferences = this.f32635c;
        String string = i2 == 1 ? sharedPreferences.getString(e(), null) : sharedPreferences.getString(d(), null);
        if (!TextUtils.isEmpty(string)) {
            try {
                byte[] bArrStringToBytes = Hex.stringToBytes(string);
                zzhzl zzhzlVar = zzhzl.f34557b;
                zzgcs zzgcsVarF = zzgcs.F(zzhzl.v(0, bArrStringToBytes, bArrStringToBytes.length));
                String strC = zzgcsVarF.C().C();
                File fileA = zzfvq.a(c(), strC, "pcam.jar");
                if (fileA == null) {
                    throw null;
                }
                if (!fileA.exists() && (fileA = zzfvq.a(c(), strC, "pcam")) == null) {
                    throw null;
                }
                File fileA2 = zzfvq.a(c(), strC, "pcbc");
                if (fileA2 == null) {
                    throw null;
                }
                if (fileA.exists() && fileA2.exists()) {
                    return zzgcsVarF;
                }
            } catch (zzibg unused) {
                this.f32637e.b(15317);
            }
        }
        return null;
    }

    public final File c() {
        File file = new File(this.f32633a, Integer.toString(((zzbbq) this.f32636d.zzb()).f24687a));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public final String d() {
        int i2 = ((zzbbq) this.f32636d.zzb()).f24687a;
        return androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 6), i2, "FBAMTD");
    }

    public final String e() {
        int i2 = ((zzbbq) this.f32636d.zzb()).f24687a;
        return androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 6), i2, "LATMTD");
    }
}
