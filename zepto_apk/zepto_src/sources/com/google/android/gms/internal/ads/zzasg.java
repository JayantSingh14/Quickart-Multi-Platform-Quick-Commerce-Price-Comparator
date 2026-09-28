package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public final class zzasg implements zzaqu {

    /* renamed from: c, reason: collision with root package name */
    public final zzasf f24273c;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f24271a = new LinkedHashMap(16, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    public long f24272b = 0;

    /* renamed from: d, reason: collision with root package name */
    public final int f24274d = 5242880;

    public zzasg(zzasf zzasfVar) {
        this.f24273c = zzasfVar;
    }

    public static byte[] e(zzase zzaseVar, long j2) throws IOException {
        long j3 = zzaseVar.f24269a - zzaseVar.f24270b;
        if (j2 >= 0 && j2 <= j3) {
            int i2 = (int) j2;
            if (i2 == j2) {
                byte[] bArr = new byte[i2];
                new DataInputStream(zzaseVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + 33 + String.valueOf(j3).length());
        androidx.fragment.app.e.A(sb, "streamToBytes length=", j2, ", maxLength=");
        sb.append(j3);
        throw new IOException(sb.toString());
    }

    public static void f(BufferedOutputStream bufferedOutputStream, int i2) throws IOException {
        bufferedOutputStream.write(i2 & 255);
        bufferedOutputStream.write((i2 >> 8) & 255);
        bufferedOutputStream.write((i2 >> 16) & 255);
        bufferedOutputStream.write((i2 >> 24) & 255);
    }

    public static int g(InputStream inputStream) {
        return (m(inputStream) << 24) | m(inputStream) | (m(inputStream) << 8) | (m(inputStream) << 16);
    }

    public static void h(BufferedOutputStream bufferedOutputStream, long j2) throws IOException {
        bufferedOutputStream.write((byte) j2);
        bufferedOutputStream.write((byte) (j2 >>> 8));
        bufferedOutputStream.write((byte) (j2 >>> 16));
        bufferedOutputStream.write((byte) (j2 >>> 24));
        bufferedOutputStream.write((byte) (j2 >>> 32));
        bufferedOutputStream.write((byte) (j2 >>> 40));
        bufferedOutputStream.write((byte) (j2 >>> 48));
        bufferedOutputStream.write((byte) (j2 >>> 56));
    }

    public static long i(InputStream inputStream) {
        return (m(inputStream) & 255) | ((m(inputStream) & 255) << 8) | ((m(inputStream) & 255) << 16) | ((m(inputStream) & 255) << 24) | ((m(inputStream) & 255) << 32) | ((m(inputStream) & 255) << 40) | ((m(inputStream) & 255) << 48) | ((m(inputStream) & 255) << 56);
    }

    public static void j(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        h(bufferedOutputStream, length);
        bufferedOutputStream.write(bytes, 0, length);
    }

    public static String k(zzase zzaseVar) {
        return new String(e(zzaseVar, i(zzaseVar)), "UTF-8");
    }

    public static int m(InputStream inputStream) throws IOException {
        int i2 = inputStream.read();
        if (i2 != -1) {
            return i2;
        }
        throw new EOFException();
    }

    public static final String n(String str) {
        int length = str.length() >> 1;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    public final synchronized zzaqt a(String str) {
        zzasd zzasdVar = (zzasd) this.f24271a.get(str);
        if (zzasdVar == null) {
            return null;
        }
        File fileD = d(str);
        try {
            zzase zzaseVar = new zzase(new BufferedInputStream(new FileInputStream(fileD)), fileD.length());
            try {
                String str2 = zzasd.a(zzaseVar).f24262b;
                if (!TextUtils.equals(str, str2)) {
                    zzarw.b("%s: key=%s, found=%s", fileD.getAbsolutePath(), str, str2);
                    zzasd zzasdVar2 = (zzasd) this.f24271a.remove(str);
                    if (zzasdVar2 != null) {
                        this.f24272b -= zzasdVar2.f24261a;
                    }
                    return null;
                }
                byte[] bArrE = e(zzaseVar, zzaseVar.f24269a - zzaseVar.f24270b);
                zzaqt zzaqtVar = new zzaqt();
                zzaqtVar.f24173a = bArrE;
                zzaqtVar.f24174b = zzasdVar.f24263c;
                zzaqtVar.f24175c = zzasdVar.f24264d;
                zzaqtVar.f24176d = zzasdVar.f24265e;
                zzaqtVar.f24177e = zzasdVar.f24266f;
                zzaqtVar.f24178f = zzasdVar.f24267g;
                List<zzarc> list = zzasdVar.f24268h;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzarc zzarcVar : list) {
                    treeMap.put(zzarcVar.f24198a, zzarcVar.f24199b);
                }
                zzaqtVar.f24179g = treeMap;
                zzaqtVar.f24180h = Collections.unmodifiableList(list);
                return zzaqtVar;
            } finally {
                zzaseVar.close();
            }
        } catch (IOException e2) {
            zzarw.b("%s: %s", fileD.getAbsolutePath(), e2.toString());
            synchronized (this) {
                boolean zDelete = d(str).delete();
                zzasd zzasdVar3 = (zzasd) this.f24271a.remove(str);
                if (zzasdVar3 != null) {
                    this.f24272b -= zzasdVar3.f24261a;
                }
                if (!zDelete) {
                    zzarw.b("Could not delete cache entry for key=%s, filename=%s", str, n(str));
                }
                return null;
            }
        }
    }

    public final synchronized void b(String str, zzaqt zzaqtVar) {
        float f2;
        try {
            long j2 = this.f24272b;
            int length = zzaqtVar.f24173a.length;
            long j3 = j2 + length;
            int i2 = this.f24274d;
            float f3 = 0.9f;
            if (j3 <= i2 || length <= i2 * 0.9f) {
                File fileD = d(str);
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileD));
                    zzasd zzasdVar = new zzasd(str, zzaqtVar);
                    try {
                        f(bufferedOutputStream, 538247942);
                        j(bufferedOutputStream, str);
                        String str2 = zzasdVar.f24263c;
                        if (str2 == null) {
                            str2 = "";
                        }
                        j(bufferedOutputStream, str2);
                        h(bufferedOutputStream, zzasdVar.f24264d);
                        h(bufferedOutputStream, zzasdVar.f24265e);
                        h(bufferedOutputStream, zzasdVar.f24266f);
                        h(bufferedOutputStream, zzasdVar.f24267g);
                        List<zzarc> list = zzasdVar.f24268h;
                        if (list != null) {
                            f(bufferedOutputStream, list.size());
                            for (zzarc zzarcVar : list) {
                                j(bufferedOutputStream, zzarcVar.f24198a);
                                j(bufferedOutputStream, zzarcVar.f24199b);
                            }
                        } else {
                            f(bufferedOutputStream, 0);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.write(zzaqtVar.f24173a);
                        bufferedOutputStream.close();
                        zzasdVar.f24261a = fileD.length();
                        l(str, zzasdVar);
                        long j4 = this.f24272b;
                        int i3 = this.f24274d;
                        if (j4 >= i3) {
                            boolean z = zzarw.f24246a;
                            if (z) {
                                zzarw.a("Pruning old cache entries.", new Object[0]);
                            }
                            long j5 = this.f24272b;
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            Iterator it = this.f24271a.entrySet().iterator();
                            int i4 = 0;
                            while (it.hasNext()) {
                                zzasd zzasdVar2 = (zzasd) ((Map.Entry) it.next()).getValue();
                                String str3 = zzasdVar2.f24262b;
                                if (d(str3).delete()) {
                                    f2 = f3;
                                    this.f24272b -= zzasdVar2.f24261a;
                                } else {
                                    f2 = f3;
                                    zzarw.b("Could not delete cache entry for key=%s, filename=%s", str3, n(str3));
                                }
                                it.remove();
                                i4++;
                                if (this.f24272b < i3 * f2) {
                                    break;
                                } else {
                                    f3 = f2;
                                }
                            }
                            if (z) {
                                zzarw.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i4), Long.valueOf(this.f24272b - j5), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                            }
                        }
                    } catch (IOException e2) {
                        zzarw.b("%s", e2.toString());
                        bufferedOutputStream.close();
                        zzarw.b("Failed to write header for %s", fileD.getAbsolutePath());
                        throw new IOException();
                    }
                } catch (IOException unused) {
                    if (!fileD.delete()) {
                        zzarw.b("Could not clean up file %s", fileD.getAbsolutePath());
                    }
                    if (!this.f24273c.zza().exists()) {
                        zzarw.b("Re-initializing cache after external clearing.", new Object[0]);
                        this.f24271a.clear();
                        this.f24272b = 0L;
                        c();
                    }
                }
            }
        } finally {
        }
    }

    public final synchronized void c() {
        File fileZza = this.f24273c.zza();
        if (fileZza.exists()) {
            File[] fileArrListFiles = fileZza.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    try {
                        long length = file.length();
                        zzase zzaseVar = new zzase(new BufferedInputStream(new FileInputStream(file)), length);
                        try {
                            zzasd zzasdVarA = zzasd.a(zzaseVar);
                            zzasdVarA.f24261a = length;
                            l(zzasdVarA.f24262b, zzasdVarA);
                            zzaseVar.close();
                        } catch (Throwable th) {
                            zzaseVar.close();
                            throw th;
                        }
                    } catch (IOException unused) {
                        file.delete();
                    }
                }
            }
        } else if (!fileZza.mkdirs()) {
            zzarw.c("Unable to create cache dir %s", fileZza.getAbsolutePath());
        }
    }

    public final File d(String str) {
        return new File(this.f24273c.zza(), n(str));
    }

    public final void l(String str, zzasd zzasdVar) {
        LinkedHashMap linkedHashMap = this.f24271a;
        if (linkedHashMap.containsKey(str)) {
            this.f24272b = (zzasdVar.f24261a - ((zzasd) linkedHashMap.get(str)).f24261a) + this.f24272b;
        } else {
            this.f24272b += zzasdVar.f24261a;
        }
        linkedHashMap.put(str, zzasdVar);
    }

    public zzasg(File file) {
        this.f24273c = new zzasc(this, file);
    }
}
