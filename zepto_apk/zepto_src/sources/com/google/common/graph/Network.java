package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;

@DoNotMock
@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set a();

    boolean b();

    boolean c();

    Set d();

    boolean f();

    EndpointPair j(Object obj);
}
