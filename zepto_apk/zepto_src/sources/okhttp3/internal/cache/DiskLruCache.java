package okhttp3.internal.cache;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.ForwardingSource;
import okio.Okio;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DiskLruCache implements Closeable, Flushable, AutoCloseable {
    public static final Regex s = new Regex("[a-z0-9_-]{1,120}");
    public static final String t = "CLEAN";
    public static final String u = "DIRTY";
    public static final String v = "REMOVE";
    public static final String w = "READ";

    /* renamed from: a, reason: collision with root package name */
    public final FileSystem f56421a;

    /* renamed from: b, reason: collision with root package name */
    public final File f56422b;

    /* renamed from: c, reason: collision with root package name */
    public final File f56423c;

    /* renamed from: d, reason: collision with root package name */
    public final File f56424d;

    /* renamed from: e, reason: collision with root package name */
    public final File f56425e;

    /* renamed from: f, reason: collision with root package name */
    public long f56426f;

    /* renamed from: g, reason: collision with root package name */
    public RealBufferedSink f56427g;

    /* renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f56428h;

    /* renamed from: i, reason: collision with root package name */
    public int f56429i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f56430j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f56431k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f56432l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f56433m;
    public boolean n;
    public boolean o;
    public long p;
    public final TaskQueue q;
    public final DiskLruCache$cleanupTask$1 r;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class Editor {

        /* renamed from: a, reason: collision with root package name */
        public final Entry f56434a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f56435b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f56436c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DiskLruCache f56437d;

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            boolean[] zArr;
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.f56437d = diskLruCache;
            this.f56434a = entry;
            if (entry.f56444e) {
                zArr = null;
            } else {
                diskLruCache.getClass();
                zArr = new boolean[2];
            }
            this.f56435b = zArr;
        }

        public final void a() {
            DiskLruCache diskLruCache = this.f56437d;
            synchronized (diskLruCache) {
                try {
                    if (this.f56436c) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (Intrinsics.b(this.f56434a.f56446g, this)) {
                        diskLruCache.b(this, false);
                    }
                    this.f56436c = true;
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void b() {
            DiskLruCache diskLruCache = this.f56437d;
            synchronized (diskLruCache) {
                try {
                    if (this.f56436c) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (Intrinsics.b(this.f56434a.f56446g, this)) {
                        diskLruCache.b(this, true);
                    }
                    this.f56436c = true;
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void c() {
            Entry entry = this.f56434a;
            if (Intrinsics.b(entry.f56446g, this)) {
                DiskLruCache diskLruCache = this.f56437d;
                if (diskLruCache.f56431k) {
                    diskLruCache.b(this, false);
                } else {
                    entry.f56445f = true;
                }
            }
        }

        public final Sink d(int i2) {
            final DiskLruCache diskLruCache = this.f56437d;
            synchronized (diskLruCache) {
                if (this.f56436c) {
                    throw new IllegalStateException("Check failed.");
                }
                if (!Intrinsics.b(this.f56434a.f56446g, this)) {
                    return Okio.b();
                }
                if (!this.f56434a.f56444e) {
                    boolean[] zArr = this.f56435b;
                    Intrinsics.c(zArr);
                    zArr[i2] = true;
                }
                try {
                    return new FaultHidingSink(diskLruCache.f56421a.f((File) this.f56434a.f56443d.get(i2)), new Function1<IOException, Unit>() { // from class: okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            IOException it = (IOException) obj;
                            Intrinsics.checkNotNullParameter(it, "it");
                            DiskLruCache diskLruCache2 = diskLruCache;
                            DiskLruCache.Editor editor = this;
                            synchronized (diskLruCache2) {
                                editor.c();
                            }
                            return Unit.f53572a;
                        }
                    });
                } catch (FileNotFoundException unused) {
                    return Okio.b();
                }
            }
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class Entry {

        /* renamed from: a, reason: collision with root package name */
        public final String f56440a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f56441b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f56442c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f56443d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f56444e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f56445f;

        /* renamed from: g, reason: collision with root package name */
        public Editor f56446g;

        /* renamed from: h, reason: collision with root package name */
        public int f56447h;

        /* renamed from: i, reason: collision with root package name */
        public long f56448i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ DiskLruCache f56449j;

        public Entry(DiskLruCache diskLruCache, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.f56449j = diskLruCache;
            this.f56440a = key;
            diskLruCache.getClass();
            this.f56441b = new long[2];
            this.f56442c = new ArrayList();
            this.f56443d = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int length = sb.length();
            for (int i2 = 0; i2 < 2; i2++) {
                sb.append(i2);
                this.f56442c.add(new File(this.f56449j.f56422b, sb.toString()));
                sb.append(".tmp");
                this.f56443d.add(new File(this.f56449j.f56422b, sb.toString()));
                sb.setLength(length);
            }
        }

        public final Snapshot a() {
            byte[] bArr = Util.f56394a;
            if (!this.f56444e) {
                return null;
            }
            final DiskLruCache diskLruCache = this.f56449j;
            if (!diskLruCache.f56431k && (this.f56446g != null || this.f56445f)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.f56441b.clone();
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    final Source sourceE = diskLruCache.f56421a.e((File) this.f56442c.get(i2));
                    if (!diskLruCache.f56431k) {
                        this.f56447h++;
                        sourceE = new ForwardingSource(sourceE) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1

                            /* renamed from: a, reason: collision with root package name */
                            public boolean f56450a;

                            @Override // okio.ForwardingSource, java.io.Closeable, java.lang.AutoCloseable
                            public final void close() throws IOException {
                                super.close();
                                if (this.f56450a) {
                                    return;
                                }
                                this.f56450a = true;
                                DiskLruCache diskLruCache2 = diskLruCache;
                                DiskLruCache.Entry entry = this;
                                synchronized (diskLruCache2) {
                                    try {
                                        int i3 = entry.f56447h - 1;
                                        entry.f56447h = i3;
                                        if (i3 == 0 && entry.f56445f) {
                                            diskLruCache2.N(entry);
                                        }
                                        Unit unit = Unit.f53572a;
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        };
                    }
                    arrayList.add(sourceE);
                } catch (FileNotFoundException unused) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Util.c((Source) it.next());
                    }
                    try {
                        diskLruCache.N(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            return new Snapshot(this.f56449j, this.f56440a, this.f56448i, arrayList, jArr);
        }
    }

    @Metadata
    public final class Snapshot implements Closeable, AutoCloseable {

        /* renamed from: a, reason: collision with root package name */
        public final String f56453a;

        /* renamed from: b, reason: collision with root package name */
        public final long f56454b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f56455c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DiskLruCache f56456d;

        public Snapshot(DiskLruCache diskLruCache, String key, long j2, ArrayList sources, long[] lengths) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(lengths, "lengths");
            this.f56456d = diskLruCache;
            this.f56453a = key;
            this.f56454b = j2;
            this.f56455c = sources;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            Iterator it = this.f56455c.iterator();
            while (it.hasNext()) {
                Util.c((Source) it.next());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(FileSystem fileSystem, File directory, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.f56421a = fileSystem;
        this.f56422b = directory;
        this.f56428h = new LinkedHashMap(0, 0.75f, true);
        this.q = taskRunner.e();
        final String strR = b.r(new StringBuilder(), Util.f56400g, " Cache");
        this.r = new Task(strR) { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public final long a() {
                DiskLruCache diskLruCache = this.f56457e;
                synchronized (diskLruCache) {
                    if (!diskLruCache.f56432l || diskLruCache.f56433m) {
                        return -1L;
                    }
                    try {
                        diskLruCache.O();
                    } catch (IOException unused) {
                        diskLruCache.n = true;
                    }
                    try {
                        if (diskLruCache.r()) {
                            diskLruCache.D();
                            diskLruCache.f56429i = 0;
                        }
                    } catch (IOException unused2) {
                        diskLruCache.o = true;
                        diskLruCache.f56427g = Okio.c(Okio.b());
                    }
                    return -1L;
                }
            }
        };
        this.f56423c = new File(directory, coil3.disk.DiskLruCache.JOURNAL_FILE);
        this.f56424d = new File(directory, coil3.disk.DiskLruCache.JOURNAL_FILE_TMP);
        this.f56425e = new File(directory, coil3.disk.DiskLruCache.JOURNAL_FILE_BACKUP);
    }

    public static void T(String str) {
        if (!s.c(str)) {
            throw new IllegalArgumentException(e.l('\"', "keys must match regex [a-z0-9_-]{1,120}: \"", str).toString());
        }
    }

    public final void A(String str) throws IOException {
        String strSubstring;
        int iW = StringsKt.w(str, ' ', 0, 6);
        if (iW == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i2 = iW + 1;
        int iW2 = StringsKt.w(str, ' ', i2, 4);
        LinkedHashMap linkedHashMap = this.f56428h;
        if (iW2 == -1) {
            strSubstring = str.substring(i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            String str2 = v;
            if (iW == str2.length() && StringsKt.O(str, str2, false)) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iW2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        Entry entry = (Entry) linkedHashMap.get(strSubstring);
        if (entry == null) {
            entry = new Entry(this, strSubstring);
            linkedHashMap.put(strSubstring, entry);
        }
        if (iW2 != -1) {
            String str3 = t;
            if (iW == str3.length() && StringsKt.O(str, str3, false)) {
                String strSubstring2 = str.substring(iW2 + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                List strings = StringsKt.M(strSubstring2, new char[]{' '});
                entry.f56444e = true;
                entry.f56446g = null;
                Intrinsics.checkNotNullParameter(strings, "strings");
                int size = strings.size();
                entry.f56449j.getClass();
                if (size != 2) {
                    throw new IOException("unexpected journal line: " + strings);
                }
                try {
                    int size2 = strings.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        entry.f56441b[i3] = Long.parseLong((String) strings.get(i3));
                    }
                    return;
                } catch (NumberFormatException unused) {
                    throw new IOException("unexpected journal line: " + strings);
                }
            }
        }
        if (iW2 == -1) {
            String str4 = u;
            if (iW == str4.length() && StringsKt.O(str, str4, false)) {
                entry.f56446g = new Editor(this, entry);
                return;
            }
        }
        if (iW2 == -1) {
            String str5 = w;
            if (iW == str5.length() && StringsKt.O(str, str5, false)) {
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    public final synchronized void D() {
        try {
            RealBufferedSink realBufferedSink = this.f56427g;
            if (realBufferedSink != null) {
                realBufferedSink.close();
            }
            RealBufferedSink writer = Okio.c(this.f56421a.f(this.f56424d));
            try {
                writer.Y(coil3.disk.DiskLruCache.MAGIC);
                writer.writeByte(10);
                writer.Y("1");
                writer.writeByte(10);
                writer.E0(201105);
                writer.writeByte(10);
                writer.E0(2);
                writer.writeByte(10);
                writer.writeByte(10);
                Iterator it = this.f56428h.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    if (entry.f56446g != null) {
                        writer.Y(u);
                        writer.writeByte(32);
                        writer.Y(entry.f56440a);
                        writer.writeByte(10);
                    } else {
                        writer.Y(t);
                        writer.writeByte(32);
                        writer.Y(entry.f56440a);
                        Intrinsics.checkNotNullParameter(writer, "writer");
                        for (long j2 : entry.f56441b) {
                            writer.writeByte(32);
                            writer.E0(j2);
                        }
                        writer.writeByte(10);
                    }
                }
                Unit unit = Unit.f53572a;
                writer.close();
                if (this.f56421a.b(this.f56423c)) {
                    this.f56421a.g(this.f56423c, this.f56425e);
                }
                this.f56421a.g(this.f56424d, this.f56423c);
                this.f56421a.h(this.f56425e);
                this.f56427g = Okio.c(new FaultHidingSink(this.f56421a.c(this.f56423c), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
                this.f56430j = false;
                this.o = false;
            } finally {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void N(Entry entry) {
        RealBufferedSink realBufferedSink;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!this.f56431k) {
            if (entry.f56447h > 0 && (realBufferedSink = this.f56427g) != null) {
                realBufferedSink.Y(u);
                realBufferedSink.writeByte(32);
                realBufferedSink.Y(entry.f56440a);
                realBufferedSink.writeByte(10);
                realBufferedSink.flush();
            }
            if (entry.f56447h > 0 || entry.f56446g != null) {
                entry.f56445f = true;
                return;
            }
        }
        Editor editor = entry.f56446g;
        if (editor != null) {
            editor.c();
        }
        for (int i2 = 0; i2 < 2; i2++) {
            this.f56421a.h((File) entry.f56442c.get(i2));
            long j2 = this.f56426f;
            long[] jArr = entry.f56441b;
            this.f56426f = j2 - jArr[i2];
            jArr[i2] = 0;
        }
        this.f56429i++;
        RealBufferedSink realBufferedSink2 = this.f56427g;
        String str = entry.f56440a;
        if (realBufferedSink2 != null) {
            realBufferedSink2.Y(v);
            realBufferedSink2.writeByte(32);
            realBufferedSink2.Y(str);
            realBufferedSink2.writeByte(10);
        }
        this.f56428h.remove(str);
        if (r()) {
            this.q.c(this.r, 0L);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "toEvict");
        N(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O() {
        /*
            r4 = this;
        L0:
            long r0 = r4.f56426f
            r2 = 10485760(0xa00000, double:5.180654E-317)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L2d
            java.util.LinkedHashMap r0 = r4.f56428h
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L13:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r0.next()
            okhttp3.internal.cache.DiskLruCache$Entry r1 = (okhttp3.internal.cache.DiskLruCache.Entry) r1
            boolean r2 = r1.f56445f
            if (r2 != 0) goto L13
            java.lang.String r0 = "toEvict"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r4.N(r1)
            goto L0
        L2c:
            return
        L2d:
            r0 = 0
            r4.n = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.O():void");
    }

    public final synchronized void a() {
        if (this.f56433m) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void b(Editor editor, boolean z) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Entry entry = editor.f56434a;
        if (!Intrinsics.b(entry.f56446g, editor)) {
            throw new IllegalStateException("Check failed.");
        }
        if (z && !entry.f56444e) {
            for (int i2 = 0; i2 < 2; i2++) {
                boolean[] zArr = editor.f56435b;
                Intrinsics.c(zArr);
                if (!zArr[i2]) {
                    editor.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                }
                if (!this.f56421a.b((File) entry.f56443d.get(i2))) {
                    editor.a();
                    return;
                }
            }
        }
        for (int i3 = 0; i3 < 2; i3++) {
            File file = (File) entry.f56443d.get(i3);
            if (!z || entry.f56445f) {
                this.f56421a.h(file);
            } else if (this.f56421a.b(file)) {
                File file2 = (File) entry.f56442c.get(i3);
                this.f56421a.g(file, file2);
                long j2 = entry.f56441b[i3];
                long jD = this.f56421a.d(file2);
                entry.f56441b[i3] = jD;
                this.f56426f = (this.f56426f - j2) + jD;
            }
        }
        entry.f56446g = null;
        if (entry.f56445f) {
            N(entry);
            return;
        }
        this.f56429i++;
        RealBufferedSink writer = this.f56427g;
        Intrinsics.c(writer);
        if (entry.f56444e || z) {
            entry.f56444e = true;
            writer.Y(t);
            writer.writeByte(32);
            writer.Y(entry.f56440a);
            Intrinsics.checkNotNullParameter(writer, "writer");
            for (long j3 : entry.f56441b) {
                writer.writeByte(32);
                writer.E0(j3);
            }
            writer.writeByte(10);
            if (z) {
                long j4 = this.p;
                this.p = 1 + j4;
                entry.f56448i = j4;
            }
        } else {
            this.f56428h.remove(entry.f56440a);
            writer.Y(v);
            writer.writeByte(32);
            writer.Y(entry.f56440a);
            writer.writeByte(10);
        }
        writer.flush();
        if (this.f56426f > 10485760 || r()) {
            this.q.c(this.r, 0L);
        }
    }

    public final synchronized Editor c(long j2, String key) {
        try {
            Intrinsics.checkNotNullParameter(key, "key");
            l();
            a();
            T(key);
            Entry entry = (Entry) this.f56428h.get(key);
            if (j2 != -1 && (entry == null || entry.f56448i != j2)) {
                return null;
            }
            if ((entry != null ? entry.f56446g : null) != null) {
                return null;
            }
            if (entry != null && entry.f56447h != 0) {
                return null;
            }
            if (!this.n && !this.o) {
                RealBufferedSink realBufferedSink = this.f56427g;
                Intrinsics.c(realBufferedSink);
                realBufferedSink.Y(u);
                realBufferedSink.writeByte(32);
                realBufferedSink.Y(key);
                realBufferedSink.writeByte(10);
                realBufferedSink.flush();
                if (this.f56430j) {
                    return null;
                }
                if (entry == null) {
                    entry = new Entry(this, key);
                    this.f56428h.put(key, entry);
                }
                Editor editor = new Editor(this, entry);
                entry.f56446g = editor;
                return editor;
            }
            this.q.c(this.r, 0L);
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f56432l && !this.f56433m) {
                Collection collectionValues = this.f56428h.values();
                Intrinsics.checkNotNullExpressionValue(collectionValues, "lruEntries.values");
                for (Entry entry : (Entry[]) collectionValues.toArray(new Entry[0])) {
                    Editor editor = entry.f56446g;
                    if (editor != null) {
                        editor.c();
                    }
                }
                O();
                RealBufferedSink realBufferedSink = this.f56427g;
                Intrinsics.c(realBufferedSink);
                realBufferedSink.close();
                this.f56427g = null;
                this.f56433m = true;
                return;
            }
            this.f56433m = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Snapshot e(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        l();
        a();
        T(key);
        Entry entry = (Entry) this.f56428h.get(key);
        if (entry == null) {
            return null;
        }
        Snapshot snapshotA = entry.a();
        if (snapshotA == null) {
            return null;
        }
        this.f56429i++;
        RealBufferedSink realBufferedSink = this.f56427g;
        Intrinsics.c(realBufferedSink);
        realBufferedSink.Y(w);
        realBufferedSink.writeByte(32);
        realBufferedSink.Y(key);
        realBufferedSink.writeByte(10);
        if (r()) {
            this.q.c(this.r, 0L);
        }
        return snapshotA;
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.f56432l) {
            a();
            O();
            RealBufferedSink realBufferedSink = this.f56427g;
            Intrinsics.c(realBufferedSink);
            realBufferedSink.flush();
        }
    }

    public final synchronized void l() {
        boolean z;
        try {
            byte[] bArr = Util.f56394a;
            if (this.f56432l) {
                return;
            }
            if (this.f56421a.b(this.f56425e)) {
                if (this.f56421a.b(this.f56423c)) {
                    this.f56421a.h(this.f56425e);
                } else {
                    this.f56421a.g(this.f56425e, this.f56423c);
                }
            }
            FileSystem fileSystem = this.f56421a;
            File file = this.f56425e;
            Intrinsics.checkNotNullParameter(fileSystem, "<this>");
            Intrinsics.checkNotNullParameter(file, "file");
            Sink sinkF = fileSystem.f(file);
            try {
                try {
                    fileSystem.h(file);
                    sinkF.close();
                    z = true;
                } catch (IOException unused) {
                    Unit unit = Unit.f53572a;
                    sinkF.close();
                    fileSystem.h(file);
                    z = false;
                }
                this.f56431k = z;
                if (this.f56421a.b(this.f56423c)) {
                    try {
                        x();
                        s();
                        this.f56432l = true;
                        return;
                    } catch (IOException e2) {
                        Platform platform = Platform.f56791a;
                        Platform platform2 = Platform.f56791a;
                        String str = "DiskLruCache " + this.f56422b + " is corrupt: " + e2.getMessage() + ", removing";
                        platform2.getClass();
                        Platform.i(5, str, e2);
                        try {
                            close();
                            this.f56421a.a(this.f56422b);
                            this.f56433m = false;
                        } catch (Throwable th) {
                            this.f56433m = false;
                            throw th;
                        }
                    }
                }
                D();
                this.f56432l = true;
            } finally {
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean r() {
        int i2 = this.f56429i;
        return i2 >= 2000 && i2 >= this.f56428h.size();
    }

    public final void s() {
        File file = this.f56424d;
        FileSystem fileSystem = this.f56421a;
        fileSystem.h(file);
        Iterator it = this.f56428h.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "i.next()");
            Entry entry = (Entry) next;
            int i2 = 0;
            if (entry.f56446g == null) {
                while (i2 < 2) {
                    this.f56426f += entry.f56441b[i2];
                    i2++;
                }
            } else {
                entry.f56446g = null;
                while (i2 < 2) {
                    fileSystem.h((File) entry.f56442c.get(i2));
                    fileSystem.h((File) entry.f56443d.get(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    public final void x() {
        File file = this.f56423c;
        FileSystem fileSystem = this.f56421a;
        RealBufferedSource realBufferedSourceD = Okio.d(fileSystem.e(file));
        try {
            String strZ = realBufferedSourceD.Z(Long.MAX_VALUE);
            String strZ2 = realBufferedSourceD.Z(Long.MAX_VALUE);
            String strZ3 = realBufferedSourceD.Z(Long.MAX_VALUE);
            String strZ4 = realBufferedSourceD.Z(Long.MAX_VALUE);
            String strZ5 = realBufferedSourceD.Z(Long.MAX_VALUE);
            if (!coil3.disk.DiskLruCache.MAGIC.equals(strZ) || !"1".equals(strZ2) || !Intrinsics.b(String.valueOf(201105), strZ3) || !Intrinsics.b(String.valueOf(2), strZ4) || strZ5.length() > 0) {
                throw new IOException("unexpected journal header: [" + strZ + ", " + strZ2 + ", " + strZ4 + ", " + strZ5 + ']');
            }
            int i2 = 0;
            while (true) {
                try {
                    A(realBufferedSourceD.Z(Long.MAX_VALUE));
                    i2++;
                } catch (EOFException unused) {
                    this.f56429i = i2 - this.f56428h.size();
                    if (realBufferedSourceD.a()) {
                        this.f56427g = Okio.c(new FaultHidingSink(fileSystem.c(file), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
                    } else {
                        D();
                    }
                    Unit unit = Unit.f53572a;
                    realBufferedSourceD.close();
                    return;
                }
            }
        } finally {
        }
    }
}
