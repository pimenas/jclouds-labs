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
package org.jclouds.vcloud.director.v1_5.domain.params;

import static com.google.common.base.Objects.equal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@XmlRootElement(name = "PublishCatalogParams")
@XmlType(propOrder = {
    "isPublished"
})
//TODO: this is ridiculously complex boolean wrapper.
public class PublishCatalogParams {
   
   public static Builder builder() {
      return new Builder();
   }

   public Builder toBuilder() {
      return new Builder().fromPublishCatalogParams(this);
   }

   public static class Builder {
      
      private boolean isPublished;

      /**
       * @see PublishCatalogParams#getIsPublished()
       */
      public Builder isPublished(boolean isPublished) {
         this.isPublished = isPublished;
         return this;
      }

      public PublishCatalogParams build() {
         return new PublishCatalogParams(isPublished);
      }

      public Builder fromPublishCatalogParams(PublishCatalogParams in) {
         return isPublished(in.isPublished());
      }
   }

   @SuppressWarnings("unused")
   private PublishCatalogParams() {
      // For JAXB and builder use
   }
   
   public PublishCatalogParams(Boolean isPublished) {
      this.isPublished = isPublished;
   }

    @XmlElement(name = "IsPublished")
    protected boolean isPublished;

    /**
     * Gets the value of the isPublished property.
     * 
     */
    public boolean isPublished() {
        return isPublished;
    }

   @Override
   public boolean equals(Object o) {
      if (this == o)
          return true;
      if (o == null || getClass() != o.getClass())
         return false;
      PublishCatalogParams that = PublishCatalogParams.class.cast(o);
      return equal(isPublished, that.isPublished);
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(isPublished);
   }

   @Override
   public String toString() {
      return MoreObjects.toStringHelper("")
            .add("isPublished", isPublished).toString();
   }

}
