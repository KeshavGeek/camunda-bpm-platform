/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.impl;

import java.io.Serializable;
import java.util.List;

import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.impl.context.Context;
import org.camunda.bpm.engine.impl.interceptor.CommandContext;
import org.camunda.bpm.engine.impl.interceptor.CommandExecutor;
import org.camunda.bpm.engine.impl.variable.VariableTypes;
import org.camunda.bpm.engine.runtime.VariableInstance;
import org.camunda.bpm.engine.runtime.VariableInstanceQuery;

/**
 * @author roman.smirnov
 */
public class VariableInstanceQueryImpl extends AbstractQuery<VariableInstanceQuery, VariableInstance> implements VariableInstanceQuery, Serializable {

  private static final long serialVersionUID = 7177849740680446490L;
  
  protected String variableName;
  protected String variableNameLike;
  protected String[] executionIds;
  protected String[] processInstanceIds;
  protected String[] taskIds;
  protected String[] activityInstanceIds;
  protected QueryVariableValue queryVariableValue;

  public VariableInstanceQueryImpl() { }
  
  public VariableInstanceQueryImpl(CommandExecutor commandExecutor) {
    super(commandExecutor);
  }

  public VariableInstanceQuery variableName(String variableName) {
    this.variableName = variableName;
    return this;
  }

  public VariableInstanceQuery variableNameLike(String variableNameLike) {
    this.variableNameLike = variableNameLike;
    return this;
  }

  public VariableInstanceQuery variableValueEquals(String variableName, Object variableValue) {
    if (variableName == null) {
      throw new ProcessEngineException("variableName is null");
    }
    if (variableValue == null) {
      throw new ProcessEngineException("variableValue is null");
    }
<<<<<<< HEAD
    
=======
>>>>>>> c32116e2a495512080f0a425448f93e42c8d7855
    this.variableName = variableName;
    queryVariableValue = new QueryVariableValue(variableName, variableValue, QueryOperator.EQUALS, true);
    return this;
  }
<<<<<<< HEAD
  
  public VariableInstanceQuery variableValueEquals(Object variableValue) {
    if (variableValue == null) {
      throw new ProcessEngineException("variableValue is null");
    }
    
    queryVariableValue = new QueryVariableValue(variableName, variableValue, QueryOperator.EQUALS, true);
    return this;
  }
=======
>>>>>>> c32116e2a495512080f0a425448f93e42c8d7855

  public VariableInstanceQuery executionIdIn(String... executionIds) {
    this.executionIds = executionIds;
    return this;
  }

  public VariableInstanceQuery processInstanceIdIn(String... processInstanceIds) {
    this.processInstanceIds = processInstanceIds;
    return this;
  }

  public VariableInstanceQuery taskIdIn(String... taskIds) {
    this.taskIds = taskIds;
    return this;
  }

  public VariableInstanceQuery activityInstanceIdIn(String... activityInstanceIds) {
    this.activityInstanceIds = activityInstanceIds;
    return this;
  }

  // ordering ////////////////////////////////////////////////////
  
  public VariableInstanceQuery orderByVariableName() {
    orderBy(VariableInstanceQueryProperty.VARIABLE_NAME);
    return this;
  }

  public VariableInstanceQuery orderByVariableType() {
    orderBy(VariableInstanceQueryProperty.VARIABLE_TYPE);
    return this;
  }

  public VariableInstanceQuery orderByActivityInstanceId() {
    orderBy(VariableInstanceQueryProperty.ACTIVITY_INSTANCE_ID);
    return this;
  }

  // results ////////////////////////////////////////////////////  
  
  protected void ensureVariablesInitialized() {
    if (this.queryVariableValue != null) {
      VariableTypes variableTypes = Context.getProcessEngineConfiguration().getVariableTypes();
      queryVariableValue.initialize(variableTypes);
    }
  }
  
  public long executeCount(CommandContext commandContext) {
    checkQueryOk();
    ensureVariablesInitialized();
    return commandContext
      .getVariableInstanceManager()
      .findVariableInstanceCountByQueryCriteria(this);
  }

  public List<VariableInstance> executeList(CommandContext commandContext, Page page) {
    checkQueryOk();
    ensureVariablesInitialized();
    return commandContext
      .getVariableInstanceManager()
      .findVariableInstanceByQueryCriteria(this, page);
  }

  // getters ////////////////////////////////////////////////////
  
  public String getVariableName() {
    return variableName;
  }

  public String getVariableNameLike() {
    return variableNameLike;
  }

  public String[] getExecutionIds() {
    return executionIds;
  }

  public String[] getProcessInstanceIds() {
    return processInstanceIds;
  }

  public String[] getTaskIds() {
    return taskIds;
  }

  public String[] getActivityInstanceIds() {
    return activityInstanceIds;
  }

  public QueryVariableValue getQueryVariableValue() {
    return queryVariableValue;
  }
  
}
