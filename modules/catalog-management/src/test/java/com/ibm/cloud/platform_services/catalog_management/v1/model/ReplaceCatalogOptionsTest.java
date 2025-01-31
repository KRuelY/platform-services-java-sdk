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

import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Unit test class for the ReplaceCatalogOptions model.
 */
public class ReplaceCatalogOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceCatalogOptions() throws Throwable {
    Feature featureModel = new Feature.Builder()
      .title("testString")
      .description("testString")
      .build();
    assertEquals(featureModel.title(), "testString");
    assertEquals(featureModel.description(), "testString");

    FilterTerms filterTermsModel = new FilterTerms.Builder()
      .filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();
    assertEquals(filterTermsModel.filterTerms(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    CategoryFilter categoryFilterModel = new CategoryFilter.Builder()
      .include(true)
      .filter(filterTermsModel)
      .build();
    assertEquals(categoryFilterModel.include(), Boolean.valueOf(true));
    assertEquals(categoryFilterModel.filter(), filterTermsModel);

    IDFilter idFilterModel = new IDFilter.Builder()
      .include(filterTermsModel)
      .exclude(filterTermsModel)
      .build();
    assertEquals(idFilterModel.include(), filterTermsModel);
    assertEquals(idFilterModel.exclude(), filterTermsModel);

    Filters filtersModel = new Filters.Builder()
      .includeAll(true)
      .categoryFilters(new java.util.HashMap<String, CategoryFilter>() { { put("foo", categoryFilterModel); } })
      .idFilters(idFilterModel)
      .build();
    assertEquals(filtersModel.includeAll(), Boolean.valueOf(true));
    assertEquals(filtersModel.categoryFilters(), new java.util.HashMap<String, CategoryFilter>() { { put("foo", categoryFilterModel); } });
    assertEquals(filtersModel.idFilters(), idFilterModel);

    SyndicationCluster syndicationClusterModel = new SyndicationCluster.Builder()
      .region("testString")
      .id("testString")
      .name("testString")
      .resourceGroupName("testString")
      .type("testString")
      .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .allNamespaces(true)
      .build();
    assertEquals(syndicationClusterModel.region(), "testString");
    assertEquals(syndicationClusterModel.id(), "testString");
    assertEquals(syndicationClusterModel.name(), "testString");
    assertEquals(syndicationClusterModel.resourceGroupName(), "testString");
    assertEquals(syndicationClusterModel.type(), "testString");
    assertEquals(syndicationClusterModel.namespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(syndicationClusterModel.allNamespaces(), Boolean.valueOf(true));

    SyndicationHistory syndicationHistoryModel = new SyndicationHistory.Builder()
      .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
      .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .build();
    assertEquals(syndicationHistoryModel.namespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(syndicationHistoryModel.clusters(), new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)));
    assertEquals(syndicationHistoryModel.lastRun(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));

    SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder()
      .token("testString")
      .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .build();
    assertEquals(syndicationAuthorizationModel.token(), "testString");
    assertEquals(syndicationAuthorizationModel.lastRun(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));

    SyndicationResource syndicationResourceModel = new SyndicationResource.Builder()
      .removeRelatedComponents(true)
      .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
      .history(syndicationHistoryModel)
      .authorization(syndicationAuthorizationModel)
      .build();
    assertEquals(syndicationResourceModel.removeRelatedComponents(), Boolean.valueOf(true));
    assertEquals(syndicationResourceModel.clusters(), new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)));
    assertEquals(syndicationResourceModel.history(), syndicationHistoryModel);
    assertEquals(syndicationResourceModel.authorization(), syndicationAuthorizationModel);

    ReplaceCatalogOptions replaceCatalogOptionsModel = new ReplaceCatalogOptions.Builder()
      .catalogIdentifier("testString")
      .id("testString")
      .rev("testString")
      .label("testString")
      .shortDescription("testString")
      .catalogIconUrl("testString")
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
      .disabled(true)
      .resourceGroupId("testString")
      .owningAccount("testString")
      .catalogFilters(filtersModel)
      .syndicationSettings(syndicationResourceModel)
      .kind("testString")
      .build();
    assertEquals(replaceCatalogOptionsModel.catalogIdentifier(), "testString");
    assertEquals(replaceCatalogOptionsModel.id(), "testString");
    assertEquals(replaceCatalogOptionsModel.rev(), "testString");
    assertEquals(replaceCatalogOptionsModel.label(), "testString");
    assertEquals(replaceCatalogOptionsModel.shortDescription(), "testString");
    assertEquals(replaceCatalogOptionsModel.catalogIconUrl(), "testString");
    assertEquals(replaceCatalogOptionsModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(replaceCatalogOptionsModel.features(), new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)));
    assertEquals(replaceCatalogOptionsModel.disabled(), Boolean.valueOf(true));
    assertEquals(replaceCatalogOptionsModel.resourceGroupId(), "testString");
    assertEquals(replaceCatalogOptionsModel.owningAccount(), "testString");
    assertEquals(replaceCatalogOptionsModel.catalogFilters(), filtersModel);
    assertEquals(replaceCatalogOptionsModel.syndicationSettings(), syndicationResourceModel);
    assertEquals(replaceCatalogOptionsModel.kind(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceCatalogOptionsError() throws Throwable {
    new ReplaceCatalogOptions.Builder().build();
  }

}