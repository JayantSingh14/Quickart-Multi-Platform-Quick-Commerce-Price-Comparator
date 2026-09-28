package com.zeptonow.horizon.storage;

import app.cash.sqldelight.Transacter;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface EventDatabase extends Transacter {

    @Metadata
    public static final class Companion {
    }

    EventDatabaseQueries a();
}
