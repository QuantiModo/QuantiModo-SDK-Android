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

import io.swagger.client.model.HumanTime;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Measurement {
  
  @SerializedName("variableName")
  private String variableName = null;
  @SerializedName("sourceName")
  private String sourceName = null;
  @SerializedName("startTimeString")
  private String startTimeString = null;
  @SerializedName("startTimeEpoch")
  private Integer startTimeEpoch = null;
  @SerializedName("humanTime")
  private HumanTime humanTime = null;
  @SerializedName("value")
  private Double value = null;
  @SerializedName("originalValue")
  private Integer originalValue = null;
  @SerializedName("originalunitAbbreviatedName")
  private String originalunitAbbreviatedName = null;
  @SerializedName("unitAbbreviatedName")
  private String unitAbbreviatedName = null;
  @SerializedName("note")
  private String note = null;

  /**
   * Name of the variable for which we are creating the measurement records
   **/
  @ApiModelProperty(required = true, value = "Name of the variable for which we are creating the measurement records")
  public String getVariableName() {
    return variableName;
  }
  public void setVariableName(String variableName) {
    this.variableName = variableName;
  }

  /**
   * Application or device used to record the measurement values
   **/
  @ApiModelProperty(required = true, value = "Application or device used to record the measurement values")
  public String getSourceName() {
    return sourceName;
  }
  public void setSourceName(String sourceName) {
    this.sourceName = sourceName;
  }

  /**
   * Start Time for the measurement event in UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"
   **/
  @ApiModelProperty(required = true, value = "Start Time for the measurement event in UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"")
  public String getStartTimeString() {
    return startTimeString;
  }
  public void setStartTimeString(String startTimeString) {
    this.startTimeString = startTimeString;
  }

  /**
   * Seconds between the start of the event measured and 1970 (Unix timestamp)
   **/
  @ApiModelProperty(value = "Seconds between the start of the event measured and 1970 (Unix timestamp)")
  public Integer getStartTimeEpoch() {
    return startTimeEpoch;
  }
  public void setStartTimeEpoch(Integer startTimeEpoch) {
    this.startTimeEpoch = startTimeEpoch;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public HumanTime getHumanTime() {
    return humanTime;
  }
  public void setHumanTime(HumanTime humanTime) {
    this.humanTime = humanTime;
  }

  /**
   * Converted measurement value in requested unit
   **/
  @ApiModelProperty(required = true, value = "Converted measurement value in requested unit")
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
  }

  /**
   * Original value as originally submitted
   **/
  @ApiModelProperty(value = "Original value as originally submitted")
  public Integer getOriginalValue() {
    return originalValue;
  }
  public void setOriginalValue(Integer originalValue) {
    this.originalValue = originalValue;
  }

  /**
   * Original Unit of measurement as originally submitted
   **/
  @ApiModelProperty(value = "Original Unit of measurement as originally submitted")
  public String getOriginalunitAbbreviatedName() {
    return originalunitAbbreviatedName;
  }
  public void setOriginalunitAbbreviatedName(String originalunitAbbreviatedName) {
    this.originalunitAbbreviatedName = originalunitAbbreviatedName;
  }

  /**
   * Abbreviated name for the unit of measurement
   **/
  @ApiModelProperty(required = true, value = "Abbreviated name for the unit of measurement")
  public String getUnitAbbreviatedName() {
    return unitAbbreviatedName;
  }
  public void setUnitAbbreviatedName(String unitAbbreviatedName) {
    this.unitAbbreviatedName = unitAbbreviatedName;
  }

  /**
   * Note of measurement
   **/
  @ApiModelProperty(value = "Note of measurement")
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Measurement measurement = (Measurement) o;
    return (this.variableName == null ? measurement.variableName == null : this.variableName.equals(measurement.variableName)) &&
        (this.sourceName == null ? measurement.sourceName == null : this.sourceName.equals(measurement.sourceName)) &&
        (this.startTimeString == null ? measurement.startTimeString == null : this.startTimeString.equals(measurement.startTimeString)) &&
        (this.startTimeEpoch == null ? measurement.startTimeEpoch == null : this.startTimeEpoch.equals(measurement.startTimeEpoch)) &&
        (this.humanTime == null ? measurement.humanTime == null : this.humanTime.equals(measurement.humanTime)) &&
        (this.value == null ? measurement.value == null : this.value.equals(measurement.value)) &&
        (this.originalValue == null ? measurement.originalValue == null : this.originalValue.equals(measurement.originalValue)) &&
        (this.originalunitAbbreviatedName == null ? measurement.originalunitAbbreviatedName == null : this.originalunitAbbreviatedName.equals(measurement.originalunitAbbreviatedName)) &&
        (this.unitAbbreviatedName == null ? measurement.unitAbbreviatedName == null : this.unitAbbreviatedName.equals(measurement.unitAbbreviatedName)) &&
        (this.note == null ? measurement.note == null : this.note.equals(measurement.note));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.variableName == null ? 0: this.variableName.hashCode());
    result = 31 * result + (this.sourceName == null ? 0: this.sourceName.hashCode());
    result = 31 * result + (this.startTimeString == null ? 0: this.startTimeString.hashCode());
    result = 31 * result + (this.startTimeEpoch == null ? 0: this.startTimeEpoch.hashCode());
    result = 31 * result + (this.humanTime == null ? 0: this.humanTime.hashCode());
    result = 31 * result + (this.value == null ? 0: this.value.hashCode());
    result = 31 * result + (this.originalValue == null ? 0: this.originalValue.hashCode());
    result = 31 * result + (this.originalunitAbbreviatedName == null ? 0: this.originalunitAbbreviatedName.hashCode());
    result = 31 * result + (this.unitAbbreviatedName == null ? 0: this.unitAbbreviatedName.hashCode());
    result = 31 * result + (this.note == null ? 0: this.note.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Measurement {\n");
    
    sb.append("  variableName: ").append(variableName).append("\n");
    sb.append("  sourceName: ").append(sourceName).append("\n");
    sb.append("  startTimeString: ").append(startTimeString).append("\n");
    sb.append("  startTimeEpoch: ").append(startTimeEpoch).append("\n");
    sb.append("  humanTime: ").append(humanTime).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("  originalValue: ").append(originalValue).append("\n");
    sb.append("  originalunitAbbreviatedName: ").append(originalunitAbbreviatedName).append("\n");
    sb.append("  unitAbbreviatedName: ").append(unitAbbreviatedName).append("\n");
    sb.append("  note: ").append(note).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
