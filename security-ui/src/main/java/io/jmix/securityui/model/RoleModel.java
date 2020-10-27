/*
 * Copyright 2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.securityui.model;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;
import io.jmix.security.model.RoleType;

import javax.persistence.Id;
import java.util.*;

/**
 * Non-persistent entity used to display roles in UI
 */
@JmixEntity(name = "sec_RoleModel")
public class RoleModel {

    @Id
    @JmixGeneratedValue
    protected UUID id;

    @JmixProperty(mandatory = true)
    protected String code;

    @JmixProperty(mandatory = true)
    protected String name;

    @JmixProperty
    private String source;

    @JmixProperty
    private RoleType roleType;

    @Composition
    @JmixProperty
    private Collection<ResourcePolicyModel> resourcePolicies;

    @Composition
    @JmixProperty
    private Collection<RowLevelPolicyModel> rowLevelPolicies;

    @JmixProperty
    private Map<String, String> customProperties = new HashMap<>();

    @JmixProperty
    private Set<String> childRoles;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Collection<ResourcePolicyModel> getResourcePolicies() {
        return resourcePolicies;
    }

    public void setResourcePolicies(Collection<ResourcePolicyModel> resourcePolicies) {
        this.resourcePolicies = resourcePolicies;
    }

    public Collection<RowLevelPolicyModel> getRowLevelPolicies() {
        return rowLevelPolicies;
    }

    public void setRowLevelPolicies(Collection<RowLevelPolicyModel> rowLevelPolicies) {
        this.rowLevelPolicies = rowLevelPolicies;
    }

    public Set<String> getChildRoles() {
        return childRoles;
    }

    public void setChildRoles(Set<String> childRoles) {
        this.childRoles = childRoles;
    }

    public Map<String, String> getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(Map<String, String> customProperties) {
        this.customProperties = customProperties;
    }
}
