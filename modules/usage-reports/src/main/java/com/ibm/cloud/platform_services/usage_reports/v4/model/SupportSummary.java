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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * SupportSummary.
 */
public class SupportSummary extends GenericModel {

  protected Double cost;
  protected String type;
  protected Double overage;

  /**
   * Gets the cost.
   *
   * The monthly support cost.
   *
   * @return the cost
   */
  public Double getCost() {
    return cost;
  }

  /**
   * Gets the type.
   *
   * The type of support.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the overage.
   *
   * Additional support cost for the month.
   *
   * @return the overage
   */
  public Double getOverage() {
    return overage;
  }
}

