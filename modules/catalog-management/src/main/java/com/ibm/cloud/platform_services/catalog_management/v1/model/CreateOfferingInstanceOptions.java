/*
 * (C) Copyright IBM Corp. 2021.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The createOfferingInstance options.
 */
public class CreateOfferingInstanceOptions extends GenericModel {

  protected String xAuthRefreshToken;
  protected String id;
  protected String rev;
  protected String url;
  protected String crn;
  protected String label;
  protected String catalogId;
  protected String offeringId;
  protected String kindFormat;
  protected String version;
  protected String clusterId;
  protected String clusterRegion;
  protected List<String> clusterNamespaces;
  protected Boolean clusterAllNamespaces;
  protected String schematicsWorkspaceId;
  protected String resourceGroupId;
  protected String installPlan;
  protected String channel;
  protected Map<String, Object> metadata;
  protected OfferingInstanceLastOperation lastOperation;

  /**
   * Builder.
   */
  public static class Builder {
    private String xAuthRefreshToken;
    private String id;
    private String rev;
    private String url;
    private String crn;
    private String label;
    private String catalogId;
    private String offeringId;
    private String kindFormat;
    private String version;
    private String clusterId;
    private String clusterRegion;
    private List<String> clusterNamespaces;
    private Boolean clusterAllNamespaces;
    private String schematicsWorkspaceId;
    private String resourceGroupId;
    private String installPlan;
    private String channel;
    private Map<String, Object> metadata;
    private OfferingInstanceLastOperation lastOperation;

