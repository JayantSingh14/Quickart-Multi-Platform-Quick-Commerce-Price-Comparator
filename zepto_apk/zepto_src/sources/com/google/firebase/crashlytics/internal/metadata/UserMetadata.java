package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes.dex */
public class UserMetadata {

    /* renamed from: a, reason: collision with root package name */
    public final MetaDataStore f43930a;

    /* renamed from: b, reason: collision with root package name */
    public final CrashlyticsWorkers f43931b;

    /* renamed from: c, reason: collision with root package name */
    public String f43932c;

    /* renamed from: d, reason: collision with root package name */
    public final SerializeableKeysMap f43933d = new SerializeableKeysMap(false);

    /* renamed from: e, reason: collision with root package name */
    public final SerializeableKeysMap f43934e = new SerializeableKeysMap(true);

    /* renamed from: f, reason: collision with root package name */
    public final RolloutAssignmentList f43935f = new RolloutAssignmentList();

    /* renamed from: g, reason: collision with root package name */
    public final AtomicMarkableReference f43936g = new AtomicMarkableReference(null, false);

    public class SerializeableKeysMap {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicMarkableReference f43937a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReference f43938b = new AtomicReference(null);

        /* renamed from: c, reason: collision with root package name */
        public final boolean f43939c;

        public SerializeableKeysMap(boolean z) {
            this.f43939c = z;
            this.f43937a = new AtomicMarkableReference(new KeysMap(z ? KEYRecord.Flags.FLAG2 : 1024), false);
        }

