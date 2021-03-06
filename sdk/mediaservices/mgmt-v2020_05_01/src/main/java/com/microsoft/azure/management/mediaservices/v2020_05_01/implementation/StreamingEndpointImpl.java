/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2020_05_01.implementation;

import com.microsoft.azure.management.mediaservices.v2020_05_01.StreamingEndpoint;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import java.util.Map;
import com.microsoft.azure.management.mediaservices.v2020_05_01.StreamingEndpointAccessControl;
import java.util.List;
import com.microsoft.azure.management.mediaservices.v2020_05_01.StreamingEndpointResourceState;
import com.microsoft.azure.management.mediaservices.v2020_05_01.CrossSiteAccessPolicies;
import org.joda.time.DateTime;

class StreamingEndpointImpl extends CreatableUpdatableImpl<StreamingEndpoint, StreamingEndpointInner, StreamingEndpointImpl> implements StreamingEndpoint, StreamingEndpoint.Definition, StreamingEndpoint.Update {
    private final MediaManager manager;
    private String resourceGroupName;
    private String accountName;
    private String streamingEndpointName;
    private Boolean cautoStart;

    StreamingEndpointImpl(String name, MediaManager manager) {
        super(name, new StreamingEndpointInner());
        this.manager = manager;
        // Set resource name
        this.streamingEndpointName = name;
        //
    }

    StreamingEndpointImpl(StreamingEndpointInner inner, MediaManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.streamingEndpointName = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.accountName = IdParsingUtils.getValueFromIdByName(inner.id(), "mediaservices");
        this.streamingEndpointName = IdParsingUtils.getValueFromIdByName(inner.id(), "streamingEndpoints");
        //
    }

    @Override
    public MediaManager manager() {
        return this.manager;
    }

    @Override
    public Observable<StreamingEndpoint> createResourceAsync() {
        StreamingEndpointsInner client = this.manager().inner().streamingEndpoints();
        return client.createAsync(this.resourceGroupName, this.accountName, this.streamingEndpointName, this.inner(), this.cautoStart)
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<StreamingEndpoint> updateResourceAsync() {
        StreamingEndpointsInner client = this.manager().inner().streamingEndpoints();
        return client.updateAsync(this.resourceGroupName, this.accountName, this.streamingEndpointName, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<StreamingEndpointInner> getInnerAsync() {
        StreamingEndpointsInner client = this.manager().inner().streamingEndpoints();
        return client.getAsync(this.resourceGroupName, this.accountName, this.streamingEndpointName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public StreamingEndpointAccessControl accessControl() {
        return this.inner().accessControl();
    }

    @Override
    public String availabilitySetName() {
        return this.inner().availabilitySetName();
    }

    @Override
    public Boolean cdnEnabled() {
        return this.inner().cdnEnabled();
    }

    @Override
    public String cdnProfile() {
        return this.inner().cdnProfile();
    }

    @Override
    public String cdnProvider() {
        return this.inner().cdnProvider();
    }

    @Override
    public DateTime created() {
        return this.inner().created();
    }

    @Override
    public CrossSiteAccessPolicies crossSiteAccessPolicies() {
        return this.inner().crossSiteAccessPolicies();
    }

    @Override
    public List<String> customHostNames() {
        return this.inner().customHostNames();
    }

    @Override
    public String description() {
        return this.inner().description();
    }

    @Override
    public DateTime freeTrialEndTime() {
        return this.inner().freeTrialEndTime();
    }

    @Override
    public String hostName() {
        return this.inner().hostName();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public DateTime lastModified() {
        return this.inner().lastModified();
    }

    @Override
    public String location() {
        return this.inner().location();
    }

    @Override
    public Long maxCacheAge() {
        return this.inner().maxCacheAge();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public StreamingEndpointResourceState resourceState() {
        return this.inner().resourceState();
    }

    @Override
    public int scaleUnits() {
        return this.inner().scaleUnits();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public StreamingEndpointImpl withExistingMediaservice(String resourceGroupName, String accountName) {
        this.resourceGroupName = resourceGroupName;
        this.accountName = accountName;
        return this;
    }

    @Override
    public StreamingEndpointImpl withAutoStart(Boolean autoStart) {
        this.cautoStart = autoStart;
        return this;
    }

    @Override
    public StreamingEndpointImpl withLocation(String location) {
        this.inner().withLocation(location);
        return this;
    }

    @Override
    public StreamingEndpointImpl withScaleUnits(int scaleUnits) {
        this.inner().withScaleUnits(scaleUnits);
        return this;
    }

    @Override
    public StreamingEndpointImpl withAccessControl(StreamingEndpointAccessControl accessControl) {
        this.inner().withAccessControl(accessControl);
        return this;
    }

    @Override
    public StreamingEndpointImpl withAvailabilitySetName(String availabilitySetName) {
        this.inner().withAvailabilitySetName(availabilitySetName);
        return this;
    }

    @Override
    public StreamingEndpointImpl withCdnEnabled(Boolean cdnEnabled) {
        this.inner().withCdnEnabled(cdnEnabled);
        return this;
    }

    @Override
    public StreamingEndpointImpl withCdnProfile(String cdnProfile) {
        this.inner().withCdnProfile(cdnProfile);
        return this;
    }

    @Override
    public StreamingEndpointImpl withCdnProvider(String cdnProvider) {
        this.inner().withCdnProvider(cdnProvider);
        return this;
    }

    @Override
    public StreamingEndpointImpl withCrossSiteAccessPolicies(CrossSiteAccessPolicies crossSiteAccessPolicies) {
        this.inner().withCrossSiteAccessPolicies(crossSiteAccessPolicies);
        return this;
    }

    @Override
    public StreamingEndpointImpl withCustomHostNames(List<String> customHostNames) {
        this.inner().withCustomHostNames(customHostNames);
        return this;
    }

    @Override
    public StreamingEndpointImpl withDescription(String description) {
        this.inner().withDescription(description);
        return this;
    }

    @Override
    public StreamingEndpointImpl withMaxCacheAge(Long maxCacheAge) {
        this.inner().withMaxCacheAge(maxCacheAge);
        return this;
    }

    @Override
    public StreamingEndpointImpl withTags(Map<String, String> tags) {
        this.inner().withTags(tags);
        return this;
    }

}
