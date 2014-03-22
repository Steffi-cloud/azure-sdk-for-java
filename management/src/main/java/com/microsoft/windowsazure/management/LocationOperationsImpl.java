/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.utils.XmlUtility;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.models.LocationsListResponse;
import com.microsoft.windowsazure.tracing.CloudTracing;

/**
* The Service Management API includes operations for listing the available data
* center locations for a hosted service in your subscription.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/gg441299.aspx for more
* information)
*/
public class LocationOperationsImpl implements ServiceOperations<ManagementClientImpl>, LocationOperations {
    /**
    * Initializes a new instance of the LocationOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    LocationOperationsImpl(ManagementClientImpl client) {
        this.client = client;
    }
    
    private ManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.ManagementClientImpl.
    * @return The Client value.
    */
    public ManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * The List Locations operation lists all of the data center locations that
    * are valid for your subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441293.aspx for
    * more information)
    *
    * @return The List Locations operation response.
    */
    @Override
    public Future<LocationsListResponse> listAsync() {
        return this.getClient().getExecutorService().submit(new Callable<LocationsListResponse>() { 
            @Override
            public LocationsListResponse call() throws Exception {
                return list();
            }
         });
    }
    
    /**
    * The List Locations operation lists all of the data center locations that
    * are valid for your subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441293.aspx for
    * more information)
    *
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The List Locations operation response.
    */
    @Override
    public LocationsListResponse list() throws IOException, ServiceException, ParserConfigurationException, SAXException {
        // Validate
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getClient().getBaseUri().toString();
        String url = "/" + this.getClient().getCredentials().getSubscriptionId() + "/locations";
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-03-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            LocationsListResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpResponse.getEntity().getContent();
            result = new LocationsListResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(responseContent);
            
            Element locationsSequenceElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/windowsazure", "Locations");
            if (locationsSequenceElement != null) {
                for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(locationsSequenceElement, "http://schemas.microsoft.com/windowsazure", "Location").size(); i1 = i1 + 1) {
                    org.w3c.dom.Element locationsElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(locationsSequenceElement, "http://schemas.microsoft.com/windowsazure", "Location").get(i1));
                    LocationsListResponse.Location locationInstance = new LocationsListResponse.Location();
                    result.getLocations().add(locationInstance);
                    
                    Element nameElement = XmlUtility.getElementByTagNameNS(locationsElement, "http://schemas.microsoft.com/windowsazure", "Name");
                    if (nameElement != null) {
                        String nameInstance;
                        nameInstance = nameElement.getTextContent();
                        locationInstance.setName(nameInstance);
                    }
                    
                    Element displayNameElement = XmlUtility.getElementByTagNameNS(locationsElement, "http://schemas.microsoft.com/windowsazure", "DisplayName");
                    if (displayNameElement != null) {
                        String displayNameInstance;
                        displayNameInstance = displayNameElement.getTextContent();
                        locationInstance.setDisplayName(displayNameInstance);
                    }
                    
                    Element availableServicesSequenceElement = XmlUtility.getElementByTagNameNS(locationsElement, "http://schemas.microsoft.com/windowsazure", "AvailableServices");
                    if (availableServicesSequenceElement != null) {
                        for (int i2 = 0; i2 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(availableServicesSequenceElement, "http://schemas.microsoft.com/windowsazure", "AvailableService").size(); i2 = i2 + 1) {
                            org.w3c.dom.Element availableServicesElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(availableServicesSequenceElement, "http://schemas.microsoft.com/windowsazure", "AvailableService").get(i2));
                            locationInstance.getAvailableServices().add(availableServicesElement.getTextContent());
                        }
                    }
                }
            }
            
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
}
