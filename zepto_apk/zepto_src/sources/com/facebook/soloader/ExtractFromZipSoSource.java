package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.SysUtil;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes3.dex */
public class ExtractFromZipSoSource extends UnpackingSoSource {

    /* renamed from: e, reason: collision with root package name */
    public final File f20268e;

    /* renamed from: f, reason: collision with root package name */
    public final String f20269f;

    public static final class ZipDso extends UnpackingSoSource.Dso implements Comparable<ZipDso> {

        /* renamed from: c, reason: collision with root package name */
        public final ZipEntry f20270c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20271d;

        public ZipDso(String str, ZipEntry zipEntry, int i2) {
            super(str, String.valueOf(zipEntry.getCrc()));
            this.f20270c = zipEntry;
            this.f20271d = i2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(ZipDso zipDso) {
            return this.f20304a.compareTo(zipDso.f20304a);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ZipDso.class == obj.getClass()) {
                ZipDso zipDso = (ZipDso) obj;
                if (this.f20270c.equals(zipDso.f20270c) && this.f20271d == zipDso.f20271d) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f20270c.hashCode() + (this.f20271d * 31);
        }
    }

    public class ZipUnpacker extends UnpackingSoSource.Unpacker {

        /* renamed from: a, reason: collision with root package name */
        public ZipDso[] f20272a;

        /* renamed from: b, reason: collision with root package name */
        public final ZipFile f20273b;

        /* renamed from: c, reason: collision with root package name */
        public final ExtractFromZipSoSource f20274c;

        public ZipUnpacker(ExtractFromZipSoSource extractFromZipSoSource) {
            this.f20273b = new ZipFile(ExtractFromZipSoSource.this.f20268e);
            this.f20274c = extractFromZipSoSource;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.Dso[] b() {
            ZipDso[] zipDsoArr = this.f20272a;
            if (zipDsoArr != null) {
                return zipDsoArr;
            }
            ZipDso[] zipDsoArrE = e();
            this.f20272a = zipDsoArrE;
            return zipDsoArrE;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final void c(File file) throws IOException {
            ZipDso[] zipDsoArrE = this.f20272a;
            if (zipDsoArrE == null) {
                zipDsoArrE = e();
                this.f20272a = zipDsoArrE;
            }
            byte[] bArr = new byte[32768];
            for (ZipDso zipDso : zipDsoArrE) {
                InputStream inputStream = this.f20273b.getInputStream(zipDso.f20270c);
                try {
                    UnpackingSoSource.InputDso inputDso = new UnpackingSoSource.InputDso(zipDso, inputStream);
                    inputStream = null;
                    try {
                        UnpackingSoSource.Unpacker.a(inputDso, bArr, file);
                        inputDso.close();
                    } finally {
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this.f20273b.close();
        }

        public final ZipDso[] e() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            HashMap map = new HashMap();
            Pattern patternCompile = Pattern.compile(ExtractFromZipSoSource.this.f20269f);
            String[] supportedAbis = SysUtil.MarshmallowSysdeps.getSupportedAbis();
            Enumeration<? extends ZipEntry> enumerationEntries = this.f20273b.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                Matcher matcher = patternCompile.matcher(zipEntryNextElement.getName());
                if (matcher.matches()) {
                    int iGroupCount = matcher.groupCount();
                    String strGroup = matcher.group(iGroupCount - 1);
                    String strGroup2 = matcher.group(iGroupCount);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= supportedAbis.length) {
                            i2 = -1;
                            break;
                        }
                        String str = supportedAbis[i2];
                        if (str != null && strGroup.equals(str)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 >= 0) {
                        linkedHashSet.add(strGroup);
                        ZipDso zipDso = (ZipDso) map.get(strGroup2);
                        if (zipDso == null || i2 < zipDso.f20271d) {
                            map.put(strGroup2, new ZipDso(strGroup2, zipEntryNextElement, i2));
                        }
                    }
                }
            }
            this.f20274c.getClass();
            ZipDso[] zipDsoArr = (ZipDso[]) map.values().toArray(new ZipDso[map.size()]);
            Arrays.sort(zipDsoArr);
            return zipDsoArr;
        }
    }

    public ExtractFromZipSoSource(Context context, String str, File file) {
        super(context, str, true);
        this.f20268e = file;
        this.f20269f = "^lib/([^/]+)/([^/]+\\.so)$";
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public final String c() {
        return "ExtractFromZipSoSource";
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public final UnpackingSoSource.Unpacker h() {
        return new ZipUnpacker(this);
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public final String toString() {
        File file = this.f20268e;
        try {
            return file.getCanonicalPath();
        } catch (IOException unused) {
            return file.getName();
        }
    }
}
