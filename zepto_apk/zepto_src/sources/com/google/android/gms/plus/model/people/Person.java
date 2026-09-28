package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
@Deprecated
/* loaded from: classes4.dex */
public interface Person extends Freezable<Person> {

    @VisibleForTesting
    @Deprecated
    public interface AgeRange extends Freezable<AgeRange> {
    }

    @VisibleForTesting
    @Deprecated
    public interface Cover extends Freezable<Cover> {

        @VisibleForTesting
        @Deprecated
        public interface CoverInfo extends Freezable<CoverInfo> {
        }

        @VisibleForTesting
        @Deprecated
        public interface CoverPhoto extends Freezable<CoverPhoto> {
        }

        @Deprecated
        public static final class Layout {
        }
    }

    @Deprecated
    public static final class Gender {
    }

    @VisibleForTesting
    @Deprecated
    public interface Image extends Freezable<Image> {
    }

    @VisibleForTesting
    @Deprecated
    public interface Name extends Freezable<Name> {
    }

    @Deprecated
    public static final class ObjectType {
    }

    @VisibleForTesting
    @Deprecated
    public interface Organizations extends Freezable<Organizations> {

        @Deprecated
        public static final class Type {
        }
    }

    @VisibleForTesting
    @Deprecated
    public interface PlacesLived extends Freezable<PlacesLived> {
    }

    @Deprecated
    public static final class RelationshipStatus {
    }

    @VisibleForTesting
    @Deprecated
    public interface Urls extends Freezable<Urls> {

        public static final class Type {
        }
    }
}
