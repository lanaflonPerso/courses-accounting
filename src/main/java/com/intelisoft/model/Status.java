package com.intelisoft.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.intelisoft.model.enums.NotifficationStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "statuses")
public class Status extends Model {

	private static final long serialVersionUID = -1644610084060724419L;

	@Column(name = "status", nullable = false)
	private NotifficationStatus status;

	@OneToMany(mappedBy = "status")
	private List<Notiffication> notiffications = new ArrayList<Notiffication>();

}