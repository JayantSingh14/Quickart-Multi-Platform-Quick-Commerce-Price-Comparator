package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public class DatabaseConfiguration {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11740a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11741b;

    /* renamed from: c, reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Factory f11742c;

    /* renamed from: d, reason: collision with root package name */
    public final RoomDatabase.MigrationContainer f11743d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f11744e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11745f;

    /* renamed from: g, reason: collision with root package name */
    public final RoomDatabase.JournalMode f11746g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f11747h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f11748i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f11749j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f11750k;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedHashSet f11751l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f11752m;
    public final ArrayList n;

    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, ArrayList arrayList, boolean z, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean z2, boolean z3, LinkedHashSet linkedHashSet, ArrayList typeConverters, ArrayList autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(migrationContainer, "migrationContainer");
        Intrinsics.checkNotNullParameter(journalMode, "journalMode");
        Intrinsics.checkNotNullParameter(queryExecutor, "queryExecutor");
        Intrinsics.checkNotNullParameter(transactionExecutor, "transactionExecutor");
        Intrinsics.checkNotNullParameter(typeConverters, "typeConverters");
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        this.f11740a = context;
        this.f11741b = str;
        this.f11742c = sqliteOpenHelperFactory;
        this.f11743d = migrationContainer;
        this.f11744e = arrayList;
        this.f11745f = z;
        this.f11746g = journalMode;
        this.f11747h = queryExecutor;
        this.f11748i = transactionExecutor;
        this.f11749j = z2;
        this.f11750k = z3;
        this.f11751l = linkedHashSet;
        this.f11752m = typeConverters;
        this.n = autoMigrationSpecs;
    }
}
