package com.chuckerteam.chucker.internal.data.repository;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.chuckerteam.chucker.internal.data.room.ChuckerDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class RepositoryProvider {

    /* renamed from: a, reason: collision with root package name */
    public static HttpTransactionDatabaseRepository f16722a;

    public static void a(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        if (f16722a == null) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            RoomDatabase.Builder builderA = Room.a(applicationContext, ChuckerDatabase.class, "chucker.db");
            builderA.f11820l = false;
            builderA.f11821m = true;
            f16722a = new HttpTransactionDatabaseRepository((ChuckerDatabase) builderA.b());
        }
    }

    public static HttpTransactionRepository b() {
        HttpTransactionDatabaseRepository httpTransactionDatabaseRepository = f16722a;
        if (httpTransactionDatabaseRepository != null) {
            return httpTransactionDatabaseRepository;
        }
        throw new IllegalStateException("You can't access the transaction repository if you don't initialize it!");
    }
}
