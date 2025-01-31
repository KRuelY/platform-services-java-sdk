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

package com.ibm.cloud.platform_services.usage_reports.v4.model;

import com.ibm.cloud.platform_services.usage_reports.v4.model.AccountSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Offer;
import com.ibm.cloud.platform_services.usage_reports.v4.model.OfferCredits;
import com.ibm.cloud.platform_services.usage_reports.v4.model.ResourcesSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Subscription;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SubscriptionSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SubscriptionTerm;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SubscriptionTermCredits;
import com.ibm.cloud.platform_services.usage_reports.v4.model.SupportSummary;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AccountSummary model.
 */
public class AccountSummaryTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAccountSummary() throws Throwable {
    AccountSummary accountSummaryModel = new AccountSummary();
    assertNull(accountSummaryModel.getAccountId());
    assertNull(accountSummaryModel.getBillingMonth());
    assertNull(accountSummaryModel.getBillingCountryCode());
    assertNull(accountSummaryModel.getBillingCurrencyCode());
    assertNull(accountSummaryModel.getResources());
    assertNull(accountSummaryModel.getOffers());
    assertNull(accountSummaryModel.getSupport());
    assertNull(accountSummaryModel.getSubscription());
  }
}