    private Builder(CreateOfferingInstanceOptions createOfferingInstanceOptions) {
      this.xAuthRefreshToken = createOfferingInstanceOptions.xAuthRefreshToken;
      this.id = createOfferingInstanceOptions.id;
      this.rev = createOfferingInstanceOptions.rev;
      this.url = createOfferingInstanceOptions.url;
      this.crn = createOfferingInstanceOptions.crn;
      this.label = createOfferingInstanceOptions.label;
      this.catalogId = createOfferingInstanceOptions.catalogId;
      this.offeringId = createOfferingInstanceOptions.offeringId;
      this.kindFormat = createOfferingInstanceOptions.kindFormat;
      this.version = createOfferingInstanceOptions.version;
      this.clusterId = createOfferingInstanceOptions.clusterId;
      this.clusterRegion = createOfferingInstanceOptions.clusterRegion;
      this.clusterNamespaces = createOfferingInstanceOptions.clusterNamespaces;
      this.clusterAllNamespaces = createOfferingInstanceOptions.clusterAllNamespaces;
      this.schematicsWorkspaceId = createOfferingInstanceOptions.schematicsWorkspaceId;
      this.resourceGroupId = createOfferingInstanceOptions.resourceGroupId;
      this.installPlan = createOfferingInstanceOptions.installPlan;
      this.channel = createOfferingInstanceOptions.channel;
      this.metadata = createOfferingInstanceOptions.metadata;
      this.lastOperation = createOfferingInstanceOptions.lastOperation;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     */
    public Builder(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
    }

    /**
     * Builds a CreateOfferingInstanceOptions.
     *
     * @return the new CreateOfferingInstanceOptions instance
     */
    public CreateOfferingInstanceOptions build() {
      return new CreateOfferingInstanceOptions(this);
    }

    /**
     * Adds an clusterNamespaces to clusterNamespaces.
     *
     * @param clusterNamespaces the new clusterNamespaces
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder addClusterNamespaces(String clusterNamespaces) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(clusterNamespaces,
        "clusterNamespaces cannot be null");
      if (this.clusterNamespaces == null) {
        this.clusterNamespaces = new ArrayList<String>();
      }
      this.clusterNamespaces.add(clusterNamespaces);
      return this;
    }

    /**
     * Set the xAuthRefreshToken.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder xAuthRefreshToken(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the crn.
     *
     * @param crn the crn
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder crn(String crn) {
      this.crn = crn;
      return this;
    }

    /**
     * Set the label.
     *
     * @param label the label
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Set the catalogId.
     *
     * @param catalogId the catalogId
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder catalogId(String catalogId) {
      this.catalogId = catalogId;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the kindFormat.
     *
     * @param kindFormat the kindFormat
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder kindFormat(String kindFormat) {
      this.kindFormat = kindFormat;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the clusterRegion.
     *
     * @param clusterRegion the clusterRegion
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder clusterRegion(String clusterRegion) {
      this.clusterRegion = clusterRegion;
      return this;
    }

    /**
     * Set the clusterNamespaces.
     * Existing clusterNamespaces will be replaced.
     *
     * @param clusterNamespaces the clusterNamespaces
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder clusterNamespaces(List<String> clusterNamespaces) {
      this.clusterNamespaces = clusterNamespaces;
      return this;
    }

    /**
     * Set the clusterAllNamespaces.
     *
     * @param clusterAllNamespaces the clusterAllNamespaces
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder clusterAllNamespaces(Boolean clusterAllNamespaces) {
      this.clusterAllNamespaces = clusterAllNamespaces;
      return this;
    }

    /**
     * Set the schematicsWorkspaceId.
     *
     * @param schematicsWorkspaceId the schematicsWorkspaceId
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder schematicsWorkspaceId(String schematicsWorkspaceId) {
      this.schematicsWorkspaceId = schematicsWorkspaceId;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the installPlan.
     *
     * @param installPlan the installPlan
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder installPlan(String installPlan) {
      this.installPlan = installPlan;
      return this;
    }

    /**
     * Set the channel.
     *
     * @param channel the channel
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder channel(String channel) {
      this.channel = channel;
      return this;
    }

    /**
     * Set the metadata.
     *
     * @param metadata the metadata
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder metadata(Map<String, Object> metadata) {
      this.metadata = metadata;
      return this;
    }

    /**
     * Set the lastOperation.
     *
     * @param lastOperation the lastOperation
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder lastOperation(OfferingInstanceLastOperation lastOperation) {
      this.lastOperation = lastOperation;
      return this;
    }

    /**
     * Set the offeringInstance.
     *
     * @param offeringInstance the offeringInstance
     * @return the CreateOfferingInstanceOptions builder
     */
    public Builder offeringInstance(OfferingInstance offeringInstance) {
      this.id = offeringInstance.id();
      this.rev = offeringInstance.rev();
      this.url = offeringInstance.url();
      this.crn = offeringInstance.crn();
      this.label = offeringInstance.label();
      this.catalogId = offeringInstance.catalogId();
      this.offeringId = offeringInstance.offeringId();
      this.kindFormat = offeringInstance.kindFormat();
      this.version = offeringInstance.version();
      this.clusterId = offeringInstance.clusterId();
      this.clusterRegion = offeringInstance.clusterRegion();
      this.clusterNamespaces = offeringInstance.clusterNamespaces();
      this.clusterAllNamespaces = offeringInstance.clusterAllNamespaces();
      this.schematicsWorkspaceId = offeringInstance.schematicsWorkspaceId();
      this.resourceGroupId = offeringInstance.resourceGroupId();
      this.installPlan = offeringInstance.installPlan();
      this.channel = offeringInstance.channel();
      this.metadata = offeringInstance.metadata();
      this.lastOperation = offeringInstance.lastOperation();
      return this;
    }
  }

