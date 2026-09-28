package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class DefaultUserAgentPublisher implements UserAgentPublisher {

    /* renamed from: a, reason: collision with root package name */
    public final String f44903a;

    /* renamed from: b, reason: collision with root package name */
    public final GlobalLibraryVersionRegistrar f44904b;

    public DefaultUserAgentPublisher(Set set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.f44903a = c(set);
        this.f44904b = globalLibraryVersionRegistrar;
    }

    public static Component b() {
        Component.Builder builderB = Component.b(UserAgentPublisher.class);
        builderB.a(new Dependency(2, 0, LibraryVersion.class));
        builderB.f43568f = new a();
        return builderB.b();
    }

    public static String c(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            LibraryVersion libraryVersion = (LibraryVersion) it.next();
            sb.append(libraryVersion.a());
            sb.append('/');
            sb.append(libraryVersion.b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // com.google.firebase.platforminfo.UserAgentPublisher
    public final String a() {
        Set setUnmodifiableSet;
        Set setUnmodifiableSet2;
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = this.f44904b;
        synchronized (globalLibraryVersionRegistrar.f44906a) {
            setUnmodifiableSet = Collections.unmodifiableSet(globalLibraryVersionRegistrar.f44906a);
        }
        boolean zIsEmpty = setUnmodifiableSet.isEmpty();
        String str = this.f44903a;
        if (zIsEmpty) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(' ');
        synchronized (globalLibraryVersionRegistrar.f44906a) {
            setUnmodifiableSet2 = Collections.unmodifiableSet(globalLibraryVersionRegistrar.f44906a);
        }
        sb.append(c(setUnmodifiableSet2));
        return sb.toString();
    }
}
