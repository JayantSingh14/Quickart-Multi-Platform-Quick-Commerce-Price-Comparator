package com.chuckerteam.chucker.internal.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import kotlin.Metadata;

@Database
@Metadata
/* loaded from: classes3.dex */
public abstract class ChuckerDatabase extends RoomDatabase {

    @Metadata
    public static final class Companion {
    }

    public abstract HttpTransactionDao q();
}
