/**
 * QuantiModo
 * QuantiModo makes it easy to retrieve normalized user data from a wide array of devices and applications. [Learn about QuantiModo](https://quantimo.do), check out our [docs](https://github.com/QuantiModo/docs) or contact us at [help.quantimo.do](https://help.quantimo.do). 
 *
 * OpenAPI spec version: 2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.swagger.client.model;

import io.swagger.client.model.Variable;
import java.util.*;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Variable {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("category")
  private String category = null;
  @SerializedName("unitAbbreviatedName")
  private String unitAbbreviatedName = null;
  @SerializedName("abbreviatedUnitId")
  private Integer abbreviatedUnitId = null;
  @SerializedName("sources")
  private String sources = null;
  @SerializedName("minimumAllowedValue")
  private Double minimumAllowedValue = null;
  @SerializedName("maximumAllowedValue")
  private Double maximumAllowedValue = null;
  public enum CombinationOperationEnum {
     MEAN,  SUM, 
  };
  @SerializedName("combinationOperation")
  private CombinationOperationEnum combinationOperation = null;
  @SerializedName("fillingValue")
  private Double fillingValue = null;
  @SerializedName("joinWith")
  private String joinWith = null;
  @SerializedName("joinedVariables")
  private List<Variable> joinedVariables = null;
  @SerializedName("parent")
  private Integer parent = null;
  @SerializedName("subVariables")
  private List<Variable> subVariables = null;
  @SerializedName("onsetDelay")
  private Integer onsetDelay = null;
  @SerializedName("durationOfAction")
  private Integer durationOfAction = null;
  @SerializedName("earliestMeasurementTime")
  private Integer earliestMeasurementTime = null;
  @SerializedName("latestMeasurementTime")
  private Integer latestMeasurementTime = null;
  @SerializedName("updated")
  private Integer updated = null;
  @SerializedName("causeOnly")
  private Integer causeOnly = null;
  @SerializedName("numberOfCorrelations")
  private Integer numberOfCorrelations = null;
  @SerializedName("outcome")
  private Integer outcome = null;
  @SerializedName("rawMeasurementsAtLastAnalysis")
  private Integer rawMeasurementsAtLastAnalysis = null;
  @SerializedName("numberOfRawMeasurements")
  private Integer numberOfRawMeasurements = null;
  @SerializedName("lastUnit")
  private String lastUnit = null;
  @SerializedName("lastValue")
  private Integer lastValue = null;
  @SerializedName("mostCommonValue")
  private Integer mostCommonValue = null;
  @SerializedName("mostCommonUnit")
  private String mostCommonUnit = null;
  @SerializedName("lastSource")
  private Integer lastSource = null;
  @SerializedName("imageUrl")
  private String imageUrl = null;
  @SerializedName("ionIcon")
  private String ionIcon = null;

  /**
   * Variable ID
   **/
  @ApiModelProperty(value = "Variable ID")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * User-defined variable display name.
   **/
  @ApiModelProperty(required = true, value = "User-defined variable display name.")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Variable category like Mood, Sleep, Physical Activity, Treatment, Symptom, etc.
   **/
  @ApiModelProperty(required = true, value = "Variable category like Mood, Sleep, Physical Activity, Treatment, Symptom, etc.")
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Abbreviated name of the default unit for the variable
   **/
  @ApiModelProperty(required = true, value = "Abbreviated name of the default unit for the variable")
  public String getUnitAbbreviatedName() {
    return unitAbbreviatedName;
  }
  public void setUnitAbbreviatedName(String unitAbbreviatedName) {
    this.unitAbbreviatedName = unitAbbreviatedName;
  }

  /**
   * Id of the default unit for the variable
   **/
  @ApiModelProperty(required = true, value = "Id of the default unit for the variable")
  public Integer getAbbreviatedUnitId() {
    return abbreviatedUnitId;
  }
  public void setAbbreviatedUnitId(Integer abbreviatedUnitId) {
    this.abbreviatedUnitId = abbreviatedUnitId;
  }

  /**
   * Comma-separated list of source names to limit variables to those sources
   **/
  @ApiModelProperty(required = true, value = "Comma-separated list of source names to limit variables to those sources")
  public String getSources() {
    return sources;
  }
  public void setSources(String sources) {
    this.sources = sources;
  }

  /**
   * The minimum allowed value for measurements. While you can record a value below this minimum, it will be excluded from the correlation analysis.
   **/
  @ApiModelProperty(required = true, value = "The minimum allowed value for measurements. While you can record a value below this minimum, it will be excluded from the correlation analysis.")
  public Double getMinimumAllowedValue() {
    return minimumAllowedValue;
  }
  public void setMinimumAllowedValue(Double minimumAllowedValue) {
    this.minimumAllowedValue = minimumAllowedValue;
  }

  /**
   * The maximum allowed value for measurements. While you can record a value above this maximum, it will be excluded from the correlation analysis.
   **/
  @ApiModelProperty(required = true, value = "The maximum allowed value for measurements. While you can record a value above this maximum, it will be excluded from the correlation analysis.")
  public Double getMaximumAllowedValue() {
    return maximumAllowedValue;
  }
  public void setMaximumAllowedValue(Double maximumAllowedValue) {
    this.maximumAllowedValue = maximumAllowedValue;
  }

  /**
   * Way to aggregate measurements over time. Options are \"MEAN\" or \"SUM\". SUM should be used for things like minutes of exercise.  If you use MEAN for exercise, then a person might exercise more minutes in one day but add separate measurements that were smaller.  So when we are doing correlational analysis, we would think that the person exercised less that day even though they exercised more.  Conversely, we must use MEAN for things such as ratings which cannot be SUMMED.
   **/
  @ApiModelProperty(required = true, value = "Way to aggregate measurements over time. Options are \"MEAN\" or \"SUM\". SUM should be used for things like minutes of exercise.  If you use MEAN for exercise, then a person might exercise more minutes in one day but add separate measurements that were smaller.  So when we are doing correlational analysis, we would think that the person exercised less that day even though they exercised more.  Conversely, we must use MEAN for things such as ratings which cannot be SUMMED.")
  public CombinationOperationEnum getCombinationOperation() {
    return combinationOperation;
  }
  public void setCombinationOperation(CombinationOperationEnum combinationOperation) {
    this.combinationOperation = combinationOperation;
  }

  /**
   * When it comes to analysis to determine the effects of this variable, knowing when it did not occur is as important as knowing when it did occur. For example, if you are tracking a medication, it is important to know when you did not take it, but you do not have to log zero values for all the days when you haven't taken it. Hence, you can specify a filling value (typically 0) to insert whenever data is missing.
   **/
  @ApiModelProperty(required = true, value = "When it comes to analysis to determine the effects of this variable, knowing when it did not occur is as important as knowing when it did occur. For example, if you are tracking a medication, it is important to know when you did not take it, but you do not have to log zero values for all the days when you haven't taken it. Hence, you can specify a filling value (typically 0) to insert whenever data is missing.")
  public Double getFillingValue() {
    return fillingValue;
  }
  public void setFillingValue(Double fillingValue) {
    this.fillingValue = fillingValue;
  }

  /**
   * The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables.
   **/
  @ApiModelProperty(required = true, value = "The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables.")
  public String getJoinWith() {
    return joinWith;
  }
  public void setJoinWith(String joinWith) {
    this.joinWith = joinWith;
  }

  /**
   * Array of Variables that are joined with this Variable
   **/
  @ApiModelProperty(required = true, value = "Array of Variables that are joined with this Variable")
  public List<Variable> getJoinedVariables() {
    return joinedVariables;
  }
  public void setJoinedVariables(List<Variable> joinedVariables) {
    this.joinedVariables = joinedVariables;
  }

  /**
   * Id of the parent variable if this variable has any parent
   **/
  @ApiModelProperty(required = true, value = "Id of the parent variable if this variable has any parent")
  public Integer getParent() {
    return parent;
  }
  public void setParent(Integer parent) {
    this.parent = parent;
  }

  /**
   * Array of Variables that are sub variables to this Variable
   **/
  @ApiModelProperty(required = true, value = "Array of Variables that are sub variables to this Variable")
  public List<Variable> getSubVariables() {
    return subVariables;
  }
  public void setSubVariables(List<Variable> subVariables) {
    this.subVariables = subVariables;
  }

  /**
   * The amount of time in seconds that elapses after the predictor/stimulus event before the outcome as perceived by a self-tracker is known as the “onset delay”. For example, the “onset delay” between the time a person takes an aspirin (predictor/stimulus event) and the time a person perceives a change in their headache severity (outcome) is approximately 30 minutes.
   **/
  @ApiModelProperty(required = true, value = "The amount of time in seconds that elapses after the predictor/stimulus event before the outcome as perceived by a self-tracker is known as the “onset delay”. For example, the “onset delay” between the time a person takes an aspirin (predictor/stimulus event) and the time a person perceives a change in their headache severity (outcome) is approximately 30 minutes.")
  public Integer getOnsetDelay() {
    return onsetDelay;
  }
  public void setOnsetDelay(Integer onsetDelay) {
    this.onsetDelay = onsetDelay;
  }

  /**
   * The amount of time over which a predictor/stimulus event can exert an observable influence on an outcome variable’s value. For instance, aspirin (stimulus/predictor) typically decreases headache severity for approximately four hours (duration of action) following the onset delay.
   **/
  @ApiModelProperty(required = true, value = "The amount of time over which a predictor/stimulus event can exert an observable influence on an outcome variable’s value. For instance, aspirin (stimulus/predictor) typically decreases headache severity for approximately four hours (duration of action) following the onset delay.")
  public Integer getDurationOfAction() {
    return durationOfAction;
  }
  public void setDurationOfAction(Integer durationOfAction) {
    this.durationOfAction = durationOfAction;
  }

  /**
   * Earliest measurement time
   **/
  @ApiModelProperty(required = true, value = "Earliest measurement time")
  public Integer getEarliestMeasurementTime() {
    return earliestMeasurementTime;
  }
  public void setEarliestMeasurementTime(Integer earliestMeasurementTime) {
    this.earliestMeasurementTime = earliestMeasurementTime;
  }

  /**
   * Latest measurement time
   **/
  @ApiModelProperty(required = true, value = "Latest measurement time")
  public Integer getLatestMeasurementTime() {
    return latestMeasurementTime;
  }
  public void setLatestMeasurementTime(Integer latestMeasurementTime) {
    this.latestMeasurementTime = latestMeasurementTime;
  }

  /**
   * When this variable or its settings were last updated
   **/
  @ApiModelProperty(required = true, value = "When this variable or its settings were last updated")
  public Integer getUpdated() {
    return updated;
  }
  public void setUpdated(Integer updated) {
    this.updated = updated;
  }

  /**
   * A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user.
   **/
  @ApiModelProperty(required = true, value = "A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user.")
  public Integer getCauseOnly() {
    return causeOnly;
  }
  public void setCauseOnly(Integer causeOnly) {
    this.causeOnly = causeOnly;
  }

  /**
   * Number of correlations
   **/
  @ApiModelProperty(required = true, value = "Number of correlations")
  public Integer getNumberOfCorrelations() {
    return numberOfCorrelations;
  }
  public void setNumberOfCorrelations(Integer numberOfCorrelations) {
    this.numberOfCorrelations = numberOfCorrelations;
  }

  /**
   * Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors. These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables.
   **/
  @ApiModelProperty(required = true, value = "Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors. These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables.")
  public Integer getOutcome() {
    return outcome;
  }
  public void setOutcome(Integer outcome) {
    this.outcome = outcome;
  }

  /**
   * The number of measurements that a given user had for this variable the last time a correlation calculation was performed. Generally correlation values are only updated once the current number of measurements for a variable is more than 10% greater than the rawMeasurementsAtLastAnalysis.  This avoids a computationally-demanding recalculation when there's not enough new data to make a significant difference in the correlation.
   **/
  @ApiModelProperty(required = true, value = "The number of measurements that a given user had for this variable the last time a correlation calculation was performed. Generally correlation values are only updated once the current number of measurements for a variable is more than 10% greater than the rawMeasurementsAtLastAnalysis.  This avoids a computationally-demanding recalculation when there's not enough new data to make a significant difference in the correlation.")
  public Integer getRawMeasurementsAtLastAnalysis() {
    return rawMeasurementsAtLastAnalysis;
  }
  public void setRawMeasurementsAtLastAnalysis(Integer rawMeasurementsAtLastAnalysis) {
    this.rawMeasurementsAtLastAnalysis = rawMeasurementsAtLastAnalysis;
  }

  /**
   * Number of measurements
   **/
  @ApiModelProperty(required = true, value = "Number of measurements")
  public Integer getNumberOfRawMeasurements() {
    return numberOfRawMeasurements;
  }
  public void setNumberOfRawMeasurements(Integer numberOfRawMeasurements) {
    this.numberOfRawMeasurements = numberOfRawMeasurements;
  }

  /**
   * Last unit
   **/
  @ApiModelProperty(required = true, value = "Last unit")
  public String getLastUnit() {
    return lastUnit;
  }
  public void setLastUnit(String lastUnit) {
    this.lastUnit = lastUnit;
  }

  /**
   * Last value
   **/
  @ApiModelProperty(required = true, value = "Last value")
  public Integer getLastValue() {
    return lastValue;
  }
  public void setLastValue(Integer lastValue) {
    this.lastValue = lastValue;
  }

  /**
   * Most common value
   **/
  @ApiModelProperty(required = true, value = "Most common value")
  public Integer getMostCommonValue() {
    return mostCommonValue;
  }
  public void setMostCommonValue(Integer mostCommonValue) {
    this.mostCommonValue = mostCommonValue;
  }

  /**
   * Most common unit
   **/
  @ApiModelProperty(required = true, value = "Most common unit")
  public String getMostCommonUnit() {
    return mostCommonUnit;
  }
  public void setMostCommonUnit(String mostCommonUnit) {
    this.mostCommonUnit = mostCommonUnit;
  }

  /**
   * Last source
   **/
  @ApiModelProperty(required = true, value = "Last source")
  public Integer getLastSource() {
    return lastSource;
  }
  public void setLastSource(Integer lastSource) {
    this.lastSource = lastSource;
  }

  /**
   * 
   **/
  @ApiModelProperty(value = "")
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   * 
   **/
  @ApiModelProperty(value = "")
  public String getIonIcon() {
    return ionIcon;
  }
  public void setIonIcon(String ionIcon) {
    this.ionIcon = ionIcon;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Variable variable = (Variable) o;
    return (this.id == null ? variable.id == null : this.id.equals(variable.id)) &&
        (this.name == null ? variable.name == null : this.name.equals(variable.name)) &&
        (this.category == null ? variable.category == null : this.category.equals(variable.category)) &&
        (this.unitAbbreviatedName == null ? variable.unitAbbreviatedName == null : this.unitAbbreviatedName.equals(variable.unitAbbreviatedName)) &&
        (this.abbreviatedUnitId == null ? variable.abbreviatedUnitId == null : this.abbreviatedUnitId.equals(variable.abbreviatedUnitId)) &&
        (this.sources == null ? variable.sources == null : this.sources.equals(variable.sources)) &&
        (this.minimumAllowedValue == null ? variable.minimumAllowedValue == null : this.minimumAllowedValue.equals(variable.minimumAllowedValue)) &&
        (this.maximumAllowedValue == null ? variable.maximumAllowedValue == null : this.maximumAllowedValue.equals(variable.maximumAllowedValue)) &&
        (this.combinationOperation == null ? variable.combinationOperation == null : this.combinationOperation.equals(variable.combinationOperation)) &&
        (this.fillingValue == null ? variable.fillingValue == null : this.fillingValue.equals(variable.fillingValue)) &&
        (this.joinWith == null ? variable.joinWith == null : this.joinWith.equals(variable.joinWith)) &&
        (this.joinedVariables == null ? variable.joinedVariables == null : this.joinedVariables.equals(variable.joinedVariables)) &&
        (this.parent == null ? variable.parent == null : this.parent.equals(variable.parent)) &&
        (this.subVariables == null ? variable.subVariables == null : this.subVariables.equals(variable.subVariables)) &&
        (this.onsetDelay == null ? variable.onsetDelay == null : this.onsetDelay.equals(variable.onsetDelay)) &&
        (this.durationOfAction == null ? variable.durationOfAction == null : this.durationOfAction.equals(variable.durationOfAction)) &&
        (this.earliestMeasurementTime == null ? variable.earliestMeasurementTime == null : this.earliestMeasurementTime.equals(variable.earliestMeasurementTime)) &&
        (this.latestMeasurementTime == null ? variable.latestMeasurementTime == null : this.latestMeasurementTime.equals(variable.latestMeasurementTime)) &&
        (this.updated == null ? variable.updated == null : this.updated.equals(variable.updated)) &&
        (this.causeOnly == null ? variable.causeOnly == null : this.causeOnly.equals(variable.causeOnly)) &&
        (this.numberOfCorrelations == null ? variable.numberOfCorrelations == null : this.numberOfCorrelations.equals(variable.numberOfCorrelations)) &&
        (this.outcome == null ? variable.outcome == null : this.outcome.equals(variable.outcome)) &&
        (this.rawMeasurementsAtLastAnalysis == null ? variable.rawMeasurementsAtLastAnalysis == null : this.rawMeasurementsAtLastAnalysis.equals(variable.rawMeasurementsAtLastAnalysis)) &&
        (this.numberOfRawMeasurements == null ? variable.numberOfRawMeasurements == null : this.numberOfRawMeasurements.equals(variable.numberOfRawMeasurements)) &&
        (this.lastUnit == null ? variable.lastUnit == null : this.lastUnit.equals(variable.lastUnit)) &&
        (this.lastValue == null ? variable.lastValue == null : this.lastValue.equals(variable.lastValue)) &&
        (this.mostCommonValue == null ? variable.mostCommonValue == null : this.mostCommonValue.equals(variable.mostCommonValue)) &&
        (this.mostCommonUnit == null ? variable.mostCommonUnit == null : this.mostCommonUnit.equals(variable.mostCommonUnit)) &&
        (this.lastSource == null ? variable.lastSource == null : this.lastSource.equals(variable.lastSource)) &&
        (this.imageUrl == null ? variable.imageUrl == null : this.imageUrl.equals(variable.imageUrl)) &&
        (this.ionIcon == null ? variable.ionIcon == null : this.ionIcon.equals(variable.ionIcon));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.category == null ? 0: this.category.hashCode());
    result = 31 * result + (this.unitAbbreviatedName == null ? 0: this.unitAbbreviatedName.hashCode());
    result = 31 * result + (this.abbreviatedUnitId == null ? 0: this.abbreviatedUnitId.hashCode());
    result = 31 * result + (this.sources == null ? 0: this.sources.hashCode());
    result = 31 * result + (this.minimumAllowedValue == null ? 0: this.minimumAllowedValue.hashCode());
    result = 31 * result + (this.maximumAllowedValue == null ? 0: this.maximumAllowedValue.hashCode());
    result = 31 * result + (this.combinationOperation == null ? 0: this.combinationOperation.hashCode());
    result = 31 * result + (this.fillingValue == null ? 0: this.fillingValue.hashCode());
    result = 31 * result + (this.joinWith == null ? 0: this.joinWith.hashCode());
    result = 31 * result + (this.joinedVariables == null ? 0: this.joinedVariables.hashCode());
    result = 31 * result + (this.parent == null ? 0: this.parent.hashCode());
    result = 31 * result + (this.subVariables == null ? 0: this.subVariables.hashCode());
    result = 31 * result + (this.onsetDelay == null ? 0: this.onsetDelay.hashCode());
    result = 31 * result + (this.durationOfAction == null ? 0: this.durationOfAction.hashCode());
    result = 31 * result + (this.earliestMeasurementTime == null ? 0: this.earliestMeasurementTime.hashCode());
    result = 31 * result + (this.latestMeasurementTime == null ? 0: this.latestMeasurementTime.hashCode());
    result = 31 * result + (this.updated == null ? 0: this.updated.hashCode());
    result = 31 * result + (this.causeOnly == null ? 0: this.causeOnly.hashCode());
    result = 31 * result + (this.numberOfCorrelations == null ? 0: this.numberOfCorrelations.hashCode());
    result = 31 * result + (this.outcome == null ? 0: this.outcome.hashCode());
    result = 31 * result + (this.rawMeasurementsAtLastAnalysis == null ? 0: this.rawMeasurementsAtLastAnalysis.hashCode());
    result = 31 * result + (this.numberOfRawMeasurements == null ? 0: this.numberOfRawMeasurements.hashCode());
    result = 31 * result + (this.lastUnit == null ? 0: this.lastUnit.hashCode());
    result = 31 * result + (this.lastValue == null ? 0: this.lastValue.hashCode());
    result = 31 * result + (this.mostCommonValue == null ? 0: this.mostCommonValue.hashCode());
    result = 31 * result + (this.mostCommonUnit == null ? 0: this.mostCommonUnit.hashCode());
    result = 31 * result + (this.lastSource == null ? 0: this.lastSource.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    result = 31 * result + (this.ionIcon == null ? 0: this.ionIcon.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Variable {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  category: ").append(category).append("\n");
    sb.append("  unitAbbreviatedName: ").append(unitAbbreviatedName).append("\n");
    sb.append("  abbreviatedUnitId: ").append(abbreviatedUnitId).append("\n");
    sb.append("  sources: ").append(sources).append("\n");
    sb.append("  minimumAllowedValue: ").append(minimumAllowedValue).append("\n");
    sb.append("  maximumAllowedValue: ").append(maximumAllowedValue).append("\n");
    sb.append("  combinationOperation: ").append(combinationOperation).append("\n");
    sb.append("  fillingValue: ").append(fillingValue).append("\n");
    sb.append("  joinWith: ").append(joinWith).append("\n");
    sb.append("  joinedVariables: ").append(joinedVariables).append("\n");
    sb.append("  parent: ").append(parent).append("\n");
    sb.append("  subVariables: ").append(subVariables).append("\n");
    sb.append("  onsetDelay: ").append(onsetDelay).append("\n");
    sb.append("  durationOfAction: ").append(durationOfAction).append("\n");
    sb.append("  earliestMeasurementTime: ").append(earliestMeasurementTime).append("\n");
    sb.append("  latestMeasurementTime: ").append(latestMeasurementTime).append("\n");
    sb.append("  updated: ").append(updated).append("\n");
    sb.append("  causeOnly: ").append(causeOnly).append("\n");
    sb.append("  numberOfCorrelations: ").append(numberOfCorrelations).append("\n");
    sb.append("  outcome: ").append(outcome).append("\n");
    sb.append("  rawMeasurementsAtLastAnalysis: ").append(rawMeasurementsAtLastAnalysis).append("\n");
    sb.append("  numberOfRawMeasurements: ").append(numberOfRawMeasurements).append("\n");
    sb.append("  lastUnit: ").append(lastUnit).append("\n");
    sb.append("  lastValue: ").append(lastValue).append("\n");
    sb.append("  mostCommonValue: ").append(mostCommonValue).append("\n");
    sb.append("  mostCommonUnit: ").append(mostCommonUnit).append("\n");
    sb.append("  lastSource: ").append(lastSource).append("\n");
    sb.append("  imageUrl: ").append(imageUrl).append("\n");
    sb.append("  ionIcon: ").append(ionIcon).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
