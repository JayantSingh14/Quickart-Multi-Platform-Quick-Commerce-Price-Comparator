package com.google.firebase.components;

import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
final class RestrictedComponentContainer implements ComponentContainer {

    /* renamed from: a, reason: collision with root package name */
    public final Set f43605a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f43606b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f43607c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f43608d;

    /* renamed from: e, reason: collision with root package name */
    public final Set f43609e;

    /* renamed from: f, reason: collision with root package name */
    public final Set f43610f;

    /* renamed from: g, reason: collision with root package name */
    public final ComponentContainer f43611g;

    /* loaded from: classes4.dex */
    public static class RestrictedPublisher implements Publisher {

        /* renamed from: a, reason: collision with root package name */
        public final Set f43612a;

        /* renamed from: b, reason: collision with root package name */
        public final Publisher f43613b;

        public RestrictedPublisher(Set set, Publisher publisher) {
            this.f43612a = set;
            this.f43613b = publisher;
        }

        @Override // com.google.firebase.events.Publisher
        public final void c(Event event) {
            if (!this.f43612a.contains(DataCollectionDefaultChange.class)) {
                throw new DependencyException(String.format("Attempting to publish an undeclared event %s.", event));
            }
            this.f43613b.c(event);
        }
    }

    public RestrictedComponentContainer(Component component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency dependency : component.f43558c) {
            int i2 = dependency.f43590c;
            boolean z = i2 == 0;
            int i3 = dependency.f43589b;
            Qualified qualified = dependency.f43588a;
            if (z) {
                if (i3 == 2) {
                    hashSet4.add(qualified);
                } else {
                    hashSet.add(qualified);
                }
            } else if (i2 == 2) {
                hashSet3.add(qualified);
            } else if (i3 == 2) {
                hashSet5.add(qualified);
            } else {
                hashSet2.add(qualified);
            }
        }
        Set set = component.f43562g;
        if (!set.isEmpty()) {
            hashSet.add(Qualified.a(Publisher.class));
        }
        this.f43605a = Collections.unmodifiableSet(hashSet);
        this.f43606b = Collections.unmodifiableSet(hashSet2);
        this.f43607c = Collections.unmodifiableSet(hashSet3);
        this.f43608d = Collections.unmodifiableSet(hashSet4);
        this.f43609e = Collections.unmodifiableSet(hashSet5);
        this.f43610f = set;
        this.f43611g = componentContainer;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Object a(Class cls) {
        if (this.f43605a.contains(Qualified.a(cls))) {
            Object objA = this.f43611g.a(cls);
            return !cls.equals(Publisher.class) ? objA : new RestrictedPublisher(this.f43610f, (Publisher) objA);
        }
        throw new DependencyException("Attempting to request an undeclared dependency " + cls + CLConstants.DOT_SALT_DELIMETER);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Provider b(Qualified qualified) {
        if (this.f43606b.contains(qualified)) {
            return this.f43611g.b(qualified);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Provider<" + qualified + ">.");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Set c(Qualified qualified) {
        if (this.f43608d.contains(qualified)) {
            return this.f43611g.c(qualified);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Set<" + qualified + ">.");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Provider d(Qualified qualified) {
        if (this.f43609e.contains(qualified)) {
            return this.f43611g.d(qualified);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Provider<Set<" + qualified + ">>.");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Object e(Qualified qualified) {
        if (this.f43605a.contains(qualified)) {
            return this.f43611g.e(qualified);
        }
        throw new DependencyException("Attempting to request an undeclared dependency " + qualified + CLConstants.DOT_SALT_DELIMETER);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Provider g(Class cls) {
        return b(Qualified.a(cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Deferred h(Qualified qualified) {
        if (this.f43607c.contains(qualified)) {
            return this.f43611g.h(qualified);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Deferred<" + qualified + ">.");
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Deferred i(Class cls) {
        return h(Qualified.a(cls));
    }
}
