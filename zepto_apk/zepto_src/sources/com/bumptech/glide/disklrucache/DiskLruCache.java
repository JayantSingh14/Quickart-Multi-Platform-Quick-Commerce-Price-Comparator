package com.bumptech.glide.disklrucache;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public final class DiskLruCache implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final File f15716a;

    /* renamed from: b, reason: collision with root package name */
    public final File f15717b;

    /* renamed from: c, reason: collision with root package name */
    public final File f15718c;

    /* renamed from: d, reason: collision with root package name */
    public final File f15719d;

    /* renamed from: f, reason: collision with root package name */
    public final long f15721f;

    /* renamed from: i, reason: collision with root package name */
    public BufferedWriter f15724i;

    /* renamed from: k, reason: collision with root package name */
    public int f15726k;

    /* renamed from: h, reason: collision with root package name */
    public long f15723h = 0;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f15725j = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: l, reason: collision with root package name */
    public long f15727l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final ThreadPoolExecutor f15728m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory());
    public final Callable n = new Callable<Void>() { // from class: com.bumptech.glide.disklrucache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        public final Void call() {
            synchronized (DiskLruCache.this) {
                try {
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    if (diskLruCache.f15724i == null) {
                        return null;
                    }
                    diskLruCache.V();
                    if (DiskLruCache.this.s()) {
                        DiskLruCache.this.O();
                        DiskLruCache.this.f15726k = 0;
                    }
                    return null;
                } finally {
                }
            }
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public final int f15720e = 1;

    /* renamed from: g, reason: collision with root package name */
    public final int f15722g = 1;

    public static final class DiskLruCacheThreadFactory implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class Editor {

        /* renamed from: a, reason: collision with root package name */
        public final Entry f15730a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f15731b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f15732c;

        public Editor(Entry entry) {
            this.f15730a = entry;
            this.f15731b = entry.f15738e ? null : new boolean[DiskLruCache.this.f15722g];
        }

        public final void a() {
            DiskLruCache.a(DiskLruCache.this, this, false);
        }

        public final File b() {
            File file;
            synchronized (DiskLruCache.this) {
                try {
                    Entry entry = this.f15730a;
                    if (entry.f15739f != this) {
                        throw new IllegalStateException();
                    }
                    if (!entry.f15738e) {
                        this.f15731b[0] = true;
                    }
                    file = entry.f15737d[0];
                    if (!DiskLruCache.this.f15716a.exists()) {
                        DiskLruCache.this.f15716a.mkdirs();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return file;
        }
    }

    public final class Entry {

        /* renamed from: a, reason: collision with root package name */
        public final String f15734a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f15735b;

        /* renamed from: c, reason: collision with root package name */
        public final File[] f15736c;

        /* renamed from: d, reason: collision with root package name */
        public final File[] f15737d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f15738e;

        /* renamed from: f, reason: collision with root package name */
        public Editor f15739f;

        public Entry(String str) {
            this.f15734a = str;
            int i2 = DiskLruCache.this.f15722g;
            this.f15735b = new long[i2];
            this.f15736c = new File[i2];
            this.f15737d = new File[i2];
            StringBuilder sb = new StringBuilder(str);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int length = sb.length();
            for (int i3 = 0; i3 < DiskLruCache.this.f15722g; i3++) {
                sb.append(i3);
                File[] fileArr = this.f15736c;
                String string = sb.toString();
                File file = DiskLruCache.this.f15716a;
                fileArr[i3] = new File(file, string);
                sb.append(".tmp");
                this.f15737d[i3] = new File(file, sb.toString());
                sb.setLength(length);
            }
        }

        public final String a() {
            StringBuilder sb = new StringBuilder();
            for (long j2 : this.f15735b) {
                sb.append(' ');
                sb.append(j2);
            }
            return sb.toString();
        }
    }

    public final class Value {

        /* renamed from: a, reason: collision with root package name */
        public final File[] f15741a;

        public Value(File[] fileArr) {
            this.f15741a = fileArr;
        }
    }

    public DiskLruCache(File file, long j2) {
        this.f15716a = file;
        this.f15717b = new File(file, coil3.disk.DiskLruCache.JOURNAL_FILE);
        this.f15718c = new File(file, coil3.disk.DiskLruCache.JOURNAL_FILE_TMP);
        this.f15719d = new File(file, coil3.disk.DiskLruCache.JOURNAL_FILE_BACKUP);
        this.f15721f = j2;
    }

    public static void T(File file, File file2, boolean z) throws IOException {
        if (z) {
            c(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void a(DiskLruCache diskLruCache, Editor editor, boolean z) {
        synchronized (diskLruCache) {
            Entry entry = editor.f15730a;
            if (entry.f15739f != editor) {
                throw new IllegalStateException();
            }
            if (z && !entry.f15738e) {
                for (int i2 = 0; i2 < diskLruCache.f15722g; i2++) {
                    if (!editor.f15731b[i2]) {
                        editor.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                    if (!entry.f15737d[i2].exists()) {
                        editor.a();
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < diskLruCache.f15722g; i3++) {
                File file = entry.f15737d[i3];
                if (!z) {
                    c(file);
                } else if (file.exists()) {
                    File file2 = entry.f15736c[i3];
                    file.renameTo(file2);
                    long j2 = entry.f15735b[i3];
                    long length = file2.length();
                    entry.f15735b[i3] = length;
                    diskLruCache.f15723h = (diskLruCache.f15723h - j2) + length;
                }
            }
            diskLruCache.f15726k++;
            entry.f15739f = null;
            if (entry.f15738e || z) {
                entry.f15738e = true;
                diskLruCache.f15724i.append((CharSequence) "CLEAN");
                diskLruCache.f15724i.append(' ');
                diskLruCache.f15724i.append((CharSequence) entry.f15734a);
                diskLruCache.f15724i.append((CharSequence) entry.a());
                diskLruCache.f15724i.append('\n');
                if (z) {
                    diskLruCache.f15727l++;
                }
            } else {
                diskLruCache.f15725j.remove(entry.f15734a);
                diskLruCache.f15724i.append((CharSequence) "REMOVE");
                diskLruCache.f15724i.append(' ');
                diskLruCache.f15724i.append((CharSequence) entry.f15734a);
                diskLruCache.f15724i.append('\n');
            }
            l(diskLruCache.f15724i);
            if (diskLruCache.f15723h > diskLruCache.f15721f || diskLruCache.s()) {
                diskLruCache.f15728m.submit(diskLruCache.n);
            }
        }
    }

    public static void b(BufferedWriter bufferedWriter) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void c(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void l(BufferedWriter bufferedWriter) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static DiskLruCache x(File file, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, coil3.disk.DiskLruCache.JOURNAL_FILE_BACKUP);
        if (file2.exists()) {
            File file3 = new File(file, coil3.disk.DiskLruCache.JOURNAL_FILE);
            if (file3.exists()) {
                file2.delete();
            } else {
                T(file2, file3, false);
            }
        }
        DiskLruCache diskLruCache = new DiskLruCache(file, j2);
        if (diskLruCache.f15717b.exists()) {
            try {
                diskLruCache.D();
                diskLruCache.A();
                return diskLruCache;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                diskLruCache.close();
                Util.a(diskLruCache.f15716a);
            }
        }
        file.mkdirs();
        DiskLruCache diskLruCache2 = new DiskLruCache(file, j2);
        diskLruCache2.O();
        return diskLruCache2;
    }

    public final void A() throws IOException {
        c(this.f15718c);
        Iterator it = this.f15725j.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            Editor editor = entry.f15739f;
            int i2 = this.f15722g;
            int i3 = 0;
            if (editor == null) {
                while (i3 < i2) {
                    this.f15723h += entry.f15735b[i3];
                    i3++;
                }
            } else {
                entry.f15739f = null;
                while (i3 < i2) {
                    c(entry.f15736c[i3]);
                    c(entry.f15737d[i3]);
                    i3++;
                }
                it.remove();
            }
        }
    }

    public final void D() {
        File file = this.f15717b;
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(file), Util.f15748a);
        try {
            String strA = strictLineReader.a();
            String strA2 = strictLineReader.a();
            String strA3 = strictLineReader.a();
            String strA4 = strictLineReader.a();
            String strA5 = strictLineReader.a();
            if (!coil3.disk.DiskLruCache.MAGIC.equals(strA) || !"1".equals(strA2) || !Integer.toString(this.f15720e).equals(strA3) || !Integer.toString(this.f15722g).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    N(strictLineReader.a());
                    i2++;
                } catch (EOFException unused) {
                    this.f15726k = i2 - this.f15725j.size();
                    if (strictLineReader.f15746e == -1) {
                        O();
                    } else {
                        this.f15724i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), Util.f15748a));
                    }
                    try {
                        strictLineReader.close();
                        return;
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                strictLineReader.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void N(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i2 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i2);
        LinkedHashMap linkedHashMap = this.f15725j;
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i2);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iIndexOf2);
        }
        Entry entry = (Entry) linkedHashMap.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            linkedHashMap.put(strSubstring, entry);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                entry.f15739f = new Editor(entry);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(StringUtils.SPACE);
        entry.f15738e = true;
        entry.f15739f = null;
        if (strArrSplit.length != DiskLruCache.this.f15722g) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
        }
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            try {
                entry.f15735b[i3] = Long.parseLong(strArrSplit[i3]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
        }
    }

    public final synchronized void O() {
        try {
            BufferedWriter bufferedWriter = this.f15724i;
            if (bufferedWriter != null) {
                b(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f15718c), Util.f15748a));
            try {
                bufferedWriter2.write(coil3.disk.DiskLruCache.MAGIC);
                bufferedWriter2.write(StringUtils.LF);
                bufferedWriter2.write("1");
                bufferedWriter2.write(StringUtils.LF);
                bufferedWriter2.write(Integer.toString(this.f15720e));
                bufferedWriter2.write(StringUtils.LF);
                bufferedWriter2.write(Integer.toString(this.f15722g));
                bufferedWriter2.write(StringUtils.LF);
                bufferedWriter2.write(StringUtils.LF);
                for (Entry entry : this.f15725j.values()) {
                    if (entry.f15739f != null) {
                        bufferedWriter2.write("DIRTY " + entry.f15734a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + entry.f15734a + entry.a() + '\n');
                    }
                }
                b(bufferedWriter2);
                if (this.f15717b.exists()) {
                    T(this.f15717b, this.f15719d, true);
                }
                T(this.f15718c, this.f15717b, false);
                this.f15719d.delete();
                this.f15724i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f15717b, true), Util.f15748a));
            } catch (Throwable th) {
                b(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void V() {
        while (this.f15723h > this.f15721f) {
            String str = (String) ((Map.Entry) this.f15725j.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.f15724i == null) {
                        throw new IllegalStateException("cache is closed");
                    }
                    Entry entry = (Entry) this.f15725j.get(str);
                    if (entry != null && entry.f15739f == null) {
                        for (int i2 = 0; i2 < this.f15722g; i2++) {
                            File file = entry.f15736c[i2];
                            if (file.exists() && !file.delete()) {
                                throw new IOException("failed to delete " + file);
                            }
                            long j2 = this.f15723h;
                            long[] jArr = entry.f15735b;
                            this.f15723h = j2 - jArr[i2];
                            jArr[i2] = 0;
                        }
                        this.f15726k++;
                        this.f15724i.append((CharSequence) "REMOVE");
                        this.f15724i.append(' ');
                        this.f15724i.append((CharSequence) str);
                        this.f15724i.append('\n');
                        this.f15725j.remove(str);
                        if (s()) {
                            this.f15728m.submit(this.n);
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f15724i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f15725j.values()).iterator();
            while (it.hasNext()) {
                Editor editor = ((Entry) it.next()).f15739f;
                if (editor != null) {
                    editor.a();
                }
            }
            V();
            b(this.f15724i);
            this.f15724i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Editor e(String str) {
        synchronized (this) {
            try {
                if (this.f15724i == null) {
                    throw new IllegalStateException("cache is closed");
                }
                Entry entry = (Entry) this.f15725j.get(str);
                if (entry == null) {
                    entry = new Entry(str);
                    this.f15725j.put(str, entry);
                } else if (entry.f15739f != null) {
                    return null;
                }
                Editor editor = new Editor(entry);
                entry.f15739f = editor;
                this.f15724i.append((CharSequence) "DIRTY");
                this.f15724i.append(' ');
                this.f15724i.append((CharSequence) str);
                this.f15724i.append('\n');
                l(this.f15724i);
                return editor;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized Value r(String str) {
        if (this.f15724i == null) {
            throw new IllegalStateException("cache is closed");
        }
        Entry entry = (Entry) this.f15725j.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.f15738e) {
            return null;
        }
        for (File file : entry.f15736c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f15726k++;
        this.f15724i.append((CharSequence) "READ");
        this.f15724i.append(' ');
        this.f15724i.append((CharSequence) str);
        this.f15724i.append('\n');
        if (s()) {
            this.f15728m.submit(this.n);
        }
        return new Value(entry.f15736c);
    }

    public final boolean s() {
        int i2 = this.f15726k;
        return i2 >= 2000 && i2 >= this.f15725j.size();
    }
}
