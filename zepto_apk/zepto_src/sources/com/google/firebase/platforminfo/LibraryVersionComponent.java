package com.google.firebase.platforminfo;

import android.content.Context;
import androidx.work.impl.c;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;

/* loaded from: classes.dex */
public class LibraryVersionComponent {

    public interface VersionExtractor<T> {
        String g(Context context);
    }

    public static Component a(String str, String str2) {
        AutoValue_LibraryVersion autoValue_LibraryVersion = new AutoValue_LibraryVersion(str, str2);
        Component.Builder builderB = Component.b(LibraryVersion.class);
        builderB.f43567e = 1;
        builderB.f43568f = new c(autoValue_LibraryVersion, 1);
        return builderB.b();
    }

    public static Component b(final String str, final VersionExtractor versionExtractor) {
        Component.Builder builderB = Component.b(LibraryVersion.class);
        builderB.f43567e = 1;
        builderB.a(Dependency.b(Context.class));
        builderB.f43568f = new ComponentFactory() { // from class: com.google.firebase.platforminfo.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object c(ComponentContainer componentContainer) {
                return new AutoValue_LibraryVersion(str, versionExtractor.g((Context) componentContainer.a(Context.class)));
            }
        };
        return builderB.b();
    }
}
