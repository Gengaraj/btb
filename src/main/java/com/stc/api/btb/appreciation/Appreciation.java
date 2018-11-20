package com.stc.api.btb.appreciation;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stc.api.btb.user.User;


@Entity()
@Table(name = "EMP_APRCTN")
public class Appreciation {
	
	
	public Appreciation() {
		// TODO Auto-generated constructor stub
	}

	// APPRECIATION_ID` bigint(15) NOT NULL AUTO_INCREMENT COMMENT 'This is an
	// unique identifier for the appreaciations\\n',
	@Id
	@Column(name = "APPRECIATION_ID", length = 15)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	private Integer appreciationId;
	
	//`APPRECIATION_TITLE` varchar(150) NOT NULL DEFAULT '',
	@Column(name = "APPRECIATION_TITLE", nullable = false, length = 150)
	private String appreciationTitle;

	// `APPRECIATION_NOTE` varchar(3000) NOT NULL COMMENT 'This is a place
	// holder for the appreciation note given\n',
	@Column(name = "APPRECIATION_NOTE", nullable = false, length = 3000)
	private String appreciationNote;

	// `APPRECIATION_STATUS` varchar(1) DEFAULT NULL COMMENT 'This is a
	// placeholder to refer the status of the appreciation, A is Approved, I is
	// inactive, P - Pending Approval. This will be used when the appreciation is deleted from the UI.
	// When user deletes the appreciation, it will be soft deleted(marked as
	// I)\n',
	@Column(name = "APPRECIATION_STATUS", nullable = false, length = 1)
	private char appreciationStatus;

	// `GIVEN_TO` bigint(15) NOT NULL COMMENT 'This is a placeholder column for
	// user id who is receiving the appreciation\n',
	@ManyToOne(targetEntity=User.class,optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name="GIVEN_TO",referencedColumnName="id")
	private User givenTo;
	
	// `GIVEN_BY` bigint(15) NOT NULL COMMENT 'This is place holder for the user
	// id who submitted the appreciation',
	@ManyToOne(targetEntity=User.class,optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name="GIVEN_BY",referencedColumnName="id")
	private User givenBy;

	// `CREATED_TIMESTAMP` datetime NOT NULL COMMENT 'This is a placeholder to
	// hold the appreciation created time.',
	@Column(name = "CREATED_TIMESTAMP", nullable = false)
	private Timestamp createdTimeStamp;

	// `UPDATED_BY` bigint(15) NOT NULL,
	@Column(name = "UPDATED_BY", nullable = false)
	private Integer updatedBy;

	// `UPDATED_TIMESTAMP` datetime NOT NULL COMMENT 'This is a placeholder to
	// hold the appreciation updated time.',
	@Column(name = "UPDATED_TIMESTAMP", nullable = false)
	private Timestamp updatedTimeStamp;

	// `APPROVED_BY` bigint(15) DEFAULT NULL COMMENT 'This is a placeholder to
	// hold the appreciation approver.',
	@Column(name = "APPROVED_BY")
	private Integer approvedBy;

	// `APPROVED_DATE` datetime DEFAULT NULL COMMENT 'This is a placeholder to
	// hold the appreciation approved date.',
	@Column(name = "APPROVED_DATE")
	private Timestamp approvedDate;

	// `PUBLISHED_BY` bigint(15) DEFAULT NULL COMMENT 'This is a placeholder to
	// contain the user id who is publishing the note.',
	@Column(name = "PUBLISHED_BY")
	private Integer publishedBy;

	// `PUBLISHED_DATE` datetime DEFAULT NULL COMMENT 'This is placeholder
	// column to hold the time of publishing the appreciation\n',
	@Column(name = "PUBLISHED_DATE")
	private Timestamp publishedDate;
	
	// `DELETED_BY` bigint(15) DEFAULT NULL,
	@Column(name = "DELETED_BY")
	private Integer deletedBy;

	// `DELETED_TIMESTAMP` datetime DEFAULT NULL COMMENT 'This is a placeholder
	// to hold the appreciation deleted date.',
	@Column(name = "DELETED_TIMESTAMP")
	private Timestamp deletedTimeStamp;

	public Integer getAppreciationId() {
		return appreciationId;
	}

	public void setAppreciationId(Integer appreciationId) {
		this.appreciationId = appreciationId;
	}

	public String getAppreciationTitle() {
		return appreciationTitle;
	}

	public void setAppreciationTitle(String appreciationTitle) {
		this.appreciationTitle = appreciationTitle;
	}

	public String getAppreciationNote() {
		return appreciationNote;
	}

	public void setAppreciationNote(String appreciationNote) {
		this.appreciationNote = appreciationNote;
	}

	public char getAppreciationStatus() {
		return appreciationStatus;
	}

	public void setAppreciationStatus(char appreciationStatus) {
		this.appreciationStatus = appreciationStatus;
	}

	public User getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(User givenBy) {
		this.givenBy = givenBy;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(Timestamp updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public Integer getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Timestamp getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Timestamp approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Integer getPublishedBy() {
		return publishedBy;
	}

	public void setPublishedBy(Integer publishedBy) {
		this.publishedBy = publishedBy;
	}

	public Timestamp getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Timestamp publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Integer getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Timestamp getDeletedTimeStamp() {
		return deletedTimeStamp;
	}

	public void setDeletedTimeStamp(Timestamp deletedTimeStamp) {
		this.deletedTimeStamp = deletedTimeStamp;
	}

	public User getGivenTo() {
		return givenTo;
	}

	public void setGivenTo(User givenTo) {
		this.givenTo = givenTo;
	}
	

}
