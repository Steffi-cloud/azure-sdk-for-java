/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.language.luis.authoring.models;

import java.util.UUID;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Regular Expression Entity Extractor.
 */
public class RegexEntityExtractor {
    /**
     * The ID of the Entity Model.
     */
    @JsonProperty(value = "id", required = true)
    private UUID id;

    /**
     * Name of the Entity Model.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * The type ID of the Entity Model.
     */
    @JsonProperty(value = "typeId")
    private Integer typeId;

    /**
     * Possible values include: 'Entity Extractor', 'Child Entity Extractor',
     * 'Hierarchical Entity Extractor', 'Hierarchical Child Entity Extractor',
     * 'Composite Entity Extractor', 'List Entity Extractor', 'Prebuilt Entity
     * Extractor', 'Intent Classifier', 'Pattern.Any Entity Extractor', 'Closed
     * List Entity Extractor', 'Regex Entity Extractor'.
     */
    @JsonProperty(value = "readableType", required = true)
    private String readableType;

    /**
     * The roles property.
     */
    @JsonProperty(value = "roles")
    private List<EntityRole> roles;

    /**
     * The Regular Expression entity pattern.
     */
    @JsonProperty(value = "regexPattern")
    private String regexPattern;

    /**
     * Get the id value.
     *
     * @return the id value
     */
    public UUID id() {
        return this.id;
    }

    /**
     * Set the id value.
     *
     * @param id the id value to set
     * @return the RegexEntityExtractor object itself.
     */
    public RegexEntityExtractor withId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the RegexEntityExtractor object itself.
     */
    public RegexEntityExtractor withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the typeId value.
     *
     * @return the typeId value
     */
    public Integer typeId() {
        return this.typeId;
    }

    /**
     * Set the typeId value.
     *
     * @param typeId the typeId value to set
     * @return the RegexEntityExtractor object itself.
     */
    public RegexEntityExtractor withTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    /**
     * Get the readableType value.
     *
     * @return the readableType value
     */
    public String readableType() {
        return this.readableType;
    }

    /**
     * Set the readableType value.
     *
     * @param readableType the readableType value to set
     * @return the RegexEntityExtractor object itself.
     */
    public RegexEntityExtractor withReadableType(String readableType) {
        this.readableType = readableType;
        return this;
    }

    /**
     * Get the roles value.
     *
     * @return the roles value
     */
    public List<EntityRole> roles() {
        return this.roles;
    }

    /**
     * Set the roles value.
     *
     * @param roles the roles value to set
     * @return the RegexEntityExtractor object itself.
     */
    public RegexEntityExtractor withRoles(List<EntityRole> roles) {
        this.roles = roles;
        return this;
    }

    /**
     * Get the regexPattern value.
     *
     * @return the regexPattern value
     */
    public String regexPattern() {
        return this.regexPattern;
    }

    /**
     * Set the regexPattern value.
     *
     * @param regexPattern the regexPattern value to set
     * @return the RegexEntityExtractor object itself.
     */
    public RegexEntityExtractor withRegexPattern(String regexPattern) {
        this.regexPattern = regexPattern;
        return this;
    }

}
