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

import java.util.Date;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class TrackingReminder {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("clientId")
  private String clientId = null;
  @SerializedName("userId")
  private Integer userId = null;
  @SerializedName("variableId")
  private Integer variableId = null;
  @SerializedName("defaultValue")
  private Float defaultValue = null;
  @SerializedName("reminderStartTime")
  private String reminderStartTime = null;
  @SerializedName("reminderEndTime")
  private String reminderEndTime = null;
  @SerializedName("reminderSound")
  private String reminderSound = null;
  @SerializedName("reminderFrequency")
  private Integer reminderFrequency = null;
  @SerializedName("popUp")
  private Boolean popUp = null;
  @SerializedName("sms")
  private Boolean sms = null;
  @SerializedName("email")
  private Boolean email = null;
  @SerializedName("notificationBar")
  private Boolean notificationBar = null;
  @SerializedName("latestTrackingReminderNotificationReminderTime")
  private Date latestTrackingReminderNotificationReminderTime = null;
  @SerializedName("lastTracked")
  private Date lastTracked = null;
  @SerializedName("startTrackingDate")
  private String startTrackingDate = null;
  @SerializedName("stopTrackingDate")
  private String stopTrackingDate = null;
  @SerializedName("updatedAt")
  private Date updatedAt = null;
  @SerializedName("variableName")
  private String variableName = null;
  @SerializedName("variableCategoryName")
  private String variableCategoryName = null;
  @SerializedName("unitAbbreviatedName")
  private String unitAbbreviatedName = null;
  public enum CombinationOperationEnum {
     MEAN,  SUM, 
  };
  @SerializedName("combinationOperation")
  private CombinationOperationEnum combinationOperation = null;

  /**
   * id
   **/
  @ApiModelProperty(value = "id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * clientId
   **/
  @ApiModelProperty(value = "clientId")
  public String getClientId() {
    return clientId;
  }
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  /**
   * ID of User
   **/
  @ApiModelProperty(value = "ID of User")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * Id for the variable to be tracked
   **/
  @ApiModelProperty(required = true, value = "Id for the variable to be tracked")
  public Integer getVariableId() {
    return variableId;
  }
  public void setVariableId(Integer variableId) {
    this.variableId = variableId;
  }

  /**
   * Default value to use for the measurement when tracking
   **/
  @ApiModelProperty(required = true, value = "Default value to use for the measurement when tracking")
  public Float getDefaultValue() {
    return defaultValue;
  }
  public void setDefaultValue(Float defaultValue) {
    this.defaultValue = defaultValue;
  }

  /**
   * Earliest time of day at which reminders should appear in UTC HH:MM:SS format
   **/
  @ApiModelProperty(value = "Earliest time of day at which reminders should appear in UTC HH:MM:SS format")
  public String getReminderStartTime() {
    return reminderStartTime;
  }
  public void setReminderStartTime(String reminderStartTime) {
    this.reminderStartTime = reminderStartTime;
  }

  /**
   * Latest time of day at which reminders should appear in UTC HH:MM:SS format
   **/
  @ApiModelProperty(value = "Latest time of day at which reminders should appear in UTC HH:MM:SS format")
  public String getReminderEndTime() {
    return reminderEndTime;
  }
  public void setReminderEndTime(String reminderEndTime) {
    this.reminderEndTime = reminderEndTime;
  }

  /**
   * String identifier for the sound to accompany the reminder
   **/
  @ApiModelProperty(value = "String identifier for the sound to accompany the reminder")
  public String getReminderSound() {
    return reminderSound;
  }
  public void setReminderSound(String reminderSound) {
    this.reminderSound = reminderSound;
  }

  /**
   * Number of seconds between one reminder and the next
   **/
  @ApiModelProperty(required = true, value = "Number of seconds between one reminder and the next")
  public Integer getReminderFrequency() {
    return reminderFrequency;
  }
  public void setReminderFrequency(Integer reminderFrequency) {
    this.reminderFrequency = reminderFrequency;
  }

  /**
   * True if the reminders should appear as a popup notification
   **/
  @ApiModelProperty(value = "True if the reminders should appear as a popup notification")
  public Boolean getPopUp() {
    return popUp;
  }
  public void setPopUp(Boolean popUp) {
    this.popUp = popUp;
  }

  /**
   * True if the reminders should be delivered via SMS
   **/
  @ApiModelProperty(value = "True if the reminders should be delivered via SMS")
  public Boolean getSms() {
    return sms;
  }
  public void setSms(Boolean sms) {
    this.sms = sms;
  }

  /**
   * True if the reminders should be delivered via email
   **/
  @ApiModelProperty(value = "True if the reminders should be delivered via email")
  public Boolean getEmail() {
    return email;
  }
  public void setEmail(Boolean email) {
    this.email = email;
  }

  /**
   * True if the reminders should appear in the notification bar
   **/
  @ApiModelProperty(value = "True if the reminders should appear in the notification bar")
  public Boolean getNotificationBar() {
    return notificationBar;
  }
  public void setNotificationBar(Boolean notificationBar) {
    this.notificationBar = notificationBar;
  }

  /**
   * UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"  timestamp for the reminder time of the latest tracking reminder notification that has been pre-emptively generated in the database
   **/
  @ApiModelProperty(value = "UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"  timestamp for the reminder time of the latest tracking reminder notification that has been pre-emptively generated in the database")
  public Date getLatestTrackingReminderNotificationReminderTime() {
    return latestTrackingReminderNotificationReminderTime;
  }
  public void setLatestTrackingReminderNotificationReminderTime(Date latestTrackingReminderNotificationReminderTime) {
    this.latestTrackingReminderNotificationReminderTime = latestTrackingReminderNotificationReminderTime;
  }

  /**
   * UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"  timestamp for the last time a measurement was received for this user and variable
   **/
  @ApiModelProperty(value = "UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"  timestamp for the last time a measurement was received for this user and variable")
  public Date getLastTracked() {
    return lastTracked;
  }
  public void setLastTracked(Date lastTracked) {
    this.lastTracked = lastTracked;
  }

  /**
   * Earliest date on which the user should be reminded to track in YYYY-MM-DD format
   **/
  @ApiModelProperty(value = "Earliest date on which the user should be reminded to track in YYYY-MM-DD format")
  public String getStartTrackingDate() {
    return startTrackingDate;
  }
  public void setStartTrackingDate(String startTrackingDate) {
    this.startTrackingDate = startTrackingDate;
  }

  /**
   * Latest date on which the user should be reminded to track in YYYY-MM-DD format
   **/
  @ApiModelProperty(value = "Latest date on which the user should be reminded to track in YYYY-MM-DD format")
  public String getStopTrackingDate() {
    return stopTrackingDate;
  }
  public void setStopTrackingDate(String stopTrackingDate) {
    this.stopTrackingDate = stopTrackingDate;
  }

  /**
   * When the record in the database was last updated. Use UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"  datetime format. Time zone should be UTC and not local.
   **/
  @ApiModelProperty(value = "When the record in the database was last updated. Use UTC ISO 8601 \"YYYY-MM-DDThh:mm:ss\"  datetime format. Time zone should be UTC and not local.")
  public Date getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * Name of the variable to be used when sending measurements
   **/
  @ApiModelProperty(value = "Name of the variable to be used when sending measurements")
  public String getVariableName() {
    return variableName;
  }
  public void setVariableName(String variableName) {
    this.variableName = variableName;
  }

  /**
   * Name of the variable category to be used when sending measurements
   **/
  @ApiModelProperty(value = "Name of the variable category to be used when sending measurements")
  public String getVariableCategoryName() {
    return variableCategoryName;
  }
  public void setVariableCategoryName(String variableCategoryName) {
    this.variableCategoryName = variableCategoryName;
  }

  /**
   * Abbreviated name of the unit to be used when sending measurements
   **/
  @ApiModelProperty(value = "Abbreviated name of the unit to be used when sending measurements")
  public String getUnitAbbreviatedName() {
    return unitAbbreviatedName;
  }
  public void setUnitAbbreviatedName(String unitAbbreviatedName) {
    this.unitAbbreviatedName = unitAbbreviatedName;
  }

  /**
   * The way multiple measurements are aggregated over time
   **/
  @ApiModelProperty(value = "The way multiple measurements are aggregated over time")
  public CombinationOperationEnum getCombinationOperation() {
    return combinationOperation;
  }
  public void setCombinationOperation(CombinationOperationEnum combinationOperation) {
    this.combinationOperation = combinationOperation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrackingReminder trackingReminder = (TrackingReminder) o;
    return (this.id == null ? trackingReminder.id == null : this.id.equals(trackingReminder.id)) &&
        (this.clientId == null ? trackingReminder.clientId == null : this.clientId.equals(trackingReminder.clientId)) &&
        (this.userId == null ? trackingReminder.userId == null : this.userId.equals(trackingReminder.userId)) &&
        (this.variableId == null ? trackingReminder.variableId == null : this.variableId.equals(trackingReminder.variableId)) &&
        (this.defaultValue == null ? trackingReminder.defaultValue == null : this.defaultValue.equals(trackingReminder.defaultValue)) &&
        (this.reminderStartTime == null ? trackingReminder.reminderStartTime == null : this.reminderStartTime.equals(trackingReminder.reminderStartTime)) &&
        (this.reminderEndTime == null ? trackingReminder.reminderEndTime == null : this.reminderEndTime.equals(trackingReminder.reminderEndTime)) &&
        (this.reminderSound == null ? trackingReminder.reminderSound == null : this.reminderSound.equals(trackingReminder.reminderSound)) &&
        (this.reminderFrequency == null ? trackingReminder.reminderFrequency == null : this.reminderFrequency.equals(trackingReminder.reminderFrequency)) &&
        (this.popUp == null ? trackingReminder.popUp == null : this.popUp.equals(trackingReminder.popUp)) &&
        (this.sms == null ? trackingReminder.sms == null : this.sms.equals(trackingReminder.sms)) &&
        (this.email == null ? trackingReminder.email == null : this.email.equals(trackingReminder.email)) &&
        (this.notificationBar == null ? trackingReminder.notificationBar == null : this.notificationBar.equals(trackingReminder.notificationBar)) &&
        (this.latestTrackingReminderNotificationReminderTime == null ? trackingReminder.latestTrackingReminderNotificationReminderTime == null : this.latestTrackingReminderNotificationReminderTime.equals(trackingReminder.latestTrackingReminderNotificationReminderTime)) &&
        (this.lastTracked == null ? trackingReminder.lastTracked == null : this.lastTracked.equals(trackingReminder.lastTracked)) &&
        (this.startTrackingDate == null ? trackingReminder.startTrackingDate == null : this.startTrackingDate.equals(trackingReminder.startTrackingDate)) &&
        (this.stopTrackingDate == null ? trackingReminder.stopTrackingDate == null : this.stopTrackingDate.equals(trackingReminder.stopTrackingDate)) &&
        (this.updatedAt == null ? trackingReminder.updatedAt == null : this.updatedAt.equals(trackingReminder.updatedAt)) &&
        (this.variableName == null ? trackingReminder.variableName == null : this.variableName.equals(trackingReminder.variableName)) &&
        (this.variableCategoryName == null ? trackingReminder.variableCategoryName == null : this.variableCategoryName.equals(trackingReminder.variableCategoryName)) &&
        (this.unitAbbreviatedName == null ? trackingReminder.unitAbbreviatedName == null : this.unitAbbreviatedName.equals(trackingReminder.unitAbbreviatedName)) &&
        (this.combinationOperation == null ? trackingReminder.combinationOperation == null : this.combinationOperation.equals(trackingReminder.combinationOperation));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.clientId == null ? 0: this.clientId.hashCode());
    result = 31 * result + (this.userId == null ? 0: this.userId.hashCode());
    result = 31 * result + (this.variableId == null ? 0: this.variableId.hashCode());
    result = 31 * result + (this.defaultValue == null ? 0: this.defaultValue.hashCode());
    result = 31 * result + (this.reminderStartTime == null ? 0: this.reminderStartTime.hashCode());
    result = 31 * result + (this.reminderEndTime == null ? 0: this.reminderEndTime.hashCode());
    result = 31 * result + (this.reminderSound == null ? 0: this.reminderSound.hashCode());
    result = 31 * result + (this.reminderFrequency == null ? 0: this.reminderFrequency.hashCode());
    result = 31 * result + (this.popUp == null ? 0: this.popUp.hashCode());
    result = 31 * result + (this.sms == null ? 0: this.sms.hashCode());
    result = 31 * result + (this.email == null ? 0: this.email.hashCode());
    result = 31 * result + (this.notificationBar == null ? 0: this.notificationBar.hashCode());
    result = 31 * result + (this.latestTrackingReminderNotificationReminderTime == null ? 0: this.latestTrackingReminderNotificationReminderTime.hashCode());
    result = 31 * result + (this.lastTracked == null ? 0: this.lastTracked.hashCode());
    result = 31 * result + (this.startTrackingDate == null ? 0: this.startTrackingDate.hashCode());
    result = 31 * result + (this.stopTrackingDate == null ? 0: this.stopTrackingDate.hashCode());
    result = 31 * result + (this.updatedAt == null ? 0: this.updatedAt.hashCode());
    result = 31 * result + (this.variableName == null ? 0: this.variableName.hashCode());
    result = 31 * result + (this.variableCategoryName == null ? 0: this.variableCategoryName.hashCode());
    result = 31 * result + (this.unitAbbreviatedName == null ? 0: this.unitAbbreviatedName.hashCode());
    result = 31 * result + (this.combinationOperation == null ? 0: this.combinationOperation.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrackingReminder {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  clientId: ").append(clientId).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  variableId: ").append(variableId).append("\n");
    sb.append("  defaultValue: ").append(defaultValue).append("\n");
    sb.append("  reminderStartTime: ").append(reminderStartTime).append("\n");
    sb.append("  reminderEndTime: ").append(reminderEndTime).append("\n");
    sb.append("  reminderSound: ").append(reminderSound).append("\n");
    sb.append("  reminderFrequency: ").append(reminderFrequency).append("\n");
    sb.append("  popUp: ").append(popUp).append("\n");
    sb.append("  sms: ").append(sms).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  notificationBar: ").append(notificationBar).append("\n");
    sb.append("  latestTrackingReminderNotificationReminderTime: ").append(latestTrackingReminderNotificationReminderTime).append("\n");
    sb.append("  lastTracked: ").append(lastTracked).append("\n");
    sb.append("  startTrackingDate: ").append(startTrackingDate).append("\n");
    sb.append("  stopTrackingDate: ").append(stopTrackingDate).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("  variableName: ").append(variableName).append("\n");
    sb.append("  variableCategoryName: ").append(variableCategoryName).append("\n");
    sb.append("  unitAbbreviatedName: ").append(unitAbbreviatedName).append("\n");
    sb.append("  combinationOperation: ").append(combinationOperation).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
