// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for DirectoryExpand. */
public final class DirectoryExpand extends ExpandableStringEnum<DirectoryExpand> {
    /** Static value * for DirectoryExpand. */
    public static final DirectoryExpand ASTERISK = fromString("*");

    /** Static value members for DirectoryExpand. */
    public static final DirectoryExpand MEMBERS = fromString("members");

    /** Static value scopedRoleMembers for DirectoryExpand. */
    public static final DirectoryExpand SCOPED_ROLE_MEMBERS = fromString("scopedRoleMembers");

    /** Static value extensions for DirectoryExpand. */
    public static final DirectoryExpand EXTENSIONS = fromString("extensions");

    /**
     * Creates or finds a DirectoryExpand from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding DirectoryExpand.
     */
    @JsonCreator
    public static DirectoryExpand fromString(String name) {
        return fromString(name, DirectoryExpand.class);
    }

    /** @return known DirectoryExpand values. */
    public static Collection<DirectoryExpand> values() {
        return values(DirectoryExpand.class);
    }
}
