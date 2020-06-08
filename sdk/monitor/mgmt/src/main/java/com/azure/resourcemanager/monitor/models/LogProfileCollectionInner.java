// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The LogProfileCollection model. */
@Fluent
public final class LogProfileCollectionInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(LogProfileCollectionInner.class);

    /*
     * the values of the log profiles.
     */
    @JsonProperty(value = "value", required = true)
    private List<LogProfileResourceInner> value;

    /**
     * Get the value property: the values of the log profiles.
     *
     * @return the value value.
     */
    public List<LogProfileResourceInner> value() {
        return this.value;
    }

    /**
     * Set the value property: the values of the log profiles.
     *
     * @param value the value value to set.
     * @return the LogProfileCollectionInner object itself.
     */
    public LogProfileCollectionInner withValue(List<LogProfileResourceInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property value in model LogProfileCollectionInner"));
        } else {
            value().forEach(e -> e.validate());
        }
    }
}