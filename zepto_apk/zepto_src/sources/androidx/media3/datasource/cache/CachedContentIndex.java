package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.media.b;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.AtomicFile;
import androidx.media3.common.util.Util;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.database.VersionTable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
class CachedContentIndex {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6000a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f6001b = new SparseArray();

    /* renamed from: c, reason: collision with root package name */
    public final SparseBooleanArray f6002c = new SparseBooleanArray();

    /* renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f6003d = new SparseBooleanArray();

    /* renamed from: e, reason: collision with root package name */
    public final Storage f6004e;

    /* renamed from: f, reason: collision with root package name */
    public Storage f6005f;

    public static final class DatabaseStorage implements Storage {

        /* renamed from: e, reason: collision with root package name */
        public static final String[] f6006e = {CLConstants.SHARED_PREFERENCE_ITEM_ID, "key", "metadata"};

        /* renamed from: a, reason: collision with root package name */
        public final StandaloneDatabaseProvider f6007a;

        /* renamed from: b, reason: collision with root package name */
        public final SparseArray f6008b = new SparseArray();

        /* renamed from: c, reason: collision with root package name */
        public String f6009c;

        /* renamed from: d, reason: collision with root package name */
        public String f6010d;

        public DatabaseStorage(StandaloneDatabaseProvider standaloneDatabaseProvider) {
            this.f6007a = standaloneDatabaseProvider;
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final boolean a() throws DatabaseIOException {
            try {
                SQLiteDatabase readableDatabase = this.f6007a.getReadableDatabase();
                String str = this.f6009c;
                str.getClass();
                return VersionTable.a(readableDatabase, 1, str) != -1;
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void b(HashMap map) throws DatabaseIOException {
            SparseArray sparseArray = this.f6008b;
            if (sparseArray.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f6007a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    try {
                        CachedContent cachedContent = (CachedContent) sparseArray.valueAt(i2);
                        if (cachedContent == null) {
                            int iKeyAt = sparseArray.keyAt(i2);
                            String str = this.f6010d;
                            str.getClass();
                            writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(iKeyAt)});
                        } else {
                            i(writableDatabase, cachedContent);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                sparseArray.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void c(long j2) {
            String hexString = Long.toHexString(j2);
            this.f6009c = hexString;
            this.f6010d = b.C("ExoPlayerCacheIndex", hexString);
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void d(CachedContent cachedContent, boolean z) {
            SparseArray sparseArray = this.f6008b;
            int i2 = cachedContent.f5993a;
            if (z) {
                sparseArray.delete(i2);
            } else {
                sparseArray.put(i2, null);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void e(HashMap map) throws DatabaseIOException {
            try {
                SQLiteDatabase writableDatabase = this.f6007a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    j(writableDatabase);
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        i(writableDatabase, (CachedContent) it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f6008b.clear();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void f(CachedContent cachedContent) {
            this.f6008b.put(cachedContent.f5993a, cachedContent);
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void g(HashMap map, SparseArray sparseArray) throws DatabaseIOException {
            StandaloneDatabaseProvider standaloneDatabaseProvider = this.f6007a;
            Assertions.g(this.f6008b.size() == 0);
            try {
                SQLiteDatabase readableDatabase = standaloneDatabaseProvider.getReadableDatabase();
                String str = this.f6009c;
                str.getClass();
                if (VersionTable.a(readableDatabase, 1, str) != 1) {
                    SQLiteDatabase writableDatabase = standaloneDatabaseProvider.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        j(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                SQLiteDatabase readableDatabase2 = standaloneDatabaseProvider.getReadableDatabase();
                String str2 = this.f6010d;
                str2.getClass();
                Cursor cursorQuery = readableDatabase2.query(str2, f6006e, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        int i2 = cursorQuery.getInt(0);
                        String string = cursorQuery.getString(1);
                        string.getClass();
                        map.put(string, new CachedContent(i2, string, CachedContentIndex.a(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
                        sparseArray.put(i2, string);
                    } finally {
                    }
                }
                cursorQuery.close();
            } catch (SQLiteException e2) {
                map.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e2);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void h() throws DatabaseIOException {
            StandaloneDatabaseProvider standaloneDatabaseProvider = this.f6007a;
            String str = this.f6009c;
            str.getClass();
            try {
                String strConcat = "ExoPlayerCacheIndex".concat(str);
                SQLiteDatabase writableDatabase = standaloneDatabaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    int i2 = VersionTable.f5816a;
                    try {
                        if (Util.g0(writableDatabase, "ExoPlayerVersions")) {
                            writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                        }
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + strConcat);
                        writableDatabase.setTransactionSuccessful();
                    } catch (SQLException e2) {
                        throw new DatabaseIOException(e2);
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e3) {
                throw new DatabaseIOException(e3);
            }
        }

        public final void i(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException, SQLException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.b(cachedContent.f5997e, new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, Integer.valueOf(cachedContent.f5993a));
            contentValues.put("key", cachedContent.f5994b);
            contentValues.put("metadata", byteArray);
            String str = this.f6010d;
            str.getClass();
            sQLiteDatabase.replaceOrThrow(str, null, contentValues);
        }

        public final void j(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException, SQLException {
            String str = this.f6009c;
            str.getClass();
            VersionTable.b(sQLiteDatabase, 1, str);
            String str2 = this.f6010d;
            str2.getClass();
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(str2));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f6010d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }
    }

    public static class LegacyStorage implements Storage {

        /* renamed from: a, reason: collision with root package name */
        public final Cipher f6011a = null;

        /* renamed from: b, reason: collision with root package name */
        public final SecretKeySpec f6012b = null;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicFile f6013c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f6014d;

        /* renamed from: e, reason: collision with root package name */
        public ReusableBufferedOutputStream f6015e;

        public LegacyStorage(File file) {
            this.f6013c = new AtomicFile(file);
        }

        public static int i(CachedContent cachedContent, int i2) {
            int iHashCode = cachedContent.f5994b.hashCode() + (cachedContent.f5993a * 31);
            if (i2 < 2) {
                long jB = cachedContent.f5997e.b();
                return (iHashCode * 31) + ((int) (jB ^ (jB >>> 32)));
            }
            return cachedContent.f5997e.hashCode() + (iHashCode * 31);
        }

        public static CachedContent j(int i2, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata defaultContentMetadataA;
            int i3 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i2 < 2) {
                long j2 = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                contentMetadataMutations.a(Long.valueOf(j2), "exo_len");
                defaultContentMetadataA = DefaultContentMetadata.f6018c.a(contentMetadataMutations);
            } else {
                defaultContentMetadataA = CachedContentIndex.a(dataInputStream);
            }
            return new CachedContent(i3, utf, defaultContentMetadataA);
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final boolean a() {
            AtomicFile atomicFile = this.f6013c;
            return atomicFile.f5658a.exists() || atomicFile.f5659b.exists();
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void b(HashMap map) throws Throwable {
            if (this.f6014d) {
                e(map);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void c(long j2) {
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void d(CachedContent cachedContent, boolean z) {
            this.f6014d = true;
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void e(HashMap map) throws Throwable {
            DataOutputStream dataOutputStream;
            AtomicFile atomicFile = this.f6013c;
            DataOutputStream dataOutputStream2 = null;
            try {
                OutputStream outputStreamA = atomicFile.a();
                ReusableBufferedOutputStream reusableBufferedOutputStream = this.f6015e;
                if (reusableBufferedOutputStream == null) {
                    this.f6015e = new ReusableBufferedOutputStream(outputStreamA);
                } else {
                    reusableBufferedOutputStream.a(outputStreamA);
                }
                dataOutputStream = new DataOutputStream(this.f6015e);
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeInt(2);
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt(map.size());
                int i2 = 0;
                for (CachedContent cachedContent : map.values()) {
                    dataOutputStream.writeInt(cachedContent.f5993a);
                    dataOutputStream.writeUTF(cachedContent.f5994b);
                    CachedContentIndex.b(cachedContent.f5997e, dataOutputStream);
                    i2 += i(cachedContent, 2);
                }
                dataOutputStream.writeInt(i2);
                dataOutputStream.close();
                atomicFile.f5659b.delete();
                int i3 = Util.f5744a;
                this.f6014d = false;
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                Util.h(dataOutputStream2);
                throw th;
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void f(CachedContent cachedContent) {
            this.f6014d = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x0089 A[Catch: all -> 0x0072, IOException -> 0x0075, TRY_LEAVE, TryCatch #5 {IOException -> 0x0075, all -> 0x0072, blocks: (B:13:0x0039, B:18:0x0043, B:25:0x0055, B:26:0x005f, B:27:0x0066, B:34:0x007a, B:35:0x007f, B:36:0x0080, B:38:0x0089, B:40:0x008f, B:41:0x009e), top: B:62:0x0039 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00aa  */
        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void g(java.util.HashMap r13, android.util.SparseArray r14) throws java.lang.Throwable {
            /*
                r12 = this;
                r0 = 1
                boolean r1 = r12.f6014d
                r1 = r1 ^ r0
                androidx.media3.common.util.Assertions.g(r1)
                androidx.media3.common.util.AtomicFile r1 = r12.f6013c
                java.io.File r2 = r1.f5658a
                java.io.File r3 = r1.f5658a
                boolean r2 = r2.exists()
                java.io.File r1 = r1.f5659b
                if (r2 != 0) goto L1d
                boolean r2 = r1.exists()
                if (r2 == 0) goto L1c
                goto L1d
            L1c:
                return
            L1d:
                r2 = 0
                java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> Lb4 java.io.IOException -> Lbb
                boolean r5 = r1.exists()     // Catch: java.lang.Throwable -> Lb4 java.io.IOException -> Lbb
                if (r5 == 0) goto L2c
                r3.delete()     // Catch: java.lang.Throwable -> Lb4 java.io.IOException -> Lbb
                r1.renameTo(r3)     // Catch: java.lang.Throwable -> Lb4 java.io.IOException -> Lbb
            L2c:
                java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb4 java.io.IOException -> Lbb
                r5.<init>(r3)     // Catch: java.lang.Throwable -> Lb4 java.io.IOException -> Lbb
                r4.<init>(r5)     // Catch: java.lang.Throwable -> Lb4 java.io.IOException -> Lbb
                java.io.DataInputStream r5 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> Lb4 java.io.IOException -> Lbb
                r5.<init>(r4)     // Catch: java.lang.Throwable -> Lb4 java.io.IOException -> Lbb
                int r2 = r5.readInt()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                if (r2 < 0) goto L4e
                r6 = 2
                if (r2 <= r6) goto L43
                goto L4e
            L43:
                int r7 = r5.readInt()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                r7 = r7 & r0
                if (r7 == 0) goto L80
                javax.crypto.Cipher r7 = r12.f6011a
                if (r7 != 0) goto L53
            L4e:
                androidx.media3.common.util.Util.h(r5)
                goto Lc0
            L53:
                r8 = 16
                byte[] r8 = new byte[r8]     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                r5.readFully(r8)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                javax.crypto.spec.IvParameterSpec r9 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                r9.<init>(r8)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                javax.crypto.spec.SecretKeySpec r8 = r12.f6012b     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75 java.security.InvalidAlgorithmParameterException -> L77 java.security.InvalidKeyException -> L79
                int r10 = androidx.media3.common.util.Util.f5744a     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75 java.security.InvalidAlgorithmParameterException -> L77 java.security.InvalidKeyException -> L79
                r7.init(r6, r8, r9)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75 java.security.InvalidAlgorithmParameterException -> L77 java.security.InvalidKeyException -> L79
                java.io.DataInputStream r6 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                javax.crypto.CipherInputStream r8 = new javax.crypto.CipherInputStream     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                r8.<init>(r4, r7)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                r6.<init>(r8)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                r5 = r6
                goto L80
            L72:
                r13 = move-exception
                r2 = r5
                goto Lb5
            L75:
                r2 = r5
                goto Lbb
            L77:
                r0 = move-exception
                goto L7a
            L79:
                r0 = move-exception
            L7a:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                r2.<init>(r0)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                throw r2     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            L80:
                int r4 = r5.readInt()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                r6 = 0
                r7 = r6
                r8 = r7
            L87:
                if (r7 >= r4) goto L9e
                androidx.media3.datasource.cache.CachedContent r9 = j(r2, r5)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                java.lang.String r10 = r9.f5994b
                r13.put(r10, r9)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                int r11 = r9.f5993a     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                r14.put(r11, r10)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                int r9 = i(r9, r2)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                int r8 = r8 + r9
                int r7 = r7 + r0
                goto L87
            L9e:
                int r2 = r5.readInt()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                int r4 = r5.read()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
                r7 = -1
                if (r4 != r7) goto Laa
                goto Lab
            Laa:
                r0 = r6
            Lab:
                if (r2 != r8) goto L4e
                if (r0 != 0) goto Lb0
                goto L4e
            Lb0:
                androidx.media3.common.util.Util.h(r5)
                return
            Lb4:
                r13 = move-exception
            Lb5:
                if (r2 == 0) goto Lba
                androidx.media3.common.util.Util.h(r2)
            Lba:
                throw r13
            Lbb:
                if (r2 == 0) goto Lc0
                androidx.media3.common.util.Util.h(r2)
            Lc0:
                r13.clear()
                r14.clear()
                r3.delete()
                r1.delete()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.CachedContentIndex.LegacyStorage.g(java.util.HashMap, android.util.SparseArray):void");
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex.Storage
        public final void h() {
            AtomicFile atomicFile = this.f6013c;
            atomicFile.f5658a.delete();
            atomicFile.f5659b.delete();
        }
    }

    public interface Storage {
        boolean a();

        void b(HashMap map);

        void c(long j2);

        void d(CachedContent cachedContent, boolean z);

        void e(HashMap map);

        void f(CachedContent cachedContent);

        void g(HashMap map, SparseArray sparseArray);

        void h();
    }

    public CachedContentIndex(StandaloneDatabaseProvider standaloneDatabaseProvider, File file) {
        DatabaseStorage databaseStorage = new DatabaseStorage(standaloneDatabaseProvider);
        LegacyStorage legacyStorage = new LegacyStorage(new File(file, "cached_content_index.exi"));
        this.f6004e = databaseStorage;
        this.f6005f = legacyStorage;
    }

    public static DefaultContentMetadata a(DataInputStream dataInputStream) throws IOException {
        int i2 = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < i2; i3++) {
            String utf = dataInputStream.readUTF();
            int i4 = dataInputStream.readInt();
            if (i4 < 0) {
                throw new IOException(b.f(i4, "Invalid value size: "));
            }
            int iMin = Math.min(i4, 10485760);
            byte[] bArrCopyOf = Util.f5749f;
            int i5 = 0;
            while (i5 != i4) {
                int i6 = i5 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i6);
                dataInputStream.readFully(bArrCopyOf, i5, iMin);
                iMin = Math.min(i4 - i6, 10485760);
                i5 = i6;
            }
            map.put(utf, bArrCopyOf);
        }
        return new DefaultContentMetadata(map);
    }

    public static void b(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry> setEntrySet = defaultContentMetadata.f6020b.entrySet();
        dataOutputStream.writeInt(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public final CachedContent c(String str) {
        return (CachedContent) this.f6000a.get(str);
    }

    public final CachedContent d(String str) {
        HashMap map = this.f6000a;
        CachedContent cachedContent = (CachedContent) map.get(str);
        if (cachedContent != null) {
            return cachedContent;
        }
        SparseArray sparseArray = this.f6001b;
        int size = sparseArray.size();
        int i2 = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i2 < size && i2 == sparseArray.keyAt(i2)) {
                i2++;
            }
            iKeyAt = i2;
        }
        CachedContent cachedContent2 = new CachedContent(iKeyAt, str, DefaultContentMetadata.f6018c);
        map.put(str, cachedContent2);
        sparseArray.put(iKeyAt, str);
        this.f6003d.put(iKeyAt, true);
        this.f6004e.f(cachedContent2);
        return cachedContent2;
    }

    public final void e(long j2) {
        Storage storage;
        Storage storage2 = this.f6004e;
        storage2.c(j2);
        Storage storage3 = this.f6005f;
        if (storage3 != null) {
            storage3.c(j2);
        }
        boolean zA = storage2.a();
        SparseArray sparseArray = this.f6001b;
        HashMap map = this.f6000a;
        if (zA || (storage = this.f6005f) == null || !storage.a()) {
            storage2.g(map, sparseArray);
        } else {
            this.f6005f.g(map, sparseArray);
            storage2.e(map);
        }
        Storage storage4 = this.f6005f;
        if (storage4 != null) {
            storage4.h();
            this.f6005f = null;
        }
    }

    public final void f(String str) {
        HashMap map = this.f6000a;
        CachedContent cachedContent = (CachedContent) map.get(str);
        if (cachedContent != null && cachedContent.f5995c.isEmpty() && cachedContent.f5996d.isEmpty()) {
            map.remove(str);
            SparseBooleanArray sparseBooleanArray = this.f6003d;
            int i2 = cachedContent.f5993a;
            boolean z = sparseBooleanArray.get(i2);
            this.f6004e.d(cachedContent, z);
            SparseArray sparseArray = this.f6001b;
            if (z) {
                sparseArray.remove(i2);
                sparseBooleanArray.delete(i2);
            } else {
                sparseArray.put(i2, null);
                this.f6002c.put(i2, true);
            }
        }
    }

    public final void g() {
        this.f6004e.b(this.f6000a);
        SparseBooleanArray sparseBooleanArray = this.f6002c;
        int size = sparseBooleanArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f6001b.remove(sparseBooleanArray.keyAt(i2));
        }
        sparseBooleanArray.clear();
        this.f6003d.clear();
    }
}
