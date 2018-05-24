/*
 * DRACOON
 * REST Web Services for DRACOON<br>Version: 4.8.0-LTS  - built at: 2018-05-03 15:44:37<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a>
 *
 * OpenAPI spec version: 4.8.0-LTS
 * Contact: develop@dracoon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

/*
 * Copyright (c) 2002-2018 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * UpdateMailServerConfig
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-23T09:31:14.222+02:00")
public class UpdateMailServerConfig {
  @JsonProperty("host")
  private String host = null;

  @JsonProperty("port")
  private Integer port = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("authenticationEnabled")
  private Boolean authenticationEnabled = null;

  @JsonProperty("sslEnabled")
  private Boolean sslEnabled = null;

  @JsonProperty("starttlsEnabled")
  private Boolean starttlsEnabled = null;

  @JsonProperty("resetUsername")
  private Boolean resetUsername = null;

  @JsonProperty("resetPassword")
  private Boolean resetPassword = null;

  public UpdateMailServerConfig host(String host) {
    this.host = host;
    return this;
  }

   /**
   * Email server host
   * @return host
  **/
  @ApiModelProperty(value = "Email server host")
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public UpdateMailServerConfig port(Integer port) {
    this.port = port;
    return this;
  }

   /**
   * Email server port
   * @return port
  **/
  @ApiModelProperty(value = "Email server port")
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public UpdateMailServerConfig username(String username) {
    this.username = username;
    return this;
  }

   /**
   * User name for email server
   * @return username
  **/
  @ApiModelProperty(value = "User name for email server")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UpdateMailServerConfig password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Password for email server
   * @return password
  **/
  @ApiModelProperty(value = "Password for email server")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UpdateMailServerConfig authenticationEnabled(Boolean authenticationEnabled) {
    this.authenticationEnabled = authenticationEnabled;
    return this;
  }

   /**
   * Set &#39;true&#39; if the email server requires authentication.
   * @return authenticationEnabled
  **/
  @ApiModelProperty(example = "false", value = "Set 'true' if the email server requires authentication.")
  public Boolean getAuthenticationEnabled() {
    return authenticationEnabled;
  }

  public void setAuthenticationEnabled(Boolean authenticationEnabled) {
    this.authenticationEnabled = authenticationEnabled;
  }

  public UpdateMailServerConfig sslEnabled(Boolean sslEnabled) {
    this.sslEnabled = sslEnabled;
    return this;
  }

   /**
   * Email server requires SSL connection? Requires &#39;starttlsEnabled&#39; to be &#39;false&#39;
   * @return sslEnabled
  **/
  @ApiModelProperty(example = "false", value = "Email server requires SSL connection? Requires 'starttlsEnabled' to be 'false'")
  public Boolean getSslEnabled() {
    return sslEnabled;
  }

  public void setSslEnabled(Boolean sslEnabled) {
    this.sslEnabled = sslEnabled;
  }

  public UpdateMailServerConfig starttlsEnabled(Boolean starttlsEnabled) {
    this.starttlsEnabled = starttlsEnabled;
    return this;
  }

   /**
   * Email server requires StartTLS connection? Requires &#39;sslEnabled&#39; to be &#39;false&#39;
   * @return starttlsEnabled
  **/
  @ApiModelProperty(example = "false", value = "Email server requires StartTLS connection? Requires 'sslEnabled' to be 'false'")
  public Boolean getStarttlsEnabled() {
    return starttlsEnabled;
  }

  public void setStarttlsEnabled(Boolean starttlsEnabled) {
    this.starttlsEnabled = starttlsEnabled;
  }

  public UpdateMailServerConfig resetUsername(Boolean resetUsername) {
    this.resetUsername = resetUsername;
    return this;
  }

   /**
   * Set &#39;true&#39; to reset email server &#39;username&#39;.
   * @return resetUsername
  **/
  @ApiModelProperty(example = "false", value = "Set 'true' to reset email server 'username'.")
  public Boolean getResetUsername() {
    return resetUsername;
  }

  public void setResetUsername(Boolean resetUsername) {
    this.resetUsername = resetUsername;
  }

  public UpdateMailServerConfig resetPassword(Boolean resetPassword) {
    this.resetPassword = resetPassword;
    return this;
  }

   /**
   * Set &#39;true&#39; to reset email server &#39;password&#39;.
   * @return resetPassword
  **/
  @ApiModelProperty(example = "false", value = "Set 'true' to reset email server 'password'.")
  public Boolean getResetPassword() {
    return resetPassword;
  }

  public void setResetPassword(Boolean resetPassword) {
    this.resetPassword = resetPassword;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateMailServerConfig updateMailServerConfig = (UpdateMailServerConfig) o;
    return Objects.equals(this.host, updateMailServerConfig.host) &&
        Objects.equals(this.port, updateMailServerConfig.port) &&
        Objects.equals(this.username, updateMailServerConfig.username) &&
        Objects.equals(this.password, updateMailServerConfig.password) &&
        Objects.equals(this.authenticationEnabled, updateMailServerConfig.authenticationEnabled) &&
        Objects.equals(this.sslEnabled, updateMailServerConfig.sslEnabled) &&
        Objects.equals(this.starttlsEnabled, updateMailServerConfig.starttlsEnabled) &&
        Objects.equals(this.resetUsername, updateMailServerConfig.resetUsername) &&
        Objects.equals(this.resetPassword, updateMailServerConfig.resetPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(host, port, username, password, authenticationEnabled, sslEnabled, starttlsEnabled, resetUsername, resetPassword);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateMailServerConfig {\n");

    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    authenticationEnabled: ").append(toIndentedString(authenticationEnabled)).append("\n");
    sb.append("    sslEnabled: ").append(toIndentedString(sslEnabled)).append("\n");
    sb.append("    starttlsEnabled: ").append(toIndentedString(starttlsEnabled)).append("\n");
    sb.append("    resetUsername: ").append(toIndentedString(resetUsername)).append("\n");
    sb.append("    resetPassword: ").append(toIndentedString(resetPassword)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

