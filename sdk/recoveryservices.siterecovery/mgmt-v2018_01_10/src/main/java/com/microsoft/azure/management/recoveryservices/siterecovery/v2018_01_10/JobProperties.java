/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.siterecovery.v2018_01_10;

import java.util.List;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Job custom data details.
 */
public class JobProperties {
    /**
     * The activity id.
     */
    @JsonProperty(value = "activityId")
    private String activityId;

    /**
     * The ScenarioName.
     */
    @JsonProperty(value = "scenarioName")
    private String scenarioName;

    /**
     * The DisplayName.
     */
    @JsonProperty(value = "friendlyName")
    private String friendlyName;

    /**
     * The status of the Job. It is one of these values - NotStarted,
     * InProgress, Succeeded, Failed, Cancelled, Suspended or Other.
     */
    @JsonProperty(value = "state")
    private String state;

    /**
     * The description of the state of the Job. For e.g. - For Succeeded state,
     * description can be Completed, PartiallySucceeded,
     * CompletedWithInformation or Skipped.
     */
    @JsonProperty(value = "stateDescription")
    private String stateDescription;

    /**
     * The tasks.
     */
    @JsonProperty(value = "tasks")
    private List<ASRTask> tasks;

    /**
     * The errors.
     */
    @JsonProperty(value = "errors")
    private List<JobErrorDetails> errors;

    /**
     * The start time.
     */
    @JsonProperty(value = "startTime")
    private DateTime startTime;

    /**
     * The end time.
     */
    @JsonProperty(value = "endTime")
    private DateTime endTime;

    /**
     * The Allowed action the job.
     */
    @JsonProperty(value = "allowedActions")
    private List<String> allowedActions;

    /**
     * The affected Object Id.
     */
    @JsonProperty(value = "targetObjectId")
    private String targetObjectId;

    /**
     * The name of the affected object.
     */
    @JsonProperty(value = "targetObjectName")
    private String targetObjectName;

    /**
     * The type of the affected object which is of
     * {Microsoft.Azure.SiteRecovery.V2015_11_10.AffectedObjectType} class.
     */
    @JsonProperty(value = "targetInstanceType")
    private String targetInstanceType;

    /**
     * The custom job details like test failover job details.
     */
    @JsonProperty(value = "customDetails")
    private JobDetails customDetails;

    /**
     * Get the activity id.
     *
     * @return the activityId value
     */
    public String activityId() {
        return this.activityId;
    }

    /**
     * Set the activity id.
     *
     * @param activityId the activityId value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withActivityId(String activityId) {
        this.activityId = activityId;
        return this;
    }

    /**
     * Get the ScenarioName.
     *
     * @return the scenarioName value
     */
    public String scenarioName() {
        return this.scenarioName;
    }

    /**
     * Set the ScenarioName.
     *
     * @param scenarioName the scenarioName value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
        return this;
    }

    /**
     * Get the DisplayName.
     *
     * @return the friendlyName value
     */
    public String friendlyName() {
        return this.friendlyName;
    }

    /**
     * Set the DisplayName.
     *
     * @param friendlyName the friendlyName value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Get the status of the Job. It is one of these values - NotStarted, InProgress, Succeeded, Failed, Cancelled, Suspended or Other.
     *
     * @return the state value
     */
    public String state() {
        return this.state;
    }

    /**
     * Set the status of the Job. It is one of these values - NotStarted, InProgress, Succeeded, Failed, Cancelled, Suspended or Other.
     *
     * @param state the state value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withState(String state) {
        this.state = state;
        return this;
    }

    /**
     * Get the description of the state of the Job. For e.g. - For Succeeded state, description can be Completed, PartiallySucceeded, CompletedWithInformation or Skipped.
     *
     * @return the stateDescription value
     */
    public String stateDescription() {
        return this.stateDescription;
    }

    /**
     * Set the description of the state of the Job. For e.g. - For Succeeded state, description can be Completed, PartiallySucceeded, CompletedWithInformation or Skipped.
     *
     * @param stateDescription the stateDescription value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
        return this;
    }

    /**
     * Get the tasks.
     *
     * @return the tasks value
     */
    public List<ASRTask> tasks() {
        return this.tasks;
    }

    /**
     * Set the tasks.
     *
     * @param tasks the tasks value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withTasks(List<ASRTask> tasks) {
        this.tasks = tasks;
        return this;
    }

    /**
     * Get the errors.
     *
     * @return the errors value
     */
    public List<JobErrorDetails> errors() {
        return this.errors;
    }

    /**
     * Set the errors.
     *
     * @param errors the errors value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withErrors(List<JobErrorDetails> errors) {
        this.errors = errors;
        return this;
    }

    /**
     * Get the start time.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Set the start time.
     *
     * @param startTime the startTime value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withStartTime(DateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the end time.
     *
     * @return the endTime value
     */
    public DateTime endTime() {
        return this.endTime;
    }

    /**
     * Set the end time.
     *
     * @param endTime the endTime value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withEndTime(DateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get the Allowed action the job.
     *
     * @return the allowedActions value
     */
    public List<String> allowedActions() {
        return this.allowedActions;
    }

    /**
     * Set the Allowed action the job.
     *
     * @param allowedActions the allowedActions value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withAllowedActions(List<String> allowedActions) {
        this.allowedActions = allowedActions;
        return this;
    }

    /**
     * Get the affected Object Id.
     *
     * @return the targetObjectId value
     */
    public String targetObjectId() {
        return this.targetObjectId;
    }

    /**
     * Set the affected Object Id.
     *
     * @param targetObjectId the targetObjectId value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withTargetObjectId(String targetObjectId) {
        this.targetObjectId = targetObjectId;
        return this;
    }

    /**
     * Get the name of the affected object.
     *
     * @return the targetObjectName value
     */
    public String targetObjectName() {
        return this.targetObjectName;
    }

    /**
     * Set the name of the affected object.
     *
     * @param targetObjectName the targetObjectName value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withTargetObjectName(String targetObjectName) {
        this.targetObjectName = targetObjectName;
        return this;
    }

    /**
     * Get the type of the affected object which is of {Microsoft.Azure.SiteRecovery.V2015_11_10.AffectedObjectType} class.
     *
     * @return the targetInstanceType value
     */
    public String targetInstanceType() {
        return this.targetInstanceType;
    }

    /**
     * Set the type of the affected object which is of {Microsoft.Azure.SiteRecovery.V2015_11_10.AffectedObjectType} class.
     *
     * @param targetInstanceType the targetInstanceType value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withTargetInstanceType(String targetInstanceType) {
        this.targetInstanceType = targetInstanceType;
        return this;
    }

    /**
     * Get the custom job details like test failover job details.
     *
     * @return the customDetails value
     */
    public JobDetails customDetails() {
        return this.customDetails;
    }

    /**
     * Set the custom job details like test failover job details.
     *
     * @param customDetails the customDetails value to set
     * @return the JobProperties object itself.
     */
    public JobProperties withCustomDetails(JobDetails customDetails) {
        this.customDetails = customDetails;
        return this;
    }

}
