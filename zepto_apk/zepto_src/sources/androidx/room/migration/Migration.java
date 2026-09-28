package androidx.room.migration;

import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public abstract class Migration {

    /* renamed from: a, reason: collision with root package name */
    public final int f11857a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11858b;

    public Migration(int i2, int i3) {
        this.f11857a = i2;
        this.f11858b = i3;
    }

    public abstract void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase);
}
