package coil3.disk;

import androidx.fragment.app.e;
import coil3.util.Collections_jvmCommonKt;
import coil3.util.FileSystemsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.SupervisorKt;
import okio.BufferedSink;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.RealBufferedSink;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DiskLruCache implements AutoCloseable {

    @NotNull
    private static final String CLEAN = "CLEAN";

    @NotNull
    private static final String DIRTY = "DIRTY";

    @NotNull
    public static final String JOURNAL_FILE = "journal";

    @NotNull
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";

    @NotNull
    public static final String JOURNAL_FILE_TMP = "journal.tmp";

    @NotNull
    public static final String MAGIC = "libcore.io.DiskLruCache";

    @NotNull
    private static final String READ = "READ";

    @NotNull
    private static final String REMOVE = "REMOVE";

    @NotNull
    public static final String VERSION = "1";
    private final int appVersion;

    @NotNull
    private final CoroutineScope cleanupScope;
    private boolean closed;

    @NotNull
    private final Path directory;

    @NotNull
    private final DiskLruCache$fileSystem$1 fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;

    @NotNull
    private final Path journalFile;

    @NotNull
    private final Path journalFileBackup;

    @NotNull
    private final Path journalFileTmp;

    @Nullable
    private BufferedSink journalWriter;

    @NotNull
    private final Object lock;

    @NotNull
    private final Map<String, Entry> lruEntries;
    private final long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private int operationsSinceRewrite;
    private long size;
    private final int valueCount;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getJOURNAL_FILE$coil_core_release$annotations() {
        }

        public static /* synthetic */ void getJOURNAL_FILE_BACKUP$coil_core_release$annotations() {
        }

        public static /* synthetic */ void getJOURNAL_FILE_TMP$coil_core_release$annotations() {
        }

        public static /* synthetic */ void getMAGIC$coil_core_release$annotations() {
        }

        public static /* synthetic */ void getVERSION$coil_core_release$annotations() {
        }

        private Companion() {
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class Editor {
        private boolean closed;

        @NotNull
        private final Entry entry;

        @NotNull
        private final boolean[] written;

        public Editor(@NotNull Entry entry) {
            this.entry = entry;
            this.written = new boolean[DiskLruCache.this.valueCount];
        }

        private final void complete(boolean z) {
            Object obj = DiskLruCache.this.lock;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (obj) {
                try {
                    if (this.closed) {
                        throw new IllegalStateException("editor is closed");
                    }
                    if (Intrinsics.b(this.entry.getCurrentEditor(), this)) {
                        diskLruCache.completeEdit(this, z);
                    }
                    this.closed = true;
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void abort() {
            complete(false);
        }

        public final void commit() {
            complete(true);
        }

        @Nullable
        public final Snapshot commitAndGet() {
            Snapshot snapshot;
            Object obj = DiskLruCache.this.lock;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (obj) {
                commit();
                snapshot = diskLruCache.get(this.entry.getKey());
            }
            return snapshot;
        }

        public final void detach() {
            if (Intrinsics.b(this.entry.getCurrentEditor(), this)) {
                this.entry.setZombie(true);
            }
        }

        @NotNull
        public final Path file(int i2) {
            Path path;
            Object obj = DiskLruCache.this.lock;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (obj) {
                if (this.closed) {
                    throw new IllegalStateException("editor is closed");
                }
                this.written[i2] = true;
                Path path2 = this.entry.getDirtyFiles().get(i2);
                FileSystemsKt.createFile$default(diskLruCache.fileSystem, path2, false, 2, null);
                path = path2;
            }
            return path;
        }

        @NotNull
        public final Entry getEntry() {
            return this.entry;
        }

        @NotNull
        public final boolean[] getWritten() {
            return this.written;
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class Entry {

        @NotNull
        private final ArrayList<Path> cleanFiles;

        @Nullable
        private Editor currentEditor;

        @NotNull
        private final ArrayList<Path> dirtyFiles;

        @NotNull
        private final String key;

        @NotNull
        private final long[] lengths;
        private int lockingSnapshotCount;
        private boolean readable;
        private boolean zombie;

        public Entry(@NotNull String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new ArrayList<>(DiskLruCache.this.valueCount);
            this.dirtyFiles = new ArrayList<>(DiskLruCache.this.valueCount);
            StringBuilder sb = new StringBuilder(str);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int length = sb.length();
            int i2 = DiskLruCache.this.valueCount;
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(i3);
                this.cleanFiles.add(DiskLruCache.this.directory.e(sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(DiskLruCache.this.directory.e(sb.toString()));
                sb.setLength(length);
            }
        }

        @NotNull
        public final ArrayList<Path> getCleanFiles() {
            return this.cleanFiles;
        }

        @Nullable
        public final Editor getCurrentEditor() {
            return this.currentEditor;
        }

        @NotNull
        public final ArrayList<Path> getDirtyFiles() {
            return this.dirtyFiles;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final long[] getLengths() {
            return this.lengths;
        }

        public final int getLockingSnapshotCount() {
            return this.lockingSnapshotCount;
        }

        public final boolean getReadable() {
            return this.readable;
        }

        public final boolean getZombie() {
            return this.zombie;
        }

        public final void setCurrentEditor(@Nullable Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths(@NotNull List<String> list) throws IOException {
            if (list.size() != DiskLruCache.this.valueCount) {
                throw new IOException("unexpected journal line: " + list);
            }
            try {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.lengths[i2] = Long.parseLong(list.get(i2));
                }
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + list);
            }
        }

        public final void setLockingSnapshotCount(int i2) {
            this.lockingSnapshotCount = i2;
        }

        public final void setReadable(boolean z) {
            this.readable = z;
        }

        public final void setZombie(boolean z) {
            this.zombie = z;
        }

        @Nullable
        public final Snapshot snapshot() {
            if (!this.readable || this.currentEditor != null || this.zombie) {
                return null;
            }
            ArrayList<Path> arrayList = this.cleanFiles;
            DiskLruCache diskLruCache = DiskLruCache.this;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!diskLruCache.fileSystem.exists(arrayList.get(i2))) {
                    try {
                        diskLruCache.removeEntry(this);
                    } catch (IOException unused) {
                    }
                    return null;
                }
            }
            this.lockingSnapshotCount++;
            return DiskLruCache.this.new Snapshot(this);
        }

        public final void writeLengths(@NotNull BufferedSink bufferedSink) {
            for (long j2 : this.lengths) {
                bufferedSink.writeByte(32).E0(j2);
            }
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class Snapshot implements AutoCloseable {
        private boolean closed;

        @NotNull
        private final Entry entry;

        public Snapshot(@NotNull Entry entry) {
            this.entry = entry;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Object obj = DiskLruCache.this.lock;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (obj) {
                try {
                    this.entry.setLockingSnapshotCount(r2.getLockingSnapshotCount() - 1);
                    if (this.entry.getLockingSnapshotCount() == 0 && this.entry.getZombie()) {
                        diskLruCache.removeEntry(this.entry);
                    }
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Nullable
        public final Editor closeAndEdit() {
            Editor editorEdit;
            Object obj = DiskLruCache.this.lock;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (obj) {
                close();
                editorEdit = diskLruCache.edit(this.entry.getKey());
            }
            return editorEdit;
        }

        @NotNull
        public final Path file(int i2) {
            if (this.closed) {
                throw new IllegalStateException("snapshot is closed");
            }
            return this.entry.getCleanFiles().get(i2);
        }

        @NotNull
        public final Entry getEntry() {
            return this.entry;
        }
    }

    @Metadata
    @DebugMetadata(c = "coil3.disk.DiskLruCache$launchCleanup$1", f = "DiskLruCache.kt", l = {}, m = "invokeSuspend")
    /* renamed from: coil3.disk.DiskLruCache$launchCleanup$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DiskLruCache.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Object obj2 = DiskLruCache.this.lock;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (obj2) {
                if (!diskLruCache.initialized || diskLruCache.closed) {
                    return Unit.f53572a;
                }
                try {
                    diskLruCache.trimToSize();
                } catch (IOException unused) {
                    diskLruCache.mostRecentTrimFailed = true;
                }
                try {
                    if (diskLruCache.journalRewriteRequired()) {
                        diskLruCache.writeJournal();
                    }
                } catch (IOException unused2) {
                    diskLruCache.mostRecentRebuildFailed = true;
                    diskLruCache.journalWriter = Okio.c(Okio.b());
                }
                return Unit.f53572a;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f53572a);
        }
    }

    public DiskLruCache(@NotNull FileSystem fileSystem, @NotNull Path path, @NotNull CoroutineDispatcher coroutineDispatcher, long j2, int i2, int i3) {
        this.directory = path;
        this.maxSize = j2;
        this.appVersion = i2;
        this.valueCount = i3;
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        this.journalFile = path.e(JOURNAL_FILE);
        this.journalFileTmp = path.e(JOURNAL_FILE_TMP);
        this.journalFileBackup = path.e(JOURNAL_FILE_BACKUP);
        this.lruEntries = Collections_jvmCommonKt.LruMutableMap$default(0, 0.0f, 3, null);
        Job jobB = SupervisorKt.b();
        CoroutineDispatcher.Key key = CoroutineDispatcher.f54074a;
        this.cleanupScope = CoroutineScopeKt.a(CoroutineContext.Element.DefaultImpls.c((JobSupport) jobB, coroutineDispatcher.s1(1)));
        this.lock = new Object();
        this.fileSystem = new DiskLruCache$fileSystem$1(fileSystem);
    }

    private final void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeEdit(Editor editor, boolean z) {
        synchronized (this.lock) {
            Entry entry = editor.getEntry();
            if (!Intrinsics.b(entry.getCurrentEditor(), editor)) {
                throw new IllegalStateException("Check failed.");
            }
            if (!z || entry.getZombie()) {
                int i2 = this.valueCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    this.fileSystem.delete(entry.getDirtyFiles().get(i3));
                }
            } else {
                int i4 = this.valueCount;
                for (int i5 = 0; i5 < i4; i5++) {
                    if (editor.getWritten()[i5] && !this.fileSystem.exists(entry.getDirtyFiles().get(i5))) {
                        editor.abort();
                        return;
                    }
                }
                int i6 = this.valueCount;
                for (int i7 = 0; i7 < i6; i7++) {
                    Path path = entry.getDirtyFiles().get(i7);
                    Path path2 = entry.getCleanFiles().get(i7);
                    if (this.fileSystem.exists(path)) {
                        this.fileSystem.atomicMove(path, path2);
                    } else {
                        FileSystemsKt.createFile$default(this.fileSystem, entry.getCleanFiles().get(i7), false, 2, null);
                    }
                    long j2 = entry.getLengths()[i7];
                    Long l2 = this.fileSystem.metadata(path2).f56944d;
                    long jLongValue = l2 != null ? l2.longValue() : 0L;
                    entry.getLengths()[i7] = jLongValue;
                    this.size = (this.size - j2) + jLongValue;
                }
            }
            entry.setCurrentEditor(null);
            if (entry.getZombie()) {
                removeEntry(entry);
                return;
            }
            this.operationsSinceRewrite++;
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.c(bufferedSink);
            if (z || entry.getReadable()) {
                entry.setReadable(true);
                bufferedSink.Y(CLEAN);
                bufferedSink.writeByte(32);
                bufferedSink.Y(entry.getKey());
                entry.writeLengths(bufferedSink);
                bufferedSink.writeByte(10);
            } else {
                this.lruEntries.remove(entry.getKey());
                bufferedSink.Y(REMOVE);
                bufferedSink.writeByte(32);
                bufferedSink.Y(entry.getKey());
                bufferedSink.writeByte(10);
            }
            bufferedSink.flush();
            if (this.size > this.maxSize || journalRewriteRequired()) {
                launchCleanup();
            }
            Unit unit = Unit.f53572a;
        }
    }

    private final void delete() throws IOException {
        close();
        FileSystemsKt.deleteContents(this.fileSystem, this.directory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean journalRewriteRequired() {
        return this.operationsSinceRewrite >= 2000;
    }

    private final void launchCleanup() {
        BuildersKt.c(this.cleanupScope, null, new AnonymousClass1(null), 3);
    }

    private final BufferedSink newJournalWriter() {
        return Okio.c(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new a(this, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit newJournalWriter$lambda$4(DiskLruCache diskLruCache, IOException iOException) {
        diskLruCache.hasJournalErrors = true;
        return Unit.f53572a;
    }

    private final void processJournal() throws IOException {
        Iterator<Entry> it = this.lruEntries.values().iterator();
        long j2 = 0;
        while (it.hasNext()) {
            Entry next = it.next();
            int i2 = 0;
            if (next.getCurrentEditor() == null) {
                int i3 = this.valueCount;
                while (i2 < i3) {
                    j2 += next.getLengths()[i2];
                    i2++;
                }
            } else {
                next.setCurrentEditor(null);
                int i4 = this.valueCount;
                while (i2 < i4) {
                    this.fileSystem.delete(next.getCleanFiles().get(i2));
                    this.fileSystem.delete(next.getDirtyFiles().get(i2));
                    i2++;
                }
                it.remove();
            }
        }
        this.size = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void readJournal() throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.String r0 = ", "
            java.lang.String r1 = "unexpected journal header: ["
            coil3.disk.DiskLruCache$fileSystem$1 r2 = r11.fileSystem
            okio.Path r3 = r11.journalFile
            okio.Source r2 = r2.source(r3)
            okio.RealBufferedSource r2 = okio.Okio.d(r2)
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.String r5 = r2.Z(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = r2.Z(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = r2.Z(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r8 = r2.Z(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r9 = r2.Z(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r10 = "libcore.io.DiskLruCache"
            boolean r10 = r10.equals(r5)     // Catch: java.lang.Throwable -> L62
            if (r10 == 0) goto L86
            java.lang.String r10 = "1"
            boolean r10 = r10.equals(r6)     // Catch: java.lang.Throwable -> L62
            if (r10 == 0) goto L86
            int r10 = r11.appVersion     // Catch: java.lang.Throwable -> L62
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L62
            boolean r10 = kotlin.jvm.internal.Intrinsics.b(r10, r7)     // Catch: java.lang.Throwable -> L62
            if (r10 == 0) goto L86
            int r10 = r11.valueCount     // Catch: java.lang.Throwable -> L62
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L62
            boolean r10 = kotlin.jvm.internal.Intrinsics.b(r10, r8)     // Catch: java.lang.Throwable -> L62
            if (r10 == 0) goto L86
            int r10 = r9.length()     // Catch: java.lang.Throwable -> L62
            if (r10 > 0) goto L86
            r0 = 0
        L58:
            java.lang.String r1 = r2.Z(r3)     // Catch: java.lang.Throwable -> L62 java.io.EOFException -> L64
            r11.readJournalLine(r1)     // Catch: java.lang.Throwable -> L62 java.io.EOFException -> L64
            int r0 = r0 + 1
            goto L58
        L62:
            r0 = move-exception
            goto Lb5
        L64:
            java.util.Map<java.lang.String, coil3.disk.DiskLruCache$Entry> r1 = r11.lruEntries     // Catch: java.lang.Throwable -> L62
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L62
            int r0 = r0 - r1
            r11.operationsSinceRewrite = r0     // Catch: java.lang.Throwable -> L62
            boolean r0 = r2.a()     // Catch: java.lang.Throwable -> L62
            if (r0 != 0) goto L77
            r11.writeJournal()     // Catch: java.lang.Throwable -> L62
            goto L7d
        L77:
            okio.BufferedSink r0 = r11.newJournalWriter()     // Catch: java.lang.Throwable -> L62
            r11.journalWriter = r0     // Catch: java.lang.Throwable -> L62
        L7d:
            kotlin.Unit r0 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L62
            r2.close()     // Catch: java.lang.Throwable -> L84
            r0 = 0
            goto Lbd
        L84:
            r0 = move-exception
            goto Lbd
        L86:
            java.io.IOException r3 = new java.io.IOException     // Catch: java.lang.Throwable -> L62
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L62
            r4.append(r5)     // Catch: java.lang.Throwable -> L62
            r4.append(r0)     // Catch: java.lang.Throwable -> L62
            r4.append(r6)     // Catch: java.lang.Throwable -> L62
            r4.append(r0)     // Catch: java.lang.Throwable -> L62
            r4.append(r7)     // Catch: java.lang.Throwable -> L62
            r4.append(r0)     // Catch: java.lang.Throwable -> L62
            r4.append(r8)     // Catch: java.lang.Throwable -> L62
            r4.append(r0)     // Catch: java.lang.Throwable -> L62
            r4.append(r9)     // Catch: java.lang.Throwable -> L62
            r0 = 93
            r4.append(r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L62
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L62
            throw r3     // Catch: java.lang.Throwable -> L62
        Lb5:
            r2.close()     // Catch: java.lang.Throwable -> Lb9
            goto Lbd
        Lb9:
            r1 = move-exception
            kotlin.ExceptionsKt.a(r0, r1)
        Lbd:
            if (r0 != 0) goto Lc0
            return
        Lc0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache.readJournal():void");
    }

    private final void readJournalLine(String str) throws IOException {
        String strSubstring;
        int iW = StringsKt.w(str, ' ', 0, 6);
        if (iW == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i2 = iW + 1;
        int iW2 = StringsKt.w(str, ' ', i2, 4);
        if (iW2 == -1) {
            strSubstring = str.substring(i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (iW == 6 && StringsKt.O(str, REMOVE, false)) {
                this.lruEntries.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iW2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        }
        Map<String, Entry> map = this.lruEntries;
        Entry entry = map.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            map.put(strSubstring, entry);
        }
        Entry entry2 = entry;
        if (iW2 != -1 && iW == 5 && StringsKt.O(str, CLEAN, false)) {
            String strSubstring2 = str.substring(iW2 + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            List<String> listM = StringsKt.M(strSubstring2, new char[]{' '});
            entry2.setReadable(true);
            entry2.setCurrentEditor(null);
            entry2.setLengths(listM);
            return;
        }
        if (iW2 == -1 && iW == 5 && StringsKt.O(str, DIRTY, false)) {
            entry2.setCurrentEditor(new Editor(entry2));
        } else if (iW2 != -1 || iW != 4 || !StringsKt.O(str, READ, false)) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeEntry(Entry entry) throws IOException {
        BufferedSink bufferedSink;
        if (entry.getLockingSnapshotCount() > 0 && (bufferedSink = this.journalWriter) != null) {
            bufferedSink.Y(DIRTY);
            bufferedSink.writeByte(32);
            bufferedSink.Y(entry.getKey());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
        }
        if (entry.getLockingSnapshotCount() > 0 || entry.getCurrentEditor() != null) {
            entry.setZombie(true);
            return true;
        }
        int i2 = this.valueCount;
        for (int i3 = 0; i3 < i2; i3++) {
            this.fileSystem.delete(entry.getCleanFiles().get(i3));
            this.size -= entry.getLengths()[i3];
            entry.getLengths()[i3] = 0;
        }
        this.operationsSinceRewrite++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.Y(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.Y(entry.getKey());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey());
        if (journalRewriteRequired()) {
            launchCleanup();
        }
        return true;
    }

    private final boolean removeOldestEntry() throws IOException {
        for (Entry entry : this.lruEntries.values()) {
            if (!entry.getZombie()) {
                removeEntry(entry);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trimToSize() {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    private final void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.c(str)) {
            throw new IllegalArgumentException(e.l('\"', "keys must match regex [a-z0-9_-]{1,120}: \"", str).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeJournal() {
        Throwable th;
        synchronized (this.lock) {
            try {
                BufferedSink bufferedSink = this.journalWriter;
                if (bufferedSink != null) {
                    bufferedSink.close();
                }
                RealBufferedSink realBufferedSinkC = Okio.c(this.fileSystem.sink(this.journalFileTmp, false));
                try {
                    realBufferedSinkC.Y(MAGIC);
                    realBufferedSinkC.writeByte(10);
                    realBufferedSinkC.Y("1");
                    realBufferedSinkC.writeByte(10);
                    realBufferedSinkC.E0(this.appVersion);
                    realBufferedSinkC.writeByte(10);
                    realBufferedSinkC.E0(this.valueCount);
                    realBufferedSinkC.writeByte(10);
                    realBufferedSinkC.writeByte(10);
                    for (Entry entry : this.lruEntries.values()) {
                        if (entry.getCurrentEditor() != null) {
                            realBufferedSinkC.Y(DIRTY);
                            realBufferedSinkC.writeByte(32);
                            realBufferedSinkC.Y(entry.getKey());
                            realBufferedSinkC.writeByte(10);
                        } else {
                            realBufferedSinkC.Y(CLEAN);
                            realBufferedSinkC.writeByte(32);
                            realBufferedSinkC.Y(entry.getKey());
                            entry.writeLengths(realBufferedSinkC);
                            realBufferedSinkC.writeByte(10);
                        }
                    }
                    Unit unit = Unit.f53572a;
                    try {
                        realBufferedSinkC.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    try {
                        realBufferedSinkC.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.a(th3, th4);
                    }
                    th = th3;
                }
                if (th != null) {
                    throw th;
                }
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.atomicMove(this.journalFile, this.journalFileBackup);
                    this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                }
                this.journalWriter = newJournalWriter();
                this.operationsSinceRewrite = 0;
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
                Unit unit2 = Unit.f53572a;
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            try {
                if (this.initialized && !this.closed) {
                    for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[0])) {
                        Editor currentEditor = entry.getCurrentEditor();
                        if (currentEditor != null) {
                            currentEditor.detach();
                        }
                    }
                    trimToSize();
                    CoroutineScopeKt.b(this.cleanupScope, null);
                    BufferedSink bufferedSink = this.journalWriter;
                    Intrinsics.c(bufferedSink);
                    bufferedSink.close();
                    this.journalWriter = null;
                    this.closed = true;
                    Unit unit = Unit.f53572a;
                    return;
                }
                this.closed = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final Editor edit(@NotNull String str) {
        synchronized (this.lock) {
            checkNotClosed();
            validateKey(str);
            initialize();
            Entry entry = this.lruEntries.get(str);
            if ((entry != null ? entry.getCurrentEditor() : null) != null) {
                return null;
            }
            if (entry != null && entry.getLockingSnapshotCount() != 0) {
                return null;
            }
            if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.c(bufferedSink);
                bufferedSink.Y(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.Y(str);
                bufferedSink.writeByte(10);
                bufferedSink.flush();
                if (this.hasJournalErrors) {
                    return null;
                }
                if (entry == null) {
                    entry = new Entry(str);
                    this.lruEntries.put(str, entry);
                }
                Editor editor = new Editor(entry);
                entry.setCurrentEditor(editor);
                return editor;
            }
            launchCleanup();
            return null;
        }
    }

    public final void evictAll() {
        synchronized (this.lock) {
            try {
                initialize();
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[0])) {
                    removeEntry(entry);
                }
                this.mostRecentTrimFailed = false;
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void flush() {
        synchronized (this.lock) {
            if (this.initialized) {
                checkNotClosed();
                trimToSize();
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.c(bufferedSink);
                bufferedSink.flush();
                Unit unit = Unit.f53572a;
            }
        }
    }

    @Nullable
    public final Snapshot get(@NotNull String str) {
        Snapshot snapshot;
        synchronized (this.lock) {
            checkNotClosed();
            validateKey(str);
            initialize();
            Entry entry = this.lruEntries.get(str);
            if (entry != null && (snapshot = entry.snapshot()) != null) {
                this.operationsSinceRewrite++;
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.c(bufferedSink);
                bufferedSink.Y(READ);
                bufferedSink.writeByte(32);
                bufferedSink.Y(str);
                bufferedSink.writeByte(10);
                if (journalRewriteRequired()) {
                    launchCleanup();
                }
                return snapshot;
            }
            return null;
        }
    }

    public final void initialize() {
        synchronized (this.lock) {
            try {
                if (this.initialized) {
                    return;
                }
                this.fileSystem.delete(this.journalFileTmp);
                if (this.fileSystem.exists(this.journalFileBackup)) {
                    if (this.fileSystem.exists(this.journalFile)) {
                        this.fileSystem.delete(this.journalFileBackup);
                    } else {
                        this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
                    }
                }
                if (this.fileSystem.exists(this.journalFile)) {
                    try {
                        readJournal();
                        processJournal();
                        this.initialized = true;
                        return;
                    } catch (IOException unused) {
                        try {
                            delete();
                            this.closed = false;
                        } catch (Throwable th) {
                            this.closed = false;
                            throw th;
                        }
                    }
                }
                writeJournal();
                this.initialized = true;
                Unit unit = Unit.f53572a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean remove(@NotNull String str) {
        synchronized (this.lock) {
            checkNotClosed();
            validateKey(str);
            initialize();
            Entry entry = this.lruEntries.get(str);
            if (entry == null) {
                return false;
            }
            boolean zRemoveEntry = removeEntry(entry);
            if (zRemoveEntry && this.size <= this.maxSize) {
                this.mostRecentTrimFailed = false;
            }
            return zRemoveEntry;
        }
    }

    public final long size() {
        long j2;
        synchronized (this.lock) {
            initialize();
            j2 = this.size;
        }
        return j2;
    }
}
