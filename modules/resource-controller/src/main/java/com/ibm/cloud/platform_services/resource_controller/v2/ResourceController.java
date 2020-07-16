/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.resource_controller.v2;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListReclamationsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceInstancesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceKeysOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.LockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.Reclamation;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ReclamationsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAlias;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAliasesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBinding;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstance;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstancesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKey;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeysList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.RunReclamationActionOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UnlockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceKeyOptions;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Manage lifecycle of your Cloud resources using Resource Controller APIs. Resources are provisioned globally in an
 * account scope. Supports asynchronous provisioning of resources. Enables consumption of a global resource through a
 * Cloud Foundry space in any region.
 *
 * @version v2
 */
public class ResourceController extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "resource_controller";

  public static final String DEFAULT_SERVICE_URL = "https://resource-controller.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `ResourceController` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `ResourceController` client using external configuration
   */
  public static ResourceController newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `ResourceController` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `ResourceController` client using external configuration
   */
  public static ResourceController newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    ResourceController service = new ResourceController(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `ResourceController` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public ResourceController(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get a list of all resource instances.
   *
   * Get a list of all resource instances.
   *
   * @param listResourceInstancesOptions the {@link ListResourceInstancesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstancesList}
   */
  public ServiceCall<ResourceInstancesList> listResourceInstances(ListResourceInstancesOptions listResourceInstancesOptions) {
    String[] pathSegments = { "v2/resource_instances" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceInstances");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceInstancesOptions != null) {
      if (listResourceInstancesOptions.guid() != null) {
        builder.query("guid", listResourceInstancesOptions.guid());
      }
      if (listResourceInstancesOptions.name() != null) {
        builder.query("name", listResourceInstancesOptions.name());
      }
      if (listResourceInstancesOptions.resourceGroupId() != null) {
        builder.query("resource_group_id", listResourceInstancesOptions.resourceGroupId());
      }
      if (listResourceInstancesOptions.resourceId() != null) {
        builder.query("resource_id", listResourceInstancesOptions.resourceId());
      }
      if (listResourceInstancesOptions.resourcePlanId() != null) {
        builder.query("resource_plan_id", listResourceInstancesOptions.resourcePlanId());
      }
      if (listResourceInstancesOptions.type() != null) {
        builder.query("type", listResourceInstancesOptions.type());
      }
      if (listResourceInstancesOptions.subType() != null) {
        builder.query("sub_type", listResourceInstancesOptions.subType());
      }
      if (listResourceInstancesOptions.limit() != null) {
        builder.query("limit", listResourceInstancesOptions.limit());
      }
      if (listResourceInstancesOptions.updatedFrom() != null) {
        builder.query("updated_from", listResourceInstancesOptions.updatedFrom());
      }
      if (listResourceInstancesOptions.updatedTo() != null) {
        builder.query("updated_to", listResourceInstancesOptions.updatedTo());
      }
    }
    ResponseConverter<ResourceInstancesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstancesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource instances.
   *
   * Get a list of all resource instances.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstancesList}
   */
  public ServiceCall<ResourceInstancesList> listResourceInstances() {
    return listResourceInstances(null);
  }

  /**
   * Create (provision) a new resource instance.
   *
   * Provision a new resource in the specified location for the selected plan.
   *
   * @param createResourceInstanceOptions the {@link CreateResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstance}
   */
  public ServiceCall<ResourceInstance> createResourceInstance(CreateResourceInstanceOptions createResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createResourceInstanceOptions,
      "createResourceInstanceOptions cannot be null");
    String[] pathSegments = { "v2/resource_instances" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "createResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createResourceInstanceOptions.entityLock() != null) {
      builder.header("Entity-Lock", createResourceInstanceOptions.entityLock());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createResourceInstanceOptions.name());
    contentJson.addProperty("target", createResourceInstanceOptions.target());
    contentJson.addProperty("resource_group", createResourceInstanceOptions.resourceGroup());
    contentJson.addProperty("resource_plan_id", createResourceInstanceOptions.resourcePlanId());
    if (createResourceInstanceOptions.tags() != null) {
      contentJson.add("tags", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createResourceInstanceOptions.tags()));
    }
    if (createResourceInstanceOptions.allowCleanup() != null) {
      contentJson.addProperty("allow_cleanup", createResourceInstanceOptions.allowCleanup());
    }
    if (createResourceInstanceOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createResourceInstanceOptions.parameters()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a resource instance.
   *
   * Retrieve a resource instance by ID.
   *
   * @param getResourceInstanceOptions the {@link GetResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstance}
   */
  public ServiceCall<ResourceInstance> getResourceInstance(GetResourceInstanceOptions getResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceInstanceOptions,
      "getResourceInstanceOptions cannot be null");
    String[] pathSegments = { "v2/resource_instances" };
    String[] pathParameters = { getResourceInstanceOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "getResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ResourceInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a resource instance.
   *
   * Delete a resource instance by ID.
   *
   * @param deleteResourceInstanceOptions the {@link DeleteResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteResourceInstance(DeleteResourceInstanceOptions deleteResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteResourceInstanceOptions,
      "deleteResourceInstanceOptions cannot be null");
    String[] pathSegments = { "v2/resource_instances" };
    String[] pathParameters = { deleteResourceInstanceOptions.id() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "deleteResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a resource instance.
   *
   * Update a resource instance by ID.
   *
   * @param updateResourceInstanceOptions the {@link UpdateResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstance}
   */
  public ServiceCall<ResourceInstance> updateResourceInstance(UpdateResourceInstanceOptions updateResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateResourceInstanceOptions,
      "updateResourceInstanceOptions cannot be null");
    String[] pathSegments = { "v2/resource_instances" };
    String[] pathParameters = { updateResourceInstanceOptions.id() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "updateResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateResourceInstanceOptions.name() != null) {
      contentJson.addProperty("name", updateResourceInstanceOptions.name());
    }
    if (updateResourceInstanceOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateResourceInstanceOptions.parameters()));
    }
    if (updateResourceInstanceOptions.resourcePlanId() != null) {
      contentJson.addProperty("resource_plan_id", updateResourceInstanceOptions.resourcePlanId());
    }
    if (updateResourceInstanceOptions.allowCleanup() != null) {
      contentJson.addProperty("allow_cleanup", updateResourceInstanceOptions.allowCleanup());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Lock a resource instance.
   *
   * Locks a resource instance by ID. A locked instance can not be updated or deleted. It does not affect actions
   * performed on child resources like aliases, bindings or keys.
   *
   * @param lockResourceInstanceOptions the {@link LockResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstance}
   */
  public ServiceCall<ResourceInstance> lockResourceInstance(LockResourceInstanceOptions lockResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(lockResourceInstanceOptions,
      "lockResourceInstanceOptions cannot be null");
    String[] pathSegments = { "v2/resource_instances", "lock" };
    String[] pathParameters = { lockResourceInstanceOptions.id() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "lockResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ResourceInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Unlock a resource instance.
   *
   * Unlocks a resource instance by ID.
   *
   * @param unlockResourceInstanceOptions the {@link UnlockResourceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceInstance}
   */
  public ServiceCall<ResourceInstance> unlockResourceInstance(UnlockResourceInstanceOptions unlockResourceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(unlockResourceInstanceOptions,
      "unlockResourceInstanceOptions cannot be null");
    String[] pathSegments = { "v2/resource_instances", "lock" };
    String[] pathParameters = { unlockResourceInstanceOptions.id() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "unlockResourceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ResourceInstance> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceInstance>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all of the resource keys.
   *
   * List all resource keys.
   *
   * @param listResourceKeysOptions the {@link ListResourceKeysOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceKeysList}
   */
  public ServiceCall<ResourceKeysList> listResourceKeys(ListResourceKeysOptions listResourceKeysOptions) {
    String[] pathSegments = { "v2/resource_keys" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceKeys");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceKeysOptions != null) {
      if (listResourceKeysOptions.guid() != null) {
        builder.query("guid", listResourceKeysOptions.guid());
      }
      if (listResourceKeysOptions.name() != null) {
        builder.query("name", listResourceKeysOptions.name());
      }
      if (listResourceKeysOptions.resourceGroupId() != null) {
        builder.query("resource_group_id", listResourceKeysOptions.resourceGroupId());
      }
      if (listResourceKeysOptions.resourceId() != null) {
        builder.query("resource_id", listResourceKeysOptions.resourceId());
      }
      if (listResourceKeysOptions.limit() != null) {
        builder.query("limit", listResourceKeysOptions.limit());
      }
      if (listResourceKeysOptions.updatedFrom() != null) {
        builder.query("updated_from", listResourceKeysOptions.updatedFrom());
      }
      if (listResourceKeysOptions.updatedTo() != null) {
        builder.query("updated_to", listResourceKeysOptions.updatedTo());
      }
    }
    ResponseConverter<ResourceKeysList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceKeysList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all of the resource keys.
   *
   * List all resource keys.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceKeysList}
   */
  public ServiceCall<ResourceKeysList> listResourceKeys() {
    return listResourceKeys(null);
  }

  /**
   * Create a new resource key.
   *
   * Create a new resource key.
   *
   * @param createResourceKeyOptions the {@link CreateResourceKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceKey}
   */
  public ServiceCall<ResourceKey> createResourceKey(CreateResourceKeyOptions createResourceKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createResourceKeyOptions,
      "createResourceKeyOptions cannot be null");
    String[] pathSegments = { "v2/resource_keys" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "createResourceKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createResourceKeyOptions.name());
    contentJson.addProperty("source", createResourceKeyOptions.source());
    if (createResourceKeyOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createResourceKeyOptions.parameters()));
    }
    if (createResourceKeyOptions.role() != null) {
      contentJson.addProperty("role", createResourceKeyOptions.role());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get resource key by ID.
   *
   * Get resource key by ID.
   *
   * @param getResourceKeyOptions the {@link GetResourceKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceKey}
   */
  public ServiceCall<ResourceKey> getResourceKey(GetResourceKeyOptions getResourceKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceKeyOptions,
      "getResourceKeyOptions cannot be null");
    String[] pathSegments = { "v2/resource_keys" };
    String[] pathParameters = { getResourceKeyOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "getResourceKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ResourceKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a resource key by ID.
   *
   * Delete a resource key by ID.
   *
   * @param deleteResourceKeyOptions the {@link DeleteResourceKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteResourceKey(DeleteResourceKeyOptions deleteResourceKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteResourceKeyOptions,
      "deleteResourceKeyOptions cannot be null");
    String[] pathSegments = { "v2/resource_keys" };
    String[] pathParameters = { deleteResourceKeyOptions.id() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "deleteResourceKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a resource key.
   *
   * Update a resource key by ID.
   *
   * @param updateResourceKeyOptions the {@link UpdateResourceKeyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceKey}
   */
  public ServiceCall<ResourceKey> updateResourceKey(UpdateResourceKeyOptions updateResourceKeyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateResourceKeyOptions,
      "updateResourceKeyOptions cannot be null");
    String[] pathSegments = { "v2/resource_keys" };
    String[] pathParameters = { updateResourceKeyOptions.id() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "updateResourceKey");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateResourceKeyOptions.name());
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceKey> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceKey>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource bindings.
   *
   * Get a list of all resource bindings.
   *
   * @param listResourceBindingsOptions the {@link ListResourceBindingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceBindingsList}
   */
  public ServiceCall<ResourceBindingsList> listResourceBindings(ListResourceBindingsOptions listResourceBindingsOptions) {
    String[] pathSegments = { "v2/resource_bindings" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceBindings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceBindingsOptions != null) {
      if (listResourceBindingsOptions.guid() != null) {
        builder.query("guid", listResourceBindingsOptions.guid());
      }
      if (listResourceBindingsOptions.name() != null) {
        builder.query("name", listResourceBindingsOptions.name());
      }
      if (listResourceBindingsOptions.resourceGroupId() != null) {
        builder.query("resource_group_id", listResourceBindingsOptions.resourceGroupId());
      }
      if (listResourceBindingsOptions.resourceId() != null) {
        builder.query("resource_id", listResourceBindingsOptions.resourceId());
      }
      if (listResourceBindingsOptions.regionBindingId() != null) {
        builder.query("region_binding_id", listResourceBindingsOptions.regionBindingId());
      }
      if (listResourceBindingsOptions.limit() != null) {
        builder.query("limit", listResourceBindingsOptions.limit());
      }
      if (listResourceBindingsOptions.updatedFrom() != null) {
        builder.query("updated_from", listResourceBindingsOptions.updatedFrom());
      }
      if (listResourceBindingsOptions.updatedTo() != null) {
        builder.query("updated_to", listResourceBindingsOptions.updatedTo());
      }
    }
    ResponseConverter<ResourceBindingsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceBindingsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource bindings.
   *
   * Get a list of all resource bindings.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceBindingsList}
   */
  public ServiceCall<ResourceBindingsList> listResourceBindings() {
    return listResourceBindings(null);
  }

  /**
   * Create a new resource binding.
   *
   * Create a new resource binding.
   *
   * @param createResourceBindingOptions the {@link CreateResourceBindingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceBinding}
   */
  public ServiceCall<ResourceBinding> createResourceBinding(CreateResourceBindingOptions createResourceBindingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createResourceBindingOptions,
      "createResourceBindingOptions cannot be null");
    String[] pathSegments = { "v2/resource_bindings" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "createResourceBinding");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("source", createResourceBindingOptions.source());
    contentJson.addProperty("target", createResourceBindingOptions.target());
    if (createResourceBindingOptions.name() != null) {
      contentJson.addProperty("name", createResourceBindingOptions.name());
    }
    if (createResourceBindingOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createResourceBindingOptions.parameters()));
    }
    if (createResourceBindingOptions.role() != null) {
      contentJson.addProperty("role", createResourceBindingOptions.role());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceBinding> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceBinding>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a resource binding.
   *
   * Retrieve a resource binding by ID.
   *
   * @param getResourceBindingOptions the {@link GetResourceBindingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceBinding}
   */
  public ServiceCall<ResourceBinding> getResourceBinding(GetResourceBindingOptions getResourceBindingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceBindingOptions,
      "getResourceBindingOptions cannot be null");
    String[] pathSegments = { "v2/resource_bindings" };
    String[] pathParameters = { getResourceBindingOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "getResourceBinding");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ResourceBinding> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceBinding>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a resource binding.
   *
   * Delete a resource binding by ID.
   *
   * @param deleteResourceBindingOptions the {@link DeleteResourceBindingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteResourceBinding(DeleteResourceBindingOptions deleteResourceBindingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteResourceBindingOptions,
      "deleteResourceBindingOptions cannot be null");
    String[] pathSegments = { "v2/resource_bindings" };
    String[] pathParameters = { deleteResourceBindingOptions.id() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "deleteResourceBinding");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a resource binding.
   *
   * Update a resource binding by ID.
   *
   * @param updateResourceBindingOptions the {@link UpdateResourceBindingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceBinding}
   */
  public ServiceCall<ResourceBinding> updateResourceBinding(UpdateResourceBindingOptions updateResourceBindingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateResourceBindingOptions,
      "updateResourceBindingOptions cannot be null");
    String[] pathSegments = { "v2/resource_bindings" };
    String[] pathParameters = { updateResourceBindingOptions.id() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "updateResourceBinding");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateResourceBindingOptions.name());
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceBinding> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceBinding>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource aliases.
   *
   * Get a list of all resource aliases.
   *
   * @param listResourceAliasesOptions the {@link ListResourceAliasesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceAliasesList}
   */
  public ServiceCall<ResourceAliasesList> listResourceAliases(ListResourceAliasesOptions listResourceAliasesOptions) {
    String[] pathSegments = { "v2/resource_aliases" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listResourceAliases");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listResourceAliasesOptions != null) {
      if (listResourceAliasesOptions.guid() != null) {
        builder.query("guid", listResourceAliasesOptions.guid());
      }
      if (listResourceAliasesOptions.name() != null) {
        builder.query("name", listResourceAliasesOptions.name());
      }
      if (listResourceAliasesOptions.resourceInstanceId() != null) {
        builder.query("resource_instance_id", listResourceAliasesOptions.resourceInstanceId());
      }
      if (listResourceAliasesOptions.regionInstanceId() != null) {
        builder.query("region_instance_id", listResourceAliasesOptions.regionInstanceId());
      }
      if (listResourceAliasesOptions.resourceId() != null) {
        builder.query("resource_id", listResourceAliasesOptions.resourceId());
      }
      if (listResourceAliasesOptions.resourceGroupId() != null) {
        builder.query("resource_group_id", listResourceAliasesOptions.resourceGroupId());
      }
      if (listResourceAliasesOptions.limit() != null) {
        builder.query("limit", listResourceAliasesOptions.limit());
      }
      if (listResourceAliasesOptions.updatedFrom() != null) {
        builder.query("updated_from", listResourceAliasesOptions.updatedFrom());
      }
      if (listResourceAliasesOptions.updatedTo() != null) {
        builder.query("updated_to", listResourceAliasesOptions.updatedTo());
      }
    }
    ResponseConverter<ResourceAliasesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceAliasesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all resource aliases.
   *
   * Get a list of all resource aliases.
   *
   * @return a {@link ServiceCall} with a result of type {@link ResourceAliasesList}
   */
  public ServiceCall<ResourceAliasesList> listResourceAliases() {
    return listResourceAliases(null);
  }

  /**
   * Create a new resource alias.
   *
   * Alias a resource instance into a targeted environment's (name)space.
   *
   * @param createResourceAliasOptions the {@link CreateResourceAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceAlias}
   */
  public ServiceCall<ResourceAlias> createResourceAlias(CreateResourceAliasOptions createResourceAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createResourceAliasOptions,
      "createResourceAliasOptions cannot be null");
    String[] pathSegments = { "v2/resource_aliases" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "createResourceAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", createResourceAliasOptions.name());
    contentJson.addProperty("source", createResourceAliasOptions.source());
    contentJson.addProperty("target", createResourceAliasOptions.target());
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceAlias> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceAlias>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a resource alias.
   *
   * Retrieve a resource alias by ID.
   *
   * @param getResourceAliasOptions the {@link GetResourceAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceAlias}
   */
  public ServiceCall<ResourceAlias> getResourceAlias(GetResourceAliasOptions getResourceAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getResourceAliasOptions,
      "getResourceAliasOptions cannot be null");
    String[] pathSegments = { "v2/resource_aliases" };
    String[] pathParameters = { getResourceAliasOptions.id() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "getResourceAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<ResourceAlias> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceAlias>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a resource alias.
   *
   * Delete a resource alias by ID.
   *
   * @param deleteResourceAliasOptions the {@link DeleteResourceAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteResourceAlias(DeleteResourceAliasOptions deleteResourceAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteResourceAliasOptions,
      "deleteResourceAliasOptions cannot be null");
    String[] pathSegments = { "v2/resource_aliases" };
    String[] pathParameters = { deleteResourceAliasOptions.id() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "deleteResourceAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }

    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a resource alias.
   *
   * Update a resource alias by ID.
   *
   * @param updateResourceAliasOptions the {@link UpdateResourceAliasOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResourceAlias}
   */
  public ServiceCall<ResourceAlias> updateResourceAlias(UpdateResourceAliasOptions updateResourceAliasOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateResourceAliasOptions,
      "updateResourceAliasOptions cannot be null");
    String[] pathSegments = { "v2/resource_aliases" };
    String[] pathParameters = { updateResourceAliasOptions.id() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "updateResourceAlias");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateResourceAliasOptions.name());
    builder.bodyJson(contentJson);
    ResponseConverter<ResourceAlias> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResourceAlias>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all reclamations.
   *
   * Get a list of all reclamations.
   *
   * @param listReclamationsOptions the {@link ListReclamationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ReclamationsList}
   */
  public ServiceCall<ReclamationsList> listReclamations(ListReclamationsOptions listReclamationsOptions) {
    String[] pathSegments = { "v1/reclamations" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "listReclamations");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listReclamationsOptions != null) {
      if (listReclamationsOptions.accountId() != null) {
        builder.query("account_id", listReclamationsOptions.accountId());
      }
      if (listReclamationsOptions.resourceInstanceId() != null) {
        builder.query("resource_instance_id", listReclamationsOptions.resourceInstanceId());
      }
    }
    ResponseConverter<ReclamationsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ReclamationsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a list of all reclamations.
   *
   * Get a list of all reclamations.
   *
   * @return a {@link ServiceCall} with a result of type {@link ReclamationsList}
   */
  public ServiceCall<ReclamationsList> listReclamations() {
    return listReclamations(null);
  }

  /**
   * Perform a reclamation action.
   *
   * Reclaim (provisionally delete) a resource so that it can no longer be used, or restore a resource so that it's
   * usable again.
   *
   * @param runReclamationActionOptions the {@link RunReclamationActionOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Reclamation}
   */
  public ServiceCall<Reclamation> runReclamationAction(RunReclamationActionOptions runReclamationActionOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(runReclamationActionOptions,
      "runReclamationActionOptions cannot be null");
    String[] pathSegments = { "v1/reclamations", "actions" };
    String[] pathParameters = { runReclamationActionOptions.id(), runReclamationActionOptions.actionName() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_controller", "v2", "runReclamationAction");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (runReclamationActionOptions.requestBy() != null) {
      contentJson.addProperty("request_by", runReclamationActionOptions.requestBy());
    }
    if (runReclamationActionOptions.comment() != null) {
      contentJson.addProperty("comment", runReclamationActionOptions.comment());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Reclamation> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Reclamation>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
