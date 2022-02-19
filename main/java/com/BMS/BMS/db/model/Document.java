package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "tblDocuments")
public class Document {

	@Id
	@Column(name = "file_id")
	private String id;

	@Column(name = "file_filename")
	private String name;

	@Column(name = "file_type")
	private Integer type; // document = 1, photo = 2, sketch = 3, form = 4, report = 5

	@Column(name = "file_url")
	private String url;

	@Column(name = "file_parent_id")
	private String parentId;

	@Column(name = "file_saved_by")
	private String createdBy;

	@Column(name = "file_permission_level")
	private Integer permission;

	@Column(name = "file_date_created")
	private String createdDate;

	@Column(name = "file_date_updated")
	private String updatedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", id)
			.append("name", name)
			.append("type", type)
			.append("url", url)
			.append("parentId", parentId)
			.append("createdBy", createdBy)
			.append("permission", permission)
			.append("createdDate", createdDate)
			.append("updatedDate", updatedDate)
			.toString();
	}
}
