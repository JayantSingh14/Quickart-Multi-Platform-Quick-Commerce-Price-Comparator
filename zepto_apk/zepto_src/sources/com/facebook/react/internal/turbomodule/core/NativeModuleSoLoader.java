package com.facebook.react.internal.turbomodule.core;

import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class NativeModuleSoLoader {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static boolean isSoLibraryLoaded;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final synchronized void maybeLoadSoLibrary() {
            if (!NativeModuleSoLoader.isSoLibraryLoaded) {
                SoLoader.m("turbomodulejsijni");
                NativeModuleSoLoader.isSoLibraryLoaded = true;
            }
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final synchronized void maybeLoadSoLibrary() {
        Companion.maybeLoadSoLibrary();
    }
}