        public final boolean a(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((KeysMap) this.f43937a.getReference()).b(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.f43937a;
                    atomicMarkableReference.set((KeysMap) atomicMarkableReference.getReference(), true);
                    Runnable runnable = new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.c
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            UserMetadata.SerializeableKeysMap serializeableKeysMap = this.f43946a;
                            Map mapUnmodifiableMap = null;
                            serializeableKeysMap.f43938b.set(null);
                            synchronized (serializeableKeysMap) {
                                if (serializeableKeysMap.f43937a.isMarked()) {
                                    KeysMap keysMap = (KeysMap) serializeableKeysMap.f43937a.getReference();
                                    synchronized (keysMap) {
                                        mapUnmodifiableMap = Collections.unmodifiableMap(new HashMap(keysMap.f43897a));
                                    }
                                    AtomicMarkableReference atomicMarkableReference2 = serializeableKeysMap.f43937a;
                                    atomicMarkableReference2.set((KeysMap) atomicMarkableReference2.getReference(), false);
                                }
                            }
                            if (mapUnmodifiableMap != null) {
                                UserMetadata userMetadata = UserMetadata.this;
                                userMetadata.f43930a.h(userMetadata.f43932c, mapUnmodifiableMap, serializeableKeysMap.f43939c);
                            }
                        }
                    };
                    AtomicReference atomicReference = this.f43938b;
                    while (!atomicReference.compareAndSet(null, runnable)) {
                        if (atomicReference.get() != null) {
                            return true;
                        }
                    }
                    UserMetadata.this.f43931b.f43875b.a(runnable);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public UserMetadata(String str, FileStore fileStore, CrashlyticsWorkers crashlyticsWorkers) {
        this.f43932c = str;
        this.f43930a = new MetaDataStore(fileStore);
        this.f43931b = crashlyticsWorkers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.firebase.crashlytics.internal.metadata.UserMetadata c(java.lang.String r11, com.google.firebase.crashlytics.internal.persistence.FileStore r12, com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers r13) throws java.lang.Throwable {
        /*
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore r0 = new com.google.firebase.crashlytics.internal.metadata.MetaDataStore
            r0.<init>(r12)
            com.google.firebase.crashlytics.internal.metadata.UserMetadata r1 = new com.google.firebase.crashlytics.internal.metadata.UserMetadata
            r1.<init>(r11, r12, r13)
            com.google.firebase.crashlytics.internal.metadata.UserMetadata$SerializeableKeysMap r13 = r1.f43933d
            java.util.concurrent.atomic.AtomicMarkableReference r13 = r13.f43937a
            java.lang.Object r13 = r13.getReference()
            com.google.firebase.crashlytics.internal.metadata.KeysMap r13 = (com.google.firebase.crashlytics.internal.metadata.KeysMap) r13
            r2 = 0
            java.util.Map r3 = r0.c(r11, r2)
            r13.c(r3)
            com.google.firebase.crashlytics.internal.metadata.UserMetadata$SerializeableKeysMap r13 = r1.f43934e
            java.util.concurrent.atomic.AtomicMarkableReference r13 = r13.f43937a
            java.lang.Object r13 = r13.getReference()
            com.google.firebase.crashlytics.internal.metadata.KeysMap r13 = (com.google.firebase.crashlytics.internal.metadata.KeysMap) r13
            r3 = 1
            java.util.Map r3 = r0.c(r11, r3)
            r13.c(r3)
            java.util.concurrent.atomic.AtomicMarkableReference r13 = r1.f43936g
            java.lang.String r0 = r0.d(r11)
            r13.set(r0, r2)
            com.google.firebase.crashlytics.internal.metadata.RolloutAssignmentList r13 = r1.f43935f
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.f43705a
            java.lang.String r3 = "Failed to close rollouts state file."
            java.lang.String r4 = "Loaded rollouts state:\n"
            java.lang.String r5 = "rollouts-state"
            java.io.File r12 = r12.c(r11, r5)
            boolean r5 = r12.exists()
            r6 = 0
            if (r5 == 0) goto L9b
            long r7 = r12.length()
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 != 0) goto L57
            goto L9b
        L57:
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            r5.<init>(r12)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            java.lang.String r7 = com.google.firebase.crashlytics.internal.common.CommonUtils.j(r5)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.util.ArrayList r7 = com.google.firebase.crashlytics.internal.metadata.MetaDataStore.b(r7)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r8.<init>(r4)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r8.append(r7)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.lang.String r4 = "\nfor session "
            r8.append(r4)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r8.append(r11)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            java.lang.String r11 = r8.toString()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            r0.b(r11, r6)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L83
            com.google.firebase.crashlytics.internal.common.CommonUtils.b(r5, r3)
            goto La6
        L7f:
            r6 = r5
            goto L97
        L81:
            r11 = move-exception
            goto L7f
        L83:
            r11 = move-exception
            goto L89
        L85:
            r11 = move-exception
            goto L97
        L87:
            r11 = move-exception
            r5 = r6
        L89:
            java.lang.String r4 = "Error deserializing rollouts state."
            r0.f(r4, r11)     // Catch: java.lang.Throwable -> L81
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore.f(r12)     // Catch: java.lang.Throwable -> L81
            com.google.firebase.crashlytics.internal.common.CommonUtils.b(r5, r3)
            java.util.List r7 = java.util.Collections.EMPTY_LIST
            goto La6
        L97:
            com.google.firebase.crashlytics.internal.common.CommonUtils.b(r6, r3)
            throw r11
        L9b:
            java.lang.String r0 = "The file has a length of zero for session: "
            java.lang.String r11 = android.support.v4.media.b.C(r0, r11)
            com.google.firebase.crashlytics.internal.metadata.MetaDataStore.g(r12, r11)
            java.util.List r7 = java.util.Collections.EMPTY_LIST
        La6:
            java.lang.String r11 = "Ignored 0 entries when adding rollout assignments. Maximum allowable: "
            monitor-enter(r13)
            java.util.ArrayList r12 = r13.f43928a     // Catch: java.lang.Throwable -> Ld6
            r12.clear()     // Catch: java.lang.Throwable -> Ld6
            int r12 = r7.size()     // Catch: java.lang.Throwable -> Ld6
            int r0 = r13.f43929b     // Catch: java.lang.Throwable -> Ld6
            if (r12 <= r0) goto Ld8
            com.google.firebase.crashlytics.internal.Logger r12 = com.google.firebase.crashlytics.internal.Logger.f43705a     // Catch: java.lang.Throwable -> Ld6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld6
            r0.<init>(r11)     // Catch: java.lang.Throwable -> Ld6
            int r11 = r13.f43929b     // Catch: java.lang.Throwable -> Ld6
            r0.append(r11)     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r11 = r0.toString()     // Catch: java.lang.Throwable -> Ld6
            r12.f(r11, r6)     // Catch: java.lang.Throwable -> Ld6
            int r11 = r13.f43929b     // Catch: java.lang.Throwable -> Ld6
            java.util.List r11 = r7.subList(r2, r11)     // Catch: java.lang.Throwable -> Ld6
            java.util.ArrayList r12 = r13.f43928a     // Catch: java.lang.Throwable -> Ld6
            r12.addAll(r11)     // Catch: java.lang.Throwable -> Ld6
            monitor-exit(r13)
            goto Lde
        Ld6:
            r11 = move-exception
            goto Ldf
        Ld8:
            java.util.ArrayList r11 = r13.f43928a     // Catch: java.lang.Throwable -> Ld6
            r11.addAll(r7)     // Catch: java.lang.Throwable -> Ld6
            monitor-exit(r13)
        Lde:
            return r1
        Ldf:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> Ld6
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.metadata.UserMetadata.c(java.lang.String, com.google.firebase.crashlytics.internal.persistence.FileStore, com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers):com.google.firebase.crashlytics.internal.metadata.UserMetadata");
    }

    public static String d(FileStore fileStore, String str) {
        return new MetaDataStore(fileStore).d(str);
    }

    public final Map a(Map map) {
        Map mapUnmodifiableMap;
        Map mapUnmodifiableMap2;
        boolean zIsEmpty = map.isEmpty();
        SerializeableKeysMap serializeableKeysMap = this.f43933d;
        if (zIsEmpty) {
            KeysMap keysMap = (KeysMap) serializeableKeysMap.f43937a.getReference();
            synchronized (keysMap) {
                mapUnmodifiableMap2 = Collections.unmodifiableMap(new HashMap(keysMap.f43897a));
            }
            return mapUnmodifiableMap2;
        }
        KeysMap keysMap2 = (KeysMap) serializeableKeysMap.f43937a.getReference();
        synchronized (keysMap2) {
            mapUnmodifiableMap = Collections.unmodifiableMap(new HashMap(keysMap2.f43897a));
        }
        HashMap map2 = new HashMap(mapUnmodifiableMap);
        int i2 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String strA = KeysMap.a(1024, (String) entry.getKey());
            if (map2.size() < 64 || map2.containsKey(strA)) {
                map2.put(strA, KeysMap.a(1024, (String) entry.getValue()));
            } else {
                i2++;
            }
        }
        if (i2 > 0) {
            Logger.f43705a.f("Ignored " + i2 + " keys when adding event specific keys. Maximum allowable: 1024", null);
        }
        return Collections.unmodifiableMap(map2);
    }

    public final Map b() {
        Map mapUnmodifiableMap;
        KeysMap keysMap = (KeysMap) this.f43934e.f43937a.getReference();
        synchronized (keysMap) {
            mapUnmodifiableMap = Collections.unmodifiableMap(new HashMap(keysMap.f43897a));
        }
        return mapUnmodifiableMap;
    }

    public final void e(String str, String str2) {
        this.f43933d.a(str, str2);
    }

    public final void f(String str) {
        this.f43934e.a("com.crashlytics.version-control-info", str);
    }

    public final void g(final String str) {
        final Map mapUnmodifiableMap;
        final List listUnmodifiableList;
        synchronized (this.f43932c) {
            this.f43932c = str;
            KeysMap keysMap = (KeysMap) this.f43933d.f43937a.getReference();
            synchronized (keysMap) {
                mapUnmodifiableMap = Collections.unmodifiableMap(new HashMap(keysMap.f43897a));
            }
            RolloutAssignmentList rolloutAssignmentList = this.f43935f;
            synchronized (rolloutAssignmentList) {
                listUnmodifiableList = Collections.unmodifiableList(new ArrayList(rolloutAssignmentList.f43928a));
            }
            this.f43931b.f43875b.a(new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.a
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    String strE;
                    BufferedWriter bufferedWriter;
                    UserMetadata userMetadata = this.f43941a;
                    String str2 = (String) userMetadata.f43936g.getReference();
                    String str3 = str;
                    MetaDataStore metaDataStore = userMetadata.f43930a;
                    if (str2 != null) {
                        metaDataStore.i(str3, (String) userMetadata.f43936g.getReference());
                    }
                    Map map = mapUnmodifiableMap;
                    if (!map.isEmpty()) {
                        metaDataStore.h(str3, map, false);
                    }
                    List list = listUnmodifiableList;
                    if (list.isEmpty()) {
                        return;
                    }
                    File fileC = metaDataStore.f43904a.c(str3, "rollouts-state");
                    if (list.isEmpty()) {
                        MetaDataStore.g(fileC, android.support.v4.media.b.C("Rollout state is empty for session: ", str3));
                        return;
                    }
                    BufferedWriter bufferedWriter2 = null;
                    try {
                        try {
                            strE = MetaDataStore.e(list);
                            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileC), MetaDataStore.f43903b));
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        bufferedWriter.write(strE);
                        bufferedWriter.flush();
                        CommonUtils.b(bufferedWriter, "Failed to close rollouts state file.");
                    } catch (Exception e3) {
                        e = e3;
                        bufferedWriter2 = bufferedWriter;
                        Logger.f43705a.f("Error serializing rollouts state.", e);
                        MetaDataStore.f(fileC);
                        CommonUtils.b(bufferedWriter2, "Failed to close rollouts state file.");
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter2 = bufferedWriter;
                        CommonUtils.b(bufferedWriter2, "Failed to close rollouts state file.");
                        throw th;
                    }
                }
            });
        }
    }

    public final void h(String str) {
        String strA = KeysMap.a(1024, str);
        synchronized (this.f43936g) {
            try {
                String str2 = (String) this.f43936g.getReference();
                if (strA == null ? str2 == null : strA.equals(str2)) {
                    return;
                }
                this.f43936g.set(strA, true);
                this.f43931b.f43875b.a(new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.b
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        boolean z;
                        String str3;
                        UserMetadata userMetadata = this.f43945a;
                        synchronized (userMetadata.f43936g) {
                            try {
                                z = false;
                                if (userMetadata.f43936g.isMarked()) {
                                    str3 = (String) userMetadata.f43936g.getReference();
                                    userMetadata.f43936g.set(str3, false);
                                    z = true;
                                } else {
                                    str3 = null;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z) {
                            userMetadata.f43930a.i(userMetadata.f43932c, str3);
                        }
                    }
                });
            } finally {
            }
        }
    }
}
