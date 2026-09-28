package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.persistence.FileStore;

/* loaded from: classes.dex */
public class LogFileManager {

    /* renamed from: c, reason: collision with root package name */
    public static final NoopLogStore f43900c = new NoopLogStore();

    /* renamed from: a, reason: collision with root package name */
    public final FileStore f43901a;

    /* renamed from: b, reason: collision with root package name */
    public FileLogStore f43902b;

    public static final class NoopLogStore implements FileLogStore {
        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public final void a() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public final String b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public final byte[] c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public final void d() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public final void e(long j2, String str) {
        }
    }

    public LogFileManager(FileStore fileStore) {
        this.f43901a = fileStore;
        this.f43902b = f43900c;
    }

    public final void a() {
        this.f43902b.d();
    }

    public final byte[] b() {
        return this.f43902b.c();
    }

    public final String c() {
        return this.f43902b.b();
    }

    public final void d(String str) {
        this.f43902b.a();
        this.f43902b = f43900c;
        if (str == null) {
            return;
        }
        this.f43902b = new QueueFileLogStore(this.f43901a.c(str, "userlog"));
    }

    public final void e(long j2, String str) {
        this.f43902b.e(j2, str);
    }

    public LogFileManager(FileStore fileStore, String str) {
        this(fileStore);
        d(str);
    }
}
