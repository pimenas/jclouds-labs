/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.vcloud.director.v1_5.user;

import static org.jclouds.Fallbacks.NullOnNotFoundOr404;

import java.io.Closeable;
import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.jclouds.rest.annotations.Delegate;
import org.jclouds.rest.annotations.EndpointParam;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.vcloud.director.v1_5.domain.Entity;
import org.jclouds.vcloud.director.v1_5.domain.Session;
import org.jclouds.vcloud.director.v1_5.features.CatalogApi;
import org.jclouds.vcloud.director.v1_5.features.MediaApi;
import org.jclouds.vcloud.director.v1_5.features.MetadataApi;
import org.jclouds.vcloud.director.v1_5.features.NetworkApi;
import org.jclouds.vcloud.director.v1_5.features.OrgApi;
import org.jclouds.vcloud.director.v1_5.features.QueryApi;
import org.jclouds.vcloud.director.v1_5.features.TaskApi;
import org.jclouds.vcloud.director.v1_5.features.UploadApi;
import org.jclouds.vcloud.director.v1_5.features.VAppApi;
import org.jclouds.vcloud.director.v1_5.features.VAppTemplateApi;
import org.jclouds.vcloud.director.v1_5.features.VdcApi;
import org.jclouds.vcloud.director.v1_5.features.VmApi;
import org.jclouds.vcloud.director.v1_5.filters.AddVCloudAuthorizationAndCookieToRequest;

import com.google.inject.Provides;

@RequestFilters(AddVCloudAuthorizationAndCookieToRequest.class)
public interface VCloudDirectorApi extends Closeable {

   /**
    * Redirects to the URL of an entity with the given VCD ID.
    *
    * <pre>
    * GET /entity/{id}
    * </pre>
    */
   @GET
   @Path("/entity/{id}")
   @Consumes
   @JAXBResponseParser
   @Fallback(NullOnNotFoundOr404.class)
   Entity resolveEntity(@PathParam("id") String id);
   
   /**
    * @return the current login session
    */
   @Provides
   Session getCurrentSession();

   /**
    * @return synchronous access to query features
    */
   @Delegate
   QueryApi getQueryApi();

   /**
    * @return synchronous access to {@link Org} features
    */
   @Delegate
   OrgApi getOrgApi();
   
   /**
    * @return synchronous access to {@link Task} features
    */
   @Delegate
   TaskApi getTaskApi();

   /**
    * @return synchronous access to {@link Network} features
    */
   @Delegate
   NetworkApi getNetworkApi();

   /**
    * @return synchronous access to {@link Catalog} features
    */
   @Delegate
   CatalogApi getCatalogApi();
   
   /**
    * @return synchronous access to {@link Media} features
    */
   @Delegate
   MediaApi getMediaApi();

   /**
    * @return synchronous access to {@link Vdc} features
    */
   @Delegate
   VdcApi getVdcApi();

   /**
    * @return synchronous access to upload features
    */
   @Delegate
   UploadApi getUploadApi();
   
   /**
    * @return synchronous access to {@link VApp} features
    */
   @Delegate
   VAppApi getVAppApi();

   /**
    * @return synchronous access to {@link VAppTemplate} features
    */
   @Delegate
   VAppTemplateApi getVAppTemplateApi();

   /**
    * @return synchronous access to {@link Vm} features
    */
   @Delegate
   VmApi getVmApi();

   @Delegate
   MetadataApi getMetadataApi(@EndpointParam URI href);
}