  protected CreateOfferingInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xAuthRefreshToken,
      "xAuthRefreshToken cannot be null");
    xAuthRefreshToken = builder.xAuthRefreshToken;
    id = builder.id;
    rev = builder.rev;
    url = builder.url;
    crn = builder.crn;
    label = builder.label;
    catalogId = builder.catalogId;
    offeringId = builder.offeringId;
    kindFormat = builder.kindFormat;
    version = builder.version;
    clusterId = builder.clusterId;
    clusterRegion = builder.clusterRegion;
    clusterNamespaces = builder.clusterNamespaces;
    clusterAllNamespaces = builder.clusterAllNamespaces;
    schematicsWorkspaceId = builder.schematicsWorkspaceId;
    resourceGroupId = builder.resourceGroupId;
    installPlan = builder.installPlan;
    channel = builder.channel;
    metadata = builder.metadata;
    lastOperation = builder.lastOperation;
  }

  /**
   * New builder.
   *
   * @return a CreateOfferingInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the xAuthRefreshToken.
   *
   * IAM Refresh token.
   *
   * @return the xAuthRefreshToken
   */
  public String xAuthRefreshToken() {
    return xAuthRefreshToken;
  }

  /**
   * Gets the id.
   *
   * provisioned instance ID (part of the CRN).
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the rev.
   *
   * Cloudant revision.
   *
   * @return the rev
   */
  public String rev() {
    return rev;
  }

  /**
   * Gets the url.
   *
   * url reference to this object.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the crn.
   *
   * platform CRN for this instance.
   *
   * @return the crn
   */
  public String crn() {
    return crn;
  }

  /**
   * Gets the label.
   *
   * the label for this instance.
   *
   * @return the label
   */
  public String label() {
    return label;
  }

  /**
   * Gets the catalogId.
   *
   * Catalog ID this instance was created from.
   *
   * @return the catalogId
   */
  public String catalogId() {
    return catalogId;
  }

  /**
   * Gets the offeringId.
   *
   * Offering ID this instance was created from.
   *
   * @return the offeringId
   */
  public String offeringId() {
    return offeringId;
  }

  /**
   * Gets the kindFormat.
   *
   * the format this instance has (helm, operator, ova...).
   *
   * @return the kindFormat
   */
  public String kindFormat() {
    return kindFormat;
  }

  /**
   * Gets the version.
   *
   * The version this instance was installed from (not version id).
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the clusterId.
   *
   * Cluster ID.
   *
   * @return the clusterId
   */
  public String clusterId() {
    return clusterId;
  }

  /**
   * Gets the clusterRegion.
   *
   * Cluster region (e.g., us-south).
   *
   * @return the clusterRegion
   */
  public String clusterRegion() {
    return clusterRegion;
  }

  /**
   * Gets the clusterNamespaces.
   *
   * List of target namespaces to install into.
   *
   * @return the clusterNamespaces
   */
  public List<String> clusterNamespaces() {
    return clusterNamespaces;
  }

  /**
   * Gets the clusterAllNamespaces.
   *
   * designate to install into all namespaces.
   *
   * @return the clusterAllNamespaces
   */
  public Boolean clusterAllNamespaces() {
    return clusterAllNamespaces;
  }

  /**
   * Gets the schematicsWorkspaceId.
   *
   * Id of the schematics workspace, for offering instances provisioned through schematics.
   *
   * @return the schematicsWorkspaceId
   */
  public String schematicsWorkspaceId() {
    return schematicsWorkspaceId;
  }

  /**
   * Gets the resourceGroupId.
   *
   * Id of the resource group to provision the offering instance into.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the installPlan.
   *
   * Type of install plan (also known as approval strategy) for operator subscriptions. Can be either automatic, which
   * automatically upgrades operators to the latest in a channel, or manual, which requires approval on the cluster.
   *
   * @return the installPlan
   */
  public String installPlan() {
    return installPlan;
  }

  /**
   * Gets the channel.
   *
   * Channel to pin the operator subscription to.
   *
   * @return the channel
   */
  public String channel() {
    return channel;
  }

  /**
   * Gets the metadata.
   *
   * Map of metadata values for this offering instance.
   *
   * @return the metadata
   */
  public Map<String, Object> metadata() {
    return metadata;
  }

  /**
   * Gets the lastOperation.
   *
   * the last operation performed and status.
   *
   * @return the lastOperation
   */
  public OfferingInstanceLastOperation lastOperation() {
    return lastOperation;
  }
}

