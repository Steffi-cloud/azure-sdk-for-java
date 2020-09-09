// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.authorization.fluent.inner.DirectoryObjectInner;
import com.azure.resourcemanager.authorization.fluent.inner.DirectoryObjectListResultInner;
import com.azure.resourcemanager.authorization.models.GetObjectsParameters;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in Objects. */
public final class ObjectsClient {
    private final ClientLogger logger = new ClientLogger(ObjectsClient.class);

    /** The proxy service used to perform REST calls. */
    private final ObjectsService service;

    /** The service client containing this operation class. */
    private final GraphRbacManagementClient client;

    /**
     * Initializes an instance of ObjectsClient.
     *
     * @param client the instance of the service client containing this operation class.
     */
    public ObjectsClient(GraphRbacManagementClient client) {
        this.service = RestProxy.create(ObjectsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for GraphRbacManagementClientObjects to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "GraphRbacManagementC")
    private interface ObjectsService {
        @Headers({"Accept: application/json,text/json", "Content-Type: application/json"})
        @Post("/{tenantID}/getObjectsByObjectIds")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<DirectoryObjectListResultInner>> getObjectsByObjectIds(
            @HostParam("$host") String endpoint,
            @QueryParam("api-version") String apiVersion,
            @PathParam("tenantID") String tenantId,
            @BodyParam("application/json") GetObjectsParameters parameters,
            Context context);

        @Headers({"Accept: application/json,text/json", "Content-Type: application/json"})
        @Post("/{tenantID}/{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<DirectoryObjectListResultInner>> getObjectsByObjectIdsNext(
            @HostParam("$host") String endpoint,
            @PathParam(value = "nextLink", encoded = true) String nextLink,
            @QueryParam("api-version") String apiVersion,
            @PathParam("tenantID") String tenantId,
            Context context);
    }

    /**
     * Gets the directory objects specified in a list of object IDs. You can also specify which resource collections
     * (users, groups, etc.) should be searched by specifying the optional types parameter.
     *
     * @param parameters Request parameters for the GetObjectsByObjectIds API.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the directory objects specified in a list of object IDs.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<DirectoryObjectInner>> getObjectsByObjectIdsSinglePageAsync(
        GetObjectsParameters parameters) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getTenantId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getTenantId() is required and cannot be null."));
        }
        if (parameters == null) {
            return Mono.error(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
        } else {
            parameters.validate();
        }
        return FluxUtil
            .withContext(
                context ->
                    service
                        .getObjectsByObjectIds(
                            this.client.getEndpoint(),
                            this.client.getApiVersion(),
                            this.client.getTenantId(),
                            parameters,
                            context))
            .<PagedResponse<DirectoryObjectInner>>map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().odataNextLink(),
                        null))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Gets the directory objects specified in a list of object IDs. You can also specify which resource collections
     * (users, groups, etc.) should be searched by specifying the optional types parameter.
     *
     * @param parameters Request parameters for the GetObjectsByObjectIds API.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the directory objects specified in a list of object IDs.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<DirectoryObjectInner>> getObjectsByObjectIdsSinglePageAsync(
        GetObjectsParameters parameters, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getTenantId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getTenantId() is required and cannot be null."));
        }
        if (parameters == null) {
            return Mono.error(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
        } else {
            parameters.validate();
        }
        context = this.client.mergeContext(context);
        return service
            .getObjectsByObjectIds(
                this.client.getEndpoint(), this.client.getApiVersion(), this.client.getTenantId(), parameters, context)
            .map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().odataNextLink(),
                        null));
    }

    /**
     * Gets the directory objects specified in a list of object IDs. You can also specify which resource collections
     * (users, groups, etc.) should be searched by specifying the optional types parameter.
     *
     * @param parameters Request parameters for the GetObjectsByObjectIds API.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the directory objects specified in a list of object IDs.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<DirectoryObjectInner> getObjectsByObjectIdsAsync(GetObjectsParameters parameters) {
        return new PagedFlux<>(
            () -> getObjectsByObjectIdsSinglePageAsync(parameters),
            nextLink -> getObjectsByObjectIdsNextSinglePageAsync(nextLink));
    }

    /**
     * Gets the directory objects specified in a list of object IDs. You can also specify which resource collections
     * (users, groups, etc.) should be searched by specifying the optional types parameter.
     *
     * @param parameters Request parameters for the GetObjectsByObjectIds API.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the directory objects specified in a list of object IDs.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<DirectoryObjectInner> getObjectsByObjectIdsAsync(
        GetObjectsParameters parameters, Context context) {
        return new PagedFlux<>(
            () -> getObjectsByObjectIdsSinglePageAsync(parameters, context),
            nextLink -> getObjectsByObjectIdsNextSinglePageAsync(nextLink, context));
    }

    /**
     * Gets the directory objects specified in a list of object IDs. You can also specify which resource collections
     * (users, groups, etc.) should be searched by specifying the optional types parameter.
     *
     * @param parameters Request parameters for the GetObjectsByObjectIds API.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the directory objects specified in a list of object IDs.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<DirectoryObjectInner> getObjectsByObjectIds(GetObjectsParameters parameters) {
        return new PagedIterable<>(getObjectsByObjectIdsAsync(parameters));
    }

    /**
     * Gets the directory objects specified in a list of object IDs. You can also specify which resource collections
     * (users, groups, etc.) should be searched by specifying the optional types parameter.
     *
     * @param parameters Request parameters for the GetObjectsByObjectIds API.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the directory objects specified in a list of object IDs.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<DirectoryObjectInner> getObjectsByObjectIds(GetObjectsParameters parameters, Context context) {
        return new PagedIterable<>(getObjectsByObjectIdsAsync(parameters, context));
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
     * @param nextLink Next link for the list operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return aD group membership for the specified AD object IDs.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<DirectoryObjectInner>> getObjectsByObjectIdsNextSinglePageAsync(String nextLink) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        if (this.client.getTenantId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getTenantId() is required and cannot be null."));
        }
        return FluxUtil
            .withContext(
                context ->
                    service
                        .getObjectsByObjectIdsNext(
                            this.client.getEndpoint(),
                            nextLink,
                            this.client.getApiVersion(),
                            this.client.getTenantId(),
                            context))
            .<PagedResponse<DirectoryObjectInner>>map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().odataNextLink(),
                        null))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
     * @param nextLink Next link for the list operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return aD group membership for the specified AD object IDs.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<DirectoryObjectInner>> getObjectsByObjectIdsNextSinglePageAsync(
        String nextLink, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        if (this.client.getTenantId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getTenantId() is required and cannot be null."));
        }
        context = this.client.mergeContext(context);
        return service
            .getObjectsByObjectIdsNext(
                this.client.getEndpoint(), nextLink, this.client.getApiVersion(), this.client.getTenantId(), context)
            .map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().odataNextLink(),
                        null));
    }
}
