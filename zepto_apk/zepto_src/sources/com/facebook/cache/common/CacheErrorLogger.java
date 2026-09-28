package com.facebook.cache.common;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public interface CacheErrorLogger {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes3.dex */
    public static final class CacheErrorCategory {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CacheErrorCategory[] f16988a = {new CacheErrorCategory("READ_DECODE", 0), new CacheErrorCategory("READ_FILE", 1), new CacheErrorCategory("READ_FILE_NOT_FOUND", 2), new CacheErrorCategory("READ_INVALID_ENTRY", 3), new CacheErrorCategory("WRITE_ENCODE", 4), new CacheErrorCategory("WRITE_CREATE_TEMPFILE", 5), new CacheErrorCategory("WRITE_UPDATE_FILE_NOT_FOUND", 6), new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND", 7), new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND", 8), new CacheErrorCategory("WRITE_RENAME_FILE_OTHER", 9), new CacheErrorCategory("WRITE_CREATE_DIR", 10), new CacheErrorCategory("WRITE_CALLBACK_ERROR", 11), new CacheErrorCategory("WRITE_INVALID_ENTRY", 12), new CacheErrorCategory("DELETE_FILE", 13), new CacheErrorCategory("EVICTION", 14), new CacheErrorCategory("GENERIC_IO", 15), new CacheErrorCategory("OTHER", 16)};

        /* JADX INFO: Fake field, exist only in values array */
        CacheErrorCategory EF5;

        public static CacheErrorCategory valueOf(String str) {
            return (CacheErrorCategory) Enum.valueOf(CacheErrorCategory.class, str);
        }

        public static CacheErrorCategory[] values() {
            return (CacheErrorCategory[]) f16988a.clone();
        }
    }
}
