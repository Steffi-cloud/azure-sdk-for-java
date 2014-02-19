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

package com.microsoft.windowsazure.management.servicebus;

import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.utils.XmlUtility;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.servicebus.models.AccessRight;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusConnectionDetail;
import com.microsoft.windowsazure.management.servicebus.models.ServiceBusConnectionDetailsResponse;
import com.microsoft.windowsazure.tracing.CloudTracing;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
* The Service Bus Management API includes operations for managing Service Bus
* relays.
*/
public class RelayOperationsImpl implements ServiceOperations<ServiceBusManagementClientImpl>, RelayOperations {
    /**
    * Initializes a new instance of the RelayOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    RelayOperationsImpl(ServiceBusManagementClientImpl client) {
        this.client = client;
    }
    
    private ServiceBusManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.servicebus.ServiceBusManagementClientImpl.
    * @return The Client value.
    */
    public ServiceBusManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * Gets the set of connection strings for a relay.
    *
    * @param namespaceName The namespace name.
    * @param relayName The relay name.
    * @return The set of connection details for a service bus entity.
    */
    @Override
    public Future<ServiceBusConnectionDetailsResponse> getConnectionDetailsAsync(final String namespaceName, final String relayName) {
        return this.getClient().getExecutorService().submit(new Callable<ServiceBusConnectionDetailsResponse>() { 
            @Override
            public ServiceBusConnectionDetailsResponse call() throws Exception {
                return getConnectionDetails(namespaceName, relayName);
            }
         });
    }
    
    /**
    * Gets the set of connection strings for a relay.
    *
    * @param namespaceName The namespace name.
    * @param relayName The relay name.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The set of connection details for a service bus entity.
    */
    @Override
    public ServiceBusConnectionDetailsResponse getConnectionDetails(String namespaceName, String relayName) throws IOException, ServiceException, ParserConfigurationException, SAXException {
        // Validate
        if (namespaceName == null) {
            throw new NullPointerException("namespaceName");
        }
        if (relayName == null) {
            throw new NullPointerException("relayName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("namespaceName", namespaceName);
            tracingParameters.put("relayName", relayName);
            CloudTracing.enter(invocationId, this, "getConnectionDetailsAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/services/servicebus/namespaces/" + namespaceName + "/Relays/" + relayName + "/ConnectionDetails";
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("Content-Type", "application/xml; charset=utf-8");
        httpRequest.setHeader("x-ms-version", "2013-08-01");
        
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
            ServiceBusConnectionDetailsResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpResponse.getEntity().getContent();
            result = new ServiceBusConnectionDetailsResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(responseContent);
            
            NodeList elements = XmlUtility.getElementsByTagNameNS(responseDoc, "http://www.w3.org/2005/Atom", "feed");
            Element feedElement = elements.getLength() > 0 ? ((Element) elements.item(0)) : null;
            if (feedElement != null) {
                if (feedElement != null) {
                    for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(feedElement, "http://www.w3.org/2005/Atom", "entry").getLength(); i1 = i1 + 1) {
                        org.w3c.dom.Element entriesElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(feedElement, "http://www.w3.org/2005/Atom", "entry").item(i1));
                        ServiceBusConnectionDetail entryInstance = new ServiceBusConnectionDetail();
                        result.getConnectionDetails().add(entryInstance);
                        
                        NodeList elements2 = XmlUtility.getElementsByTagNameNS(entriesElement, "http://www.w3.org/2005/Atom", "content");
                        Element contentElement = elements2.getLength() > 0 ? ((Element) elements2.item(0)) : null;
                        if (contentElement != null) {
                            NodeList elements3 = XmlUtility.getElementsByTagNameNS(contentElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "ConnectionDetail");
                            Element connectionDetailElement = elements3.getLength() > 0 ? ((Element) elements3.item(0)) : null;
                            if (connectionDetailElement != null) {
                                NodeList elements4 = XmlUtility.getElementsByTagNameNS(connectionDetailElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "KeyName");
                                Element keyNameElement = elements4.getLength() > 0 ? ((Element) elements4.item(0)) : null;
                                if (keyNameElement != null) {
                                    String keyNameInstance;
                                    keyNameInstance = keyNameElement.getTextContent();
                                    entryInstance.setKeyName(keyNameInstance);
                                }
                                
                                NodeList elements5 = XmlUtility.getElementsByTagNameNS(connectionDetailElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "ConnectionString");
                                Element connectionStringElement = elements5.getLength() > 0 ? ((Element) elements5.item(0)) : null;
                                if (connectionStringElement != null) {
                                    String connectionStringInstance;
                                    connectionStringInstance = connectionStringElement.getTextContent();
                                    entryInstance.setConnectionString(connectionStringInstance);
                                }
                                
                                NodeList elements6 = XmlUtility.getElementsByTagNameNS(connectionDetailElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AuthorizationType");
                                Element authorizationTypeElement = elements6.getLength() > 0 ? ((Element) elements6.item(0)) : null;
                                if (authorizationTypeElement != null) {
                                    String authorizationTypeInstance;
                                    authorizationTypeInstance = authorizationTypeElement.getTextContent();
                                    entryInstance.setAuthorizationType(authorizationTypeInstance);
                                }
                                
                                NodeList elements7 = XmlUtility.getElementsByTagNameNS(connectionDetailElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "Rights");
                                Element rightsSequenceElement = elements7.getLength() > 0 ? ((Element) elements7.item(0)) : null;
                                if (rightsSequenceElement != null) {
                                    for (int i2 = 0; i2 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(rightsSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AccessRights").getLength(); i2 = i2 + 1) {
                                        org.w3c.dom.Element rightsElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(rightsSequenceElement, "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect", "AccessRights").item(i2));
                                        entryInstance.getRights().add(AccessRight.valueOf(rightsElement.getTextContent()));
                                    }
                                }
                            }
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
